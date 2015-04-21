/**
 * Created by Jerry on 21-04-2015.
 */
public class Traveller {

    private final int id;
    private final Car car;

    public Traveller(int id,Car car) throws Exception {

        validateTravellerId(id);
        validateCar(car);
        this.id=id;
        this.car = car;
    }

    private void validateCar(Car car) throws Exception {
        if(car == null){
            throw new Exception("");
        }
    }

    private void validateTravellerId(int id) throws Exception {
        if(id<=0){
            throw new Exception("Invalid Id");
        }
    }





}
