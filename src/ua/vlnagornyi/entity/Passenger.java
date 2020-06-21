package ua.vlnagornyi.entity;

import java.util.Objects;

public class Passenger {
    private int currentFloor;
    private int targetFloor;

    public Passenger(int currentFloor, int targetFloor) {
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return currentFloor == passenger.currentFloor &&
                targetFloor == passenger.targetFloor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentFloor, targetFloor);
    }
}
