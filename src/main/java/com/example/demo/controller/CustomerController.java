package com.example.demo.controller;

import com.example.demo.model.CustomerDTO;
import com.example.demo.model.projections.dtos.ClientFirstNameAndSurnameDTO;
import com.example.demo.model.projections.dtos.ClientFirstNameDTO;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/firstname-surname-by-id/{id}")
    public ResponseEntity<ClientFirstNameAndSurnameDTO> getFirstnameAndSurnameById(@PathVariable("id") Long id) {
        return ResponseEntity.accepted().body(customerService.findById(id));
    }

    @GetMapping("/count-names")
    public List<ClientFirstNameDTO> getCountedNames() {
        return customerService.getCountFirstNames();
    }

    @GetMapping("/count-names-v2")
    public List<ClientFirstNameDTO> getCountedNamesV2() {
        return customerService.getCountFirstNamesV2();
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping
    public CustomerDTO getCustomerById(@RequestParam(name = "id", required = false) Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }


}
