package app.rosettacloud.ProjectAlpha.repositories;

import org.springframework.data.repository.CrudRepository;

import app.rosettacloud.ProjectAlpha.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
