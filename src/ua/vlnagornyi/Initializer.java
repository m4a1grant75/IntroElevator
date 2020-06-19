package ua.vlnagornyi;

import ua.vlnagornyi.entity.Floor;
import ua.vlnagornyi.entity.Passenger;

import java.util.ArrayList;
import java.util.List;

public class Initializer {

    private static int MAX_AMOUNT_OF_FLOORS = 20;
    private static int MIN_AMOUNT_OF_FLOORS = 5;
    private static int MAX_AMOUNT_OF_PASSENGERS = 10;

    public List<Floor> createFloors (){
        int amountOfFloors = MIN_AMOUNT_OF_FLOORS + (int)(Math.random() * MAX_AMOUNT_OF_FLOORS);
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < amountOfFloors; i++){
            int amountOfPassengers = (int) (Math.random() * MAX_AMOUNT_OF_PASSENGERS);
            Floor tempFloor = new Floor(i,createPassengers(amountOfPassengers, i, amountOfFloors));
            floors.add(tempFloor);
        }
        return floors;
    }

    private List<Passenger> createPassengers(int amountOfPassengers, int currentFloor, int amountOfFloors){
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < amountOfPassengers; i++) {
            int targetFloor = defineTargetFloor(amountOfFloors, i);
            Passenger passenger = new Passenger(currentFloor, targetFloor);
            passengers.add(passenger);
        }
        return passengers;
    }

    private int defineTargetFloor(int amountOfFloors, int currentFloor) {
        int targetFloor;
        do {
            targetFloor = (int) (Math.random() * amountOfFloors);
        } while (targetFloor == currentFloor);
        return targetFloor;
    }
}
