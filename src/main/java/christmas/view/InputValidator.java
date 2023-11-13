package christmas.view;

import christmas.utils.ErrorMessage;

import static christmas.utils.ErrorConstants.VISIT_DAY_ERROR;
import static christmas.utils.Parser.parseInteger;

public class InputValidator {
    private static final Integer MIN_DAY_RANGE = 1;
    private static final Integer MAX_DAY_RANGE = 31;

    public static void validateVisitDay(String day) {
        validateDayType(day);
        Integer intDay = parseInteger(day);
        if (intDay < MIN_DAY_RANGE || intDay > MAX_DAY_RANGE) {
            throw new ErrorMessage(VISIT_DAY_ERROR);
        }
    }

    private static void validateDayType(String day) {
        try {
            Integer.parseInt(day);
        } catch (IllegalArgumentException exception) {
            throw new ErrorMessage(VISIT_DAY_ERROR);
        }
    }
}
