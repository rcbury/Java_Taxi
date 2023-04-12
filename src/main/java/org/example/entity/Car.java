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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
