package classes.car_salesman;

public class Car {
    private String model;
    private Engine engine;
    private Double weght;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Car(String model, Engine engine, Double weght, String color) {
        this.model = model;
        this.engine = engine;
        this.weght = weght;
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Double getWeght() {
        return weght;
    }

    public void setWeght(Double weght) {
        this.weght = weght;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    public Car(String model, Engine engine) {
        this.engine = engine;
        this.model = model;
        this.weght = null;
        this.color = null;
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s:\nPower: %d\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s" ,
                model,
                engine.getModel(),
                engine.getPower().intValue(),
                engine.getDisplacement() == null ? "n/a" : engine.getDisplacement().intValue(),
                engine.getEfficiency() == null ? "n/a" : engine.getEfficiency(),
                weght == null ? "n/a": weght.intValue(),
                color == null ? "n/a" : color);
    }
}
