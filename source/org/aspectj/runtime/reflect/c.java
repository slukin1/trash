package org.aspectj.runtime.reflect;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.d;
import w10.a;
import w10.b;

public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f58999e = new Class[0];

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f59000f = new String[0];

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable f59001g;

    /* renamed from: h  reason: collision with root package name */
    public static Object[] f59002h = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    public Class f59003a;

    /* renamed from: b  reason: collision with root package name */
    public ClassLoader f59004b;

    /* renamed from: c  reason: collision with root package name */
    public String f59005c;

    /* renamed from: d  reason: collision with root package name */
    public int f59006d = 0;

    static {
        Hashtable hashtable = new Hashtable();
        f59001g = hashtable;
        hashtable.put("void", Void.TYPE);
        f59001g.put("boolean", Boolean.TYPE);
        f59001g.put("byte", Byte.TYPE);
        f59001g.put("char", Character.TYPE);
        f59001g.put("short", Short.TYPE);
        f59001g.put("int", Integer.TYPE);
        f59001g.put("long", Long.TYPE);
        f59001g.put("float", Float.TYPE);
        f59001g.put("double", Double.TYPE);
    }

    public c(String str, Class cls) {
        this.f59005c = str;
        this.f59003a = cls;
        this.f59004b = cls.getClassLoader();
    }

    public static Class a(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class cls = (Class) f59001g.get(str);
        if (cls != null) {
            return cls;
        }
        if (classLoader != null) {
            return Class.forName(str, false, classLoader);
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return ClassNotFoundException.class;
        }
    }

    public static JoinPoint c(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3) {
        return new d(staticPart, obj, obj2, new Object[]{obj3});
    }

    public static JoinPoint d(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3, Object obj4) {
        return new d(staticPart, obj, obj2, new Object[]{obj3, obj4});
    }

    public static JoinPoint e(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        return new d(staticPart, obj, obj2, objArr);
    }

    public a b(String str, String str2, String str3, String str4, String str5) {
        int parseInt = Integer.parseInt(str, 16);
        Class a11 = a(str2, this.f59004b);
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i11 = 0; i11 < countTokens; i11++) {
            clsArr[i11] = a(stringTokenizer.nextToken(), this.f59004b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i12 = 0; i12 < countTokens2; i12++) {
            strArr[i12] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i13 = 0; i13 < countTokens3; i13++) {
            clsArr2[i13] = a(stringTokenizer3.nextToken(), this.f59004b);
        }
        b bVar = new b(parseInt, a11, clsArr, strArr, clsArr2);
        bVar.k(this.f59004b);
        return bVar;
    }

    public b f(String str, String str2, Class cls, String str3, String str4, String str5, String str6) {
        String str7 = str;
        int parseInt = Integer.parseInt(str, 16);
        String str8 = str3;
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i11 = 0; i11 < countTokens; i11++) {
            clsArr[i11] = a(stringTokenizer.nextToken(), this.f59004b);
        }
        String str9 = str4;
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i12 = 0; i12 < countTokens2; i12++) {
            strArr[i12] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i13 = 0; i13 < countTokens3; i13++) {
            clsArr2[i13] = a(stringTokenizer3.nextToken(), this.f59004b);
        }
        return new f(parseInt, str2, cls, clsArr, strArr, clsArr2, a(str6, this.f59004b));
    }

    public b g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str3;
        return f(str, str2, a(str3, this.f59004b), str4, str5, str6, str7);
    }

    public JoinPoint.StaticPart h(String str, v10.a aVar, int i11) {
        int i12 = this.f59006d;
        this.f59006d = i12 + 1;
        return new d.a(i12, str, aVar, i(i11, -1));
    }

    public w10.c i(int i11, int i12) {
        return new g(this.f59003a, this.f59005c, i11);
    }
}
