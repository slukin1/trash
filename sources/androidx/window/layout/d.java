package androidx.window.layout;

import android.view.DisplayCutout;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/window/layout/d;", "", "Landroid/view/DisplayCutout;", "displayCutout", "", "b", "d", "c", "a", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f12108a = new d();

    public final int a(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}
