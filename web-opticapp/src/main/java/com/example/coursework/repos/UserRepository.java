package com.example.coursework.repos;

import com.example.coursework.entities.Order;
import com.example.coursework.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
    User findUserById(Long id);

}
