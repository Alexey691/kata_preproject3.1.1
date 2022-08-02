package ru.javamentor.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.springmvc.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
