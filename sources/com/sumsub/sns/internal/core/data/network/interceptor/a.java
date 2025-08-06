package com.sumsub.sns.internal.core.data.network.interceptor;

import android.os.Build;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.source.settings.b;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final b f32940a;

    /* renamed from: b  reason: collision with root package name */
    public final i f32941b = LazyKt__LazyJVMKt.a(new C0354a(this));

    /* renamed from: com.sumsub.sns.internal.core.data.network.interceptor.a$a  reason: collision with other inner class name */
    public static final class C0354a extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f32942a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0354a(a aVar) {
            super(0);
            this.f32942a = aVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f32942a.f32940a.f();
        }
    }

    public a(b bVar) {
        this.f32940a = bVar;
    }

    public synchronized Response intercept(Interceptor.Chain chain) {
        Request.Builder addHeader;
        String f11;
        String str;
        String str2;
        Request.Builder addHeader2 = chain.request().newBuilder().addHeader(n0.e.f32152c, this.f32940a.h());
        String a11 = this.f32940a.a();
        if (!(!StringsKt__StringsJVMKt.z(a11))) {
            a11 = null;
        }
        if (a11 != null) {
            addHeader2.addHeader(n0.e.f32154e, a11);
        }
        e0 e0Var = e0.f32018a;
        Request.Builder addHeader3 = addHeader2.addHeader(n0.e.f32156g, e0Var.getPackageName());
        addHeader = addHeader3.addHeader(n0.e.f32157h, e0Var.getVersionName() + '/' + e0Var.getVersionCode()).addHeader(n0.e.f32158i, com.sumsub.sns.internal.core.common.i.b()).addHeader(n0.e.f32159j, a()).addHeader(n0.e.f32160k, com.sumsub.sns.a.f30551d).addHeader(n0.e.f32161l, e0Var.getLocale().toString()).addHeader(n0.e.f32162m, n0.f32119g).addHeader(n0.e.f32163n, Build.VERSION.RELEASE).addHeader(n0.e.f32164o, n0.f32120h).addHeader(n0.e.f32165p, String.valueOf(e0Var.isDebug())).addHeader(n0.e.f32166q, a());
        if (chain.request().headers().get(n0.e.f32151b) == null) {
            addHeader.addHeader(n0.e.f32151b, String.valueOf(this.f32940a.g()));
        }
        Map<String, String> settings = e0Var.getSettings();
        if (!(settings == null || (str2 = settings.get("appFrameworkName")) == null)) {
            addHeader.addHeader(n0.e.f32167r, str2);
        }
        Map<String, String> settings2 = e0Var.getSettings();
        if (!(settings2 == null || (str = settings2.get("appFrameworkVersion")) == null)) {
            addHeader.addHeader(n0.e.f32168s, str);
        }
        com.sumsub.sns.internal.ff.a aVar = com.sumsub.sns.internal.ff.a.f34215a;
        if (aVar.A().g() && (f11 = aVar.A().f()) != null) {
            addHeader.addHeader(n0.e.f32169t, f11);
        }
        return chain.proceed(addHeader.build());
    }

    public final String a() {
        return (String) this.f32941b.getValue();
    }
}
