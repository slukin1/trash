package kotlinx.serialization.internal;

import h10.a;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.z;
import kotlin.l;
import kotlin.o;
import kotlin.p;
import kotlin.q;
import kotlin.r;
import kotlin.reflect.c;
import kotlin.u;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;

public final class n1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<c<? extends Object>, b<? extends Object>> f57747a = MapsKt__MapsKt.l(l.a(Reflection.b(String.class), a.I(d0.f56774a)), l.a(Reflection.b(Character.TYPE), a.C(n.f56787a)), l.a(Reflection.b(char[].class), a.d()), l.a(Reflection.b(Double.TYPE), a.D(s.f56796a)), l.a(Reflection.b(double[].class), a.e()), l.a(Reflection.b(Float.TYPE), a.E(t.f56797a)), l.a(Reflection.b(float[].class), a.f()), l.a(Reflection.b(Long.TYPE), a.G(z.f56799a)), l.a(Reflection.b(long[].class), a.i()), l.a(Reflection.b(q.class), a.x(q.f56813c)), l.a(Reflection.b(r.class), a.s()), l.a(Reflection.b(Integer.TYPE), a.F(w.f56798a)), l.a(Reflection.b(int[].class), a.g()), l.a(Reflection.b(o.class), a.w(o.f56805c)), l.a(Reflection.b(p.class), a.r()), l.a(Reflection.b(Short.TYPE), a.H(b0.f56768a)), l.a(Reflection.b(short[].class), a.o()), l.a(Reflection.b(kotlin.t.class), a.y(kotlin.t.f56897c)), l.a(Reflection.b(u.class), a.t()), l.a(Reflection.b(Byte.TYPE), a.B(m.f56786a)), l.a(Reflection.b(byte[].class), a.c()), l.a(Reflection.b(kotlin.m.class), a.v(kotlin.m.f56800c)), l.a(Reflection.b(kotlin.n.class), a.q()), l.a(Reflection.b(Boolean.TYPE), a.A(kotlin.jvm.internal.l.f56785a)), l.a(Reflection.b(boolean[].class), a.b()), l.a(Reflection.b(Unit.class), a.z(Unit.f56620a)), l.a(Reflection.b(Void.class), a.l()), l.a(Reflection.b(kotlin.time.b.class), a.J(kotlin.time.b.f56931c)));

    public static final f a(String str, e eVar) {
        d(str);
        return new m1(str, eVar);
    }

    public static final <T> b<T> b(c<T> cVar) {
        return f57747a.get(cVar);
    }

    public static final String c(String str) {
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char charAt = str.charAt(0);
        sb2.append(Character.isLowerCase(charAt) ? CharsKt__CharKt.f(charAt) : String.valueOf(charAt));
        sb2.append(str.substring(1));
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void d(java.lang.String r4) {
        /*
            java.util.Map<kotlin.reflect.c<? extends java.lang.Object>, kotlinx.serialization.b<? extends java.lang.Object>> r0 = f57747a
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0069
            java.lang.Object r1 = r0.next()
            kotlin.reflect.c r1 = (kotlin.reflect.c) r1
            java.lang.String r1 = r1.f()
            java.lang.String r1 = c(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "kotlin."
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r3 = 1
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.w(r4, r2, r3)
            if (r2 != 0) goto L_0x003d
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.w(r4, r1, r3)
            if (r2 != 0) goto L_0x003d
            goto L_0x000a
        L_0x003d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r4 = " there already exist "
            r2.append(r4)
            java.lang.String r4 = c(r1)
            r2.append(r4)
            java.lang.String r4 = "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            java.lang.String r4 = kotlin.text.StringsKt__IndentKt.f(r4)
            r0.<init>(r4)
            throw r0
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.n1.d(java.lang.String):void");
    }
}
