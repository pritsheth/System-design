import exception.OwnerWithoutNameException;
import observers.ParkingLotOwnerObserver;

public class ParkingLotOwner implements ParkingLotOwnerObserver {

    private final String name;
private ParkingAttendant parkingAttendant;

    ParkingLotOwner(String name) throws Exception {

        if (name == null) {
            throw new OwnerWithoutNameException("Owner with No Name");
        }
        this.name = name;
    }

    public void updateWhenParkingLotIsFull() {

    }


    public void updateWhenParkingLotIsAvailable() {

    }

    public void setParkingAttendant(ParkingAttendant parkingAttendant) {
        this.parkingAttendant = parkingAttendant;
    }

    public void updateParkingStrategy(ParkingLotStrategy parkingLotStrategy){
        parkingAttendant.setParkingLotStrategy(parkingLotStrategy);
    }



}