package org.example.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="plate_number")
    private String plateNumber;

    @Column(name="description")
    private String description;

    @OneToOne(mappedBy = "car")
    private Driver currentDriver;

    @ManyToOne()
    @JoinColumn(name="type_id")
    private CarType type;
}
