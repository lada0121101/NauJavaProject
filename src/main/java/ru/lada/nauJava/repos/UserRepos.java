package ru.lada.nauJava.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lada.nauJava.objects.User;

import java.util.List;

public interface UserRepos extends CrudRepository<User,Long> {
    List<User> findByUsername(String username);
}
