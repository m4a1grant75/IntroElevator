package ua.vlnagornyi.entity;

public class Elevator {
    private static final int MAX_CAPACITY = 5;
    private static Elevator elevator;

    private int amountOfPassenger;
    private int currentFloor;
    private int nextFloor;

    private Elevator(int amountOfPassenger, int currentFloor, int nextFloor) {
        this.amountOfPassenger = amountOfPassenger;
        this.currentFloor = currentFloor;
        this.nextFloor = nextFloor;
    }

    public Elevator getElevator(int amountOfPassenger, int currentFloor){
        if (elevator == null){
            elevator = new Elevator(amountOfPassenger, currentFloor, 0);
        }
        return elevator;
    }

    public int getAmountOfPassenger() {
        return amountOfPassenger;
    }

    public void setAmountOfPassenger(int amountOfPassenger) {
        this.amountOfPassenger = amountOfPassenger;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }
}
