package com.zopim.android.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class ServiceUtils {
    private static final String CHANNEL_ID = "zopim.notification.id";
    private static final int REQUEST_CODE = 43789;
    private static final int SERVICE_ID = 234;

    private static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i11 = applicationInfo.labelRes;
        return i11 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i11);
    }

    @TargetApi(26)
    private static NotificationChannel getNotificationChannel(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, context.getString(R.string.chat_notification_notification_channel), 1);
        notificationChannel.setSound((Uri) null, (AudioAttributes) null);
        notificationChannel.setVibrationPattern((long[]) null);
        return notificationChannel;
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    @TargetApi(26)
    private static Notification getServiceNotification(Context context, Intent intent) {
        Notification.Builder contentText = new Notification.Builder(context, CHANNEL_ID).setSmallIcon(R.drawable.ic_foreground_notification).setContentText(context.getString(R.string.chat_notification_content_text, new Object[]{getApplicationName(context)}));
        if (intent != null) {
            PushAutoTrackHelper.hookIntentGetActivity(context, REQUEST_CODE, intent, 134217728);
            PendingIntent activity = PendingIntent.getActivity(context, REQUEST_CODE, intent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetActivity(activity, context, REQUEST_CODE, intent, 134217728);
            contentText.setContentIntent(activity);
        }
        getNotificationManager(context).createNotificationChannel(getNotificationChannel(context));
        return contentText.build();
    }

    public static void startAsForegroundServiceIfNeeded(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void startForegroundIfNeeded(Service service, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            service.startForeground(SERVICE_ID, getServiceNotification(service, intent));
        }
    }
}
