package com.app.model;

public class GoodsBogie extends Bogie {
    private String cargoType;

    public GoodsBogie(String id, String name, String type, int capacity, String cargoType) {
        super(id, name, type, capacity);
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
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
