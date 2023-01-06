package com.example.demo.model.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientFirstNameAndSurnameDTO {

    String firstName;
    String surname;

}
