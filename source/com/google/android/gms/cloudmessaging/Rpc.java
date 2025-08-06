package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sumsub.sentry.a;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rpc {
    private static int zza;
    private static PendingIntent zzb;
    private static final Executor zzc = zzz.zza;
    private static final Pattern zzd = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zze = new SimpleArrayMap<>();
    private final Context zzf;
    private final zzt zzg;
    private final ScheduledExecutorService zzh;
    private Messenger zzi;
    private Messenger zzj;
    private zzd zzk;

    public Rpc(Context context) {
        this.zzf = context;
        this.zzg = new zzt(context);
        this.zzi = new Messenger(new zzaa(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzh = scheduledThreadPoolExecutor;
    }

    public static /* synthetic */ Task zza(Bundle bundle) throws Exception {
        if (zzi(bundle)) {
            return Tasks.forResult(null);
        }
        return Tasks.forResult(bundle);
    }

    public static /* bridge */ /* synthetic */ void zzc(Rpc rpc, Message message) {
        String str;
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzc());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.zzk = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.zzj = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra(MTCoreConstants.Register.KEY_REGISTRATION_ID);
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            String valueOf = String.valueOf(intent2.getExtras());
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
                            sb2.append("Unexpected response, no error or registration id ");
                            sb2.append(valueOf);
                            Log.w("Rpc", sb2.toString());
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            if (stringExtra2.length() != 0) {
                                str = "Received InstanceID error ".concat(stringExtra2);
                            } else {
                                str = new String("Received InstanceID error ");
                            }
                            Log.d("Rpc", str);
                        }
                        if (stringExtra2.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !"ID".equals(split[1])) {
                                Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                                return;
                            }
                            String str2 = split[2];
                            String str3 = split[3];
                            if (str3.startsWith(":")) {
                                str3 = str3.substring(1);
                            }
                            rpc.zzh(str2, intent2.putExtra("error", str3).getExtras());
                            return;
                        }
                        synchronized (rpc.zze) {
                            for (int i11 = 0; i11 < rpc.zze.size(); i11++) {
                                rpc.zzh(rpc.zze.l(i11), intent2.getExtras());
                            }
                        }
                        return;
                    }
                    Matcher matcher = zzd.matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        if (group != null) {
                            Bundle extras = intent2.getExtras();
                            extras.putString(MTCoreConstants.Register.KEY_REGISTRATION_ID, group2);
                            rpc.zzh(group, extras);
                            return;
                        }
                        return;
                    } else if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                        return;
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    String valueOf2 = String.valueOf(action);
                    Log.d("Rpc", valueOf2.length() != 0 ? "Unexpected response action: ".concat(valueOf2) : new String("Unexpected response action: "));
                    return;
                } else {
                    return;
                }
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    private final Task<Bundle> zze(Bundle bundle) {
        String zzf2 = zzf();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.zze) {
            this.zze.put(zzf2, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.zzg.zzb() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        zzg(this.zzf, intent);
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzf2).length() + 5);
        sb2.append("|ID|");
        sb2.append(zzf2);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        intent.putExtra("kid", sb2.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 8);
            sb3.append("Sending ");
            sb3.append(valueOf);
            Log.d("Rpc", sb3.toString());
        }
        intent.putExtra("google.messenger", this.zzi);
        if (!(this.zzj == null && this.zzk == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.zzj;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.zzk.zzb(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            taskCompletionSource.getTask().addOnCompleteListener(zzc, new zzw(this, zzf2, this.zzh.schedule(new zzy(taskCompletionSource), 30, TimeUnit.SECONDS)));
            return taskCompletionSource.getTask();
        }
        if (this.zzg.zzb() == 2) {
            this.zzf.sendBroadcast(intent);
        } else {
            this.zzf.startService(intent);
        }
        taskCompletionSource.getTask().addOnCompleteListener(zzc, new zzw(this, zzf2, this.zzh.schedule(new zzy(taskCompletionSource), 30, TimeUnit.SECONDS)));
        return taskCompletionSource.getTask();
    }

    private static synchronized String zzf() {
        String num;
        synchronized (Rpc.class) {
            int i11 = zza;
            zza = i11 + 1;
            num = Integer.toString(i11);
        }
        return num;
    }

    private static synchronized void zzg(Context context, Intent intent) {
        synchronized (Rpc.class) {
            if (zzb == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzb = zza.zza(context, 0, intent2, zza.zza);
            }
            intent.putExtra(a.f30241h, zzb);
        }
    }

    private final void zzh(String str, Bundle bundle) {
        String str2;
        synchronized (this.zze) {
            TaskCompletionSource remove = this.zze.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "Missing callback for ".concat(valueOf);
                } else {
                    str2 = new String("Missing callback for ");
                }
                Log.w("Rpc", str2);
                return;
            }
            remove.setResult(bundle);
        }
    }

    private static boolean zzi(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public Task<Bundle> send(Bundle bundle) {
        if (this.zzg.zza() >= 12000000) {
            return zzs.zzb(this.zzf).zzd(1, bundle).continueWith(zzc, zzv.zza);
        }
        if (this.zzg.zzb() != 0) {
            return zze(bundle).continueWithTask(zzc, new zzu(this, bundle));
        }
        return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
    }

    public final /* synthetic */ Task zzb(Bundle bundle, Task task) throws Exception {
        if (task.isSuccessful() && zzi((Bundle) task.getResult())) {
            return zze(bundle).onSuccessTask(zzc, zzx.zza);
        }
        return task;
    }

    public final /* synthetic */ void zzd(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.zze) {
            this.zze.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
