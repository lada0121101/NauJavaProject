package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lada.nauJava.objects.Grade;

public interface GradeRepos extends CrudRepository<Grade,Long> {
}
