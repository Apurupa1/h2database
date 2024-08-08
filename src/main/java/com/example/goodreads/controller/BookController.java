package com.example.goodreads.controller;

import com.example.goodreads.service.BookService;
import com.example.goodreads.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BookController {
    BookService bookService = new BookService();
    @GetMapping("/books")
    public ArrayList<Book>getBooks(){
        return bookService.getBooks();
    }


    @GetMapping("/books/{bookId}")
    public Book getBookId(@PathVariable ("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable ("bookId")int bookId,@RequestBody Book book){
        return bookService.updateBook(bookId,book);
    }
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable ("bookId")int bookId){
         bookService.deleteBook(bookId);
    }
}