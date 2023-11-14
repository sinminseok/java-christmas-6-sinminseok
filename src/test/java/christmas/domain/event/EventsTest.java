package christmas.domain.event;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class EventsTest {
    private Events events;

    @BeforeEach
    void setInit() {
        Event discountEvent1 = Event.of("테스트 할인 이벤트1", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestDiscountEventCondition());
        Event discountEvent2 = Event.of("테스트 할인 이벤트2", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestDiscountEventCondition());
        Event discountEvent3 = Event.of("테스트 할인 이벤트3", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestDiscountEventCondition());
        Event giftEvent1 = Event.of("테스트 증정 이벤트1", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestGiftEventCondition());
        Event giftEvent2 = Event.of("테스트 증정 이벤트2", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new EventTest.TestGiftEventCondition());

        events = new Events(List.of(discountEvent1, discountEvent2, discountEvent3, giftEvent1, giftEvent2));
    }

    @Test
    void findRewards_메서드는_모든_이벤들의_보상을_찾는다() {
        //when
        List<Reward> rewards = events.findRewards(null);
        //then
        Assertions.assertThat(rewards.size()).isEqualTo(5);
    }

    @Test
    void findRewardMenus_메서드는_이벤트들_중_증정메뉴_보상만을_찾는다() {
        //when
        List<RewardMenu> menuRewards = events.findRewardMenus(null);
        //then
        Assertions.assertThat(menuRewards.size()).isEqualTo(2);
    }


    @Test
    void findRewardDiscounts_메서드는_이벤트들_중_할인혜택_보상만을_찾는다() {
        //when
        List<Reward> menuRewards = events.findRewardDiscounts(null);
        //then
        Assertions.assertThat(menuRewards.size()).isEqualTo(3);
    }
}
