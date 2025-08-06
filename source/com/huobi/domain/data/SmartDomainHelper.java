package com.huobi.domain.data;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.hbg.core.bean.SmartDomainData;
import com.huobi.utils.GsonHelper;
import com.huochat.community.network.domain.DomainTool;
import i6.d;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import okhttp3.OkHttpClient;

public final class SmartDomainHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SmartDomainHelper f43843a = new SmartDomainHelper();

    /* renamed from: b  reason: collision with root package name */
    public static SmartDomainData f43844b;

    /* renamed from: c  reason: collision with root package name */
    public static OkHttpClient f43845c;

    /* renamed from: d  reason: collision with root package name */
    public static OkHttpClient f43846d = new OkHttpClient();

    /* renamed from: e  reason: collision with root package name */
    public static final List<String> f43847e = CollectionsKt__CollectionsKt.p("www.google.com", "www.okx-dns1.com", "www.okx-dns2.com", "www.binance.com", "www.mokexapp.com");

    public interface a {
        void a(String str, int i11);

        void onError(String str, int i11, String str2);
    }

    public static final class b extends TypeToken<Map<String, ? extends Set<? extends TestDomainInfo>>> {
    }

    static {
        nj.a aVar = nj.a.f47632a;
        X509TrustManager b11 = aVar.b();
        f43845c = new OkHttpClient.Builder().sslSocketFactory(aVar.c(b11), b11).build();
    }

    public final void d(String str, a aVar) {
        String str2 = DomainTool.DOMAIN_PREFIX + str + "/-/x/pro/netinfo";
        d.c("DOMAIN_TEST", "dmh5检测URL：" + str2);
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new SmartDomainHelper$domainTestDmh5$1(str2, aVar, str, (c<? super SmartDomainHelper$domainTestDmh5$1>) null), 3, (Object) null);
    }

    public final void e(String str, a aVar) {
        String str2 = DomainTool.DOMAIN_PREFIX + str + "/-/x/pro/netinfo";
        d.c("DOMAIN_TEST", "GlobalWeb检测URL：" + str2);
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new SmartDomainHelper$domainTestGlobal$1(str2, aVar, str, (c<? super SmartDomainHelper$domainTestGlobal$1>) null), 3, (Object) null);
    }

    public final void f(String str, a aVar) {
        String str2 = DomainTool.DOMAIN_PREFIX + str + "/-/x/pro/netinfo";
        d.c("DOMAIN_TEST", "Hbdm检测URL：" + str2);
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new SmartDomainHelper$domainTestHbdm$1(str2, aVar, str, (c<? super SmartDomainHelper$domainTestHbdm$1>) null), 3, (Object) null);
    }

    public final void g(String str, a aVar) {
        String str2 = DomainTool.DOMAIN_PREFIX + str + "/-/x/pro/netinfo";
        d.c("DOMAIN_TEST", "KycWeb检测URL：" + str2);
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new SmartDomainHelper$domainTestKycWeb$1(str2, aVar, str, (c<? super SmartDomainHelper$domainTestKycWeb$1>) null), 3, (Object) null);
    }

    public final void h(String str, a aVar) {
        String str2 = StringsKt__StringsJVMKt.G("https://l10n-otc-api.huobi.cn", "l10n-otc-api.huobi.cn", str, false, 4, (Object) null) + "/v1/data/config-list?type=time";
        d.c("DOMAIN_TEST", "OTC检测URL：" + str2);
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new SmartDomainHelper$domainTestOtc$1(str2, aVar, str, (c<? super SmartDomainHelper$domainTestOtc$1>) null), 3, (Object) null);
    }

    public final void i(String str, a aVar) {
        String str2 = StringsKt__StringsJVMKt.G("https://www.huobipro.com", "www.huobipro.com", str, false, 4, (Object) null) + "/-/x/pro/netinfo";
        d.c("DOMAIN_TEST", "Pro检测URL：" + str2);
        n1 unused = i.d(g1.f57277b, (CoroutineContext) null, (CoroutineStart) null, new SmartDomainHelper$domainTestPro$1(str2, aVar, str, (c<? super SmartDomainHelper$domainTestPro$1>) null), 3, (Object) null);
    }

    public final SmartDomainData j() {
        if (f43844b == null) {
            f43844b = com.huobi.domain.c.d();
        }
        if (f43844b == null) {
            f43844b = com.huobi.domain.c.c();
        }
        return f43844b;
    }

    public final Map<String, Set<TestDomainInfo>> k() {
        String d11 = ConfigPreferences.d("user_config", "APP_DOMAIN_TEST_CONFIG");
        if (TextUtils.isEmpty(d11)) {
            return null;
        }
        try {
            return (Map) new Gson().fromJson(d11, new b().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void l(Map<String, ? extends Set<? extends TestDomainInfo>> map) {
        try {
            ConfigPreferences.m("user_config", "APP_DOMAIN_TEST_CONFIG", GsonHelper.a().toJson((Object) map));
        } catch (Exception unused) {
            d.c(ShareConstants.ACTION, "saveAppConfigFile Fail");
        }
    }
}
