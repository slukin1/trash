package o20;

import com.iproov.sdk.bridge.OptionsBridge;

public class c {
    public static void a(long j11, long j12) {
        b((String) null, j11, j12);
    }

    public static void b(String str, long j11, long j12) {
        if (j11 != j12) {
            d(str, Long.valueOf(j11), Long.valueOf(j12));
        }
    }

    public static void c(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    public static void d(String str, Object obj, Object obj2) {
        c(e(str, obj, obj2));
    }

    public static String e(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals(str2)) {
            str2 = str + " ";
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        if (valueOf.equals(valueOf2)) {
            return str2 + "expected: " + f(obj, valueOf) + " but was: " + f(obj2, valueOf2);
        }
        return str2 + "expected:<" + valueOf + "> but was:<" + valueOf2 + ">";
    }

    public static String f(Object obj, String str) {
        String name = obj == null ? OptionsBridge.NULL_VALUE : obj.getClass().getName();
        return name + "<" + str + ">";
    }
}
