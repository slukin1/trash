package wa;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001c A[LOOP:0: B:5:0x001c->B:8:0x002c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r2) {
        /*
            va.b r0 = va.b.o()
            com.hbg.lib.network.otc.core.bean.OtcConfigBean r0 = r0.r()
            if (r0 == 0) goto L_0x002e
            java.util.List r1 = r0.getCoinInfoList()
            boolean r1 = com.hbg.lib.core.util.CollectionsUtils.b(r1)
            if (r1 != 0) goto L_0x002e
            java.util.List r0 = r0.getCoinInfoList()
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo$CoinInfo r1 = (com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo.CoinInfo) r1
            int r1 = r1.getCoinId()
            if (r1 != r2) goto L_0x001c
        L_0x002e:
            r2 = 8
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: wa.a.a(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001c A[LOOP:0: B:5:0x001c->B:8:0x0030, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(java.lang.String r2) {
        /*
            va.b r0 = va.b.o()
            com.hbg.lib.network.otc.core.bean.OtcConfigBean r0 = r0.r()
            if (r0 == 0) goto L_0x0032
            java.util.List r1 = r0.getCoinInfoList()
            boolean r1 = com.hbg.lib.core.util.CollectionsUtils.b(r1)
            if (r1 != 0) goto L_0x0032
            java.util.List r0 = r0.getCoinInfoList()
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo$CoinInfo r1 = (com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo.CoinInfo) r1
            java.lang.String r1 = r1.getShortName()
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x001c
        L_0x0032:
            r2 = 8
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: wa.a.b(java.lang.String):int");
    }
}
