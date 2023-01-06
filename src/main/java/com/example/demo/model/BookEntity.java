package com.example.demo.model;

import com.example.demo.entity.Author;
import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "BOOK")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "book_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class BookEntity extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 25, nullable = false)
    private String status;

    @Column(length = 4, nullable = false)
    private Short createYear;

    @OneToMany(mappedBy = "bookEntity")
    private Set<Rent> rent;

    @ManyToMany
    @JoinTable(name="author_book",
                joinColumns = {@JoinColumn(name="book_id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name="author_id", referencedColumnName = "id")})
    private Set<Author> author;

}
