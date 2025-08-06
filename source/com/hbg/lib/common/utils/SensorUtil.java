package com.hbg.lib.common.utils;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import i6.d;
import java.util.HashMap;
import org.json.JSONObject;

public class SensorUtil {
    public static void a(String str, HashMap hashMap) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("]");
        if (hashMap == null) {
            str2 = "";
        } else {
            str2 = hashMap.toString();
        }
        sb2.append(str2);
        d.j("SensorUtil", sb2.toString());
        if (hashMap == null) {
            try {
                SensorsDataAPI.sharedInstance().track(str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            try {
                SensorsDataAPI.sharedInstance().track(str, new JSONObject(hashMap));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }
}
