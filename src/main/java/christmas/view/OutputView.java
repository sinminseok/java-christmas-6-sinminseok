package christmas.view;

import christmas.dto.MenuItemDto;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String START_PLANNER_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_PREVIEW_MESSAGE = "12월 {0}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = NEXT_LINE + "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT_PRICE_MESSAGE = NEXT_LINE + "<할인 전 총주문 금액>";
    private static final String MENU_INFORMATION = "{0} {1}개";
    private static final String PRICE_UNIT = "원";

    public static void printStartMessage() {
        System.out.println(START_PLANNER_MESSAGE);
    }

    public static void printEventPreview(LocalDate localDate) {
        System.out.println(MessageFormat.format(EVENT_PREVIEW_MESSAGE, localDate.getDayOfMonth()));
    }

    public static void printOrderMenu(List<MenuItemDto> orderMenus) {
        System.out.println(ORDER_MENU_MESSAGE);
        orderMenus.stream()
                .forEach(orderMenuDto -> System.out.println(formatMenu(orderMenuDto)));
    }

    public static void printBeforeDiscountPrice(Integer price) {
        System.out.println(BEFORE_DISCOUNT_PRICE_MESSAGE);
        System.out.println(formatPrice(price) + PRICE_UNIT);
    }

    private static String formatPrice(int price) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(price);
    }

    private static String formatMenu(MenuItemDto orderMenu) {
        return MessageFormat.format(MENU_INFORMATION, orderMenu.getMenuName(), orderMenu.getAmount());
    }
}
