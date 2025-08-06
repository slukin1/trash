package ul;

import androidx.recyclerview.widget.LinearLayoutManager;

public final /* synthetic */ class u0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f60813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60814c;

    public /* synthetic */ u0(LinearLayoutManager linearLayoutManager, int i11) {
        this.f60813b = linearLayoutManager;
        this.f60814c = i11;
    }

    public final void run() {
        this.f60813b.scrollToPositionWithOffset(this.f60814c, 0);
    }
}
