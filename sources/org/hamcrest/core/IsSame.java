package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsSame<T> extends BaseMatcher<T> {
    private final T object;

    public IsSame(T t11) {
        this.object = t11;
    }

    @Factory
    public static <T> Matcher<T> sameInstance(T t11) {
        return new IsSame(t11);
    }

    @Factory
    public static <T> Matcher<T> theInstance(T t11) {
        return new IsSame(t11);
    }

    public void describeTo(Description description) {
        description.appendText("sameInstance(").appendValue(this.object).appendText(")");
    }

    public boolean matches(Object obj) {
        return obj == this.object;
    }
}
