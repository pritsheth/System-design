import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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




    @Test
    public void testParkCarWhenLocationIsAvailable() throws Exception {

        ParkingLot parkingLot=new ParkingLot(10);
        Car car=new Car(1);
        boolean success=parkingLot.parkCar(car);
        assertEquals(success,true);

    }


    @Test
    public void testParkCarWhenLocationIsNotAvailable() throws Exception {

        ParkingLot parkingLot=new ParkingLot(1);
        Car carA=new Car(1);
        Car carB=new Car(2);

        parkingLot.parkCar(carA);
        boolean success = parkingLot.parkCar(carB);

        assertFalse(success);
    }





}
