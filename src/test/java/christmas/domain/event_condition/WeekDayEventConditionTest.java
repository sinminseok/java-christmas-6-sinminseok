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
        EventConditionContext context = new EventConditionContext(10000, new CalendarDay(LocalDate.of(2023, 12, selectDay), false));
        //when
        boolean canApplyEvent = weekDayEventCondition.canApply(context);
        //then
        assertThat(canApplyEvent).isTrue();
    }

    @Test
    void 평일_할인_이벤트_보상은_디저트메뉴_갯수1개당_2023원_할인이다() {
        //given
        OrderMenu orderMenu1 = new OrderMenu(Menu.of("디저트메뉴", 10000, MenuType.DESERT), 3);
        Order order = new Order(List.of(orderMenu1));
        EventRewardContext context = new EventRewardContext(order, null);
        //when
        EventReward eventReward = weekDayEventCondition.giveReward(context);
        //then
        assertThat(eventReward.getRewardValue()).isEqualTo(6069);
    }
}
