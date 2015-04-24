import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TravellerTest {


    @Test(expected = Exception.class)
    public void shouldNotBeAbleToCreateTravellerForNegativeId() throws Exception {
        Car car = new Car(1);
        Traveller traveller = new Traveller(-1, car);
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToCreateTravellerForInvalidId() throws Exception {
        Car car = new Car(1);
        Traveller traveller = new Traveller(0, car);
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToCreateTravellerWithNoCar() throws Exception {
        Car car = null;
        Traveller traveller = new Traveller(1, car);
    }

    @Test
    public void shouldBeAbleToParkMyCar() throws Exception {
        Car car = new Car(1);
        Traveller traveller = new Traveller(1, car);
        ParkingLot parkingLot = new ParkingLot(5);

        ParkingAttendant parkingAttendant = mock(ParkingAttendant.class);
        when(parkingAttendant.findParkingLot()).thenReturn(parkingLot);

        assertTrue(traveller.parkMyCar(parkingAttendant));
        verify(parkingAttendant).findParkingLot();
    }


    @Test
    public void shouldBeNotifiedIfCarIsNotParked() throws Exception {

        Car car = new Car(1);
        Traveller traveller = new Traveller(1, car);
        ParkingLot parkingLot = new ParkingLot(1);

        ParkingAttendant parkingAttendant = mock(ParkingAttendant.class);
        when(parkingAttendant.findParkingLot()).thenReturn(parkingLot);

        traveller.parkMyCar(parkingAttendant);
        Car carA = new Car(2);
        Traveller travellerA = new Traveller(2, carA);

        Assert.assertFalse(travellerA.parkMyCar(parkingAttendant));
        verify(parkingAttendant, times(2)).findParkingLot();
    }


    @Test
    public void shouldBeAbleToRetrieveMyCar() throws Exception {
        Car car = new Car(1);
        Traveller traveller = new Traveller(1, car);
        ParkingLot parkingLot = new ParkingLot(5);

        ParkingAttendant parkingAttendant = mock(ParkingAttendant.class);
        when(parkingAttendant.findParkingLot()).thenReturn(parkingLot);

        traveller.parkMyCar(parkingAttendant);
        Car carA = traveller.retrieveCar(parkingLot);
        assertEquals(carA, car);
        verify(parkingAttendant).findParkingLot();
    }

    @Test
    public void shouldNotBeAbleToRetrieveCarFromParkingLotWhenNoTicket() throws Exception {
        Car car = new Car(1);
        Traveller traveller = new Traveller(1, car);
        ParkingLot parkingLot = new ParkingLot(5);
        Assert.assertNull(traveller.retrieveCar(parkingLot));

    }


}



