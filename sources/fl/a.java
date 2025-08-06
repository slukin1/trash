package fl;

import com.hbg.lib.data.symbol.TradeType;
import i6.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static TradeType f76184a;

    public static TradeType a() {
        d.b("FutureModuleConfig-->getCurrentTradeType-->" + f76184a);
        return f76184a;
    }

    public static void b(TradeType tradeType) {
        f76184a = tradeType;
        d.b("FutureModuleConfig-->setCurrentTradeType-->" + f76184a);
    }
}
