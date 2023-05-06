package org.example.mappers;

import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.entity.Car;
import org.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );
    @Mapping(target = "typeId", source = "type.id")
    @Mapping(target = "driverId", source = "currentDriver.id")
    CarDto toDto(Car car);

    @Mapping(target = "typeId", source = "type.id")
    @Mapping(target = "driverId", source = "currentDriver.id")
    List<CarDto> toDtos(List<Car> cars);

    Car toEntity(CarDto carDto);
}
