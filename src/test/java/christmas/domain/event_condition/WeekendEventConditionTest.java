package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WeekendEventConditionTest {

    private WeekendEventCondition weekendEventCondition;

    @BeforeEach
    void setInit() {
        weekendEventCondition = new WeekendEventCondition();
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 9})
    void 주말_할인_이벤트_참여_가능_여부를_확인한다(int selectDay) {
        //given
        EventApplyParameter eventApplyParameter = new EventApplyParameter(10000, new CalendarDay(LocalDate.of(2023, 12, selectDay), false));
        //when
        boolean canApplyEvent = weekendEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isTrue();
    }
}
