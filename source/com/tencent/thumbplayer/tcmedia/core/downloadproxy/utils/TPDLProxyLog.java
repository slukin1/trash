package com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils;

import android.util.Log;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;

public class TPDLProxyLog {
    private static ITPDLProxyLogListener mLogListener;
    private static int mServiceType;

    public static void d(String str, int i11, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.d(str, i11, str2, str3);
            return;
        }
        Log.d("[" + str2 + "][" + str + ":" + i11 + "]", str3);
    }

    public static void e(String str, int i11, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.e(str, i11, str2, str3);
            return;
        }
        Log.e("[" + str2 + "][" + str + ":" + i11 + "]", str3);
    }

    public static void i(String str, int i11, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.i(str, i11, str2, str3);
            return;
        }
        Log.i("[" + str2 + "][" + str + ":" + i11 + "]", str3);
    }

    public static void setLogListener(int i11, ITPDLProxyLogListener iTPDLProxyLogListener) {
        mServiceType = i11;
        mLogListener = iTPDLProxyLogListener;
    }

    public static void w(String str, int i11, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.w(str, i11, str2, str3);
            return;
        }
        Log.w("[" + str2 + "][" + str + ":" + i11 + "]", str3);
    }
}
