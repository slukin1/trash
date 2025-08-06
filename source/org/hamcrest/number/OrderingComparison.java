package org.hamcrest.number;

import java.lang.Comparable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class OrderingComparison<T extends Comparable<T>> extends TypeSafeMatcher<T> {
    private static final int EQUAL = 0;
    private static final int GREATER_THAN = 1;
    private static final int LESS_THAN = -1;
    private static final String[] comparisonDescriptions = {"less than", "equal to", "greater than"};
    private final T expected;
    private final int maxCompare;
    private final int minCompare;

    private OrderingComparison(T t11, int i11, int i12) {
        this.expected = t11;
        this.minCompare = i11;
        this.maxCompare = i12;
    }

    private static String asText(int i11) {
        return comparisonDescriptions[Integer.signum(i11) + 1];
    }

    @Factory
    public static <T extends Comparable<T>> Matcher<T> comparesEqualTo(T t11) {
        return new OrderingComparison(t11, 0, 0);
    }

    @Factory
    public static <T extends Comparable<T>> Matcher<T> greaterThan(T t11) {
        return new OrderingComparison(t11, 1, 1);
    }

    @Factory
    public static <T extends Comparable<T>> Matcher<T> greaterThanOrEqualTo(T t11) {
        return new OrderingComparison(t11, 0, 1);
    }

    @Factory
    public static <T extends Comparable<T>> Matcher<T> lessThan(T t11) {
        return new OrderingComparison(t11, -1, -1);
    }

    @Factory
    public static <T extends Comparable<T>> Matcher<T> lessThanOrEqualTo(T t11) {
        return new OrderingComparison(t11, -1, 0);
    }

    public void describeTo(Description description) {
        description.appendText("a value ").appendText(asText(this.minCompare));
        if (this.minCompare != this.maxCompare) {
            description.appendText(" or ").appendText(asText(this.maxCompare));
        }
        description.appendText(" ").appendValue(this.expected);
    }

    public void describeMismatchSafely(T t11, Description description) {
        description.appendValue(t11).appendText(" was ").appendText(asText(t11.compareTo(this.expected))).appendText(" ").appendValue(this.expected);
    }

    public boolean matchesSafely(T t11) {
        int signum = Integer.signum(t11.compareTo(this.expected));
        return this.minCompare <= signum && signum <= this.maxCompare;
    }
}
