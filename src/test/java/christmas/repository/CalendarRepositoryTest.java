package christmas.repository;

import christmas.domain.day.CalendarDay;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CalendarRepositoryTest {

    @Test
    void findByDay_메서드는_저장소에_저장된_캘린더_날짜_정보를_조회한다() {
        //when
        CalendarDay byDay = CalendarRepository.findByDay(25);
        //then
        Assertions.assertThat(byDay.getDay()).isEqualTo(LocalDate.of(2023, 12, 25));
        Assertions.assertThat(byDay.getHasStar()).isTrue();
    }
}
