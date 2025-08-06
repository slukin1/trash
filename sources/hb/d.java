package hb;

import com.hbg.lite.market.widget.LiteTradingView;
import java.util.List;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteTradingView f54915b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f54916c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f54917d;

    public /* synthetic */ d(LiteTradingView liteTradingView, boolean z11, List list) {
        this.f54915b = liteTradingView;
        this.f54916c = z11;
        this.f54917d = list;
    }

    public final void run() {
        this.f54915b.F(this.f54916c, this.f54917d);
    }
}
