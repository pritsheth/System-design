import java.util.*;

/**
 * Created by Jerry on 21-04-2015.
 */
public class ParkingLot extends Observable{

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

   /* private void validateNull(Object... elements) throws Exception {
       for (Object obj:elements){
           if(obj==null){
               throw new Exception("");
           }
       }

    }
*/

    public Integer parkCar(Car car) throws Exception {
        if (isFull()) {
           throw new Exception();
        }
         parkedCars.put(car.getregistrationNumber(),car);
        if (isFull()) {
            setChanged();
            notifyObservers("Parking Lot Full");
        }
        return car.getregistrationNumber();

    }


    public Car unparkCar(Integer ticket) throws Exception {

        if(isFull()){
            setChanged();
            notifyObservers("Parking Lot is now available");
        }

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