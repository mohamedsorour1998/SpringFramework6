package app.rosettacloud.ProjectAlpha.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Component;

import app.rosettacloud.ProjectAlpha.repositories.AuthorRepository;
import app.rosettacloud.ProjectAlpha.repositories.BookRepository;
import app.rosettacloud.ProjectAlpha.repositories.PublisherRepository;
import app.rosettacloud.ProjectAlpha.domain.*;

@Component
// when spring starts, it invokes the constructor
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book myBook = new Book();
        myBook.setTitle("Domain Driven Design");
        myBook.setIsbn("123456");

        Publisher myPublisher = new Publisher();
        myPublisher.setPublisherName("newPublisherName");
        myPublisher.setAddress("newPublisherAddress");
        myPublisher.setCity("newPublisherCity");
        myPublisher.setState("newPublisherState");
        myPublisher.setZip(55555);

        Author ericSaved = authorRepository.save(eric);
        Book myBookSaved = bookRepository.save(myBook);
        Publisher savedPublisher = publisherRepository.save(myPublisher);

        Author newEric = new Author();
        eric.setFirstName("New Eric");
        eric.setLastName("New Evans");

        Book newMyBook = new Book();
        myBook.setTitle("New Domain Driven Design");
        myBook.setIsbn("123456");

        Author newEricSaved = authorRepository.save(newEric);
        Book newMyBookSaved = bookRepository.save(newMyBook);
        // Association between each author and its book
        myBookSaved.setPublisher(savedPublisher);
        newMyBookSaved.setPublisher(savedPublisher);
        ericSaved.getBooks().add(myBookSaved);
        newEricSaved.getBooks().add(newMyBookSaved);
        myBook.getAuthors().add(ericSaved);
        newMyBook.getAuthors().add(newEricSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(newEricSaved);
        bookRepository.save(myBookSaved);
        bookRepository.save(newMyBookSaved);

        System.out.println("Authors Count: " + authorRepository.count());
        System.out.println("Books Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }

}
