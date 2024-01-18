package net.kerouad.accountdataservice.mapper;


import net.kerouad.accountdataservice.model.Customer;
import net.kerouad.customerdataservice.stub.CustomerServiceOuterClass;
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
}
