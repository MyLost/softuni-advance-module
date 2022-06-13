package classes.google;

public class Car {
    private String carModel;
    private Integer carSpeed;

    public Car(String carModel, Integer carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(Integer carSpeed) {
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return this.carModel + " " + this.carSpeed;
    }
}
