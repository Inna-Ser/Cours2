package Diary;

import Diary.Exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    public enum Repeatability {
        ONE_TIME,
        EVERY_DAY,
        EVERY_WEEK,
        EVERY_MONTH,
        EVERY_YEAR
    }
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private Type type;
    private int id;
    private static int idGenerator = 1;

    public Task(String title, String description, LocalDateTime dateTime, Type type) {
        if (title != null || !title.isBlank() || !title.isEmpty()) {
            this.title = title;
        } else {
            try {
                throw new IncorrectArgumentException("Correct data must be specified", this);
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.type = type;
        this.id = idGenerator++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public abstract boolean appearsIn(LocalDate date);

    public abstract Repeatability getRepeatability();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dateTime, task.dateTime) && type == task.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, dateTime, type, id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
