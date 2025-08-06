package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.dataacquisition.DeviceInfos;

public class TGlobalHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Context f49824a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f49825b;
    public static String curProcessName;

    private static synchronized String a() {
        synchronized (TGlobalHelper.class) {
            if (f49825b != null) {
                String str = f49825b;
                return str;
            }
            f49825b = DeviceInfos.getDM();
            String str2 = f49825b;
            return str2;
        }
    }

    public static Context getContext(Context context) {
        if (f49824a == null) {
            f49824a = context;
        }
        return f49824a;
    }

    public static synchronized String getDM(Context context) {
        synchronized (TGlobalHelper.class) {
            if (f49825b != null) {
                String str = f49825b;
                return str;
            }
            if (context == null) {
                context = f49824a;
            }
            try {
                if (!Util.isMainProcess(context)) {
                    f49825b = (String) PushPreferences.getObject(context, "dm", "");
                } else {
                    f49825b = DeviceInfos.getDM();
                }
            } catch (Throwable th2) {
                TBaseLogger.d("TGlobalHelper", "get dm failed,error:" + th2);
            }
            if (f49825b == null) {
                f49825b = "";
            }
            String str2 = f49825b;
            return str2;
        }
    }

    public static Object loadWithIPC(String str) {
        if (Util.isNullOrEmptyString(str)) {
            return null;
        }
        if ("dm".equals(str)) {
            return a();
        }
        TBaseLogger.d("TGlobalHelper", "don't support type");
        return null;
    }

    public static void setContext(Context context) {
        f49824a = context;
    }
}
