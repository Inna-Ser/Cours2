package Diary;
public class IncorrectArgumentException extends Exception {
    private final Task task;

        public IncorrectArgumentException(String message, Task task) {
        super(message);
        this.task = task;
    }
}