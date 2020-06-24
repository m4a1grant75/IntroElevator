package ua.vlnagornyi;

import ua.vlnagornyi.entity.Elevator;
import ua.vlnagornyi.service.ElevatorService;
import ua.vlnagornyi.entity.Floor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Floor> building = InitializerUtil.createFloors();
        Elevator elevator = Elevator.getInstance(0, new ArrayList<>());
        ElevatorService service = new ElevatorService(elevator);
        service.startElevator(building);
    }
}
