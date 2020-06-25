package ua.vlnagornyi.service;

import ua.vlnagornyi.entity.Passenger;
import ua.vlnagornyi.entity.Elevator;
import ua.vlnagornyi.entity.Floor;

import java.util.List;
import java.util.stream.Collectors;

public class ElevatorService {

    private static final int MAX_ELEVATOR_CAPACITY = 5;

    private Elevator elevator;

    public ElevatorService(Elevator elevator) {
        this.elevator = elevator;
    }

    public void startElevator(List<Floor> building){
        int nextFloor = 0;
        do {
            Floor floorAfterMove = moveTo(building.get(nextFloor));
            building.set(nextFloor, floorAfterMove);
            nextFloor = calculateNextFloor(building);
            printElevator(building);
        }while (checkBuilding(building));
    }

    public boolean checkBuilding(List<Floor> building){
        int amountOfPassengers = building.stream()
                .mapToInt(value -> value.getPassengers().size())
                .sum();
        amountOfPassengers += elevator.getPassengers().size();
        System.out.println("Passengers left: " + amountOfPassengers);
        return amountOfPassengers != 0;
    }

    private Floor moveTo (Floor floor){
        elevator.setCurrentFloor(floor.getNumber());
        elevator.setPassengers(dropOffPassengers());
        List<Passenger> extraPassenger = pickUpPassengers(floor.getPassengers());
        floor.setPassengers(extraPassenger);
        return floor;
    }

    private List<Passenger> pickUpPassengers (List<Passenger> newPassengers){
        List<Passenger> currentPassengers = elevator.getPassengers();
        if (currentPassengers.size() < MAX_ELEVATOR_CAPACITY){
            int freeSpace = MAX_ELEVATOR_CAPACITY - currentPassengers.size();
            List<Passenger> gettingInPassangers = newPassengers.subList(0, Math.min(newPassengers.size(), freeSpace));
            currentPassengers.addAll(gettingInPassangers);
            newPassengers.removeAll(gettingInPassangers);
        }
        return newPassengers;
    }

    private List<Passenger> dropOffPassengers(){                                                                        //press "f" to pay respect
        List<Passenger> passengers = elevator.getPassengers();
        return passengers.stream()
                .filter(passenger -> passenger.getTargetFloor() != elevator.getCurrentFloor())
                .collect(Collectors.toList());
    }

    //если пассажиров нет, возвращаем первый этаж с пассажирами или 0
    //иначе - максимальный этаж, нужный пассажирам. так мы точно приедем туда, куда нужно хотя бы одному из пассажиров
    //такая стратегия мне кажется более выгодной, так как мы не тратим итерации на пустые этажи и этажи, на которые пассажирам не надо
    private int calculateNextFloor(List<Floor> building) {
        List<Passenger> passengers = elevator.getPassengers();
        int maxFloor = 0;
        if (passengers.isEmpty()){
            return  building.stream()
                    .filter(f -> !f.getPassengers().isEmpty())
                    .findFirst()
                    .map(Floor::getNumber)
                    .orElse(0);
        } else {
            for (Passenger p : passengers) {
                maxFloor = Math.max(p.getTargetFloor(), maxFloor);
            }
            return maxFloor;
        }
    }

    private void printElevator(List<Floor> building){
        for (Floor floor : building){
            if (floor.getNumber() == elevator.getCurrentFloor()){
                System.out.printf("---------------------- Current floor: %d ------------------------\n", elevator.getCurrentFloor());
                System.out.println("Floor: " + floor.getPassengers() + "  |  Elevator: " + elevator.getPassengers());
            } else {
                System.out.printf("---------------------- floor: %d --------------------------------\n", floor.getNumber());
                System.out.println("Floor: " + floor.getPassengers());
            }
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("Step end");
    }
}
