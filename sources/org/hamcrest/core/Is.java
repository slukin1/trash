package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class Is<T> extends BaseMatcher<T> {
    private final Matcher<T> matcher;

    public Is(Matcher<T> matcher2) {
        this.matcher = matcher2;
    }

    @Factory
    public static <T> Matcher<T> is(Matcher<T> matcher2) {
        return new Is(matcher2);
    }

    @Factory
    public static <T> Matcher<T> isA(Class<T> cls) {
        return is(IsInstanceOf.instanceOf(cls));
    }

    public void describeMismatch(Object obj, Description description) {
        this.matcher.describeMismatch(obj, description);
    }

    public void describeTo(Description description) {
        description.appendText("is ").appendDescriptionOf(this.matcher);
    }

    public boolean matches(Object obj) {
        return this.matcher.matches(obj);
    }

    @Factory
    public static <T> Matcher<T> is(T t11) {
        return is(IsEqual.equalTo(t11));
    }

    @Deprecated
    @Factory
    public static <T> Matcher<T> is(Class<T> cls) {
        return is(IsInstanceOf.instanceOf(cls));
    }
}
