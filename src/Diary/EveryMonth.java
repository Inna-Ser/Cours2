package Diary;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class EveryMonth extends Task {
    public EveryMonth(String title, String description, LocalDateTime dateTime, Type type) {
        super(title, description, dateTime, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().toLocalDate().getDayOfMonth()==date.getDayOfMonth();
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.EVERY_MONTH;
    }
}
