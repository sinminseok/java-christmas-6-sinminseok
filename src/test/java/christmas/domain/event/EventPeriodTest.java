package christmas.domain.event;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EventPeriodTest {

    @ParameterizedTest
    @CsvSource(value = {"5, true", "11, false"})
    void containPeriod_메서드는_전달받은_날짜가_포함되어_있는지_확인한다(int day, boolean result) {
        //given
        EventPeriod eventPeriod = new EventPeriod(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 10));
        //when
        boolean containPeriod = eventPeriod.containPeriod(LocalDate.of(2023, 12, day));
        //then
        assertThat(containPeriod).isEqualTo(result);
    }
}
