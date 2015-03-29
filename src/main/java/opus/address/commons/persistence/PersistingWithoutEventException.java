package opus.address.commons.persistence;

public final class PersistingWithoutEventException extends RuntimeException {

    public PersistingWithoutEventException() {
        super("Attempting to persist data without associating to an event.");
    }
}
