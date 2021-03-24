class ParkingSystem {

    private int[] locs;

    public ParkingSystem(int big, int medium, int small) {
        locs = new int[3];
        locs[0] = big;
        locs[1] = medium;
        locs[2] = small;
    }

    public boolean addCar(int carType) {
        if (locs[carType] >= 1) {
            locs[carType] -= 1;
            return true;
        }
        else {
            return false;
        }
    }
}
public class Prob1603 {
}


