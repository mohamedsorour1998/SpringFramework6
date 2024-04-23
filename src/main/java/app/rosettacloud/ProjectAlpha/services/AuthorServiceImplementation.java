package app.rosettacloud.ProjectAlpha.services;

import org.springframework.stereotype.Service;

import app.rosettacloud.ProjectAlpha.domain.Author;
import app.rosettacloud.ProjectAlpha.repositories.AuthorRepository;

@Service
public class AuthorServiceImplementation implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

}
