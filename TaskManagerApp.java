import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class TaskManagerApp {

    // CUSTOM EXCEPTION (BONUS)
    static class InvalidTaskException extends Exception {
        public InvalidTaskException(String message) {
            super(message);
        }
    }

    // TASK MANAGER CLASS
    static class TaskManager {
        private ArrayList<String> tasks;
        private LinkedList<String> linkedTasks;

        // Constructor
        public TaskManager() {
            tasks = new ArrayList<>();
            linkedTasks = new LinkedList<>();
            log("TaskManager created.");
        }

        // Simple logging mechanism (BONUS)
        private void log(String message) {
            System.out.println("[LOG] " + message);
        }

        // Adding the task
        public void addTask(String task) throws InvalidTaskException {
            if (task == null || task.trim().isEmpty()) {
                throw new InvalidTaskException("Error: Invalid task!");
            }
            tasks.add(task);
            linkedTasks.add(task);
            log("Task added: " + task);
        }

        // Sorting the tasks alphabetically
        public void sortTasks() {
            Collections.sort(tasks);
            Collections.sort(linkedTasks);
            log("Tasks sorted alphabetically.");
        }

        // Searching the task
        public void searchTask(String task) {
            if (tasks.contains(task)) {
                int index = tasks.indexOf(task);
                System.out.println("Task found at index: " + index);
            } else {
                System.out.println("Task not found: " + task);
            }
        }

        // Removing the task
        public void removeTask(String task) {
            if (tasks.remove(task) && linkedTasks.remove(task)) {
                System.out.println("Task removed: " + task);
            } else {
                System.out.println("Task not found: " + task);
            }
        }

        // Finding the longest task
        public void findLongestTask() {
            if (tasks.isEmpty()) {
                System.out.println("No tasks available.");
                return;
            }
            String longest = tasks.get(0);
            for (String t : tasks) {
                if (t.length() > longest.length()) {
                    longest = t;
                }
            }
            System.out.println("Longest task: " + longest);
        }

        // Retrieving a task by index
        public void getTaskByIndex(int index) {
            try {
                String task = tasks.get(index);
                System.out.println("Task at index " + index + ": " + task);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Index " + index + " is out of bounds!");
            }
        }

        // Displaying all tasks
        public void displayTasks() {
            System.out.println("Tasks in ArrayList:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ": " + tasks.get(i));
            }

            System.out.println("Tasks in LinkedList:");
            int idx = 0;
            for (String t : linkedTasks) {
                System.out.println(idx + ": " + t);
                idx++;
            }
        }
    }

    // Main method and calling all methods
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        // Adding tasks
        try {
            tm.addTask("Finish Java assignment");
            tm.addTask("Study for exams");
            tm.addTask("Buy groceries");

            // Invalid task
            tm.addTask("");
        } catch (InvalidTaskException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Task input process completed.\n");
        }

        // Displaying all tasks
        tm.displayTasks();
        System.out.println();

        // Sorting the tasks
        tm.sortTasks();
        System.out.println("After sorting:");
        tm.displayTasks();
        System.out.println();

        // Searching the tasks
        tm.searchTask("Study for exams");
        tm.searchTask("Go jogging");
        System.out.println();

        // Removing the tasks
        tm.removeTask("Buy groceries");
        tm.removeTask("Go jogging");
        System.out.println();

        // Finding the longest task
        tm.findLongestTask();
        System.out.println();

        // Getting the task by index
        tm.getTaskByIndex(1);
        tm.getTaskByIndex(5);
        System.out.println();

        System.out.println("Program execution finished.");
    }
}
