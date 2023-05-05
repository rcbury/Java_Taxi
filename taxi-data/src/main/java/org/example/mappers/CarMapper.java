package org.example.mappers;

import org.example.dto.CarDto;
import org.example.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );
    @Mapping(target = "typeId", source = "type.id")
    @Mapping(target = "driverId", source = "currentDriver.id")
    CarDto toDto(Car car);
    Car toEntity(CarDto carDto);
}
