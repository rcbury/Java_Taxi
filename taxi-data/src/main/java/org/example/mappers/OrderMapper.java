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
    OrderDto toDto(Order order);
    @Mapping(target = "tariff.id", source = "tariffId")
    Order toEntity(OrderDto orderDto);
}
