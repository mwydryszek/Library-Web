package com.example.demo.service;

import com.example.demo.exception.AuthorNotFoundException;
import com.example.demo.model.Author;
import com.example.demo.model.AuthorDTO;
import com.example.demo.model.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id).map(authorMapper::mapToDTO).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        Author author= authorRepository.save(authorMapper.mapToEntity(authorDTO));
        return authorMapper.mapToDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        authorDTO.setId(id);
        Author author = authorRepository.save(authorMapper.mapToEntity(authorDTO));
        return authorMapper.mapToDTO(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
