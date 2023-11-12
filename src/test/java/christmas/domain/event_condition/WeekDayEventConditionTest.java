package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WeekDayEventConditionTest {

    private WeekDayEventCondition weekDayEventCondition;

    @BeforeEach
    void setInit() {
        weekDayEventCondition = new WeekDayEventCondition();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7})
    void 평일_할인_이벤트_참여_가능_여부를_확인한다(int selectDay) {
        //given
        EventApplyParameter eventApplyParameter = new EventApplyParameter(10000, new CalendarDay(LocalDate.of(2023, 12, selectDay), false));
        //when
        boolean canApplyEvent = weekDayEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isTrue();
    }
}
