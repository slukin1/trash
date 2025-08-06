package com.tencent.liteav.txcplayer.a;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;

public final class b {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i11 = 0; i11 < codecCount; i11++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i11);
                if (!codecInfoAt.isEncoder()) {
                    for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                        if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        } catch (Throwable th2) {
            LiteavLog.e("MediaCodecUtils", "isMimeTypeSupported exception: " + th2.getMessage());
        }
        return false;
    }
}
