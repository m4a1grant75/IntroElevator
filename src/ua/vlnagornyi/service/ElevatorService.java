package ua.vlnagornyi.service;

import ua.vlnagornyi.entity.Elevator;
import ua.vlnagornyi.entity.Floor;
import ua.vlnagornyi.entity.Passenger;

import java.util.List;
import java.util.stream.Collectors;

public class ElevatorService {

    private static final int MAX_ELEVATOR_CAPACITY = 5;

    private Elevator elevator;
    private int nextFloor;

    public ElevatorService(Elevator elevator, int nextFloor) {
        this.elevator = elevator;
        this.nextFloor = nextFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public Floor moveTo (Floor floor){
        System.out.println("before stop");
        printElevator();
        elevator.setCurrentFloor(floor.getNumber());
        elevator.setPassengers(dropOffPassengers());
        List<Passenger> extraPassenger = pickUpPassengers(floor.getPassengers());
        floor.setPassengers(extraPassenger);
        calculateNextFloor();
        System.out.println("after stop");
        printElevator();
        return floor;
    }

    public List<Passenger> pickUpPassengers (List<Passenger> newPassengers){
        List<Passenger> currentPassengers = elevator.getPassengers();
        if (currentPassengers.size() < MAX_ELEVATOR_CAPACITY){
            int freeSpace = MAX_ELEVATOR_CAPACITY - currentPassengers.size();

            currentPassengers.addAll(newPassengers.subList(0, Math.min(newPassengers.size(), freeSpace)));
            newPassengers.removeAll(newPassengers.subList(0, Math.min(newPassengers.size(), freeSpace)));
        }
        return newPassengers;
    }

    public List<Passenger> dropOffPassengers(){
        List<Passenger> passengers = elevator.getPassengers();
        return passengers.stream()
                .filter(passenger -> passenger.getTargetFloor() != elevator.getCurrentFloor())
                .collect(Collectors.toList());
    }

    public void calculateNextFloor() {
        List<Passenger> passengers = elevator.getPassengers();
        int maxFloor = 0;
        for (Passenger p : passengers) {
            maxFloor = Math.max(p.getTargetFloor(), maxFloor);
        }
        if (maxFloor > elevator.getCurrentFloor()) {
            nextFloor = nextFloor + 1;
        } else {
            nextFloor = nextFloor - 1;
        }
    }

    public void printElevator(){
        System.out.println("-----------------------");
        System.out.println(elevator);
        System.out.println("-----------------------");
    }
}
