package qi;

import com.huobi.c2c.lend.view.C2CLendTradeLayout;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CLendTradeLayout f53385b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CharSequence f53386c;

    public /* synthetic */ g(C2CLendTradeLayout c2CLendTradeLayout, CharSequence charSequence) {
        this.f53385b = c2CLendTradeLayout;
        this.f53386c = charSequence;
    }

    public final void run() {
        this.f53385b.D(this.f53386c);
    }
}
