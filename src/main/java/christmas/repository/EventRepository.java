package christmas.repository;

import christmas.domain.event.Event;
import christmas.domain.event_condition.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventRepository {
    private static final List<Event> events = new ArrayList<>();

    static {
        events.add(Event.of("크리스마스 디데이 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new ChristmasEventCondition()));
        events.add(Event.of("평일 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new WeekDayEventCondition()));
        events.add(Event.of("주말 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new WeekendEventCondition()));
        events.add(Event.of("특별 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new SpecialEventCondition()));
        events.add(Event.of("증정 이벤트", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new GiftEventCondition()));
    }
}
