import exception.InvalidInputException;
import exception.NoSpaceAvailableException;
import observers.FBIAgenetObserver;
import observers.ParkingLotOwnerObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

    private static final Float percent = 0.8f;


    private final int size;


    private HashMap<Integer, Car> parkedCars;
    private List<ParkingLotOwnerObserver> parkingLotOwnerObservers;
    private List<FBIAgenetObserver> fbiAgenetObservers;

    public ParkingLot(int size) throws Exception {
        validateInput(size);
        this.size = size;
        parkedCars = new HashMap<Integer, Car>();
        parkingLotOwnerObservers = new ArrayList<ParkingLotOwnerObserver>();
        fbiAgenetObservers = new ArrayList<FBIAgenetObserver>();
    }





    private void validateInput(Integer size) throws Exception {
        if (size == null || size <= 0) {
            throw new InvalidInputException("Invalid Input");
        }
    }

    public Integer parkCar(Car car) throws Exception {
        checkIfSpaceIsAvailable();
        parkedCars.put(car.getRegistrationNumber(), car);
        notifyFbiAgentIfParkingLotIs80PercentFull();
        notifyParkingLotOwnerIfSpaceIsFull();
        return car.getRegistrationNumber();
    }

    public void attachParkingLotOwnerObserver(ParkingLotOwnerObserver parkingLotOwnerObserver) {
        parkingLotOwnerObservers.add(parkingLotOwnerObserver);
    }

    private void notifyFbiAgentIfParkingLotIs80PercentFull() {
        if (this.size * percent <= parkedCars.size()) {
            for (FBIAgenetObserver fbiAgenetObserver : fbiAgenetObservers) {
                fbiAgenetObserver.updateWhenSpaceIs80PercentFull();
            }
        }
    }

    private void notifyParkingLotOwnerIfSpaceIsFull() {
        if (isParkingSpaceFull()) {
            for (ParkingLotOwnerObserver parkingLotOwnerObserver : parkingLotOwnerObservers) {
                parkingLotOwnerObserver.updateWhenParkingLotIsFull();
            }
        }
    }

    private void checkIfSpaceIsAvailable() throws Exception {
        if (isParkingSpaceFull()) {
            throw new NoSpaceAvailableException("Parking Size is Full");
        }
    }


    public Car unParkCar(Integer ticket) throws Exception {

        validateInput(ticket);
        notifyParkingLotOwnerIfSpaceIsAvailableAgain();
        Car car = parkedCars.get(ticket);
        parkedCars.remove(ticket);

        return car;

    }

    private void notifyParkingLotOwnerIfSpaceIsAvailableAgain() {
        if (isParkingSpaceFull()) {
            for (ParkingLotOwnerObserver parkingLotOwnerObserver : parkingLotOwnerObservers) {
                parkingLotOwnerObserver.updateWhenParkingLotIsAvailable();
            }
        }
    }

    public boolean isParkingSpaceFull() {
        if (parkedCars.size() == this.size) {
            return true;
        }
        return false;
    }

    public void attachFBIAgentObserver(FBIAgenetObserver fbiAgenetObserver) {
        fbiAgenetObservers.add(fbiAgenetObserver);
    }

    public int getSize() {
        return size;
    }


    public HashMap<Integer, Car> getParkedCars() {
        return parkedCars;
    }

}