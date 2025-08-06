package zo;

public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final a f85095g = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f85096a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f85097b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f85098c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f85099d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f85100e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f85101f = 20;

    public static a g() {
        return f85095g;
    }

    public int a() {
        return this.f85099d;
    }

    public int b() {
        return this.f85098c;
    }

    public int c() {
        return this.f85097b;
    }

    public int d() {
        return this.f85096a;
    }

    public int e() {
        return this.f85100e;
    }

    public int f() {
        return this.f85101f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return "rejected";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String h(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = "triggered"
            java.lang.String r1 = "rejected"
            java.lang.String r2 = "canceled"
            if (r5 == 0) goto L_0x0029
            r3 = 1
            if (r5 == r3) goto L_0x0026
            r3 = 2
            if (r5 == r3) goto L_0x0024
            switch(r5) {
                case 10: goto L_0x0021;
                case 11: goto L_0x0024;
                case 12: goto L_0x001f;
                case 13: goto L_0x002b;
                default: goto L_0x0011;
            }
        L_0x0011:
            switch(r5) {
                case 20: goto L_0x001c;
                case 21: goto L_0x0019;
                case 22: goto L_0x001f;
                case 23: goto L_0x002b;
                case 24: goto L_0x0024;
                case 25: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x002b
        L_0x0016:
            java.lang.String r0 = "stopped"
            goto L_0x002b
        L_0x0019:
            java.lang.String r0 = "pending"
            goto L_0x002b
        L_0x001c:
            java.lang.String r0 = "canceled,rejected,triggered,stopped"
            goto L_0x002b
        L_0x001f:
            r0 = r1
            goto L_0x002b
        L_0x0021:
            java.lang.String r0 = "canceled,rejected,triggered"
            goto L_0x002b
        L_0x0024:
            r0 = r2
            goto L_0x002b
        L_0x0026:
            java.lang.String r0 = "partial-canceled,filled"
            goto L_0x002b
        L_0x0029:
            java.lang.String r0 = "partial-canceled,filled,canceled"
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zo.a.h(int):java.lang.String");
    }

    public boolean i() {
        return this.f85096a == 2;
    }

    public boolean j() {
        return this.f85097b == 2;
    }

    public boolean k() {
        return this.f85097b == 3;
    }

    public void l() {
        this.f85096a = 0;
        this.f85097b = 0;
        this.f85098c = 0;
        this.f85099d = 0;
        this.f85100e = 10;
        this.f85101f = 20;
    }

    public void m(int i11) {
        this.f85099d = i11;
    }

    public void n(int i11) {
        this.f85098c = i11;
    }

    public void o(int i11) {
        this.f85097b = i11;
    }

    public void p(int i11) {
        this.f85096a = i11;
    }

    public void q(int i11) {
        this.f85100e = i11;
    }

    public void r(int i11) {
        this.f85101f = i11;
    }
}
