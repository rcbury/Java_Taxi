package org.example.controller;

import org.example.dto.DriverDto;
import org.example.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
@RestController
@RequestMapping("api/drivers")
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
}