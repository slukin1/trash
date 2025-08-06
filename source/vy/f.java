package vy;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f40621a = Pattern.compile("([\t\r\n])+");

    public static class a implements Comparator<String> {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i11 = 0;
        for (char c11 : str.toCharArray()) {
            i11 = (i11 * 31) + c11;
        }
        return i11;
    }

    public static Map<String, String> b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new a());
        treeMap.putAll(map);
        return treeMap;
    }

    public static boolean c(String str) {
        return str == null || str.length() <= 0;
    }

    public static String d(String str) {
        return (str == null || "".equals(str)) ? str : f40621a.matcher(str).replaceAll("");
    }
}
