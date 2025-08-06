package com.tencent.wxop.stat;

public enum d {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    public int aI;

    private d(int i11) {
        this.aI = i11;
    }

    public static d a(int i11) {
        for (d dVar : values()) {
            if (i11 == dVar.aI) {
                return dVar;
            }
        }
        return null;
    }
}
