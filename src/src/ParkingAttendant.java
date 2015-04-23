import exception.ParkingNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ParkingAttendant {

    private List<ParkingLot> parkingLots;

    public ParkingAttendant(ArrayList<ParkingLot> parkingLots) throws Exception {
        if (parkingLots == null) {
            throw new ParkingNotFoundException("Attendant don't have parking lot");
        }
        this.parkingLots = parkingLots;
    }

    public ParkingLot findParkingLot() {

        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isParkingSpaceFull()) {
                return parkingLot;
            }

        }
        return null;
    }
}

