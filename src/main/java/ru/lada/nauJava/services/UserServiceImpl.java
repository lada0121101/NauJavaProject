package ru.lada.nauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lada.nauJava.objects.User;
import ru.lada.nauJava.repos.UserRepos;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepos users;
    @Autowired
    public UserServiceImpl(UserRepos users) {
        this.users = users;
    }

    @Override
    public List<User> findByUsername(String username) {
        return users.findByUsername(username);
    }

    @Override
    public User createUser(User user) throws Exception {
        if(!users.findById(user.getId()).isEmpty()){
            throw new Exception("Пользователь уже существует");
        }
        users.save(user);
        return user;
    }
}
