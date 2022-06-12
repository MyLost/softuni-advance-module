package classes.speed_racing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostForOneKm;
    private int traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostForOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKm = fuelCostForOneKm;
        traveledDistance =0;
    }

    public void travel(int distanceForTraveled) {
        double needFuelForTravelDistance = distanceForTraveled * fuelCostForOneKm;
        if (needFuelForTravelDistance <= fuelAmount) {
            fuelAmount = fuelAmount - needFuelForTravelDistance;
            traveledDistance += distanceForTraveled;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, traveledDistance);
    }
}
