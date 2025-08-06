package wz;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Html5Entities;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f60205a;

    static {
        Map<String, String> map;
        try {
            Field declaredField = Html5Entities.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            map = (Map) declaredField.get((Object) null);
        } catch (Throwable th2) {
            Map<String, String> emptyMap = Collections.emptyMap();
            th2.printStackTrace();
            map = emptyMap;
        }
        f60205a = map;
    }

    public static int a(String str, int[] iArr) {
        String str2 = f60205a.get(str);
        if (str2 == null) {
            return 0;
        }
        int length = str2.length();
        if (length == 1) {
            iArr[0] = str2.charAt(0);
        } else {
            iArr[0] = str2.charAt(0);
            iArr[1] = str2.charAt(1);
        }
        return length;
    }

    public static boolean b(String str) {
        return f60205a.containsKey(str);
    }
}
