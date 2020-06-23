package ua.vlnagornyi;

import ua.vlnagornyi.entity.Elevator;
import ua.vlnagornyi.entity.Floor;
import ua.vlnagornyi.service.ElevatorService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Floor> building = InitializerUtil.createFloors();
        ElevatorService service = new ElevatorService(Elevator.getInstance(0, new ArrayList<>()), 0);
        do {
            int nextFloor = service.getNextFloor();
            if (nextFloor < 0){
                continue;
            }
            Floor floorAfterMove = service.moveTo(building.get(nextFloor));
            building.set(nextFloor, floorAfterMove);
            System.out.println(building);
        }while (checkBuilding(building));
    }

    private static boolean checkBuilding(List<Floor> building){
        int amountOfPassengers = building.stream()
                .mapToInt(value -> value.getPassengers().size())
                .sum();
        return amountOfPassengers > 0;
    }
}
