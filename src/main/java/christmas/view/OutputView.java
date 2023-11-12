package christmas.view;

import java.text.MessageFormat;
import java.time.LocalDate;

public class OutputView {
    private static final String START_PLANNER_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_PREVIEW_MESSAGE = "12월 {0}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public static void printStartMessage() {
        System.out.println(START_PLANNER_MESSAGE);
    }

    public static void printEventPreview(LocalDate localDate) {
        System.out.println(MessageFormat.format(EVENT_PREVIEW_MESSAGE, localDate.getDayOfMonth()));
    }
}
