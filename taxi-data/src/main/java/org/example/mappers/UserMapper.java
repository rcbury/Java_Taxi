package org.example.mappers;

import org.example.dto.CarDto;
import org.example.dto.UserDto;
import org.example.entity.Car;
import org.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
