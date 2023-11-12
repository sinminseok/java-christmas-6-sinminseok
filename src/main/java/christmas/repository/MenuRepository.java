package christmas.repository;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(Menu.of("양송이수프", 6000, MenuType.APPETIZER));
        menus.add(Menu.of("타파스", 5500, MenuType.APPETIZER));
        menus.add(Menu.of("시저샐러드", 8000, MenuType.APPETIZER));

        menus.add(Menu.of("티본스테이크", 55000, MenuType.MAIN));
        menus.add(Menu.of("바비큐립", 54000, MenuType.MAIN));
        menus.add(Menu.of("해산물파스타", 35000, MenuType.MAIN));
        menus.add(Menu.of("크리스마스파스타", 25000, MenuType.MAIN));

        menus.add(Menu.of("초코케이크", 15000, MenuType.DESERT));
        menus.add(Menu.of("아이스크림", 5000, MenuType.DESERT));

        menus.add(Menu.of("제로콜라", 3000, MenuType.DRINKING));
        menus.add(Menu.of("레드와인", 6000, MenuType.DRINKING));
        menus.add(Menu.of("샴페인", 25000, MenuType.DRINKING));
    }
}
