package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="driver_statuses")
@Data
public class DriverStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
