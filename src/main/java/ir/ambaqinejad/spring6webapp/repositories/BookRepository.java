package ir.ambaqinejad.spring6webapp.repositories;

import ir.ambaqinejad.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
