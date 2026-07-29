package com.app.model;

import com.app.exception.InvalidCapacityException;

public class PassengerBogie extends Bogie {

    public PassengerBogie(String id, String name, String type, int capacity) throws InvalidCapacityException {
        super(id, name, type, capacity);
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero. Received: " + capacity);
        }
    }

    @Override
    public String toString() {
        return "PassengerBogie{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", capacity=" + getCapacity() +
                '}';
    }
}
