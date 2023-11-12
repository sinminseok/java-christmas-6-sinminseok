package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.utils.Parser.parseInteger;

public class InputView {
    private static final String INPUT_VISIT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public static Integer readVisitDay() {
        System.out.println(INPUT_VISIT_DAY_MESSAGE);
        String input = Console.readLine();
        //todo 검증 로직 추가
        return parseInteger(input);
    }
}
