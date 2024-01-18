package net.kerouad.accountdataservice.feign;

import net.kerouad.accountdataservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8080/", value = "customer-rest-client")
public interface CustomerRestClient {

    @GetMapping("/save")
    void saveCustomer(Customer customer);
    @GetMapping("/customers")
    List<Customer> getCustomers();

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable(name = "id") Long id);
}
