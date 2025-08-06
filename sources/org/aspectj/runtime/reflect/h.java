package org.aspectj.runtime.reflect;

import java.lang.reflect.Modifier;
import okhttp3.HttpUrl;

public class h {

    /* renamed from: j  reason: collision with root package name */
    public static h f59021j;

    /* renamed from: k  reason: collision with root package name */
    public static h f59022k;

    /* renamed from: l  reason: collision with root package name */
    public static h f59023l;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59024a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59025b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59026c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59027d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59028e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59029f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59030g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59031h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f59032i;

    static {
        h hVar = new h();
        f59021j = hVar;
        hVar.f59024a = true;
        hVar.f59025b = false;
        hVar.f59026c = false;
        hVar.f59027d = false;
        hVar.f59028e = true;
        hVar.f59029f = false;
        hVar.f59030g = false;
        hVar.f59032i = 0;
        h hVar2 = new h();
        f59022k = hVar2;
        hVar2.f59024a = true;
        hVar2.f59025b = true;
        hVar2.f59026c = false;
        hVar2.f59027d = false;
        hVar2.f59028e = false;
        f59021j.f59032i = 1;
        h hVar3 = new h();
        f59023l = hVar3;
        hVar3.f59024a = false;
        hVar3.f59025b = true;
        hVar3.f59026c = false;
        hVar3.f59027d = true;
        hVar3.f59028e = false;
        hVar3.f59031h = false;
        hVar3.f59032i = 2;
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (this.f59025b) {
                stringBuffer.append("(");
                c(stringBuffer, clsArr);
                stringBuffer.append(")");
            } else if (clsArr.length == 0) {
                stringBuffer.append("()");
            } else {
                stringBuffer.append("(..)");
            }
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (this.f59026c && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            c(stringBuffer, clsArr);
        }
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(g(clsArr[i11]));
        }
    }

    public String d(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    public String e(int i11) {
        if (!this.f59027d) {
            return "";
        }
        String modifier = Modifier.toString(i11);
        if (modifier.length() == 0) {
            return "";
        }
        return modifier + " ";
    }

    public String f(Class cls, String str) {
        return h(cls, str, this.f59028e);
    }

    public String g(Class cls) {
        return h(cls, cls.getName(), this.f59024a);
    }

    public String h(Class cls, String str, boolean z11) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            return h(componentType, componentType.getName(), z11) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else if (z11) {
            return i(str).replace(DecodedChar.FNC1, '.');
        } else {
            return str.replace(DecodedChar.FNC1, '.');
        }
    }

    public String i(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }
}
