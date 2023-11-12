package christmas.domain;

import java.time.LocalDate;

public class EventPeriod {
    private final LocalDate startDay;
    private final LocalDate endDay;

    public EventPeriod(LocalDate startDay, LocalDate endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }
}
