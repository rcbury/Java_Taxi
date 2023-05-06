package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "end_address")
    private String endAddress;

    @Column(name = "start_address")
    private String startAddress;

    @Column(name = "start_time", nullable = true)
    private Date startTime;

    @Column(name = "end_time", nullable = true)
    private Date endTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="tariff_id")
    private Tariff tariff;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="status_id")
    private OrderStatus status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="driver_id", nullable = true)
    private Driver driver;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="price")
    private double price;
}
