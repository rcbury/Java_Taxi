package org.example.interfaces;

import org.example.dto.DriverDto;

import java.util.List;

public interface DriverRepositoryInterface {
    public DriverDto create(DriverDto driverDto);
    public void delete(Long id);
    public DriverDto getById(Long id);
    public List<DriverDto> getAll();
    public DriverDto update(DriverDto driverDto);
}
