package org.example.repository;

import org.example.dao.UserDao;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.mappers.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements org.example.repository.interfaces.UserRepository {
    UserDao userDao;
    UserMapper mapper;

    public UserRepository(UserDao userDao, UserMapper mapper) {
        this.userDao = userDao;
        this.mapper = mapper;
    }

    public UserDto create(UserDto userDto) {
        User newUser = mapper.toEntity(userDto);
        userDao.save(newUser);

        return mapper.toDto(newUser);
    }

    public UserDto delete(Long id) {
        User removeUser = userDao.removeUserById(id);

        return mapper.toDto(removeUser);
    }

    public UserDto getById(Long id) {
        Optional<User> findUser = userDao.findById(id);

        if (findUser.isPresent()) {
            return mapper.toDto(findUser.get());
        } else {
            return null;
        }
    }

    public UserDto update(UserDto userUpdateDto) {
        var userUpdate = mapper.toEntity(userUpdateDto);

        userDao.save(userUpdate);

        return userUpdateDto;
    }
}