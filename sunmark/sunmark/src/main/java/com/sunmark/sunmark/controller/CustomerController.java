package com.sunmark.sunmark.controller;

import com.sunmark.sunmark.dto.CustomerSaveRequestDTO;
import com.sunmark.sunmark.entity.Customer;
import com.sunmark.sunmark.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/rice")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save-customer")
    private String saveCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO){

        String message = customerService.saveCustomer(saveRequestDTO);

        return message;
    }

    @GetMapping(path = "/get-customer")
    public List<Customer> getCustomer(){
       return customerService.getCustomers();
    }


}
