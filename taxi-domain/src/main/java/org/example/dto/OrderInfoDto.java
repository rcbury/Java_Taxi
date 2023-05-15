package org.example.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfoDto {
    private Long id;
    private String endAddress;
    private String startAddress;
    private Date startTime;
    private Date endTime;
    private TariffDto tariff;
    private StatusDto status;
    private DriverDto driver;
    private CarDto car;
    private UserDto user;
    private double price;
}
