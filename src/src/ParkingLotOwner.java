import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jerry on 22-04-2015.
 */
public class ParkingLotOwner implements Observer {

    private final String name;

    ParkingLotOwner(String name) {
        this.name = name;

    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}