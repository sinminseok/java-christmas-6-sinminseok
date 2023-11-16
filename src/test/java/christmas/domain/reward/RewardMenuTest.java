package christmas.domain.reward;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RewardMenuTest {

    @Test
    void calculatePrice_메서드는_보상_메뉴의_혜택_금액을_계산한다() {
        //given
        Menu menu = Menu.of("메뉴", 10000, MenuType.MAIN);
        RewardMenu rewardMenu = new RewardMenu(menu, 2);
        //when
        Integer rewardPrice = rewardMenu.calculatePrice();
        //then
        assertThat(rewardPrice).isEqualTo(20000);
    }
}
