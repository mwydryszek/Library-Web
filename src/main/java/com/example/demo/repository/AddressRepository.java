package com.example.demo.repository;

import com.example.demo.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>, PagingAndSortingRepository<Address, Long> {

    Page<Address> findByCity(String city, Pageable pageable);

    Optional<Address> findFirstByCity(String city);

    @Query("Select a From Address a Where a.street = :street")
    List<Address> findByStreet(@Param(value="street") String street);

}
