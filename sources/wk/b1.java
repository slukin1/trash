package wk;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.finance.bean.BaseAssetInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func2;
import vk.y;

public class b1 implements Func2<List<BaseAssetInfo>, Map<String, SymbolPrice>, List<y>> {

    /* renamed from: b  reason: collision with root package name */
    public y.a f48071b;

    public class a extends EasySubscriber<BaseAssetInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f48072b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f48073c;

        public a(Map map, List list) {
            this.f48072b = map;
            this.f48073c = list;
        }

        /* renamed from: a */
        public void onNext(BaseAssetInfo baseAssetInfo) {
            super.onNext(baseAssetInfo);
            y yVar = new y(baseAssetInfo);
            yVar.j(b1.this.d(baseAssetInfo, this.f48072b));
            yVar.h(b1.this.f48071b);
            this.f48073c.add(yVar);
        }
    }

    public b1(y.a aVar) {
        this.f48071b = aVar;
    }

    /* renamed from: c */
    public List<y> call(List<BaseAssetInfo> list, Map<String, SymbolPrice> map) {
        ArrayList arrayList = new ArrayList();
        Observable.from(list).subscribe(new a(map, arrayList));
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String d(com.huobi.finance.bean.BaseAssetInfo r10, java.util.Map<java.lang.String, com.hbg.lib.network.pro.socket.bean.SymbolPrice> r11) {
        /*
            r9 = this;
            java.lang.String r0 = "usdt"
            java.lang.String r1 = "btc"
            java.lang.String r2 = "eth"
            java.lang.String r3 = "husd"
            java.lang.String r4 = "ht"
            java.lang.String[] r1 = new java.lang.String[]{r0, r1, r2, r3, r4}
            r2 = 0
            if (r11 == 0) goto L_0x00f3
            java.lang.String r3 = r10.getCurrency()
            r4 = 0
        L_0x0016:
            r5 = 5
            if (r4 >= r5) goto L_0x00f3
            r5 = r1[r4]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            boolean r6 = r11.containsKey(r6)
            if (r6 == 0) goto L_0x007b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.Object r6 = r11.get(r6)
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r6 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r6
            if (r6 == 0) goto L_0x00ef
            java.lang.Double r6 = r6.getClose()
            if (r6 == 0) goto L_0x00ef
            java.lang.String r10 = r10.getAvaialAble()
            java.math.BigDecimal r10 = i6.m.a(r10)
            double r3 = r6.doubleValue()
            java.math.BigDecimal r1 = java.math.BigDecimal.valueOf(r3)
            java.math.BigDecimal r10 = r10.multiply(r1)
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 != 0) goto L_0x00f4
            com.huobi.finance.bean.BaseAssetInfo r0 = new com.huobi.finance.bean.BaseAssetInfo
            r0.<init>()
            r0.setCurrency(r5)
            java.lang.String r10 = r10.toPlainString()
            r0.setAvaialAble(r10)
            java.lang.String r10 = r9.d(r0, r11)
            return r10
        L_0x007b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            boolean r6 = r11.containsKey(r6)
            if (r6 == 0) goto L_0x00ef
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            java.lang.Object r6 = r11.get(r6)
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r6 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r6
            if (r6 == 0) goto L_0x00ef
            java.lang.Double r6 = r6.getClose()
            if (r6 == 0) goto L_0x00ef
            double r7 = r6.doubleValue()
            java.math.BigDecimal r7 = java.math.BigDecimal.valueOf(r7)
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            int r7 = r7.compareTo(r8)
            if (r7 <= 0) goto L_0x00ef
            java.lang.String r10 = r10.getAvaialAble()
            java.math.BigDecimal r10 = i6.m.a(r10)
            double r3 = r6.doubleValue()
            java.math.BigDecimal r1 = java.math.BigDecimal.valueOf(r3)
            r3 = 16
            java.math.RoundingMode r4 = java.math.RoundingMode.DOWN
            java.math.BigDecimal r10 = r10.divide(r1, r3, r4)
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 != 0) goto L_0x00f4
            com.huobi.finance.bean.BaseAssetInfo r0 = new com.huobi.finance.bean.BaseAssetInfo
            r0.<init>()
            r0.setCurrency(r5)
            java.lang.String r10 = r10.toPlainString()
            r0.setAvaialAble(r10)
            java.lang.String r10 = r9.d(r0, r11)
            return r10
        L_0x00ef:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x00f3:
            r10 = r2
        L_0x00f4:
            if (r10 != 0) goto L_0x00f7
            return r2
        L_0x00f7:
            java.lang.String r10 = r10.toPlainString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: wk.b1.d(com.huobi.finance.bean.BaseAssetInfo, java.util.Map):java.lang.String");
    }
}
