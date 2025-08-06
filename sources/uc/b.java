package uc;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Map<String, List<LevelAvailableMarginInfo>>> f19354a = new HashMap();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19355a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19355a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19355a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: uc.b.a.<clinit>():void");
        }
    }

    public static List<LevelAvailableMarginInfo> b(TradeType tradeType, String str, int i11) {
        Map<String, Map<String, List<LevelAvailableMarginInfo>>> map = f19354a;
        Map map2 = map.get(tradeType.toString() + i11);
        if (map2 != null) {
            return (List) map2.get(str);
        }
        return null;
    }

    public static /* synthetic */ List c(TradeType tradeType, int i11, String str, List list) {
        Map<String, Map<String, List<LevelAvailableMarginInfo>>> map = f19354a;
        Map map2 = map.get(tradeType.toString() + i11);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(tradeType.toString() + i11, map2);
        }
        map2.put(str, list);
        return list;
    }

    public static Observable<List<LevelAvailableMarginInfo>> d(TradeType tradeType, String str, int i11) {
        d9.a<List<LevelAvailableMarginInfo>> aVar;
        int i12 = a.f19355a[tradeType.ordinal()];
        if (i12 == 1) {
            aVar = l9.a.a().s(str);
        } else if (i12 != 2) {
            aVar = q7.a.a().s(str);
        } else if (i11 == 1) {
            aVar = h8.a.a().E(str, FutureContractInfo.MARGIN_CROSS);
        } else {
            aVar = h8.a.a().t0(str, FutureContractInfo.MARGIN_ISOLATED);
        }
        return aVar.b().map(new a(tradeType, i11, str));
    }
}
