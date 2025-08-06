package com.engagelab.privates.push.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.push.api.NotificationMessage;
import com.huawei.hms.push.constant.RemoteMessageConst;

public class NotificationChannelUtil {
    private static final String CHANNEL_DEFAULT = "ENGAGELAB_PRIVATES_CHANNEL_default";
    private static final String CHANNEL_HIGH = "ENGAGELAB_PRIVATES_CHANNEL_high";
    private static final String CHANNEL_LOW = "ENGAGELAB_PRIVATES_CHANNEL_low";
    private static final String TAG = "NotificationChannelUtil";

    public static String getChannel(Context context, boolean z11, NotificationMessage notificationMessage) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        String channelId = getChannelId(context, z11, notificationMessage);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager.getNotificationChannel(channelId) != null) {
            return channelId;
        }
        String channelName = getChannelName(context, z11, notificationMessage);
        int channelImportance = getChannelImportance(context, z11, notificationMessage);
        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, channelImportance);
        Uri soundUri = NotificationUtil.getSoundUri(context, z11, notificationMessage);
        int defaults = NotificationUtil.getDefaults(context, z11, notificationMessage);
        notificationChannel.setLockscreenVisibility(NotificationUtil.getVisibility(context, z11, notificationMessage));
        notificationChannel.setSound(soundUri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        boolean z12 = true;
        notificationChannel.enableLights((defaults & 4) != 0);
        if ((defaults & 2) == 0) {
            z12 = false;
        }
        notificationChannel.enableVibration(z12);
        notificationManager.createNotificationChannel(notificationChannel);
        MTCommonLog.d(TAG, "build channel channelId:" + channelId + ", channelName:" + channelName + ", channelImportance:" + channelImportance);
        return channelId;
    }

    private static String getChannelId(Context context, boolean z11, NotificationMessage notificationMessage) {
        if (z11) {
            return CHANNEL_LOW;
        }
        if (!TextUtils.isEmpty(notificationMessage.getChannelId())) {
            return notificationMessage.getChannelId();
        }
        int priority = notificationMessage.getPriority();
        if (priority == -2 || priority == -1) {
            return CHANNEL_LOW;
        }
        if (priority == 1 || priority == 2) {
            if (TextUtils.isEmpty(notificationMessage.getSound())) {
                return "ENGAGELAB_PRIVATES_CHANNEL_high_" + notificationMessage.getDefaults();
            }
            return "ENGAGELAB_PRIVATES_CHANNEL_high_" + notificationMessage.getDefaults() + "_" + notificationMessage.getSound();
        } else if (TextUtils.isEmpty(notificationMessage.getSound())) {
            return "ENGAGELAB_PRIVATES_CHANNEL_default_" + notificationMessage.getDefaults();
        } else {
            return "ENGAGELAB_PRIVATES_CHANNEL_default_" + notificationMessage.getDefaults() + "_" + notificationMessage.getSound();
        }
    }

    private static int getChannelImportance(Context context, boolean z11, NotificationMessage notificationMessage) {
        int priority;
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        if (z11 || (priority = notificationMessage.getPriority()) == -2 || priority == -1) {
            return 2;
        }
        return (priority == 1 || priority == 2) ? 4 : 3;
    }

    private static String getChannelName(Context context, boolean z11, NotificationMessage notificationMessage) {
        String str = CHANNEL_LOW;
        if (z11) {
            return context.getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
        }
        int priority = notificationMessage.getPriority();
        if (!(priority == -2 || priority == -1)) {
            str = (priority == 1 || priority == 2) ? CHANNEL_HIGH : CHANNEL_DEFAULT;
        }
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        return identifier > 0 ? context.getString(identifier) : "NORMAL";
    }
}
