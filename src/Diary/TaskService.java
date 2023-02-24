package Diary;
import java.util.*;

public class TaskService {
      Map<Integer, Task> taskMap = new HashMap<>();
    Collection<? extends Task> taskCollection = new HashSet<>();

    public void addTask(Task task){
        this.taskCollection.add(task);
    }

    public int remove
}
