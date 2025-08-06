package gl;

import com.hbg.lib.data.symbol.TradeType;
import java.util.HashMap;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<TradeType, Boolean> f76186a = new HashMap();

    public static boolean a(TradeType tradeType) {
        Boolean bool = f76186a.get(tradeType);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static void b(TradeType tradeType, boolean z11) {
        f76186a.put(tradeType, Boolean.valueOf(z11));
    }
}
