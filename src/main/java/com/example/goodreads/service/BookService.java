package com.example.goodreads.service;

import java.util.*;
import com.example.goodreads.model.Book;
import com.example.goodreads.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookService implements BookRepository {
    private HashMap<Integer, Book> hmap = new HashMap<>();

    public BookService() {
        Book b1 = new Book(1, "Harry Potter", "harry_potter.jpg");
        Book b2 = new Book(2, "Rise", "rise.jpeg");
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> bookCollection = hmap.values();
        return new ArrayList<>(bookCollection);
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = hmap.get(bookId);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;


    }

    int uniqueId = 3;

    @Override
    public Book addBook(Book book) {
        book.setId(uniqueId);
        hmap.put(uniqueId, book);
        uniqueId += 1;
        return book;
    }
    @Override
    public Book updateBook(int bookId,Book book){
        Book existingBook=hmap.get(bookId);
        if(existingBook==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        if (book.getName()!=null){
            existingBook.setName(book.getName());
        }
//        if(book.getImageUrl()!=null){
//            existingBook.setImageUrl(book.getImageUrl());
//        }
        return existingBook;
    }
    @Override
    public void deleteBook(int bookId){
        Book book=hmap.get(bookId);
        if(book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            hmap.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
