import java.util.List;

public class NormalParkingStrategy implements ParkingLotStrategy{
    public ParkingLot findParkingLot(List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isParkingSpaceFull()) {
                return parkingLot;
            }
        }
        return null;
    }
}
