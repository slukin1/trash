package com.tencent.android.tpush.stat;

public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    

    /* renamed from: v  reason: collision with root package name */
    public int f69869v;

    private StatReportStrategy(int i11) {
        this.f69869v = i11;
    }

    public static StatReportStrategy getStatReportStrategy(int i11) {
        for (StatReportStrategy statReportStrategy : values()) {
            if (i11 == statReportStrategy.getIntValue()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    public int getIntValue() {
        return this.f69869v;
    }
}
