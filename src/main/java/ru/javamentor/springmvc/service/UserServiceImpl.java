package ru.javamentor.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.javamentor.springmvc.models.User;
import ru.javamentor.springmvc.repository.UserRepository;


import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void delUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updUser(User user) {
        userRepository.save(user);

    }
}
