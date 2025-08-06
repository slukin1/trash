package androidx.test.espresso.base;

import junit.framework.AssertionFailedError;

final class DefaultFailureHandler$AssertionFailedWithCauseError extends AssertionFailedError {
    public DefaultFailureHandler$AssertionFailedWithCauseError(String str, Throwable th2) {
        super(str);
        initCause(th2);
    }
}
