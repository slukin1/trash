package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.af;
import com.xiaomi.push.ax;
import com.xiaomi.push.dw;
import com.xiaomi.push.j;
import com.xiaomi.push.t;
import java.util.List;
import java.util.Map;

public class bb {
    /* access modifiers changed from: private */
    @TargetApi(19)
    public static void c(Context context, String str, int i11, String str2, Notification notification) {
        af a11;
        Notification a12;
        Context context2 = context;
        int i12 = i11;
        String str3 = str2;
        Notification notification2 = notification;
        if (context2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && Build.VERSION.SDK_INT >= 26 && (a12 = a(notification2, i12, str3, a11)) != null) {
            boolean z11 = notification2 != null;
            if (a12.getGroupAlertBehavior() != 1) {
                ax.a((Object) a12, "mGroupAlertBehavior", (Object) 1);
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j11 = a12.extras.getLong("mipush_org_when", 0);
            int i13 = a12.extras.getInt("mipush_n_top_fre", 0);
            int i14 = a12.extras.getInt("mipush_n_top_prd", 0);
            if (i14 > 0 && i14 >= i13) {
                int i15 = i14;
                String str4 = "mipush_n_top_prd";
                long j12 = ((long) (i14 * 1000)) + j11;
                int min = (j11 >= currentTimeMillis || currentTimeMillis >= j12) ? 0 : i13 > 0 ? (int) Math.min((j12 - currentTimeMillis) / 1000, (long) i13) : i15;
                if (!z11) {
                    if (min > 0) {
                        a12.when = currentTimeMillis;
                        b.a("update top notification: " + str3);
                        a11.a(i12, a12);
                    } else {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context2, a12);
                        recoverBuilder.setPriority(0);
                        recoverBuilder.setWhen(currentTimeMillis);
                        Bundle extras = recoverBuilder.getExtras();
                        if (extras != null) {
                            extras.remove("mipush_n_top_flag");
                            extras.remove("mipush_org_when");
                            extras.remove("mipush_n_top_fre");
                            extras.remove(str4);
                            recoverBuilder.setExtras(extras);
                        }
                        b.a("update top notification to common: " + str3);
                        (a11 = af.a(context, str)).a(i12, recoverBuilder.build());
                    }
                }
                if (min > 0) {
                    b.a("schedule top notification next update delay: " + min);
                    af.a(context).a(b(i11, str2));
                    af.a(context).b(a(context2, str, i12, str3, (Notification) null), min);
                }
            }
        }
    }

    public static void a(Context context, Map<String, String> map, dw dwVar, long j11) {
        if (map != null && dwVar != null && j.a(context) && a(map)) {
            int a11 = a(map);
            int b11 = b(map);
            if (a11 <= 0 || b11 > a11) {
                b.d("set top notification failed - period:" + a11 + " frequency:" + b11);
                return;
            }
            dwVar.setPriority(2);
            Bundle bundle = new Bundle();
            bundle.putLong("mipush_org_when", j11);
            bundle.putBoolean("mipush_n_top_flag", true);
            if (b11 > 0) {
                bundle.putInt("mipush_n_top_fre", b11);
            }
            bundle.putInt("mipush_n_top_prd", a11);
            dwVar.addExtras(bundle);
        }
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, t.a(map.get("notification_top_frequency"), 0));
    }

    /* access modifiers changed from: private */
    public static String b(int i11, String str) {
        return "n_top_update_" + i11 + "_" + str;
    }

    @TargetApi(19)
    /* renamed from: a  reason: collision with other method in class */
    public static void m3009a(Context context, String str, int i11, String str2, Notification notification) {
        if (j.a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i11, str2, notification);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m3010a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        b.c("top notification' repeat is " + parseBoolean);
        return parseBoolean;
    }

    private static int a(Map<String, String> map) {
        return Math.max(0, t.a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    private static Notification a(Notification notification, int i11, String str, af afVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString(Constants.MessagePayloadKeys.MSGID_SERVER))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> b11 = afVar.b();
        if (b11 == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : b11) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString(Constants.MessagePayloadKeys.MSGID_SERVER);
            if (i11 == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    private static af.a a(Context context, String str, int i11, String str2, Notification notification) {
        final int i12 = i11;
        final String str3 = str2;
        final Context context2 = context;
        final String str4 = str;
        final Notification notification2 = notification;
        return new af.a() {
            public String a() {
                return bb.b(i12, str3);
            }

            @TargetApi(19)
            public void run() {
                bb.c(context2, str4, i12, str3, notification2);
            }
        };
    }
}
