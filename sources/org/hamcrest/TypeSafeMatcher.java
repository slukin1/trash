package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;

public abstract class TypeSafeMatcher<T> extends BaseMatcher<T> {
    private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("matchesSafely", 1, 0);
    private final Class<?> expectedType;

    public TypeSafeMatcher() {
        this(TYPE_FINDER);
    }

    public final void describeMismatch(Object obj, Description description) {
        if (obj == null) {
            super.describeMismatch(obj, description);
        } else if (!this.expectedType.isInstance(obj)) {
            description.appendText("was a ").appendText(obj.getClass().getName()).appendText(" (").appendValue(obj).appendText(")");
        } else {
            describeMismatchSafely(obj, description);
        }
    }

    public void describeMismatchSafely(T t11, Description description) {
        super.describeMismatch(t11, description);
    }

    public final boolean matches(Object obj) {
        return obj != null && this.expectedType.isInstance(obj) && matchesSafely(obj);
    }

    public abstract boolean matchesSafely(T t11);

    public TypeSafeMatcher(Class<?> cls) {
        this.expectedType = cls;
    }

    public TypeSafeMatcher(ReflectiveTypeFinder reflectiveTypeFinder) {
        this.expectedType = reflectiveTypeFinder.findExpectedType(getClass());
    }
}
