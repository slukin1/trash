package com.google.android.gms.internal.auth;

final class zzen {
    private static final zzel zza = new zzem();
    private static final zzel zzb;

    static {
        zzel zzel;
        try {
            zzel = (zzel) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzel = null;
        }
        zzb = zzel;
    }

    public static zzel zza() {
        zzel zzel = zzb;
        if (zzel != null) {
            return zzel;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzel zzb() {
        return zza;
    }
}
