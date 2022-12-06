package com.example.demo.service;

import com.example.demo.model.AddressDTO;
import com.example.demo.model.BookDTO;

import java.util.List;

public interface AddressService {

    AddressDTO getAddressById(Long id);

    List<AddressDTO> getAllAddresses();

    AddressDTO addAddress(AddressDTO addressDTO);

    AddressDTO updateAddress(Long id, AddressDTO addressDTO);

    void deleteAddress(Long id);

}
