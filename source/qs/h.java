package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class h implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f70398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70399c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f70400d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f70401e;

    public /* synthetic */ h(n nVar, SwapCurrencyInfo swapCurrencyInfo, String str, int i11) {
        this.f70398b = nVar;
        this.f70399c = swapCurrencyInfo;
        this.f70400d = str;
        this.f70401e = i11;
    }

    public final void call(Object obj) {
        this.f70398b.I(this.f70399c, this.f70400d, this.f70401e, (List) obj);
    }
}
