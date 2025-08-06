package ts;

import com.huobi.swap.ui.SwapMarketClosingDialog;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapMarketClosingDialog f60430b;

    public /* synthetic */ t(SwapMarketClosingDialog swapMarketClosingDialog) {
        this.f60430b = swapMarketClosingDialog;
    }

    public final void run() {
        this.f60430b.dismiss();
    }
}
