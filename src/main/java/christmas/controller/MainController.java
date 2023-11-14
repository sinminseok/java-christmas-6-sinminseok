package christmas.controller;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.domain.plan.Plan;
import christmas.service.PlanService;
import christmas.service.OrderService;
import christmas.service.CalendarService;
import christmas.service.EventService;
import christmas.service.CustomerService;
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

        CalendarDay day = retryOnException(this::findDay);
        Order order = retryOnException(this::orderMenu);

        Events events = findEvents(order, day);
        Plan plan = buildPlan(events, order, day);

        showDayAndOrder(day, order);
        showPlan(plan);
        saveCustomer(plan);
    }

    private CalendarDay findDay() {
        return calendarService.findByDay(inputView.readVisitDay());
    }

    private Order orderMenu() {
        return orderService.createOrder(inputView.readOrder());
    }

    private Events findEvents(Order order, CalendarDay calendarDay) {
        return eventService.findEvents(order, calendarDay);
    }

    private Plan buildPlan(Events events, Order order, CalendarDay day) {
        return planService.createPlanner(events, order, day);
    }

    private void showDayAndOrder(CalendarDay day, Order order) {
        outputView.printEventPreview(day.getDay());
        outputView.printOrderMenu(order.toDto().getOrderMenus());
    }

    private void showPlan(Plan plan) {
        outputView.printBeforeDiscountPrice(planService.findBeforeDiscountPrice(plan));
        outputView.printGiftReward(planService.findGiftReward(plan));
        outputView.printRewards(planService.findRewards(plan));
        outputView.printTotalDiscountPrice(planService.findTotalRewardPrice(plan));
        outputView.printAfterDiscountPrice(planService.findPayPrice(plan));
        outputView.printBadge(planService.findBadge(plan));
    }

    private void saveCustomer(Plan plan) {
        customerService.save(plan);
    }
}
