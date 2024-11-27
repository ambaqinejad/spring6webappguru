package ir.ambaqinejad.spring6webapp.services;

import ir.ambaqinejad.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
