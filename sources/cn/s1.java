package cn;

import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;

public final /* synthetic */ class s1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBaseFragment f13192b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f13193c;

    public /* synthetic */ s1(LinearSwapTradeBaseFragment linearSwapTradeBaseFragment, boolean z11) {
        this.f13192b = linearSwapTradeBaseFragment;
        this.f13193c = z11;
    }

    public final void run() {
        this.f13192b.qj(this.f13193c);
    }
}
