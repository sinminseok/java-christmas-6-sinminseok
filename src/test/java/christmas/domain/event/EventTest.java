package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import christmas.domain.event_condition.*;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {
    private Event discountEvent;
    private Event giftEvent;

    @BeforeEach
    void setInit() {
        discountEvent = Event.of("테스트 할인 이벤트", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new TestDiscountEventCondition());
        giftEvent = Event.of("테스트 증정 이벤트", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new TestGiftEventCondition());
    }

    @Test
    void findReward_메서드는_이벤트가_부여하는_보상을_찾는다() {
        //given
        EventRewardContext context = provideTestRewardContext();
        //when
        EventReward reward = discountEvent.findReward(context);
        //then
        assertThat(reward.getRewardValue()).isEqualTo(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"25, true", "26, false"})
    void isApplicable_메서드는_이벤트_참여_여부를_확인한다(int day, boolean result) {
        //given
        EventConditionContext context = provideTestConditionContext(day);
        //when
        boolean applicable = discountEvent.isApplicable(context);
        //then
        assertThat(applicable).isEqualTo(result);
    }

    @Test
    void isGiftEvent_메서드는_이벤트가_증정이벤트_인지_판별한다() {
        //when
        boolean result = giftEvent.isGiftEvent();
        //then
        assertThat(result).isTrue();
    }

    @Test
    void isDiscountEvent_메서드는_이벤트가_할인이벤트_인지_판별한다() {
        //when
        boolean result = discountEvent.isDiscountEvent();
        //then
        assertThat(result).isTrue();
    }

    private EventRewardContext provideTestRewardContext() {
        return new EventRewardContext(null, new CalendarDay(LocalDate.of(2023, 12, 25), true));
    }

    private EventConditionContext provideTestConditionContext(int day) {
        return new EventConditionContext(10000, new CalendarDay(LocalDate.of(2023, 12, day), false));
    }

    public static class TestDiscountEventCondition implements EventCondition {

        @Override
        public boolean canApply(EventConditionContext eventApplyParameter) {
            return true;
        }

        @Override
        public EventReward giveReward(EventRewardContext eventRewardParameter) {
            return new EventReward(1000);
        }

        @Override
        public EventType checkType() {
            return EventType.DISCOUNT;
        }
    }


    public static class TestGiftEventCondition implements EventCondition {

        @Override
        public boolean canApply(EventConditionContext eventApplyParameter) {
            return true;
        }

        @Override
        public EventReward giveReward(EventRewardContext eventRewardParameter) {
            return new EventReward(new RewardMenu(Menu.of("증정메뉴", 10000, MenuType.MAIN), 1));
        }

        @Override
        public EventType checkType() {
            return EventType.GIFT;
        }
    }
}
