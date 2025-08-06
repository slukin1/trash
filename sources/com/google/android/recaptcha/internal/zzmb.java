package com.google.android.recaptcha.internal;

public enum zzmb {
    DOUBLE(zzmc.DOUBLE, 1),
    FLOAT(zzmc.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzmc.BOOLEAN, 0),
    STRING(zzmc.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzmc.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzmc.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzmc zzt;

    private zzmb(zzmc zzmc, int i11) {
        this.zzt = zzmc;
    }

    public final zzmc zza() {
        return this.zzt;
    }
}
