package com.sumsub.sns.internal.core.domain;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33605a = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final String f33606b = "FaceDetectorFactory";

    /* renamed from: c  reason: collision with root package name */
    public static final long f33607c = 500;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final b a() {
            try {
                com.sumsub.sns.internal.ff.a aVar = com.sumsub.sns.internal.ff.a.f34215a;
                JSONObject jSONObject = new JSONObject(aVar.m().f());
                return new b(jSONObject.optBoolean("mlkit", false), aVar.e().g(), jSONObject.optLong("frameDelay", 500));
            } catch (Exception e11) {
                com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                com.sumsub.sns.internal.log.b.b(aVar2, h.f33606b, "Failed to create config: " + com.sumsub.sns.internal.ff.a.f34215a.m().f(), e11);
                return new b(false, false, 0, 7, (r) null);
            }
        }

        public a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f33608a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f33609b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33610c;

        public b() {
            this(false, false, 0, 7, (r) null);
        }

        public final boolean a() {
            return this.f33608a;
        }

        public final boolean b() {
            return this.f33609b;
        }

        public final long c() {
            return this.f33610c;
        }

        public final long d() {
            return this.f33610c;
        }

        public final boolean e() {
            return this.f33608a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f33608a == bVar.f33608a && this.f33609b == bVar.f33609b && this.f33610c == bVar.f33610c;
        }

        public final boolean f() {
            return this.f33609b;
        }

        public int hashCode() {
            boolean z11 = this.f33608a;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            boolean z13 = this.f33609b;
            if (!z13) {
                z12 = z13;
            }
            return ((i11 + (z12 ? 1 : 0)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f33610c);
        }

        public String toString() {
            return "FaceDetectorConfig(mlKit=" + this.f33608a + ", tflow=" + this.f33609b + ", frameDelay=" + this.f33610c + ')';
        }

        public b(boolean z11, boolean z12, long j11) {
            this.f33608a = z11;
            this.f33609b = z12;
            this.f33610c = j11;
        }

        public final b a(boolean z11, boolean z12, long j11) {
            return new b(z11, z12, j11);
        }

        public static /* synthetic */ b a(b bVar, boolean z11, boolean z12, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = bVar.f33608a;
            }
            if ((i11 & 2) != 0) {
                z12 = bVar.f33609b;
            }
            if ((i11 & 4) != 0) {
                j11 = bVar.f33610c;
            }
            return bVar.a(z11, z12, j11);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(boolean z11, boolean z12, long j11, int i11, r rVar) {
            this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? false : z12, (i11 & 4) != 0 ? 500 : j11);
        }
    }

    public final boolean a(Context context) {
        if (context == null) {
            i.a(i.f33611a, f33606b, "@isGooglePlayServicesAvailable, Context is null", (Throwable) null, 4, (Object) null);
            return false;
        }
        try {
            boolean z11 = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
            i iVar = i.f33611a;
            i.a(iVar, f33606b, "@isGooglePlayServicesAvailable, Has connection to GP Services: " + z11, (Throwable) null, 4, (Object) null);
            return z11;
        } catch (Throwable th2) {
            i.f33611a.a(f33606b, "@isGooglePlayServicesAvailable, Failed to check GP Services", th2);
            return false;
        }
    }

    public final o b(Context context) {
        m mVar = new m();
        ArrayList arrayList = new ArrayList();
        b a11 = f33605a.a();
        if (a11.f() && context != null && Build.VERSION.SDK_INT >= 26) {
            try {
                i.a(i.f33611a, f33606b, "Using TensorFlow Face detector", (Throwable) null, 4, (Object) null);
                arrayList.add(new q(context.getApplicationContext()));
            } catch (Throwable th2) {
                i.f33611a.a(f33606b, "Can't use TF detector", th2);
            }
        }
        if (a(context, a11.e())) {
            i.a(i.f33611a, f33606b, "MLKit is disabled. Using native Face detector", (Throwable) null, 4, (Object) null);
            arrayList.add(mVar);
            return new b(arrayList);
        }
        try {
            Class.forName("com.google.mlkit.vision.face.FaceDetection");
            i.a(i.f33611a, f33606b, "Using MLKit Face detector", (Throwable) null, 4, (Object) null);
            arrayList.add(new l());
        } catch (Throwable th3) {
            i.f33611a.a(f33606b, "Can't use MLKit detector", th3);
        }
        arrayList.add(mVar);
        return new b(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r10 = r10.toLowerCase(java.util.Locale.ROOT);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r9, boolean r10) {
        /*
            r8 = this;
            com.sumsub.sns.internal.core.domain.i r6 = com.sumsub.sns.internal.core.domain.i.f33611a
            java.lang.String r1 = "FaceDetectorFactory"
            java.lang.String r2 = "@isMlKitDisabled, Checking is MLKit disabled"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            com.sumsub.sns.internal.core.domain.i.a(r0, r1, r2, r3, r4, r5)
            r7 = 1
            if (r10 != 0) goto L_0x001c
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "FaceDetectorFactory"
            java.lang.String r2 = "@isMlKitDisabled, MLKit disabled with FF"
            r0 = r6
            com.sumsub.sns.internal.core.domain.i.a(r0, r1, r2, r3, r4, r5)
            return r7
        L_0x001c:
            java.lang.String r10 = android.os.Build.MANUFACTURER
            r0 = 0
            if (r10 == 0) goto L_0x0035
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r10 = r10.toLowerCase(r1)
            if (r10 == 0) goto L_0x0035
            r1 = 2
            r2 = 0
            java.lang.String r3 = "huawei"
            boolean r10 = kotlin.text.StringsKt__StringsKt.R(r10, r3, r0, r1, r2)
            if (r10 != r7) goto L_0x0035
            r10 = r7
            goto L_0x0036
        L_0x0035:
            r10 = r0
        L_0x0036:
            if (r10 == 0) goto L_0x0044
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "FaceDetectorFactory"
            java.lang.String r2 = "@isMlKitDisabled, manufacturer is Huawei"
            r0 = r6
            com.sumsub.sns.internal.core.domain.i.a(r0, r1, r2, r3, r4, r5)
            return r7
        L_0x0044:
            boolean r9 = r8.a(r9)
            if (r9 != 0) goto L_0x0056
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "FaceDetectorFactory"
            java.lang.String r2 = "@isMlKitDisabled, no connection to GP Services"
            r0 = r6
            com.sumsub.sns.internal.core.domain.i.a(r0, r1, r2, r3, r4, r5)
            return r7
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.h.a(android.content.Context, boolean):boolean");
    }
}
