package com.example.demo.service.exception.controller;

import com.example.demo.model.RentDTO;
import com.example.demo.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rent")
public class RentController {

    private final RentService rentService;

    @GetMapping("/all")
    public List<RentDTO> getAllRents() {
        return rentService.getAllRents();
    }

    @GetMapping
    public RentDTO getRentById(@RequestParam(name = "id", required = false) Long id) {
        return rentService.getRentById(id);
    }

    @PostMapping
    public RentDTO addRent(@RequestBody RentDTO rentDTO) {
        return rentService.addRent(rentDTO);
    }

    @PutMapping("/{id}")
    public RentDTO updateRent(@PathVariable("id") Long id, @RequestBody RentDTO rentDTO) {
        return rentService.updateRent(id, rentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRent(@PathVariable("id") Long id) {
        rentService.deleteRent(id);
    }


}
