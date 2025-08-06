package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

final class zzht implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzik zzb;

    public zzht(zzik zzik, Bundle bundle) {
        this.zzb = zzik;
        this.zza = bundle;
    }

    public final void run() {
        zzik zzik = this.zzb;
        Bundle bundle = this.zza;
        zzik.zzg();
        zzik.zza();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzik.zzt.zzJ()) {
            zzik.zzt.zzaA().zzj().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzlk zzlk = new zzlk(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string2);
        try {
            zzau zzz = zzik.zzt.zzv().zzz(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0, true, true);
            zzau zzz2 = zzik.zzt.zzv().zzz(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0, true, true);
            zzau zzz3 = zzik.zzt.zzv().zzz(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0, true, true);
            zzik.zzt.zzt().zzE(new zzac(bundle.getString("app_id"), string2, zzlk, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzz2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzz, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzz3));
        } catch (IllegalArgumentException unused) {
        }
    }
}
