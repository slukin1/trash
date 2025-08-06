package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;
import java.util.List;
import org.hamcrest.Matcher;

public final class NoMatchingViewException extends RuntimeException {
    /* access modifiers changed from: private */
    public EspressoOptional<String> adapterViewWarning;
    /* access modifiers changed from: private */
    public List<View> adapterViews;
    /* access modifiers changed from: private */
    public boolean includeViewHierarchy;
    /* access modifiers changed from: private */
    public View rootView;
    /* access modifiers changed from: private */
    public Matcher<? super View> viewMatcher;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Matcher<? super View> f11085a;

        /* renamed from: b  reason: collision with root package name */
        public View f11086b;

        /* renamed from: c  reason: collision with root package name */
        public List<View> f11087c = Lists.g();

        /* renamed from: d  reason: collision with root package name */
        public boolean f11088d = true;

        /* renamed from: e  reason: collision with root package name */
        public EspressoOptional<String> f11089e = EspressoOptional.a();

        /* renamed from: f  reason: collision with root package name */
        public Throwable f11090f;
    }

    private static String getErrorMessage(Builder builder) {
        if (builder.f11088d) {
            String format = String.format("No views in hierarchy found matching: %s", new Object[]{builder.f11085a});
            if (builder.f11089e.c()) {
                String valueOf = String.valueOf(format);
                String valueOf2 = String.valueOf((String) builder.f11089e.b());
                format = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            }
            return HumanReadables.b(builder.f11086b, (List<View>) null, format, (String) null);
        }
        return String.format("Could not find a view that matches %s", new Object[]{builder.f11085a});
    }

    public String getViewMatcherDescription() {
        Matcher<? super View> matcher = this.viewMatcher;
        return matcher != null ? matcher.toString() : "unknown";
    }

    private NoMatchingViewException(String str) {
        super(str);
        this.adapterViews = Lists.g();
        this.includeViewHierarchy = true;
        this.adapterViewWarning = EspressoOptional.a();
    }

    private NoMatchingViewException(Builder builder) {
        super(getErrorMessage(builder), builder.f11090f);
        this.adapterViews = Lists.g();
        this.includeViewHierarchy = true;
        this.adapterViewWarning = EspressoOptional.a();
        this.viewMatcher = builder.f11085a;
        this.rootView = builder.f11086b;
        this.adapterViews = builder.f11087c;
        this.adapterViewWarning = builder.f11089e;
        this.includeViewHierarchy = builder.f11088d;
    }
}
