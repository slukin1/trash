package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import java.util.Random;
import org.json.JSONObject;

public class e {
    public static String a(Context context) {
        String a11 = d.a(context, "xg.mta.ui", "");
        if (TextUtils.isEmpty(a11)) {
            a11 = CustomDeviceInfos.getFacilityIdentity(context);
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
        }
        d.b(context, "xg.mta.ui", a11);
        return a11;
    }

    public static Context b(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th2) {
                TLogger.e("XgStat", "jsonPut error", th2);
            }
        }
    }
}
