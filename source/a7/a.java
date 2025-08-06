package a7;

import com.hbg.lib.data.symbol.TradeType;
import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<TradeType, Integer> f68393a = new HashMap();

    public static Integer a(TradeType tradeType) {
        return f68393a.get(tradeType);
    }

    public static void b(TradeType tradeType, int i11) {
        f68393a.put(tradeType, Integer.valueOf(i11));
    }

    public static void c(TradeType tradeType) {
        f68393a.remove(tradeType);
    }
}
