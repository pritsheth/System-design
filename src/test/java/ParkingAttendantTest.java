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
    public void findParkingLotForFestiveSeason() throws Exception {

        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(4);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner("amss");
        parkingLotOwner.updateParkingStrategy(new FestiveSeasonParkingStrategy());
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        ParkingLot parkingLot = parkingAttendant.findParkingLot();
        assertEquals(parkingLot, parkingLotB);
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



    @Test
    public void shouldFindCarForParticularTicket() throws Exception {
        ParkingLot parkingLotA = new ParkingLot(1);
        Car car = new Car(1);
       Integer ticket= parkingLotA.parkCar(car);

        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLotA);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);

       Car carA = parkingAttendant.findCarForParticularTicket(ticket);
       assertEquals(carA, car);
    }




}