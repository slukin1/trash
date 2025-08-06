package org.hamcrest.collection;

import java.util.Collection;
import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

public class IsCollectionWithSize<E> extends FeatureMatcher<Collection<? extends E>, Integer> {
    public IsCollectionWithSize(Matcher<? super Integer> matcher) {
        super(matcher, "a collection with size", "collection size");
    }

    @Factory
    public static <E> Matcher<Collection<? extends E>> hasSize(Matcher<? super Integer> matcher) {
        return new IsCollectionWithSize(matcher);
    }

    @Factory
    public static <E> Matcher<Collection<? extends E>> hasSize(int i11) {
        return hasSize((Matcher<? super Integer>) IsEqual.equalTo(Integer.valueOf(i11)));
    }

    public Integer featureValueOf(Collection<? extends E> collection) {
        return Integer.valueOf(collection.size());
    }
}
