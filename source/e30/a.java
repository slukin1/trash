package e30;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;
import uk.co.senab.photoview.scrollerproxy.ScrollerProxy;

@TargetApi(9)
public class a extends ScrollerProxy {

    /* renamed from: a  reason: collision with root package name */
    public final OverScroller f60249a;

    public a(Context context) {
        this.f60249a = new OverScroller(context);
    }

    public boolean a() {
        return this.f60249a.computeScrollOffset();
    }

    public void b(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21) {
        this.f60249a.fling(i11, i12, i13, i14, i15, i16, i17, i18, i19, i21);
    }

    public void c(boolean z11) {
        this.f60249a.forceFinished(z11);
    }

    public int d() {
        return this.f60249a.getCurrX();
    }

    public int e() {
        return this.f60249a.getCurrY();
    }

    public boolean g() {
        return this.f60249a.isFinished();
    }
}
