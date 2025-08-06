package org.apache.commons.cli;

public class PatternOptionBuilder {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f58892a;

    /* renamed from: b  reason: collision with root package name */
    public static final Class f58893b;

    /* renamed from: c  reason: collision with root package name */
    public static final Class f58894c;

    /* renamed from: d  reason: collision with root package name */
    public static final Class f58895d;

    /* renamed from: e  reason: collision with root package name */
    public static final Class f58896e;

    /* renamed from: f  reason: collision with root package name */
    public static final Class f58897f;

    /* renamed from: g  reason: collision with root package name */
    public static final Class f58898g;

    /* renamed from: h  reason: collision with root package name */
    public static final Class f58899h;

    /* renamed from: i  reason: collision with root package name */
    public static final Class f58900i;

    /* renamed from: j  reason: collision with root package name */
    public static /* synthetic */ Class f58901j;

    /* renamed from: k  reason: collision with root package name */
    public static /* synthetic */ Class f58902k;

    /* renamed from: l  reason: collision with root package name */
    public static /* synthetic */ Class f58903l;

    /* renamed from: m  reason: collision with root package name */
    public static /* synthetic */ Class f58904m;

    /* renamed from: n  reason: collision with root package name */
    public static /* synthetic */ Class f58905n;

    /* renamed from: o  reason: collision with root package name */
    public static /* synthetic */ Class f58906o;

    /* renamed from: p  reason: collision with root package name */
    public static /* synthetic */ Class f58907p;

    /* renamed from: q  reason: collision with root package name */
    public static /* synthetic */ Class f58908q;

    /* renamed from: r  reason: collision with root package name */
    public static /* synthetic */ Class f58909r;

    static {
        Class cls = f58901j;
        if (cls == null) {
            cls = a("java.lang.String");
            f58901j = cls;
        }
        f58892a = cls;
        Class cls2 = f58902k;
        if (cls2 == null) {
            cls2 = a("java.lang.Object");
            f58902k = cls2;
        }
        f58893b = cls2;
        Class cls3 = f58903l;
        if (cls3 == null) {
            cls3 = a("java.lang.Number");
            f58903l = cls3;
        }
        f58894c = cls3;
        Class cls4 = f58904m;
        if (cls4 == null) {
            cls4 = a("java.util.Date");
            f58904m = cls4;
        }
        f58895d = cls4;
        Class cls5 = f58905n;
        if (cls5 == null) {
            cls5 = a("java.lang.Class");
            f58905n = cls5;
        }
        f58896e = cls5;
        Class cls6 = f58906o;
        if (cls6 == null) {
            cls6 = a("java.io.FileInputStream");
            f58906o = cls6;
        }
        f58897f = cls6;
        Class cls7 = f58907p;
        if (cls7 == null) {
            cls7 = a("java.io.File");
            f58907p = cls7;
        }
        f58898g = cls7;
        Class cls8 = f58908q;
        if (cls8 == null) {
            cls8 = a("[Ljava.io.File;");
            f58908q = cls8;
        }
        f58899h = cls8;
        Class cls9 = f58909r;
        if (cls9 == null) {
            cls9 = a("java.net.URL");
            f58909r = cls9;
        }
        f58900i = cls9;
    }

    public static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError().initCause(e11);
        }
    }
}
