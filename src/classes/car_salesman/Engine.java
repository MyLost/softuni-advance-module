package classes.car_salesman;

public class Engine {

    private String model;
    private Double power;
    private Double displacement;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    private String efficiency;

    public Engine(String model, Double power, Double displacement, String efficiency) {
        this.model = model;
        this.power =  power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

}
