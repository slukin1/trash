package hv;

import android.text.TextUtils;
import bv.f;
import bv.h;
import com.huobi.woodpecker.kalle.Kalle;
import com.huobi.woodpecker.kalle.Url;
import com.huobi.woodpecker.kalle.o;
import com.huobi.woodpecker.kalle.simple.SimpleCallback;
import com.huobi.woodpecker.kalle.simple.cache.CacheMode;
import com.huobi.woodpecker.model.Config;
import com.huobi.woodpecker.net.JsonConverter;
import com.huobi.woodpecker.net.UrlConfig;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import kv.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f22797a = Charset.forName("UTF-8");

    /* renamed from: hv.a$a  reason: collision with other inner class name */
    public class C0188a extends SimpleCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.huobi.woodpecker.kalle.a f22798a;

        public C0188a(com.huobi.woodpecker.kalle.a aVar) {
            this.f22798a = aVar;
        }

        public void e(Exception exc) {
            com.huobi.woodpecker.kalle.a aVar = this.f22798a;
            if (aVar != null) {
                aVar.a(Boolean.FALSE);
            }
        }

        public void f(h<Void, String> hVar) {
            e.e("API", "trendLog result=>" + hVar.a() + ", succeed:::" + hVar.e() + ", failed:::" + hVar.b());
            com.huobi.woodpecker.kalle.a aVar = this.f22798a;
            if (aVar != null) {
                aVar.a(Boolean.valueOf(hVar.c()));
            }
        }
    }

    public class b extends JsonConverter<Void> {
        /* renamed from: c */
        public Void b(String str, Type type) {
            return null;
        }
    }

    public class c extends SimpleCallback<Config> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.huobi.woodpecker.kalle.a f22799a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22800b;

        public c(com.huobi.woodpecker.kalle.a aVar, String str) {
            this.f22799a = aVar;
            this.f22800b = str;
        }

        public void e(Exception exc) {
        }

        public void f(h<Config, String> hVar) {
            String a11 = UrlConfig.a();
            if (this.f22799a != null && TextUtils.equals(this.f22800b, a11)) {
                this.f22799a.a(hVar.e());
            }
        }
    }

    public class d extends JsonConverter<Config> {
        /* renamed from: c */
        public Config b(String str, Type type) {
            return Config.fromJsonObject(str);
        }
    }

    public static void a(String str, com.huobi.woodpecker.kalle.a<Config> aVar) {
        String a11 = UrlConfig.a();
        Url.a i11 = Url.j(a11).h(com.sumsub.sentry.a.f30241h, com.huobi.woodpecker.b.f()).i("env", str).h("source", 3).i("appv", com.huobi.woodpecker.b.e()).i("appsdkv", com.huobi.woodpecker.b.d()).i("appwm", com.huobi.woodpecker.b.q()).i("appsysv", com.huobi.woodpecker.b.l()).i("apppt", com.huobi.woodpecker.b.c());
        String n11 = com.huobi.woodpecker.b.n();
        if (!TextUtils.isEmpty(n11)) {
            i11.i(ZendeskIdentityStorage.UUID_KEY, n11);
        }
        Url j11 = i11.j();
        e.e("API", "getProfile-url:" + j11.toString());
        Kalle.a(j11).o(CacheMode.NETWORK_NO_THEN_READ_CACHE).n(j11.toString()).p(new d()).q(new c(aVar, a11));
    }

    public static void b(String str, com.huobi.woodpecker.kalle.a<Boolean> aVar) {
        if (str != null && str.length() > 0) {
            String c11 = UrlConfig.c();
            if (!TextUtils.isEmpty(c11)) {
                ((f.b) Kalle.c(Url.j(c11).j()).m(new o(str))).r(new b()).s(new C0188a(aVar));
                return;
            }
            e.e("API", "trendLog url is null =>");
            if (aVar != null) {
                aVar.a(Boolean.TRUE);
            }
        } else if (aVar != null) {
            aVar.a(Boolean.TRUE);
        }
    }
}
