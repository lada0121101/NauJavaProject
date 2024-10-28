package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.lada.nauJava.objects.Grade;
@RepositoryRestResource(path = "grades")
public interface GradeRepos extends CrudRepository<Grade,Long> {
}
