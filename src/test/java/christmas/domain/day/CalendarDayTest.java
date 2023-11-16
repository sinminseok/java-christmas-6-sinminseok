package christmas.domain.day;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void isWeekend_메서드는_주말날짜_인지_판별한다(int day) {
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, day), false);
        //when
        boolean weekend = calendarDay.isWeekend();
        //then
        assertThat(weekend).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7})
    void isWeekDay_메서드는_평일날짜_인지_판별한다(int day) {
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, day), false);
        //when
        boolean weekend = calendarDay.isWeekDay();
        //then
        assertThat(weekend).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"14, false", "15, true", "16, true"})
    void isBefore_메서드는_지정한_날짜와_같거나_이전인지_확인한다(int compareDay, boolean result) {
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, 15), false);
        //when
        boolean before = calendarDay.isBeforeOrEqual(LocalDate.of(2023, 12, compareDay));
        //then
        assertThat(before).isEqualTo(result);
    }


    @ParameterizedTest
    @CsvSource(value = {"14, true", "15, true", "16, false"})
    void isAfter_메서드는_지정한_날짜와_같거나_이후인지_확인한다(int compareDay, boolean result) {
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, 15), false);
        //when
        boolean before = calendarDay.isAfterOrEqual(LocalDate.of(2023, 12, compareDay));
        //then
        assertThat(before).isEqualTo(result);
    }


}
