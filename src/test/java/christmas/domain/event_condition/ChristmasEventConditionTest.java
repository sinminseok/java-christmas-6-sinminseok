package christmas.domain.event_condition;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static christmas.data.DummyData.provideOrderData;
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
        EventConditionContext eventApplyParameter = new EventConditionContext(10000, new CalendarDay(LocalDate.of(2023, 12, selectDay), false));
        //when
        boolean canApplyEvent = christmasEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1000", "10, 1900", "25, 3400"})
    void 크리스마스_디데이_이벤트_보상이_올바르게_반환되는지_확인한다(int selectDay, int result) {
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, selectDay), false);
        EventRewardContext rewardStandard = new EventRewardContext(provideOrderData(), calendarDay);
        //when
        EventReward eventReward = christmasEventCondition.giveReward(rewardStandard);
        //then
        assertThat(eventReward.getRewardValue()).isEqualTo(result);
    }
}
