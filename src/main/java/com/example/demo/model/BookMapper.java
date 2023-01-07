package com.example.demo.model;

import com.example.demo.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RentMapper.class})
public interface BookMapper {
    BookEntity mapToEntity(BookDTO bookDTO);
    BookDTO mapToDTO(BookEntity bookEntity);

}
