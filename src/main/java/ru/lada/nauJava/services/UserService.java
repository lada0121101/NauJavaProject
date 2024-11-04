package ru.lada.nauJava.services;

import ru.lada.nauJava.objects.User;

import java.util.List;

public interface UserService {
    List<User> findByUsername(String username);
    User createUser(User user) throws Exception;
}
