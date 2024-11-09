package ir.ambaqinejad.spring6webapp.repositories;

import ir.ambaqinejad.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
