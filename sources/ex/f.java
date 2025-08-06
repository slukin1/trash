package ex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.Map;

public final class f {
    public static String a(Context context, String str) {
        Map<String, String> f11 = f(context);
        if (f11 == null) {
            return null;
        }
        return f11.get(str);
    }

    public static String b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(Context context) {
        return d(context, (String) null);
    }

    public static String d(Context context, String str) {
        b e11 = e(context);
        if (e11 == null) {
            return str;
        }
        return e11.a();
    }

    public static b e(Context context) {
        String b11 = b(context);
        if (TextUtils.isEmpty(b11)) {
            return null;
        }
        return c.a(new File(b11));
    }

    public static Map<String, String> f(Context context) {
        String b11 = b(context);
        if (TextUtils.isEmpty(b11)) {
            return null;
        }
        return c.b(new File(b11));
    }
}
