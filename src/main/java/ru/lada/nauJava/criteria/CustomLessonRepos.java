package ru.lada.nauJava.criteria;

import ru.lada.nauJava.objects.Lesson;

import java.time.OffsetDateTime;
import java.util.List;

public interface CustomLessonRepos {
    List<Lesson> findByHometask(OffsetDateTime deadline);
}
