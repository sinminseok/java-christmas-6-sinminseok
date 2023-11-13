package christmas.domain.plan;


import christmas.domain.event.Reward;
import christmas.domain.event.RewardMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.data.DummyData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlanTest {

    private Plan plan;

    @BeforeEach
    void setInit() {
        plan = new Plan(provideEventsData(), provideOrderData(), provideCalendarDay());
    }

    @Test
    void findBeforeDiscountPrice_메서드는_할인전_주문총_금액을_찾는다() {
        //when
        Integer beforeDiscountPrice = plan.findBeforeDiscountPrice();
        //then
        assertThat(beforeDiscountPrice).isEqualTo(300000);
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
        assertThat(menuRewards.size()).isEqualTo(1);
    }

    @Test
    void calculateTotalRewardPrice_메서드는_적용된_총_혜택_금액을_계산한다() {
        //when
        Integer rewardPrice = plan.calculateTotalRewardPrice();
        //then
        assertThat(rewardPrice).isEqualTo(41538);
    }
}
