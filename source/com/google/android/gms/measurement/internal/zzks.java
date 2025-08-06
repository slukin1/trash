package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbt;

public final class zzks extends zzku {
    private final AlarmManager zza = ((AlarmManager) this.zzt.zzaw().getSystemService("alarm"));
    private zzan zzb;
    private Integer zzc;

    public zzks(zzlh zzlh) {
        super(zzlh);
    }

    private final int zzf() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzt.zzaw().getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzh() {
        Context zzaw = this.zzt.zzaw();
        return PendingIntent.getBroadcast(zzaw, 0, new Intent().setClassName(zzaw, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.zza);
    }

    private final zzan zzi() {
        if (this.zzb == null) {
            this.zzb = new zzkr(this, this.zzf.zzp());
        }
        return this.zzb;
    }

    @TargetApi(24)
    private final void zzj() {
        JobScheduler jobScheduler = (JobScheduler) this.zzt.zzaw().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzf());
        }
    }

    public final void zza() {
        zzW();
        this.zzt.zzaA().zzj().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        zzi().zzb();
        if (Build.VERSION.SDK_INT >= 24) {
            zzj();
        }
    }

    public final boolean zzb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzj();
        return false;
    }

    public final void zzd(long j11) {
        zzW();
        this.zzt.zzay();
        Context zzaw = this.zzt.zzaw();
        if (!zzlp.zzal(zzaw)) {
            this.zzt.zzaA().zzc().zza("Receiver not registered/enabled");
        }
        if (!zzlp.zzam(zzaw, false)) {
            this.zzt.zzaA().zzc().zza("Service not registered/enabled");
        }
        zza();
        this.zzt.zzaA().zzj().zzb("Scheduling upload, millis", Long.valueOf(j11));
        long elapsedRealtime = this.zzt.zzax().elapsedRealtime() + j11;
        this.zzt.zzf();
        if (j11 < Math.max(0, ((Long) zzeg.zzx.zza((Object) null)).longValue()) && !zzi().zze()) {
            zzi().zzd(j11);
        }
        this.zzt.zzay();
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzaw2 = this.zzt.zzaw();
            ComponentName componentName = new ComponentName(zzaw2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int zzf = zzf();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            zzbt.zza(zzaw2, new JobInfo.Builder(zzf, componentName).setMinimumLatency(j11).setOverrideDeadline(j11 + j11).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            this.zzt.zzf();
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzeg.zzs.zza((Object) null)).longValue(), j11), zzh());
        }
    }
}
