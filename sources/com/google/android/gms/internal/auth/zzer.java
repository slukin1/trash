package com.google.android.gms.internal.auth;

final class zzer implements zzfu {
    private static final zzer zza = new zzer();

    private zzer() {
    }

    public static zzer zza() {
        return zza;
    }

    public final zzft zzb(Class cls) {
        Class<zzeu> cls2 = zzeu.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzft) zzeu.zza(cls.asSubclass(cls2)).zzi(3, (Object) null, (Object) null);
            } catch (Exception e11) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e11);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzeu.class.isAssignableFrom(cls);
    }
}
