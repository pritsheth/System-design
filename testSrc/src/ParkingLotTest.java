import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
        Integer ticket = parkingLot.parkCar(car);
        Car retrievedCar = parkingLot.unparkCar(ticket);
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








}
