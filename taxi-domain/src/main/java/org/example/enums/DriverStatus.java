package org.example.enums;

public enum DriverStatus {
    AVAILABLE (1L),
    TAKING_ORDER(2L),
    NOT_AVAILABLE(3L);
    private Long index;

    DriverStatus(Long index) {
        this.index = index;
    }

    public Long getIndex() {
        return this.index;
    }
}
