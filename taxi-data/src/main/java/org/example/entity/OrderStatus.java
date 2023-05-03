package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="order_statuses")
@Data
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
