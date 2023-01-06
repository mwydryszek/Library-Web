package com.example.demo.projections.dtos;

import com.example.demo.projections.ClientFirstNameCount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientFirstNameDTO implements ClientFirstNameCount {
    String firstName;
    Long firstNameCount;
}
