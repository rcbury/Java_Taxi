package org.example.enums;

public enum CarTypes {
    SEDAN (1L),
    UNIVERSAL(2L),
    HATCHBACK(3L),
    COUPE(4L),
    GRUZOVOY(5L);

    private Long index;

    CarTypes(Long index) {
        this.index = index;
    }
}
