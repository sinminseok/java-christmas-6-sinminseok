package christmas.controller;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.domain.plan.Plan;
import christmas.service.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.config.AppConfig.getInputView;
import static christmas.config.AppConfig.getOutputView;
import static christmas.utils.Retry.retryOnException;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private final PlanService planService;
    private final OrderService orderService;
    private final CalendarService calendarService;
    private final EventService eventService;
    private final CustomerService customerService;

    public MainController(PlanService planService, OrderService orderService, CalendarService calendarService, EventService eventService, CustomerService customerService) {
        this.inputView = getInputView();
        this.outputView = getOutputView();
        this.planService = planService;
        this.orderService = orderService;
        this.calendarService = calendarService;
        this.eventService = eventService;
        this.customerService = customerService;
    }

    public void run() {
        outputView.printStartMessage();
        CalendarDay selectDay = retryOnException(this::registerVisitDay);
        Order order = retryOnException(this::registerOrder);
        Events events = findApplicableEvents(order, selectDay);
        Plan plan = planService.createPlanner(events, order, selectDay);
        showPlan(plan, selectDay, order);
        saveCustomer(plan);
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

    private void showPlan(Plan plan, CalendarDay calendarDay, Order order) {
        outputView.printEventPreview(calendarDay.getDay());
        outputView.printOrderMenu(orderService.findOrderMenus(order));
        outputView.printBeforeDiscountPrice(planService.findBeforeDiscountPrice(plan));
        outputView.printGiftReward(planService.findGiftReward(plan));
        outputView.printRewards(planService.findRewards(plan));
        outputView.printTotalDiscountPrice(planService.findTotalRewardPrice(plan));
        outputView.printAfterDiscountPrice(planService.findPayPrice(plan));
        outputView.printBadge(planService.findBadge(plan));
    }

    private void saveCustomer(Plan plan) {
        customerService.saveCustomer(plan);
    }

}
