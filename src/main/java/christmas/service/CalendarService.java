package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.repository.CalendarRepository;

public class CalendarService {
    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public CalendarDay findByDay(int day) {
        return calendarRepository.findByDay(day);
    }
}
