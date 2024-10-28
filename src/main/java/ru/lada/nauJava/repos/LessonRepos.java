package ru.lada.nauJava.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.lada.nauJava.objects.Lesson;

import java.time.OffsetDateTime;
import java.util.List;

@RepositoryRestResource(path = "lessons")
public interface LessonRepos extends CrudRepository<Lesson,Long> {
    @Query("FROM Lesson WHERE hometask.deadline = :deadline")
    public List<Lesson> findByHometask(OffsetDateTime deadline);
}
