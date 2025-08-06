package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.SubaccountQueryData;
import java.util.Map;
import rx.functions.Action2;

public final /* synthetic */ class p implements Action2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeType f54124b;

    public /* synthetic */ p(TradeType tradeType) {
        this.f54124b = tradeType;
    }

    public final void call(Object obj, Object obj2) {
        h2.Z2(this.f54124b, (Map) obj, (SubaccountQueryData) obj2);
    }
}
