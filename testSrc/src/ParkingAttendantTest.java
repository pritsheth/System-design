import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParkingAttendantTest {

    @Test(expected = Exception.class)
    public void parkingAttendantShouldHaveParkingLot() throws Exception {

        ParkingAttendant parkingAttendant = new ParkingAttendant(null);
    }

    @Test
    public void findParkingLotWhichHasSpaceTest() throws Exception {

        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        ParkingLot parkingLotResult = parkingAttendant.findParkingLot();
        assertEquals(parkingLotResult, parkingLotA);

    }

    @Test
    public void checkIfAllLotsAreFull() throws Exception {
        ParkingLot parkingLotA = new ParkingLot(1);
        Car car = new Car(2);
        parkingLotA.parkCar(car);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLotA);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        ParkingLot parkingLotResult = parkingAttendant.findParkingLot();
        assertNull(parkingLotResult);
    }

}