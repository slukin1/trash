package vx;

import java.util.Comparator;
import ox.c;

public final class d {

    public static class a implements Comparator<String> {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
        }
    }

    public static Comparator<String> a() {
        return new a();
    }

    public static String b(String str, c cVar) {
        return str + "_" + cVar.b() + "x" + cVar.a();
    }
}
