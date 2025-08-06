package org.hamcrest.collection;

import java.util.Arrays;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsArray<T> extends TypeSafeMatcher<T[]> {
    private final Matcher<? super T>[] elementMatchers;

    public IsArray(Matcher<? super T>[] matcherArr) {
        this.elementMatchers = (Matcher[]) matcherArr.clone();
    }

    @Factory
    public static <T> IsArray<T> array(Matcher<? super T>... matcherArr) {
        return new IsArray<>(matcherArr);
    }

    public void describeTo(Description description) {
        description.appendList(descriptionStart(), descriptionSeparator(), descriptionEnd(), Arrays.asList(this.elementMatchers));
    }

    public String descriptionEnd() {
        return "]";
    }

    public String descriptionSeparator() {
        return ", ";
    }

    public String descriptionStart() {
        return "[";
    }

    public void describeMismatchSafely(T[] tArr, Description description) {
        if (tArr.length != this.elementMatchers.length) {
            description.appendText("array length was " + tArr.length);
            return;
        }
        for (int i11 = 0; i11 < tArr.length; i11++) {
            if (!this.elementMatchers[i11].matches(tArr[i11])) {
                description.appendText("element " + i11 + " was ").appendValue(tArr[i11]);
                return;
            }
        }
    }

    public boolean matchesSafely(T[] tArr) {
        if (tArr.length != this.elementMatchers.length) {
            return false;
        }
        for (int i11 = 0; i11 < tArr.length; i11++) {
            if (!this.elementMatchers[i11].matches(tArr[i11])) {
                return false;
            }
        }
        return true;
    }
}
