package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class k implements j {

    public static final class a extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f34616a = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return Build.SUPPORTED_ABIS[0];
        }
    }

    public static final class b extends Lambda implements d10.a<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f34617a = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(Runtime.getRuntime().availableProcessors());
        }
    }

    public static final class c extends Lambda implements d10.a<Map<String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f34618a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(0);
            this.f34618a = kVar;
        }

        /* renamed from: a */
        public final Map<String, String> invoke() {
            return this.f34618a.d();
        }
    }

    public String b() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, a.f34616a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public int c() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, b.f34617a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = 0;
        }
        return ((Number) a11).intValue();
    }

    public final Map<String, String> d() {
        HashMap hashMap = new HashMap();
        Scanner scanner = new Scanner(new File(l.f34626a));
        while (scanner.hasNextLine()) {
            List L0 = StringsKt__StringsKt.L0(scanner.nextLine(), new String[]{l.f34627b}, false, 0, 6, (Object) null);
            if (L0.size() > 1) {
                String str = (String) L0.get(0);
                int length = str.length() - 1;
                int i11 = 0;
                boolean z11 = false;
                while (i11 <= length) {
                    boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                    if (!z11) {
                        if (!z12) {
                            z11 = true;
                        } else {
                            i11++;
                        }
                    } else if (!z12) {
                        break;
                    } else {
                        length--;
                    }
                }
                String obj = str.subSequence(i11, length + 1).toString();
                String str2 = (String) L0.get(1);
                int length2 = str2.length() - 1;
                int i12 = 0;
                boolean z13 = false;
                while (i12 <= length2) {
                    boolean z14 = x.c(str2.charAt(!z13 ? i12 : length2), 32) <= 0;
                    if (!z13) {
                        if (!z14) {
                            z13 = true;
                        } else {
                            i12++;
                        }
                    } else if (!z14) {
                        break;
                    } else {
                        length2--;
                    }
                }
                hashMap.put(obj, str2.subSequence(i12, length2 + 1).toString());
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new c(this), 1, (Object) null);
        Map h11 = MapsKt__MapsKt.h();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = h11;
        }
        return (Map) a11;
    }
}
