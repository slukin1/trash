package org.hamcrest.collection;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.IsEqual;

public class IsIterableContainingInOrder<E> extends TypeSafeDiagnosingMatcher<Iterable<? extends E>> {
    private final List<Matcher<? super E>> matchers;

    public static class MatchSeries<F> {
        public final List<Matcher<? super F>> matchers;
        private final Description mismatchDescription;
        public int nextMatchIx = 0;

        public MatchSeries(List<Matcher<? super F>> list, Description description) {
            this.mismatchDescription = description;
            if (!list.isEmpty()) {
                this.matchers = list;
                return;
            }
            throw new IllegalArgumentException("Should specify at least one expected element");
        }

        private void describeMismatch(Matcher<? super F> matcher, F f11) {
            Description description = this.mismatchDescription;
            description.appendText("item " + this.nextMatchIx + l.f34627b);
            matcher.describeMismatch(f11, this.mismatchDescription);
        }

        private boolean isMatched(F f11) {
            Matcher matcher = this.matchers.get(this.nextMatchIx);
            if (!matcher.matches(f11)) {
                describeMismatch(matcher, f11);
                return false;
            }
            this.nextMatchIx++;
            return true;
        }

        private boolean isNotSurplus(F f11) {
            if (this.matchers.size() > this.nextMatchIx) {
                return true;
            }
            this.mismatchDescription.appendText("Not matched: ").appendValue(f11);
            return false;
        }

        public boolean isFinished() {
            if (this.nextMatchIx >= this.matchers.size()) {
                return true;
            }
            this.mismatchDescription.appendText("No item matched: ").appendDescriptionOf(this.matchers.get(this.nextMatchIx));
            return false;
        }

        public boolean matches(F f11) {
            return isNotSurplus(f11) && isMatched(f11);
        }
    }

    public IsIterableContainingInOrder(List<Matcher<? super E>> list) {
        this.matchers = list;
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(E... eArr) {
        ArrayList arrayList = new ArrayList();
        for (E equalTo : eArr) {
            arrayList.add(IsEqual.equalTo(equalTo));
        }
        return contains(arrayList);
    }

    public void describeTo(Description description) {
        description.appendText("iterable containing ").appendList("[", ", ", "]", this.matchers);
    }

    public boolean matchesSafely(Iterable<? extends E> iterable, Description description) {
        MatchSeries matchSeries = new MatchSeries(this.matchers, description);
        for (Object matches : iterable) {
            if (!matchSeries.matches(matches)) {
                return false;
            }
        }
        return matchSeries.isFinished();
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(Matcher<? super E> matcher) {
        return contains(new ArrayList(Arrays.asList(new Matcher[]{matcher})));
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(Matcher<? super E>... matcherArr) {
        return contains(Arrays.asList(matcherArr));
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(List<Matcher<? super E>> list) {
        return new IsIterableContainingInOrder(list);
    }
}
