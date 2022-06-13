package classes.google;

public class Children {
    private String childName;
    private String childBirthDay;

    public Children(String childName, String childBirthDay) {
        this.childName = childName;
        this.childBirthDay = childBirthDay;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildBirthDay() {
        return childBirthDay;
    }

    public void setChildBirthDay(String childBirthDay) {
        this.childBirthDay = childBirthDay;
    }

    @Override
    public String toString() {
        return this.childName + " " + this.childBirthDay;
    }
}
