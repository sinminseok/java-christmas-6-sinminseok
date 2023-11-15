package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Event;
import christmas.domain.event.Events;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.Order;
import christmas.domain.order.OrderMenu;
import christmas.domain.plan.Badge;
import christmas.domain.plan.Plan;
import christmas.dto.RewardDto;
import christmas.dummy.TestDiscountEventCondition;
import christmas.dummy.TestGiftEventCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class PlanServiceTest {

    private PlanService planService;

    private Order order;
    private CalendarDay calendarDay;
    private Events events;

    @BeforeEach
    void setInit() {
        planService = new PlanService();
        order = provideOrder();
        calendarDay = provideCalendarDay();
        events = provideEvents();
    }

    @Test
    void createPlan_메서드는_전달받은_정보로_Plan_객체를_생성해_반환한다() {
        //when
        Plan plan = planService.createPlan(events, order, calendarDay);
        //then
        Assertions.assertThat(plan).isNotNull();
    }

    @Test
    void findBeforeDiscountPrice_메서드는_할인전_주문_금액을_반환한다() {
        //given
        Plan plan = new Plan(events, order, calendarDay);
        //then
        Integer beforeDiscountPrice = planService.findBeforeDiscountPrice(plan);
        //then
        Assertions.assertThat(beforeDiscountPrice).isEqualTo(10000);
    }

    @Test
    void findRewards_메서드는_제공된_모든_혜택을_RewardDto_로_반환한다() {
        //given
        Plan plan = new Plan(events, order, calendarDay);
        //when
        List<RewardDto> rewards = planService.findRewards(plan);
        //then
        Assertions.assertThat(rewards.size()).isEqualTo(3);
    }

    @Test
    void findTotalRewardPrice_메서드는_총_혜택금액을_반환한다() {
        //given
        Plan plan = new Plan(events, order, calendarDay);
        //when
        Integer totalRewardPrice = planService.findTotalRewardPrice(plan);
        //then
        Assertions.assertThat(totalRewardPrice).isEqualTo(12000);
    }

    @Test
    void findPayPrice_메서드는_최종_지불_금액을_반환한다() {
        //given
        Plan plan = new Plan(events, order, calendarDay);
        //when
        Integer payPrice = planService.findPayPrice(plan);
        //then
        Assertions.assertThat(payPrice).isEqualTo(8000);
    }

    @Test
    void findBadge_메서드는_발급된_배지를_반환한다() {
        //given
        Plan plan = new Plan(events, order, calendarDay);
        //when
        Badge badge = planService.findBadge(plan);
        //then
        Assertions.assertThat(badge).isEqualTo(Badge.TREE);
    }


    private Order provideOrder() {
        OrderMenu orderMenu = new OrderMenu(Menu.of("메뉴1", 10000, MenuType.MAIN), 1);
        return new Order(List.of(orderMenu));
    }

    private CalendarDay provideCalendarDay() {
        return new CalendarDay(LocalDate.of(2023, 12, 25), true);
    }

    private Events provideEvents() {
        Event discountEvent1 = Event.of("테스트 할인 이벤트1", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new TestDiscountEventCondition());
        Event discountEvent2 = Event.of("테스트 할인 이벤트2", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new TestDiscountEventCondition());
        Event giftEvent1 = Event.of("테스트 증정 이벤트1", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new TestGiftEventCondition());
        return new Events(List.of(discountEvent1, discountEvent2, giftEvent1));
    }
}
