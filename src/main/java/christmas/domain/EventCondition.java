package christmas.domain;

import christmas.domain.event_condition.EventApplyParameter;

public interface EventCondition {
    boolean canApplyEvent(EventApplyParameter eventApplyParameter);
}
