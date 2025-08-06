package com.mob.tools;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.jumio.sdk.reject.JumioRejectReason;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.commons.l;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;

public class c {
    public static int a(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1001", str)) {
            return -1;
        }
        return applicationInfo.uid;
    }

    public static String b(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1004", str)) {
            return null;
        }
        return applicationInfo.name;
    }

    public static int c(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1005", str)) {
            return -1;
        }
        return applicationInfo.labelRes;
    }

    public static CharSequence d(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1006", str)) {
            return null;
        }
        return applicationInfo.nonLocalizedLabel;
    }

    public static boolean e(ApplicationInfo applicationInfo, String str) {
        return applicationInfo != null && a("1007", str) && applicationInfo.enabled;
    }

    public static String f(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1008", str)) {
            return null;
        }
        return applicationInfo.processName;
    }

    public static CharSequence g(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1101", str)) {
            return null;
        }
        return applicationInfo.loadLabel(MobSDK.getContext().getPackageManager());
    }

    public static ApplicationInfo a(Object obj, String str) {
        if (obj == null || !a(JumioRejectReason.BLURRY, str)) {
            return null;
        }
        return (ApplicationInfo) ReflectHelper.getInstanceField(obj, l.a("015flli6fkFefk5fkfmEgKgg0gMghfm"), null);
    }

    public static Signature[] b(Object obj, String str) {
        if (obj == null || !a("2002", str)) {
            return null;
        }
        return (Signature[]) ReflectHelper.getInstanceField(obj, l.a("010Dhkfkgl5gfk@fifl*hFhk"), null);
    }

    public static String c(Object obj, String str) {
        if (obj == null || !a(JumioRejectReason.HIDDEN_PART_DOC, str)) {
            return "1.0";
        }
        return (String) ReflectHelper.getInstanceField(obj, l.a("011?ff@hRflhkfkfm+gQgi)f3fhUh"), "1.0");
    }

    public static long d(Object obj, String str) {
        if (obj == null || !a(JumioRejectReason.DAMAGED_DOCUMENT, str)) {
            return 0;
        }
        return ((Long) ReflectHelper.getInstanceField(obj, l.a("016?ghfkflhk(k.ggYgChk1kfiiLhefkfhZh"), 0L)).longValue();
    }

    public static long e(Object obj, String str) {
        if (obj == null || !a(JumioRejectReason.GLARE, str)) {
            return 0;
        }
        return ((Long) ReflectHelper.getInstanceField(obj, l.a("014if=hkIk(gmTlJfe[fkhIhefkfhBh"), 0L)).longValue();
    }

    public static int f(Object obj, String str) {
        if (obj == null || !a("2007", str)) {
            return 0;
        }
        return ((Integer) ReflectHelper.getInstanceField(obj, l.a("011Lff,h=flhkfkfmRgWgffmfe4h"), 0)).intValue();
    }

    public static long g(Object obj, String str) {
        if (obj == null || !a("2101", str)) {
            return 0;
        }
        return ((Long) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("018Igl7hkHhgfmJg4glim$hLflhkfkfmUg3gffmfe%h"), 0L, new Object[0])).longValue();
    }

    public static boolean a(String str, String str2) {
        String str3 = (String) b.a("aps", null);
        if (str3 == null) {
            return true;
        }
        String[] split = str3.split(";");
        if (TextUtils.equals(str2, DH.SyncMtd.getPackageName())) {
            if (split.length > 1) {
                return !split[1].contains(str);
            }
            return true;
        } else if (split.length > 0) {
            return !split[0].contains(str);
        } else {
            return true;
        }
    }
}
