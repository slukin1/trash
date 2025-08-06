package com.tencent.qcloud.tuikit.tuicallkit.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.qcloud.tuikit.tuicallkit.utils.DeviceUtils;

public class TUICallService extends Service {
    private static final int NOTIFICATION_ID = 1001;

    private Notification createForegroundNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("notification_channel_id_01", "TRTC Foreground Service Notification", 4);
            notificationChannel.setDescription("Channel description");
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        return new NotificationCompat.e((Context) this, "notification_channel_id_01").g();
    }

    public static void start(Context context) {
        if (!DeviceUtils.isServiceRunning(context, TUICallService.class.getName())) {
            Intent intent = new Intent(context, TUICallService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, TUICallService.class));
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate() {
        super.onCreate();
        Notification createForegroundNotification = createForegroundNotification();
        if (Build.VERSION.SDK_INT > 33) {
            startForeground(1001, createForegroundNotification, 128);
        } else {
            startForeground(1001, createForegroundNotification);
        }
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }
}
