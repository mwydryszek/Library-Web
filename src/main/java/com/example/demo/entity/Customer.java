package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "customer_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class Customer extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String surname;

    @Column(length = 50)
    private String phoneNumber;

    @Column(length = 9)
    private LocalDate birthDate;

    @OneToOne(mappedBy = "customer")
    private Address address;

    @OneToMany(mappedBy = "customer")
    private Set<Rent> rent;

}
