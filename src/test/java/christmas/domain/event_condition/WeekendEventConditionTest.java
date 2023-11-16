package christmas.domain.event_condition;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.OrderMenu;
import christmas.domain.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;

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
        EventConditionContext eventApplyParameter = new EventConditionContext(10000, new CalendarDay(LocalDate.of(2023, 12, selectDay), false));
        //when
        boolean canApplyEvent = weekendEventCondition.canApply(eventApplyParameter);
        //then
        assertThat(canApplyEvent).isTrue();
    }

    @Test
    void 주말_할인_이벤트_보상은_메인메뉴_갯수1개당_2023원_할인이다() {
        //given
        OrderMenu orderMenu = new OrderMenu(Menu.of("메인메뉴", 10000, MenuType.MAIN), 3);
        Order order = new Order(List.of(orderMenu));
        EventRewardContext context = new EventRewardContext(order, null);
        //when
        EventReward eventReward = weekendEventCondition.giveReward(context);
        //then
        assertThat(eventReward.getRewardValue()).isEqualTo(6069);
    }
}
