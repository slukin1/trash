package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzlb implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb = "_err";
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzlc zzd;

    public zzlb(zzlc zzlc, String str, String str2, Bundle bundle) {
        this.zzd = zzlc;
        this.zza = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zzd.zza.zzF((zzau) Preconditions.checkNotNull(this.zzd.zza.zzv().zzz(this.zza, this.zzb, this.zzc, TtmlNode.TEXT_EMPHASIS_AUTO, this.zzd.zza.zzax().currentTimeMillis(), false, true)), this.zza);
    }
}
