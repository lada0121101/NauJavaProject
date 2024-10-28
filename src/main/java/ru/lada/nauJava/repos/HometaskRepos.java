package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lada.nauJava.objects.Hometask;

import java.time.OffsetDateTime;
import java.util.List;


public interface HometaskRepos extends CrudRepository<Hometask,Long> {
    public List<Hometask> findByDeadline(OffsetDateTime deadline);
}
