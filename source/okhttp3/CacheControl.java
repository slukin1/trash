package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.r;

public final class CacheControl {
    public static final Companion Companion = new Companion((r) null);
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j11) {
            if (j11 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j11;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, (String) null, (r) null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i11, TimeUnit timeUnit) {
            if (i11 >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds((long) i11));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + i11).toString());
        }

        public final Builder maxStale(int i11, TimeUnit timeUnit) {
            if (i11 >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds((long) i11));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i11).toString());
        }

        public final Builder minFresh(int i11, TimeUnit timeUnit) {
            if (i11 >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds((long) i11));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + i11).toString());
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i11) {
            int length = str.length();
            while (i11 < length) {
                if (StringsKt__StringsKt.Q(str2, str.charAt(i11), false, 2, (Object) null)) {
                    return i11;
                }
                i11++;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return companion.indexOfElement(str, str2, i11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.CacheControl parse(okhttp3.Headers r30) {
            /*
                r29 = this;
                r0 = r29
                r1 = r30
                int r2 = r30.size()
                r6 = 1
                r8 = r6
                r7 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = -1
                r13 = -1
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = -1
                r18 = -1
                r19 = 0
                r20 = 0
                r21 = 0
            L_0x001e:
                if (r7 >= r2) goto L_0x016e
                java.lang.String r3 = r1.name(r7)
                java.lang.String r5 = r1.value(r7)
                java.lang.String r4 = "Cache-Control"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.w(r3, r4, r6)
                if (r4 == 0) goto L_0x0035
                if (r9 == 0) goto L_0x0033
                goto L_0x003d
            L_0x0033:
                r9 = r5
                goto L_0x003e
            L_0x0035:
                java.lang.String r4 = "Pragma"
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.w(r3, r4, r6)
                if (r3 == 0) goto L_0x0163
            L_0x003d:
                r8 = 0
            L_0x003e:
                r3 = 0
            L_0x003f:
                int r4 = r5.length()
                if (r3 >= r4) goto L_0x0163
                java.lang.String r4 = "=,;"
                int r4 = r0.indexOfElement(r5, r4, r3)
                java.lang.String r3 = r5.substring(r3, r4)
                java.lang.CharSequence r3 = kotlin.text.StringsKt__StringsKt.i1(r3)
                java.lang.String r3 = r3.toString()
                int r6 = r5.length()
                if (r4 == r6) goto L_0x00ae
                char r6 = r5.charAt(r4)
                r1 = 44
                if (r6 == r1) goto L_0x00ae
                char r1 = r5.charAt(r4)
                r6 = 59
                if (r1 != r6) goto L_0x006e
                goto L_0x00ae
            L_0x006e:
                int r4 = r4 + 1
                int r1 = okhttp3.internal.Util.indexOfNonWhitespace(r5, r4)
                int r4 = r5.length()
                if (r1 >= r4) goto L_0x009b
                char r4 = r5.charAt(r1)
                r6 = 34
                if (r4 != r6) goto L_0x009b
                int r1 = r1 + 1
                r24 = 34
                r26 = 0
                r27 = 4
                r28 = 0
                r23 = r5
                r25 = r1
                int r4 = kotlin.text.StringsKt__StringsKt.f0(r23, r24, r25, r26, r27, r28)
                java.lang.String r1 = r5.substring(r1, r4)
                r6 = 1
                int r4 = r4 + r6
                goto L_0x00b1
            L_0x009b:
                java.lang.String r4 = ",;"
                int r4 = r0.indexOfElement(r5, r4, r1)
                java.lang.String r1 = r5.substring(r1, r4)
                java.lang.CharSequence r1 = kotlin.text.StringsKt__StringsKt.i1(r1)
                java.lang.String r1 = r1.toString()
                goto L_0x00b1
            L_0x00ae:
                int r4 = r4 + 1
                r1 = 0
            L_0x00b1:
                java.lang.String r6 = "no-cache"
                r0 = 1
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x00c3
                r1 = r30
                r6 = r0
                r10 = r6
            L_0x00be:
                r3 = r4
                r0 = r29
                goto L_0x003f
            L_0x00c3:
                java.lang.String r6 = "no-store"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x00d0
                r1 = r30
                r6 = r0
                r11 = r6
                goto L_0x00be
            L_0x00d0:
                java.lang.String r6 = "max-age"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x00e1
                r6 = -1
                int r12 = okhttp3.internal.Util.toNonNegativeInt(r1, r6)
            L_0x00dd:
                r1 = r30
                r6 = r0
                goto L_0x00be
            L_0x00e1:
                java.lang.String r6 = "s-maxage"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x00ef
                r6 = -1
                int r13 = okhttp3.internal.Util.toNonNegativeInt(r1, r6)
                goto L_0x00dd
            L_0x00ef:
                java.lang.String r6 = "private"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x00fc
                r1 = r30
                r6 = r0
                r14 = r6
                goto L_0x00be
            L_0x00fc:
                java.lang.String r6 = "public"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x0109
                r1 = r30
                r6 = r0
                r15 = r6
                goto L_0x00be
            L_0x0109:
                java.lang.String r6 = "must-revalidate"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x0117
                r1 = r30
                r6 = r0
                r16 = r6
                goto L_0x00be
            L_0x0117:
                java.lang.String r6 = "max-stale"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x0127
                r3 = 2147483647(0x7fffffff, float:NaN)
                int r17 = okhttp3.internal.Util.toNonNegativeInt(r1, r3)
                goto L_0x00dd
            L_0x0127:
                java.lang.String r6 = "min-fresh"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r3, r0)
                if (r6 == 0) goto L_0x0135
                r6 = -1
                int r18 = okhttp3.internal.Util.toNonNegativeInt(r1, r6)
                goto L_0x00dd
            L_0x0135:
                r6 = -1
                java.lang.String r1 = "only-if-cached"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.w(r1, r3, r0)
                if (r1 == 0) goto L_0x0145
                r1 = r30
                r6 = r0
                r19 = r6
                goto L_0x00be
            L_0x0145:
                java.lang.String r1 = "no-transform"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.w(r1, r3, r0)
                if (r1 == 0) goto L_0x0154
                r1 = r30
                r6 = r0
                r20 = r6
                goto L_0x00be
            L_0x0154:
                java.lang.String r1 = "immutable"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.w(r1, r3, r0)
                if (r1 == 0) goto L_0x00dd
                r1 = r30
                r6 = r0
                r21 = r6
                goto L_0x00be
            L_0x0163:
                r0 = r6
                r6 = -1
                int r7 = r7 + 1
                r1 = r30
                r6 = r0
                r0 = r29
                goto L_0x001e
            L_0x016e:
                if (r8 != 0) goto L_0x0173
                r22 = 0
                goto L_0x0175
            L_0x0173:
                r22 = r9
            L_0x0175:
                okhttp3.CacheControl r0 = new okhttp3.CacheControl
                r23 = 0
                r9 = r0
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }
    }

    private CacheControl(boolean z11, boolean z12, int i11, int i12, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, boolean z17, boolean z18, String str) {
        this.noCache = z11;
        this.noStore = z12;
        this.maxAgeSeconds = i11;
        this.sMaxAgeSeconds = i12;
        this.isPrivate = z13;
        this.isPublic = z14;
        this.mustRevalidate = z15;
        this.maxStaleSeconds = i13;
        this.minFreshSeconds = i14;
        this.onlyIfCached = z16;
        this.noTransform = z17;
        this.immutable = z18;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z11, boolean z12, int i11, int i12, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, boolean z17, boolean z18, String str, r rVar) {
        this(z11, z12, i11, i12, z13, z14, z15, i13, i14, z16, z17, z18, str);
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m3097deprecated_immutable() {
        return this.immutable;
    }

    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m3098deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m3099deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m3100deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m3101deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m3102deprecated_noCache() {
        return this.noCache;
    }

    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m3103deprecated_noStore() {
        return this.noStore;
    }

    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m3104deprecated_noTransform() {
        return this.noTransform;
    }

    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m3105deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m3106deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.noCache) {
            sb2.append("no-cache, ");
        }
        if (this.noStore) {
            sb2.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb2.append("max-age=");
            sb2.append(this.maxAgeSeconds);
            sb2.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.sMaxAgeSeconds);
            sb2.append(", ");
        }
        if (this.isPrivate) {
            sb2.append("private, ");
        }
        if (this.isPublic) {
            sb2.append("public, ");
        }
        if (this.mustRevalidate) {
            sb2.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb2.append("max-stale=");
            sb2.append(this.maxStaleSeconds);
            sb2.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.minFreshSeconds);
            sb2.append(", ");
        }
        if (this.onlyIfCached) {
            sb2.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb2.append("no-transform, ");
        }
        if (this.immutable) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String sb3 = sb2.toString();
        this.headerValue = sb3;
        return sb3;
    }
}
