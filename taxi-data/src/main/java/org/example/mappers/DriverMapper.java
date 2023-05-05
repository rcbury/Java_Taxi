package org.example.mappers;

import org.example.dto.DriverDto;
import org.example.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper( DriverMapper.class );
    DriverDto toDto(Driver driver);
    Driver toEntity(DriverDto carDto);
}
