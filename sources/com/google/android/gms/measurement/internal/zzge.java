package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class zzge implements Runnable {
    public final /* synthetic */ zzgv zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzge(zzgv zzgv, String str, Bundle bundle) {
        this.zza = zzgv;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc);
    }
}
