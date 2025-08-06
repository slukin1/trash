package com.google.android.gms.internal.measurement;

final class zzme {
    private static final zzmd zza;
    private static final zzmd zzb = new zzmd();

    static {
        zzmd zzmd;
        try {
            zzmd = (zzmd) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzmd = null;
        }
        zza = zzmd;
    }

    public static zzmd zza() {
        return zza;
    }

    public static zzmd zzb() {
        return zzb;
    }
}
