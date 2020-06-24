package ua.vlnagornyi.service;

import org.junit.Before;
import org.junit.Test;
import ua.vlnagornyi.InitializerUtil;
import ua.vlnagornyi.entity.Elevator;
import ua.vlnagornyi.entity.Floor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ElevatorServiceTest {

    ElevatorService elevatorService;

    @Before
    public void setUp() {
        elevatorService = new ElevatorService(Elevator.getInstance(0, new ArrayList<>()));
    }

    @Test
    public void startElevator() {
        List<Floor> building = InitializerUtil.createFloors();
        elevatorService.startElevator(building);
        int amountOfPassengers = building.stream()
                .mapToInt(value -> value.getPassengers().size())
                .sum();
        assertEquals(0, amountOfPassengers);
    }

}