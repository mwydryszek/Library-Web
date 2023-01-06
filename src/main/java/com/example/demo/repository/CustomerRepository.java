package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.model.projections.ClientFirstNameCount;
import com.example.demo.model.projections.dtos.ClientFirstNameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("Select c.firstName as firstName, count(c) as firstNameCount from Customer c group by c.firstName")
    List<ClientFirstNameCount> countFirstNames();

    @Query("Select new com.example.demo.projections.dtos.ClientFirstNameDTO(c.firstName, count(c)) from Customer c group by c.firstName")
    List<ClientFirstNameDTO> countFirstNamesV2();

   <T> T findById(Long id, Class<T> clazz);


}
