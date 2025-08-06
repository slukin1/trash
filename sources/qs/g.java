package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import rx.functions.Action0;

public final /* synthetic */ class g implements Action0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f70394b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70395c;

    public /* synthetic */ g(n nVar, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70394b = nVar;
        this.f70395c = swapCurrencyInfo;
    }

    public final void call() {
        this.f70394b.H(this.f70395c);
    }
}
