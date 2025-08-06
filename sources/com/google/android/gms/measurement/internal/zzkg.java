package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;

public final class zzkg {
    private final Context zza;

    public zzkg(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    private final zzet zzk() {
        return zzgd.zzp(this.zza, (zzcl) null, (Long) null).zzaA();
    }

    public final int zza(Intent intent, int i11, int i12) {
        zzgd zzp = zzgd.zzp(this.zza, (zzcl) null, (Long) null);
        zzet zzaA = zzp.zzaA();
        if (intent == null) {
            zzaA.zzk().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzp.zzay();
        zzaA.zzj().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i12), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzh(new zzkd(this, i12, zzaA, intent));
        }
        return 2;
    }

    public final IBinder zzb(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgv(zzlh.zzt(this.zza), (String) null);
        }
        zzk().zzk().zzb("onBind received unknown action", action);
        return null;
    }

    public final /* synthetic */ void zzc(int i11, zzet zzet, Intent intent) {
        if (((zzkf) this.zza).zzc(i11)) {
            zzet.zzj().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i11));
            zzk().zzj().zza("Completed wakeful intent.");
            ((zzkf) this.zza).zza(intent);
        }
    }

    public final /* synthetic */ void zzd(zzet zzet, JobParameters jobParameters) {
        zzet.zzj().zza("AppMeasurementJobService processed last upload request.");
        ((zzkf) this.zza).zzb(jobParameters, false);
    }

    public final void zze() {
        zzgd zzp = zzgd.zzp(this.zza, (zzcl) null, (Long) null);
        zzet zzaA = zzp.zzaA();
        zzp.zzay();
        zzaA.zzj().zza("Local AppMeasurementService is starting up");
    }

    public final void zzf() {
        zzgd zzp = zzgd.zzp(this.zza, (zzcl) null, (Long) null);
        zzet zzaA = zzp.zzaA();
        zzp.zzay();
        zzaA.zzj().zza("Local AppMeasurementService is shutting down");
    }

    public final void zzg(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onRebind called with null intent");
            return;
        }
        zzk().zzj().zzb("onRebind called. action", intent.getAction());
    }

    public final void zzh(Runnable runnable) {
        zzlh zzt = zzlh.zzt(this.zza);
        zzt.zzaB().zzp(new zzke(this, zzt, runnable));
    }

    @TargetApi(24)
    public final boolean zzi(JobParameters jobParameters) {
        zzgd zzp = zzgd.zzp(this.zza, (zzcl) null, (Long) null);
        zzet zzaA = zzp.zzaA();
        String string = jobParameters.getExtras().getString("action");
        zzp.zzay();
        zzaA.zzj().zzb("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzh(new zzkc(this, zzaA, jobParameters));
        return true;
    }

    public final boolean zzj(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzj().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
