package app.rosettacloud.ProjectAlpha.repositories;

import org.springframework.data.repository.CrudRepository;

import app.rosettacloud.ProjectAlpha.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
