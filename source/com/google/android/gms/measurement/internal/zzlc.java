package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class zzlc implements zzlo {
    public final /* synthetic */ zzlh zza;

    public zzlc(zzlh zzlh) {
        this.zza = zzlh;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            zzlh zzlh = this.zza;
            if (zzlh.zzn != null) {
                zzlh.zzn.zzaA().zzd().zzb("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.zza.zzaB().zzp(new zzlb(this, str, "_err", bundle));
    }
}
