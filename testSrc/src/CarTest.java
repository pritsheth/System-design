
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jerry on 21-04-2015.
 */
public class CarTest {

    @Test(expected = Exception.class)
    public void testCarForNegativeRegistrationId()throws Exception{
        Car car = new Car(-1);
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToCreateCarWithInvalidRegistrationId()throws Exception{
        Car car = new Car(0);
    }

  @Test
  public void shouldCreateCarWithValidRegistrationId()throws Exception{
      Car car = new Car(2);
      Assert.assertNotNull(car);

  }

    @Test
    public void shouldGetSameRegistrationIdOfCreatedCar()throws Exception{
        Car car = new Car(2);
        Assert.assertEquals(car.getregistrationNumber(),2);

    }





}
