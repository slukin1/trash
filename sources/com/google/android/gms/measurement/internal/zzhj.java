package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

public final /* synthetic */ class zzhj implements Runnable {
    public final /* synthetic */ zzik zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzhj(zzik zzik, Bundle bundle, long j11) {
        this.zza = zzik;
        this.zzb = bundle;
        this.zzc = j11;
    }

    public final void run() {
        zzik zzik = this.zza;
        Bundle bundle = this.zzb;
        long j11 = this.zzc;
        if (TextUtils.isEmpty(zzik.zzt.zzh().zzm())) {
            zzik.zzS(bundle, 0, j11);
        } else {
            zzik.zzt.zzaA().zzl().zza("Using developer consent only; google app id found");
        }
    }
}
