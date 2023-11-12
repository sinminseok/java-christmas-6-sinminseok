package christmas.domain.day;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarDayTest {

    @ParameterizedTest
    @CsvSource(value = {"2023-12-25, true", "2023-12-30, false"})
    void isSameDay_메서드는_전달받은_날짜와_비교해_같은지를_판별한다(String compareDate, boolean result) {
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, 25), false);
        //when
        boolean sameDay = calendarDay.isSameDay(LocalDate.parse(compareDate));
        //then
        assertThat(sameDay).isEqualTo(result);
    }
}
