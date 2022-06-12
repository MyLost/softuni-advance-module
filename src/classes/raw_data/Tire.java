package classes.raw_data;

public class Tire {

    public double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public double getTireAge() {
        return tireAge;
    }

    public void setTireAge(double tireAge) {
        this.tireAge = tireAge;
    }

    private double tirePressure;

    private double tireAge;
    public Tire(double tirePressure, double tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }
}
