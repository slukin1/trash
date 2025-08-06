package com.sumsub.sns.internal.core.data.network.interceptor;

import android.util.Base64;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.g0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.x;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.p;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.h;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

public final class c implements Interceptor {

    /* renamed from: d  reason: collision with root package name */
    public static final a f32945d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final int f32946e = 3;

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.b<String> f32947a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.b<String> f32948b;

    /* renamed from: c  reason: collision with root package name */
    public int f32949c;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    @f
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\b\u000fB\u001f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014B3\b\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sns/internal/core/data/network/interceptor/c$b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getAccessToken$annotations", "()V", "accessToken", "b", "c", "getRedirectUrl$annotations", "redirectUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {
        public static final C0355b Companion = new C0355b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final String f32950a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32951b;

        public static final class a implements d0<b> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32952a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32953b;

            static {
                a aVar = new a();
                f32952a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.network.interceptor.TokenInterceptor.JWTPayload", aVar, 2);
                pluginGeneratedSerialDescriptor.k("jti", true);
                pluginGeneratedSerialDescriptor.k("url", true);
                f32953b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public b deserialize(kotlinx.serialization.encoding.c cVar) {
                int i11;
                Object obj;
                Object obj2;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                if (b11.k()) {
                    v1 v1Var = v1.f57779a;
                    obj = b11.j(descriptor, 0, v1Var, null);
                    obj2 = b11.j(descriptor, 1, v1Var, null);
                    i11 = 3;
                } else {
                    obj2 = null;
                    Object obj3 = null;
                    int i12 = 0;
                    boolean z11 = true;
                    while (z11) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            z11 = false;
                        } else if (w11 == 0) {
                            obj3 = b11.j(descriptor, 0, v1.f57779a, obj3);
                            i12 |= 1;
                        } else if (w11 == 1) {
                            obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                            i12 |= 2;
                        } else {
                            throw new UnknownFieldException(w11);
                        }
                    }
                    obj = obj3;
                    i11 = i12;
                }
                b11.c(descriptor);
                return new b(i11, (String) obj, (String) obj2, (q1) null);
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                v1 v1Var = v1.f57779a;
                return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32953b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(d dVar, b bVar) {
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                b.a(bVar, b11, descriptor);
                b11.c(descriptor);
            }
        }

        /* renamed from: com.sumsub.sns.internal.core.data.network.interceptor.c$b$b  reason: collision with other inner class name */
        public static final class C0355b {
            public /* synthetic */ C0355b(r rVar) {
                this();
            }

            public final kotlinx.serialization.b<b> serializer() {
                return a.f32952a;
            }

            public C0355b() {
            }
        }

        public b() {
            this((String) null, (String) null, 3, (r) null);
        }

        public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
            boolean z11 = false;
            if (bVar2.q(fVar, 0) || bVar.f32950a != null) {
                bVar2.y(fVar, 0, v1.f57779a, bVar.f32950a);
            }
            if (bVar2.q(fVar, 1) || bVar.f32951b != null) {
                z11 = true;
            }
            if (z11) {
                bVar2.y(fVar, 1, v1.f57779a, bVar.f32951b);
            }
        }

        public static /* synthetic */ void b() {
        }

        public static /* synthetic */ void d() {
        }

        public final String c() {
            return this.f32951b;
        }

        public /* synthetic */ b(int i11, String str, String str2, q1 q1Var) {
            if ((i11 & 0) != 0) {
                h1.a(i11, 0, a.f32952a.getDescriptor());
            }
            if ((i11 & 1) == 0) {
                this.f32950a = null;
            } else {
                this.f32950a = str;
            }
            if ((i11 & 2) == 0) {
                this.f32951b = null;
            } else {
                this.f32951b = str2;
            }
        }

        public final String a() {
            return this.f32950a;
        }

        public b(String str, String str2) {
            this.f32950a = str;
            this.f32951b = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(String str, String str2, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
        }
    }

    public c(com.sumsub.sns.internal.core.b<String> bVar, com.sumsub.sns.internal.core.b<String> bVar2) {
        this.f32947a = bVar;
        this.f32948b = bVar2;
    }

    public final boolean a() {
        String str = null;
        try {
            TokenExpirationHandler tokenExpirationHandler = e0.f32018a.getTokenExpirationHandler();
            if (tokenExpirationHandler != null) {
                str = tokenExpirationHandler.onTokenExpired();
            }
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            aVar.e(a11, message, e11);
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            com.sumsub.sns.core.c.b(cVar, d.f32954a, "error updating token: " + e11.getMessage(), (Throwable) null, 4, (Object) null);
        }
        if (!(str != null && g0.b(str))) {
            return false;
        }
        this.f32947a.a(str);
        return true;
    }

    public final Request b(Request request) {
        if (!g0.b(this.f32947a.get())) {
            com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.f32954a, "Invalid token, try to refresh", (Throwable) null, 4, (Object) null);
            return null;
        }
        try {
            return a(request);
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            aVar.e(a11, message, e11);
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            com.sumsub.sns.core.c.b(cVar, d.f32954a, "error adding header: " + e11.getMessage(), (Throwable) null, 4, (Object) null);
            SNSErrorHandler errorHandler = e0.f32018a.getErrorHandler();
            if (errorHandler == null) {
                return null;
            }
            errorHandler.onError(new SNSException.Unknown(e11));
            return null;
        }
    }

    public final Request c(Request request) {
        if (!a()) {
            return null;
        }
        try {
            return a(request);
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            com.sumsub.log.logger.a.b(aVar, a11, message, (Throwable) null, 4, (Object) null);
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            com.sumsub.sns.core.c.b(cVar, d.f32954a, "error adding header: " + e11.getMessage(), (Throwable) null, 4, (Object) null);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.Response intercept(okhttp3.Interceptor.Chain r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            okhttp3.Request r0 = r12.request()     // Catch:{ all -> 0x0075 }
            okhttp3.Request r1 = r11.b(r0)     // Catch:{ all -> 0x0075 }
            if (r1 != 0) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            okhttp3.Response r1 = r12.proceed(r0)     // Catch:{ all -> 0x0075 }
            int r2 = r1.code()     // Catch:{ all -> 0x0075 }
            r3 = 401(0x191, float:5.62E-43)
            r4 = 0
            if (r2 == r3) goto L_0x001e
            r11.f32949c = r4     // Catch:{ all -> 0x0075 }
            monitor-exit(r11)
            return r1
        L_0x001e:
            com.sumsub.sns.core.c r5 = com.sumsub.sns.core.c.f30748a     // Catch:{ all -> 0x0075 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r2.<init>()     // Catch:{ all -> 0x0075 }
            java.lang.String r6 = "Token is expired. Attempts("
            r2.append(r6)     // Catch:{ all -> 0x0075 }
            int r6 = r11.f32949c     // Catch:{ all -> 0x0075 }
            r2.append(r6)     // Catch:{ all -> 0x0075 }
            java.lang.String r6 = "). Headers are "
            r2.append(r6)     // Catch:{ all -> 0x0075 }
            okhttp3.Headers r6 = r1.headers()     // Catch:{ all -> 0x0075 }
            r2.append(r6)     // Catch:{ all -> 0x0075 }
            java.lang.String r6 = ", try to refresh..."
            r2.append(r6)     // Catch:{ all -> 0x0075 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0075 }
            java.lang.String r6 = "TokenInterceptor"
            r8 = 0
            r9 = 4
            r10 = 0
            com.sumsub.sns.core.c.b(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0075 }
        L_0x004c:
            okhttp3.Request r2 = r11.c(r0)     // Catch:{ all -> 0x0075 }
            if (r2 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = r2
        L_0x0054:
            r1.close()     // Catch:{ all -> 0x0075 }
            okhttp3.Response r1 = r12.proceed(r0)     // Catch:{ all -> 0x0075 }
            int r2 = r1.code()     // Catch:{ all -> 0x0075 }
            r5 = 3
            if (r2 == r3) goto L_0x0065
            r11.f32949c = r4     // Catch:{ all -> 0x0075 }
            goto L_0x006d
        L_0x0065:
            int r2 = r11.f32949c     // Catch:{ all -> 0x0075 }
            int r2 = r2 + 1
            r11.f32949c = r2     // Catch:{ all -> 0x0075 }
            if (r2 < r5) goto L_0x004c
        L_0x006d:
            int r12 = r11.f32949c     // Catch:{ all -> 0x0075 }
            if (r12 < r5) goto L_0x0073
            r11.f32949c = r4     // Catch:{ all -> 0x0075 }
        L_0x0073:
            monitor-exit(r11)
            return r1
        L_0x0075:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.network.interceptor.c.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public final Request a(Request request) {
        String str;
        String str2;
        String c11;
        String a11;
        Request.Builder removeHeader = request.newBuilder().removeHeader(n0.e.f32153d);
        String str3 = this.f32947a.get();
        if (StringsKt__StringsJVMKt.M(str3, "_act-jwt-", false, 2, (Object) null) || StringsKt__StringsJVMKt.M(str3, "_act-sbx-jwt-", false, 2, (Object) null)) {
            try {
                List L0 = StringsKt__StringsKt.L0(StringsKt__StringsKt.A0(StringsKt__StringsKt.A0(str3, "_act-jwt-"), "_act-sbx-jwt-"), new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
                byte[] decode = Base64.decode(URLDecoder.decode((String) L0.get(0), "utf-8"), 2);
                Charset charset = kotlin.text.b.f56908b;
                String str4 = new String(decode, charset);
                String str5 = new String(Base64.decode(URLDecoder.decode((String) L0.get(1), "utf-8"), 2), charset);
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a12 = com.sumsub.sns.internal.log.c.a(this);
                com.sumsub.log.logger.a.a(aVar, a12, "JWT: header=" + str4 + " payload=" + str5, (Throwable) null, 4, (Object) null);
                kotlinx.serialization.json.a a13 = x.a(false, 1, (Object) null);
                kotlinx.serialization.modules.d a14 = a13.a();
                p g11 = Reflection.g(b.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                b bVar = (b) a13.c(h.d(a14, g11), str5);
                if (!(bVar == null || (a11 = bVar.a()) == null)) {
                    this.f32947a.a(a11);
                    removeHeader.addHeader(n0.e.f32153d, a11);
                }
                if (!(bVar == null || (c11 = bVar.c()) == null)) {
                    this.f32948b.a(c11);
                }
            } catch (Exception unused) {
                removeHeader.addHeader(n0.e.f32153d, str3);
            }
        } else {
            removeHeader.addHeader(n0.e.f32153d, str3);
        }
        String str6 = this.f32948b.get();
        if (str6 != null) {
            HttpUrl parse = HttpUrl.Companion.parse(str6);
            HttpUrl url = request.url();
            HttpUrl.Builder newBuilder = url.newBuilder();
            if (parse == null || (str = parse.scheme()) == null) {
                str = url.scheme();
            }
            HttpUrl.Builder scheme = newBuilder.scheme(str);
            if (parse == null || (str2 = parse.host()) == null) {
                str2 = url.host();
            }
            HttpUrl build = scheme.host(str2).build();
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            com.sumsub.sns.core.c.b(cVar, d.f32954a, "Substitute url: " + url + " -> " + build, (Throwable) null, 4, (Object) null);
            removeHeader.url(build);
        }
        return removeHeader.build();
    }
}
