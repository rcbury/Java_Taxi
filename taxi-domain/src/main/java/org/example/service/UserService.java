package org.example.service;

import org.example.dto.UserDto;
import org.example.interfaces.UserRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepositoryInterface repository;

    UserService(UserRepositoryInterface repository) {
        this.repository = repository;
    }

    public UserDto create(UserDto userDto) {
        return repository.create(userDto);
    }
    public UserDto delete(Long id) {
        return repository.delete(id);
    }
    public UserDto getById(Long id) {
        return repository.getById(id);
    }
    public UserDto update(Long id, UserDto userUpdateDto) {
        return repository.update(id, userUpdateDto);
    }
}
