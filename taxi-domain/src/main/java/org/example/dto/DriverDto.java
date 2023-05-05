package org.example.dto;

import lombok.Data;

@Data
public class DriverDto {
    private Long id = 0L;
    private String name;
    private String licenseNumber;
    private Long carId;
    private Long statusId;

}
