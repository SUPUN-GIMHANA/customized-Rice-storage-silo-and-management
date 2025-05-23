package com.sunmark.sunmark.service.impl;

import com.sunmark.sunmark.dto.CustomerSaveRequestDTO;
import com.sunmark.sunmark.entity.Customer;
import com.sunmark.sunmark.repo.CustomerRepo;
import com.sunmark.sunmark.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {
        Customer customer = new Customer(
                0,
                saveRequestDTO.getRadiousA(),
                saveRequestDTO.getRadiousB(),
                saveRequestDTO.getRadiousC(),
                saveRequestDTO.getHeightA(),
                saveRequestDTO.getHeightB(),
                saveRequestDTO.getHeightC(),
                saveRequestDTO.getLoadvalie(),
                saveRequestDTO.getUnloadvalie(),
                saveRequestDTO.getInputdate()
        );
        customerRepo.save(customer);
        return "Customer saved successfully";

    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }
}
