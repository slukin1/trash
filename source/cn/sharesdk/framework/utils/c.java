package cn.sharesdk.framework.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class c {
    public static PendingIntent a(Context context, int i11, Intent intent, int i12) {
        if (Build.VERSION.SDK_INT >= 23) {
            PushAutoTrackHelper.hookIntentGetBroadcast(context, i11, intent, 67108864);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i11, intent, 67108864);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, i11, intent, 67108864);
            return broadcast;
        }
        PushAutoTrackHelper.hookIntentGetBroadcast(context, i11, intent, i12);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, i11, intent, i12);
        PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast2, context, i11, intent, i12);
        return broadcast2;
    }
}
