package org.joda.time.chrono;

import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.text.DateFormatSymbols;
import java.util.Comparator;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.a;

public class k {

    /* renamed from: p  reason: collision with root package name */
    public static ConcurrentMap<Locale, k> f23093p = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String[] f23094a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f23095b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f23096c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f23097d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f23098e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f23099f;

    /* renamed from: g  reason: collision with root package name */
    public final TreeMap<String, Integer> f23100g;

    /* renamed from: h  reason: collision with root package name */
    public final TreeMap<String, Integer> f23101h;

    /* renamed from: i  reason: collision with root package name */
    public final TreeMap<String, Integer> f23102i;

    /* renamed from: j  reason: collision with root package name */
    public final int f23103j;

    /* renamed from: k  reason: collision with root package name */
    public final int f23104k;

    /* renamed from: l  reason: collision with root package name */
    public final int f23105l;

    /* renamed from: m  reason: collision with root package name */
    public final int f23106m;

    /* renamed from: n  reason: collision with root package name */
    public final int f23107n;

    /* renamed from: o  reason: collision with root package name */
    public final int f23108o;

    public k(Locale locale) {
        DateFormatSymbols d11 = a.d(locale);
        this.f23094a = d11.getEras();
        this.f23095b = u(d11.getWeekdays());
        this.f23096c = u(d11.getShortWeekdays());
        this.f23097d = v(d11.getMonths());
        this.f23098e = v(d11.getShortMonths());
        this.f23099f = d11.getAmPmStrings();
        Integer[] numArr = new Integer[13];
        for (int i11 = 0; i11 < 13; i11++) {
            numArr[i11] = Integer.valueOf(i11);
        }
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        TreeMap<String, Integer> treeMap = new TreeMap<>(comparator);
        this.f23100g = treeMap;
        b(treeMap, this.f23094a, numArr);
        if (TUIThemeManager.LANGUAGE_EN.equals(locale.getLanguage())) {
            treeMap.put("BCE", numArr[0]);
            treeMap.put("CE", numArr[1]);
        }
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(comparator);
        this.f23101h = treeMap2;
        b(treeMap2, this.f23095b, numArr);
        b(treeMap2, this.f23096c, numArr);
        a(treeMap2, 1, 7, numArr);
        TreeMap<String, Integer> treeMap3 = new TreeMap<>(comparator);
        this.f23102i = treeMap3;
        b(treeMap3, this.f23097d, numArr);
        b(treeMap3, this.f23098e, numArr);
        a(treeMap3, 1, 12, numArr);
        this.f23103j = q(this.f23094a);
        this.f23104k = q(this.f23095b);
        this.f23105l = q(this.f23096c);
        this.f23106m = q(this.f23097d);
        this.f23107n = q(this.f23098e);
        this.f23108o = q(this.f23099f);
    }

    public static void a(TreeMap<String, Integer> treeMap, int i11, int i12, Integer[] numArr) {
        while (i11 <= i12) {
            treeMap.put(String.valueOf(i11).intern(), numArr[i11]);
            i11++;
        }
    }

    public static void b(TreeMap<String, Integer> treeMap, String[] strArr, Integer[] numArr) {
        int length = strArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                String str = strArr[length];
                if (str != null) {
                    treeMap.put(str, numArr[length]);
                }
            } else {
                return;
            }
        }
    }

    public static k h(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        k kVar = (k) f23093p.get(locale);
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(locale);
        k putIfAbsent = f23093p.putIfAbsent(locale, kVar2);
        return putIfAbsent != null ? putIfAbsent : kVar2;
    }

    public static int q(String[] strArr) {
        int length;
        int length2 = strArr.length;
        int i11 = 0;
        while (true) {
            length2--;
            if (length2 < 0) {
                return i11;
            }
            String str = strArr[length2];
            if (str != null && (length = str.length()) > i11) {
                i11 = length;
            }
        }
    }

    public static String[] u(String[] strArr) {
        String[] strArr2 = new String[8];
        int i11 = 1;
        while (i11 < 8) {
            strArr2[i11] = strArr[i11 < 7 ? i11 + 1 : 1];
            i11++;
        }
        return strArr2;
    }

    public static String[] v(String[] strArr) {
        String[] strArr2 = new String[13];
        for (int i11 = 1; i11 < 13; i11++) {
            strArr2[i11] = strArr[i11 - 1];
        }
        return strArr2;
    }

    public int c(String str) {
        Integer num = this.f23101h.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.dayOfWeek(), str);
    }

    public String d(int i11) {
        return this.f23096c[i11];
    }

    public String e(int i11) {
        return this.f23095b[i11];
    }

    public int f(String str) {
        Integer num = this.f23100g.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.era(), str);
    }

    public String g(int i11) {
        return this.f23094a[i11];
    }

    public int i() {
        return this.f23105l;
    }

    public int j() {
        return this.f23104k;
    }

    public int k() {
        return this.f23103j;
    }

    public int l() {
        return this.f23108o;
    }

    public int m() {
        return this.f23107n;
    }

    public int n() {
        return this.f23106m;
    }

    public int o(String str) {
        String[] strArr = this.f23099f;
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                throw new IllegalFieldValueException(DateTimeFieldType.halfdayOfDay(), str);
            }
        } while (!strArr[length].equalsIgnoreCase(str));
        return length;
    }

    public String p(int i11) {
        return this.f23099f[i11];
    }

    public int r(String str) {
        Integer num = this.f23102i.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.monthOfYear(), str);
    }

    public String s(int i11) {
        return this.f23098e[i11];
    }

    public String t(int i11) {
        return this.f23097d[i11];
    }
}
