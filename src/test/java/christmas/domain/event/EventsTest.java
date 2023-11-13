package christmas.domain.event;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.data.DummyData.provideEventRewardContextData;
import static christmas.data.DummyData.provideEventsData;

public class EventsTest {

    @Test
    void findRewards_메서드는_모든_이벤들의_보상을_찾는다(){
        //given
        Events events = provideEventsData();
        EventRewardContext rewardStandard = provideEventRewardContextData();
        //when
        List<Reward> giftRewards = events.findRewards(rewardStandard);
        //then
        Assertions.assertThat(giftRewards.size()).isEqualTo(5);
    }
}
