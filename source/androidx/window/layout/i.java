package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.core.b;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.j;
import androidx.window.layout.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/i;", "", "Landroid/app/Activity;", "activity", "Landroidx/window/extensions/layout/FoldingFeature;", "oemFeature", "Landroidx/window/layout/j;", "a", "(Landroid/app/Activity;Landroidx/window/extensions/layout/FoldingFeature;)Landroidx/window/layout/j;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "info", "Landroidx/window/layout/s;", "b", "(Landroid/app/Activity;Landroidx/window/extensions/layout/WindowLayoutInfo;)Landroidx/window/layout/s;", "Landroidx/window/core/b;", "bounds", "", "c", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f12118a = new i();

    public final j a(Activity activity, FoldingFeature foldingFeature) {
        k.b bVar;
        j.c cVar;
        int type = foldingFeature.getType();
        if (type == 1) {
            bVar = k.b.f12135b.a();
        } else if (type != 2) {
            return null;
        } else {
            bVar = k.b.f12135b.b();
        }
        int state = foldingFeature.getState();
        if (state == 1) {
            cVar = j.c.f12128c;
        } else if (state != 2) {
            return null;
        } else {
            cVar = j.c.f12129d;
        }
        if (c(activity, new b(foldingFeature.getBounds()))) {
            return new k(new b(foldingFeature.getBounds()), bVar, cVar);
        }
        return null;
    }

    public final s b(Activity activity, WindowLayoutInfo windowLayoutInfo) {
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            j a11 = foldingFeature instanceof FoldingFeature ? f12118a.a(activity, foldingFeature) : null;
            if (a11 != null) {
                arrayList.add(a11);
            }
        }
        return new s(arrayList);
    }

    public final boolean c(Activity activity, b bVar) {
        Rect a11 = v.f12159a.a(activity).a();
        if (bVar.e()) {
            return false;
        }
        if (bVar.d() != a11.width() && bVar.a() != a11.height()) {
            return false;
        }
        if (bVar.d() < a11.width() && bVar.a() < a11.height()) {
            return false;
        }
        if (bVar.d() == a11.width() && bVar.a() == a11.height()) {
            return false;
        }
        return true;
    }
}
