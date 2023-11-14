package christmas.domain.plan;


import christmas.domain.day.CalendarDay;
import christmas.domain.event.*;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.OrderMenu;
import christmas.domain.order.Order;
import christmas.domain.reward.Reward;
import christmas.domain.reward.RewardMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlanTest {

    private Plan plan;

    @BeforeEach
    void setInit() {
        plan = new Plan(provideEvents(), provideOrder(), provideCalendarDay());
    }

    @Test
    void findBeforeDiscountPrice_메서드는_할인전_주문총_금액을_찾는다() {
        //when
        Integer beforeDiscountPrice = plan.findBeforeDiscountPrice();
        //then
        assertThat(beforeDiscountPrice).isEqualTo(50000);
    }

    @Test
    void findAllReward_메서드는_적용된_모든_혜택_내역을_찾는다() {
        //when
        List<Reward> allReward = plan.findAllReward();
        //then
        assertThat(allReward.size()).isEqualTo(5);
    }

    @Test
    void findMenuRewards_메서드는_적용된_이벤트들_중_증정_메뉴를_찾는다() {
        //when
        List<RewardMenu> menuRewards = plan.findMenuRewards();
        //then
        assertThat(menuRewards.size()).isEqualTo(2);
    }

    @Test
    void calculateTotalRewardPrice_메서드는_적용된_총_혜택_금액을_계산한다() {
        //when
        Integer rewardPrice = plan.calculateTotalRewardPrice();
        //then
        assertThat(rewardPrice).isEqualTo(23000);
    }

    @Test
    void calculatePaymentPrice_메서드는_할인_후_예상_결제금액을_계산한다() {
        //when
        Integer paymentPrice = plan.calculatePaymentPrice();
        //then
        assertThat(paymentPrice).isEqualTo(47000);
    }

    @Test
    void awardBadge_메서드는_총혜택_금액에_따라_이벤트_배지를_부여한다() {
        Badge badge = plan.awardBadge();
        //then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    private Events provideEvents() {
        Event discountEvent1 = Event.of("테스트 할인 이벤트1", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestDiscountEventCondition());
        Event discountEvent2 = Event.of("테스트 할인 이벤트2", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestDiscountEventCondition());
        Event discountEvent3 = Event.of("테스트 할인 이벤트3", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestDiscountEventCondition());
        Event giftEvent1 = Event.of("테스트 증정 이벤트1", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestGiftEventCondition());
        Event giftEvent2 = Event.of("테스트 증정 이벤트2", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestGiftEventCondition());
        return new Events(List.of(discountEvent1, discountEvent2, discountEvent3, giftEvent1, giftEvent2));
    }

    public static Order provideOrder() {
        Menu menu = Menu.of("메뉴1", 50000, MenuType.MAIN);
        OrderMenu menuItem = new OrderMenu(menu, 1);
        return new Order(List.of(menuItem));
    }

    public static CalendarDay provideCalendarDay() {
        return new CalendarDay(LocalDate.of(2023, 12, 25), true);
    }
}
