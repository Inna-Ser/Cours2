package Diary;

import java.time.LocalDateTime;

public class EveryWeek extends Task{
    public EveryWeek(String title, String description, LocalDateTime dateTime, Type type, int id) {
        super(title, description, dateTime, type, id);
    }
}
