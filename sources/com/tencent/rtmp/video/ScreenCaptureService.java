package com.tencent.rtmp.video;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Binder;
import android.os.IBinder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

public class ScreenCaptureService extends Service {
    private static final String CHANNEL_ID = "notification_id";
    private static final int NOTIFICATION_ID = 13957237;
    private static final String TAG = "ScreenCaptureService";

    private Notification createNotification() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            ((NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION)).createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
        }
        Notification.Builder defaults = new Notification.Builder(this).setDefaults(1);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            defaults.setChannelId("notification_id");
        }
        return defaults.build();
    }

    public IBinder onBind(Intent intent) {
        LiteavLog.i(TAG, "Service on bind");
        return new Binder();
    }

    public void onDestroy() {
        stopForeground(true);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        int intExtra = intent.getIntExtra("code", -1);
        Intent intent2 = (Intent) intent.getParcelableExtra("data");
        LiteavLog.i(TAG, "On Start server command, code:" + intExtra + ", data:" + intent2);
        if (intent2 == null) {
            stopSelf();
            return 2;
        }
        try {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 29) {
                startForeground(NOTIFICATION_ID, createNotification(), 32);
            } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
                startForeground(NOTIFICATION_ID, createNotification());
            }
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "start foreground failed.", th2);
        }
        MediaProjection mediaProjection = null;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            try {
                mediaProjection = ((MediaProjectionManager) getSystemService("media_projection")).getMediaProjection(intExtra, intent2);
            } catch (Throwable th3) {
                LiteavLog.e(TAG, "onStartCommand mediaProjectionManager getMediaProjection fail.", th3);
            }
            VirtualDisplayManager.a((Context) this).a(mediaProjection);
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        LiteavLog.i(TAG, "Service on unbind");
        return super.onUnbind(intent);
    }
}
