package opus.address.commons;

public final class OneTimeSet<V> {
    private boolean notSet = true;
    private V value;

    public void set(V value) {
        if (notSet) {
            this.value = value;
            notSet = false;
        }
    }

    public V get() { return value; }
}
