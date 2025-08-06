package com.sumsub.sns.internal.core.common;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Iterator;
import kotlin.jvm.internal.x;
import p0.m;

public final class j {
    public static final boolean a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static final boolean b(Context context, String str) {
        T t11;
        if (Build.VERSION.SDK_INT < 26) {
            return m.d(context).a();
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (!notificationManager.areNotificationsEnabled()) {
            return false;
        }
        Iterator<T> it2 = notificationManager.getNotificationChannels().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((NotificationChannel) t11).getId(), str)) {
                break;
            }
        }
        NotificationChannel notificationChannel = (NotificationChannel) t11;
        if (notificationChannel == null || notificationChannel.getImportance() != 0) {
            return true;
        }
        return false;
    }
}
