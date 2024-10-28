package ru.lada.nauJava.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.lada.nauJava.objects.Lesson;

import java.time.OffsetDateTime;
import java.util.List;

public interface LessonRepos extends CrudRepository<Lesson,Long> {
    @Query("FROM Lesson WHERE hometask.deadline = :deadline")
    public List<Lesson> findByHometask(OffsetDateTime deadline);
}
