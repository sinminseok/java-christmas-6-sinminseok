package christmas.domain.event;

import java.time.LocalDate;

public class EventPeriod {
    private final LocalDate startDay;
    private final LocalDate endDay;

    public EventPeriod(LocalDate startDay, LocalDate endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public boolean containPeriod(LocalDate localDate) {
        return !localDate.isBefore(startDay) && !localDate.isAfter(endDay);
    }
}
