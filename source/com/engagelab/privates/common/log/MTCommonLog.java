package com.engagelab.privates.common.log;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.iproov.sdk.bridge.OptionsBridge;
import org.json.JSONObject;

public class MTCommonLog {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void d(String str, String str2) {
        if (MTGlobal.getDebugMode()) {
            String tag = getTag();
            Log.d(tag, "[" + str + "] " + str2);
        }
    }

    public static void e(String str, String str2) {
        String tag = getTag();
        Log.e(tag, "[" + str + "] " + str2);
    }

    private static String getTag() {
        try {
            String name = Thread.currentThread().getName();
            if (TextUtils.isEmpty(name)) {
                return "ENGAGELAB-PRIVATES-SDK";
            }
            if (TextUtils.equals(name, Looper.getMainLooper().getThread().getName())) {
                return "ENGAGELAB-PRIVATES-MAIN";
            }
            if (name.startsWith(MTCommonConstants.AURORA)) {
                return name;
            }
            return MTCommonConstants.AURORA + name;
        } catch (Throwable unused) {
            return "ENGAGELAB-PRIVATES-SDK";
        }
    }

    public static void i(String str, String str2) {
        String tag = getTag();
        Log.i(tag, "[" + str + "] " + str2);
    }

    public static String toLogString(Bundle bundle) {
        if (bundle == null) {
            return OptionsBridge.NULL_VALUE;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{ ");
            for (String str : bundle.keySet()) {
                sb2.append(str);
                sb2.append(":");
                sb2.append(bundle.get(str));
                sb2.append(" ");
            }
            sb2.append("}");
            return sb2.toString();
        } catch (Throwable unused) {
            return bundle.toString();
        }
    }

    public static void w(String str, String str2) {
        if (MTGlobal.getDebugMode()) {
            String tag = getTag();
            Log.w(tag, "[" + str + "] " + str2);
        }
    }

    public static String toLogString(JSONObject jSONObject) {
        if (jSONObject == null) {
            return OptionsBridge.NULL_VALUE;
        }
        try {
            String jSONObject2 = jSONObject.toString(2);
            return LINE_SEPARATOR + jSONObject2;
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }
}
