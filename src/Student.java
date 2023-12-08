import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Boolean> taskResults;

    public Student(String name) {
        this.name = name;
        this.taskResults = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTaskResult(boolean isPassed) {
        taskResults.add(isPassed);
    }

    public List<Boolean> getTaskResults() {
        return taskResults;
    }
}