package com.tencent.thumbplayer.tcmedia.tplayer.a.b;

import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class a implements Serializable {
    @C0626a(a = "usedatatransport")
    private int A = -1;
    @C0626a(a = "datatransportprotocolver")
    private String B = "";
    @C0626a(a = "cdnuip")
    private String C = "";
    @C0626a(a = "cdnip")
    private String D = "";
    @C0626a(a = "platform")
    private int E = -1;
    @C0626a(a = "playerconfig")
    private String F = "";
    @C0626a(a = "drmability")
    private int G = -1;
    private Map<String, String> H = null;
    private Map<String, String> I = null;
    private Map<String, String> J = null;
    private Map<String, String> K = null;
    @C0626a(a = "flowid")

    /* renamed from: a  reason: collision with root package name */
    private String f49358a = "";
    @C0626a(a = "guid")

    /* renamed from: b  reason: collision with root package name */
    private String f49359b = "";
    @C0626a(a = "seq")

    /* renamed from: c  reason: collision with root package name */
    private int f49360c = -1;
    @C0626a(a = "platformtype")

    /* renamed from: d  reason: collision with root package name */
    private int f49361d = -1;
    @C0626a(a = "devtype")

    /* renamed from: e  reason: collision with root package name */
    private int f49362e = -1;
    @C0626a(a = "networktype")

    /* renamed from: f  reason: collision with root package name */
    private int f49363f = -1;
    @C0626a(a = "devicename")

    /* renamed from: g  reason: collision with root package name */
    private String f49364g = "";
    @C0626a(a = "osver")

    /* renamed from: h  reason: collision with root package name */
    private String f49365h = "";
    @C0626a(a = "appname")

    /* renamed from: i  reason: collision with root package name */
    private String f49366i = "";
    @C0626a(a = "appver")

    /* renamed from: j  reason: collision with root package name */
    private String f49367j = "";
    @C0626a(a = "playerver")

    /* renamed from: k  reason: collision with root package name */
    private String f49368k = "";
    @C0626a(a = "reportprotocolver")

    /* renamed from: l  reason: collision with root package name */
    private String f49369l = "";
    @C0626a(a = "durationms")

    /* renamed from: m  reason: collision with root package name */
    private long f49370m = -1;
    @C0626a(a = "hlssourcetype")

    /* renamed from: n  reason: collision with root package name */
    private int f49371n = -1;
    @C0626a(a = "playertype")

    /* renamed from: o  reason: collision with root package name */
    private int f49372o = -1;
    @C0626a(a = "urlprotocol")

    /* renamed from: p  reason: collision with root package name */
    private int f49373p = -1;
    @C0626a(a = "containerformat")

    /* renamed from: q  reason: collision with root package name */
    private String f49374q = "";
    @C0626a(a = "videoencodefmt")

    /* renamed from: r  reason: collision with root package name */
    private int f49375r = -1;
    @C0626a(a = "audioencodefmt")

    /* renamed from: s  reason: collision with root package name */
    private int f49376s = -1;
    @C0626a(a = "subtitleencodefmt")

    /* renamed from: t  reason: collision with root package name */
    private int f49377t = -1;
    @C0626a(a = "streambitratekbps")

    /* renamed from: u  reason: collision with root package name */
    private long f49378u = -1;
    @C0626a(a = "videoframerate")

    /* renamed from: v  reason: collision with root package name */
    private float f49379v = -1.0f;
    @C0626a(a = "url")

    /* renamed from: w  reason: collision with root package name */
    private String f49380w = "";
    @C0626a(a = "resolution")

    /* renamed from: x  reason: collision with root package name */
    private String f49381x = "";
    @C0626a(a = "datatransportver")

    /* renamed from: y  reason: collision with root package name */
    private String f49382y = "";
    @C0626a(a = "speedkbps")

    /* renamed from: z  reason: collision with root package name */
    private int f49383z = -1;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.tencent.thumbplayer.tcmedia.tplayer.a.b.a$a  reason: collision with other inner class name */
    public @interface C0626a {
        String a() default "";
    }

    private String a(Field field) {
        try {
            field.setAccessible(true);
            if (field.getType() == Integer.TYPE) {
                return String.valueOf(field.getInt(this));
            }
            if (field.getType() == Long.TYPE) {
                return String.valueOf(field.getLong(this));
            }
            if (field.getType() == Float.TYPE) {
                return String.valueOf(field.getFloat(this));
            }
            if (field.getType() == Boolean.TYPE) {
                return String.valueOf(field.getBoolean(this));
            }
            if (field.getType() == String.class) {
                return (String) field.get(this);
            }
            String name = getClass().getName();
            TPLogUtil.e(name, "getFieldValue field:" + field.getName() + " is not match.");
            return "-1";
        } catch (Exception e11) {
            TPLogUtil.e(getClass().getName(), (Throwable) e11);
        }
    }

    private Map<String, String> a(Field[] fieldArr) {
        HashMap hashMap = new HashMap();
        for (Field field : fieldArr) {
            C0626a aVar = (C0626a) field.getAnnotation(C0626a.class);
            if (aVar != null) {
                hashMap.put(aVar.a(), a(field));
            }
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        for (Map.Entry next : map2.entrySet()) {
            if (map.containsKey(next.getKey())) {
                map.put(next.getKey(), next.getValue());
            }
        }
    }

    private void c() {
        Map<String, String> map;
        Map<String, String> map2 = this.H;
        if (map2 != null && (map = this.J) != null) {
            a(map2, map);
        }
    }

    private void d() {
        Map<String, String> map;
        Map<String, String> map2 = this.I;
        if (map2 != null && (map = this.K) != null) {
            a(map2, map);
        }
    }

    public String a() {
        return this.f49358a;
    }

    public void a(float f11) {
        this.f49379v = f11;
    }

    public void a(int i11) {
        this.f49360c = i11;
    }

    public void a(long j11) {
        this.f49370m = j11;
    }

    public void a(a aVar) {
        this.f49358a = aVar.f49358a;
        this.f49359b = aVar.f49359b;
        this.f49360c = aVar.f49360c;
        this.f49361d = aVar.f49361d;
        this.f49362e = aVar.f49362e;
        this.f49363f = aVar.f49363f;
        this.f49364g = aVar.f49364g;
        this.f49365h = aVar.f49365h;
        this.f49366i = aVar.f49366i;
        this.f49368k = aVar.f49368k;
        this.f49367j = aVar.f49367j;
        this.f49369l = aVar.f49369l;
        this.f49370m = aVar.f49370m;
        this.f49371n = aVar.f49371n;
        this.f49372o = aVar.f49372o;
        this.f49373p = aVar.f49373p;
        this.f49374q = aVar.f49374q;
        this.f49375r = aVar.f49375r;
        this.f49376s = aVar.f49376s;
        this.f49377t = aVar.f49377t;
        this.f49378u = aVar.f49378u;
        this.f49379v = aVar.f49379v;
        this.f49380w = aVar.f49380w;
        this.f49381x = aVar.f49381x;
        this.f49382y = aVar.f49382y;
        this.f49383z = aVar.f49383z;
        this.A = aVar.A;
        this.C = aVar.C;
        this.D = aVar.D;
        this.B = aVar.B;
        this.E = aVar.E;
        this.F = aVar.F;
        this.H = aVar.H;
        this.I = aVar.I;
        this.J = aVar.J;
        this.K = aVar.K;
        this.G = aVar.G;
    }

    public void a(String str) {
        this.f49358a = str;
    }

    public void a(Map<String, String> map) {
        this.H = map;
    }

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        Class<? super Object> superclass = getClass().getSuperclass();
        if (superclass != null) {
            hashMap.putAll(a(superclass.getDeclaredFields()));
        }
        hashMap.putAll(a(getClass().getDeclaredFields()));
        c();
        d();
        Map<String, String> map = this.H;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.J;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        Map<String, String> map3 = this.I;
        if (map3 != null) {
            hashMap.putAll(map3);
        }
        Map<String, String> map4 = this.K;
        if (map4 != null) {
            hashMap.putAll(map4);
        }
        return hashMap;
    }

    public void b(int i11) {
        this.f49361d = i11;
    }

    public void b(long j11) {
        this.f49378u = j11;
    }

    public void b(String str) {
        this.f49359b = str;
    }

    public void b(Map<String, String> map) {
        this.I = map;
    }

    public void c(int i11) {
        this.f49362e = i11;
    }

    public void c(String str) {
        this.f49364g = str;
    }

    public void c(Map<String, String> map) {
        this.J = map;
    }

    public void d(int i11) {
        this.f49363f = i11;
    }

    public void d(String str) {
        this.f49365h = str;
    }

    public void d(Map<String, String> map) {
        this.K = map;
    }

    public void e(int i11) {
        this.f49371n = i11;
    }

    public void e(String str) {
        this.f49366i = str;
    }

    public void f(int i11) {
        this.f49372o = i11;
    }

    public void f(String str) {
        this.f49368k = str;
    }

    public void g(int i11) {
        this.f49373p = i11;
    }

    public void g(String str) {
        this.f49367j = str;
    }

    public void h(int i11) {
        this.f49375r = i11;
    }

    public void h(String str) {
        this.f49369l = str;
    }

    public void i(int i11) {
        this.f49376s = i11;
    }

    public void i(String str) {
        this.f49374q = str;
    }

    public void j(int i11) {
        this.f49377t = i11;
    }

    public void j(String str) {
        this.f49380w = str;
    }

    public void k(int i11) {
        this.f49383z = i11;
    }

    public void k(String str) {
        this.f49381x = str;
    }

    public void l(int i11) {
        this.A = i11;
    }

    public void l(String str) {
        this.f49382y = str;
    }

    public void m(int i11) {
        this.E = i11;
    }

    public void m(String str) {
        this.C = str;
    }

    public void n(int i11) {
        this.G = i11;
    }

    public void n(String str) {
        this.D = str;
    }

    public void o(String str) {
        this.B = str;
    }

    public void p(String str) {
        this.F = str;
    }
}
