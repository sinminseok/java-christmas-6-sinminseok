package christmas.view;

import christmas.utils.ErrorMessage;

import static christmas.utils.ErrorConstants.ORDER_ERROR;
import static christmas.utils.ErrorConstants.VISIT_DAY_ERROR;
import static christmas.utils.Parser.COMMA;
import static christmas.utils.Parser.parseInteger;
import static christmas.utils.Parser.DIVIDE_NAME_AMOUNT_STANDARD;
import static christmas.utils.Parser.removeSpacesBetweenCommas;

public class InputValidator {
    private static final Integer MIN_MENU_COUNT = 1;
    private static final Integer MIN_DAY_RANGE = 1;
    private static final Integer MAX_DAY_RANGE = 31;
    private static final String ORDER_FORMAT_REGEX = "^(\\p{L}+-\\d+,)*\\p{L}+-\\d+$";

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

    public static void validateOrder(String input) {
        String trimmedInput = removeSpacesBetweenCommas(input);
        validateOrderFormat(trimmedInput);
        validateMenuCount(input);
    }

    private static void validateOrderFormat(String input) {
        if (!input.matches(ORDER_FORMAT_REGEX)) {
            throw new ErrorMessage(ORDER_ERROR);
        }
    }

    private static void validateMenuCount(String input) {
        for (String menuEntry : input.split(COMMA)) {
            int menuCount = Integer.parseInt(menuEntry.split(DIVIDE_NAME_AMOUNT_STANDARD)[1]);
            if (menuCount < MIN_MENU_COUNT) {
                throw new ErrorMessage(ORDER_ERROR);
            }
        }
    }
}
