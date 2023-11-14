package christmas.domain.day;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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
    void isWeekend_메서드는_주말날짜_인지_판별한다(int day){
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, day), false);
        //when
        boolean weekend = calendarDay.isWeekend();
        //then
        Assertions.assertThat(weekend).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7})
    void isWeekDay_메서드는_평일날짜_인지_판별한다(int day){
        //given
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, day), false);
        //when
        boolean weekend = calendarDay.isWeekDay();
        //then
        Assertions.assertThat(weekend).isTrue();
    }


}
