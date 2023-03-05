package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryDay extends Task{

    public EveryDay(String title, String description, LocalDateTime dateTime, Type type) {
        super(title, description, dateTime, type);
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.EVERY_DAY;
    }

    @Override
    public  boolean appearsIn(LocalDate date) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return date.equals(taskDate) || date.isAfter(taskDate);
    }


}
