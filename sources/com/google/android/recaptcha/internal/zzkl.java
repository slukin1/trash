package com.google.android.recaptcha.internal;

final class zzkl {
    private static final zzkk zza;
    private static final zzkk zzb = new zzkk();

    static {
        zzkk zzkk;
        try {
            zzkk = (zzkk) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzkk = null;
        }
        zza = zzkk;
    }

    public static zzkk zza() {
        return zza;
    }

    public static zzkk zzb() {
        return zzb;
    }
}
