package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;

public class MqttConfig {
    public static void enableAlarmManager(Context context, boolean z11) {
        MqttConfigImpl.enableAlarmManager(context, z11);
    }

    public static long getAccessId(Context context) {
        return MqttConfigImpl.getAccessId(context);
    }

    public static String getAccessKey(Context context) {
        return MqttConfigImpl.getAccessKey(context);
    }

    public static int getAlarmManagerKeepAliveInterval(Context context) {
        return MqttConfigImpl.getAlarmManagerKeepAliveInterval(context);
    }

    public static int getKeepAliveInterval(Context context) {
        return MqttConfigImpl.getKeepAliveInterval(context);
    }

    public static boolean isEnabledAlarmManager(Context context) {
        return MqttConfigImpl.isEnabledAlarmManager(context);
    }

    public static void setAccessId(Context context, long j11) {
        MqttConfigImpl.setAccessId(context, j11);
    }

    public static void setAccessKey(Context context, String str) {
        MqttConfigImpl.setAccessKey(context, str);
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z11) {
        MqttConfigImpl.setForeignWeakAlarmMode(context, z11);
    }

    public static void setKeepAliveInterval(Context context, int i11) {
        MqttConfigImpl.setKeepAliveInterval(context, i11);
    }

    public static void setServerAddr(Context context, String str) {
        MqttConfigImpl.setServerAddr(context, str);
    }
}
