package Diary;

import Diary.Exception.TaskNotFoundException;

import java.util.HashSet;
import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final Map<Integer, Task> archiveMap = new HashMap<>();

    public void addTask(Task task) {
        this.taskMap.put(task.getId(), task);
    }

    public void removeTask(int id) throws TaskNotFoundException {
        if (this.taskMap.containsKey(id)) {
            this.taskMap.remove(id);
        } else {
            throw new TaskNotFoundException("This task didn't found");
        }
    }
    public void moveTaskToArchive(int id) throws TaskNotFoundException {
        if (this.taskMap.containsKey(id)) {
            this.archiveMap.put(id, taskMap.get(taskMap)); //this.taskMap.remove(id);
        } else {
            throw new TaskNotFoundException("This task didn't found");
        }
    }

    public Collection<Task> getAllTask() {
        return this.taskMap.values();
    }

    public Collection<Task> getTasksOfDay(LocalDate date) {
        HashSet<Task> tasksOfDay = new HashSet<>();
        for (Task task : taskMap.values()) {
            if (task.appearsIn(date)) {
                tasksOfDay.add(task);
            }
        }
        return tasksOfDay;
    }
}

