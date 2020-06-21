package ua.vlnagornyi.entity;

import java.util.List;

public class Elevator {
    private static Elevator elevator;

    private int currentFloor;
    private int nextFloor;
    private List<Passenger> passengers;

    private Elevator(int currentFloor, int nextFloor, List<Passenger> passengers) {
        this.currentFloor = currentFloor;
        this.nextFloor = nextFloor;
        this.passengers = passengers;
    }

    public static Elevator getInstance(int currentFloor, List<Passenger> passengers){
        if (elevator == null){
            elevator = new Elevator(currentFloor, 0, passengers);
        }
        return elevator;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
