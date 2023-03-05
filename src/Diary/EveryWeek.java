package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryWeek extends Task{
    public EveryWeek(String title, String description, LocalDateTime dateTime, Type type) {
        super(title, description, dateTime, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().toLocalDate().getDayOfWeek()==date.getDayOfWeek();
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.EVERY_WEEK;
    }
}
