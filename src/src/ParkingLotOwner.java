import exception.OwnerWithoutNameException;
import observers.ParkingLotOwnerObserver;

public class ParkingLotOwner implements ParkingLotOwnerObserver {

    private final String name;

    ParkingLotOwner(String name) throws Exception {

        if (name == null) {
            throw new OwnerWithoutNameException("Owner with No Name");
        }
        this.name = name;
    }

    @Override
    public void updateWhenParkingLotIsFull() {

    }

    @Override
    public void updateWhenParkingLotIsAvailable() {

    }
}