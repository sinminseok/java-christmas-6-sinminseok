package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.reward.Reward;
import christmas.domain.reward.RewardMenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class EventRewardTest {

    @Test
    void isRewardMenuType_메서드는_보상이_증정_메뉴인지_판별한다() {
        //given
        RewardMenu rewardMenu = new RewardMenu(Menu.of("메뉴", 10000, MenuType.MAIN), 2);
        EventReward eventReward = new EventReward(rewardMenu);
        //when
        boolean rewardMenuType = eventReward.isRewardMenuType();
        //then
        Assertions.assertThat(rewardMenuType).isTrue();
    }

    @ParameterizedTest
    @MethodSource("provideRewardMenu")
    void wrapReward_메서드는_보상을_Reward_형식에_맞춰_변환한다(EventReward eventReward, int result) {
        //when
        Reward reward = eventReward.wrapReward("이벤트이름");
        //then
        Assertions.assertThat(reward.getName()).isEqualTo("이벤트이름");
        Assertions.assertThat(reward.getDiscountPrice()).isEqualTo(result);
    }

    @Test
    void wrapRewardMenu_메서드는_보상을_RewardMenu_형식에_맞춰_변환한다() {
        //given
        RewardMenu rewardMenu = new RewardMenu(Menu.of("메뉴", 10000, MenuType.MAIN), 2);
        EventReward eventReward = new EventReward(rewardMenu);
        //when
        RewardMenu result = eventReward.wrapRewardMenu();
        //then
        Assertions.assertThat(result.equals(rewardMenu)).isTrue();
    }

    static List<Arguments> provideRewardMenu() {
        RewardMenu rewardMenu = new RewardMenu(Menu.of("메뉴", 10000, MenuType.MAIN), 2);
        return Arrays.asList(
                Arguments.of(new EventReward(rewardMenu), 20000),
                Arguments.of(new EventReward(10000), 10000)
        );
    }
}
