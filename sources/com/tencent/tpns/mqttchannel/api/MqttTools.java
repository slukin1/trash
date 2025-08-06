package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.a.b;

public class MqttTools {
    public static String getMqttSdkVersion() {
        return "1.4.4.2";
    }

    public static boolean isAesPushMsgTopic(Context context, String str) {
        return b.l(context, str);
    }

    public static boolean isGZipAesPushMsgTopic(Context context, String str) {
        return b.p(context, str);
    }

    public static boolean isGZipPushMsgTopic(Context context, String str) {
        return b.n(context, str);
    }

    public static boolean isPushMsgTopic(Context context, String str) {
        return b.j(context, str);
    }
}
