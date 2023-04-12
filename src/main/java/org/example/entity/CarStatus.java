package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="car_statuses")
@Data
public class CarStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
