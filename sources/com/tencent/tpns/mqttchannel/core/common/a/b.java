package com.tencent.tpns.mqttchannel.core.common.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.common.Constants;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f49965a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f49966b;

    /* renamed from: c  reason: collision with root package name */
    private static Integer f49967c;

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String b(Context context, String str) {
        return "/_xg/push/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String c(Context context, String str) {
        return "/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String d(Context context, String str) {
        return "/_xg/push/aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String e(Context context, String str) {
        return "/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String f(Context context, String str) {
        return "/_xg/push/gzip/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String g(Context context, String str) {
        return "/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String h(Context context, String str) {
        return "/_xg/push/gzip_aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static boolean i(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean j(Context context, String str) {
        return str.startsWith("/_xg/push/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean k(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean l(Context context, String str) {
        return str.startsWith("/_xg/push/aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean m(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean n(Context context, String str) {
        return str.startsWith("/_xg/push/gzip/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean o(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean p(Context context, String str) {
        return str.startsWith("/_xg/push/gzip_aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static String a(Context context, String str) {
        return "/_xg/rpc/recv/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static void b(Context context) {
        Intent e11 = e(context);
        c(context, e11);
        Boolean valueOf = Boolean.valueOf(MqttConfig.isEnabledAlarmManager(context));
        f49966b = valueOf;
        if (valueOf == null || !valueOf.booleanValue()) {
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "disable alarm manager");
        } else {
            a(context, e11);
        }
    }

    public static void c(Context context) {
        Intent e11 = e(context);
        c(context, e11);
        if (f49966b == null) {
            f49966b = Boolean.valueOf(MqttConfig.isEnabledAlarmManager(context));
        }
        Boolean bool = f49966b;
        if (bool == null || !bool.booleanValue()) {
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "disable alarm manager");
        } else {
            b(context, e11);
        }
    }

    public static void d(Context context) {
        c(context, e(context));
    }

    private static Intent e(Context context) {
        Intent intent = new Intent(Constants.XG_PUSH_SERVICE_PING_ACTION);
        intent.setClassName(context, "com.tencent.android.tpush.XGPushReceiver");
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static boolean a(Context context) {
        try {
            if (!Util.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return true;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            if (a()) {
                return true;
            }
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "APNUtil -> checkNetWork", th2);
            int i11 = f49965a + 1;
            f49965a = i11;
            if (i11 >= 5) {
                f49965a = 0;
                return true;
            }
        }
    }

    private static void b(Context context, Intent intent) {
        try {
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "startPingByAlarmManager");
            if (f49967c == null) {
                f49967c = Integer.valueOf(MqttConfig.getAlarmManagerKeepAliveInterval(context));
            }
            int i11 = 134217728;
            if (Build.VERSION.SDK_INT >= 31) {
                i11 = 167772160;
            }
            PushAutoTrackHelper.hookIntentGetBroadcast(context, 0, intent, i11);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i11);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, 0, intent, i11);
            TPushAlarmManager.getAlarmManager(context).set(0, ((long) (f49967c.intValue() * 1000)) + System.currentTimeMillis(), broadcast, XGApiConfig.isPowerSaveMode(context));
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "Alarm started with interval: " + f49967c);
        } catch (Throwable th2) {
            a.d("com.tencent.tpns.mqttchannel.core.common.util", "startPingByAlarmManager error: " + th2.toString());
        }
    }

    private static void c(Context context, Intent intent) {
        try {
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "cancelPingAlarmManager");
            int i11 = 134217728;
            if (Build.VERSION.SDK_INT >= 31) {
                i11 = 167772160;
            }
            PushAutoTrackHelper.hookIntentGetBroadcast(context, 0, intent, i11);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i11);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, 0, intent, i11);
            TPushAlarmManager.getAlarmManager(context).cancal(broadcast);
        } catch (Throwable th2) {
            a.d("com.tencent.tpns.mqttchannel.core.common.util", "cancelPingAlarmManager error: " + th2.toString());
        }
    }

    public static boolean a() {
        try {
            Process exec = Runtime.getRuntime().exec("ping -c 1 -w 10 www.qq.com");
            int waitFor = exec.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (bufferedReader.readLine() != null) {
            }
            bufferedReader.close();
            exec.destroy();
            if (waitFor == 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private static void a(Context context, Intent intent) {
        try {
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "startPingByAlarmManager");
            int alarmManagerKeepAliveInterval = MqttConfig.getAlarmManagerKeepAliveInterval(context);
            f49967c = Integer.valueOf(alarmManagerKeepAliveInterval);
            int i11 = 134217728;
            if (Build.VERSION.SDK_INT >= 31) {
                i11 = 167772160;
            }
            PushAutoTrackHelper.hookIntentGetBroadcast(context, 0, intent, i11);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i11);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, 0, intent, i11);
            TPushAlarmManager.getAlarmManager(context).set(0, ((long) (alarmManagerKeepAliveInterval * 1000)) + System.currentTimeMillis(), broadcast, XGApiConfig.isPowerSaveMode(context));
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "Alarm started with interval: " + alarmManagerKeepAliveInterval);
        } catch (Throwable th2) {
            a.d("com.tencent.tpns.mqttchannel.core.common.util", "startPingByAlarmManager error: " + th2.toString());
        }
    }
}
