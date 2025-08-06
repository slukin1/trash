package androidx.test.espresso.matcher;

import android.view.View;
import android.widget.TextView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public final class ViewMatchers {

    /* renamed from: androidx.test.espresso.matcher.ViewMatchers$1  reason: invalid class name */
    class AnonymousClass1 extends BoundedMatcher<View, TextView> {
    }

    public enum Visibility {
        VISIBLE(0),
        INVISIBLE(4),
        GONE(8);
        
        private final int value;

        private Visibility(int i11) {
            this.value = i11;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final class WithClassNameMatcher extends TypeSafeMatcher<View> {

        /* renamed from: b  reason: collision with root package name */
        public final Matcher<String> f11367b;

        public /* synthetic */ WithClassNameMatcher(Matcher matcher, AnonymousClass1 r22) {
            this(matcher);
        }

        /* renamed from: a */
        public boolean matchesSafely(View view) {
            return this.f11367b.matches(view.getClass().getName());
        }

        public void describeTo(Description description) {
            description.appendText("with class name: ");
            this.f11367b.describeTo(description);
        }

        public WithClassNameMatcher(Matcher<String> matcher) {
            this.f11367b = matcher;
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [org.hamcrest.Matcher<java.lang.String>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.hamcrest.Matcher<android.view.View> a(org.hamcrest.Matcher<java.lang.String> r2) {
        /*
            androidx.test.espresso.matcher.ViewMatchers$WithClassNameMatcher r0 = new androidx.test.espresso.matcher.ViewMatchers$WithClassNameMatcher
            java.lang.Object r2 = androidx.test.espresso.core.internal.deps.guava.base.Preconditions.i(r2)
            org.hamcrest.Matcher r2 = (org.hamcrest.Matcher) r2
            r1 = 0
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.matcher.ViewMatchers.a(org.hamcrest.Matcher):org.hamcrest.Matcher");
    }
}
