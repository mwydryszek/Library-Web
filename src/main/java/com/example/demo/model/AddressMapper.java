package com.example.demo.model;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address mapToEntity(AddressDTO addressDTO);

    AddressDTO mapToDTO(Address address);

}
