package com.tencent.android.tpns.mqtt.logging;

public class LoggerFactory {
    private static final String CLASS_NAME = "LoggerFactory";
    public static final String MQTT_CLIENT_MSG_CAT = "com.tencent.android.tpns.mqtt.internal.nls.logcat";
    private static String jsr47LoggerClassName = JSR47Logger.class.getName();
    private static String overrideloggerClassName;

    public static Logger getLogger(String str, String str2) {
        return new MLogger();
    }

    public static String getLoggingProperty(String str) {
        return null;
    }

    public static void setLogger(String str) {
        overrideloggerClassName = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        return null;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[ExcHandler: ClassNotFoundException | NoClassDefFoundError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.android.tpns.mqtt.logging.Logger getLogger(java.lang.String r1, java.util.ResourceBundle r2, java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{  }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ ClassNotFoundException | NoClassDefFoundError -> 0x000f, ClassNotFoundException | NoClassDefFoundError -> 0x000f, ClassNotFoundException | NoClassDefFoundError -> 0x000f }
            com.tencent.android.tpns.mqtt.logging.Logger r1 = (com.tencent.android.tpns.mqtt.logging.Logger) r1     // Catch:{ ClassNotFoundException | NoClassDefFoundError -> 0x000f, ClassNotFoundException | NoClassDefFoundError -> 0x000f, ClassNotFoundException | NoClassDefFoundError -> 0x000f }
            r1.initialise(r2, r3, r4)
            return r1
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.logging.LoggerFactory.getLogger(java.lang.String, java.util.ResourceBundle, java.lang.String, java.lang.String):com.tencent.android.tpns.mqtt.logging.Logger");
    }
}
