package org.hamcrest.collection;

import java.util.Iterator;
import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

public class IsIterableWithSize<E> extends FeatureMatcher<Iterable<E>, Integer> {
    public IsIterableWithSize(Matcher<? super Integer> matcher) {
        super(matcher, "an iterable with size", "iterable size");
    }

    @Factory
    public static <E> Matcher<Iterable<E>> iterableWithSize(Matcher<? super Integer> matcher) {
        return new IsIterableWithSize(matcher);
    }

    @Factory
    public static <E> Matcher<Iterable<E>> iterableWithSize(int i11) {
        return iterableWithSize((Matcher<? super Integer>) IsEqual.equalTo(Integer.valueOf(i11)));
    }

    public Integer featureValueOf(Iterable<E> iterable) {
        Iterator<E> it2 = iterable.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            i11++;
            it2.next();
        }
        return Integer.valueOf(i11);
    }
}
