package com.example.demo.controller;

import com.example.demo.model.BookDTO;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;


    @GetMapping("/all")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping
    public BookDTO getBookById(@RequestParam(name = "id", required = false) Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

    /**
     * Zadanie.
     * Stworzyc metody kontrolera BookController, które będą pozwalały na manipulację listą książek, która znajduje się w BookRepository.
     * Podstawowa ścieżka dla wszystkich metod kontrollera ma wyglądać "/api/book"
     * W implementowanych metodach odwołać się do metod z BookService, która jest pośrednikiem z BookRepository.
     * Zaimplementować kolejno:
     *  - pobieranie wszystkich książek (BookService.getAllBooks())
     *  - pobieranie jednej książki po id (BookService.getBookById()) id pobrać wykorzystując @RequestParam
     *  - dodawanie nowej ksiazki (BookService.addBook())
     *  - edytowanie istniejacej ksiazki (BookService.updateBook()) id pobrać wykorzystując @PathVariable
     *  - usuwanie ksiazki (BookService.deleteBook()) id pobrać wykorzystując @PathVariable
     *
     *  DLA CHETNYCH
     *  Wykorzystać Mapstructa do stworzenia BookMappera
     *  link do mapstructa: https://mapstruct.org/
     *
     *  DLA BARDZO CHETNYCH
     *  Bazę danych można zamienić na prawdziwą
     *  https://www.geeksforgeeks.org/spring-boot-jparepository-with-example/
     */


}
