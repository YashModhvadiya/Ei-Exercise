package Task2_MiniProject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

// Task class represents a task with description, start time, end time, and priority
class Task {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;
    private boolean isCompleted;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s] %s", startTime, endTime, description, priority, (isCompleted ? "(Completed)" : ""));
    }
}

// TaskFactory uses Factory Pattern to create tasks
class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        return new Task(description, startTime, endTime, priority);
    }
}

// Observer interface for notifying task conflicts or updates
interface TaskObserver {
    void notifyConflict(Task task, Task conflictingTask);
}

// Concrete observer to display conflict messages
class ConflictNotifier implements TaskObserver {
    @Override
    public void notifyConflict(Task task, Task conflictingTask) {
        System.out.println("Error: Task '" + task.getDescription() + "' conflicts with existing task '" + conflictingTask.getDescription() + "'");
    }
}

// ScheduleManager class follows Singleton Pattern to manage tasks
class ScheduleManager {
    private List<Task> tasks;
    private List<TaskObserver> observers;

    // Singleton instance
    private static ScheduleManager instance;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    // Get the single instance of ScheduleManager
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Add observer
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    // Notify observers of task conflicts
    private void notifyObservers(Task task, Task conflictingTask) {
        for (TaskObserver observer : observers) {
            observer.notifyConflict(task, conflictingTask);
        }
    }

    // Add a new task
    public boolean addTask(Task task) {
        if (validateTask(task)) {
            tasks.add(task);
            System.out.println("Task added successfully.");
            return true;
        } else {
            return false;
        }
    }

    // Remove a task by description
    public boolean removeTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                tasks.remove(task);
                System.out.println("Task removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Task not found.");
        return false;
    }

    // View all tasks sorted by start time
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.sort(Comparator.comparing(Task::getStartTime));
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // View tasks by priority
    public void viewTasksByPriority(String priority) {
        List<Task> priorityTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                priorityTasks.add(task);
            }
        }
        if (priorityTasks.isEmpty()) {
            System.out.println("No tasks found for priority level: " + priority);
        } else {
            for (Task task : priorityTasks) {
                System.out.println(task);
            }
        }
    }

    // Mark a task as completed
    public boolean markTaskAsCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markAsCompleted();
                System.out.println("Task marked as completed.");
                return true;
            }
        }
        System.out.println("Error: Task not found.");
        return false;
    }

    // Validate if task can be added (no overlapping times)
    private boolean validateTask(Task newTask) {
        for (Task task : tasks) {
            if (isOverlapping(newTask, task)) {
                notifyObservers(newTask, task);
                return false;
            }
        }
        return true;
    }

    // Helper function to check time overlap
    private boolean isOverlapping(Task task1, Task task2) {
        return (task1.getStartTime().compareTo(task2.getEndTime()) < 0 && task1.getEndTime().compareTo(task2.getStartTime()) > 0);
    }

    public List<Task> getTasks() {
        return tasks;  // 'tasks' is the list of tasks managed by the ScheduleManager
    }
}

// Main application
public class AstronautSchedule {
    private static final ScheduleManager scheduleManager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        // Adding ConflictNotifier observer to ScheduleManager
        scheduleManager.addObserver(new ConflictNotifier());

        // Launch the GUI version of the Astronaut Daily Schedule Organizer
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AstronautScheduleGUI();  // Start the GUI
            }
        });
    }
}
