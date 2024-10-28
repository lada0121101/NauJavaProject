package ru.lada.nauJava.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lada.nauJava.objects.Hometask;

import java.time.OffsetDateTime;
import java.util.List;
@Repository
public class CustomHometaskReposImpl implements CustomHometaskRepos{
    private EntityManager manager;
    @Autowired
    public CustomHometaskReposImpl(EntityManager manager){
        this.manager=manager;
    }
    @Override
    public List<Hometask> findByDeadline(OffsetDateTime deadline) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Hometask> query = builder.createQuery(Hometask.class);

        Root<Hometask> root = query.from(Hometask.class);
        Predicate condition = builder.equal(root.get("deadline"),deadline);

        query.select(root).where(condition);
        return manager.createQuery(query).getResultList();
    }
}
