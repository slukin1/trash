package z6;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import rx.functions.Func1;

public final /* synthetic */ class k implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f62014b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f62015c;

    public /* synthetic */ k(l lVar, TradeType tradeType) {
        this.f62014b = lVar;
        this.f62015c = tradeType;
    }

    public final Object call(Object obj) {
        return this.f62014b.k(this.f62015c, (LinearSwapUserInfo) obj);
    }
}
