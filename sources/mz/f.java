package mz;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Character, String> f58290a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f58291b = System.getProperty("line.separator");

    static {
        HashMap hashMap = new HashMap();
        f58290a = hashMap;
        hashMap.put('\'', "\\'");
        f58290a.put('\"', "\\\"");
        f58290a.put('\\', "\\\\");
        f58290a.put('/', "\\/");
        f58290a.put(8, "\\b");
        f58290a.put(10, "\\n");
        f58290a.put(9, "\\t");
        f58290a.put(12, "\\f");
        f58290a.put(13, "\\r");
    }

    public static String a(String str) {
        if (e(str)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() * 2);
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (f58290a.containsKey(Character.valueOf(charAt))) {
                sb2.append(f58290a.get(Character.valueOf(charAt)));
            } else {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public static List<String> b(String str) {
        if (!c(str)) {
            return a.l(new ArrayList(0));
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (c(str2)) {
                arrayList.add(str2);
            }
        }
        return a.l(arrayList);
    }

    public static boolean c(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean d(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        for (String e11 : strArr) {
            if (e(e11)) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(String str) {
        return !c(str);
    }

    public static boolean f(String str) {
        if (e(str)) {
            return false;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isDigit(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static String g(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (c(list.get(i11))) {
                sb2.append(list.get(i11));
                if (i11 < list.size() - 1) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return sb2.toString();
    }

    public static String h(String... strArr) {
        return g(strArr == null ? null : Arrays.asList(strArr));
    }

    public static String i(List<? extends Number> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            for (Number number : list) {
                if (number != null) {
                    arrayList.add(number.toString());
                }
            }
        } else {
            arrayList = null;
        }
        return g(arrayList);
    }
}
