package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import com.mob.tools.utils.DH;

public class h {
    public static String a() {
        try {
            String oSLanguage = DH.SyncMtd.getOSLanguage();
            if (!TextUtils.isEmpty(oSLanguage)) {
                return oSLanguage;
            }
            SSDKLog.b().a("osl null", new Object[0]);
            return "";
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return "";
        }
    }

    public static String b() {
        try {
            String oSCountry = DH.SyncMtd.getOSCountry();
            if (!TextUtils.isEmpty(oSCountry)) {
                return oSCountry;
            }
            SSDKLog.b().a("osc null", new Object[0]);
            return "";
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return "";
        }
    }
}
