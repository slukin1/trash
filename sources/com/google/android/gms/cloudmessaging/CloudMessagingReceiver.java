package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private final ExecutorService zza;

    public static final class IntentActionKeys {
        public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";

        private IntentActionKeys() {
        }
    }

    public static final class IntentKeys {
        public static final String PENDING_INTENT = "pending_intent";
        public static final String WRAPPED_INTENT = "wrapped_intent";

        private IntentKeys() {
        }
    }

    public CloudMessagingReceiver() {
        zze.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    private final int zzb(Context context, Intent intent) {
        Task<Void> task;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        if (TextUtils.isEmpty(stringExtra)) {
            task = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.MessagePayloadKeys.MSGID, stringExtra);
            task = zzs.zzb(context).zzc(2, bundle);
        }
        int onMessageReceive = onMessageReceive(context, new CloudMessage(intent));
        try {
            Tasks.await(task, TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            String valueOf = String.valueOf(e11);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Message ack failed: ");
            sb2.append(valueOf);
            Log.w("CloudMessagingReceiver", sb2.toString());
        }
        return onMessageReceive;
    }

    private final int zzc(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(IntentKeys.PENDING_INTENT);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove(IntentKeys.PENDING_INTENT);
        } else {
            extras = new Bundle();
        }
        if (IntentActionKeys.NOTIFICATION_DISMISS.equals(intent.getAction())) {
            onNotificationDismissed(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    public Executor getBroadcastExecutor() {
        return this.zza;
    }

    public abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    public void onNotificationDismissed(Context context, Bundle bundle) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            getBroadcastExecutor().execute(new zze(this, intent, context, isOrderedBroadcast(), goAsync()));
        }
    }

    public final /* synthetic */ void zza(Intent intent, Context context, boolean z11, BroadcastReceiver.PendingResult pendingResult) {
        int i11;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra(IntentKeys.WRAPPED_INTENT);
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                i11 = zzc(context, intent2);
            } else {
                i11 = zzb(context, intent);
            }
            if (z11) {
                pendingResult.setResultCode(i11);
            }
        } finally {
            pendingResult.finish();
        }
    }
}
