package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Landroidx/window/layout/c;", "", "Landroid/view/Display;", "display", "Landroid/graphics/Point;", "point", "", "a", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f12107a = new c();

    public final void a(Display display, Point point) {
        display.getRealSize(point);
    }
}
