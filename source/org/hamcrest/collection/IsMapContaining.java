package org.hamcrest.collection;

import java.util.Map;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsEqual;

public class IsMapContaining<K, V> extends TypeSafeMatcher<Map<? extends K, ? extends V>> {
    private final Matcher<? super K> keyMatcher;
    private final Matcher<? super V> valueMatcher;

    public IsMapContaining(Matcher<? super K> matcher, Matcher<? super V> matcher2) {
        this.keyMatcher = matcher;
        this.valueMatcher = matcher2;
    }

    @Factory
    public static <K, V> Matcher<Map<? extends K, ? extends V>> hasEntry(Matcher<? super K> matcher, Matcher<? super V> matcher2) {
        return new IsMapContaining(matcher, matcher2);
    }

    @Factory
    public static <K> Matcher<Map<? extends K, ?>> hasKey(Matcher<? super K> matcher) {
        return new IsMapContaining(matcher, IsAnything.anything());
    }

    @Factory
    public static <V> Matcher<Map<?, ? extends V>> hasValue(Matcher<? super V> matcher) {
        return new IsMapContaining(IsAnything.anything(), matcher);
    }

    public void describeTo(Description description) {
        description.appendText("map containing [").appendDescriptionOf(this.keyMatcher).appendText("->").appendDescriptionOf(this.valueMatcher).appendText("]");
    }

    @Factory
    public static <K, V> Matcher<Map<? extends K, ? extends V>> hasEntry(K k11, V v11) {
        return new IsMapContaining(IsEqual.equalTo(k11), IsEqual.equalTo(v11));
    }

    @Factory
    public static <K> Matcher<Map<? extends K, ?>> hasKey(K k11) {
        return new IsMapContaining(IsEqual.equalTo(k11), IsAnything.anything());
    }

    @Factory
    public static <V> Matcher<Map<?, ? extends V>> hasValue(V v11) {
        return new IsMapContaining(IsAnything.anything(), IsEqual.equalTo(v11));
    }

    public void describeMismatchSafely(Map<? extends K, ? extends V> map, Description description) {
        description.appendText("map was ").appendValueList("[", ", ", "]", map.entrySet());
    }

    public boolean matchesSafely(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            if (this.keyMatcher.matches(next.getKey()) && this.valueMatcher.matches(next.getValue())) {
                return true;
            }
        }
        return false;
    }
}
