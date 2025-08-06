package gb;

import com.hbg.lite.market.LiteMarketInfoActivity;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteMarketInfoActivity f54806b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54807c;

    public /* synthetic */ d(LiteMarketInfoActivity liteMarketInfoActivity, String str) {
        this.f54806b = liteMarketInfoActivity;
        this.f54807c = str;
    }

    public final void run() {
        this.f54806b.Kh(this.f54807c);
    }
}
