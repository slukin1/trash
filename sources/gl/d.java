package gl;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserOrderLimit;
import com.huobi.future.bean.FutureUserOrderLimit;
import com.huobi.future.bean.FutureUserOrderLimitType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<FutureUserOrderLimit>> f76187a = new HashMap();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f76188a;

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
                f76188a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f76188a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OPTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: gl.d.a.<clinit>():void");
        }
    }

    public static Observable<List<FutureUserOrderLimit>> b(boolean z11, TradeType tradeType, String str) {
        if (z11) {
            Map<String, List<FutureUserOrderLimit>> map = f76187a;
            List list = map.get(tradeType.toString() + str);
            if (list != null) {
                return Observable.just(list);
            }
        }
        int i11 = a.f76188a[tradeType.ordinal()];
        if (i11 == 1) {
            return h8.a.a().b0(str, TtmlNode.COMBINE_ALL).b().map(new c(tradeType, str));
        }
        if (i11 != 2) {
            return Observable.just(new ArrayList());
        }
        return Observable.just(new ArrayList());
    }

    public static FutureUserOrderLimitType c(TradeType tradeType, String str, String str2) {
        Map<String, List<FutureUserOrderLimit>> map = f76187a;
        List<FutureUserOrderLimit> list = map.get(tradeType.toString() + str);
        FutureUserOrderLimitType futureUserOrderLimitType = null;
        if (list != null) {
            for (FutureUserOrderLimit futureUserOrderLimit : list) {
                if (futureUserOrderLimit.getOrderPriceType().equals(str2)) {
                    Iterator<FutureUserOrderLimitType> it2 = futureUserOrderLimit.getList().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        FutureUserOrderLimitType next = it2.next();
                        if (next.getContractCode().equals(str)) {
                            futureUserOrderLimitType = next;
                            break;
                        }
                    }
                }
            }
        }
        return futureUserOrderLimitType;
    }

    public static List<FutureUserOrderLimit> d(String str, TradeType tradeType) {
        Map<String, List<FutureUserOrderLimit>> map = f76187a;
        if (map.get(tradeType.toString() + str) == null) {
            return new ArrayList();
        }
        return map.get(tradeType.toString() + str);
    }

    public static FutureUserOrderLimitType e(TradeType tradeType, String str, int i11, int i12, String str2) {
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 == 5) {
                            if (i12 == 3) {
                                return c(tradeType, str2, "optimal_20_ioc");
                            }
                            if (i12 != 4) {
                                return c(tradeType, str2, "optimal_20");
                            }
                            return c(tradeType, str2, "optimal_20_fok");
                        }
                    } else if (i12 == 3) {
                        return c(tradeType, str2, "optimal_10_ioc");
                    } else {
                        if (i12 != 4) {
                            return c(tradeType, str2, "optimal_10");
                        }
                        return c(tradeType, str2, "optimal_10_fok");
                    }
                } else if (i12 == 3) {
                    return c(tradeType, str2, "optimal_5_ioc");
                } else {
                    if (i12 != 4) {
                        return c(tradeType, str2, "optimal_5");
                    }
                    return c(tradeType, str2, "optimal_5_fok");
                }
            } else if (i12 == 3) {
                return c(tradeType, str2, "opponent_ioc");
            } else {
                if (i12 != 4) {
                    return c(tradeType, str2, "opponent");
                }
                return c(tradeType, str2, "opponent_fok");
            }
        } else if (i12 == 0) {
            return c(tradeType, str2, "limit");
        } else {
            if (i12 == 1) {
                return c(tradeType, str2, "trigger");
            }
            if (i12 == 2) {
                return c(tradeType, str2, "post_only");
            }
            if (i12 == 3) {
                return c(tradeType, str2, "ioc");
            }
            if (i12 == 4) {
                return c(tradeType, str2, "fok");
            }
        }
        return null;
    }

    public static /* synthetic */ List f(TradeType tradeType, String str, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            FutureUserOrderLimit futureUserOrderLimit = new FutureUserOrderLimit();
            futureUserOrderLimit.linearSwapConvert(futureUserOrderLimit, (LinearSwapUserOrderLimit) it2.next());
            arrayList.add(futureUserOrderLimit);
        }
        Map<String, List<FutureUserOrderLimit>> map = f76187a;
        map.put(tradeType.toString() + str, arrayList);
        return d(str, tradeType);
    }
}
