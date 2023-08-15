package com.example.studentservice.service;


import com.example.studentservice.feignclients.AdressFeignclient;
import com.example.studentservice.response.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired

    private AdressFeignclient adressFeignclient;


    @CircuitBreaker(name = "adressService",fallbackMethod = "fallbackgetAdress")
    public Response getAdressService() {

        return this.adressFeignclient.getAdressService();
    }

    public Response fallbackgetAdress(){
        return new Response();
    }
}
