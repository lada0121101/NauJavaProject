package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.lada.nauJava.objects.Hometask;

import java.time.OffsetDateTime;
import java.util.List;

@RepositoryRestResource(path="hometasks")
public interface HometaskRepos extends CrudRepository<Hometask,Long> {
    public List<Hometask> findByDeadline(OffsetDateTime deadline);
}
