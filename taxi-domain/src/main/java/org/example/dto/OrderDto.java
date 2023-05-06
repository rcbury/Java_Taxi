package org.example.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private Long id;
    private String endAddress;
    private String startAddress;
    private Date startTime;
    private Date endTime;
    private Long tariffId;
    private Long statusId;
    private Long driverId;
    private Long userId;
    private double price;
}
