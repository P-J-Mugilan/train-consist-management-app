package com.app.model;

import com.app.exception.CargoSafetyException;

public class GoodsBogie extends Bogie {
    private String cargoType;

    public GoodsBogie(String id, String name, String type, int capacity, String cargoType) {
        super(id, name, type, capacity);
        // Validate during construction as well
        if (type.equalsIgnoreCase("Rectangular") && "Petroleum".equalsIgnoreCase(cargoType)) {
            throw new CargoSafetyException("Safety Violation: Petroleum cannot be assigned to a Rectangular bogie.");
        }
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        assignCargo(cargoType);
    }

    public void assignCargo(String cargoType) {
        if (getType().equalsIgnoreCase("Rectangular") && "Petroleum".equalsIgnoreCase(cargoType)) {
            throw new CargoSafetyException("Safety Violation: Petroleum cannot be assigned to a Rectangular bogie.");
        }
        this.cargoType = cargoType;
    }

    @Override
    public String toString() {
        return "GoodsBogie{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", capacity=" + getCapacity() +
                ", cargoType='" + cargoType + '\'' +
                '}';
    }
}
