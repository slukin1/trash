package org.hamcrest.core;

import java.lang.reflect.Array;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsEqual<T> extends BaseMatcher<T> {
    private final Object expectedValue;

    public IsEqual(T t11) {
        this.expectedValue = t11;
    }

    private static boolean areArrayElementsEqual(Object obj, Object obj2) {
        for (int i11 = 0; i11 < Array.getLength(obj); i11++) {
            if (!areEqual(Array.get(obj, i11), Array.get(obj2, i11))) {
                return false;
            }
        }
        return true;
    }

    private static boolean areArrayLengthsEqual(Object obj, Object obj2) {
        return Array.getLength(obj) == Array.getLength(obj2);
    }

    private static boolean areArraysEqual(Object obj, Object obj2) {
        return areArrayLengthsEqual(obj, obj2) && areArrayElementsEqual(obj, obj2);
    }

    private static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null || !isArray(obj)) {
            return obj.equals(obj2);
        }
        if (!isArray(obj2) || !areArraysEqual(obj, obj2)) {
            return false;
        }
        return true;
    }

    @Factory
    public static <T> Matcher<T> equalTo(T t11) {
        return new IsEqual(t11);
    }

    private static boolean isArray(Object obj) {
        return obj.getClass().isArray();
    }

    public void describeTo(Description description) {
        description.appendValue(this.expectedValue);
    }

    public boolean matches(Object obj) {
        return areEqual(obj, this.expectedValue);
    }
}
