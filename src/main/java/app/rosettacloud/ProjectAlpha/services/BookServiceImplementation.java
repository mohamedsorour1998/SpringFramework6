package app.rosettacloud.ProjectAlpha.services;

import org.springframework.stereotype.Service;

import app.rosettacloud.ProjectAlpha.domain.Book;
import app.rosettacloud.ProjectAlpha.repositories.BookRepository;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

}
