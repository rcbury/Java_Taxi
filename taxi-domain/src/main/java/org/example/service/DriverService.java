package org.example.service;

import org.example.dto.DriverDto;
import org.example.repository.interfaces.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class DriverService {
    DriverRepository repository;

    DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public DriverDto create(DriverDto driverDto) {
        return repository.create(driverDto);
    }
    public void delete(Long id) {
        repository.delete(id);
    }
    public DriverDto getById(Long id) {
        return repository.getById(id);
    }
    public DriverDto update(DriverDto driverDto) {
        return repository.update(driverDto);
    }

    public List<DriverDto> getAll() {
        return repository.getAll();
    }

    public List<DriverDto> getFreeDrivers()
    {
        var allDrivers = repository.getAll();
        var freeDrivers = new ArrayList<DriverDto>();
        for (var driver : allDrivers)
        {
            if (driver.getStatusId() == 1)
            {
                freeDrivers.add(driver);
            }
        }
        return freeDrivers;
    }
}
