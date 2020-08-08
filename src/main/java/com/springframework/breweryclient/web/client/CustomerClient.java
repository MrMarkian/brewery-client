package com.springframework.breweryclient.web.client;

import com.springframework.breweryclient.web.moodel.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "com.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;

    private final RestTemplate restTemplate;


    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
       this.restTemplate = restTemplateBuilder.build() ;
    }



    public CustomerDto getCustomerByID(UUID customerId){
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public void deleteCustomer(UUID customerId){

        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId.toString() );
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto){
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId.toString(), customerDto);

    }

    public void setApiHost(String apiHost) {

        this.apiHost = apiHost;
    }
}
