package christmas.domain.event_condition;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventApplyParameter;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardParameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static christmas.data.DummyData.provideEventRewardParameterData;
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

    @Test
    void 평일_할인_이벤트_보상은_디저트메뉴_갯수1개당_2023원_할인이다() {
        //given
        // provideEventRewardParameterData 는 3개의 디저트 메뉴를 제공한다.
        EventRewardParameter eventRewardParameter = provideEventRewardParameterData();
        //when
        EventReward eventReward = weekDayEventCondition.giveReward(eventRewardParameter);
        //then
        assertThat(eventReward.getRewardValue()).isEqualTo(6069);
    }
}
