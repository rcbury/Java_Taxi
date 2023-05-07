package org.example.service;

import org.example.dto.UserDto;
import org.example.repository.interfaces.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository repository;

    UserService(UserRepository repository) {
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
    public UserDto update(UserDto userUpdateDto) {
        return repository.update(userUpdateDto);
    }
}
