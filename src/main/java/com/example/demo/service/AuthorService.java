package com.example.demo.service;

import com.example.demo.model.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO getAuthorById(Long id);

    List<AuthorDTO> getAllAuthors();

    AuthorDTO addAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO);

    void deleteAuthor(Long id);

}
