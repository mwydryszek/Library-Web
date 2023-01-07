package com.example.demo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Author;
import com.example.demo.entity.BookEntity;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Rent;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Component
public class DatabaseInitializer {

    private final AddressRepository addressRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final RentRepository rentRepository;

    @PostConstruct
    public void initDatabase(){

        Customer customer = Customer.builder()
                .firstName("Kamil")
                .surname("Kowal")
                .birthDate(LocalDate.of(1999, 1,1))
                .build();

        customerRepository.save(customer);

        Address address = Address.builder()
                .street("Morska")
                .city("Koszalin")
                .zipCode("75-123")
                .houseNumber("1")
                .customer(customer)
                .build();

        addressRepository.save(address);

        Author author = Author.builder()
                .firstName("Marek")
                .surname("Kowal")
                .birthDate(LocalDate.of(2000, 1, 1))
                .build();

        authorRepository.save(author);

        BookEntity book = BookEntity.builder()
                .status("ok")
                .title("Harry Potter")
                .createYear((short) 2000)
                .author(Set.of(author))
                .build();

        bookRepository.save(book);

        Rent rent = Rent.builder()
                .rentStarted(new Timestamp(System.currentTimeMillis()))
                .rentEnded(new Timestamp(System.currentTimeMillis()))
                .customer(customer)
                .bookEntity(book)
                .build();

        rentRepository.save(rent);

    }

}
