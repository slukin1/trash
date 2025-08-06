package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

abstract class ShortcutCombination<T> extends BaseMatcher<T> {
    private final Iterable<Matcher<? super T>> matchers;

    public ShortcutCombination(Iterable<Matcher<? super T>> iterable) {
        this.matchers = iterable;
    }

    public abstract void describeTo(Description description);

    public void describeTo(Description description, String str) {
        description.appendList("(", " " + str + " ", ")", this.matchers);
    }

    public abstract boolean matches(Object obj);

    public boolean matches(Object obj, boolean z11) {
        for (Matcher<? super T> matches : this.matchers) {
            if (matches.matches(obj) == z11) {
                return z11;
            }
        }
        return !z11;
    }
}
