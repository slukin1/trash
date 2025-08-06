package xk;

import com.huobi.finance.bean.OnChainDataTotal;
import com.huobi.finance.model.subaccount.OnChainDataProvider;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnChainDataProvider f61638b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61639c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f61640d;

    public /* synthetic */ n(OnChainDataProvider onChainDataProvider, String str, boolean z11) {
        this.f61638b = onChainDataProvider;
        this.f61639c = str;
        this.f61640d = z11;
    }

    public final Object call(Object obj) {
        return this.f61638b.i(this.f61639c, this.f61640d, (OnChainDataTotal) obj);
    }
}
