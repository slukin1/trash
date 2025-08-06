package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzjf extends zzjb {
    public static final zzjf zza;
    private static final Object[] zzd;
    public final transient Object[] zzb;
    public final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzjf(objArr, 0, objArr, 0, 0);
    }

    public zzjf(Object[] objArr, int i11, Object[] objArr2, int i12, int i13) {
        this.zzb = objArr;
        this.zze = i11;
        this.zzc = objArr2;
        this.zzf = i12;
        this.zzg = i13;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int zza2 = zzit.zza(obj.hashCode());
        while (true) {
            int i11 = zza2 & this.zzf;
            Object obj2 = objArr[i11];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zza2 = i11 + 1;
        }
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    public final int size() {
        return this.zzg;
    }

    public final int zza(Object[] objArr, int i11) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final int zzc() {
        return 0;
    }

    public final zzjh zzd() {
        return zzg().listIterator(0);
    }

    public final Object[] zze() {
        return this.zzb;
    }

    public final zzja zzh() {
        return zzja.zzg(this.zzb, this.zzg);
    }

    public final boolean zzj() {
        return true;
    }
}
