package org.example.controller;

import org.example.dto.DriverDto;
import org.example.service.DriverService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
@RestController
@RequestMapping("api/v1/drivers")
public class DriverController {
    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = "/{id}", method = GET)
    @GetMapping
    public DriverDto getDriver(@PathVariable("id") Long id) {
        var response = driverService.getById(id);

        return response;
    }

    @PostMapping
    public DriverDto add(@RequestBody DriverDto driver) {
        var response = driverService.create(driver);

        return response;
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @DeleteMapping
    public void deleteDriver(@PathVariable("id") Long id) {
        driverService.delete(id);
    }

    @PutMapping
    public DriverDto putDriver(@RequestBody DriverDto DriverDto) {
        var response = driverService.update(DriverDto);

        return response;
    }

    @RequestMapping(value = "/all", method = GET)
    @GetMapping
    public List<DriverDto> getDrivers() {
        var response = driverService.getAll();

        return response;
    }

    @RequestMapping(value = "/free", method = GET)
    @GetMapping
    public List<DriverDto> getFreeDrivers() {
        var response = driverService.getFreeDrivers();

        return response;
    }

    @RequestMapping(value = "/online", method = GET)
    @PutMapping
    public void sendOnLine(@RequestParam Long driverId) {
        driverService.sendOnLine(driverId);
    }

    @RequestMapping(value = "/offline", method = GET)
    @PutMapping
    public void sendOffLine(@RequestParam Long driverId) {
        driverService.sendOffLine(driverId);
    }

    @RequestMapping(value = "/money", method = GET)
    @GetMapping
    public double getMoney(@RequestParam Long driverId,
                           @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        var response = driverService.getSalary(driverId, date);

        return response;
    }
}