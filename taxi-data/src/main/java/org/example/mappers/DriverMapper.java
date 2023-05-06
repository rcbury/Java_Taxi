package org.example.mappers;

import org.example.dto.DriverDto;
import org.example.dto.OrderDto;
import org.example.entity.Driver;
import org.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper( DriverMapper.class );
    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "statusId", source = "status.id")
    DriverDto toDto(Driver driver);

    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "statusId", source = "status.id")
    List<DriverDto> toDtos(List<Driver> drivers);

    Driver toEntity(DriverDto driverDto);
}
