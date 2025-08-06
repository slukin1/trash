package xk;

import com.hbg.lib.network.pro.core.bean.DefiBoxAsset;
import com.huobi.finance.bean.OnChainDataTotal;
import com.huobi.finance.model.subaccount.OnChainDataProvider;
import java.util.Map;
import rx.functions.Func2;

public final /* synthetic */ class p implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnChainDataProvider f61642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OnChainDataTotal f61643c;

    public /* synthetic */ p(OnChainDataProvider onChainDataProvider, OnChainDataTotal onChainDataTotal) {
        this.f61642b = onChainDataProvider;
        this.f61643c = onChainDataTotal;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f61642b.h(this.f61643c, (Map) obj, (DefiBoxAsset) obj2);
    }
}
