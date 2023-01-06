package com.example.demo.model;


import com.example.demo.entity.Rent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentMapper {

    Rent mapToEntity(RentDTO rentDTO);

    RentDTO mapToDTO(Rent rent);


}
