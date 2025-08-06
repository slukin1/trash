package vy;

import com.ta.a.e.h;

public class g {
    public static String a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception e11) {
            h.f("", e11, new Object[0]);
            return str2;
        }
    }
}
