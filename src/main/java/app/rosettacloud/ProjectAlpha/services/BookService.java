package app.rosettacloud.ProjectAlpha.services;

import app.rosettacloud.ProjectAlpha.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}