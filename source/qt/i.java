package qt;

import com.hbg.lib.data.symbol.TradeType;
import java.util.HashMap;
import java.util.Map;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static Map<TradeType, Boolean> f84704a = new HashMap();

    public static boolean a(TradeType tradeType) {
        Boolean bool = f84704a.get(tradeType);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static boolean b(TradeType tradeType) {
        return f84704a.containsKey(tradeType);
    }

    public static void c(TradeType tradeType) {
        f84704a.remove(tradeType);
    }

    public static void d(TradeType tradeType, boolean z11) {
        f84704a.put(tradeType, Boolean.valueOf(z11));
    }
}
