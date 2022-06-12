package classes.raw_data;

public class Cargo {

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    private double cargoWeight;
    private String cargoType;
    public Cargo(double cargoWeight, String cargoType) {
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
    }
}
