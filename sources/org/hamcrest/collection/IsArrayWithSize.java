package org.hamcrest.collection;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.DescribedAs;
import org.hamcrest.core.IsEqual;

public class IsArrayWithSize<E> extends FeatureMatcher<E[], Integer> {
    public IsArrayWithSize(Matcher<? super Integer> matcher) {
        super(matcher, "an array with size", "array size");
    }

    @Factory
    public static <E> Matcher<E[]> arrayWithSize(Matcher<? super Integer> matcher) {
        return new IsArrayWithSize(matcher);
    }

    @Factory
    public static <E> Matcher<E[]> emptyArray() {
        return DescribedAs.describedAs("an empty array", arrayWithSize(0), new Object[0]);
    }

    @Factory
    public static <E> Matcher<E[]> arrayWithSize(int i11) {
        return arrayWithSize((Matcher<? super Integer>) IsEqual.equalTo(Integer.valueOf(i11)));
    }

    public Integer featureValueOf(E[] eArr) {
        return Integer.valueOf(eArr.length);
    }
}
