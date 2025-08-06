package org.hamcrest.number;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsCloseTo extends TypeSafeMatcher<Double> {
    private final double delta;
    private final double value;

    public IsCloseTo(double d11, double d12) {
        this.delta = d12;
        this.value = d11;
    }

    private double actualDelta(Double d11) {
        return Math.abs(d11.doubleValue() - this.value) - this.delta;
    }

    @Factory
    public static Matcher<Double> closeTo(double d11, double d12) {
        return new IsCloseTo(d11, d12);
    }

    public void describeTo(Description description) {
        description.appendText("a numeric value within ").appendValue(Double.valueOf(this.delta)).appendText(" of ").appendValue(Double.valueOf(this.value));
    }

    public void describeMismatchSafely(Double d11, Description description) {
        description.appendValue(d11).appendText(" differed by ").appendValue(Double.valueOf(actualDelta(d11)));
    }

    public boolean matchesSafely(Double d11) {
        return actualDelta(d11) <= 0.0d;
    }
}
