package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.lada.nauJava.objects.Teacher;
@RepositoryRestResource(path = "teachers")
public interface TeacherRepos extends CrudRepository<Teacher,Long> {
}
