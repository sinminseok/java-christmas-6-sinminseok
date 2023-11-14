package christmas.repository;

import christmas.domain.menu.Menu;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuRepositoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"타파스", "양송이수프", "티본스테이크", "초코케이크", "샴페인"})
    void findByName_메서드는_메뉴이름으로_저장된_메뉴정보를_찾는다(String menuName) {
        //when
        Menu menu = MenuRepository.findByName(menuName);
        //then
        assertThat(menu.getName()).isEqualTo(menuName);
    }
}
