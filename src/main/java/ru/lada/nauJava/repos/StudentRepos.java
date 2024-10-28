package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lada.nauJava.objects.Student;

public interface StudentRepos extends CrudRepository<Student,Long> {
}
