import exception.CarNotValidException;
import exception.ParkingNotFoundException;
import exception.TravellerNotValidException;

public class Traveller {

    private final int id;
    private final Car car;
    private Integer ticket;

    public Traveller(int id, Car car) throws Exception {
        validateTravellerId(id);
        validateCar(car);
        this.id = id;
        this.car = car;
    }

    private void validateCar(Car car) throws Exception {
        if (car == null) {
            throw new CarNotValidException("Car IS Not Found");
        }
    }

    private void validateTravellerId(int id) throws Exception {
        if (id <= 0) {
            throw new TravellerNotValidException("Invalid Id");
        }
    }


    public Boolean parkMyCar(ParkingAttendant parkingAttendant) {
        try {
            ParkingLot parkingLot = parkingAttendant.findParkingLot();

            if (parkingLot == null) {
                throw new ParkingNotFoundException("All ParkingLots are Full");
            }
            this.ticket = parkingLot.parkCar(this.car);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public Car retrieveCar(ParkingLot parkingLot) {

        try {
            return parkingLot.unParkCar(this.ticket);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return null;

        }


    }

}
