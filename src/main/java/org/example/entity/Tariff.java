package org.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tariffs")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "price_multiplier")
    private Double price_multiplier;

    @ManyToMany
    @JoinTable(
        name = "tariff_car_types",
        joinColumns = @JoinColumn(name = "tariff_id"),
        inverseJoinColumns = @JoinColumn(name = "car_type_id"))
    private Set<CarType> carTypes;
}
