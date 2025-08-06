package la;

import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabItemLayoutIndicator f58016b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58017c;

    public /* synthetic */ g(TabItemLayoutIndicator tabItemLayoutIndicator, int i11) {
        this.f58016b = tabItemLayoutIndicator;
        this.f58017c = i11;
    }

    public final void run() {
        this.f58016b.s(this.f58017c);
    }
}
