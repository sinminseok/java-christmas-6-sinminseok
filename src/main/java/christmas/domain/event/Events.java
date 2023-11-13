package christmas.domain.event;

import christmas.domain.menu.OrderMenu;

import java.util.List;
import java.util.stream.Collectors;

public class Events {
    private final List<Event> events;

    public Events(List<Event> events) {
        this.events = events;
    }

    public List<Reward> findRewards(EventRewardContext context) {
        return events.stream()
                .map(event -> event.findReward(context))
                .collect(Collectors.toList());
    }

    public List<OrderMenu> findMenuRewards(EventRewardContext context) {
        return events.stream()
                .filter(Event::isGiftEvent)
                .map(event -> event.wrapMenuItemReward(context))
                .collect(Collectors.toList());

    }
}
