/**
 * Created by Jerry on 21-04-2015.
 */
public class Client {

    public static void main(String args[]) throws Exception {


        Car jaguar = new Car(1);
        Car audi = new Car(2);
        ParkingLot parkingLot = new ParkingLot(2);

        ParkingLotOwner owner = new ParkingLotOwner("ritesh");
//       Traveller traveller=new Traveller(1);

        parkingLot.parkCar(jaguar);
        parkingLot.parkCar(audi);


    }

}
