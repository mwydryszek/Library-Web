package com.example.demo.service;

import com.example.demo.service.exception.AddressNotFoundException;
import com.example.demo.entity.Address;
import com.example.demo.model.AddressDTO;
import com.example.demo.model.AddressMapper;
import com.example.demo.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public Page<AddressDTO> getAddressByCity(String city, Pageable pageable) {

        Page<Address> page = addressRepository.findByCity(city, pageable);

        return page.map(addressMapper::mapToDTO);
    }

    @Override
    public Optional<AddressDTO> getFirstAddressByCity(String city) {
        return addressRepository.findFirstByCity(city).stream().map(addressMapper::mapToDTO).findFirst();
    }

    @Override
    public List<AddressDTO> getAddressByStreet(String street) {
        return addressRepository.findByStreet(street).stream().map(addressMapper::mapToDTO).collect(Collectors.toList());
    }

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
