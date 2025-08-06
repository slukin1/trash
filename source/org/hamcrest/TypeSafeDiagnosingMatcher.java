package org.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.internal.ReflectiveTypeFinder;

public abstract class TypeSafeDiagnosingMatcher<T> extends BaseMatcher<T> {
    private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("matchesSafely", 2, 0);
    private final Class<?> expectedType;

    public TypeSafeDiagnosingMatcher(Class<?> cls) {
        this.expectedType = cls;
    }

    public final void describeMismatch(Object obj, Description description) {
        if (obj == null || !this.expectedType.isInstance(obj)) {
            super.describeMismatch(obj, description);
        } else {
            matchesSafely(obj, description);
        }
    }

    public final boolean matches(Object obj) {
        return obj != null && this.expectedType.isInstance(obj) && matchesSafely(obj, new Description.NullDescription());
    }

    public abstract boolean matchesSafely(T t11, Description description);

    public TypeSafeDiagnosingMatcher(ReflectiveTypeFinder reflectiveTypeFinder) {
        this.expectedType = reflectiveTypeFinder.findExpectedType(getClass());
    }

    public TypeSafeDiagnosingMatcher() {
        this(TYPE_FINDER);
    }
}
