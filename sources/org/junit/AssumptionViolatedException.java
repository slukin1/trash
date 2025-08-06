package org.junit;

import org.hamcrest.Matcher;

public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T> AssumptionViolatedException(T t11, Matcher<T> matcher) {
        super((Object) t11, (Matcher<?>) matcher);
    }

    public <T> AssumptionViolatedException(String str, T t11, Matcher<T> matcher) {
        super(str, t11, matcher);
    }

    public AssumptionViolatedException(String str) {
        super(str);
    }

    public AssumptionViolatedException(String str, Throwable th2) {
        super(str, th2);
    }
}
