package com.example.demo.smartKyc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartKycController
{
    private final SmartKycService smartKycService;

    @Autowired
    public SmartKycController(SmartKycService smartKycService)
    {
        this.smartKycService = smartKycService;
    }

    @PostMapping("/chainWithHighestValue")
    @CrossOrigin(origins = "http://localhost:4200")
    public Integer getChainWithHighestValue(@RequestBody WrapperSmartKycDTO dto)
    {
        return smartKycService.getChainWithHighestValue(dto);
    }
}