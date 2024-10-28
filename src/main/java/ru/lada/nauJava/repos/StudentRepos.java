package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.lada.nauJava.objects.Student;
@RepositoryRestResource(path = "students")
public interface StudentRepos extends CrudRepository<Student,Long> {
}
