package christmas.utils;

import java.util.List;

public class Parser {
    public static final String COMMA = ",";
    public static final String DIVIDE_NAME_AMOUNT_STANDARD = "-";
    private static final String COMMA_SPACE_REGEX = ",\\s+";

    public static Integer parseInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> splitByComma(String input) {
        String value = removeSpacesBetweenCommas(input);
        return List.of(value.split(COMMA));
    }

    public static List<String> splitNameAndAmount(String input) {
        String value = removeSpacesBetweenCommas(input);
        return List.of(value.split(DIVIDE_NAME_AMOUNT_STANDARD));
    }

    public static String removeSpacesBetweenCommas(String input) {
        return input.replaceAll(COMMA_SPACE_REGEX, COMMA); // , 사이의 공백 제거
    }
}
