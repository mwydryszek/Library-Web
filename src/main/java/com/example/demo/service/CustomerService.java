package com.example.demo.service;

import com.example.demo.model.CustomerDTO;
import com.example.demo.model.projections.dtos.ClientFirstNameAndSurnameDTO;
import com.example.demo.model.projections.dtos.ClientFirstNameDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getCustomerById(Long id);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    List<ClientFirstNameDTO> getCountFirstNames();

    List<ClientFirstNameDTO> getCountFirstNamesV2();

    ClientFirstNameAndSurnameDTO findById(Long id);

    void deleteCustomer(Long id);

}
