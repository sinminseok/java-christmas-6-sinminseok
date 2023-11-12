package christmas.controller;

import christmas.service.CalendarService;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.config.AppConfig.getInputView;
import static christmas.config.AppConfig.getOutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private final MenuService menuService;
    private final CalendarService calendarService;
    private final EventService eventService;

    public MainController(MenuService menuService, CalendarService calendarService, EventService eventService) {
        this.inputView = getInputView();
        this.outputView = getOutputView();
        this.menuService = menuService;
        this.calendarService = calendarService;
        this.eventService = eventService;
    }

    public void run() {

    }
}
