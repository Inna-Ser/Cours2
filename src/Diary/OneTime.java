package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTime extends Task{
    public OneTime(String title, String description, LocalDateTime dateTime, Type type) {
        super(title, description, dateTime, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.equals(this.getDateTime().toLocalDate());
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.ONE_TIME;
    }
}
