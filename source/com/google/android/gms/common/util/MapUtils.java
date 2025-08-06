package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;

@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(StringBuilder sb2, HashMap<String, String> hashMap) {
        sb2.append("{");
        boolean z11 = true;
        for (String next : hashMap.keySet()) {
            if (!z11) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            String str = hashMap.get(next);
            sb2.append("\"");
            sb2.append(next);
            sb2.append("\":");
            if (str == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
            }
            z11 = false;
        }
        sb2.append("}");
    }
}
