package me.coding.wetter.message;

/**
 * @author G002299
 * @version 2021/3/22
 */
public class SetRequest {

    private final String key;
    private final Object value;

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Set{" + "key='" + key + '\'' + ", value=" + value + '}';
    }
}
