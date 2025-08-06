package com.huobi.main.trade.enums;

import android.text.TextUtils;

public enum TradeTabsType {
    COLLECTION,
    COLLECTION_SEARCH,
    OTHER,
    COMPARE,
    OTHER_SEARCH,
    UNKONW;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f77786a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.huobi.main.trade.enums.TradeTabsType[] r0 = com.huobi.main.trade.enums.TradeTabsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f77786a = r0
                com.huobi.main.trade.enums.TradeTabsType r1 = com.huobi.main.trade.enums.TradeTabsType.COLLECTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f77786a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.main.trade.enums.TradeTabsType r1 = com.huobi.main.trade.enums.TradeTabsType.COLLECTION_SEARCH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f77786a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.main.trade.enums.TradeTabsType r1 = com.huobi.main.trade.enums.TradeTabsType.OTHER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f77786a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.main.trade.enums.TradeTabsType r1 = com.huobi.main.trade.enums.TradeTabsType.OTHER_SEARCH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.trade.enums.TradeTabsType.a.<clinit>():void");
        }
    }

    public static TradeTabsType getTabsType(TradeTabsType tradeTabsType, String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        int i11 = a.f77786a[tradeTabsType.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? (i11 == 4 && isEmpty) ? OTHER : tradeTabsType : isEmpty ? tradeTabsType : OTHER_SEARCH : isEmpty ? COLLECTION : tradeTabsType : isEmpty ? tradeTabsType : COLLECTION_SEARCH;
    }
}
