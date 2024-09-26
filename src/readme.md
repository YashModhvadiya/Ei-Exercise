
---
# For Task 2
# Astronaut Daily Schedule Organizer

This Java application, **Astronaut Daily Schedule Organizer**, is a simple desktop application for managing and organizing tasks in an astronaut's daily schedule. It allows users to add, remove, and mark tasks as complete, using a graphical user interface (GUI) built with **Swing**.

## Features

- **Add Tasks**: Users can input a task description, start time, end time, and priority (Low, Medium, High).
- **Remove Tasks**: Tasks can be removed by entering the task description.
- **Mark Tasks as Completed**: Users can mark tasks as completed, which will update their status in the task table.
- **View Tasks in a Table**: Tasks are displayed in a table showing their description, start time, end time, priority, and completion status.
- **Success/Error Messages**: Messages are displayed to confirm actions (e.g., adding or removing tasks) or indicate errors (e.g., invalid input or task not found).

## Code Explanation

### Main Components
1. **GUI Layout**:
    - The application window is created using a `JFrame` and is divided into different panels for task input, task display (table), and control buttons.
    - A **GridLayout** is used for the input panel where the user can add task details such as the description, start time, end time, and priority.
    - The task table is created using `JTable` and holds columns for task details.

2. **Task Actions**:
    - **Add Task**: The `addTask()` method is called when the "Add Task" button is clicked. It gathers the task data from the input fields, creates a new task, and adds it to the `ScheduleManager`.
    - **Remove Task**: The `removeTask()` method removes a task based on the description entered in the remove field.
    - **Mark Task as Completed**: The `markTaskAsCompleted()` method updates the task's status to completed if it exists.

3. **Task Management**:
    - `ScheduleManager`: A singleton class that manages the list of tasks.
    - `TaskFactory`: A factory class used to create tasks with the specified parameters.
    - Tasks are stored in a `List` and displayed in the table.

4. **Messages**:
    - A message label at the bottom of the window shows success or error messages based on the user’s actions.

### File Structure
The folder includes:
- **AstronautScheduleGUI.java**: The main file that contains the GUI and logic for adding, removing, and completing tasks.
- **ScheduleManager.java**: A class responsible for managing the list of tasks.
- **Task.java**: A class representing the task entity.
- **TaskFactory.java**: A helper class that simplifies the creation of tasks.

### How to Run

To run the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/repository-name.git
   cd repository-name
   ```

2. **Open in IntelliJ**:
    - Launch IntelliJ IDEA.
    - Click **File** > **Open** and select the project folder.

3. **Build the project**:
    - Make sure your project’s SDK is set up correctly (Java 8 or later).
    - Build the project by selecting **Build** > **Build Project** from the menu.

4. **Run the Application**:
    - Right-click on the `AstronautScheduleGUI` class in the **Project** window.
    - Select **Run 'AstronautScheduleGUI.main()'**.
    - The GUI window will open, and you can start adding, removing, and managing tasks.

### Dependencies

- **Java 8+**: Ensure you have Java 8 or higher installed to run the application.
- **Swing**: This application uses the built-in `javax.swing` package for the graphical user interface.

### How to Use

1. **Adding Tasks**:
    - Enter the task description, start time, end time, and priority in the respective fields.
    - Click on **Add Task** to add the task to the schedule.

2. **Removing Tasks**:
    - Enter the task description in the "Remove Task" field.
    - Click on **Remove Task** to delete the task from the schedule.

3. **Marking Tasks as Completed**:
    - Enter the task description in the "Remove Task" field.
    - Click on **Mark Task as Completed** to update the task’s status.

4. **Viewing Tasks**:
    - The task table will display all tasks added to the schedule, showing their details and whether they are completed.




### License

This project is open-source and available under the MIT License.

---

