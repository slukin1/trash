package com.google.android.gms.internal.auth;

final class zzdi extends zzdh {
    private final Object zza;

    public zzdi(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdi) {
            return this.zza.equals(((zzdi) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza + ")";
    }

    public final Object zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return true;
    }
}
