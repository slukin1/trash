package tz;

import android.text.Layout;
import android.text.Spanned;
import java.lang.ref.WeakReference;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Layout> f60194a;

    public static Layout b(Spanned spanned) {
        h[] hVarArr = (h[]) spanned.getSpans(0, spanned.length(), h.class);
        if (hVarArr == null || hVarArr.length <= 0) {
            return null;
        }
        return hVarArr[0].a();
    }

    public Layout a() {
        return (Layout) this.f60194a.get();
    }
}
