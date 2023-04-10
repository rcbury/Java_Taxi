package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "end_address")
    private String endAddress;

    @Column(name = "start_address")
    private String startAddress;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @ManyToOne
    @JoinColumn(name="tariff_id")
    private Tariff tariff;

    @ManyToOne
    @JoinColumn(name="status_id")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
