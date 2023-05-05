package org.example.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long id = 0L;
    private Long driverId;
    private String plateNumber;
    private String description;
    private Long typeId;

}
