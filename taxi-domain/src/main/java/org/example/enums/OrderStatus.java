package org.example.enums;

import org.springframework.core.annotation.Order;

public enum OrderStatus {
    LOOKING_DRIVER (1L, "Свободный водитель"),
    DRIVING_TO_CLIENT (2L, "Водитель в пути до клиента"),
    DRIVING_TO_DESTINATION (3L, "Водитель в пути до места назначения"),
    ARRIVED_TO_DESTINATION (4L, "Водитель прибыл до места назначения"),
    CANCELLED (5L, "Заказ отменен");

    private String title;
    private Long value;

    OrderStatus(Long index, String title) {
        this.title = title;
        this.value = index;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getIndex() {
        return this.value;
    }
}
