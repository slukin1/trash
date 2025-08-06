package com.google.android.gms.internal.measurement;

final class zzkq {
    private static final zzko zza = new zzkp();
    private static final zzko zzb;

    static {
        zzko zzko;
        try {
            zzko = (zzko) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzko = null;
        }
        zzb = zzko;
    }

    public static zzko zza() {
        zzko zzko = zzb;
        if (zzko != null) {
            return zzko;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzko zzb() {
        return zza;
    }
}
