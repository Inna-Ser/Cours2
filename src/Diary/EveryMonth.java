package Diary;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class EveryMonth extends Task{

    public EveryMonth(String title, String description, LocalDateTime dateTime, Type type, int id) {
        super(title, description, dateTime, type, id);
    }
}
