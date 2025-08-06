package org.hamcrest;

public abstract class Condition<T> {
    public static final NotMatched<Object> NOT_MATCHED = new NotMatched<>();

    public static final class Matched<T> extends Condition<T> {
        private final Description mismatch;
        private final T theValue;

        public <U> Condition<U> and(Step<? super T, U> step) {
            return step.apply(this.theValue, this.mismatch);
        }

        public boolean matching(Matcher<T> matcher, String str) {
            if (matcher.matches(this.theValue)) {
                return true;
            }
            this.mismatch.appendText(str);
            matcher.describeMismatch(this.theValue, this.mismatch);
            return false;
        }

        private Matched(T t11, Description description) {
            super();
            this.theValue = t11;
            this.mismatch = description;
        }
    }

    public static final class NotMatched<T> extends Condition<T> {
        private NotMatched() {
            super();
        }

        public <U> Condition<U> and(Step<? super T, U> step) {
            return Condition.notMatched();
        }

        public boolean matching(Matcher<T> matcher, String str) {
            return false;
        }
    }

    public interface Step<I, O> {
        Condition<O> apply(I i11, Description description);
    }

    public static <T> Condition<T> matched(T t11, Description description) {
        return new Matched(t11, description);
    }

    public static <T> Condition<T> notMatched() {
        return NOT_MATCHED;
    }

    public abstract <U> Condition<U> and(Step<? super T, U> step);

    public final boolean matching(Matcher<T> matcher) {
        return matching(matcher, "");
    }

    public abstract boolean matching(Matcher<T> matcher, String str);

    public final <U> Condition<U> then(Step<? super T, U> step) {
        return and(step);
    }

    private Condition() {
    }
}
