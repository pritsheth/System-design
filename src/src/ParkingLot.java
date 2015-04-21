/**
 * Created by Jerry on 21-04-2015.
 */
public class ParkingLot {

    private final int size;
    private final boolean[] occupiedParkingSlots;

    public ParkingLot(int size) throws Exception {
        validateParkingLotSize(size);
        this.size = size;
        this.occupiedParkingSlots = new boolean[size];
    }

    private void validateParkingLotSize(int size) throws Exception {
        if (size <= 0) {
            throw new Exception("");
        }
    }


    public boolean parkCar(Car car) {
        int freeSlot = getNextFreeSlot();
        if (freeSlot > -1) {
            occupiedParkingSlots[freeSlot] = true;
            return true;
        }
        return false;


    }

    private int getNextFreeSlot() {
        int freeSlot = -1;
        for (int slot = 0; slot < size; slot++) {
            if (occupiedParkingSlots[slot] == false) {
                freeSlot = slot;
                break;
            }
        }
        return freeSlot;
    }


}