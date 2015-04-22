/**
 * Created by Jerry on 21-04-2015.
 */
public class Traveller {

    private final int id;
    private final Car car;
    private Integer ticket;

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


    public Boolean parkMyCar(ParkingLot parkingLot) {


        try {
            this.ticket = parkingLot.parkCar(this.car);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public Car retrieveCar(ParkingLot parkingLot)  {

        try {
            return parkingLot.unparkCar(this.ticket);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return null;

        }


    }

}
