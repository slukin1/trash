package com.huobi.finance.bean;

import java.io.Serializable;

public class AssetCacheInfoData implements Serializable {
    private int cacheTimeHour;
    private boolean isAndroidOpenCache;

    public int getCacheTimeHour() {
        return this.cacheTimeHour;
    }

    public long getTimeMillis() {
        return ((long) this.cacheTimeHour) * 60 * 60 * 1000;
    }

    public boolean isAndroidOpenCache() {
        return this.isAndroidOpenCache;
    }

    public void setAndroidOpenCache(boolean z11) {
        this.isAndroidOpenCache = z11;
    }

    public void setCacheTimeHour(int i11) {
        this.cacheTimeHour = i11;
    }
}
