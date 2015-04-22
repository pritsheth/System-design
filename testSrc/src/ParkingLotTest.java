import org.junit.Assert;
import org.junit.Test;


import java.util.Observable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by Jerry on 21-04-2015.
 */
public class ParkingLotTest {

    @Test(expected = Exception.class)
    public void testParkingLotCreationForNegativeSize()throws Exception{
        ParkingLot parkingLot=new ParkingLot(-1);
    }

    @Test(expected = Exception.class)
    public void testParkingLotCreationForZeroSize()throws Exception{
        ParkingLot parkingLot=new ParkingLot(0);
    }




     @Test(expected = Exception.class)
    public void testParkCarWhenLocationIsNotAvailable() throws Exception {

        ParkingLot parkingLot=new ParkingLot(1);
        Car carA=new Car(1);
        Car carB=new Car(2);

        parkingLot.parkCar(carA);
        parkingLot.parkCar(carB);


    }

    @Test
    public void shouldBeAbleToUnParkCar()throws Exception{
        Car car=new Car(1);

        ParkingLot parkingLot = new ParkingLot(5);
        Integer ticket1 = parkingLot.parkCar(car);

        Car retrievedCar = parkingLot.unparkCar(ticket1);
         Assert.assertEquals(retrievedCar, car);
    }

    @Test
    public void shouldNotBeAbleToUnParkCarThatIsNotInParkingLot()throws Exception{
        ParkingLot parkingLot = new ParkingLot(5);
        Car retrievedCar = parkingLot.unparkCar(7);
        Assert.assertNull(retrievedCar);
    }


    @Test(expected = Exception.class)
    public void shouldNotBeAbleToUnParkCarWithNoTicket()throws Exception{
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.unparkCar(null);

    }


    @Test(expected = Exception.class)
    public void shouldNotBeAbleToParkCarWhenParkingLotIsFull()throws Exception{
        ParkingLot parkingLot = new ParkingLot(1);
        Car carA=new Car(1);
        Car carB=new Car(2);
        parkingLot.parkCar(carA);
        parkingLot.parkCar(carB);

    }


    @Test
    public void parkingLotOwnerIsNotifiedWhenParkingIsFull()throws Exception{
        Car jaguar=new Car(1);
        Car audi=new Car(2);

        final ParkingLotOwner parkingLotOwner = mock(ParkingLotOwner.class);
        ParkingLot parkingLot=new ParkingLot(1);
        doNothing().when(parkingLotOwner).update(parkingLot, "Parking Lot Full");
        parkingLot.addObserver(parkingLotOwner);
        parkingLot.parkCar(jaguar);
        verify(parkingLotOwner,times(1)).update(parkingLot, "Parking Lot Full");

    }



    @Test
    public void parkingLotOwnerIsNotifiedWhenParkingSpaceIsAvailableAgain()throws Exception{
        Car jaguar=new Car(1);
        Car audi=new Car(2);

        final ParkingLotOwner parkingLotOwner = mock(ParkingLotOwner.class);
        ParkingLot parkingLot=new ParkingLot(2);
//        doNothing().when(parkingLotOwner).update(any(Observable.class), anyString());
        parkingLot.addObserver(parkingLotOwner);
        int ticket= parkingLot.parkCar(jaguar);
        parkingLot.parkCar(audi);
        parkingLot.unparkCar(ticket);
        verify(parkingLotOwner,times(1)).update(parkingLot, "Parking Lot is now available");

    }















}
