package ua.vlnagornyi.entity;

import java.util.List;

public class Elevator {
    private static Elevator elevator;

    private int currentFloor;
    private List<Passenger> passengers;

    private Elevator(int currentFloor, List<Passenger> passengers) {
        this.currentFloor = currentFloor;
        this.passengers = passengers;
    }

    public static Elevator getInstance(int currentFloor, List<Passenger> passengers){
        if (elevator == null){
            elevator = new Elevator(currentFloor, passengers);
        }
        return elevator;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                ", passengers=" + passengers +
                '}';
    }
}
