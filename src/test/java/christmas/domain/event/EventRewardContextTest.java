package christmas.domain.event;

import christmas.domain.menu.MenuType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static christmas.data.DummyData.provideCalendarDay;
import static christmas.data.DummyData.provideOrderData;

public class EventRewardContextTest {

    @ParameterizedTest
    @CsvSource(value = {"MAIN, 3", "DESERT, 3"})
    void countMenuByType_메서드는_메뉴타입을_전달받아_주문에_있는_메뉴와_비교해_일치_갯수를_계산한다(MenuType menuType, int result) {
        //given
        EventRewardContext eventRewardContext = new EventRewardContext(provideOrderData(), provideCalendarDay());
        //when
        int count = eventRewardContext.countMenuByType(menuType);
        //then
        Assertions.assertThat(count).isEqualTo(result);
    }

    @Test
    void calculateDaysSinceStart_메서드는_전잘받은_시작날짜와_종료날짜_사이의_일수를_계산한다() {
        // given
        LocalDate startDate = LocalDate.of(2023, 12, 20);
        // provideCalendarDay 날짜 : 2023.12.25
        EventRewardContext eventRewardContext = new EventRewardContext(provideOrderData(), provideCalendarDay());
        // when
        int daysSinceStart = eventRewardContext.calculateDaysSinceStart(startDate);
        // then

        Assertions.assertThat(daysSinceStart).isEqualTo(5); // Adjust the expected value based on the actual date difference
    }
}
