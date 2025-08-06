package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.c.a;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK})
public class XGPushReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f68058a;

    public void a(Context context, Intent intent) {
        TLogger.d("XGPushReceiver", "ping from alarmManager");
        Util.getWakeCpu(context);
        a.a().f68881b.b((OnMqttCallback) null);
    }

    public void onReceive(final Context context, final Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (context == null || intent == null) {
            Util.killPushProcess(context);
            return;
        }
        this.f68058a = context;
        final String action = intent.getAction();
        if (action != null) {
            b.b(context.getApplicationContext());
            if (XGPushConfig.enableDebug) {
                TLogger.d("XGPushReceiver", "PushReceiver received " + action + " @@ " + context.getPackageName());
            }
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    if (!j.i(context)) {
                        Util.killPushProcess(context);
                    } else if (Constants.ACTION_INTERNAL_PUSH_MESSAGE.equals(action)) {
                        a.b(b.e());
                    } else if (!Constants.ACTION_SDK_INSTALL.equals(action)) {
                        if (Constants.XG_PUSH_SERVICE_PING_ACTION.equals(action)) {
                            XGPushReceiver.this.a(context, intent);
                            return;
                        }
                        TLogger.d("XGPushReceiver", "start XGService");
                        b.a(context.getApplicationContext(), 3500);
                        a.b(context.getApplicationContext());
                    }
                }
            });
        }
    }
}
