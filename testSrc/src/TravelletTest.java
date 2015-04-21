import org.junit.Test;

/**
 * Created by Jerry on 21-04-2015.
 */
public class TravelletTest {


    @Test(expected = Exception.class)
    public void testTravellerForNegativeId()throws Exception{
        Car car=new Car(1);
        Traveller traveller = new Traveller(-1,car);
    }

    @Test(expected = Exception.class)
    public void testTravellerForZeroId()throws Exception{
        Car car=new Car(1);
        Traveller traveller = new Traveller(0,car);
    }

    @Test(expected = Exception.class)
    public void testTravellerForNullCar()throws Exception{
        Car car=null;
        Traveller traveller = new Traveller(1,car);
    }






}



