package christmas.domain.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    private Menu menu;

    @BeforeEach
    void setInit() {
        menu = Menu.of("메뉴", 10000, MenuType.MAIN);
    }

    @ParameterizedTest
    @CsvSource(value = {"메뉴, true", "메뉴1, false"})
    void isSameName_메서드는_메뉴_이름과_비교해_동일성을_판별한다(String name, boolean result) {
        //when
        boolean sameName = menu.isSameName(name);
        //then
        assertThat(sameName).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"MAIN, true", "APPETIZER, false", "DESERT, false", "DRINKING, false"})
    void isSameMenuType_메서드는_메뉴타입과_비교해_동일성을_판별한다(MenuType menuType, boolean result) {
        //when
        boolean sameMenuType = menu.isSameMenuType(menuType);
        //then
        assertThat(sameMenuType).isEqualTo(result);
    }
}
