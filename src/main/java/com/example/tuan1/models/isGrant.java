package com.example.tuan1.models;

import jakarta.persistence.Table;

@Table(name = "is_grant")
public enum isGrant {
    GRANTED(1),
    DENIED(0),
    PENDING(-1);

    private final int value;

    private isGrant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
