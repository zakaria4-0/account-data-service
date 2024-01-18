package net.kerouad.accountdataservice;

import net.kerouad.customerdataservice.web.CustomerService;
import net.kerouad.customerdataservice.web.CustomerSoapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class AccountDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountDataServiceApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    CustomerSoapService customerSoapService(){
        return new CustomerService().getCustomerSoapServicePort();
    }
}
