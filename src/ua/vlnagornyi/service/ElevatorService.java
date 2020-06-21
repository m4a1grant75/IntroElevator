package ua.vlnagornyi.service;

import ua.vlnagornyi.entity.Elevator;
import ua.vlnagornyi.entity.Floor;
import ua.vlnagornyi.entity.Passenger;

import java.util.ArrayList;
import java.util.List;

public class ElevatorService {

    private static final int MAX_ELEVATOR_CAPACITY = 5;

    private Elevator elevator;
    private final int maxFloor;

    public ElevatorService(Elevator elevator, int max_floor) {
        this.elevator = elevator;
        this.maxFloor = max_floor;
    }

    public Floor moveTo (Floor floor){
        elevator.setCurrentFloor(floor.getNumber());
        dropOffPassengers();
        List<Passenger> extraPassenger = pickUpPassengers(floor.getPassengers());
        floor.setPassengers(extraPassenger);
        elevator.setCurrentFloor(floor.getNumber());
        return floor;
    }

    public List<Passenger> pickUpPassengers (List<Passenger> newPassengers){
        List<Passenger> currentPassengers = elevator.getPassengers();
        if (currentPassengers.size() < MAX_ELEVATOR_CAPACITY){
            int freeSpace = MAX_ELEVATOR_CAPACITY - currentPassengers.size();
            currentPassengers.addAll(newPassengers.subList(0, freeSpace));
            newPassengers.removeAll(newPassengers.subList(0, freeSpace));
            elevator.setNextFloor(calculateNextFloor());
        }
        return newPassengers;
    }

    public List<Passenger> dropOffPassengers(){
        List<Passenger> passengers = elevator.getPassengers();
        passengers.removeIf(p -> p.getTargetFloor() == elevator.getCurrentFloor());
        return passengers;
    }

    private int calculateNextFloor() {
        List<Passenger> passengers = elevator.getPassengers();
        int maxFloor = 0;
        for (Passenger p : passengers) {
            maxFloor = Math.max(p.getCurrentFloor(), maxFloor);
        }
        if (maxFloor > elevator.getCurrentFloor()) {
            return elevator.getCurrentFloor() + 1;
        } else {
            return elevator.getCurrentFloor() - 1;
        }
    }
}
