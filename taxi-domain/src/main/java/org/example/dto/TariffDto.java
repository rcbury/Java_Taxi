package org.example.dto;

import lombok.Data;

@Data
public class TariffDto {
    private long id;
    private double price_multiplier;
    private String name;
}
