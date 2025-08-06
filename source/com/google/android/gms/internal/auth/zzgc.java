package com.google.android.gms.internal.auth;

final class zzgc {
    private static final zzgb zza;
    private static final zzgb zzb = new zzgb();

    static {
        zzgb zzgb;
        try {
            zzgb = (zzgb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgb = null;
        }
        zza = zzgb;
    }

    public static zzgb zza() {
        return zza;
    }

    public static zzgb zzb() {
        return zzb;
    }
}
