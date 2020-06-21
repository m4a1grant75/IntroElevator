package ua.vlnagornyi;

import ua.vlnagornyi.entity.Elevator;
import ua.vlnagornyi.entity.Floor;
import ua.vlnagornyi.service.ElevatorService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Floor> building = InitializerUtil.createFloors();
        int amountOfPassengers = building.stream()
                .mapToInt(value -> value.getPassengers().size())
                .sum();
        ElevatorService service = new ElevatorService(
                Elevator.getInstance(0, new ArrayList<>()), building.size());
        int nextFloor = 0;
        while (building.size() > 0){

        }
    }
}
