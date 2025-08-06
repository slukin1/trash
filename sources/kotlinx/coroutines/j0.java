package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f57355a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f57356b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f57357c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicLong f57358d = new AtomicLong(0);

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (r0.equals("on") != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0.equals("") != false) goto L_0x0041;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.d0.d(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0063
            int r3 = r0.hashCode()
            if (r3 == 0) goto L_0x0039
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L_0x0030
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L_0x0027
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L_0x0043
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0043
            goto L_0x0063
        L_0x0027:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0043
            goto L_0x0063
        L_0x0030:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0043
            goto L_0x0041
        L_0x0039:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0043
        L_0x0041:
            r0 = r1
            goto L_0x0064
        L_0x0043:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.append(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0063:
            r0 = r2
        L_0x0064:
            f57356b = r0
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.d0.f(r0, r1)
            if (r0 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r1 = r2
        L_0x0072:
            f57357c = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            f57358d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.j0.<clinit>():void");
    }

    public static final boolean a() {
        return f57355a;
    }

    public static final AtomicLong b() {
        return f57358d;
    }

    public static final boolean c() {
        return f57356b;
    }

    public static final boolean d() {
        return f57357c;
    }
}
