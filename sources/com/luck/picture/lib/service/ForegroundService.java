package com.luck.picture.lib.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class ForegroundService extends Service {
    private static final String CHANNEL_ID = ("com.luck.picture.lib." + ForegroundService.class.getName());
    private static final String CHANNEL_NAME = "com.luck.picture.lib";
    private static final int NOTIFICATION_ID = 1;
    private static boolean isForegroundServiceIng = false;

    private Notification createForegroundNotification() {
        int i11 = SdkVersionUtils.isMaxN() ? 4 : 0;
        if (SdkVersionUtils.isO()) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "com.luck.picture.lib", i11);
            notificationChannel.setLightColor(-16776961);
            notificationChannel.canBypassDnd();
            notificationChannel.setBypassDnd(true);
            notificationChannel.setLockscreenVisibility(0);
            ((NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION)).createNotificationChannel(notificationChannel);
        }
        return new NotificationCompat.e((Context) this, CHANNEL_ID).X(R.drawable.ps_ic_trans_1px).C(getAppName()).B(getString(SelectorProviders.getInstance().getSelectorConfig().chooseMode == SelectMimeType.ofAudio() ? R.string.ps_use_sound : R.string.ps_use_camera)).O(true).g();
    }

    private String getAppName() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.loadLabel(getPackageManager()).toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static void startForegroundService(Context context, boolean z11) {
        try {
            if (!isForegroundServiceIng && z11) {
                Intent intent = new Intent(context, ForegroundService.class);
                if (SdkVersionUtils.isO()) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void stopService(Context context) {
        try {
            if (isForegroundServiceIng) {
                context.stopService(new Intent(context, ForegroundService.class));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        startForeground(1, createForegroundNotification());
    }

    public void onDestroy() {
        isForegroundServiceIng = false;
        stopForeground(true);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        isForegroundServiceIng = true;
        return super.onStartCommand(intent, i11, i12);
    }
}
