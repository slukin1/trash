package com.huobi.finance.model.subaccount;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.OtcOptionDataTotal;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import d7.c0;
import d7.k;
import dt.h2;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import xk.b;
import xk.u;

public class OtcOptonDataProvider extends b<OtcOptionDataTotal, OtcOptionsDetailInfo, String, String> {

    /* renamed from: c  reason: collision with root package name */
    public Comparator<OtcOptionsDetailInfo> f45453c;

    public class a implements Func1<Map<String, Map<String, String>>, Observable<OtcOptionDataTotal>> {
        public a() {
        }

        /* renamed from: a */
        public Observable<OtcOptionDataTotal> call(Map<String, Map<String, String>> map) {
            OtcOptionDataTotal otcOptionDataTotal = new OtcOptionDataTotal();
            otcOptionDataTotal.setOriginAssetData(map);
            return Observable.just(otcOptionDataTotal);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int m(com.huobi.finance.bean.OtcOptionsDetailInfo r6, com.huobi.finance.bean.OtcOptionsDetailInfo r7) {
        /*
            r0 = 0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r1 = r7.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x0021 }
            double r1 = i6.m.h0(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0021 }
            java.lang.String r2 = r6.getEstimateAmount()     // Catch:{ NumberFormatException -> 0x001f }
            double r2 = i6.m.h0(r2)     // Catch:{ NumberFormatException -> 0x001f }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r1 = r0
        L_0x0023:
            r2.printStackTrace()
        L_0x0026:
            double r2 = r0.doubleValue()
            double r4 = r1.doubleValue()
            int r2 = java.lang.Double.compare(r2, r4)
            if (r2 == 0) goto L_0x0039
            int r6 = r1.compareTo(r0)
            return r6
        L_0x0039:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            d7.k r2 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r7.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r7 = r2.I(r7, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0065 }
            d7.k r7 = d7.k.C()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r6.getCurrency()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r6 = r7.I(r6, r3)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0069:
            int r6 = r1.compareTo(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.model.subaccount.OtcOptonDataProvider.m(com.huobi.finance.bean.OtcOptionsDetailInfo, com.huobi.finance.bean.OtcOptionsDetailInfo):int");
    }

    public /* bridge */ /* synthetic */ Observable a(boolean z11) {
        return super.a(z11);
    }

    public Observable<OtcOptionDataTotal> d() {
        return h2.t1().w3(TradeType.OTC_OPTIONS, false).flatMap(new a());
    }

    public Comparator<OtcOptionsDetailInfo> e() {
        if (this.f45453c == null) {
            this.f45453c = u.f61648b;
        }
        return this.f45453c;
    }

    public Observable<List<String>> f(boolean z11) {
        return c0.f(z11);
    }

    public Observable<String> g(boolean z11) {
        return Observable.just(null);
    }

    /* renamed from: k */
    public void c(OtcOptionDataTotal otcOptionDataTotal, List<String> list, Map<String, BigDecimal> map, Comparator<OtcOptionsDetailInfo> comparator, String str) {
        OtcOptionDataTotal otcOptionDataTotal2 = otcOptionDataTotal;
        HashMap hashMap = new HashMap();
        Map<String, Map<String, String>> originAssetData = otcOptionDataTotal.getOriginAssetData();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (originAssetData != null && !originAssetData.isEmpty()) {
            for (Map.Entry next : originAssetData.entrySet()) {
                String str2 = (String) next.getKey();
                BigDecimal bigDecimal2 = bigDecimal;
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    String str3 = (String) entry.getKey();
                    String str4 = (String) entry.getValue();
                    if (str3 == null || str2 == null) {
                        Map<String, BigDecimal> map2 = map;
                    } else {
                        o(hashMap, str2, str3, str4, map);
                        bigDecimal2 = bigDecimal2.add(l(map, str2, str3, str4));
                    }
                }
                Map<String, BigDecimal> map3 = map;
                bigDecimal = bigDecimal2;
            }
        }
        otcOptionDataTotal2.setNetAssetToBtc(bigDecimal.toPlainString());
        otcOptionDataTotal2.setNetAsset(LegalCurrencyConfigUtil.D(m.u0(bigDecimal.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
        ArrayList<OtcOptionsDetailInfo> n11 = n(hashMap, list);
        Collections.sort(n11, comparator);
        otcOptionDataTotal2.setDetailInfos(n11);
    }

    public final BigDecimal l(Map<String, BigDecimal> map, String str, String str2, String str3) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (str2.equalsIgnoreCase(this.f48083b)) {
            if ("trade".equals(str) || "frozen".equals(str)) {
                return bigDecimal.add(m.a(str3));
            }
            return bigDecimal;
        } else if (!map.containsKey(str2)) {
            return bigDecimal;
        } else {
            return ("trade".equals(str) || "frozen".equals(str)) ? bigDecimal.add(map.get(str2).multiply(m.a(str3))) : bigDecimal;
        }
    }

    public final ArrayList<OtcOptionsDetailInfo> n(Map<String, OtcOptionsDetailInfo> map, List<String> list) {
        for (String next : list) {
            if (!map.containsKey(next)) {
                OtcOptionsDetailInfo otcOptionsDetailInfo = new OtcOptionsDetailInfo();
                otcOptionsDetailInfo.setCurrency(next);
                otcOptionsDetailInfo.setAvaialAble("0");
                otcOptionsDetailInfo.setOnOrders("0");
                otcOptionsDetailInfo.setEstimateAmount("0.00");
                map.put(next, otcOptionsDetailInfo);
            }
        }
        return new ArrayList<>(map.values());
    }

    public final void o(Map<String, OtcOptionsDetailInfo> map, String str, String str2, String str3, Map<String, BigDecimal> map2) {
        OtcOptionsDetailInfo otcOptionsDetailInfo;
        if (map.get(str2) == null) {
            otcOptionsDetailInfo = new OtcOptionsDetailInfo();
            otcOptionsDetailInfo.setCurrency(str2);
            otcOptionsDetailInfo.setDisplayName(k.C().z(str2));
            map.put(str2, otcOptionsDetailInfo);
        } else {
            otcOptionsDetailInfo = map.get(str2);
        }
        if (map2.containsKey(str2)) {
            otcOptionsDetailInfo.setEstimateAmountToBtc(m.a(otcOptionsDetailInfo.getEstimateAmountToBtc()).add(map2.get(str2).multiply(m.a(str3))).toPlainString());
        }
        otcOptionsDetailInfo.setEstimateAmount(LegalCurrencyConfigUtil.L(m.a(otcOptionsDetailInfo.getEstimateAmount()).add(m.a(LegalCurrencyConfigUtil.G(str3, str2, TradeType.PRO)))));
        str.hashCode();
        if (str.equals("frozen")) {
            otcOptionsDetailInfo.setOnOrders(str3);
        } else if (str.equals("trade")) {
            otcOptionsDetailInfo.setAvaialAble(str3);
        }
    }
}
