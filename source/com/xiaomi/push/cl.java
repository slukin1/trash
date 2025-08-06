package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.q;
import java.util.Arrays;
import java.util.List;

public class cl {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f51502a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final List<String> f2614a = Arrays.asList(new String[]{"001", "002", "003", "004", "005"});

    public static void a(String str, String str2) {
    }

    public static boolean a(Context context) {
        if (f51502a == null) {
            try {
                if (!j.a(context)) {
                    f51502a = Boolean.FALSE;
                }
                String a11 = q.a(context);
                if (TextUtils.isEmpty(a11) || a11.length() < 3) {
                    f51502a = Boolean.FALSE;
                } else {
                    f51502a = Boolean.valueOf(f2614a.contains(a11.substring(a11.length() - 3)));
                }
                a("Sampling statistical connection quality: " + f51502a);
            } catch (Throwable th2) {
                f51502a = Boolean.FALSE;
                b.c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th2);
            }
        }
        return f51502a.booleanValue();
    }

    public static void a(String str) {
        a("Push-ConnectionQualityStatsHelper", str);
    }
}
