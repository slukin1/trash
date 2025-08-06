package bh;

import android.app.Application;
import android.util.Log;
import com.hbg.lib.core.util.ChannelUtils;
import com.huobi.app.NetworkMonitorInterceptor;
import com.huobi.webcache.OnlyCacheWebView;
import com.huobi.woodpecker.HBOkHttpDNS;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.WoodpeckerEventListenerInterceptor;
import com.huobi.woodpecker.WoodpeckerInterceptor;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.huobi.woodpecker.core.ActionType;
import com.huochat.community.network.domain.DomainTool;
import i6.d;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import tg.r;
import wi.b;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static String f40755a = "open.woodpeckerlog.com";

    /* renamed from: b  reason: collision with root package name */
    public static final EventListener.Factory f40756b = new a();

    public class a implements EventListener.Factory {
        public EventListener create(Call call) {
            if (!ActionType.API.isEnable() || call == null) {
                return EventListener.NONE;
            }
            HttpUrl url = call.request().url();
            if (!url.toString().contains("/-/x/otc/file")) {
                return new com.huobi.woodpecker.a(url, call);
            }
            return com.huobi.woodpecker.a.f20946s.create(call);
        }
    }

    public static void a(OkHttpClient.Builder builder) {
        HBOkHttpDNS.e().o("sg");
        builder.addInterceptor(new WoodpeckerInterceptor()).addNetworkInterceptor(new WoodpeckerEventListenerInterceptor()).addInterceptor(new NetworkMonitorInterceptor()).dns(HBOkHttpDNS.e()).eventListenerFactory(com.huobi.woodpecker.a.f20946s);
    }

    public static void b(OkHttpClient.Builder builder) {
        HBOkHttpDNS.e().o("sg");
        builder.addInterceptor(new WoodpeckerInterceptor()).addNetworkInterceptor(new WoodpeckerEventListenerInterceptor()).dns(HBOkHttpDNS.e()).eventListenerFactory(f40756b);
    }

    public static void c(Application application) {
        String str = b.A + "/open/v1/log/profile/get";
        d.b("WoodPeckerHelper-->init-->" + str);
        WoodPeckerSDK.j().e(false).d(1).i(ChannelUtils.a()).h(vu.b.b(application)).a("10.54.0").f(b.B).g(str).b(application);
        WoodPeckerWebViewAspect.c(OnlyCacheWebView.class);
    }

    public static void d() {
        Log.d("WoodPeckerHelper", "设置啄木鸟UUID：" + r.x().Q());
        WoodPeckerSDK.f().n(r.x().Q());
    }

    public static void e() {
        Log.d("WoodPeckerHelper", "清空啄木鸟UUID");
        WoodPeckerSDK.f().n((String) null);
    }

    public static void f() {
        String str = DomainTool.DOMAIN_PREFIX + f40755a + "/-/x/woodpecker" + "/open/v1/log/profile/get";
        d.b("WoodPeckerHelper-->resetDomain-->" + str);
        WoodPeckerSDK.f().m(str);
    }

    public static void g(String str) {
        d.b("WoodPeckerHelper-->setBaseUrl-->" + str);
        f40755a = str;
        f();
    }
}
