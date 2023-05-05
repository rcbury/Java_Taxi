package org.example.interfaces;

import org.example.dto.UserDto;

public interface UserRepositoryInterface {
    public UserDto create(UserDto userDto);
    public UserDto delete(Long id);
    public UserDto getById(Long id);
    public UserDto update(Long id, UserDto userUpdateDto);
}
