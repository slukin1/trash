package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzc implements Runnable {
    public final /* synthetic */ LifecycleCallback zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzd zzc;

    public zzc(zzd zzd, LifecycleCallback lifecycleCallback, String str) {
        this.zzc = zzd;
        this.zza = lifecycleCallback;
        this.zzb = str;
    }

    public final void run() {
        Bundle bundle;
        zzd zzd = this.zzc;
        if (zzd.zzc > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            if (zzd.zzd != null) {
                bundle = zzd.zzd.getBundle(this.zzb);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (this.zzc.zzc >= 2) {
            this.zza.onStart();
        }
        if (this.zzc.zzc >= 3) {
            this.zza.onResume();
        }
        if (this.zzc.zzc >= 4) {
            this.zza.onStop();
        }
        if (this.zzc.zzc >= 5) {
            this.zza.onDestroy();
        }
    }
}
