package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RENT")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "rent_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class Rent extends BaseEntity {
    private Timestamp rentStarted;
    private Timestamp rentEnded;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity bookEntity;
}
