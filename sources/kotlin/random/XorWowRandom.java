package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.r;

public final class XorWowRandom extends Random implements Serializable {
    private static final a Companion = new a((r) null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;

    /* renamed from: v  reason: collision with root package name */
    private int f56819v;

    /* renamed from: w  reason: collision with root package name */
    private int f56820w;

    /* renamed from: x  reason: collision with root package name */
    private int f56821x;

    /* renamed from: y  reason: collision with root package name */
    private int f56822y;

    /* renamed from: z  reason: collision with root package name */
    private int f56823z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public XorWowRandom(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f56821x = i11;
        this.f56822y = i12;
        this.f56823z = i13;
        this.f56820w = i14;
        this.f56819v = i15;
        this.addend = i16;
        int i17 = i11 | i12 | i13 | i14 | i15;
        if (i17 != 0) {
            for (int i18 = 0; i18 < 64; i18++) {
                nextInt();
            }
            return;
        }
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    }

    public int nextBits(int i11) {
        return b.f(nextInt(), i11);
    }

    public int nextInt() {
        int i11 = this.f56821x;
        int i12 = i11 ^ (i11 >>> 2);
        this.f56821x = this.f56822y;
        this.f56822y = this.f56823z;
        this.f56823z = this.f56820w;
        int i13 = this.f56819v;
        this.f56820w = i13;
        int i14 = ((i12 ^ (i12 << 1)) ^ i13) ^ (i13 << 4);
        this.f56819v = i14;
        int i15 = this.addend + 362437;
        this.addend = i15;
        return i14 + i15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XorWowRandom(int r8, int r9) {
        /*
            r7 = this;
            int r5 = ~r8
            int r0 = r8 << 10
            int r1 = r9 >>> 4
            r6 = r0 ^ r1
            r3 = 0
            r4 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.XorWowRandom.<init>(int, int):void");
    }
}
