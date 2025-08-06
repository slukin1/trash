package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

public class FTOSPushHelper {

    /* renamed from: a  reason: collision with root package name */
    private static long f51278a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f2427a = false;

    private static void a(Context context) {
        AbstractPushManager a11 = e.a(context).a(d.ASSEMBLE_PUSH_FTOS);
        if (a11 != null) {
            b.a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a11.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j11 = f51278a;
            if (j11 <= 0 || j11 + 300000 <= elapsedRealtime) {
                f51278a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f2427a;
    }

    public static boolean hasNetwork(Context context) {
        return f.a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a11;
        if (map != null && map.containsKey("pushMsg")) {
            String str = map.get("pushMsg");
            if (!TextUtils.isEmpty(str) && (a11 = f.a(context)) != null) {
                MiPushMessage a12 = f.a(str);
                if (!a12.getExtra().containsKey("notify_effect")) {
                    a11.onNotificationMessageClicked(context, a12);
                }
            }
        }
    }

    public static void setNeedRegister(boolean z11) {
        f2427a = z11;
    }

    public static void uploadToken(Context context, String str) {
        f.a(context, d.ASSEMBLE_PUSH_FTOS, str);
    }
}
