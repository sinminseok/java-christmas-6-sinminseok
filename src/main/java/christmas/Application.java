package christmas;

import christmas.controller.MainController;

import static christmas.config.AppConfig.*;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(getMenuService(), getOrderService(), getCalendarService(), getEventService());
        mainController.run();
    }
}
