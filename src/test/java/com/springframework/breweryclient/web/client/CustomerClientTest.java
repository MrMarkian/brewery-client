package com.springframework.breweryclient.web.client;

import com.springframework.breweryclient.web.moodel.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerByID() {
        CustomerDto dto = client.getCustomerByID(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("New Test Customer")
                .build();
        URI uri = client.saveNewCustomer(customerDto);
        System.out.println(uri);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("New Test Customer")
                .build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }
}