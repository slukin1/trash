package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkg;

public final class AppMeasurementService extends Service implements zzkf {
    private zzkg zza;

    private final zzkg zzd() {
        if (this.zza == null) {
            this.zza = new zzkg(this);
        }
        return this.zza;
    }

    public IBinder onBind(Intent intent) {
        return zzd().zzb(intent);
    }

    public void onCreate() {
        super.onCreate();
        zzd().zze();
    }

    public void onDestroy() {
        zzd().zzf();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        zzd().zzg(intent);
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        zzd().zza(intent, i11, i12);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final void zzb(JobParameters jobParameters, boolean z11) {
        throw new UnsupportedOperationException();
    }

    public final boolean zzc(int i11) {
        return stopSelfResult(i11);
    }
}
