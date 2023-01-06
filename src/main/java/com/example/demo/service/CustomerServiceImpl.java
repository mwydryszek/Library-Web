package com.example.demo.service;

import com.example.demo.model.exception.CustomerNotFoundException;
import com.example.demo.entity.Customer;
import com.example.demo.model.CustomerDTO;
import com.example.demo.model.CustomerMapper;
import com.example.demo.model.projections.ClientFirstNameAndSurname;
import com.example.demo.model.projections.dtos.ClientFirstNameAndSurnameDTO;
import com.example.demo.model.projections.dtos.ClientFirstNameDTO;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id).map(customerMapper::mapToDTO).orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(customerMapper.mapToEntity(customerDTO));
        return customerMapper.mapToDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        customerDTO.setId(id);
        Customer customer = customerRepository.save(customerMapper.mapToEntity(customerDTO));
        return customerMapper.mapToDTO(customer);
    }

    @Override
    public List<ClientFirstNameDTO> getCountFirstNames() {
        return customerRepository.countFirstNames().stream().map(projections -> new ClientFirstNameDTO(projections.getFirstName(), projections.getFirstNameCount())).collect(Collectors.toList());
    }

    @Override
    public List<ClientFirstNameDTO> getCountFirstNamesV2() {
        return customerRepository.countFirstNamesV2();
    }

    @Override
    public ClientFirstNameAndSurnameDTO findById(Long id) {
        ClientFirstNameAndSurname clientFirstNameAndSurname = customerRepository.findById(id, ClientFirstNameAndSurname.class);
        return ClientFirstNameAndSurnameDTO.builder()
                .firstName(clientFirstNameAndSurname.getFirstName())
                .surname(clientFirstNameAndSurname.getSurname())
                .build();
    }


    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
