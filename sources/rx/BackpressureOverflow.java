package rx;

import rx.exceptions.MissingBackpressureException;

public final class BackpressureOverflow {
    public static final Strategy ON_OVERFLOW_DEFAULT;
    public static final Strategy ON_OVERFLOW_DROP_LATEST = DropLatest.INSTANCE;
    public static final Strategy ON_OVERFLOW_DROP_OLDEST = DropOldest.INSTANCE;
    public static final Strategy ON_OVERFLOW_ERROR;

    public static final class DropLatest implements Strategy {
        public static final DropLatest INSTANCE = new DropLatest();

        private DropLatest() {
        }

        public boolean mayAttemptDrop() {
            return false;
        }
    }

    public static final class DropOldest implements Strategy {
        public static final DropOldest INSTANCE = new DropOldest();

        private DropOldest() {
        }

        public boolean mayAttemptDrop() {
            return true;
        }
    }

    public static final class Error implements Strategy {
        public static final Error INSTANCE = new Error();

        private Error() {
        }

        public boolean mayAttemptDrop() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    static {
        Error error = Error.INSTANCE;
        ON_OVERFLOW_ERROR = error;
        ON_OVERFLOW_DEFAULT = error;
    }

    private BackpressureOverflow() {
        throw new IllegalStateException("No instances!");
    }
}
