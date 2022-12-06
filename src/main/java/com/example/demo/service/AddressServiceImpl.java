package com.example.demo.service;

import com.example.demo.exception.AddressNotFoundException;
import com.example.demo.model.Address;
import com.example.demo.model.AddressDTO;
import com.example.demo.model.AddressMapper;
import com.example.demo.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressDTO getAddressById(Long id) {
        return addressRepository.findById(id).map(addressMapper::mapToDTO).orElseThrow(AddressNotFoundException::new);
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream().map(addressMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address address= addressRepository.save(addressMapper.mapToEntity(addressDTO));
        return addressMapper.mapToDTO(address);
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        addressDTO.setId(id);
        Address address = addressRepository.save(addressMapper.mapToEntity(addressDTO));
        return addressMapper.mapToDTO(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
