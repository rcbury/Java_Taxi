package org.example.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    public Long id;
    public String endAddress;
    public String startAddress;
    public Date startTime;
    public Date endTime;
    public Long tarrifId;
    public Long statusId;
    public Long driverId;
    public Long userId;

}
