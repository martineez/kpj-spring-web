package cz.inventi.academy.springweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.inventi.academy.springweb.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private long ids;

    private Map<Long, Book> books = new HashMap<>();

    @Override
    public List<Book> loadBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void save(Book book) {
        if (book != null) {
            book.setId(getNextId());
            books.put(book.getId(), book);
        }
    }

    @Override
    public void delete(long id) {
        books.remove(id);
    }

    protected long getNextId() {
        return ids++;
    }
}
