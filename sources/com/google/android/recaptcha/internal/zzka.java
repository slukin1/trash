package com.google.android.recaptcha.internal;

final class zzka {
    private static final zzjz zza;
    private static final zzjz zzb = new zzjz();

    static {
        zzjz zzjz;
        try {
            zzjz = (zzjz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjz = null;
        }
        zza = zzjz;
    }

    public static zzjz zza() {
        return zza;
    }

    public static zzjz zzb() {
        return zzb;
    }
}
