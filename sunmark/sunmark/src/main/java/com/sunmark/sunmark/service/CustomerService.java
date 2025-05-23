package com.sunmark.sunmark.service;

import com.sunmark.sunmark.dto.CustomerSaveRequestDTO;
import com.sunmark.sunmark.entity.Customer;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

    List<Customer> getCustomers();
}
