package christmas.domain.event;

import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.data.DummyData.provideEventRewardContextData;
import static christmas.data.DummyData.provideEventsData;
import static org.assertj.core.api.Assertions.assertThat;

public class EventsTest {

    @Test
    void findRewards_메서드는_모든_이벤들의_보상을_찾는다() {
        //given
        Events events = provideEventsData();
        EventRewardContext rewardStandard = provideEventRewardContextData();
        //when
        List<Reward> rewards = events.findRewards(rewardStandard);
        //then
        assertThat(rewards.size()).isEqualTo(5);
    }

    @Test
    void findMenuRewards_메서드는_이벤트들_중_증정이벤트의_보상만을_찾는다() {
        //given
        Events events = provideEventsData();
        EventRewardContext rewardStandard = provideEventRewardContextData();
        //when
        List<RewardMenu> giftRewards = events.findRewardMenus(rewardStandard);
        //then
        assertThat(giftRewards.size()).isEqualTo(1);
    }
}
