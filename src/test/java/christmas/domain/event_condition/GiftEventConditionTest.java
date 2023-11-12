package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftEventConditionTest {

    private GiftEventCondition giftEventCondition;

    @BeforeEach
    void setInit() {
        giftEventCondition = new GiftEventCondition();
    }

    @ParameterizedTest
    @CsvSource(value = {"110000, false", "120000, true"})
    void 증정_이벤트_참여_가능_여부를_확인한다(Integer orderPrice, boolean result) {
        //given
        EventApplyParameter eventApplyParameter = new EventApplyParameter(orderPrice, new CalendarDay(LocalDate.of(2023, 12, 25), false));
        //when
        boolean canApplyEvent = giftEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }
}
