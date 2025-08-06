package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Landroidx/window/layout/b;", "", "Landroid/app/Activity;", "activity", "Landroid/graphics/Rect;", "a", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f12106a = new b();

    public final Rect a(Activity activity) {
        return activity.getWindowManager().getCurrentWindowMetrics().getBounds();
    }
}
