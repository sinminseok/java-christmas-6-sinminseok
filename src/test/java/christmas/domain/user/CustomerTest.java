package christmas.domain.user;


import christmas.domain.event.Reward;
import christmas.domain.event.RewardMenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.data.DummyData.*;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setInit() {
        customer = new Customer(provideEventsData(), provideOrderData(), provideCalendarDay());
    }

    @Test
    void findBeforeDiscountPrice_메서드는_할인전_주문총_금액을_찾는다() {
        //when
        Integer beforeDiscountPrice = customer.findBeforeDiscountPrice();
        //then
        Assertions.assertThat(beforeDiscountPrice).isEqualTo(300000);
    }

    @Test
    void findAllReward_메서드는_적용된_모든_혜택_내역을_찾는다() {
        //when
        List<Reward> allReward = customer.findAllReward();
        //then
        Assertions.assertThat(allReward.size()).isEqualTo(5);
    }

    @Test
    void findMenuRewards_메서드는_적용된_이벤트들_중_증정_메뉴를_찾는다() {
        //when
        List<RewardMenu> menuRewards = customer.findMenuRewards();
        //then
        Assertions.assertThat(menuRewards.size()).isEqualTo(1);
    }

    @Test
    void calculateTotalRewardPrice_메서드는_적용된_총_혜택_금액을_계산한다(){
        //when
        Integer rewardPrice = customer.calculateTotalRewardPrice();
        //then
        Assertions.assertThat(rewardPrice).isEqualTo(41538);
    }
}
