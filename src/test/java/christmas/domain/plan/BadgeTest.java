package christmas.domain.plan;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {

    @ParameterizedTest
    @CsvSource(value = {"4000, NONE", "5000, STAR", "10000, TREE", "20000, SANTA"})
    void of_메서드는_가격범위에_포함된_Badge_를_찾아_반환한다(int price, Badge result) {
        //when
        Badge badge = Badge.of(price);
        //then
        assertThat(badge).isEqualTo(result);
    }
}
