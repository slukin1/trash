package com.tencent.thumbplayer.tcmedia.core.player;

import android.view.Surface;
import java.util.Map;

public class TPNativePlayerUtils {
    public static boolean isTPNativePlayerSurface(Surface surface) {
        return surface instanceof TPNativePlayerSurface;
    }

    public static String[] tpMapStringToStringArray(Map<String, String> map) {
        int i11 = 0;
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        String[] strArr = new String[(map.size() * 2)];
        for (String next : map.keySet()) {
            int i12 = i11 * 2;
            strArr[i12] = next;
            strArr[i12 + 1] = map.get(next);
            i11++;
        }
        return strArr;
    }
}
