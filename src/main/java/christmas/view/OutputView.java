package christmas.view;

import christmas.domain.plan.Badge;
import christmas.dto.MenuItemDto;
import christmas.dto.RewardDto;

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
    private static final String GIFT_REWARD_MESSAGE = NEXT_LINE + "<증정 메뉴>";
    private static final String REWARD_MESSAGE = NEXT_LINE + "<혜택 내역>";
    private static final String TOTAL_DISCOUNT_PRICE_MESSAGE = NEXT_LINE + "<총혜택 금액>";
    private static final String AFTER_DISCOUNT_PRICE_MESSAGE = NEXT_LINE + "<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = NEXT_LINE + "<12월 이벤트 배지>";
    private static final String MENU_INFORMATION = "{0} {1}개";
    private static final String REWARD_INFORMATION = "{0}: -{1}원";
    private static final String PRICE_UNIT = "원";
    private static final String NONE = "없음";
    private static final String MINUS = "-";
    private static final Integer ZERO = 0;

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

    public static void printGiftReward(List<MenuItemDto> rewards) {
        System.out.println(GIFT_REWARD_MESSAGE);
        if (rewards.size() == ZERO) {
            System.out.println(NONE);
            return;
        }
        rewards.stream()
                .forEach(menuDto -> System.out.println(formatMenu(menuDto)));
    }

    public static void printRewards(List<RewardDto> rewards) {
        System.out.println(REWARD_MESSAGE);
        if (rewards.size() == ZERO) {
            System.out.println(NONE);
            return;
        }
        rewards.stream()
                .forEach(rewardDiscount -> System.out.println(formatReward(rewardDiscount)));
    }

    public static void printTotalDiscountPrice(int price) {
        System.out.println(TOTAL_DISCOUNT_PRICE_MESSAGE);
        if (price == ZERO) {
            System.out.println(price + PRICE_UNIT);
            return;
        }
        System.out.println(MINUS + formatPrice(price));
    }

    public static void printAfterDiscountPrice(int price) {
        System.out.println(AFTER_DISCOUNT_PRICE_MESSAGE);
        System.out.println(formatPrice(price) + PRICE_UNIT);
    }

    public static void printBadge(Badge badge) {
        System.out.println(BADGE_MESSAGE);
        System.out.println(badge.getName());
    }

    private static String formatPrice(int price) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(price);
    }

    private static String formatMenu(MenuItemDto orderMenu) {
        return MessageFormat.format(MENU_INFORMATION, orderMenu.getMenuName(), orderMenu.getAmount());
    }

    private static String formatReward(RewardDto rewardDto) {
        return MessageFormat.format(REWARD_INFORMATION, rewardDto.getName(), formatPrice(rewardDto.getDiscountPrice()));
    }
}
