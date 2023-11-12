package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecialEventConditionTest {

    private SpecialEventCondition specialEventCondition;

    @BeforeEach
    void setInit(){
        specialEventCondition = new SpecialEventCondition();
    }

    @ParameterizedTest
    @CsvSource(value = {"false, false", "true, true"})
    void 특별_할인_이벤트_참여_가능_여부를_확인한다(boolean hasStar, boolean result) {
        //given
        CalendarDay day = new CalendarDay(LocalDate.of(2023, 12, 23), hasStar);
        EventApplyParameter eventApplyParameter = new EventApplyParameter(1000, day);
        //when
        boolean canApplyEvent = specialEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }
}
