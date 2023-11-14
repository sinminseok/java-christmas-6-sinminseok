package christmas.repository;

import christmas.domain.event.Event;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EventRepositoryTest {

    @Test
    void findAll_메서드는_저장된_모든_이벤트를_찾는다() {
        //when
        List<Event> events = EventRepository.findAll();
        //then
        Assertions.assertThat(events.size()).isEqualTo(5);
    }
}
