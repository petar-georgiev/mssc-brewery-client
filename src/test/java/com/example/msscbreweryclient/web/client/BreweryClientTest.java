package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.BeerDto;
import com.example.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveBeerDto() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Beer Name")
                .beerStyle("LAGER")
                .build();

        URI uri = client.saveBeerDto(beerDto);

        assertNotNull(uri);
        System.out.println(uri.toString());

    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Beer Name")
                .beerStyle("LAGER")
                .build();

        client.updateBeer(UUID.randomUUID(),beerDto);
    }


    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById(){
        CustomerDto customer = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void saveCustomerDto(){
        CustomerDto customerDto = CustomerDto.builder()
                .name("Pesho").build();
        URI uri = client.saveCustomerDto(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer(){
        CustomerDto customerDto = CustomerDto.builder()
                .name("Pesho").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}