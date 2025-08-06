package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzjw implements Runnable {
    public final /* synthetic */ zzjy zza;

    public zzjw(zzjy zzjy) {
        this.zza = zzjy;
    }

    public final void run() {
        zzjz zzjz = this.zza.zza;
        Context zzaw = zzjz.zzt.zzaw();
        this.zza.zza.zzt.zzay();
        zzjz.zzo(zzjz, new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
