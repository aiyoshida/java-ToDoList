# ToDoList Application

## Overview
This ToDoList application is developed as part of the "Basic of Programming 3" course assignment by Ai Yoshida (Neptun code: FPYYT9). The purpose of this application is to manage tasks efficiently. Users can store tasks in this ToDoList application and display them with various views.

## Features
- **Task Input**: Users can input the following details for each task:
  - Title of the task
  - Short description of the task
  - Deadline date of the task
  - Priority of the task (High, Medium, Low)
  - Category of the task
  - Status of the task (Completed or Uncompleted)
- **Serialization**: Tasks are saved in a file using serialization.
- **Display Options**: Users can view tasks in different modes:
  - By Category (default)
  - By Deadline
  - By Priority
  - By Completed Tasks
- **Recurring Events**: Users can create recurring tasks by setting the frequency and end date.

## Classes and Functions

### Task
```java
public class Task implements Serializable {
    private LocalDate taskDate;
    private String taskTitle;
    private String taskDescription;
    private enum taskPriority { High, Medium, Low };
    private String[] taskCategory;
    private boolean isDone;

    public Task(String date, String title, String descrip, taskPriority p, String[] category, boolean d) {
        // Implementation
    }
}
