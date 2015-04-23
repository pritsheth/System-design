import org.junit.Test;

public class ParkingLotOwnerTest {

    @Test(expected = Exception.class)
    public void ownerHasNoName() throws Exception {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(null);
    }



}