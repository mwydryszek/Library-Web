package com.example.demo.service.exception.controller;

import com.example.demo.model.AddressDTO;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/find-by-city/{city}")
    public Page<AddressDTO> getAddressByCity(@PathVariable("city") String city, Pageable pageable){
        return addressService.getAddressByCity(city, pageable);
    }

    @GetMapping("/find-first-by-city/{city}")
    public Optional<AddressDTO> getFirstAddressByCity(@PathVariable("city") String city){
        return addressService.getFirstAddressByCity(city);
    }

    @GetMapping("/find-by-street/{street}")
    public List<AddressDTO> getAddressByStreet(@PathVariable("street") String street){
        return addressService.getAddressByStreet(street);
    }

    @GetMapping("/all")
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping
    public AddressDTO getAddressById(@RequestParam(name = "id", required = false) Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public AddressDTO addAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.addAddress(addressDTO);
    }

    @PutMapping("/{id}")
    public AddressDTO updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
        return addressService.updateAddress(id, addressDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }


}
