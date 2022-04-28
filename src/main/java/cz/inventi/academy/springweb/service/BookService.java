package cz.inventi.academy.springweb.service;

import java.util.List;

import cz.inventi.academy.springweb.model.Book;

public interface BookService {

    List<Book> loadBooks();

    void save(Book book);

    void delete(long id);
}
