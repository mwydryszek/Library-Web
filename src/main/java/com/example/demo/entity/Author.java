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
@Table(name = "AUTHOR")
@SequenceGenerator(name = "generator_seq", sequenceName = "author_id_seq", allocationSize = 1, initialValue = 1)
public class Author extends BaseEntity{

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String surname;

    private LocalDate birthDate;

    @ManyToMany(mappedBy = "author")
    private Set<BookEntity> bookEntities;


}
