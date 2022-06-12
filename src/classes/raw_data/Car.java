package classes.raw_data;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model) {
        this.model = model;
        this.tires = new ArrayList<>();
    }

    public boolean isHaveTyreWithLowPressure() {
        for (Tire tire : tires) {
            if(tire.getTirePressure() < 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return model;
    }
}
