import observers.FBIAgenetObserver;
import observers.ParkingLotOwnerObserver;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ParkingLotTest {

    @Test(expected = Exception.class)
    public void testParkingLotCreationForNegativeSize() throws Exception {
        ParkingLot parkingLot = new ParkingLot(-1);
    }

    @Test(expected = Exception.class)
    public void testParkingLotCreationForZeroSize() throws Exception {
        ParkingLot parkingLot = new ParkingLot(0);
    }

    @Test(expected = Exception.class)
    public void testParkCarWhenLocationIsNotAvailable() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car carA = new Car(1);
        Car carB = new Car(2);

        parkingLot.parkCar(carA);
        parkingLot.parkCar(carB);
    }

    @Test
    public void shouldBeAbleToUnParkCar() throws Exception {
        Car car = new Car(1);

        ParkingLot parkingLot = new ParkingLot(5);
        Integer ticket1 = parkingLot.parkCar(car);

        Car retrievedCar = parkingLot.unParkCar(ticket1);
        Assert.assertEquals(retrievedCar, car);
    }

    @Test
    public void shouldNotBeAbleToUnParkCarThatIsNotInParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5);
        Car retrievedCar = parkingLot.unParkCar(7);
        Assert.assertNull(retrievedCar);
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToUnParkCarWithNoTicket() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.unParkCar(null);
    }

    @Test
    public void parkingLotOwnerIsNotifiedWhenParkingIsFull() throws Exception {
        Car jaguar = new Car(1);
        Car audi = new Car(2);

        final ParkingLotOwnerObserver parkingLotOwnerObserver = mock(ParkingLotOwnerObserver.class);
        ParkingLot parkingLot = new ParkingLot(1);
        doNothing().when(parkingLotOwnerObserver).updateWhenParkingLotIsFull();
        parkingLot.attachParkingLotOwnerObserver(parkingLotOwnerObserver);
        parkingLot.parkCar(jaguar);

        verify(parkingLotOwnerObserver, times(1)).updateWhenParkingLotIsFull();
    }


    @Test
    public void parkingLotOwnerIsNotifiedWhenParkingSpaceIsAvailableAgain() throws Exception {
        Car jaguar = new Car(1);
        Car audi = new Car(2);

        final ParkingLotOwnerObserver parkingLotOwnerObserver = mock(ParkingLotOwnerObserver.class);
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.attachParkingLotOwnerObserver(parkingLotOwnerObserver);
        int ticket = parkingLot.parkCar(jaguar);
        parkingLot.parkCar(audi);
        parkingLot.unParkCar(ticket);
        verify(parkingLotOwnerObserver, times(1)).updateWhenParkingLotIsAvailable();
    }

    @Test
    public void fbiAgentIsNotifiedWhenParkingSpaceIs80PercentFull() throws Exception {
        Car jaguar = new Car(1);
        Car audi = new Car(2);
        Car bmw = new Car(3);
        Car benz = new Car(4);

        FBIAgenetObserver fbiAgenetObservert = mock(FBIAgenetObserver.class);
        ParkingLot parkingLot = new ParkingLot(5);

        parkingLot.attachFBIAgentObserver(fbiAgenetObservert);
        parkingLot.parkCar(jaguar);
        parkingLot.parkCar(audi);
        parkingLot.parkCar(bmw);
        parkingLot.parkCar(benz);

        verify(fbiAgenetObservert, times(1)).updateWhenSpaceIs80PercentFull();
    }



}
