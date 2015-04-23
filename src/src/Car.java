import exception.CarNotValidException;

public class Car {

    private final int registrationNumber;

    public Car(int registrationNumber) throws Exception {

        validateCarId(registrationNumber);
        this.registrationNumber = registrationNumber;
    }

    private void validateCarId(int registrationNumber) throws Exception {
        if (registrationNumber <= 0) {
            throw new CarNotValidException("Invalid registrationNumber");
        }
    }


    public int getRegistrationNumber() {
        return this.registrationNumber;
    }


}
