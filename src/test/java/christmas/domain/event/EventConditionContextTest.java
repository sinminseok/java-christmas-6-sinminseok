package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EventConditionContextTest {

    @ParameterizedTest
    @CsvSource({
            "2023-12-01, 2023-12-31, 2023-12-15, true",
            "2023-12-01, 2023-12-31, 2023-11-15, false"
    })
    void isContainDay_메서드는_시작일과_종료일_사이에_날짜가_포함되어_있는지_판별한다(String startDateStr, String endDateStr, String calendarDayStr, boolean expectedResult) {
        // given
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        CalendarDay calendarDay = new CalendarDay(LocalDate.parse(calendarDayStr), false);
        // when
        EventConditionContext context = new EventConditionContext(0, calendarDay);
        boolean result = context.isContainDay(startDate, endDate);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}
