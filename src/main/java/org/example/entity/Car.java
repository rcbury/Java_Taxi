package org.example.entity;

import javax.persistence.*;

@Entity(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name="driver_id", referencedColumnName = "id")
    private Driver driver;

    @Column(name="plate_number")
    private String plateNumber;

    @Column(name="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name="status_id")
    private CarStatus status;

    @ManyToOne()
    @JoinColumn(name="type_id")
    private CarType type;
}
