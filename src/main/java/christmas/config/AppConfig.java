package christmas.config;

import christmas.repository.CalendarRepository;
import christmas.repository.EventRepository;
import christmas.repository.MenuRepository;
import christmas.service.CalendarService;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static final CalendarRepository calendarRepository = new CalendarRepository();
    private static final MenuRepository menuRepository = new MenuRepository();
    private static final EventRepository eventRepository = new EventRepository();

    public static InputView getInputView() {
        return inputView;
    }

    public static OutputView getOutputView() {
        return outputView;
    }

    public static CalendarService getCalendarService() {
        return new CalendarService(calendarRepository);
    }


    public static EventService getEventService() {
        return new EventService(eventRepository);
    }

    public static MenuService getMenuService() {
        return new MenuService(menuRepository);
    }

}
