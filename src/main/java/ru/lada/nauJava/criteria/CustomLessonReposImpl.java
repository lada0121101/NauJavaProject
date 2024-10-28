package ru.lada.nauJava.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lada.nauJava.objects.Hometask;
import ru.lada.nauJava.objects.Lesson;

import java.time.OffsetDateTime;
import java.util.List;
@Repository
public class CustomLessonReposImpl implements CustomLessonRepos{
    private EntityManager manager;
    @Autowired
    public CustomLessonReposImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Lesson> findByHometask(OffsetDateTime deadline) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lesson> query = builder.createQuery(Lesson.class);

        Root<Lesson> root = query.from(Lesson.class);
        Join<Lesson, Hometask> join = root.join("hometask", JoinType.INNER);
        Predicate condition = builder.equal(join.get("deadline"),deadline);

        query.select(root).where(condition);

        return manager.createQuery(query).getResultList();
    }
}
