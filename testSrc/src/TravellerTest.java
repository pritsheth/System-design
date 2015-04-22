import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jerry on 21-04-2015.
 */
public class TravellerTest {


    @Test(expected = Exception.class)
    public void shouldNotBeAbleToCreateTravellerForNegativeId()throws Exception{
        Car car=new Car(1);
        Traveller traveller = new Traveller(-1,car);
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToCreateTravellerForInvalidId()throws Exception{
        Car car=new Car(1);
        Traveller traveller = new Traveller(0,car);
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToCreateTravellerWithNoCar()throws Exception{
        Car car=null;
        Traveller traveller = new Traveller(1,car);
    }

    @Test
    public void shouldBeAbleToParkMyCar()throws Exception{
        Car car=new Car(1);
        Traveller traveller = new Traveller(1,car);
        ParkingLot parkingLot = new ParkingLot(5);
        Assert.assertTrue(traveller.parkMyCar(parkingLot));
    }


    @Test
    public void shouldBeNotifiedIfCarIsNotParked()throws Exception{

        Car car=new Car(1);
        Traveller traveller = new Traveller(1,car);
        ParkingLot parkingLot = new ParkingLot(1);
        traveller.parkMyCar(parkingLot);
        Car carA=new Car(2);
        Traveller travellerA = new Traveller(2,carA);

        Assert.assertFalse(travellerA.parkMyCar(parkingLot));
    }



       @Test
    public void shouldBeAbleToRetrieveMyCar()throws Exception{
        Car car=new Car(1);
        Traveller traveller = new Traveller(1,car);
        ParkingLot parkingLot = new ParkingLot(5);
        traveller.parkMyCar(parkingLot);
        Car carA=traveller.retrieveCar(parkingLot);
        Assert.assertEquals(carA, car);
    }


    @Test
    public void shouldNotBeAbleToRetrieveCarFromParkingLotWhenNoTicket()throws Exception{
        Car car=new Car(1);
        Traveller traveller = new Traveller(1,car);
        ParkingLot parkingLot = new ParkingLot(5);
        Assert.assertNull(traveller.retrieveCar(parkingLot));

    }





}



