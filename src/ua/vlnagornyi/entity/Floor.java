package ua.vlnagornyi.entity;

import java.util.List;

public class Floor {
    private int number;
    private List<Passenger> passengers;

    public Floor(int number, List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getNumber() {
        return number;
    }
}
