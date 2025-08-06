package com.huobi.woodpecker;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.lifecycle.c0;
import com.google.gson.Gson;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.huobi.woodpecker.kalle.Kalle;
import com.huobi.woodpecker.kalle.connect.http.RedirectInterceptor;
import com.huobi.woodpecker.kalle.g;
import com.huobi.woodpecker.net.UrlConfig;
import com.huobi.woodpecker.udf.impl.WoodpeckerUdfRecorderImpl;
import com.huobi.woodpecker.utils.StringUtils;
import com.huochat.community.network.domain.DomainTool;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kv.e;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import vu.d;
import vu.f;

public class WoodPeckerSDK {

    /* renamed from: a  reason: collision with root package name */
    public Context f20925a;

    /* renamed from: b  reason: collision with root package name */
    public List<gv.a> f20926b;

    /* renamed from: c  reason: collision with root package name */
    public volatile jv.a f20927c;

    public static final class ConfigBuilder {

        /* renamed from: a  reason: collision with root package name */
        public int f20928a;

        /* renamed from: b  reason: collision with root package name */
        public String f20929b;

        /* renamed from: c  reason: collision with root package name */
        public String f20930c;

        /* renamed from: d  reason: collision with root package name */
        public String f20931d;

        /* renamed from: e  reason: collision with root package name */
        public String f20932e;

        /* renamed from: f  reason: collision with root package name */
        public String f20933f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f20934g;

        /* renamed from: h  reason: collision with root package name */
        public String f20935h;

        public ConfigBuilder a(String str) {
            this.f20933f = str;
            return this;
        }

        public void b(Application application) {
            c(application, (g.b) null);
        }

        public void c(Application application, g.b bVar) {
            if (this.f20928a <= 0) {
                throw new IllegalArgumentException("businessLine not set ");
            } else if (StringUtils.b(this.f20929b)) {
                throw new IllegalArgumentException("wm(productFlavors) not set ");
            } else if (StringUtils.b(this.f20931d)) {
                throw new IllegalArgumentException("url not set ");
            } else if (!StringUtils.b(this.f20932e)) {
                WoodPeckerSDK.f().h(application, this, bVar);
            } else {
                throw new IllegalArgumentException("env not set ");
            }
        }

        public ConfigBuilder d(int i11) {
            this.f20928a = i11;
            return this;
        }

        public ConfigBuilder e(boolean z11) {
            this.f20934g = z11;
            return this;
        }

        public ConfigBuilder f(String str) {
            this.f20932e = str;
            return this;
        }

        public ConfigBuilder g(String str) {
            this.f20931d = str;
            return this;
        }

        public ConfigBuilder h(String str) {
            this.f20930c = str;
            return this;
        }

        public ConfigBuilder i(String str) {
            this.f20929b = str;
            return this;
        }
    }

    @Keep
    public static class JssdkBean {
        public String sdkUrl;
        public boolean stop = true;

        public String toString() {
            return "JssdkBean{sdkUrl='" + this.sdkUrl + '\'' + ", stop=" + this.stop + '}';
        }
    }

    @Keep
    public static class ReTryException extends IOException {
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d.k().n();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            WoodPeckerSDK.k("https://hbg-prod-fed-public.hbfile.net/nuwa/static/prod/dFHfDojDl5kKLGC6Ydskh.json");
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final WoodPeckerSDK f20938a = new WoodPeckerSDK((a) null);
    }

    public /* synthetic */ WoodPeckerSDK(a aVar) {
        this();
    }

    public static WoodPeckerSDK f() {
        return c.f20938a;
    }

    public static ConfigBuilder j() {
        return new ConfigBuilder();
    }

    public static void k(String str) {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request.Builder url = new Request.Builder().url(str);
        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
        try {
            Response execute = build.newCall(url.cacheControl(cacheControl).get().build()).execute();
            int code = execute.code();
            e.c("WPSDK", "requestJsSdkCode() called with: url = [" + str + "]rscode=" + code);
            if (code == 200) {
                String string = execute.body().string();
                e.c("WPSDK", "requestGrayData() called with: url = [" + str + "] content =" + string);
                JssdkBean jssdkBean = (JssdkBean) new Gson().fromJson(string, JssdkBean.class);
                if (!jssdkBean.stop && !TextUtils.isEmpty(jssdkBean.sdkUrl) && jssdkBean.sdkUrl.startsWith(DomainTool.DOMAIN_PREFIX)) {
                    Response execute2 = build.newCall(new Request.Builder().url(jssdkBean.sdkUrl).cacheControl(cacheControl).get().build()).execute();
                    int code2 = execute2.code();
                    e.c("WPSDK", "requestJsSdkCode() called with: url = [" + str + "]ccode=" + code2);
                    if (code2 == 200) {
                        String readString = execute2.body().source().readString(StandardCharsets.UTF_8);
                        e.c("WPSDK", "requestJsSdkCode() called with: js = " + readString);
                        if (!TextUtils.isEmpty(readString)) {
                            WoodPeckerWebViewAspect.f20996c = "javascript:   (function() {        var script=document.createElement('script');         script.setAttribute('type','text/javascript');         script.src='" + jssdkBean.sdkUrl + "';         document.head.appendChild(script);     }    )();";
                        }
                    }
                }
            }
        } catch (IOException e11) {
            k("https://app-static-1306115679.file.myqcloud.com/nuwa/static/prod/dFHfDojDl5kKLGC6Ydskh.json");
            e.g("WPSDK", "requestGrayData：IOException " + e11.getMessage(), e11);
        } catch (Exception e12) {
            e.g("WPSDK", "requestGrayData：Exception " + e12.getMessage(), e12);
        }
    }

    public final g.b d(g.b bVar) {
        if (bVar == null) {
            bVar = g.q();
        }
        bVar.s(new hv.c(e())).v(f.c()).t(vu.g.d()).q(new yu.f(3)).q(new RedirectInterceptor()).q(new yu.e("HBWP:::", false));
        if (e() != null) {
            bVar.u(new xu.a(e()));
        }
        return bVar;
    }

    public Context e() {
        return this.f20925a;
    }

    public jv.a g() {
        if (this.f20927c == null) {
            synchronized (this) {
                if (this.f20927c == null) {
                    this.f20927c = new WoodpeckerUdfRecorderImpl();
                }
            }
        }
        return this.f20927c;
    }

    public final void h(Application application, ConfigBuilder configBuilder, g.b bVar) {
        l(application);
        if (configBuilder != null) {
            e.n(configBuilder.f20934g);
            if (e() == null) {
                e.h("WPSDK", "WoodPeckerSDK initialize failed!!!");
            } else if (!TextUtils.isEmpty(configBuilder.f20931d)) {
                UrlConfig.f(configBuilder.f20931d);
                fv.g.c().d();
                b.t(configBuilder.f20934g);
                b.s(configBuilder.f20928a);
                b.z(configBuilder.f20929b);
                b.y(configBuilder.f20930c);
                b.v(configBuilder.f20932e);
                b.r(configBuilder.f20933f);
                b.w(configBuilder.f20935h);
                String[] a11 = new hv.b(this.f20925a).a();
                e.c("WPSDK", "run2() called " + Arrays.toString(a11));
                b.u(a11);
                Kalle.d(d(bVar).r());
                try {
                    c0.l().getLifecycle().a(vu.a.a());
                } catch (Throwable unused) {
                }
                vu.g.d().i(new a());
                vu.g.d().i(new b());
            } else {
                e.h("WPSDK", "init failed, url not setting!!!");
            }
        } else {
            throw new IllegalArgumentException("ConfigBuilder must be not null !!!");
        }
    }

    public void l(Context context) {
        if (this.f20925a != null && (context instanceof Application)) {
            this.f20925a = context;
        } else if (context != null) {
            this.f20925a = context;
        }
    }

    public void m(String str) {
        if (!TextUtils.isEmpty(str)) {
            UrlConfig.f(str);
            vu.g.d().i(c.f21010b);
        }
    }

    public void n(String str) {
        b.x(str);
    }

    public WoodPeckerSDK() {
        this.f20926b = new ArrayList();
    }
}
