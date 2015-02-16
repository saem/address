package opus.address.commons;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Try<T> {
    private Try() {
    }

    public static <T> Try<T> failure(Exception e) {
        return new Failure<>(e);
    }

    public static <T> Try<T> success(T value) {
        return new Success<>(value);
    }

    public static <T> Try<T> attempt(Callable<T> callable) {
        try {
            return Success.success((T) callable.call());
        } catch (Exception e) {
            return Failure.failure(e);
        }
    }

    /**
     * Return true if there is a value present, otherwise false
     *
     * @return Boolean
     */
    public abstract Boolean isSuccess();

    /**
     * Return true if there is not value present, otherwise false
     *
     * @return Boolean
     */
    public abstract Boolean isFailure();

    /**
     *
     */
    public abstract void throwException();

    abstract public Optional<T> filter(Predicate<? super T> predicate);

    abstract public <U> Try<U> flatMap(Function<? super T, Try<U>> mapper);

    abstract public T get();

    public void ifSuccess(Consumer<? super T> consumer) {
        if (isSuccess()) {
            consumer.accept(get());
        }
    }

    abstract public T orElse(T other);

    abstract public T orElseGet(Supplier<? extends T> other);

    abstract public T orElseGet(Function<Try, ? extends T> other);

    abstract public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X;

    abstract public RuntimeException getException();

    abstract public <U> Try<U> map(Function<? super T, ? extends U> mapper);

    @Override
    public int hashCode() {
        return isSuccess() ? get().hashCode() : 0;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Try && (
                (((Try) other).isFailure() && this.isFailure()) ||
                        (((Try) other).isSuccess() && this.isSuccess() && ((Success) other).get().equals(((Success) this).get()))
        );
    }

    abstract public String toString();

    private static class Failure<V> extends Try<V> {
        final private RuntimeException exception;

        public Failure(Exception e) {
            super();
            this.exception = new RuntimeException(e);
        }

        @Override
        public Boolean isSuccess() {
            return false;
        }

        @Override
        public Boolean isFailure() {
            return true;
        }

        @Override
        public void throwException() {
            throw exception;
        }

        @Override
        public Optional<V> filter(Predicate<? super V> predicate) {
            return Optional.empty();
        }

        @Override
        @SuppressWarnings("unchecked")
        public <U> Try<U> flatMap(Function<? super V, Try<U>> mapper) {
            return (Try<U>) this;
        }

        @Override
        public V get() {
            throw new NoSuchElementException();
        }

        @Override
        public V orElse(V other) {
            return other;
        }

        @Override
        public V orElseGet(Supplier<? extends V> other) {
            return other.get();
        }

        @Override
        public V orElseGet(Function<Try, ? extends V> other) {
            return other.apply(this);
        }

        @Override
        public <X extends Throwable> V orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
            throw exceptionSupplier.get();
        }

        @Override
        public RuntimeException getException() {
            return exception;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <U> Try<U> map(Function<? super V, ? extends U> mapper) {
            return (Try<U>) this;
        }

        @Override
        public String toString() {
            return "Failure <" + exception.getClass().toString() + "> " + exception.toString();
        }
    }

    private static class Success<V> extends Try<V> {
        final private V value;

        public Success(V value) {
            super();
            this.value = value;
        }

        public V get() {
            return value;
        }

        @Override
        public V orElse(V other) {
            return value;
        }

        @Override
        public V orElseGet(Supplier<? extends V> other) {
            return value;
        }

        @Override
        public V orElseGet(Function<Try, ? extends V> other) {
            return value;
        }

        @Override
        public <X extends Throwable> V orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
            return value;
        }

        @Override
        public RuntimeException getException() {
            throw new RuntimeException("Getting exception on successful try -- this is likely a bug");
        }

        @Override
        public <U> Try<U> map(Function<? super V, ? extends U> mapper) {
            return Try.attempt(() -> mapper.apply(value));
        }

        @Override
        public String toString() {
            return "Success<" + value.getClass().toString() + "> " + value.toString();
        }

        @Override
        public Boolean isSuccess() {
            return true;
        }

        @Override
        public Boolean isFailure() {
            return false;
        }

        @Override
        public void throwException() {
            throw new RuntimeException("Throwing exception on successful try -- this is likely a bug");
        }

        @Override
        public Optional<V> filter(Predicate<? super V> predicate) {
            return predicate.test(value) ? Optional.ofNullable(value) : Optional.empty();
        }

        @Override
        public <U> Try<U> flatMap(Function<? super V, Try<U>> mapper) {
            return mapper.apply(value);
        }
    }
}
