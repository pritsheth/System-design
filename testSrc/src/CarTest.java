import org.junit.Test;

/**
 * Created by Jerry on 21-04-2015.
 */
public class CarTest {

    @Test(expected = Exception.class)
    public void testTravellerForNegativeId()throws Exception{
        Car car = new Car(-1);
    }

    @Test(expected = Exception.class)
    public void testTravellerForZeroId()throws Exception{
        Car car = new Car(0);
    }

    


}
