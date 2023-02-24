package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryDay extends Task{

    public EveryDay(String title, String description, LocalDateTime dateTime, Type type, int id) {
        super(title, description, dateTime, type, id);
    }

    public boolean appearsIn(LocalDate date) {
        return date.equals()
    }
}
