package christmas.controller;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.domain.user.Customer;
import christmas.dto.OrderDto;
import christmas.service.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.config.AppConfig.getInputView;
import static christmas.config.AppConfig.getOutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private final CustomerService customerService;
    private final OrderService orderService;
    private final CalendarService calendarService;
    private final EventService eventService;

    public MainController(CustomerService customerService, OrderService orderService, CalendarService calendarService, EventService eventService) {
        this.inputView = getInputView();
        this.outputView = getOutputView();
        this.customerService = customerService;
        this.orderService = orderService;
        this.calendarService = calendarService;
        this.eventService = eventService;
    }

    public void run() {
        outputView.printStartMessage();
        CalendarDay selectDay = registerVisitDay();
        Order order = registerOrder();
        Events events = findApplicableEvents(order, selectDay);
        Customer customer = customerService.createPlanner(events, order, selectDay);
        showPlanner(customer, selectDay, order);
    }

    private void showPlanner(Customer customer, CalendarDay calendarDay, Order order) {
        outputView.printEventPreview(calendarDay.getDay());
        outputView.printOrderMenu(orderService.findOrderMenus(order));
        outputView.printBeforeDiscountPrice(customerService.findBeforeDiscountPrice(customer));
        outputView.printGiftReward(customerService.findGiftReward(customer));
        outputView.printRewards(customerService.findRewards(customer));
        outputView.printTotalDiscountPrice(customerService.findTotalRewardPrice(customer));
        outputView.printAfterDiscountPrice(customerService.findPayPrice(customer));
        outputView.printBadge(customerService.findBadge(customer));
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
