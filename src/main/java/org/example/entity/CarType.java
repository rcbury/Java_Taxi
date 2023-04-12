package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="car_types")
@Data
public class CarType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

}

