package Diary;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryYear extends Task{
    public EveryYear(String title, String description, LocalDateTime dateTime, Type type) {
        super(title, description, dateTime, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().toLocalDate().getDayOfYear()==date.getDayOfYear();
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.EVERY_YEAR;
    }
}
