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

    @ParameterizedTest
    @ValueSource(strings = {"타파스-1-시저샐러드-1", "타파스-한글", "0-1"})
    void validateOrderFormat_메서드는_메뉴_형식이_다른_경우_예외를_발생한다(String input){
        assertThatThrownBy(() -> InputValidator.validateOrder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-0", "타파스-0, 샐러드-1"})
    void validateOrderFormat_메서드는_메뉴_갯수가_1이상의_숫자가_아닌경우_예외를_발생한다(String input){
        assertThatThrownBy(() -> InputValidator.validateOrder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
