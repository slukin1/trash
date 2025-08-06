package com.google.android.gms.internal.fido;

final class zzaw extends zzat {
    public static final zzat zza = new zzaw(new Object[0], 0);
    public final transient Object[] zzb;
    private final transient int zzc;

    public zzaw(Object[] objArr, int i11) {
        this.zzb = objArr;
        this.zzc = i11;
    }

    public final Object get(int i11) {
        zzam.zza(i11, this.zzc, "index");
        Object obj = this.zzb[i11];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i11) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return 0;
    }

    public final Object[] zze() {
        return this.zzb;
    }
}
