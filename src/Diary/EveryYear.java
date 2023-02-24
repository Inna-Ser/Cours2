package Diary;

import java.time.LocalDateTime;

public class EveryYear extends Task{
    public EveryYear(String title, String description, LocalDateTime dateTime, Type type, int id) {
        super(title, description, dateTime, type, id);
    }
}
