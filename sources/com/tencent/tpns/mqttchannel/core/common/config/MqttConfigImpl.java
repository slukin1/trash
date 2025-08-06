package com.tencent.tpns.mqttchannel.core.common.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.mqttchannel.core.common.a.a;

public class MqttConfigImpl {
    public static final int DEFAULT_KEEP_ALIVE_INTERVAL = 285;
    public static Integer keepAliveInterval;

    private static boolean a(Context context) {
        Object metaData;
        int i11 = PushPreferences.getInt(context, "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + context.getPackageName(), -1);
        if (i11 == -1 && (metaData = CommonHelper.getMetaData(context, "XG_WEAK_ALARM", (Object) null)) != null) {
            if (metaData.toString().equals("true")) {
                i11 = 1;
            }
            a.e("MqttConfigImpl", "getMetaData key:" + i11);
        }
        if (i11 == 1) {
            return true;
        }
        return false;
    }

    public static void enableAlarmManager(Context context, boolean z11) {
        PushPreferences.putBoolean(context, "MQTT_ENABLE_ALARM_MANAGER", z11);
    }

    public static long getAccessId(Context context) {
        return XGApiConfig.getAccessId(context);
    }

    public static String getAccessKey(Context context) {
        return XGApiConfig.getAccessKey(context);
    }

    public static int getAlarmManagerKeepAliveInterval(Context context) {
        return getKeepAliveInterval(context) + 10;
    }

    public static int getKeepAliveInterval(Context context) {
        try {
            int interval = CloudManager.getInstance(context).getInterval() / 1000;
            if (interval >= 60) {
                keepAliveInterval = Integer.valueOf(interval);
            }
            if (keepAliveInterval == null) {
                if (a(context)) {
                    a.b("MqttConfigImpl", "isForeignWeakAlarmMode KeepAlive set to : 3600");
                    return 3600;
                }
                Integer valueOf = Integer.valueOf(PushPreferences.getInt(context, "MQTT_KEEPALIVE_INTERVAL", 0));
                keepAliveInterval = valueOf;
                if (valueOf.intValue() == 0) {
                    keepAliveInterval = Integer.valueOf(DEFAULT_KEEP_ALIVE_INTERVAL);
                }
            }
            return keepAliveInterval.intValue();
        } catch (Throwable unused) {
            return DEFAULT_KEEP_ALIVE_INTERVAL;
        }
    }

    public static String getServerAddr(Context context) {
        String string = PushPreferences.getString(context, "MQTT_HOST", (String) null);
        return TextUtils.isEmpty(string) ? "tcp://127.0.0.1:1883" : string;
    }

    public static boolean isEnabledAlarmManager(Context context) {
        return PushPreferences.getBoolean(context, "MQTT_ENABLE_ALARM_MANAGER", false);
    }

    public static void setAccessId(Context context, long j11) {
        XGApiConfig.setAccessId(context, j11);
    }

    public static void setAccessKey(Context context, String str) {
        XGApiConfig.setAccessKey(context, str);
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z11) {
        PushPreferences.putInt(context, "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + context.getPackageName(), z11 ? 1 : 0);
    }

    public static boolean setKeepAliveInterval(Context context, int i11) {
        if (i11 < 10 || i11 > 36000) {
            return false;
        }
        keepAliveInterval = Integer.valueOf(i11);
        PushPreferences.putInt(context, "MQTT_KEEPALIVE_INTERVAL", i11);
        return true;
    }

    public static void setServerAddr(Context context, String str) {
        PushPreferences.putString(context, "MQTT_HOST", str);
    }
}
