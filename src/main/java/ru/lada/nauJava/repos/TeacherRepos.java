package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lada.nauJava.objects.Teacher;

public interface TeacherRepos extends CrudRepository<Teacher,Long> {
}
