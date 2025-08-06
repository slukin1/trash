package com.hbg.module.libkt.helper;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import i6.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class SensorsDataHelper {
    public static final SensorsDataHelper INSTANCE = new SensorsDataHelper();

    private SensorsDataHelper() {
    }

    public static final void track(String str, HashMap<?, ?> hashMap) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        if (hashMap == null || (str2 = hashMap.toString()) == null) {
            str2 = "";
        }
        sb2.append(str2);
        d.j("SensorsDataHelper", sb2.toString());
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

    public static /* synthetic */ void track$default(String str, HashMap hashMap, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            hashMap = null;
        }
        track(str, hashMap);
    }
}
