package us;

import androidx.core.widget.NestedScrollView;
import us.e;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NestedScrollView f60928b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60929c;

    public /* synthetic */ d(NestedScrollView nestedScrollView, int i11) {
        this.f60928b = nestedScrollView;
        this.f60929c = i11;
    }

    public final void run() {
        e.a.i(this.f60928b, this.f60929c);
    }
}
