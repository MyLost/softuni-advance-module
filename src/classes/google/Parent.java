package classes.google;

public class Parent {
    private String parentName;
    private String parentBirthDay;

    public Parent(String parentName, String parentBirthDay) {
        this.parentName = parentName;
        this.parentBirthDay = parentBirthDay;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentBirthDay() {
        return parentBirthDay;
    }

    public void setParentBirthDay(String parentBirthDay) {
        this.parentBirthDay = parentBirthDay;
    }

    @Override
    public String toString() {
        return this.parentName + " " + this.parentBirthDay;
    }
}

