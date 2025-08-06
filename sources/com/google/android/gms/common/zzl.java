package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzl extends zzj {
    private static final WeakReference zza = new WeakReference((Object) null);
    private WeakReference zzb = zza;

    public zzl(byte[] bArr) {
        super(bArr);
    }

    public abstract byte[] zzb();

    public final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzb.get();
            if (bArr == null) {
                bArr = zzb();
                this.zzb = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
