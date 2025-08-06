package org.hamcrest.beans;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HasProperty<T> extends TypeSafeMatcher<T> {
    private final String propertyName;

    public HasProperty(String str) {
        this.propertyName = str;
    }

    @Factory
    public static <T> Matcher<T> hasProperty(String str) {
        return new HasProperty(str);
    }

    public void describeMismatchSafely(T t11, Description description) {
        description.appendText("no ").appendValue(this.propertyName).appendText(" in ").appendValue(t11);
    }

    public void describeTo(Description description) {
        description.appendText("hasProperty(").appendValue(this.propertyName).appendText(")");
    }

    public boolean matchesSafely(T t11) {
        try {
            return PropertyUtil.getPropertyDescriptor(this.propertyName, t11) != null;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }
}
