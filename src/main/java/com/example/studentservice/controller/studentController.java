package com.example.studentservice.controller;


import com.example.studentservice.feignclients.AdressFeignclient;
import com.example.studentservice.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController

public class studentController {



    @Autowired
    private WebClient webClient;

    @Autowired

    private AdressFeignclient adressFeignclient;



    @GetMapping(value = "/other_service")

    public Response getAdressService(){

        System.out.println("nadaaa"+this.webClient.get());
         //return this.webClient.get().uri("/api_adresses").retrieve().bodyToFlux(Response.class).blockFirst();
        return  this.adressFeignclient.getAdressService();
    }

    @GetMapping(value = "/use_Feign_methode")

    public Response getAdress(){

        return this.adressFeignclient.getAdressService();

    }
}
