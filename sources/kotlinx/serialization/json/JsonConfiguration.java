package kotlinx.serialization.json;

import kotlin.jvm.internal.r;

public final class JsonConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f57808a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f57809b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f57810c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f57811d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f57812e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f57813f;

    /* renamed from: g  reason: collision with root package name */
    public final String f57814g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f57815h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f57816i;

    /* renamed from: j  reason: collision with root package name */
    public final String f57817j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f57818k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f57819l;

    /* renamed from: m  reason: collision with root package name */
    public final q f57820m;

    public JsonConfiguration() {
        this(false, false, false, false, false, false, (String) null, false, false, (String) null, false, false, (q) null, 8191, (r) null);
    }

    public JsonConfiguration(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, String str, boolean z17, boolean z18, String str2, boolean z19, boolean z21, q qVar) {
        this.f57808a = z11;
        this.f57809b = z12;
        this.f57810c = z13;
        this.f57811d = z14;
        this.f57812e = z15;
        this.f57813f = z16;
        this.f57814g = str;
        this.f57815h = z17;
        this.f57816i = z18;
        this.f57817j = str2;
        this.f57818k = z19;
        this.f57819l = z21;
        this.f57820m = qVar;
    }

    public final boolean a() {
        return this.f57818k;
    }

    public final boolean b() {
        return this.f57811d;
    }

    public final String c() {
        return this.f57817j;
    }

    public final boolean d() {
        return this.f57815h;
    }

    public final boolean e() {
        return this.f57808a;
    }

    public final boolean f() {
        return this.f57813f;
    }

    public final boolean g() {
        return this.f57809b;
    }

    public final q h() {
        return this.f57820m;
    }

    public final boolean i() {
        return this.f57812e;
    }

    public final String j() {
        return this.f57814g;
    }

    public final boolean k() {
        return this.f57819l;
    }

    public final boolean l() {
        return this.f57816i;
    }

    public final boolean m() {
        return this.f57810c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f57808a + ", ignoreUnknownKeys=" + this.f57809b + ", isLenient=" + this.f57810c + ", allowStructuredMapKeys=" + this.f57811d + ", prettyPrint=" + this.f57812e + ", explicitNulls=" + this.f57813f + ", prettyPrintIndent='" + this.f57814g + "', coerceInputValues=" + this.f57815h + ", useArrayPolymorphism=" + this.f57816i + ", classDiscriminator='" + this.f57817j + "', allowSpecialFloatingPointValues=" + this.f57818k + ", useAlternativeNames=" + this.f57819l + ", namingStrategy=" + this.f57820m + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JsonConfiguration(boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, java.lang.String r21, boolean r22, boolean r23, java.lang.String r24, boolean r25, boolean r26, kotlinx.serialization.json.q r27, int r28, kotlin.jvm.internal.r r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            r8 = 1
            if (r7 == 0) goto L_0x0031
            r7 = r8
            goto L_0x0033
        L_0x0031:
            r7 = r20
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            java.lang.String r9 = "    "
            goto L_0x003c
        L_0x003a:
            r9 = r21
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r22
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r2
            goto L_0x004c
        L_0x004a:
            r11 = r23
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0053
            java.lang.String r12 = "type"
            goto L_0x0055
        L_0x0053:
            r12 = r24
        L_0x0055:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r2 = r25
        L_0x005c:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r8 = r26
        L_0x0063:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0069
            r0 = 0
            goto L_0x006b
        L_0x0069:
            r0 = r27
        L_0x006b:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r27 = r8
            r28 = r0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.JsonConfiguration.<init>(boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, boolean, boolean, java.lang.String, boolean, boolean, kotlinx.serialization.json.q, int, kotlin.jvm.internal.r):void");
    }
}
