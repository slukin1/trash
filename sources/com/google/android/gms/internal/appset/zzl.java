package com.google.android.gms.internal.appset;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzl implements AppSetIdClient {
    private static AppSetIdClient zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private boolean zzc = false;
    private final ScheduledExecutorService zzd;
    private final ExecutorService zze;

    public zzl(Context context) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.zzd = newSingleThreadScheduledExecutor;
        this.zze = Executors.newSingleThreadExecutor();
        this.zzb = context;
        if (!this.zzc) {
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(new zzj(this, (zzi) null), 0, 86400, TimeUnit.SECONDS);
            this.zzc = true;
        }
    }

    public static synchronized AppSetIdClient zzc(Context context) {
        AppSetIdClient appSetIdClient;
        synchronized (zzl.class) {
            Preconditions.checkNotNull(context, "Context must not be null");
            if (zza == null) {
                zza = new zzl(context.getApplicationContext());
            }
            appSetIdClient = zza;
        }
        return appSetIdClient;
    }

    public static final void zze(Context context) {
        String str;
        if (!zzf(context).edit().remove("app_set_id").commit()) {
            String valueOf = String.valueOf(context.getPackageName());
            if (valueOf.length() != 0) {
                str = "Failed to clear app set ID generated for App ".concat(valueOf);
            } else {
                str = new String("Failed to clear app set ID generated for App ");
            }
            Log.e("AppSet", str);
        }
        if (!zzf(context).edit().remove("app_set_id_last_used_time").commit()) {
            String valueOf2 = String.valueOf(context.getPackageName());
            Log.e("AppSet", valueOf2.length() != 0 ? "Failed to clear app set ID last used time for App ".concat(valueOf2) : new String("Failed to clear app set ID last used time for App "));
        }
    }

    private static final SharedPreferences zzf(Context context) {
        return context.getSharedPreferences("app_set_id_storage", 0);
    }

    private static final void zzg(Context context) throws zzk {
        String str;
        SharedPreferences zzf = zzf(context);
        if (!zzf.edit().putLong("app_set_id_last_used_time", DefaultClock.getInstance().currentTimeMillis()).commit()) {
            String valueOf = String.valueOf(context.getPackageName());
            if (valueOf.length() != 0) {
                str = "Failed to store app set ID last used time for App ".concat(valueOf);
            } else {
                str = new String("Failed to store app set ID last used time for App ");
            }
            Log.e("AppSet", str);
            throw new zzk("Failed to store the app set ID last used time.");
        }
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zze.execute(new zzh(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final long zza() {
        long j11 = zzf(this.zzb).getLong("app_set_id_last_used_time", -1);
        if (j11 != -1) {
            return j11 + 33696000000L;
        }
        return -1;
    }

    public final /* synthetic */ void zzd(TaskCompletionSource taskCompletionSource) {
        String str;
        String str2;
        String string = zzf(this.zzb).getString("app_set_id", (String) null);
        long zza2 = zza();
        if (string == null || DefaultClock.getInstance().currentTimeMillis() > zza2) {
            string = UUID.randomUUID().toString();
            try {
                Context context = this.zzb;
                if (!zzf(context).edit().putString("app_set_id", string).commit()) {
                    String valueOf = String.valueOf(context.getPackageName());
                    if (valueOf.length() != 0) {
                        str2 = "Failed to store app set ID generated for App ".concat(valueOf);
                    } else {
                        str2 = new String("Failed to store app set ID generated for App ");
                    }
                    Log.e("AppSet", str2);
                    throw new zzk("Failed to store the app set ID.");
                }
                zzg(context);
                Context context2 = this.zzb;
                SharedPreferences zzf = zzf(context2);
                if (!zzf.edit().putLong("app_set_id_creation_time", DefaultClock.getInstance().currentTimeMillis()).commit()) {
                    String valueOf2 = String.valueOf(context2.getPackageName());
                    if (valueOf2.length() != 0) {
                        str = "Failed to store app set ID creation time for App ".concat(valueOf2);
                    } else {
                        str = new String("Failed to store app set ID creation time for App ");
                    }
                    Log.e("AppSet", str);
                    throw new zzk("Failed to store the app set ID creation time.");
                }
            } catch (zzk e11) {
                taskCompletionSource.setException(e11);
                return;
            }
        } else {
            try {
                zzg(this.zzb);
            } catch (zzk e12) {
                taskCompletionSource.setException(e12);
                return;
            }
        }
        taskCompletionSource.setResult(new AppSetIdInfo(string, 1));
    }
}
