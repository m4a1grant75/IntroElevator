package ua.vlnagornyi.entity;

public class Passenger {
    private int targetFloor;

    public Passenger(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    @Override
    public String toString() {
        return "{" + targetFloor + "}";
    }
}
