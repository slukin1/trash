package org.hamcrest.collection;

import com.xiaomi.mipush.sdk.Constants;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsEmptyIterable<E> extends TypeSafeMatcher<Iterable<? extends E>> {
    @Factory
    public static <E> Matcher<Iterable<? extends E>> emptyIterable() {
        return new IsEmptyIterable();
    }

    @Factory
    public static <E> Matcher<Iterable<E>> emptyIterableOf(Class<E> cls) {
        return emptyIterable();
    }

    public void describeTo(Description description) {
        description.appendText("an empty iterable");
    }

    public void describeMismatchSafely(Iterable<? extends E> iterable, Description description) {
        description.appendValueList("[", Constants.ACCEPT_TIME_SEPARATOR_SP, "]", iterable);
    }

    public boolean matchesSafely(Iterable<? extends E> iterable) {
        return !iterable.iterator().hasNext();
    }
}
