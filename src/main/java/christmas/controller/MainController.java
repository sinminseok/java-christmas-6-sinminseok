package christmas.controller;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.dto.OrderDto;
import christmas.service.CalendarService;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.config.AppConfig.getInputView;
import static christmas.config.AppConfig.getOutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private final MenuService menuService;
    private final OrderService orderService;
    private final CalendarService calendarService;
    private final EventService eventService;

    public MainController(MenuService menuService, OrderService orderService, CalendarService calendarService, EventService eventService) {
        this.inputView = getInputView();
        this.outputView = getOutputView();
        this.menuService = menuService;
        this.orderService = orderService;
        this.calendarService = calendarService;
        this.eventService = eventService;
    }

    public void run() {
        outputView.printStartMessage();
        CalendarDay selectDay = registerVisitDay();
        Order order = registerOrder();
        Events events = findApplicableEvents(order, selectDay);
    }

    private Order registerOrder() {
        return orderService.createOrder(inputView.readOrder());
    }

    private CalendarDay registerVisitDay() {
        return calendarService.findByDay(inputView.readVisitDay());
    }

    private Events findApplicableEvents(Order order, CalendarDay calendarDay) {
        return eventService.findApplicableEvents(order, calendarDay);
    }

}
