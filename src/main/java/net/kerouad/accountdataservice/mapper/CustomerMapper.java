package net.kerouad.accountdataservice.mapper;


import net.kerouad.accountdataservice.model.Customer;
import net.kerouad.customerdataservice.stub.CustomerServiceOuterClass;
import net.kerouad.customerdataservice.web.CustomerRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private ModelMapper modelMapper = new ModelMapper();
    public Customer fromSoapCustomer(net.kerouad.customerdataservice.web.Customer soapCustomer){
        return modelMapper.map(soapCustomer, Customer.class);
    }
    public Customer customerfromGrpcCustomer(CustomerServiceOuterClass.Customer grpcCustomer){
        return modelMapper.map(grpcCustomer, Customer.class);
    }

    public CustomerRequest fromCustomerToSoap(Customer customer) {
        return modelMapper.map(customer, CustomerRequest.class);
    }

    public CustomerServiceOuterClass.SaveCustomerRequest fromCustomerToGrpc(Customer customer) {
        return modelMapper.map(customer, CustomerServiceOuterClass.SaveCustomerRequest.Builder.class).build();
    }
}
