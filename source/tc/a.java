package tc;

import com.hbg.lib.common.utils.SP;
import com.hbg.lib.data.symbol.TradeType;
import i6.d;
import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<TradeType, Integer> f19352a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<TradeType, Integer> f19353b = new HashMap();

    public static int a(TradeType tradeType) {
        int b11 = b(tradeType);
        return b11 == 1 ? c(tradeType) : b11;
    }

    public static int b(TradeType tradeType) {
        Map<TradeType, Integer> map = f19352a;
        if (map.containsKey(tradeType)) {
            return map.get(tradeType).intValue();
        }
        if (tradeType == TradeType.SWAP) {
            tradeType = TradeType.CONTRACT;
        }
        int e11 = SP.e("SP_KEY_ORDER_SHOW_TYPE_" + tradeType.toString(), 0);
        d.b("FutureOrderShowTypeHelper-->getOrderShowType-->tradeType:" + tradeType + " orderShowType:" + e11);
        map.put(tradeType, Integer.valueOf(e11));
        return e11;
    }

    public static int c(TradeType tradeType) {
        Map<TradeType, Integer> map = f19353b;
        if (map.containsKey(tradeType)) {
            return map.get(tradeType).intValue();
        }
        if (tradeType == TradeType.SWAP) {
            tradeType = TradeType.CONTRACT;
        }
        int e11 = SP.e("SP_KEY_ORDER_SHOW_TYPE2_" + tradeType.toString(), 0);
        d.b("FutureOrderShowTypeHelper-->getOrderTabType-->tradeType:" + tradeType + " orderShowType:" + e11);
        map.put(tradeType, Integer.valueOf(e11));
        return e11;
    }

    public static void d(TradeType tradeType, int i11) {
        if (tradeType == TradeType.SWAP) {
            tradeType = TradeType.CONTRACT;
        }
        f19352a.put(tradeType, Integer.valueOf(i11));
        d.b("FutureOrderShowTypeHelper-->getOrderShowType-->tradeType:" + tradeType + " orderShowType:" + i11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SP_KEY_ORDER_SHOW_TYPE_");
        sb2.append(tradeType.toString());
        SP.q(sb2.toString(), i11);
    }

    public static void e(TradeType tradeType, int i11) {
        if (tradeType == TradeType.SWAP) {
            tradeType = TradeType.CONTRACT;
        }
        f19353b.put(tradeType, Integer.valueOf(i11));
        d.b("FutureOrderShowTypeHelper-->setOrderTabType-->tradeType:" + tradeType + " orderShowType:" + i11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SP_KEY_ORDER_SHOW_TYPE2_");
        sb2.append(tradeType.toString());
        SP.q(sb2.toString(), i11);
    }
}
