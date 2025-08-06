package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzjs implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzq zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzjz zzf;

    public zzjs(zzjz zzjz, AtomicReference atomicReference, String str, String str2, String str3, zzq zzq, boolean z11) {
        this.zzf = zzjz;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzq;
        this.zze = z11;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                zzjz zzjz = this.zzf;
                zzej zzh = zzjz.zzb;
                if (zzh == null) {
                    zzjz.zzt.zzaA().zzd().zzd("(legacy) Failed to get user properties; not connected to service", (Object) null, this.zzb, this.zzc);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    Preconditions.checkNotNull(this.zzd);
                    this.zza.set(zzh.zzh(this.zzb, this.zzc, this.zze, this.zzd));
                } else {
                    this.zza.set(zzh.zzi((String) null, this.zzb, this.zzc, this.zze));
                }
                this.zzf.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e11) {
                try {
                    this.zzf.zzt.zzaA().zzd().zzd("(legacy) Failed to get user properties; remote exception", (Object) null, this.zzb, e11);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                } catch (Throwable th2) {
                    this.zza.notify();
                    throw th2;
                }
            }
        }
    }
}
