package org.example.mappers;

import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.UserDto;
import org.example.entity.Car;
import org.example.entity.Order;
import org.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDto toDto(User user);

    List<OrderDto> toDtos(List<Order> cars);

    User toEntity(UserDto userDto);
}
