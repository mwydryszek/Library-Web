package com.example.demo.model;

import com.example.demo.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer mapToEntity(CustomerDTO customerDTO);

    CustomerDTO mapToDTO(Customer customer);

}
