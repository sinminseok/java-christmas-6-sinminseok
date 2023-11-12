package christmas.domain.event_condition;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        EventConditionContext eventApplyParameter = new EventConditionContext(1000, day);
        //when
        boolean canApplyEvent = specialEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }

    @Test
    void 특별_할인_이벤트_보상은_총_금액에_적용될_1000원_할인이다() {
        //given
        CalendarDay day = new CalendarDay(LocalDate.of(2023, 12, 23), false);
        //when
        EventReward eventReward = specialEventCondition.giveReward(null);
        //then
        assertThat(eventReward.getRewardValue()).isEqualTo(1000);
    }
}
