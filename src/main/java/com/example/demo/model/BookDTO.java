package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String status;
    private Short createYear;
    private Set<RentDTO> rents;
}
