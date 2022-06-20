package classes.university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity, List<Student> students) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        String result = null;

        if(getStudentCount() >= capacity) {
            result  = "No seats in the university";
        }
        for (Student s : students) {
            if(getStudent(student.firstName, student.lastName) != null) {
                result = "Student is already in university";
                break;
            }
        }

        if(result == null) {
            students.add(student);
            result =  "Added student " + student.firstName + " " + student.lastName;
        }

        return  result;
    }

    public String dismissStudent(Student student) {

        if(getStudent(student.firstName, student.lastName) == null) {
            return  "Student not found";
        }
        this.students.remove(student);
        return "Removed student " + student.firstName + " " + student.lastName;
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student s : students) {
            if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }

    public String getStatistics() {
        return students.stream()
                .map(s -> String.format(
                        "==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                        s.getFirstName(), s.getLastName(), s.getBestSubject()
                        )).collect(Collectors.joining(System.lineSeparator()));
    }
}
