package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasEventConditionTest {

    private ChristmasEventCondition christmasEventCondition;

    @BeforeEach
    void setInit() {
        christmasEventCondition = new ChristmasEventCondition();
    }

    @ParameterizedTest
    @CsvSource(value = {"24, true", "26, false"})
    void 크리스마스_디데이_이벤트_참여_가능_여부를_확인한다(int selectDay, boolean result) {
        //given
        EventApplyParameter eventApplyParameter = new EventApplyParameter(10000, new CalendarDay(LocalDate.of(2023, 12, selectDay), false));
        //when
        boolean canApplyEvent = christmasEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }
}
