package com.sumsub.sns.internal.ml.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.OkHttpClient;

public abstract class a {

    /* renamed from: com.sumsub.sns.internal.ml.core.a$a  reason: collision with other inner class name */
    public static final class C0407a extends a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f34980a;

        /* renamed from: b  reason: collision with root package name */
        public final String f34981b;

        /* renamed from: c  reason: collision with root package name */
        public final String f34982c;

        public C0407a(Context context, String str, String str2) {
            super((r) null);
            this.f34980a = context;
            this.f34981b = str;
            this.f34982c = str2;
        }

        public final C0407a a(Context context, String str, String str2) {
            return new C0407a(context, str, str2);
        }

        public final Context b() {
            return this.f34980a;
        }

        public final String c() {
            return this.f34981b;
        }

        public final String d() {
            return this.f34982c;
        }

        public final Context e() {
            return this.f34980a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0407a)) {
                return false;
            }
            C0407a aVar = (C0407a) obj;
            return x.b(this.f34980a, aVar.f34980a) && x.b(this.f34981b, aVar.f34981b) && x.b(this.f34982c, aVar.f34982c);
        }

        public final String f() {
            return this.f34982c;
        }

        public final String g() {
            return this.f34981b;
        }

        public int hashCode() {
            return (((this.f34980a.hashCode() * 31) + this.f34981b.hashCode()) * 31) + this.f34982c.hashCode();
        }

        public String toString() {
            return i.a((Object) this) + l.f34627b + this.f34981b;
        }

        public static /* synthetic */ C0407a a(C0407a aVar, Context context, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                context = aVar.f34980a;
            }
            if ((i11 & 2) != 0) {
                str = aVar.f34981b;
            }
            if ((i11 & 4) != 0) {
                str2 = aVar.f34982c;
            }
            return aVar.a(context, str, str2);
        }

        public ByteBuffer a() {
            c cVar = c.f35017a;
            String str = this.f34982c;
            c.b(cVar, str, "Loading MlModel " + this.f34981b + " from assets", (Throwable) null, 4, (Object) null);
            AssetFileDescriptor openFd = this.f34980a.getAssets().openFd(this.f34981b);
            return new FileInputStream(openFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f34983a;

        /* renamed from: b  reason: collision with root package name */
        public final OkHttpClient f34984b;

        /* renamed from: c  reason: collision with root package name */
        public final String f34985c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f34986d;

        /* renamed from: e  reason: collision with root package name */
        public final String f34987e;

        public b(Context context, OkHttpClient okHttpClient, String str, boolean z11, String str2) {
            super((r) null);
            this.f34983a = context;
            this.f34984b = okHttpClient;
            this.f34985c = str;
            this.f34986d = z11;
            this.f34987e = str2;
        }

        public final b a(Context context, OkHttpClient okHttpClient, String str, boolean z11, String str2) {
            return new b(context, okHttpClient, str, z11, str2);
        }

        public final Context b() {
            return this.f34983a;
        }

        public final OkHttpClient c() {
            return this.f34984b;
        }

        public final String d() {
            return this.f34985c;
        }

        public final boolean e() {
            return this.f34986d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f34983a, bVar.f34983a) && x.b(this.f34984b, bVar.f34984b) && x.b(this.f34985c, bVar.f34985c) && this.f34986d == bVar.f34986d && x.b(this.f34987e, bVar.f34987e);
        }

        public final String f() {
            return this.f34987e;
        }

        public final boolean g() {
            return this.f34986d;
        }

        public final Context h() {
            return this.f34983a;
        }

        public int hashCode() {
            int hashCode = ((((this.f34983a.hashCode() * 31) + this.f34984b.hashCode()) * 31) + this.f34985c.hashCode()) * 31;
            boolean z11 = this.f34986d;
            if (z11) {
                z11 = true;
            }
            return ((hashCode + (z11 ? 1 : 0)) * 31) + this.f34987e.hashCode();
        }

        public final String i() {
            return this.f34987e;
        }

        public final OkHttpClient j() {
            return this.f34984b;
        }

        public final String k() {
            return this.f34985c;
        }

        public String toString() {
            return i.a((Object) this) + l.f34627b + this.f34985c;
        }

        public static /* synthetic */ b a(b bVar, Context context, OkHttpClient okHttpClient, String str, boolean z11, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                context = bVar.f34983a;
            }
            if ((i11 & 2) != 0) {
                okHttpClient = bVar.f34984b;
            }
            OkHttpClient okHttpClient2 = okHttpClient;
            if ((i11 & 4) != 0) {
                str = bVar.f34985c;
            }
            String str3 = str;
            if ((i11 & 8) != 0) {
                z11 = bVar.f34986d;
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                str2 = bVar.f34987e;
            }
            return bVar.a(context, okHttpClient2, str3, z12, str2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b7, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b8, code lost:
            kotlin.io.b.a(r7, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bb, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.nio.ByteBuffer a() {
            /*
                r9 = this;
                com.sumsub.sns.internal.ml.core.c r6 = com.sumsub.sns.internal.ml.core.c.f35017a
                java.lang.String r1 = r9.f34987e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Loading model "
                r0.append(r2)
                java.lang.String r2 = r9.f34985c
                r0.append(r2)
                java.lang.String r2 = r0.toString()
                r3 = 0
                r4 = 4
                r5 = 0
                r0 = r6
                com.sumsub.sns.internal.ml.core.c.b(r0, r1, r2, r3, r4, r5)
                okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
                r0.<init>()
                java.lang.String r1 = r9.f34985c
                okhttp3.Request$Builder r0 = r0.url((java.lang.String) r1)
                boolean r1 = r9.f34986d
                if (r1 != 0) goto L_0x0033
                okhttp3.CacheControl r1 = okhttp3.CacheControl.FORCE_NETWORK
                okhttp3.Request$Builder r0 = r0.cacheControl(r1)
            L_0x0033:
                okhttp3.Request r0 = r0.build()
                okhttp3.OkHttpClient r1 = r9.f34984b
                okhttp3.Call r0 = r1.newCall(r0)
                okhttp3.Response r7 = r0.execute()
                r8 = 0
                boolean r0 = r7.isSuccessful()     // Catch:{ all -> 0x00b5 }
                if (r0 != 0) goto L_0x0083
                java.lang.String r1 = r9.f34987e     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Failed to load model"
                r3 = 0
                r4 = 4
                r5 = 0
                r0 = r6
                com.sumsub.sns.internal.ml.core.c.b(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b5 }
                int r0 = r7.code()     // Catch:{ all -> 0x00b5 }
                r1 = 404(0x194, float:5.66E-43)
                if (r0 != r1) goto L_0x006c
                java.lang.String r1 = r9.f34987e     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Model file NOT found"
                r3 = 0
                r4 = 4
                r5 = 0
                r0 = r6
                com.sumsub.sns.internal.ml.core.c.b(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b5 }
                com.sumsub.sns.internal.ml.core.d r0 = new com.sumsub.sns.internal.ml.core.d     // Catch:{ all -> 0x00b5 }
                r0.<init>()     // Catch:{ all -> 0x00b5 }
                throw r0     // Catch:{ all -> 0x00b5 }
            L_0x006c:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00b5 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                r1.<init>()     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Unexpected code "
                r1.append(r2)     // Catch:{ all -> 0x00b5 }
                r1.append(r7)     // Catch:{ all -> 0x00b5 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b5 }
                r0.<init>(r1)     // Catch:{ all -> 0x00b5 }
                throw r0     // Catch:{ all -> 0x00b5 }
            L_0x0083:
                okhttp3.Response r0 = r7.cacheResponse()     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x0095
                java.lang.String r1 = r9.f34987e     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Got MlModel from cache"
                r3 = 0
                r4 = 4
                r5 = 0
                r0 = r6
                com.sumsub.sns.internal.ml.core.c.b(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b5 }
                goto L_0x00a0
            L_0x0095:
                java.lang.String r1 = r9.f34987e     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Got MlModel from the server"
                r3 = 0
                r4 = 4
                r5 = 0
                r0 = r6
                com.sumsub.sns.internal.ml.core.c.b(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b5 }
            L_0x00a0:
                okhttp3.ResponseBody r0 = r7.body()     // Catch:{ all -> 0x00b5 }
                byte[] r0 = r0.bytes()     // Catch:{ all -> 0x00b5 }
                int r1 = r0.length     // Catch:{ all -> 0x00b5 }
                java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)     // Catch:{ all -> 0x00b5 }
                java.nio.ByteBuffer r0 = r1.put(r0)     // Catch:{ all -> 0x00b5 }
                kotlin.io.b.a(r7, r8)
                return r0
            L_0x00b5:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x00b7 }
            L_0x00b7:
                r1 = move-exception
                kotlin.io.b.a(r7, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.core.a.b.a():java.nio.ByteBuffer");
        }
    }

    public /* synthetic */ a(r rVar) {
        this();
    }

    public abstract ByteBuffer a();

    public a() {
    }
}
