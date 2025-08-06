package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.util.HumanReadables;
import org.hamcrest.Matcher;

public final class AmbiguousViewMatcherException extends RuntimeException {
    /* access modifiers changed from: private */
    public View[] others;
    /* access modifiers changed from: private */
    public View rootView;
    /* access modifiers changed from: private */
    public View view1;
    /* access modifiers changed from: private */
    public View view2;
    /* access modifiers changed from: private */
    public Matcher<? super View> viewMatcher;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Matcher<? super View> f11069a;

        /* renamed from: b  reason: collision with root package name */
        public View f11070b;

        /* renamed from: c  reason: collision with root package name */
        public View f11071c;

        /* renamed from: d  reason: collision with root package name */
        public View f11072d;

        /* renamed from: e  reason: collision with root package name */
        public View[] f11073e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11074f = true;
    }

    private static String getErrorMessage(Builder builder) {
        if (builder.f11074f) {
            ImmutableSet h11 = ImmutableSet.builder().f(builder.f11071c, builder.f11072d).f(builder.f11073e).h();
            return HumanReadables.b(builder.f11070b, Lists.h(h11), String.format("'%s' matches multiple views in the hierarchy.", new Object[]{builder.f11069a}), "****MATCHES****");
        }
        return String.format("Multiple Ambiguous Views found for matcher %s", new Object[]{builder.f11069a});
    }

    private AmbiguousViewMatcherException(String str) {
        super(str);
    }

    private AmbiguousViewMatcherException(Builder builder) {
        super(getErrorMessage(builder));
        this.viewMatcher = builder.f11069a;
        this.rootView = builder.f11070b;
        this.view1 = builder.f11071c;
        this.view2 = builder.f11072d;
        this.others = builder.f11073e;
    }
}
