package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class zzju implements Runnable {
    public final /* synthetic */ ComponentName zza;
    public final /* synthetic */ zzjy zzb;

    public zzju(zzjy zzjy, ComponentName componentName) {
        this.zzb = zzjy;
        this.zza = componentName;
    }

    public final void run() {
        zzjz.zzo(this.zzb.zza, this.zza);
    }
}
