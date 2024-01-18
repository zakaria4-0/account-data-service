package net.kerouad.accountdataservice.web;


import net.devh.boot.grpc.client.inject.GrpcClient;
import net.kerouad.accountdataservice.feign.CustomerRestClient;
import net.kerouad.accountdataservice.mapper.CustomerMapper;
import net.kerouad.accountdataservice.model.Customer;
import net.kerouad.customerdataservice.stub.CustomerServiceGrpc;
import net.kerouad.customerdataservice.stub.CustomerServiceOuterClass;
import net.kerouad.customerdataservice.web.CustomerSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account-service")
public class AccountRestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private CustomerSoapService customerSoapService;
    @Autowired
    private CustomerMapper customerMapper;
    @GrpcClient(value = "customerService")
    private CustomerServiceGrpc.CustomerServiceBlockingStub customerServiceBlockingStub;

    /**
     * Rest Client
     */

    //Rest Client ->  programmative en utilisant restTemplate
    @GetMapping ("/save")
    public HttpStatusCode saveCustomer() {
        Customer customer = new Customer(null, "sanae", "sanae@gmail.com");
      /*
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer, headers);*/
        ResponseEntity<Customer> customerResponseEntity = restTemplate.postForEntity("http://localhost:8080/save", customer, Customer.class);
        return customerResponseEntity.getStatusCode();
    }
    @GetMapping("/customers")
    public List<Customer> listCustomers(){
        Customer[] customers = restTemplate.getForObject("http://localhost:8080/customers", Customer[].class);
        return List.of(customers);
    }

    //Rest Client ->  version RestTemplate
    @GetMapping("/customer/{id}")
    public Customer customerById(@PathVariable Long id){
        Customer customer = restTemplate.getForObject("http://localhost:8080/customer/" + id, Customer.class);
        return customer;
    }

    // Rest Client -> version WebClient
    @GetMapping ("/save/v2")
    public void saveCustomerV2() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        Customer customer = new Customer(null, "sanae", "sanae@gmail.com");
        webClient.post().uri("/save", customer);
    }
    @GetMapping("/customer/v2/{id}")
    public Mono<Customer> customerByIdV2(@PathVariable Long id){
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        Mono<Customer> customerMono = webClient.get()
                .uri("/customer/{id}", id)
                .retrieve().bodyToMono(Customer.class);
        return customerMono;
    }

    //Rest Client ->  version OpenFeign
    @GetMapping ("/save/v3")
    public void saveCustomerV3() {
        Customer customer = new Customer(null, "sanae", "sanae@gmail.com");
        customerRestClient.saveCustomer(customer);
    }
    @GetMapping("/customer/v3/{id}")
    public Customer customerByIdV3(@PathVariable Long id){
        return customerRestClient.getCustomerById(id);
    }

    //Rest Client -> programmative en utilisant WebClient
    @GetMapping("/customers/v2")
    public Flux<Customer> listCustomerV2(){
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        Flux<Customer> customerFlux = webClient.get()
                .uri("/customers")
                .retrieve().
                bodyToFlux(Customer.class);
        return customerFlux;
    }

    // Rest Client -> déclarative en utilisant OpenFeign
    @GetMapping("/customers/V3")
    public List<Customer> listCustomersV3(){
        return customerRestClient.getCustomers();
    }

    /*--------------------------------------------------------------------------------------------------------*/

    /** GraphQl Client */

    @GetMapping("/gql/saveCustomer")
    public void saveCustomerGql(){
        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder()
                .url("http://localhost:8080/graphql")
                .build();
        var httpRequestDocument= """
                mutation {
                    saveCustomer(customer: {
                      name: "malika",
                      email: "malika@gmail.com"
                    }){
                      id, name, email
                    }
                  }
                """;
        graphQlClient.document(httpRequestDocument).execute();
    }

    @GetMapping("/gql/customers")
    public Mono<List<Customer>> listCustomersGql(){
        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder()
                .url("http://localhost:8080/graphql")
                .build();
        var httpRequestDocument= """
                query {
                   findAll {
                     id, name
                   }
                 }
                """;
        Mono<List<Customer>> customersMono = graphQlClient.document(httpRequestDocument)
                .retrieve("findAll")
                .toEntityList(Customer.class);
        return customersMono;
    }

    @GetMapping("/gql/customer/{id}")
    public Mono<Customer> customerByIdGql(@PathVariable Long id){
        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder()
                .url("http://localhost:8080/graphql")
                .build();
        var httpRequestDocument= """
                query($id:Int) {
                  findById(id:$id) {
                    id, name, email
                  }
                }
                """;
        Mono<Customer> customerMono = graphQlClient.document(httpRequestDocument)
                .variable("id", id)
                .retrieve("findById")
                .toEntity(Customer.class);
        return customerMono;
    }

    /*--------------------------------------------------------------------------------------------------------*/

    /** SOAP Client */

    @GetMapping("/soap/customers")
    public List<Customer> soapCustomers(){
        List<net.kerouad.customerdataservice.web.Customer> customerList = customerSoapService.findAll();
        List<Customer> customers = customerList.stream().map(c -> customerMapper.fromSoapCustomer(c)).collect(Collectors.toList());
        return customers;
    }

    @GetMapping("/soap/customerById/{id}")
    public Customer customerByIdSoap(@PathVariable Long id){
        net.kerouad.customerdataservice.web.Customer customerById = customerSoapService.findCustomerById(id);
        return customerMapper.fromSoapCustomer(customerById);
    }

    /*--------------------------------------------------------------------------------------------------------*/

    /** GRPC Client */

    @GetMapping("/grpc/customers")
    public List<Customer> grpcCustomers(){
        CustomerServiceOuterClass.GetAllCustomersRequest request = CustomerServiceOuterClass.GetAllCustomersRequest.newBuilder().build();

        CustomerServiceOuterClass.GetCustomersResponse response = customerServiceBlockingStub.getAllCustomers(request);
        List<CustomerServiceOuterClass.Customer> customersList = response.getCustomersList();
        return customersList.stream().map(customer -> customerMapper.customerfromGrpcCustomer(customer)).collect(Collectors.toList());
    }

    @GetMapping("/grpc/customer/{id}")
    public Customer grpcCustomerById(@PathVariable Long id){
        CustomerServiceOuterClass.GetCustomerByIdRequest request = CustomerServiceOuterClass.GetCustomerByIdRequest.newBuilder().setCustomerId(id).build();

        CustomerServiceOuterClass.GetCustomerByIdResponse response = customerServiceBlockingStub.getCustomerById(request);
        CustomerServiceOuterClass.Customer customerGrpc = response.getCustomer();
        return customerMapper.customerfromGrpcCustomer(customerGrpc);
    }

}
