package androidx.test.espresso.matcher;

import android.app.Activity;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import androidx.test.espresso.Root;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

public final class RootMatchers {

    /* renamed from: a  reason: collision with root package name */
    public static final Matcher<Root> f11365a = Matchers.allOf(d(), Matchers.allOf(Matchers.anyOf(Matchers.allOf(e(), h(c())), g()), f()));

    public static final class HasWindowFocus extends TypeSafeMatcher<View> {
        /* renamed from: a */
        public boolean matchesSafely(View view) {
            return view.hasWindowFocus();
        }

        public void describeTo(Description description) {
            description.appendText("has window focus");
        }
    }

    public static final class HasWindowLayoutParams extends TypeSafeMatcher<Root> {
        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            return root.b().c();
        }

        public void describeTo(Description description) {
            description.appendText("has window layout params");
        }
    }

    public static final class IsDialog extends TypeSafeMatcher<Root> {
        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            int i11 = root.b().b().type;
            if (i11 == 1 || i11 >= 99 || root.a().getWindowToken() != root.a().getApplicationWindowToken()) {
                return false;
            }
            return true;
        }

        public void describeTo(Description description) {
            description.appendText("is dialog");
        }
    }

    public static final class IsFocusable extends TypeSafeMatcher<Root> {
        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            return (root.b().b().flags & 8) != 8;
        }

        public void describeTo(Description description) {
            description.appendText("is focusable");
        }
    }

    public static final class IsPlatformPopup extends TypeSafeMatcher<Root> {
        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            return RootMatchers.h(ViewMatchers.a(Matchers.is(Build.VERSION.SDK_INT >= 23 ? "android.widget.PopupWindow$PopupDecorView" : "android.widget.PopupWindow$PopupViewContainer"))).matches(root);
        }

        public void describeTo(Description description) {
            description.appendText("with decor view of type PopupWindow$PopupViewContainer");
        }
    }

    public static final class IsSubwindowOfCurrentActivity extends TypeSafeMatcher<Root> {
        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            return RootMatchers.b().contains(root.a().getApplicationWindowToken());
        }

        public void describeTo(Description description) {
            description.appendText("is subwindow of current activity");
        }
    }

    public static final class IsSystemAlertWindow extends TypeSafeMatcher<Root> {
        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            int i11 = root.b().b().type;
            return 2000 < i11 && 2999 > i11 && root.a().getWindowToken() == root.a().getApplicationWindowToken();
        }

        public void describeTo(Description description) {
            description.appendText("is system alert window");
        }
    }

    public static final class IsTouchable extends TypeSafeMatcher<Root> {
        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            return (root.b().b().flags & 16) != 16;
        }

        public void describeTo(Description description) {
            description.appendText("is touchable");
        }
    }

    public static final class WithDecorView extends TypeSafeMatcher<Root> {

        /* renamed from: b  reason: collision with root package name */
        public final Matcher<View> f11366b;

        public WithDecorView(Matcher<View> matcher) {
            this.f11366b = matcher;
        }

        /* renamed from: a */
        public boolean matchesSafely(Root root) {
            return this.f11366b.matches(root.a());
        }

        public void describeTo(Description description) {
            description.appendText("with decor view ");
            this.f11366b.describeTo(description);
        }
    }

    public static List<IBinder> b() {
        Collection<Activity> a11 = ActivityLifecycleMonitorRegistry.a().a(Stage.RESUMED);
        if (a11.isEmpty()) {
            Log.w("RootMatchers", "suppressed: NoActivityResumedException(\"At least one activity should be in RESUMED stage.\"");
        }
        ArrayList g11 = Lists.g();
        for (Activity window : a11) {
            g11.add(window.getWindow().getDecorView().getApplicationWindowToken());
        }
        return g11;
    }

    public static Matcher<View> c() {
        return new HasWindowFocus();
    }

    public static Matcher<Root> d() {
        return new HasWindowLayoutParams();
    }

    public static Matcher<Root> e() {
        return new IsDialog();
    }

    public static Matcher<Root> f() {
        return new IsFocusable();
    }

    public static Matcher<Root> g() {
        return new IsSubwindowOfCurrentActivity();
    }

    public static Matcher<Root> h(Matcher<View> matcher) {
        Preconditions.i(matcher);
        return new WithDecorView(matcher);
    }
}
