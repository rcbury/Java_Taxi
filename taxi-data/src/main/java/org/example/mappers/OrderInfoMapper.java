package org.example.mappers;

import org.example.dto.DriverDto;
import org.example.dto.OrderDto;
import org.example.dto.OrderInfoDto;
import org.example.entity.Driver;
import org.example.entity.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderInfoMapper {
    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );
    @Mapping(target = "driver.carId", source = "driver.car.id")
    @Mapping(target = "driver.statusId", source = "driver.status.id")
    @Mapping(target = "car", source = "driver.car")
    OrderInfoDto toDto(Order order);

    @AfterMapping
    default void toEntityAfterMapping(OrderDto source, @MappingTarget Order target) {
        if (source.getDriverId() == null) {
            target.setDriver(null);
        }
    }

}
