package ir.ambaqinejad.spring6webapp.repositories;

import ir.ambaqinejad.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
