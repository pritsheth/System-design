/**
 * Created by Jerry on 21-04-2015.
 */
public class Car {

    private final int id;

    public Car(int id) throws Exception {

        validateCarId(id);
        this.id=id;
    }

    private void validateCarId(int id) throws Exception {
        if(id<=0){
            throw new Exception("Invalid Id");
        }
    }




}
