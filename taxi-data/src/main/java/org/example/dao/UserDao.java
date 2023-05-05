package org.example.dao;

import org.example.entity.Order;
import org.example.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserDao extends CrudRepository<User, Long> {
    User removeUserById(Long id);
}
