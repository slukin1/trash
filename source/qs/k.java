package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import rx.functions.Func1;

public final /* synthetic */ class k implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70409b;

    public /* synthetic */ k(String str) {
        this.f70409b = str;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(((SwapCurrencyInfo) obj).getSymbol().equalsIgnoreCase(this.f70409b));
    }
}
