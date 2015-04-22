import java.util.HashMap;

/**
 * Created by Jerry on 21-04-2015.
 */
public class ParkingLot {

    private final int size;
       private HashMap<Integer,Car> parkedCars;

    public ParkingLot(int size) throws Exception {
        validate(size);
        this.size = size;
         parkedCars=new HashMap<Integer, Car>();
    }

    private void validate(Integer size) throws Exception {
        if (size == null ||  size <= 0) {
            throw new Exception("");
        }
    }


    public Integer parkCar(Car car) throws Exception {

        if (isFull()) {
            throw new Exception("Unable To Park");
             }

        parkedCars.put(car.getregistrationNumber(),car);
        return car.getregistrationNumber();

    }




    public Car unparkCar(Integer ticket) throws Exception {

        validate(ticket);
        Car car=parkedCars.get(ticket);
        parkedCars.remove(ticket);
        return car;

    }

    public boolean isFull(){
        if(parkedCars.size()==this.size){
            return true;
        }
        return false;
    }
}