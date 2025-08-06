package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsAnything<T> extends BaseMatcher<T> {
    private final String message;

    public IsAnything() {
        this("ANYTHING");
    }

    @Factory
    public static Matcher<Object> anything() {
        return new IsAnything();
    }

    public void describeTo(Description description) {
        description.appendText(this.message);
    }

    public boolean matches(Object obj) {
        return true;
    }

    public IsAnything(String str) {
        this.message = str;
    }

    @Factory
    public static Matcher<Object> anything(String str) {
        return new IsAnything(str);
    }
}
