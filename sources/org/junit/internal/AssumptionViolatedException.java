package org.junit.internal;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

public class AssumptionViolatedException extends RuntimeException implements SelfDescribing {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final Matcher<?> fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public AssumptionViolatedException(String str, boolean z11, Object obj, Matcher<?> matcher) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fMatcher = matcher;
        this.fValueMatcher = z11;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    public void describeTo(Description description) {
        String str = this.fAssumption;
        if (str != null) {
            description.appendText(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                description.appendText(l.f34627b);
            }
            description.appendText("got: ");
            description.appendValue(this.fValue);
            if (this.fMatcher != null) {
                description.appendText(", expected: ");
                description.appendDescriptionOf(this.fMatcher);
            }
        }
    }

    public String getMessage() {
        return StringDescription.asString(this);
    }

    @Deprecated
    public AssumptionViolatedException(Object obj, Matcher<?> matcher) {
        this((String) null, true, obj, matcher);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Object obj, Matcher<?> matcher) {
        this(str, true, obj, matcher);
    }

    @Deprecated
    public AssumptionViolatedException(String str) {
        this(str, false, (Object) null, (Matcher<?>) null);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Throwable th2) {
        this(str, false, (Object) null, (Matcher<?>) null);
        initCause(th2);
    }
}
