package org.hamcrest;

public abstract class DiagnosingMatcher<T> extends BaseMatcher<T> {
    public final void describeMismatch(Object obj, Description description) {
        matches(obj, description);
    }

    public final boolean matches(Object obj) {
        return matches(obj, Description.NONE);
    }

    public abstract boolean matches(Object obj, Description description);
}
