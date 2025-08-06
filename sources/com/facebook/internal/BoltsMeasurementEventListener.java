package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.xiaomi.mipush.sdk.Constants;
import s1.a;

public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    private void close() {
        a.b(this.applicationContext).e(this);
    }

    public static BoltsMeasurementEventListener getInstance(Context context) {
        BoltsMeasurementEventListener boltsMeasurementEventListener = _instance;
        if (boltsMeasurementEventListener != null) {
            return boltsMeasurementEventListener;
        }
        BoltsMeasurementEventListener boltsMeasurementEventListener2 = new BoltsMeasurementEventListener(context);
        _instance = boltsMeasurementEventListener2;
        boltsMeasurementEventListener2.open();
        return _instance;
    }

    private void open() {
        a.b(this.applicationContext).c(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
    }

    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        String str = BOLTS_MEASUREMENT_EVENT_PREFIX + intent.getStringExtra("event_name");
        Bundle bundleExtra = intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
        Bundle bundle = new Bundle();
        for (String str2 : bundleExtra.keySet()) {
            bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", Constants.ACCEPT_TIME_SEPARATOR_SERVER).replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
        }
        internalAppEventsLogger.logEvent(str, bundle);
    }
}
