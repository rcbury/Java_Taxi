package org.example.mappers;

import org.example.dto.CarDto;
import org.example.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );
    CarDto toDto(Car car);
    Car toEntity(CarDto carDto);
}
