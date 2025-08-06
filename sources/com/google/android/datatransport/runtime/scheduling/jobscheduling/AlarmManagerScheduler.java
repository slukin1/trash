package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerScheduler implements WorkScheduler {
    public static final String ATTEMPT_NUMBER = "attemptNumber";
    public static final String BACKEND_NAME = "backendName";
    public static final String EVENT_PRIORITY = "priority";
    public static final String EXTRAS = "extras";
    private static final String LOG_TAG = "AlarmManagerScheduler";
    private AlarmManager alarmManager;
    private final Clock clock;
    private final SchedulerConfig config;
    private final Context context;
    private final EventStore eventStore;

    public AlarmManagerScheduler(Context context2, EventStore eventStore2, Clock clock2, SchedulerConfig schedulerConfig) {
        this(context2, eventStore2, (AlarmManager) context2.getSystemService("alarm"), clock2, schedulerConfig);
    }

    public boolean isJobServiceOn(Intent intent) {
        return PendingIntent.getBroadcast(this.context, 0, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912) != null;
    }

    public void schedule(TransportContext transportContext, int i11) {
        schedule(transportContext, i11, false);
    }

    public void schedule(TransportContext transportContext, int i11, boolean z11) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", transportContext.getBackendName());
        builder.appendQueryParameter("priority", String.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        if (transportContext.getExtras() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        Intent intent = new Intent(this.context, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i11);
        if (z11 || !isJobServiceOn(intent)) {
            long nextCallTime = this.eventStore.getNextCallTime(transportContext);
            long scheduleDelay = this.config.getScheduleDelay(transportContext.getPriority(), nextCallTime, i11);
            Logging.d(LOG_TAG, "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(scheduleDelay), Long.valueOf(nextCallTime), Integer.valueOf(i11));
            this.alarmManager.set(3, this.clock.getTime() + scheduleDelay, PendingIntent.getBroadcast(this.context, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
            return;
        }
        Logging.d(LOG_TAG, "Upload for context %s is already scheduled. Returning...", (Object) transportContext);
    }

    public AlarmManagerScheduler(Context context2, EventStore eventStore2, AlarmManager alarmManager2, Clock clock2, SchedulerConfig schedulerConfig) {
        this.context = context2;
        this.eventStore = eventStore2;
        this.alarmManager = alarmManager2;
        this.clock = clock2;
        this.config = schedulerConfig;
    }
}
