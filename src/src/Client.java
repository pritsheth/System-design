/**
 * Created by Jerry on 21-04-2015.
 */
public class Client {

    public static void main(String args[]) throws Exception {


        Car jaguar=new Car(1);
        Car audi=new Car(2);
        ParkingLot parkingLot=new ParkingLot(1);

        ParkingLotOwner owner=new ParkingLotOwner("ritesh");
        parkingLot.addObserver(owner);

        parkingLot.parkCar(jaguar);
        parkingLot.parkCar(audi);


    }

}
