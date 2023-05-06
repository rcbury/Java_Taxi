package org.example.mappers;

import org.example.dto.DriverDto;
import org.example.dto.OrderDto;
import org.example.entity.Driver;
import org.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );
    @Mapping(target = "tariffId", source = "tariff.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "driverId", source = "driver.id")
    @Mapping(target = "statusId", source = "status.id")

    OrderDto toDto(Order order);
    @Mapping(target = "tariff.id", source = "tariffId")
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "driver.id", source = "driverId")
    @Mapping(target = "status.id", source = "statusId")
    Order toEntity(OrderDto orderDto);
}
