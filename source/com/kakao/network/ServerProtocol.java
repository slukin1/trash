package com.kakao.network;

import qw.b;

public final class ServerProtocol {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final String f25060a = d();
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final String f25061b = c();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f25062c = c();
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final String f25063d = b();
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final String f25064e = e();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25065a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.kakao.common.KakaoPhase[] r0 = com.kakao.common.KakaoPhase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25065a = r0
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.DEV     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25065a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.SANDBOX     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25065a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.CBT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f25065a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.PRODUCTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakao.network.ServerProtocol.a.<clinit>():void");
        }
    }

    public static String a() {
        b d11 = com.kakao.common.a.b() == null ? null : com.kakao.common.a.b().d();
        if (d11 == null || d11.a() == null) {
            return b();
        }
        int i11 = a.f25065a[d11.a().ordinal()];
        if (i11 == 1) {
            return "alpha-kapi.kakao.com";
        }
        if (i11 != 2) {
            return i11 != 3 ? "kapi.kakao.com" : "beta-kapi.kakao.com";
        }
        return "sandbox-kapi.kakao.com";
    }

    public static String b() {
        return "kapi.kakao.com";
    }

    public static String c() {
        return "auth.kakao.com";
    }

    public static String d() {
        return "kauth.kakao.com";
    }

    public static String e() {
        return "kakaonavi-wguide.kakao.com";
    }
}
