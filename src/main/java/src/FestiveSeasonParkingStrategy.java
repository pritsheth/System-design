import java.util.List;

public class FestiveSeasonParkingStrategy implements ParkingLotStrategy{

    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {

        Integer maximum=Integer.MIN_VALUE;
        ParkingLot parkingLotResult=null;
        for (ParkingLot parkingLot : parkingLots) {
            if(maximum < parkingLot.getSize() && !parkingLot.isParkingSpaceFull()){
                parkingLotResult=parkingLot;
                maximum=parkingLot.getSize();
            }
        }
        return parkingLotResult;
    }
}
