package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.MenuAmountDto;
import christmas.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

import static christmas.utils.Parser.*;
import static christmas.view.InputValidator.validateOrder;
import static christmas.view.InputValidator.validateVisitDay;

public class InputView {
    private static final String INPUT_VISIT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_INFORMATION_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static Integer readVisitDay() {
        System.out.println(INPUT_VISIT_DAY_MESSAGE);
        String input = Console.readLine();
        validateVisitDay(input);
        return parseInteger(input);
    }

    public static OrderDto readOrder() {
        System.out.println(INPUT_ORDER_INFORMATION_MESSAGE);
        String input = Console.readLine();
        validateOrder(input);
        return toInputOrderDto(input);
    }

    private static OrderDto toInputOrderDto(String input) {
        List<String> informations = splitByComma(input);
        List<MenuAmountDto> menuAmountDtos = informations.stream()
                .map(InputView::parseOrderMenu)
                .collect(Collectors.toList());
        return new OrderDto(menuAmountDtos);
    }

    private static MenuAmountDto parseOrderMenu(String information) {
        List<String> strings = splitNameAndAmount(information);
        String menuName = strings.get(0);
        Integer amount = parseInteger(strings.get(1));
        return new MenuAmountDto(menuName, amount);
    }
}
