package org.hamcrest.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.IsEqual;

public class IsIterableContainingInAnyOrder<T> extends TypeSafeDiagnosingMatcher<Iterable<? extends T>> {
    private final Collection<Matcher<? super T>> matchers;

    public static class Matching<S> {
        private final Collection<Matcher<? super S>> matchers;
        private final Description mismatchDescription;

        public Matching(Collection<Matcher<? super S>> collection, Description description) {
            this.matchers = new ArrayList(collection);
            this.mismatchDescription = description;
        }

        private boolean isMatched(S s11) {
            for (Matcher next : this.matchers) {
                if (next.matches(s11)) {
                    this.matchers.remove(next);
                    return true;
                }
            }
            this.mismatchDescription.appendText("Not matched: ").appendValue(s11);
            return false;
        }

        private boolean isNotSurplus(S s11) {
            if (!this.matchers.isEmpty()) {
                return true;
            }
            this.mismatchDescription.appendText("Not matched: ").appendValue(s11);
            return false;
        }

        public boolean isFinished(Iterable<? extends S> iterable) {
            if (this.matchers.isEmpty()) {
                return true;
            }
            this.mismatchDescription.appendText("No item matches: ").appendList("", ", ", "", this.matchers).appendText(" in ").appendValueList("[", ", ", "]", iterable);
            return false;
        }

        public boolean matches(S s11) {
            return isNotSurplus(s11) && isMatched(s11);
        }
    }

    public IsIterableContainingInAnyOrder(Collection<Matcher<? super T>> collection) {
        this.matchers = collection;
    }

    @Deprecated
    @Factory
    public static <E> Matcher<Iterable<? extends E>> containsInAnyOrder(Matcher<? super E> matcher) {
        return containsInAnyOrder(new ArrayList(Arrays.asList(new Matcher[]{matcher})));
    }

    public void describeTo(Description description) {
        description.appendText("iterable over ").appendList("[", ", ", "]", this.matchers).appendText(" in any order");
    }

    @Factory
    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Matcher<? super T>... matcherArr) {
        return containsInAnyOrder(Arrays.asList(matcherArr));
    }

    public boolean matchesSafely(Iterable<? extends T> iterable, Description description) {
        Matching matching = new Matching(this.matchers, description);
        for (Object matches : iterable) {
            if (!matching.matches(matches)) {
                return false;
            }
        }
        return matching.isFinished(iterable);
    }

    @Factory
    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T equalTo : tArr) {
            arrayList.add(IsEqual.equalTo(equalTo));
        }
        return new IsIterableContainingInAnyOrder(arrayList);
    }

    @Factory
    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Collection<Matcher<? super T>> collection) {
        return new IsIterableContainingInAnyOrder(collection);
    }
}
