import java.util.ArrayList;
import java.util.List;

public class Loginp3 {
    private List<String> developers;
    private List<String> taskNames;
    private List<String> taskIds;
    private List<Integer> taskDurations;
    private List<String> taskStatuses;

    public Loginp3() {
        developers = new ArrayList<>();
        taskNames = new ArrayList<>();
        taskIds = new ArrayList<>();
        taskDurations = new ArrayList<>();
        taskStatuses = new ArrayList<>();
    }

    public void addTask(String developer, String taskName, String taskId, int taskDuration, String taskStatus) {
        developers.add(developer);
        taskNames.add(taskName);
        taskIds.add(taskId);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
    }

    public void displayDoneTasks() {
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equals("done")) {
                System.out.println("Developer: " + developers.get(i));
                System.out.println("Task Name: " + taskNames.get(i));
                System.out.println("Task Duration: " + taskDurations.get(i));
                System.out.println();
            }
        }
    }

    public void displayLongestTask() {
        int maxDuration = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            System.out.println("Developer: " + developers.get(maxIndex));
            System.out.println("Task Duration: " + taskDurations.get(maxIndex));
        }
    }

    public void searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equals(taskName)) {
                System.out.println("Task Name: " + taskNames.get(i));
                System.out.println("Developer: " + developers.get(i));
                System.out.println("Task Status: " + taskStatuses.get(i));
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void searchTasksByDeveloper(String developer) {
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equals(developer)) {
                System.out.println("Task Name: " + taskNames.get(i));
                System.out.println("Task Status: " + taskStatuses.get(i));
                System.out.println();
            }
        }
    }

    public void deleteTask(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equals(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIds.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                System.out.println("Task deleted successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void displayAllTasks() {
        for (int i = 0; i < taskNames.size(); i++) {
            System.out.println("Task Name: " + taskNames.get(i));
            System.out.println("Developer: " + developers.get(i));
            System.out.println("Task ID: " + taskIds.get(i));
            System.out.println("Task Duration: " + taskDurations.get(i));
            System.out.println("Task Status: " + taskStatuses.get(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Loginp3 lp3 = new Loginp3();

        // Example usage
        lp3.addTask("John Doe", "Task 1", "T1", 5, "done");
        lp3.addTask("Jane Smith", "Task 2", "T2", 3, "in progress");
        lp3.addTask("John Doe", "Task 3", "T3", 7, "done");

        lp3.displayDoneTasks();

        System.out.println("---");

        lp3.displayLongestTask();

        System.out.println("---");

        lp3.searchTaskByName("Task 2");

        System.out.println("---");

        lp3.searchTasksByDeveloper("John Doe");

        System.out.println("---");

        lp3.deleteTask("Task 2");

        System.out.println("---");

        lp3.displayAllTasks();
    }
}
