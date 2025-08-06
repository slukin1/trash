package com.google.android.gms.internal.auth;

final class zzfs {
    private static final zzfr zza;
    private static final zzfr zzb = new zzfr();

    static {
        zzfr zzfr;
        try {
            zzfr = (zzfr) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzfr = null;
        }
        zza = zzfr;
    }

    public static zzfr zza() {
        return zza;
    }

    public static zzfr zzb() {
        return zzb;
    }
}
