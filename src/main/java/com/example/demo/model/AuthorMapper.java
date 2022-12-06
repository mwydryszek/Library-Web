package com.example.demo.model;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author mapToEntity(AuthorDTO authorDTO);

    AuthorDTO mapToDTO(Author author);

}
