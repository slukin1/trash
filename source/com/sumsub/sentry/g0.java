package com.sumsub.sentry;

import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@f
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t%B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eB%\b\u0017\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001d\u0010#J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006HÇ\u0001J\u001b\u0010\t\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fJ#\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000fJ\u001b\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0012J\u0010\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\t\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/sumsub/sentry/g0;", "Lcom/sumsub/sns/internal/log/cacher/a;", "Lcom/sumsub/sentry/v;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "value", "", "(Lcom/sumsub/sentry/v;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/io/OutputStream;", "outputStream", "(Lcom/sumsub/sentry/v;Ljava/io/OutputStream;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/io/InputStream;", "inputStream", "(Ljava/io/InputStream;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "bytes", "", "Ljava/lang/String;", "url", "Lokhttp3/OkHttpClient;", "b", "Lkotlin/i;", "()Lokhttp3/OkHttpClient;", "sentryOkHttpClient", "<init>", "(Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "c", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class g0 implements com.sumsub.sns.internal.log.cacher.a<v> {
    public static final c Companion = new c((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f30350c = "SentrySink";

    /* renamed from: a  reason: collision with root package name */
    public final String f30351a;

    /* renamed from: b  reason: collision with root package name */
    public final i f30352b;

    public static final class a implements d0<g0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30353a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30354b;

        static {
            a aVar = new a();
            f30353a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentrySink", aVar, 1);
            pluginGeneratedSerialDescriptor.k("url", false);
            f30354b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public g0 deserialize(kotlinx.serialization.encoding.c cVar) {
            String str;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                str = b11.i(descriptor, 0);
            } else {
                str = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        str = b11.i(descriptor, 0);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new g0(i11, str, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30354b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(kotlinx.serialization.encoding.d dVar, g0 g0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            g0.a(g0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b extends Lambda implements d10.a<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f30355a = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return builder.callTimeout(30, timeUnit).connectTimeout(30, timeUnit).readTimeout(30, timeUnit).writeTimeout(30, timeUnit).pingInterval(20, timeUnit).build();
        }
    }

    public static final class c {
        public /* synthetic */ c(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<g0> serializer() {
            return a.f30353a;
        }

        public c() {
        }
    }

    public static final class d extends Lambda implements d10.a<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f30356a = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return builder.callTimeout(30, timeUnit).connectTimeout(30, timeUnit).readTimeout(30, timeUnit).writeTimeout(30, timeUnit).pingInterval(20, timeUnit).build();
        }
    }

    public /* synthetic */ g0(int i11, String str, q1 q1Var) {
        if (1 != (i11 & 1)) {
            h1.a(i11, 1, a.f30353a.getDescriptor());
        }
        this.f30351a = str;
        this.f30352b = LazyKt__LazyJVMKt.a(b.f30355a);
    }

    public static final void a(g0 g0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.p(fVar, 0, g0Var.f30351a);
    }

    public final OkHttpClient a() {
        return (OkHttpClient) this.f30352b.getValue();
    }

    public g0(String str) {
        this.f30351a = str;
        this.f30352b = LazyKt__LazyJVMKt.a(d.f30356a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        kotlin.io.b.a(r0, r3);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(com.sumsub.sentry.v r3, kotlin.coroutines.c<? super java.lang.Boolean> r4) {
        /*
            r2 = this;
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream
            r0.<init>(r4)
            com.sumsub.sentry.m r1 = com.sumsub.sentry.m.f30426a     // Catch:{ all -> 0x0022 }
            r1.a(r3, r0)     // Catch:{ all -> 0x0022 }
            kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0022 }
            r3 = 0
            kotlin.io.b.a(r0, r3)
            byte[] r3 = r4.toByteArray()
            boolean r3 = r2.a(r3)
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r3
        L_0x0022:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r4 = move-exception
            kotlin.io.b.a(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.g0.send(com.sumsub.sentry.v, kotlin.coroutines.c):java.lang.Object");
    }

    public Object a(v vVar, OutputStream outputStream, kotlin.coroutines.c<? super Unit> cVar) {
        m.f30426a.a(vVar, outputStream);
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.b.a(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.io.InputStream r7, kotlin.coroutines.c<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r1 = "SentrySink"
            java.lang.String r2 = "Resend envelope from cache"
            r3 = 0
            r4 = 4
            r5 = 0
            com.sumsub.log.logger.a.a(r0, r1, r2, r3, r4, r5)
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0033 }
            r8.<init>()     // Catch:{ Exception -> 0x0033 }
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0033 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0033 }
            r1 = 0
            byte[] r7 = kotlin.io.a.c(r7)     // Catch:{ all -> 0x002c }
            r0.write(r7)     // Catch:{ all -> 0x002c }
            kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x002c }
            kotlin.io.b.a(r0, r1)     // Catch:{ Exception -> 0x0033 }
            byte[] r7 = r8.toByteArray()     // Catch:{ Exception -> 0x0033 }
            boolean r7 = r6.a(r7)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0050
        L_0x002c:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x002e }
        L_0x002e:
            r8 = move-exception
            kotlin.io.b.a(r0, r7)     // Catch:{ Exception -> 0x0033 }
            throw r8     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            r7 = move-exception
            com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Can't resend envelope from cache: "
            r8.append(r1)
            r8.append(r7)
            java.lang.String r2 = r8.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "SentrySink"
            com.sumsub.log.logger.a.a(r0, r1, r2, r3, r4, r5)
            r7 = 0
        L_0x0050:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.a.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.g0.a(java.io.InputStream, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean a(byte[] bArr) {
        try {
            Request.Builder builder = new Request.Builder();
            return a().newCall(builder.url(this.f30351a + "api/2/envelope/").header(HttpHeaders.CONTENT_ENCODING, DecompressionHelper.GZIP_ENCODING).header("Accept", "application/json").header(HttpHeaders.CONNECTION, "close").header("User-Agent", com.sumsub.sns.a.f30551d).header("X-Sentry-Auth", "Sentry sentry_version=7,sentry_client=1.32.1,sentry_key=5ed67192b2104fb682468a5be4dee5da").post(RequestBody.Companion.create$default(RequestBody.Companion, bArr, MediaType.Companion.get("application/x-sentry-envelope"), 0, 0, 6, (Object) null)).build()).execute().isSuccessful();
        } catch (Exception unused) {
            return false;
        }
    }
}
