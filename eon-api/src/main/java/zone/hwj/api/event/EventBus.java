package zone.hwj.api.event;

public interface EventBus {
    void publish(Event<?> event);
    void subscribe(String topic, EventHandler<?> handler);

    interface EventHandler<T> {
        void handle(Event<T> event);
    }
}
