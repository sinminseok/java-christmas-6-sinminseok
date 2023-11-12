package christmas;

import christmas.controller.MainController;

import static christmas.config.AppConfig.*;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(getMenuService(), getCalendarService(), getEventService());
        mainController.run();
    }
}
