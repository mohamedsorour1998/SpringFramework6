package app.rosettacloud.ProjectAlpha.services;

import app.rosettacloud.ProjectAlpha.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
