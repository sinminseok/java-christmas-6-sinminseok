package christmas.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"english", "한글", "", " "})
    void validateVisitDay_메서드는_숫자가_아닌_값을_입력한_경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateVisitDay(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"0", "32"})
    void validateVisitDay_메서드는_1이상_31이하의_범위를_벗어난_경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateVisitDay(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
