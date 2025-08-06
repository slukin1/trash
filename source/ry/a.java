package ry;

import android.content.Context;
import android.os.Build;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final c f40581a;

    public static class b extends c {
        public int a(Context context, String str, String str2) {
            return b.a(context, str, str2);
        }

        public String b(String str) {
            return b.b(str);
        }

        public b() {
            super();
        }
    }

    public static class c {
        public int a(Context context, String str, String str2) {
            return 1;
        }

        public String b(String str) {
            return null;
        }

        public c() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f40581a = new b();
        } else {
            f40581a = new c();
        }
    }

    public static int a(Context context, String str, String str2) {
        return f40581a.a(context, str, str2);
    }

    public static String b(String str) {
        return f40581a.b(str);
    }
}
