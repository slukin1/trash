package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.profileinstaller.f;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@KeepForSdk
public class FcmBroadcastProcessor {
    private static final String EXTRA_BINARY_DATA = "rawData";
    private static final String EXTRA_BINARY_DATA_BASE_64 = "gcm.rawData64";
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context2) {
        this.context = context2;
        this.executor = f.f10497b;
    }

    private static Task<Integer> bindToMessagingService(Context context2, Intent intent, boolean z11) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        WithinAppServiceConnection serviceConnection = getServiceConnection(context2, ServiceStarter.ACTION_MESSAGING_EVENT);
        if (!z11) {
            return serviceConnection.sendIntent(intent).continueWith(f.f10497b, d.f67120a);
        }
        if (ServiceStarter.getInstance().hasWakeLockPermission(context2)) {
            WakeLockHolder.sendWakefulServiceIntent(context2, serviceConnection, intent);
        } else {
            serviceConnection.sendIntent(intent);
        }
        return Tasks.forResult(-1);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context2, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context2, str);
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$bindToMessagingService$3(Task task) throws Exception {
        return -1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$startMessagingService$1(Task task) throws Exception {
        return 403;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task lambda$startMessagingService$2(Context context2, Intent intent, boolean z11, Task task) throws Exception {
        return (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) ? task : bindToMessagingService(context2, intent, z11).continueWith(f.f10497b, e.f67122a);
    }

    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    public static void setServiceConnection(WithinAppServiceConnection withinAppServiceConnection) {
        synchronized (lock) {
            fcmServiceConn = withinAppServiceConnection;
        }
    }

    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_BINARY_DATA_BASE_64);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(EXTRA_BINARY_DATA_BASE_64);
        }
        return startMessagingService(this.context, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> startMessagingService(Context context2, Intent intent) {
        boolean z11 = true;
        boolean z12 = PlatformVersion.isAtLeastO() && context2.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z11 = false;
        }
        if (!z12 || z11) {
            return Tasks.call(this.executor, new f(context2, intent)).continueWithTask(this.executor, new c(context2, intent, z11));
        }
        return bindToMessagingService(context2, intent, z11);
    }

    public FcmBroadcastProcessor(Context context2, ExecutorService executorService) {
        this.context = context2;
        this.executor = executorService;
    }
}
