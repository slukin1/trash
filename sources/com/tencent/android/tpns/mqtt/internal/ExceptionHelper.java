package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttSecurityException;

public class ExceptionHelper {
    private ExceptionHelper() {
    }

    public static MqttException createMqttException(int i11) {
        if (i11 == 4 || i11 == 5) {
            return new MqttSecurityException(i11);
        }
        return new MqttException(i11);
    }

    public static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static MqttException createMqttException(Throwable th2) {
        if (th2.getClass().getName().equals("java.security.GeneralSecurityException")) {
            return new MqttSecurityException(th2);
        }
        return new MqttException(th2);
    }
}
