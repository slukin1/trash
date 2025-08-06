package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class zzhk implements Runnable {
    public final /* synthetic */ zzik zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzhk(zzik zzik, Bundle bundle) {
        this.zza = zzik;
        this.zzb = bundle;
    }

    public final void run() {
        this.zza.zzC(this.zzb);
    }
}
