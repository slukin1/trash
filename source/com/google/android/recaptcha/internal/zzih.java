package com.google.android.recaptcha.internal;

final class zzih {
    private static final zzif zza = new zzig();
    private static final zzif zzb;

    static {
        zzif zzif;
        try {
            zzif = (zzif) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzif = null;
        }
        zzb = zzif;
    }

    public static zzif zza() {
        zzif zzif = zzb;
        if (zzif != null) {
            return zzif;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzif zzb() {
        return zza;
    }
}
