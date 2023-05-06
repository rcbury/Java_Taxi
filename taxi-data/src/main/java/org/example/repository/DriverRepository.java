package org.example.repository;

import org.example.dao.CarDao;
import org.example.dao.DriverDao;
import org.example.dao.DriverStatusDao;
import org.example.dto.DriverDto;
import org.example.entity.Driver;
import org.example.entity.Order;
import org.example.enums.DriverStatus;
import org.example.enums.OrderStatus;
import org.example.mappers.DriverMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepository implements org.example.repository.interfaces.DriverRepository {
    private CarDao carDao;
    private DriverDao driverDao;
    private DriverStatusDao driverStatusDao;
    private DriverMapper mapper;

    public DriverRepository(CarDao carDao, DriverDao driverDao,
                            DriverStatusDao driverStatusDao, DriverMapper mapper)
    {
        this.carDao = carDao;
        this.driverDao = driverDao;
        this.driverStatusDao = driverStatusDao;
        this.mapper = mapper;
    }

    public DriverDto create(DriverDto driverDto)
    {
        Driver driverEntity = new Driver();
        var car = carDao.findById(driverDto.getCarId());
        var status = driverStatusDao.findById(driverDto.getStatusId());
        if (car.isPresent())
        {
            driverEntity.setCar(car.get());
        }
        if (status.isPresent())
        {
            driverEntity.setStatus(status.get());
        }
        driverEntity.setLicenseNumber(driverDto.getLicenseNumber());
        driverEntity.setName(driverDto.getName());
        driverDao.save(driverEntity);
        return mapper.toDto(driverEntity);
    }

    public DriverDto update(DriverDto driverDto)
    {
        var driver = driverDao.findById(driverDto.getId());
        if (driver.isPresent())
        {
            var driverEntity = driver.get();
            var car = carDao.findById(driverDto.getCarId());
            var status = driverStatusDao.findById(driverDto.getStatusId());
            if (car.isPresent())
            {
                driverEntity.setCar(car.get());
            }
            if (status.isPresent())
            {
                driverEntity.setStatus(status.get());
            }
            driverEntity.setLicenseNumber(driverDto.getLicenseNumber());
            driverEntity.setName(driverDto.getName());
            driverDao.save(driverEntity);
            return mapper.toDto(driverEntity);
        }
        return driverDto;
    }

    public DriverDto getById(Long id)
    {
        var optionalEntity = driverDao.findById(id);
        if (optionalEntity.isPresent())
        {
            return mapper.toDto(optionalEntity.get());
        }
        DriverDto dto = new DriverDto();
        return dto;
    }

    public List<DriverDto> getAll()
    {
        var drivers = driverDao.findAll();
        var driverList = new ArrayList<Driver>();

        driverList.forEach(driverList::add);

        return mapper.toDtos(driverList);
    }

    public List<DriverDto> findByStatusId(DriverStatus status) {
        var listFreeDriver = driverDao.findByStatusId(status.getIndex());
        var listFreeDriverDto = new ArrayList<DriverDto>();

        for (var driver : listFreeDriver)
        {
            listFreeDriverDto.add(mapper.toDto(driver));
        }

        return listFreeDriverDto;
    }

    public void delete(Long id)
    {
        driverDao.deleteById(id);
    }

}
