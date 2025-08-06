package com.kakao.util.helper.log;

import android.util.Log;
import com.kakao.util.helper.log.LoggerConfig;
import java.util.HashSet;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final LoggerConfig f25164a = l();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f25165b = false;

    public static int a(String str) {
        return c(f25164a.e(), str);
    }

    public static int b(String str, Object... objArr) {
        return d(f25164a.e(), str, objArr);
    }

    public static int c(Tag tag, String str) {
        return n(tag, 3, str);
    }

    public static int d(Tag tag, String str, Object... objArr) {
        if (!f25164a.j(3)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return n(tag, 3, str);
    }

    public static int e(String str) {
        return g(f25164a.e(), str);
    }

    public static int f(String str, Throwable th2) {
        return h(f25164a.e(), str, th2);
    }

    public static int g(Tag tag, String str) {
        return n(tag, 6, str);
    }

    public static int h(Tag tag, String str, Throwable th2) {
        return i(tag, "%s\n%s", str, j(th2));
    }

    public static int i(Tag tag, String str, Object... objArr) {
        if (!f25164a.j(6)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return n(tag, 6, str);
    }

    public static String j(Throwable th2) {
        return th2 == null ? "" : Log.getStackTraceString(th2);
    }

    public static int k(String str, Object... objArr) {
        return m(f25164a.e(), str, objArr);
    }

    public static LoggerConfig l() {
        LoggerConfig.Builder d11 = new LoggerConfig.Builder().b(Tag.DEFAULT).e("com.kakao.sdk").d(5);
        HashSet hashSet = new HashSet();
        hashSet.add(a.class.getName());
        d11.c(hashSet);
        return d11.a();
    }

    public static int m(Tag tag, String str, Object... objArr) {
        if (!f25164a.j(4)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return n(tag, 4, str);
    }

    public static int n(Tag tag, int i11, String str) {
        int i12 = 0;
        if (str == null) {
            return 0;
        }
        LoggerConfig loggerConfig = f25164a;
        String f11 = loggerConfig.f(f25165b, str);
        if (!loggerConfig.j(i11)) {
            return 0;
        }
        if (f11 == null) {
            f11 = loggerConfig.f(f25165b, str);
        }
        if (f11 == null) {
            return 0;
        }
        String tag2 = tag.tag();
        int length = f11.length();
        int i13 = 0;
        int i14 = 0;
        while (i12 < length) {
            int i15 = length - i12;
            if (i15 > 2000) {
                i15 = 2000;
            }
            int i16 = i15 + i12;
            i13 += o(i11, tag2, f11.substring(i12, i16), i14);
            i12 = i16;
            i14++;
        }
        return i13;
    }

    public static int o(int i11, String str, String str2, int i12) {
        String str3;
        int length = str2.length();
        if (i12 > 0) {
            str3 = String.format(Locale.getDefault(), "Cont(%d) ", new Object[]{Integer.valueOf(i12)});
        } else {
            str3 = "";
        }
        if (length > 2000) {
            str2 = str2.substring(0, 2000);
        }
        if (i11 == 0) {
            return Log.d(str, str3 + str2);
        } else if (i11 == 2) {
            return Log.v(str, str3 + str2);
        } else if (i11 == 3) {
            return Log.d(str, str3 + str2);
        } else if (i11 == 4) {
            return Log.i(str, str3 + str2);
        } else if (i11 == 5) {
            return Log.w(str, str3 + str2);
        } else if (i11 != 6) {
            return 0;
        } else {
            return Log.e(str, str3 + str2);
        }
    }

    public static int p(String str) {
        return q(f25164a.e(), str);
    }

    public static int q(Tag tag, String str) {
        return n(tag, 5, str);
    }
}
