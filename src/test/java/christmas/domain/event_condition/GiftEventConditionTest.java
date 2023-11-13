package christmas.domain.event_condition;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.RewardMenu;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        EventConditionContext eventApplyParameter = new EventConditionContext(orderPrice, new CalendarDay(LocalDate.of(2023, 12, 25), false));
        //when
        boolean canApplyEvent = giftEventCondition.canApplyEvent(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }

    @Test
    void 증정_이벤트_보상은_샴페인_1병이다() {
        //given
        Menu champagne = Menu.of("샴페인", 25000, MenuType.DRINKING);
        RewardMenu resultReward = new RewardMenu(champagne, 1);
        //when
        EventReward eventReward = giftEventCondition.giveReward(null);
        //then
        Assertions.assertThat(eventReward.getRewardValue()).isEqualTo(resultReward);
    }
}
