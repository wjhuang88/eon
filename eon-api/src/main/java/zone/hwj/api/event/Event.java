package zone.hwj.api.event;

public interface Event<T> {
    String id();
    Message<T> message();
}
