package regular_exam_2022.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if(exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
       return exercises.remove(getExercise(name, muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise e : exercises) {
            if(e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                return e;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
       int mostBurnedCaloriesExercise = 0;
        Exercise exercise = null;
        for (Exercise e : exercises) {
            if(e.getBurnedCalories() > mostBurnedCaloriesExercise) {
                mostBurnedCaloriesExercise = e.getBurnedCalories();
                exercise = e;
            }
        }
        return exercise;
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: " + type + "\n");
        exercises.forEach(exercise -> sb.append("Exercise: " + exercise.getName() + ", " + exercise.getMuscle() + ", " + exercise.getBurnedCalories() + "\n" ));
        return sb.toString().trim();
    }
}
