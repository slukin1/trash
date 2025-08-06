package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhc;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

final class zzd implements AppMeasurementSdk.OnEventListener {
    public final /* synthetic */ zze zza;

    public zzd(zze zze) {
        this.zza = zze;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j11) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            int i11 = zzc.zza;
            String zza2 = zzhc.zza(str2);
            if (zza2 != null) {
                str2 = zza2;
            }
            bundle2.putString(DbParams.TABLE_EVENTS, str2);
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
