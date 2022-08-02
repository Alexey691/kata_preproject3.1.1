package ru.javamentor.springmvc.service;

import ru.javamentor.springmvc.models.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    void delUser(long id);

    void updUser(User user);

    Optional<User> getUser(long id);

    List<User> getAllUsers();
}
