package go;

import com.huobi.margin.ui.TradeMarginBalanceDialog;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeMarginBalanceDialog f54848b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54849c;

    public /* synthetic */ c(TradeMarginBalanceDialog tradeMarginBalanceDialog, String str) {
        this.f54848b = tradeMarginBalanceDialog;
        this.f54849c = str;
    }

    public final void run() {
        this.f54848b.Eh(this.f54849c);
    }
}
