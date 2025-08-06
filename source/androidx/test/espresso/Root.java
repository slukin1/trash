package androidx.test.espresso;

import android.view.View;
import android.view.WindowManager;
import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;

public final class Root {

    /* renamed from: a  reason: collision with root package name */
    public final View f11094a;

    /* renamed from: b  reason: collision with root package name */
    public final EspressoOptional<WindowManager.LayoutParams> f11095b;

    public static class Builder {
    }

    public View a() {
        return this.f11094a;
    }

    public EspressoOptional<WindowManager.LayoutParams> b() {
        return this.f11095b;
    }

    public String toString() {
        MoreObjects.ToStringHelper e11 = MoreObjects.b(this).d("application-window-token", this.f11094a.getApplicationWindowToken()).d("window-token", this.f11094a.getWindowToken()).e("has-window-focus", this.f11094a.hasWindowFocus());
        if (this.f11095b.c()) {
            e11.b("layout-params-type", this.f11095b.b().type).d("layout-params-string", this.f11095b.b());
        }
        e11.d("decor-view-string", HumanReadables.a(this.f11094a));
        return e11.toString();
    }
}
