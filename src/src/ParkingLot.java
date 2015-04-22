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
        checkIfSpaceIsAvailable();
        parkedCars.put(car.getregistrationNumber(),car);
        notifyListenersIfFull();
        return car.getregistrationNumber();

    }

    private void notifyListenersIfFull() {
        if (isFull()) {
            setChanged();
            notifyObservers("Parking Lot Full");
        }
    }

    private void checkIfSpaceIsAvailable() throws Exception {
        if (isFull()) {
           throw new Exception();
        }
    }


    public Car unparkCar(Integer ticket) throws Exception {

        notifyListenersIfSpaceAvailable();

        validate(ticket);
        Car car=parkedCars.get(ticket);
        parkedCars.remove(ticket);

        return car;

    }

    private void notifyListenersIfSpaceAvailable() {
        if(isFull()){
            setChanged();
            notifyObservers("Parking Lot is now available");
        }
    }

    public boolean isFull(){
        if(parkedCars.size()==this.size){
            return true;
        }
        return false;
    }
}