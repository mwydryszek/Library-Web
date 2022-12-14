package com.example.demo.service;

import com.example.demo.model.AddressDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Page<AddressDTO> getAddressByCity(String city, Pageable pageable);

    Optional<AddressDTO> getFirstAddressByCity(String city);

    List<AddressDTO> getAddressByStreet(String street);


    AddressDTO getAddressById(Long id);

    List<AddressDTO> getAllAddresses();

    AddressDTO addAddress(AddressDTO addressDTO);

    AddressDTO updateAddress(Long id, AddressDTO addressDTO);

    void deleteAddress(Long id);

}
