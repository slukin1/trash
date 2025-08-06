package com.huobi.index.bean;

import android.app.Activity;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import pro.huobi.R;

public enum RiseRankType {
    RANK_RISE_TYPE_USDT("usdt"),
    RANK_RISE_TYPE_USDT_SWAP(RankScreenBean.SCREEN_VALUE_USDT_SWAP),
    RANK_RISE_TYPE_SYMBOL_SWAP(RankScreenBean.SCREEN_VALUE_SYMBOL_SWAP),
    RANK_RISE_TYPE_BTC("btc"),
    RANK_RISE_TYPE_HT("ht"),
    RANK_RISE_TYPE_ETP("etp"),
    RANK_RISE_TYPE_FUTURE("contract");
    
    private String currency;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f73238a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.index.bean.RiseRankType[] r0 = com.huobi.index.bean.RiseRankType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f73238a = r0
                com.huobi.index.bean.RiseRankType r1 = com.huobi.index.bean.RiseRankType.RANK_RISE_TYPE_USDT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f73238a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.index.bean.RiseRankType r1 = com.huobi.index.bean.RiseRankType.RANK_RISE_TYPE_BTC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f73238a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.index.bean.RiseRankType r1 = com.huobi.index.bean.RiseRankType.RANK_RISE_TYPE_HT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f73238a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.index.bean.RiseRankType r1 = com.huobi.index.bean.RiseRankType.RANK_RISE_TYPE_ETP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f73238a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.index.bean.RiseRankType r1 = com.huobi.index.bean.RiseRankType.RANK_RISE_TYPE_FUTURE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.bean.RiseRankType.a.<clinit>():void");
        }
    }

    private RiseRankType(String str) {
        this.currency = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getTitle(Activity activity) {
        int i11 = a.f73238a[ordinal()];
        if (i11 == 1) {
            return activity.getString(R.string.n_home_ranking_usdt_symbol);
        }
        if (i11 == 2) {
            return activity.getString(R.string.n_home_rangking_btc_symbol);
        }
        if (i11 == 3) {
            return activity.getString(R.string.n_home_rangking_ht_symbol);
        }
        if (i11 == 4) {
            return activity.getString(R.string.etp_str);
        }
        if (i11 != 5) {
            return activity.getString(R.string.n_title_spot);
        }
        return activity.getString(R.string.n_title_future);
    }
}
