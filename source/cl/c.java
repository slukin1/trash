package cl;

import android.os.Build;
import android.text.TextUtils;
import bh.j;
import com.google.gson.Gson;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.core.util.o;
import com.hbg.lib.core.util.w;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.domain.data.source.remote.bean.config.RemoteFlutterFeatureConfig;
import com.huobi.dynamiclangs.util.DynamicStringsHelper;
import com.huobi.flutter.PlatformConfig;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.utils.HBHTtoHTXManager;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.a0;
import com.huobi.utils.x;
import com.huochat.community.network.domain.DomainTool;
import com.huochat.community.util.EncryptTool;
import com.xiaomi.mipush.sdk.Constants;
import gj.d;
import i6.l;
import m6.a;
import tg.r;
import wi.b;

public final class c {

    /* renamed from: i  reason: collision with root package name */
    public static final c f66745i = new c();

    /* renamed from: a  reason: collision with root package name */
    public final String f66746a = Build.MODEL;

    /* renamed from: b  reason: collision with root package name */
    public final int f66747b = Build.VERSION.SDK_INT;

    /* renamed from: c  reason: collision with root package name */
    public String f66748c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66749d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66750e = false;

    /* renamed from: f  reason: collision with root package name */
    public RemoteFlutterFeatureConfig f66751f;

    /* renamed from: g  reason: collision with root package name */
    public RemoteFlutterFeatureConfig f66752g;

    /* renamed from: h  reason: collision with root package name */
    public String f66753h = "";

    public static String a(String str, int i11) {
        String str2;
        String str3;
        String str4;
        PlatformConfig platformConfig = new PlatformConfig();
        platformConfig.setGlobalBaseUrl(DomainTool.DOMAIN_PREFIX + DomainSwitcher.y());
        platformConfig.setProBaseUrl(DomainTool.DOMAIN_PREFIX + DomainSwitcher.O());
        platformConfig.setUcBaseUrl(DomainTool.DOMAIN_PREFIX + DomainSwitcher.Z());
        platformConfig.setGlobalHBUrl(DomainTool.DOMAIN_PREFIX + DomainSwitcher.N());
        String M = DomainSwitcher.M();
        if (!TextUtils.isEmpty(M)) {
            if (!M.endsWith("/")) {
                M = M + "/";
            }
            platformConfig.setGlobalOtcUrl(M);
        }
        platformConfig.setKycUrl(DomainTool.DOMAIN_PREFIX + DomainSwitcher.z());
        platformConfig.setTravelRuleUrl(DomainTool.DOMAIN_PREFIX + DomainSwitcher.Y());
        platformConfig.setGlobalInstUrl(DomainTool.DOMAIN_PREFIX + DomainSwitcher.B());
        String str5 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.t();
        if (!SystemUtils.c()) {
            str5 = b.f48056t;
        }
        platformConfig.setContractH5Url(str5);
        if (SystemUtils.c()) {
            str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.W();
        } else {
            str2 = b.f48045i;
        }
        if (str2.endsWith("/")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        if (SystemUtils.c()) {
            str3 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.x();
        } else {
            str3 = b.f48044h;
        }
        if (str3.endsWith("/")) {
            str3 = str3.substring(0, str3.length() - 1);
        }
        if (SystemUtils.c()) {
            str4 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.Q();
        } else {
            str4 = b.f48060x;
        }
        if (!str4.endsWith("/")) {
            str4 = str4 + "/";
        }
        platformConfig.setSwapBaseUrl(str2);
        platformConfig.setContractBaseUrl(str3);
        platformConfig.setOptionBaseUrl(str2);
        platformConfig.setRiskBaseUrl(str4);
        String str6 = b.f48048l;
        if (SystemUtils.c()) {
            String P = DomainSwitcher.P();
            if (!TextUtils.isEmpty(P)) {
                str6 = str6.replace("l10n-api.huobi.cn", P);
            }
        }
        platformConfig.setProSocketUrl(str6);
        platformConfig.setRouteName(str);
        platformConfig.setInternalStyle(NightHelper.e().g() ? "1" : "0");
        platformConfig.setLanguageEnv(AppLanguageHelper.getInstance().getCurAppLocale().toString().replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (a.k()) {
            platformConfig.setLanguageEnv("dynamic");
            platformConfig.setLanguageEnvHeader(a.f());
            platformConfig.setZendeskLocaleStr(a.j());
            platformConfig.setDynamicStrings(DynamicStringsHelper.b());
        }
        platformConfig.setVersionName("10.54.0");
        platformConfig.setVersionCode(String.valueOf(105400));
        platformConfig.setOnlineNetwork(SystemUtils.c());
        platformConfig.setAndroidStatusBarHeight(i11);
        platformConfig.setUserAgent(l.f());
        platformConfig.setGlobalWebUrl(a0.j());
        platformConfig.setKycWebUrl(a0.m());
        platformConfig.setLite(LiteReHelper.a().b());
        platformConfig.setNormalDisplay(d.n().x());
        platformConfig.setSwitch11Open(d.n().s(11));
        platformConfig.setWebHost(o.f());
        platformConfig.setProToken(r.x().H());
        platformConfig.setUcToken(r.x().I());
        platformConfig.setOtcToken(r.x().E());
        platformConfig.setPhpToken(r.x().G());
        platformConfig.setKycToken(r.x().C());
        platformConfig.setInstToken(r.x().w());
        platformConfig.setDmToken(r.x().q());
        platformConfig.setOtcToken(r.x().E());
        platformConfig.setUuid(PhoneUtils.r());
        platformConfig.setVToken(ku.b.e().h(BaseApplication.b()));
        platformConfig.setInReview(false);
        platformConfig.setRedRise(w.l());
        platformConfig.setGlobalZendeskDomain(ConfigPreferences.e("user_config", "ZENDESK_HUOBI_GLOBAL_DOMAIN", "www.huobi.com.ec"));
        if (!LiteReHelper.a().b() || !LegalCurrencyConfigUtil.y().equalsIgnoreCase("krw")) {
            platformConfig.setCurrencyUnit(LegalCurrencyConfigUtil.y().toUpperCase());
        } else {
            platformConfig.setCurrencyUnit("usd".toUpperCase());
            LegalCurrencyConfigUtil.c0("usd");
        }
        platformConfig.setCurrencyCharacter(LegalCurrencyConfigUtil.w());
        platformConfig.setSubAccount(r.x().X());
        try {
            platformConfig.setProxyHost(PhoneUtils.q(j.c()));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        platformConfig.setChinaUser(x.d());
        if (!TextUtils.isEmpty(r.x().s())) {
            platformConfig.setUid(r.x().s());
        }
        platformConfig.setSwitch27Open(d.n().w());
        x.a();
        platformConfig.setIpCountry(37);
        platformConfig.setHbUcUa(EncryptTool.md5(m0.a()));
        platformConfig.setNewHomepage(HomeHelper.j());
        platformConfig.setIsHtUpgradeState(Boolean.valueOf(HBHTtoHTXManager.f83692a.g()));
        return new Gson().toJson((Object) platformConfig);
    }

    public static c c() {
        return f66745i;
    }

    public String b() {
        return this.f66748c;
    }

    public final boolean d(RemoteFlutterFeatureConfig remoteFlutterFeatureConfig) {
        if (remoteFlutterFeatureConfig == null || !remoteFlutterFeatureConfig.isModuleSwitch() || !r.x().F0() || this.f66753h.equals(r.x().s())) {
            return false;
        }
        this.f66753h = r.x().s();
        return true;
    }

    public void e(RemoteFlutterFeatureConfig remoteFlutterFeatureConfig) {
        boolean z11 = false;
        if (remoteFlutterFeatureConfig == null) {
            remoteFlutterFeatureConfig = new RemoteFlutterFeatureConfig();
            remoteFlutterFeatureConfig.setModuleSwitch(false);
        }
        i6.d.j("flutter", remoteFlutterFeatureConfig.toString());
        this.f66751f = remoteFlutterFeatureConfig;
        this.f66749d = false;
        if (remoteFlutterFeatureConfig.isModuleSwitch()) {
            boolean z12 = this.f66751f.getSupportSdkList() != null && this.f66751f.getSupportSdkList().contains(Integer.valueOf(this.f66747b));
            boolean z13 = this.f66751f.getNoSupportDeviceModelList() != null && !this.f66751f.getNoSupportDeviceModelList().contains(this.f66746a);
            boolean z14 = remoteFlutterFeatureConfig.getMinSupportAppVersion() != 0 && 105400 >= remoteFlutterFeatureConfig.getMinSupportAppVersion();
            i6.d.j("flutter", "flutter config sdk support is " + z12);
            i6.d.j("flutter", "flutter config device model support is " + z13);
            i6.d.j("flutter", "flutter config min support app version " + z14);
            if (z12 && z13 && z14) {
                z11 = true;
            }
            this.f66749d = z11;
        }
        i6.d.j("flutter", "flutter config invite module support is " + this.f66749d);
    }

    public void f(RemoteFlutterFeatureConfig remoteFlutterFeatureConfig) {
        this.f66752g = remoteFlutterFeatureConfig;
    }

    public void g(RemoteFlutterFeatureConfig remoteFlutterFeatureConfig) {
        i6.d.b("FlutterFeatureUtils-->loadVulcanConfig-->config = " + remoteFlutterFeatureConfig);
        boolean z11 = false;
        if (remoteFlutterFeatureConfig == null) {
            remoteFlutterFeatureConfig = new RemoteFlutterFeatureConfig();
            remoteFlutterFeatureConfig.setModuleSwitch(false);
        }
        i6.d.j("flutter", remoteFlutterFeatureConfig.toString());
        this.f66750e = false;
        if (remoteFlutterFeatureConfig.isModuleSwitch()) {
            boolean z12 = remoteFlutterFeatureConfig.getSupportSdkList() != null && remoteFlutterFeatureConfig.getSupportSdkList().contains(Integer.valueOf(this.f66747b));
            boolean z13 = remoteFlutterFeatureConfig.getNoSupportDeviceModelList() != null && !remoteFlutterFeatureConfig.getNoSupportDeviceModelList().contains(this.f66746a);
            boolean z14 = remoteFlutterFeatureConfig.getMinSupportAppVersion() != 0 && 105400 >= remoteFlutterFeatureConfig.getMinSupportAppVersion();
            i6.d.j("flutter", "flutter config sdk support is " + z12);
            i6.d.j("flutter", "flutter config device model support is " + z13);
            i6.d.j("flutter", "flutter config min support app version " + z14);
            if (z12 && z13 && z14) {
                z11 = true;
            }
            this.f66750e = z11;
        }
        i6.d.j("flutter", "flutter config Vulcan module support is " + this.f66750e);
    }

    public void h(String str) {
        if (d(this.f66752g)) {
            dh.c.g(str);
        }
    }

    public void i(String str) {
        this.f66748c = str;
    }
}
