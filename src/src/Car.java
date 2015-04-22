/**
 * Created by Jerry on 21-04-2015.
 */
public class Car {

    private final int registrationNumber;

    public Car(int registrationNumber) throws Exception {

        validateCarId(registrationNumber);
        this.registrationNumber = registrationNumber;
    }

    private void validateCarId(int registrationNumber) throws Exception {
        if(registrationNumber<=0){
            throw new Exception("Invalid registrationNumber");
        }
    }


    public int getregistrationNumber(){
        return this.registrationNumber;
    }



}
