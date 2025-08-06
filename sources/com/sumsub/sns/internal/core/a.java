package com.sumsub.sns.internal.core;

import android.content.Context;
import android.net.Uri;
import android.text.Spanned;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.q;
import com.sumsub.sns.internal.core.common.SNSSession;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.o0;
import com.sumsub.sns.internal.core.common.p0;
import com.sumsub.sns.internal.core.common.x;
import com.sumsub.sns.internal.core.common.x0;
import com.sumsub.sns.internal.fingerprint.Fingerprinter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.r1;
import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public final class a {
    public static a A;

    /* renamed from: z  reason: collision with root package name */
    public static final C0314a f31823z = new C0314a((kotlin.jvm.internal.r) null);

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f31824a;

    /* renamed from: b  reason: collision with root package name */
    public final SNSSession f31825b;

    /* renamed from: c  reason: collision with root package name */
    public final h0 f31826c = i0.a(e2.b((n1) null, 1, (Object) null));

    /* renamed from: d  reason: collision with root package name */
    public final kotlin.i f31827d = LazyKt__LazyJVMKt.a(new t(this));

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.i f31828e = LazyKt__LazyJVMKt.a(new h(this));

    /* renamed from: f  reason: collision with root package name */
    public final kotlin.i f31829f = LazyKt__LazyJVMKt.a(new d(this));

    /* renamed from: g  reason: collision with root package name */
    public final kotlin.i f31830g = LazyKt__LazyJVMKt.a(new e(this));

    /* renamed from: h  reason: collision with root package name */
    public final kotlin.i f31831h = LazyKt__LazyJVMKt.a(new m(this));

    /* renamed from: i  reason: collision with root package name */
    public final kotlin.i f31832i = LazyKt__LazyJVMKt.a(new b(this));

    /* renamed from: j  reason: collision with root package name */
    public final kotlin.i f31833j = LazyKt__LazyJVMKt.a(new f(this));

    /* renamed from: k  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.extensions.a f31834k = new j(this);

    /* renamed from: l  reason: collision with root package name */
    public final kotlin.i f31835l = LazyKt__LazyJVMKt.a(new i(this));

    /* renamed from: m  reason: collision with root package name */
    public final kotlin.i f31836m = LazyKt__LazyJVMKt.a(new c(this));

    /* renamed from: n  reason: collision with root package name */
    public final kotlin.i f31837n = LazyKt__LazyJVMKt.a(new l(this));

    /* renamed from: o  reason: collision with root package name */
    public final kotlinx.serialization.json.a f31838o = x.a(false, 1, (Object) null);

    /* renamed from: p  reason: collision with root package name */
    public final kotlin.i f31839p = LazyKt__LazyJVMKt.a(new o(this));

    /* renamed from: q  reason: collision with root package name */
    public final kotlin.i f31840q = LazyKt__LazyJVMKt.a(new n(this));

    /* renamed from: r  reason: collision with root package name */
    public final kotlin.i f31841r = LazyKt__LazyJVMKt.a(new g(this));

    /* renamed from: s  reason: collision with root package name */
    public final kotlin.i f31842s = LazyKt__LazyJVMKt.a(new q(this));

    /* renamed from: t  reason: collision with root package name */
    public final kotlin.i f31843t = LazyKt__LazyJVMKt.a(new r(this));

    /* renamed from: u  reason: collision with root package name */
    public final kotlin.i f31844u = LazyKt__LazyJVMKt.a(new p(this));

    /* renamed from: v  reason: collision with root package name */
    public final kotlin.i f31845v = LazyKt__LazyJVMKt.a(new k(this));

    /* renamed from: w  reason: collision with root package name */
    public final kotlin.i f31846w = LazyKt__LazyJVMKt.a(s.f31869a);

    /* renamed from: x  reason: collision with root package name */
    public final b<String> f31847x = new u(this);

    /* renamed from: y  reason: collision with root package name */
    public final v f31848y = new v();

    /* renamed from: com.sumsub.sns.internal.core.a$a  reason: collision with other inner class name */
    public static final class C0314a {
        public /* synthetic */ C0314a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final a a(Context context, SNSSession sNSSession) {
            if (context == context.getApplicationContext()) {
                a a11 = a.A;
                if (a11 != null) {
                    if (!kotlin.jvm.internal.x.b(a11.E(), sNSSession)) {
                        a11 = null;
                    }
                    if (a11 != null) {
                        return a11;
                    }
                }
                a aVar = new a(new WeakReference(context), sNSSession);
                C0314a aVar2 = a.f31823z;
                a.A = aVar;
                return aVar;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public C0314a() {
        }
    }

    public static final class b extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.analythic.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31849a;

        /* renamed from: com.sumsub.sns.internal.core.a$b$a  reason: collision with other inner class name */
        public static final class C0315a extends Lambda implements d10.a<UUID> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f31850a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0315a(a aVar) {
                super(0);
                this.f31850a = aVar;
            }

            /* renamed from: a */
            public final UUID invoke() {
                return this.f31850a.F().g();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
            super(0);
            this.f31849a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.analythic.a invoke() {
            com.sumsub.sns.internal.log.cacher.e eVar = new com.sumsub.sns.internal.log.cacher.e(new com.sumsub.sns.internal.core.analytics.k(this.f31849a.d(), new C0315a(this.f31849a)), this.f31849a.j().getCacheDir());
            eVar.a("_AnalyticsRepository");
            com.sumsub.sns.internal.log.cacher.d.f34872a.a(eVar);
            return new com.sumsub.sns.internal.core.data.source.analythic.a(eVar);
        }
    }

    public static final class c extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.applicant.remote.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31851a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(0);
            this.f31851a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.d invoke() {
            return new com.sumsub.sns.internal.core.data.source.applicant.remote.d(this.f31851a.i(), this.f31851a.f(), this.f31851a.w(), this.f31851a.E().getUrl());
        }
    }

    public static final class d extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.applicant.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31852a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar) {
            super(0);
            this.f31852a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.applicant.c invoke() {
            return new com.sumsub.sns.internal.core.data.source.applicant.c(this.f31852a.e(), this.f31852a.p());
        }
    }

    public static final class e extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.applicant.f> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31853a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar) {
            super(0);
            this.f31853a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.applicant.f invoke() {
            return new com.sumsub.sns.internal.core.data.source.applicant.f(this.f31853a.e());
        }
    }

    public static final class f extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.cache.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31854a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a aVar) {
            super(0);
            this.f31854a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.cache.b invoke() {
            return new com.sumsub.sns.internal.core.data.source.cache.b(this.f31854a.j());
        }
    }

    public static final class g extends Lambda implements d10.a<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31855a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f31855a = aVar;
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            return this.f31855a.w().newBuilder().cache(new Cache(new File(this.f31855a.j().getCacheDir(), "sumsub_cache"), 31457280)).build();
        }
    }

    public static final class h extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.common.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31856a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar) {
            super(0);
            this.f31856a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.common.c invoke() {
            return new com.sumsub.sns.internal.core.data.source.common.c(this.f31856a.o());
        }
    }

    public static final class i extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.dynamic.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31857a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar) {
            super(0);
            this.f31857a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.dynamic.c invoke() {
            return new com.sumsub.sns.internal.core.data.source.dynamic.c(this.f31857a.F(), this.f31857a.e(), this.f31857a.o(), this.f31857a.f31826c, (CoroutineDispatcher) null, this.f31857a.G(), this.f31857a.f31848y, 16, (kotlin.jvm.internal.r) null);
        }
    }

    public static final class j implements com.sumsub.sns.internal.core.data.source.extensions.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31858a;

        public j(a aVar) {
            this.f31858a = aVar;
        }

        public Spanned a(CharSequence charSequence) {
            return com.sumsub.sns.internal.core.common.i.a(charSequence, this.f31858a.j());
        }
    }

    public static final class k extends Lambda implements d10.a<com.sumsub.sns.internal.core.domain.o> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31859a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(a aVar) {
            super(0);
            this.f31859a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.domain.o invoke() {
            return new com.sumsub.sns.internal.core.domain.h().b((Context) this.f31859a.f31824a.get());
        }
    }

    public static final class l extends Lambda implements d10.a<Fingerprinter> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31860a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(a aVar) {
            super(0);
            this.f31860a = aVar;
        }

        /* renamed from: a */
        public final Fingerprinter invoke() {
            return com.sumsub.sns.internal.fingerprint.a.a(this.f31860a.j());
        }
    }

    public static final class m extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.log.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31861a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(a aVar) {
            super(0);
            this.f31861a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.log.c invoke() {
            return new com.sumsub.sns.internal.core.data.source.log.c(this.f31861a.v());
        }
    }

    public static final class n extends Lambda implements d10.a<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31862a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(a aVar) {
            super(0);
            this.f31862a = aVar;
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            HttpLoggingInterceptor.Level level;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder addInterceptor = builder.callTimeout(30, timeUnit).connectTimeout(30, timeUnit).readTimeout(30, timeUnit).writeTimeout(30, timeUnit).pingInterval(20, timeUnit).addInterceptor(new com.sumsub.sns.internal.core.data.network.interceptor.a(this.f31862a.F())).addInterceptor(new com.sumsub.sns.internal.core.data.network.interceptor.c(this.f31862a.G(), this.f31862a.f31848y));
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (kotlin.jvm.internal.r) null);
            if (e0.f32018a.isDebug()) {
                level = HttpLoggingInterceptor.Level.BODY;
            } else {
                level = HttpLoggingInterceptor.Level.NONE;
            }
            httpLoggingInterceptor.level(level);
            return addInterceptor.addInterceptor(new com.sumsub.sns.internal.core.data.network.interceptor.b(httpLoggingInterceptor, CollectionsKt__CollectionsJVMKt.e(new Regex("/resources/tracking/trackEventsComp", RegexOption.IGNORE_CASE)))).build();
        }
    }

    public static final class o extends Lambda implements d10.a<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31863a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(a aVar) {
            super(0);
            this.f31863a = aVar;
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            HttpLoggingInterceptor.Level level;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MINUTES;
            OkHttpClient.Builder callTimeout = builder.callTimeout(5, timeUnit);
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            OkHttpClient.Builder addInterceptor = callTimeout.connectTimeout(30, timeUnit2).readTimeout(30, timeUnit2).writeTimeout(1, timeUnit).pingInterval(20, timeUnit2).addInterceptor(new com.sumsub.sns.internal.core.data.network.interceptor.a(this.f31863a.F())).addInterceptor(new com.sumsub.sns.internal.core.data.network.interceptor.c(this.f31863a.G(), this.f31863a.f31848y));
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (kotlin.jvm.internal.r) null);
            if (e0.f32018a.isDebug()) {
                level = HttpLoggingInterceptor.Level.BODY;
            } else {
                level = HttpLoggingInterceptor.Level.NONE;
            }
            httpLoggingInterceptor.level(level);
            RegexOption regexOption = RegexOption.IGNORE_CASE;
            return addInterceptor.addInterceptor(new com.sumsub.sns.internal.core.data.network.interceptor.b(httpLoggingInterceptor, CollectionsKt__CollectionsKt.n(new Regex("applicantActions/\\w+/images", regexOption), new Regex("resources/applicants/\\w+/info/idDoc", regexOption)))).build();
        }
    }

    public static final class s extends Lambda implements d10.a<o0> {

        /* renamed from: a  reason: collision with root package name */
        public static final s f31869a = new s();

        public s() {
            super(0);
        }

        /* renamed from: a */
        public final o0 invoke() {
            return new p0().a();
        }
    }

    public static final class t extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.settings.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31870a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(a aVar) {
            super(0);
            this.f31870a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.settings.a invoke() {
            return new com.sumsub.sns.internal.core.data.source.settings.a(this.f31870a.j().getSharedPreferences(n0.f32115c, 0));
        }
    }

    public static final class u implements b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31871a;

        public u(a aVar) {
            this.f31871a = aVar;
        }

        /* renamed from: a */
        public String get() {
            return this.f31871a.E().getAccessToken();
        }

        public void a(String str) {
            this.f31871a.E().setAccessToken(str);
        }
    }

    public static final class v implements b<String> {

        /* renamed from: a  reason: collision with root package name */
        public String f31872a;

        /* renamed from: a */
        public String get() {
            return this.f31872a;
        }

        public void a(String str) {
            this.f31872a = str;
        }
    }

    public a(WeakReference<Context> weakReference, SNSSession sNSSession) {
        this.f31824a = weakReference;
        this.f31825b = sNSSession;
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void x() {
    }

    public static /* synthetic */ void z() {
    }

    public final Picasso A() {
        return (Picasso) this.f31844u.getValue();
    }

    public final Retrofit B() {
        return (Retrofit) this.f31842s.getValue();
    }

    public final Retrofit C() {
        return (Retrofit) this.f31843t.getValue();
    }

    public final o0 D() {
        return (o0) this.f31846w.getValue();
    }

    public final SNSSession E() {
        return this.f31825b;
    }

    public final com.sumsub.sns.internal.core.data.source.settings.b F() {
        return (com.sumsub.sns.internal.core.data.source.settings.b) this.f31827d.getValue();
    }

    public final b<String> G() {
        return this.f31847x;
    }

    public final com.sumsub.sns.internal.core.data.source.cache.a k() {
        return (com.sumsub.sns.internal.core.data.source.cache.a) this.f31833j.getValue();
    }

    public final OkHttpClient l() {
        return (OkHttpClient) this.f31841r.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.common.a n() {
        return (com.sumsub.sns.internal.core.data.source.common.a) this.f31828e.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.common.b o() {
        return (com.sumsub.sns.internal.core.data.source.common.b) B().create(com.sumsub.sns.internal.core.data.source.common.b.class);
    }

    public final com.sumsub.sns.internal.core.data.source.dynamic.b p() {
        return (com.sumsub.sns.internal.core.data.source.dynamic.b) this.f31835l.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.extensions.a q() {
        return this.f31834k;
    }

    public final com.sumsub.sns.internal.core.domain.o r() {
        return (com.sumsub.sns.internal.core.domain.o) this.f31845v.getValue();
    }

    public final Fingerprinter s() {
        return (Fingerprinter) this.f31837n.getValue();
    }

    public final kotlinx.serialization.json.a t() {
        return this.f31838o;
    }

    public final com.sumsub.sns.internal.core.data.source.log.a u() {
        return (com.sumsub.sns.internal.core.data.source.log.a) this.f31831h.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.log.b v() {
        return (com.sumsub.sns.internal.core.data.source.log.b) B().create(com.sumsub.sns.internal.core.data.source.log.b.class);
    }

    public final OkHttpClient w() {
        return (OkHttpClient) this.f31840q.getValue();
    }

    public final OkHttpClient y() {
        return (OkHttpClient) this.f31839p.getValue();
    }

    public final void b() {
        r1.f(this.f31826c.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public final com.sumsub.sns.internal.core.data.source.analythic.a c() {
        return (com.sumsub.sns.internal.core.data.source.analythic.a) this.f31832i.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.analythic.b d() {
        return (com.sumsub.sns.internal.core.data.source.analythic.b) B().create(com.sumsub.sns.internal.core.data.source.analythic.b.class);
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.a e() {
        return (com.sumsub.sns.internal.core.data.source.applicant.a) this.f31836m.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.remote.c f() {
        return (com.sumsub.sns.internal.core.data.source.applicant.remote.c) C().create(com.sumsub.sns.internal.core.data.source.applicant.remote.c.class);
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.b g() {
        return (com.sumsub.sns.internal.core.data.source.applicant.b) this.f31829f.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.e h() {
        return (com.sumsub.sns.internal.core.data.source.applicant.e) this.f31830g.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.remote.e i() {
        return (com.sumsub.sns.internal.core.data.source.applicant.remote.e) B().create(com.sumsub.sns.internal.core.data.source.applicant.remote.e.class);
    }

    public final Context j() {
        return this.f31824a.get().getApplicationContext();
    }

    public static final class p extends Lambda implements d10.a<Picasso> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31864a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(a aVar) {
            super(0);
            this.f31864a = aVar;
        }

        /* renamed from: a */
        public final Picasso invoke() {
            Context context = (Context) this.f31864a.f31824a.get();
            if (context == null) {
                return null;
            }
            a aVar = this.f31864a;
            return new Picasso.b(context).e(c.f31959a).c(new com.squareup.picasso.n(aVar.w())).f(new d(aVar)).a();
        }

        public static final void a(Picasso picasso, Uri uri, Exception exc) {
            com.sumsub.sns.internal.log.a.f34862a.e("Picasso", "Error", exc);
        }

        public static final com.squareup.picasso.q a(a aVar, com.squareup.picasso.q qVar) {
            return new q.b(Uri.parse(aVar.E().getUrl() + qVar.f30085d)).a();
        }
    }

    public static final class q extends Lambda implements d10.a<Retrofit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31865a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(a aVar) {
            super(0);
            this.f31865a = aVar;
        }

        /* renamed from: a */
        public final Retrofit invoke() {
            return new Retrofit.Builder().baseUrl(this.f31865a.E().getUrl()).client(this.f31865a.w()).addCallAdapterFactory(new com.sumsub.sns.internal.core.data.adapter.network.b(new C0316a(this.f31865a))).addConverterFactory(bw.c.a(this.f31865a.t(), MediaType.Companion.get("application/json"))).build();
        }

        /* renamed from: com.sumsub.sns.internal.core.a$q$a  reason: collision with other inner class name */
        public static final class C0316a implements x0 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f31866a;

            public C0316a(a aVar) {
                this.f31866a = aVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0093 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.CharSequence a(java.lang.String r8) {
                /*
                    r7 = this;
                    com.sumsub.sns.internal.core.a r0 = r7.f31866a
                    com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.p()
                    kotlinx.coroutines.flow.j1 r0 = r0.b()
                    java.lang.Object r0 = r0.getValue()
                    com.sumsub.sns.internal.core.data.source.dynamic.b$a r0 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r0
                    r1 = 0
                    if (r0 == 0) goto L_0x00d5
                    com.sumsub.sns.internal.core.data.source.dynamic.e r0 = r0.i()
                    if (r0 == 0) goto L_0x00d5
                    java.lang.Object r0 = r0.d()
                    com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                    if (r0 == 0) goto L_0x00d5
                    java.util.Map r0 = r0.C()
                    if (r0 == 0) goto L_0x002e
                    java.lang.String r2 = "errorCodes"
                    java.lang.Object r0 = r0.get(r2)
                    goto L_0x002f
                L_0x002e:
                    r0 = r1
                L_0x002f:
                    boolean r2 = r0 instanceof java.util.Map
                    if (r2 == 0) goto L_0x0036
                    java.util.Map r0 = (java.util.Map) r0
                    goto L_0x0037
                L_0x0036:
                    r0 = r1
                L_0x0037:
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L_0x0075
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>()
                    java.util.Set r0 = r0.entrySet()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0048:
                    boolean r5 = r0.hasNext()
                    if (r5 == 0) goto L_0x0076
                    java.lang.Object r5 = r0.next()
                    java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                    java.lang.Object r6 = r5.getKey()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    java.lang.Object r6 = r5.getValue()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    r6 = r3
                    goto L_0x0067
                L_0x0066:
                    r6 = r2
                L_0x0067:
                    if (r6 == 0) goto L_0x0048
                    java.lang.Object r6 = r5.getKey()
                    java.lang.Object r5 = r5.getValue()
                    r4.put(r6, r5)
                    goto L_0x0048
                L_0x0075:
                    r4 = r1
                L_0x0076:
                    if (r4 == 0) goto L_0x0080
                    boolean r0 = r4.isEmpty()
                    r0 = r0 ^ r3
                    if (r0 != r3) goto L_0x0080
                    r2 = r3
                L_0x0080:
                    if (r2 == 0) goto L_0x0083
                    goto L_0x0084
                L_0x0083:
                    r4 = r1
                L_0x0084:
                    if (r4 == 0) goto L_0x00cb
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.Set r2 = r4.entrySet()
                    java.util.Iterator r2 = r2.iterator()
                L_0x0093:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x00c6
                    java.lang.Object r3 = r2.next()
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                    java.lang.Object r4 = r3.getKey()
                    boolean r5 = r4 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00a8
                    r4 = r1
                L_0x00a8:
                    java.lang.String r4 = (java.lang.String) r4
                    if (r4 != 0) goto L_0x00ad
                    goto L_0x00ba
                L_0x00ad:
                    java.lang.Object r3 = r3.getValue()
                    boolean r5 = r3 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00b6
                    r3 = r1
                L_0x00b6:
                    java.lang.String r3 = (java.lang.String) r3
                    if (r3 != 0) goto L_0x00bc
                L_0x00ba:
                    r3 = r1
                    goto L_0x00c0
                L_0x00bc:
                    kotlin.Pair r3 = kotlin.l.a(r4, r3)
                L_0x00c0:
                    if (r3 == 0) goto L_0x0093
                    r0.add(r3)
                    goto L_0x0093
                L_0x00c6:
                    java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r0)
                    goto L_0x00cc
                L_0x00cb:
                    r0 = r1
                L_0x00cc:
                    if (r0 == 0) goto L_0x00d5
                    java.lang.Object r8 = r0.get(r8)
                    r1 = r8
                    java.lang.String r1 = (java.lang.String) r1
                L_0x00d5:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.a.q.C0316a.a(java.lang.String):java.lang.CharSequence");
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0093 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.String> a() {
                /*
                    r7 = this;
                    com.sumsub.sns.internal.core.a r0 = r7.f31866a
                    com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.p()
                    kotlinx.coroutines.flow.j1 r0 = r0.b()
                    java.lang.Object r0 = r0.getValue()
                    com.sumsub.sns.internal.core.data.source.dynamic.b$a r0 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r0
                    if (r0 == 0) goto L_0x00cc
                    com.sumsub.sns.internal.core.data.source.dynamic.e r0 = r0.i()
                    if (r0 == 0) goto L_0x00cc
                    java.lang.Object r0 = r0.d()
                    com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                    if (r0 == 0) goto L_0x00cc
                    java.util.Map r0 = r0.C()
                    r1 = 0
                    if (r0 == 0) goto L_0x002e
                    java.lang.String r2 = "errorCodes"
                    java.lang.Object r0 = r0.get(r2)
                    goto L_0x002f
                L_0x002e:
                    r0 = r1
                L_0x002f:
                    boolean r2 = r0 instanceof java.util.Map
                    if (r2 == 0) goto L_0x0036
                    java.util.Map r0 = (java.util.Map) r0
                    goto L_0x0037
                L_0x0036:
                    r0 = r1
                L_0x0037:
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L_0x0075
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>()
                    java.util.Set r0 = r0.entrySet()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0048:
                    boolean r5 = r0.hasNext()
                    if (r5 == 0) goto L_0x0076
                    java.lang.Object r5 = r0.next()
                    java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                    java.lang.Object r6 = r5.getKey()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    java.lang.Object r6 = r5.getValue()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    r6 = r3
                    goto L_0x0067
                L_0x0066:
                    r6 = r2
                L_0x0067:
                    if (r6 == 0) goto L_0x0048
                    java.lang.Object r6 = r5.getKey()
                    java.lang.Object r5 = r5.getValue()
                    r4.put(r6, r5)
                    goto L_0x0048
                L_0x0075:
                    r4 = r1
                L_0x0076:
                    if (r4 == 0) goto L_0x0080
                    boolean r0 = r4.isEmpty()
                    r0 = r0 ^ r3
                    if (r0 != r3) goto L_0x0080
                    r2 = r3
                L_0x0080:
                    if (r2 == 0) goto L_0x0083
                    goto L_0x0084
                L_0x0083:
                    r4 = r1
                L_0x0084:
                    if (r4 == 0) goto L_0x00ca
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.Set r2 = r4.entrySet()
                    java.util.Iterator r2 = r2.iterator()
                L_0x0093:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x00c6
                    java.lang.Object r3 = r2.next()
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                    java.lang.Object r4 = r3.getKey()
                    boolean r5 = r4 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00a8
                    r4 = r1
                L_0x00a8:
                    java.lang.String r4 = (java.lang.String) r4
                    if (r4 != 0) goto L_0x00ad
                    goto L_0x00ba
                L_0x00ad:
                    java.lang.Object r3 = r3.getValue()
                    boolean r5 = r3 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00b6
                    r3 = r1
                L_0x00b6:
                    java.lang.String r3 = (java.lang.String) r3
                    if (r3 != 0) goto L_0x00bc
                L_0x00ba:
                    r3 = r1
                    goto L_0x00c0
                L_0x00bc:
                    kotlin.Pair r3 = kotlin.l.a(r4, r3)
                L_0x00c0:
                    if (r3 == 0) goto L_0x0093
                    r0.add(r3)
                    goto L_0x0093
                L_0x00c6:
                    java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r0)
                L_0x00ca:
                    if (r1 != 0) goto L_0x00d0
                L_0x00cc:
                    java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
                L_0x00d0:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.a.q.C0316a.a():java.util.Map");
            }
        }
    }

    public static final class r extends Lambda implements d10.a<Retrofit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31867a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(a aVar) {
            super(0);
            this.f31867a = aVar;
        }

        /* renamed from: a */
        public final Retrofit invoke() {
            return new Retrofit.Builder().baseUrl(this.f31867a.E().getUrl()).client(this.f31867a.y()).addCallAdapterFactory(new com.sumsub.sns.internal.core.data.adapter.network.b(new C0317a(this.f31867a))).addConverterFactory(bw.c.a(this.f31867a.t(), MediaType.Companion.get("application/json"))).build();
        }

        /* renamed from: com.sumsub.sns.internal.core.a$r$a  reason: collision with other inner class name */
        public static final class C0317a implements x0 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f31868a;

            public C0317a(a aVar) {
                this.f31868a = aVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0093 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.CharSequence a(java.lang.String r8) {
                /*
                    r7 = this;
                    com.sumsub.sns.internal.core.a r0 = r7.f31868a
                    com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.p()
                    kotlinx.coroutines.flow.j1 r0 = r0.b()
                    java.lang.Object r0 = r0.getValue()
                    com.sumsub.sns.internal.core.data.source.dynamic.b$a r0 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r0
                    r1 = 0
                    if (r0 == 0) goto L_0x00d5
                    com.sumsub.sns.internal.core.data.source.dynamic.e r0 = r0.i()
                    if (r0 == 0) goto L_0x00d5
                    java.lang.Object r0 = r0.d()
                    com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                    if (r0 == 0) goto L_0x00d5
                    java.util.Map r0 = r0.C()
                    if (r0 == 0) goto L_0x002e
                    java.lang.String r2 = "errorCodes"
                    java.lang.Object r0 = r0.get(r2)
                    goto L_0x002f
                L_0x002e:
                    r0 = r1
                L_0x002f:
                    boolean r2 = r0 instanceof java.util.Map
                    if (r2 == 0) goto L_0x0036
                    java.util.Map r0 = (java.util.Map) r0
                    goto L_0x0037
                L_0x0036:
                    r0 = r1
                L_0x0037:
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L_0x0075
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>()
                    java.util.Set r0 = r0.entrySet()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0048:
                    boolean r5 = r0.hasNext()
                    if (r5 == 0) goto L_0x0076
                    java.lang.Object r5 = r0.next()
                    java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                    java.lang.Object r6 = r5.getKey()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    java.lang.Object r6 = r5.getValue()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    r6 = r3
                    goto L_0x0067
                L_0x0066:
                    r6 = r2
                L_0x0067:
                    if (r6 == 0) goto L_0x0048
                    java.lang.Object r6 = r5.getKey()
                    java.lang.Object r5 = r5.getValue()
                    r4.put(r6, r5)
                    goto L_0x0048
                L_0x0075:
                    r4 = r1
                L_0x0076:
                    if (r4 == 0) goto L_0x0080
                    boolean r0 = r4.isEmpty()
                    r0 = r0 ^ r3
                    if (r0 != r3) goto L_0x0080
                    r2 = r3
                L_0x0080:
                    if (r2 == 0) goto L_0x0083
                    goto L_0x0084
                L_0x0083:
                    r4 = r1
                L_0x0084:
                    if (r4 == 0) goto L_0x00cb
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.Set r2 = r4.entrySet()
                    java.util.Iterator r2 = r2.iterator()
                L_0x0093:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x00c6
                    java.lang.Object r3 = r2.next()
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                    java.lang.Object r4 = r3.getKey()
                    boolean r5 = r4 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00a8
                    r4 = r1
                L_0x00a8:
                    java.lang.String r4 = (java.lang.String) r4
                    if (r4 != 0) goto L_0x00ad
                    goto L_0x00ba
                L_0x00ad:
                    java.lang.Object r3 = r3.getValue()
                    boolean r5 = r3 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00b6
                    r3 = r1
                L_0x00b6:
                    java.lang.String r3 = (java.lang.String) r3
                    if (r3 != 0) goto L_0x00bc
                L_0x00ba:
                    r3 = r1
                    goto L_0x00c0
                L_0x00bc:
                    kotlin.Pair r3 = kotlin.l.a(r4, r3)
                L_0x00c0:
                    if (r3 == 0) goto L_0x0093
                    r0.add(r3)
                    goto L_0x0093
                L_0x00c6:
                    java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r0)
                    goto L_0x00cc
                L_0x00cb:
                    r0 = r1
                L_0x00cc:
                    if (r0 == 0) goto L_0x00d5
                    java.lang.Object r8 = r0.get(r8)
                    r1 = r8
                    java.lang.String r1 = (java.lang.String) r1
                L_0x00d5:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.a.r.C0317a.a(java.lang.String):java.lang.CharSequence");
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0093 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.String> a() {
                /*
                    r7 = this;
                    com.sumsub.sns.internal.core.a r0 = r7.f31868a
                    com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.p()
                    kotlinx.coroutines.flow.j1 r0 = r0.b()
                    java.lang.Object r0 = r0.getValue()
                    com.sumsub.sns.internal.core.data.source.dynamic.b$a r0 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r0
                    if (r0 == 0) goto L_0x00cc
                    com.sumsub.sns.internal.core.data.source.dynamic.e r0 = r0.i()
                    if (r0 == 0) goto L_0x00cc
                    java.lang.Object r0 = r0.d()
                    com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                    if (r0 == 0) goto L_0x00cc
                    java.util.Map r0 = r0.C()
                    r1 = 0
                    if (r0 == 0) goto L_0x002e
                    java.lang.String r2 = "errorCodes"
                    java.lang.Object r0 = r0.get(r2)
                    goto L_0x002f
                L_0x002e:
                    r0 = r1
                L_0x002f:
                    boolean r2 = r0 instanceof java.util.Map
                    if (r2 == 0) goto L_0x0036
                    java.util.Map r0 = (java.util.Map) r0
                    goto L_0x0037
                L_0x0036:
                    r0 = r1
                L_0x0037:
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L_0x0075
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>()
                    java.util.Set r0 = r0.entrySet()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0048:
                    boolean r5 = r0.hasNext()
                    if (r5 == 0) goto L_0x0076
                    java.lang.Object r5 = r0.next()
                    java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                    java.lang.Object r6 = r5.getKey()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    java.lang.Object r6 = r5.getValue()
                    boolean r6 = r6 instanceof java.lang.String
                    if (r6 == 0) goto L_0x0066
                    r6 = r3
                    goto L_0x0067
                L_0x0066:
                    r6 = r2
                L_0x0067:
                    if (r6 == 0) goto L_0x0048
                    java.lang.Object r6 = r5.getKey()
                    java.lang.Object r5 = r5.getValue()
                    r4.put(r6, r5)
                    goto L_0x0048
                L_0x0075:
                    r4 = r1
                L_0x0076:
                    if (r4 == 0) goto L_0x0080
                    boolean r0 = r4.isEmpty()
                    r0 = r0 ^ r3
                    if (r0 != r3) goto L_0x0080
                    r2 = r3
                L_0x0080:
                    if (r2 == 0) goto L_0x0083
                    goto L_0x0084
                L_0x0083:
                    r4 = r1
                L_0x0084:
                    if (r4 == 0) goto L_0x00ca
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.Set r2 = r4.entrySet()
                    java.util.Iterator r2 = r2.iterator()
                L_0x0093:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x00c6
                    java.lang.Object r3 = r2.next()
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                    java.lang.Object r4 = r3.getKey()
                    boolean r5 = r4 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00a8
                    r4 = r1
                L_0x00a8:
                    java.lang.String r4 = (java.lang.String) r4
                    if (r4 != 0) goto L_0x00ad
                    goto L_0x00ba
                L_0x00ad:
                    java.lang.Object r3 = r3.getValue()
                    boolean r5 = r3 instanceof java.lang.String
                    if (r5 != 0) goto L_0x00b6
                    r3 = r1
                L_0x00b6:
                    java.lang.String r3 = (java.lang.String) r3
                    if (r3 != 0) goto L_0x00bc
                L_0x00ba:
                    r3 = r1
                    goto L_0x00c0
                L_0x00bc:
                    kotlin.Pair r3 = kotlin.l.a(r4, r3)
                L_0x00c0:
                    if (r3 == 0) goto L_0x0093
                    r0.add(r3)
                    goto L_0x0093
                L_0x00c6:
                    java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r0)
                L_0x00ca:
                    if (r1 != 0) goto L_0x00d0
                L_0x00cc:
                    java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
                L_0x00d0:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.a.r.C0317a.a():java.util.Map");
            }
        }
    }
}
