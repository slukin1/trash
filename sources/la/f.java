package la;

import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabItemLayoutIndicator f58014b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58015c;

    public /* synthetic */ f(TabItemLayoutIndicator tabItemLayoutIndicator, int i11) {
        this.f58014b = tabItemLayoutIndicator;
        this.f58015c = i11;
    }

    public final void run() {
        this.f58014b.q(this.f58015c);
    }
}
