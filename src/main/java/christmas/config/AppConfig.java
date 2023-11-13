package christmas.config;

import christmas.repository.CalendarRepository;
import christmas.repository.CustomerRepository;
import christmas.repository.EventRepository;
import christmas.repository.MenuRepository;
import christmas.service.*;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static final CalendarRepository calendarRepository = new CalendarRepository();
    private static final MenuRepository menuRepository = new MenuRepository();
    private static final EventRepository eventRepository = new EventRepository();
    private static final CustomerRepository customerRepository = new CustomerRepository();

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

    public static PlanService getPlanService() {
        return new PlanService();
    }

    public static CustomerService getCustomerService() {
        return new CustomerService(customerRepository);
    }

    public static OrderService getOrderService() {
        return new OrderService(menuRepository);
    }

}
