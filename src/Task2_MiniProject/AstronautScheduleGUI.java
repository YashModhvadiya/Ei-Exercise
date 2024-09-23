package Task2_MiniProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AstronautScheduleGUI {
    private ScheduleManager scheduleManager = ScheduleManager.getInstance();

    private JFrame frame;
    private JTextField descriptionField, startTimeField, endTimeField, priorityField, removeTaskField;
    private JTable tasksTable;
    private DefaultTableModel tableModel;
    private JLabel messageLabel;

    public AstronautScheduleGUI() {
        frame = new JFrame("Astronaut Daily Schedule Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Layout setup
        frame.setLayout(new BorderLayout());

        // Input panel for adding tasks
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Start Time (HH:MM):"));
        startTimeField = new JTextField();
        inputPanel.add(startTimeField);

        inputPanel.add(new JLabel("End Time (HH:MM):"));
        endTimeField = new JTextField();
        inputPanel.add(endTimeField);

        inputPanel.add(new JLabel("Priority (Low, Medium, High):"));
        priorityField = new JTextField();
        inputPanel.add(priorityField);

        // Button to add task
        JButton addButton = new JButton("Add Task");
        inputPanel.add(addButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Table for displaying tasks
        String[] columnNames = {"Description", "Start Time", "End Time", "Priority", "Completed"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tasksTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tasksTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel for remove task and mark as complete
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

// Remove task input
        controlPanel.add(new JLabel("Remove Task (Description):"));
        removeTaskField = new JTextField();
        controlPanel.add(removeTaskField);

// Button to remove task
        JButton removeButton = new JButton("Remove Task");
        controlPanel.add(removeButton);

// Button to mark task as completed
        JButton markCompleteButton = new JButton("Mark Task as Completed");
        controlPanel.add(markCompleteButton);

// Create a panel to hold control panel and message label
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(controlPanel, BorderLayout.CENTER);

// Label to display success/error messages
        messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setPreferredSize(new Dimension(600, 30)); // Set a fixed height
        bottomPanel.add(messageLabel, BorderLayout.SOUTH);

// Add the bottom panel to the frame
        frame.add(bottomPanel, BorderLayout.SOUTH);



        // Button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        markCompleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskAsCompleted();
            }
        });

        // Show frame
        frame.setVisible(true);
    }

    // Method to add task from the GUI
    private void addTask() {
        String description = descriptionField.getText();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();
        String priority = priorityField.getText();

        // Use the TaskFactory and ScheduleManager to add a task
        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        boolean success = scheduleManager.addTask(task);

        if (success) {
            updateTable();
            messageLabel.setText("Task Added successfully");
        } else {
            JOptionPane.showMessageDialog(frame, "Error: Task conflict or invalid input");
            messageLabel.setText("Error:Task conflict or invalid input");
        }
    }

    // Method to remove task from the GUI
    private void removeTask() {
        String description = removeTaskField.getText();
        boolean success = scheduleManager.removeTask(description);

        if (success) {
            updateTable();
            messageLabel.setText("Task removed Successfully");
        } else {
            JOptionPane.showMessageDialog(frame, "Error: Task not found");
            messageLabel.setText("Error:Task not found");
        }
    }

    // Method to mark task as completed from the GUI
    private void markTaskAsCompleted() {
        String description = removeTaskField.getText();
        boolean success = scheduleManager.markTaskAsCompleted(description);

        if (success) {
            updateTable();
            messageLabel.setText("Task marked as completed.");
        } else {
            JOptionPane.showMessageDialog(frame, "Error: Task not found or already completed");
            messageLabel.setText("Error:Task not found or already completed");
        }
    }

    // Method to update the table with tasks from the ScheduleManager
    private void updateTable() {
        // Clear the existing table
        tableModel.setRowCount(0);

        // Fetch the current tasks
        List<Task> tasks = scheduleManager.getTasks();
        for (Task task : tasks) {
            Object[] rowData = {
                    task.getDescription(),
                    task.getStartTime(),
                    task.getEndTime(),
                    task.getPriority(),
                    task.isCompleted() ? "Yes" : "No"
            };
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AstronautScheduleGUI();
            }
        });
    }
}
