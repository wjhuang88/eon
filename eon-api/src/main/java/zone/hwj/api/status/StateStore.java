package zone.hwj.api.status;

public interface StateStore {
    <T> T load(String key);
    <T> void save(String key, T value);
}
