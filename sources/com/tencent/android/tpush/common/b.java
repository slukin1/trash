package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile C0741b f68894a;

    public static class a extends TTask {

        /* renamed from: a  reason: collision with root package name */
        private Context f68895a = null;

        /* renamed from: b  reason: collision with root package name */
        private Intent f68896b = null;

        public a(Context context, Intent intent) {
            this.f68895a = context;
            this.f68896b = intent;
        }

        public void TRun() {
            String action = this.f68896b.getAction();
            if (action != null) {
                TLogger.d("AppChangesHandler", "action:" + action);
            }
        }
    }

    /* renamed from: com.tencent.android.tpush.common.b$b  reason: collision with other inner class name */
    public static class C0741b extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent != null && context != null) {
                CommonWorkingThread.getInstance().execute(new a(context, intent));
            }
        }
    }

    public static void a(Context context) {
    }
}
