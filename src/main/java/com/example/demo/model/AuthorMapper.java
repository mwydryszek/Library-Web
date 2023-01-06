package com.example.demo.model;

import com.example.demo.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author mapToEntity(AuthorDTO authorDTO);

    AuthorDTO mapToDTO(Author author);

}
