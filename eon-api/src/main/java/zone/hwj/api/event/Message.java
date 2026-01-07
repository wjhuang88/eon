package zone.hwj.api.event;

public record Message<T>(
        String agentFrom,
        String agentTo,
        String topic,
        T payload
) { }
