package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import christmas.domain.event_condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    @ParameterizedTest
    @MethodSource("provideEventData")
    void canApplyEvent_메서드는_주문과_선택한_날짜를_기반으로_이벤트가_적용가능한지_판별한다(Event event, boolean result) {
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, 25), true);
        EventConditionContext eventApplyParameter = new EventConditionContext(150000, calendarDay);
        //when
        boolean canApplyEvent = event.isApplicable(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }

    static List<Arguments> provideEventData() {
        return Arrays.asList(
                //주말 할인 이벤트를 제외한 나머지 이벤트 참여 여부 결과를 true 를 예상한다.
                Arguments.of(Event.of("크리스마스 디데이 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new ChristmasEventCondition()), true),
                Arguments.of(Event.of("평일 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new WeekDayEventCondition()), true),
                Arguments.of(Event.of("주말 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new WeekendEventCondition()), false),
                Arguments.of(Event.of("특별 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new SpecialEventCondition()), true),
                Arguments.of(Event.of("증정 이벤트", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new GiftEventCondition()), true)
        );
    }
}
