import exception.ParkingNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingAttendant {

    private List<ParkingLot> parkingLots;
    private ParkingLotStrategy parkingLotStrategy;


    public ParkingAttendant(ArrayList<ParkingLot> parkingLots) throws Exception {
        if (parkingLots == null) {
            throw new ParkingNotFoundException("Attendant don't have parking lot");
        }
        this.parkingLots = parkingLots;
    }

    public ParkingLot findParkingLot() {
        return parkingLotStrategy.findParkingLot(parkingLots);
    }

    public void setParkingLotStrategy(ParkingLotStrategy parkingLotStrategy) {
        this.parkingLotStrategy = parkingLotStrategy;
    }

    public Car findCarForParticularTicket(Integer ticket) throws Exception {
        for (ParkingLot parkingLot : parkingLots) {
            HashMap<Integer, Car> parkedCar = parkingLot.getParkedCars();
            if (parkedCar.containsKey(ticket)) {
                return parkingLot.unParkCar(ticket);
            }
        }
        return null;
    }


    private ParkingLot findParkingLotWithMaximumSize() {
        Integer maximum = Integer.MIN_VALUE;
        ParkingLot parkingLotResult = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (maximum < parkingLot.getSize() && !parkingLot.isParkingSpaceFull()) {
                parkingLotResult = parkingLot;
                maximum = parkingLot.getSize();
            }

        }
        System.out.println(parkingLotResult.getSize());
        return parkingLotResult;

    }




}

