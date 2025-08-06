package com.mob.commons.cc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import com.mob.commons.s;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class e implements t<NotificationManager> {
    public boolean a(NotificationManager notificationManager, Class<NotificationManager> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (!s.a("025c8dj fdifZegdk)i3diefdi,cdi@didk!e@ed+hdeefg").equals(str) || Build.VERSION.SDK_INT < 26 || objArr.length != 1 || !(objArr[0] instanceof NotificationChannel)) {
            if (s.a("006eNdk1i2diefec").equals(str)) {
                if (objArr.length == 2) {
                    int intValue = objArr[0].intValue();
                    Notification notification = objArr[1];
                    notificationManager.notify(intValue, notification);
                    PushAutoTrackHelper.onNotify(notificationManager, intValue, notification);
                    return true;
                } else if (objArr.length == 3) {
                    String str2 = objArr[0];
                    int intValue2 = objArr[1].intValue();
                    Notification notification2 = objArr[2];
                    notificationManager.notify(str2, intValue2, notification2);
                    PushAutoTrackHelper.onNotify(notificationManager, str2, intValue2, notification2);
                    return true;
                }
            } else if (s.a("025BdcQfgfifRegdk4iKdiefdi$cdiNdidk?eUedIhdeefg").equals(str) && Build.VERSION.SDK_INT >= 26 && objArr.length == 1) {
                notificationManager.deleteNotificationChannel(objArr[0]);
                return true;
            } else if (s.a("006cdecfg").equals(str)) {
                if (objArr.length == 1) {
                    notificationManager.cancel(objArr[0].intValue());
                    return true;
                } else if (objArr.length == 2) {
                    notificationManager.cancel(objArr[0], objArr[1].intValue());
                    return true;
                }
            }
            return false;
        }
        notificationManager.createNotificationChannel(objArr[0]);
        return true;
    }
}
