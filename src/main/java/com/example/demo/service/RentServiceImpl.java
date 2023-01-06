package com.example.demo.service;

import com.example.demo.model.exception.RentNotFoundException;
import com.example.demo.entity.Rent;
import com.example.demo.model.RentDTO;
import com.example.demo.model.RentMapper;
import com.example.demo.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService{
    private final RentRepository rentRepository;
    private final RentMapper rentMapper;

    @Override
    public RentDTO getRentById(Long id) {
        return rentRepository.findById(id).map(rentMapper::mapToDTO).orElseThrow(RentNotFoundException::new);
    }

    @Override
    public List<RentDTO> getAllRents() {
        return rentRepository.findAll().stream().map(rentMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public RentDTO addRent(RentDTO rentDTO) {
        Rent rent= rentRepository.save(rentMapper.mapToEntity(rentDTO));
        return rentMapper.mapToDTO(rent);
    }

    @Override
    public RentDTO updateRent(Long id, RentDTO rentDTO) {
        rentDTO.setId(id);
        Rent rent = rentRepository.save(rentMapper.mapToEntity(rentDTO));
        return rentMapper.mapToDTO(rent);
    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }
}
