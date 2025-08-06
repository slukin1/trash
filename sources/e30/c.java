package e30;

import android.content.Context;
import android.widget.Scroller;
import uk.co.senab.photoview.scrollerproxy.ScrollerProxy;

public class c extends ScrollerProxy {

    /* renamed from: a  reason: collision with root package name */
    public final Scroller f60250a;

    public c(Context context) {
        this.f60250a = new Scroller(context);
    }

    public boolean a() {
        return this.f60250a.computeScrollOffset();
    }

    public void b(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21) {
        this.f60250a.fling(i11, i12, i13, i14, i15, i16, i17, i18);
    }

    public void c(boolean z11) {
        this.f60250a.forceFinished(z11);
    }

    public int d() {
        return this.f60250a.getCurrX();
    }

    public int e() {
        return this.f60250a.getCurrY();
    }

    public boolean g() {
        return this.f60250a.isFinished();
    }
}
