package Diary;

public class TaskNotFoundException extends Exception{
    private final TaskService taskService;

    public TaskNotFoundException(TaskService taskService) {
        this.taskService = taskService;
    }

    public TaskNotFoundException(String message, TaskService taskService) {
        super(message);
        this.taskService = taskService;
    }
}
