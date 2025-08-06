package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.List;
import org.hamcrest.Matcher;

public final class NoMatchingRootException extends RuntimeException {
    private NoMatchingRootException(String str) {
        super(str);
    }

    public static NoMatchingRootException create(Matcher<Root> matcher, List<Root> list) {
        Preconditions.i(matcher);
        Preconditions.i(list);
        return new NoMatchingRootException(String.format("Matcher '%s' did not match any of the following roots: %s", new Object[]{matcher, list}));
    }
}
