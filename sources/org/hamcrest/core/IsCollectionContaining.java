package org.hamcrest.core;

import java.util.ArrayList;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class IsCollectionContaining<T> extends TypeSafeDiagnosingMatcher<Iterable<? super T>> {
    private final Matcher<? super T> elementMatcher;

    public IsCollectionContaining(Matcher<? super T> matcher) {
        this.elementMatcher = matcher;
    }

    @Factory
    public static <T> Matcher<Iterable<? super T>> hasItem(Matcher<? super T> matcher) {
        return new IsCollectionContaining(matcher);
    }

    @Factory
    public static <T> Matcher<Iterable<T>> hasItems(Matcher<? super T>... matcherArr) {
        ArrayList arrayList = new ArrayList(matcherArr.length);
        for (Matcher<? super T> isCollectionContaining : matcherArr) {
            arrayList.add(new IsCollectionContaining(isCollectionContaining));
        }
        return AllOf.allOf(arrayList);
    }

    public void describeTo(Description description) {
        description.appendText("a collection containing ").appendDescriptionOf(this.elementMatcher);
    }

    @Factory
    public static <T> Matcher<Iterable<? super T>> hasItem(T t11) {
        return new IsCollectionContaining(IsEqual.equalTo(t11));
    }

    public boolean matchesSafely(Iterable<? super T> iterable, Description description) {
        boolean z11 = false;
        for (Object next : iterable) {
            if (this.elementMatcher.matches(next)) {
                return true;
            }
            if (z11) {
                description.appendText(", ");
            }
            this.elementMatcher.describeMismatch(next, description);
            z11 = true;
        }
        return false;
    }

    @Factory
    public static <T> Matcher<Iterable<T>> hasItems(T... tArr) {
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T hasItem : tArr) {
            arrayList.add(hasItem(hasItem));
        }
        return AllOf.allOf(arrayList);
    }
}
