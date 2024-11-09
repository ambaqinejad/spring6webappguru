package ir.ambaqinejad.spring6webapp.bootstrap;

import ir.ambaqinejad.spring6webapp.domain.Author;
import ir.ambaqinejad.spring6webapp.domain.Book;
import ir.ambaqinejad.spring6webapp.domain.Publisher;
import ir.ambaqinejad.spring6webapp.repositories.AuthorRepository;
import ir.ambaqinejad.spring6webapp.repositories.BookRepository;
import ir.ambaqinejad.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("AmirHosein");
        author1.setLastName("Baqinejad");

        Book book1 = new Book();
        book1.setTitle("Domain Driven Design");
        book1.setIsbn("123456");

        Author author1Saved = authorRepository.save(author1);
        Book book1Saved = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirstName("Ali");
        author2.setLastName("Hamedi");

        Book book2 = new Book();
        book2.setTitle("Java Design Pattern");
        book2.setIsbn("546824");

        Author author2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);

        author1Saved.getBooks().add(book1Saved);
        author2Saved.getBooks().add(book2Saved);
        book1Saved.getAuthors().add(author1Saved);
        book2Saved.getAuthors().add(author2Saved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My publisher");
        publisher.setAddress("123 Main");
        Publisher publisherSaved = publisherRepository.save(publisher);
        book1Saved.setPublisher(publisherSaved);
        book2Saved.setPublisher(publisherSaved);

        authorRepository.save(author1Saved);
        authorRepository.save(author2Saved);
        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);

        System.out.println("In bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
