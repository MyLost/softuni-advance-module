package classes.raw_data;

public class Engine {

    public double getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(double engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    private double engineSpeed;
    private double enginePower;
    public Engine(double engineSpeed, double enginePower) {
        this.enginePower = enginePower;
        this.engineSpeed = engineSpeed;
    }
}
