package com.example.studentservice.feignclients;


import com.example.studentservice.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


// url de micro service sender
@FeignClient(value = "api-gateway")


public interface AdressFeignclient {

    @GetMapping(value = "/student-service/other_service")
    public Response getAdressService();



    }
