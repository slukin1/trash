package com.huobi.domain;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.common.utils.crypt.rsa.RSAProvider;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.AppContentConfig;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.bean.SmartDomainData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.app.H5CacheServiceHelper;
import com.huobi.app.HbMgtConfigHelper;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.api.DomainService;
import com.huobi.domain.data.DomainInfo;
import com.huobi.domain.data.SmartDomainHelper;
import com.huobi.domain.data.TestDomainInfo;
import com.huobi.domain.data.source.DomainRepository;
import com.huobi.domain.data.source.cache.DomainCacheDataSource;
import com.huobi.domain.data.source.remote.bean.SmartDomain;
import com.huobi.domain.data.source.remote.bean.config.SmartRemoteDefaultConfig;
import com.huobi.utils.HBHTtoHTXManager;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.c1;
import com.huobi.utils.d1;
import com.huobi.utils.w;
import com.huobi.vulcan.model.VulcanInfo;
import com.huochat.community.network.domain.DomainTool;
import com.jumio.sdk.reject.JumioRejectReason;
import com.xiaomi.mipush.sdk.Constants;
import i6.l;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import tq.p;
import wn.c0;

public final class DomainSwitcher {
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static Set<String> H;
    public static Map<String, Set<TestDomainInfo>> I;
    public static Map<String, String> J = new HashMap();
    public static long K;
    public static long L = 300000;
    public static boolean M;

    /* renamed from: g  reason: collision with root package name */
    public static final DomainSwitcher f43775g = new DomainSwitcher();

    /* renamed from: h  reason: collision with root package name */
    public static String f43776h;

    /* renamed from: i  reason: collision with root package name */
    public static String f43777i;

    /* renamed from: j  reason: collision with root package name */
    public static String f43778j;

    /* renamed from: k  reason: collision with root package name */
    public static String f43779k;

    /* renamed from: l  reason: collision with root package name */
    public static String f43780l;

    /* renamed from: m  reason: collision with root package name */
    public static String f43781m;

    /* renamed from: n  reason: collision with root package name */
    public static String f43782n;

    /* renamed from: o  reason: collision with root package name */
    public static String f43783o;

    /* renamed from: p  reason: collision with root package name */
    public static String f43784p;

    /* renamed from: q  reason: collision with root package name */
    public static String f43785q;

    /* renamed from: r  reason: collision with root package name */
    public static String f43786r;

    /* renamed from: s  reason: collision with root package name */
    public static String f43787s;

    /* renamed from: t  reason: collision with root package name */
    public static String f43788t;

    /* renamed from: u  reason: collision with root package name */
    public static String f43789u;

    /* renamed from: v  reason: collision with root package name */
    public static String f43790v;

    /* renamed from: w  reason: collision with root package name */
    public static String f43791w;

    /* renamed from: x  reason: collision with root package name */
    public static String f43792x;

    /* renamed from: y  reason: collision with root package name */
    public static String f43793y;

    /* renamed from: z  reason: collision with root package name */
    public static String f43794z;

    /* renamed from: a  reason: collision with root package name */
    public final DomainRepository f43795a = new DomainRepository();

    /* renamed from: b  reason: collision with root package name */
    public long f43796b;

    /* renamed from: c  reason: collision with root package name */
    public DomainInfo f43797c;

    /* renamed from: d  reason: collision with root package name */
    public SmartDomain f43798d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Integer> f43799e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public int f43800f = 3;

    public enum DomainModuleKey {
        DMK_INSTITUTION("institution"),
        DMK_KYCWEB("kycWeb"),
        DMK_GLOBALWEB("globalWeb"),
        DMK_GLOBALMOBILE("globalMobile"),
        DMK_CONTRACT("contract"),
        DMK_INDEX("index"),
        DMK_SPOT(RankScreenBean.SCREEN_VALUE_SPOT),
        DMK_DMH5("dmH5"),
        DMK_OTC("otc");
        
        public String key;

        private DomainModuleKey(String str) {
            this.key = str;
        }
    }

    public static class DomainUpdateEvent {
    }

    public static class TestErrorAction<T> implements Action1<T> {
        public void call(T t11) {
        }
    }

    public class a implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43801a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43802b;

        public a(AtomicBoolean atomicBoolean, TestDomainInfo testDomainInfo) {
            this.f43801a = atomicBoolean;
            this.f43802b = testDomainInfo;
        }

        public void a(String str, int i11) {
            if (this.f43801a.compareAndSet(false, true)) {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmIndexDomain 成功：" + str);
                DomainSwitcher.m0(str);
            } else {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmIndexDomain 成功：不再设置" + str);
            }
            TestDomainInfo testDomainInfo = this.f43802b;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_INDEX.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testDmIndexDomain 失败, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_INDEX.key, this.f43802b, str2, i11);
        }
    }

    public class b implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43804b;

        public b(AtomicBoolean atomicBoolean, TestDomainInfo testDomainInfo) {
            this.f43803a = atomicBoolean;
            this.f43804b = testDomainInfo;
        }

        public void a(String str, int i11) {
            if (this.f43803a.compareAndSet(false, true)) {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testSpotDomain 成功：" + str);
                DomainSwitcher.l0(str);
            } else {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testSpotDomain 成功：不再设置" + str);
            }
            TestDomainInfo testDomainInfo = this.f43804b;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_SPOT.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testSpotDomain 失败, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_SPOT.key, this.f43804b, str2, i11);
        }
    }

    public class c implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43805a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43806b;

        public c(AtomicBoolean atomicBoolean, TestDomainInfo testDomainInfo) {
            this.f43805a = atomicBoolean;
            this.f43806b = testDomainInfo;
        }

        public void a(String str, int i11) {
            if (this.f43805a.compareAndSet(false, true)) {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testContractDomain 成功：" + str);
                DomainSwitcher.q0(str);
                DomainSwitcher.G0(str);
            } else {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testContractDomain 成功 无需设置：" + str);
            }
            TestDomainInfo testDomainInfo = this.f43806b;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_CONTRACT.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testContractDomain 失败, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_CONTRACT.key, this.f43806b, str2, i11);
        }
    }

    public class d implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43807a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43808b;

        public d(AtomicBoolean atomicBoolean, TestDomainInfo testDomainInfo) {
            this.f43807a = atomicBoolean;
            this.f43808b = testDomainInfo;
        }

        public void a(String str, int i11) {
            if (this.f43807a.compareAndSet(false, true)) {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmh5Domain 成功：" + str);
                DomainSwitcher.r0(str);
            } else {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmh5Domain 成功 无需设置：" + str);
            }
            TestDomainInfo testDomainInfo = this.f43808b;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_DMH5.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testDmh5Domain 失败, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_DMH5.key, this.f43808b, str2, i11);
        }
    }

    public class e implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43809a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43810b;

        public e(AtomicBoolean atomicBoolean, TestDomainInfo testDomainInfo) {
            this.f43809a = atomicBoolean;
            this.f43810b = testDomainInfo;
        }

        public void a(String str, int i11) {
            if (this.f43809a.compareAndSet(false, true)) {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testOtcDomain 成功：" + str);
                DomainSwitcher.A0(str);
            } else {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testOtcDomain 成功 无需设置：" + str);
            }
            TestDomainInfo testDomainInfo = this.f43810b;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_OTC.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testOtcDomain 失败, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_OTC.key, this.f43810b, str2, i11);
        }
    }

    public class f extends Subscriber<Long> {
        public f() {
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Long l11) {
            DomainSwitcher.this.V0();
        }
    }

    public class g implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43812a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43813b;

        public g(TestDomainInfo testDomainInfo, AtomicBoolean atomicBoolean) {
            this.f43812a = testDomainInfo;
            this.f43813b = atomicBoolean;
        }

        public void a(String str, int i11) {
            synchronized (this.f43812a) {
                if (this.f43813b.compareAndSet(false, true)) {
                    LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testGlobalWebDomain 成功：" + str);
                    DomainSwitcher.o0(str);
                } else {
                    LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testGlobalWebDomain 成功 无需设置：" + str);
                }
            }
            TestDomainInfo testDomainInfo = this.f43812a;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_GLOBALWEB.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testGlobalWebDomain 失败, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_GLOBALWEB.key, this.f43812a, str2, i11);
        }
    }

    public class h implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43815b;

        public h(AtomicBoolean atomicBoolean, TestDomainInfo testDomainInfo) {
            this.f43814a = atomicBoolean;
            this.f43815b = testDomainInfo;
        }

        public void a(String str, int i11) {
            if (this.f43814a.compareAndSet(false, true)) {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testKycWebDomain 成功：" + str);
                DomainSwitcher.w0(str);
            } else {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testKycWebDomain 成功 已设置，不再设置：" + str);
            }
            TestDomainInfo testDomainInfo = this.f43815b;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_KYCWEB.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testKycWebDomain 失败, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_KYCWEB.key, this.f43815b, str2, i11);
        }
    }

    public class i extends BaseSubscriber<Pair<String, String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43816b;

        public i(String str) {
            this.f43816b = str;
        }

        /* renamed from: a */
        public void onNext(Pair<String, String> pair) {
            super.onNext(pair);
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：ZendeskUrlDomain 成功：" + ((String) pair.first));
            c1.A(this.f43816b, (String) pair.first);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：ZendeskUrlDomain 失败：" + th2);
        }
    }

    public class j implements SmartDomainHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f43817a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TestDomainInfo f43818b;

        public j(AtomicBoolean atomicBoolean, TestDomainInfo testDomainInfo) {
            this.f43817a = atomicBoolean;
            this.f43818b = testDomainInfo;
        }

        public void a(String str, int i11) {
            if (this.f43817a.compareAndSet(false, true)) {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testGlobalMDomain 成功：" + str);
                DomainSwitcher.z0(str);
            } else {
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testGlobalMDomain 成功 无需设置：" + str);
            }
            TestDomainInfo testDomainInfo = this.f43818b;
            testDomainInfo.isTestOk = true;
            DomainSwitcher.g0(DomainModuleKey.DMK_GLOBALMOBILE.key, testDomainInfo, i11);
        }

        public void onError(String str, int i11, String str2) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "域名检测：testGlobalMDomain 失败：, code: " + i11 + " message:" + str2);
            DomainSwitcher.h0(DomainModuleKey.DMK_GLOBALMOBILE.key, this.f43818b, str2, i11);
        }
    }

    public class k extends BaseSubscriber<DomainInfo> {
        public k() {
        }

        /* renamed from: a */
        public void onNext(DomainInfo domainInfo) {
            super.onNext(domainInfo);
            DomainSwitcher.this.U0(domainInfo);
            if (DomainSwitcher.K != 0) {
                LogAndWoodRecorder.b("DOMAIN_TEST", "启动域名检测失败，正在检测中:" + DomainSwitcher.H);
                return;
            }
            if (domainInfo != null) {
                DomainInfo unused = DomainSwitcher.this.f43797c = domainInfo;
            } else {
                DomainInfo unused2 = DomainSwitcher.this.f43797c = DomainCacheDataSource.a();
                if (DomainSwitcher.this.f43797c == null) {
                    DomainInfo unused3 = DomainSwitcher.this.f43797c = AppDomainConfigUtils.j(c.e("domain.json"), c.c());
                }
            }
            LogAndWoodRecorder.a("DOMAIN_TEST", "更新remote domain正常流程，启动域名检测");
            long unused4 = DomainSwitcher.K = System.currentTimeMillis();
            Set unused5 = DomainSwitcher.H = new HashSet();
            DomainSwitcher.H.addAll(domainInfo.k());
            DomainSwitcher.H.addAll(domainInfo.j());
            DomainSwitcher.H.addAll(domainInfo.m());
            DomainSwitcher.H.addAll(domainInfo.l());
            DomainSwitcher.H.addAll(domainInfo.o());
            DomainSwitcher.H.addAll(domainInfo.g());
            DomainSwitcher.H.addAll(domainInfo.h());
            DomainSwitcher.H.addAll(domainInfo.n());
            LogAndWoodRecorder.a("DOMAIN_TEST", "域名检测集合：" + DomainSwitcher.H);
            DomainSwitcher.I.clear();
            DomainSwitcher.P0(domainInfo);
            DomainSwitcher.O0(domainInfo);
            DomainSwitcher.Q0(domainInfo);
            DomainSwitcher.M0(domainInfo);
            DomainSwitcher.S0(domainInfo);
            DomainSwitcher.L0(domainInfo);
            DomainSwitcher.N0(domainInfo);
            DomainSwitcher.R0(domainInfo);
            po.a.a();
            gj.b.j().w();
            qu.d.i().t();
        }

        public void onAfter() {
            super.onAfter();
            LogAndWoodRecorder.a("DOMAIN_TEST", "remote domain更新后，开始初始化" + this);
            HomeHelper.g();
            gj.d.n().I();
            gj.g.e().h();
            qu.d.i().t();
            is.a.h();
            is.a.v();
            HbMgtConfigHelper.a();
            H5CacheServiceHelper.init();
            uh.i.d().l();
            uh.i.d().m();
            w.d().f();
            LegalCurrencyConfigUtil.b0();
            c0.k();
            HBHTtoHTXManager.f83692a.c();
            qu.a.a();
            po.a.e();
            sn.w.j().h((u6.g) null).subscribe(new BaseSubscriber());
        }
    }

    public DomainSwitcher() {
        a0();
    }

    public static DomainSwitcher A() {
        return f43775g;
    }

    public static void A0(String str) {
        f43783o = str;
    }

    public static String B() {
        return f43788t;
    }

    public static void B0(String str) {
        f43779k = str;
    }

    public static String C() {
        return A;
    }

    public static void C0(String str) {
        f43777i = str;
        LogAndWoodRecorder.c("DOMAIN_TEST", "pro domain = " + str);
    }

    public static String D() {
        return B;
    }

    public static void D0(String str) {
        f43784p = str;
    }

    public static String E() {
        return C;
    }

    public static void E0(String str) {
        f43781m = str;
    }

    public static String F() {
        return D;
    }

    public static String G() {
        return G;
    }

    public static void G0(String str) {
        f43787s = str;
        LogAndWoodRecorder.c("DOMAIN_TEST", "swap domain = " + f43787s);
    }

    public static String H() {
        return f43794z;
    }

    public static void H0(String str) {
        k0(str);
        C0(str + "/-/x/pro/");
        n0(str + "/-/x/etf/");
        D0(str + "/-/s/pro");
        J0(str + "/-/x/uc/");
        B0(str + "/-/x/hb/");
        s0(str + "/-/x/hbg/");
        t0(str + "/-/x/huobi-kyc/");
        y0(str + "/-/x/");
        x0(str + "/-/x/mp-content/");
        E0(str + "/-/x/rca/");
        I0(str + "/-/x/travelrule/");
    }

    public static String I() {
        return f43793y;
    }

    public static void I0(String str) {
        f43792x = str;
    }

    public static String J() {
        return E;
    }

    public static void J0(String str) {
        f43778j = str;
    }

    public static String K() {
        String str = wi.b.f48047k;
        if (!SystemUtils.c()) {
            return str;
        }
        String J2 = J();
        return !TextUtils.isEmpty(J2) ? str.replace("m.huobi.com", J2) : str;
    }

    public static void L0(DomainInfo domainInfo) {
        if (domainInfo == null) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testContractDomain domainInfo is null");
            return;
        }
        LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testContractDomain - " + domainInfo.g());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (String next : domainInfo.g()) {
            TestDomainInfo testDomainInfo = new TestDomainInfo();
            testDomainInfo.host = next;
            SmartDomainHelper.f43843a.f(next, new c(atomicBoolean, testDomainInfo));
        }
    }

    public static String M() {
        String str;
        if (SystemUtils.c()) {
            str = f43783o + "/-/x/otc/";
        } else {
            str = wi.b.f48042f;
        }
        if (str.startsWith("http")) {
            return str;
        }
        return DomainTool.DOMAIN_PREFIX + str;
    }

    public static void M0(DomainInfo domainInfo) {
        if (domainInfo == null) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmIndexDomain domainInfo is null");
            return;
        }
        LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmIndexDomain - " + domainInfo.l());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (String next : domainInfo.l()) {
            TestDomainInfo testDomainInfo = new TestDomainInfo();
            testDomainInfo.host = next;
            SmartDomainHelper.f43843a.f(next, new a(atomicBoolean, testDomainInfo));
        }
    }

    public static String N() {
        return f43779k;
    }

    public static void N0(DomainInfo domainInfo) {
        if (domainInfo == null) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmh5Domain domainInfo is null");
            return;
        }
        LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testDmh5Domain - " + domainInfo.g());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (String next : domainInfo.h()) {
            TestDomainInfo testDomainInfo = new TestDomainInfo();
            testDomainInfo.host = next;
            SmartDomainHelper.f43843a.d(next, new d(atomicBoolean, testDomainInfo));
        }
    }

    public static String O() {
        return f43777i;
    }

    public static void O0(DomainInfo domainInfo) {
        if (domainInfo == null) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testGlobalMDomain domainInfo is null");
            return;
        }
        LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testGlobalMDomain - " + domainInfo.j());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (String next : domainInfo.j()) {
            TestDomainInfo testDomainInfo = new TestDomainInfo();
            testDomainInfo.host = next;
            SmartDomainHelper.f43843a.e(next, new j(atomicBoolean, testDomainInfo));
        }
    }

    public static String P() {
        return f43784p;
    }

    public static void P0(DomainInfo domainInfo) {
        if (domainInfo != null && domainInfo.k() != null) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：GlobalWebDomain - " + domainInfo.k());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (String next : domainInfo.k()) {
                TestDomainInfo testDomainInfo = new TestDomainInfo();
                testDomainInfo.host = next;
                SmartDomainHelper.f43843a.e(next, new g(testDomainInfo, atomicBoolean));
            }
        }
    }

    public static String Q() {
        return f43781m;
    }

    public static void Q0(DomainInfo domainInfo) {
        if (domainInfo != null && domainInfo.m() != null && !domainInfo.m().isEmpty()) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：KycWebDomain - " + domainInfo.m());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (String next : domainInfo.m()) {
                TestDomainInfo testDomainInfo = new TestDomainInfo();
                testDomainInfo.host = next;
                SmartDomainHelper.f43843a.g(next, new h(atomicBoolean, testDomainInfo));
            }
        }
    }

    public static String R() {
        AppContentConfig n11 = gj.b.j().n();
        return (n11 == null || TextUtils.isEmpty(n11.getShareCn())) ? "" : n11.getShareCn();
    }

    public static void R0(DomainInfo domainInfo) {
        if (domainInfo == null) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testOtcDomain domainInfo is null");
            return;
        }
        LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testOtcDomain - " + domainInfo.n());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (String next : domainInfo.n()) {
            TestDomainInfo testDomainInfo = new TestDomainInfo();
            testDomainInfo.host = next;
            SmartDomainHelper.f43843a.h(next, new e(atomicBoolean, testDomainInfo));
        }
    }

    public static String S() {
        AppContentConfig n11 = gj.b.j().n();
        return (n11 == null || TextUtils.isEmpty(n11.getShareEn())) ? "" : n11.getShareEn();
    }

    public static void S0(DomainInfo domainInfo) {
        if (domainInfo != null) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：testSpotDomain - " + domainInfo.o());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (String next : domainInfo.o()) {
                TestDomainInfo testDomainInfo = new TestDomainInfo();
                testDomainInfo.host = next;
                SmartDomainHelper.f43843a.i(next, new b(atomicBoolean, testDomainInfo));
            }
        }
    }

    public static String T() {
        AppContentConfig n11 = gj.b.j().n();
        return (n11 == null || TextUtils.isEmpty(n11.getShareOverseaCn())) ? "" : n11.getShareOverseaCn();
    }

    public static void T0(String str, List<String> list) {
        LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：ZendeskUrlDomain - " + list);
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                String str2 = list.get(0);
                LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：ZendeskUrlDomain url(only one) = " + str2);
                c1.A(str, str2);
                return;
            }
            LogAndWoodRecorder.c("DOMAIN_TEST", "域名检测：ZendeskUrlDomain " + list);
            Observable.from(list).flatMap(h.f43856b).takeFirst(g.f43855b).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(str));
        }
    }

    public static String U() {
        AppContentConfig n11 = gj.b.j().n();
        return (n11 == null || TextUtils.isEmpty(n11.getShareOverseaEn())) ? "" : n11.getShareOverseaEn();
    }

    public static String W() {
        return f43787s;
    }

    public static Observable<Pair<String, String>> W0(String str) {
        return ((DomainService) p.z(DomainService.class)).zendeskDomainTest(DomainTool.DOMAIN_PREFIX + str + "/hc/" + d1.h()).map(new f(str)).onErrorReturn(new e(str)).observeOn(Schedulers.io()).subscribeOn(Schedulers.io());
    }

    public static String X(String str, String str2) {
        i6.k.d("DOMAIN_TEST", "getTestDomainHost " + str + " " + str2);
        Set<TestDomainInfo> set = I.get(str);
        if (set == null) {
            i6.k.d("DOMAIN_TEST", "getTestDomainHost null return default " + str2);
            return str2;
        }
        for (TestDomainInfo testDomainInfo : set) {
            if (testDomainInfo != null && !TextUtils.isEmpty(testDomainInfo.host)) {
                i6.k.d("DOMAIN_TEST", "getTestDomainHost return test domain " + testDomainInfo.host);
                return testDomainInfo.host;
            }
        }
        i6.k.d("DOMAIN_TEST", "getTestDomainHost return default " + str2);
        return str2;
    }

    public static String Y() {
        return f43792x;
    }

    public static String Z() {
        return f43778j;
    }

    public static void a0() {
        SmartDomainHelper smartDomainHelper = SmartDomainHelper.f43843a;
        SmartDomainData j11 = smartDomainHelper.j();
        Map<String, Set<TestDomainInfo>> k11 = smartDomainHelper.k();
        I = k11;
        if (k11 == null) {
            I = new HashMap();
        }
        try {
            l0(X(DomainModuleKey.DMK_SPOT.key, j11.spot.get(0).url));
            z0(X(DomainModuleKey.DMK_GLOBALMOBILE.key, j11.globalMobile.get(0).url));
            o0(X(DomainModuleKey.DMK_GLOBALWEB.key, j11.globalWeb.get(0).url));
            w0(X(DomainModuleKey.DMK_KYCWEB.key, j11.kycWeb.get(0).url));
            DomainModuleKey domainModuleKey = DomainModuleKey.DMK_CONTRACT;
            q0(X(domainModuleKey.key, j11.contract.get(0).url));
            G0(X(domainModuleKey.key, j11.contract.get(0).url));
            m0(X(DomainModuleKey.DMK_INDEX.key, j11.index.get(0).url));
            u0(j11.institution.get(0).url);
            r0(X(DomainModuleKey.DMK_DMH5.key, j11.dmH5.get(0).url));
            A0(X(DomainModuleKey.DMK_OTC.key, j11.otc.get(0).url));
            LogAndWoodRecorder.a("DOMAIN_TEST", "初始化默认域名成功：");
        } catch (Exception e11) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "初始化默认域名失败：" + e11);
            b0();
            e11.printStackTrace();
        }
    }

    public static void b0() {
        DomainInfo a11 = DomainCacheDataSource.a();
        if (a11 == null || a11.f() == null) {
            DomainInfo j11 = AppDomainConfigUtils.j(c.e("domain.json"), c.c());
            if (!(j11 == null || j11.f() == null)) {
                SmartRemoteDefaultConfig f11 = j11.f();
                l0(f11.getSpotDefault());
                z0(f11.getGlobalMobileDefault());
                o0(f11.getGlobalWebDefault());
                w0(f11.getKycWebDefault());
                q0(f11.getContractDefault());
                G0(f11.getContractDefault());
                m0(f11.getDmIndexDefault());
                u0(f11.getInstitutionDefault());
                r0(f11.getContractH5Default());
                A0(f11.getOtcDefault());
            }
            if (j11 != null) {
                v0(j11);
                return;
            }
            return;
        }
        SmartRemoteDefaultConfig f12 = a11.f();
        if (!TextUtils.isEmpty(f12.getSpotDefault())) {
            l0(f12.getSpotDefault());
        }
        if (!TextUtils.isEmpty(f12.getGlobalMobileDefault())) {
            z0(f12.getGlobalMobileDefault());
        }
        if (!TextUtils.isEmpty(f12.getGlobalWebDefault())) {
            o0(f12.getGlobalWebDefault());
        }
        if (!TextUtils.isEmpty(f12.getKycWebDefault())) {
            w0(f12.getKycWebDefault());
        }
        if (!TextUtils.isEmpty(f12.getContractDefault())) {
            q0(f12.getContractDefault());
            G0(f12.getContractDefault());
        }
        if (!TextUtils.isEmpty(f12.getDmIndexDefault())) {
            m0(f12.getDmIndexDefault());
        }
        if (!TextUtils.isEmpty(f12.getInstitutionDefault())) {
            u0(f12.getInstitutionDefault());
        }
        if (!TextUtils.isEmpty(f12.getContractH5Default())) {
            r0(f12.getContractH5Default());
        }
        if (!TextUtils.isEmpty(f12.getOtcDefault())) {
            A0(f12.getOtcDefault());
        }
    }

    public static /* synthetic */ Boolean c0(Pair pair) {
        return Boolean.valueOf(!TextUtils.isEmpty((CharSequence) pair.second) && !"-1".equals(pair.second));
    }

    public static /* synthetic */ Pair d0(String str, Response response) {
        if (response.code() == 200) {
            return new Pair(str, JumioRejectReason.NOT_READABLE);
        }
        return new Pair(str, "-1");
    }

    public static void f0(String str, String str2) {
        if (J != null && !TextUtils.isEmpty(str)) {
            J.put(str, str2);
        }
    }

    public static synchronized void g0(String str, TestDomainInfo testDomainInfo, int i11) {
        synchronized (DomainSwitcher.class) {
            h0(str, testDomainInfo, "", i11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void h0(java.lang.String r5, com.huobi.domain.data.TestDomainInfo r6, java.lang.String r7, int r8) {
        /*
            java.lang.Class<com.huobi.domain.DomainSwitcher> r0 = com.huobi.domain.DomainSwitcher.class
            monitor-enter(r0)
            if (r6 == 0) goto L_0x00c8
            java.lang.String r1 = r6.host     // Catch:{ all -> 0x00c5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x00c8
            java.util.Map<java.lang.String, java.util.Set<com.huobi.domain.data.TestDomainInfo>> r1 = I     // Catch:{ all -> 0x00c5 }
            if (r1 == 0) goto L_0x00c8
            java.util.Set<java.lang.String> r1 = H     // Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x0017
            goto L_0x00c8
        L_0x0017:
            java.lang.String r2 = r6.host     // Catch:{ all -> 0x00c5 }
            r1.remove(r2)     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = "DOMAIN_TEST"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
            r2.<init>()     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = "检测单一域名完成并移除："
            r2.append(r3)     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x00c5 }
            r2.append(r3)     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = "，域名检测集合："
            r2.append(r3)     // Catch:{ all -> 0x00c5 }
            java.util.Set<java.lang.String> r3 = H     // Catch:{ all -> 0x00c5 }
            r2.append(r3)     // Catch:{ all -> 0x00c5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c5 }
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r1, r2)     // Catch:{ all -> 0x00c5 }
            boolean r1 = r6.isTestOk     // Catch:{ all -> 0x00c5 }
            if (r1 == 0) goto L_0x006d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00c5 }
            long r3 = K     // Catch:{ all -> 0x00c5 }
            long r1 = r1 - r3
            r6.testTime = r1     // Catch:{ all -> 0x00c5 }
            java.util.Map<java.lang.String, java.util.Set<com.huobi.domain.data.TestDomainInfo>> r1 = I     // Catch:{ all -> 0x00c5 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x005d
            java.util.Map<java.lang.String, java.util.Set<com.huobi.domain.data.TestDomainInfo>> r1 = I     // Catch:{ all -> 0x00c5 }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x00c5 }
            r2.<init>()     // Catch:{ all -> 0x00c5 }
            r1.put(r5, r2)     // Catch:{ all -> 0x00c5 }
        L_0x005d:
            java.util.Map<java.lang.String, java.util.Set<com.huobi.domain.data.TestDomainInfo>> r1 = I     // Catch:{ all -> 0x00c5 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00c5 }
            java.util.Set r1 = (java.util.Set) r1     // Catch:{ all -> 0x00c5 }
            r1.add(r6)     // Catch:{ all -> 0x00c5 }
            java.util.Map<java.lang.String, java.util.Set<com.huobi.domain.data.TestDomainInfo>> r2 = I     // Catch:{ all -> 0x00c5 }
            r2.put(r5, r1)     // Catch:{ all -> 0x00c5 }
        L_0x006d:
            java.lang.String r5 = r6.host     // Catch:{ all -> 0x00c5 }
            long r1 = r6.testTime     // Catch:{ all -> 0x00c5 }
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r1 = -1
        L_0x007a:
            j0(r5, r1, r7, r8)     // Catch:{ all -> 0x00c5 }
            java.util.Set<java.lang.String> r5 = H     // Catch:{ all -> 0x00c5 }
            if (r5 == 0) goto L_0x00c3
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x00c5 }
            if (r5 == 0) goto L_0x00c3
            dh.g r5 = dh.g.d()     // Catch:{ all -> 0x00c5 }
            r5.g()     // Catch:{ all -> 0x00c5 }
            java.util.Map<java.lang.String, retrofit2.Retrofit> r5 = tq.p.f84888a     // Catch:{ all -> 0x00c5 }
            r5.clear()     // Catch:{ all -> 0x00c5 }
            r5 = 0
            H = r5     // Catch:{ all -> 0x00c5 }
            K = r3     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = "DOMAIN_TEST"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
            r6.<init>()     // Catch:{ all -> 0x00c5 }
            java.lang.String r7 = "域名检测完成，重新初始化网络请求，保存检测结果:"
            r6.append(r7)     // Catch:{ all -> 0x00c5 }
            java.util.Map<java.lang.String, java.util.Set<com.huobi.domain.data.TestDomainInfo>> r7 = I     // Catch:{ all -> 0x00c5 }
            r6.append(r7)     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c5 }
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r5, r6)     // Catch:{ all -> 0x00c5 }
            com.huobi.domain.data.SmartDomainHelper r5 = com.huobi.domain.data.SmartDomainHelper.f43843a     // Catch:{ all -> 0x00c5 }
            java.util.Map<java.lang.String, java.util.Set<com.huobi.domain.data.TestDomainInfo>> r6 = I     // Catch:{ all -> 0x00c5 }
            r5.l(r6)     // Catch:{ all -> 0x00c5 }
            org.greenrobot.eventbus.EventBus r5 = org.greenrobot.eventbus.EventBus.d()     // Catch:{ all -> 0x00c5 }
            com.huobi.domain.DomainSwitcher$DomainUpdateEvent r6 = new com.huobi.domain.DomainSwitcher$DomainUpdateEvent     // Catch:{ all -> 0x00c5 }
            r6.<init>()     // Catch:{ all -> 0x00c5 }
            r5.k(r6)     // Catch:{ all -> 0x00c5 }
        L_0x00c3:
            monitor-exit(r0)
            return
        L_0x00c5:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        L_0x00c8:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.domain.DomainSwitcher.h0(java.lang.String, com.huobi.domain.data.TestDomainInfo, java.lang.String, int):void");
    }

    public static SmartDomainData i0(String str) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        b2.a.d().a("/debug/mock_manager").navigation();
        SmartDomainData smartDomainData = null;
        try {
            String string = builder.build().newCall(new Request.Builder().url(str).build()).execute().body().string();
            LogAndWoodRecorder.a("DOMAIN_TEST", "请求域名url security 成功：" + string);
            HbgIntCodeResponse hbgIntCodeResponse = (HbgIntCodeResponse) new Gson().fromJson(string, new TypeToken<HbgIntCodeResponse<String>>() {
            }.getType());
            if (hbgIntCodeResponse.getCode() == 200) {
                String str2 = (String) hbgIntCodeResponse.getData();
                if (str2 == null) {
                    return null;
                }
                String str3 = new String(RSAProvider.b(Base64.decode(str2.getBytes(StandardCharsets.UTF_8), 0), "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAImAK6FIF+4UAxQmURJ4yJcnyerbOV7/MEJRg1vZvXWSqubYK/coJiwcn0DL62TZr9JPqR0dGunCYbkaUuNgcuGh0YZU2kuSWYP5hx6MOSVwDzS9McuuADDcKkgBte9u1nIdQZRN/Um3wYGXRtgg/FMZlBExvcgJIZXaVefx2nXTAgMBAAECgYBKoD6NxSP/uerF19nubZFowFaNWbf0gAnAJJ9njXCPTC/nI/IQrUCydkJUl5hFXwRW35dITtCZiD8jiE7uSx1t3oUwe0KiDcvpilm/2LFbw0P3dnnFt6WRM4s98mISbeBHxawrq0hn3YlkNMwVY6ze6D2egSMJSr9+QGHynwES6QJBAL9Dm2/hTclXtHa8RjxY+7N6wE9PF7jHn8G+B/UN6KleaWDzknR/sXw9Q6zQ3JIadFiyX2J6HNy0yUzhAQgdOo0CQQC4CiR/imGdlDU/70w6a0h8cmgL9wMlgz1a2YXfeMGONdQyHgye4fPTUdkub+R05ByKkTHhN7fT8XWTCHmYC4nfAkEApL0WpMbquQFR7vM7i78ZDP4tpiH5zK4kbDvBntDcFQW8vkUNYEqcFOav46oCUdV3YO5COg/zzCXrPMyQluyWAQJAVYAoyrQQe7PyNTzITk+vQlmoav6cEJ5zL7TlFBg23Am4BnydYmcY7vEUlBVZrtCXTez8nmRTW/zOobuLOg8KQwJBALpTq+kdbyPt5IzL/kbA44cgAzg7so8I/P/cf/LbXoblLSzbEx5ryUGhKheTHLROo+xZj5llMbdJgZmF+gBdWbc="), StandardCharsets.UTF_8);
                SmartDomainData smartDomainData2 = (SmartDomainData) new Gson().fromJson(str3, SmartDomainData.class);
                if (smartDomainData2 != null) {
                    try {
                        LogAndWoodRecorder.a("DOMAIN_TEST", "DomainSecurity 解密成功:" + str3);
                        return smartDomainData2;
                    } catch (Exception e11) {
                        e = e11;
                        smartDomainData = smartDomainData2;
                        e.printStackTrace();
                        return smartDomainData;
                    }
                } else {
                    LogAndWoodRecorder.a("DOMAIN_TEST", "DomainSecurity 解密失败");
                    return smartDomainData2;
                }
            } else {
                LogAndWoodRecorder.a("DOMAIN_TEST", "DomainSecurity 请求失败");
                return null;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public static void j0(String str, long j11, String str2, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put(VulcanInfo.HOST, str);
        hashMap.put("durtion", Long.valueOf(j11));
        hashMap.put("errorMsg", str2);
        hashMap.put("code", Integer.valueOf(i11));
        hashMap.put("network_dns", l.c(bh.j.c().getApplicationContext()));
        gs.g.i("network_detect", hashMap);
    }

    public static void k0(String str) {
        f0(f43776h, DomainModuleKey.DMK_SPOT.key);
        f43776h = str;
    }

    public static void l0(String str) {
        k0(str);
        C0(str + "/-/x/pro/");
        n0(str + "/-/x/etf/");
        J0(str + "/-/x/uc/");
        B0(str + "/-/x/hb/");
        s0(str + "/-/x/hbg/");
        t0(str + "/-/x/huobi-kyc/");
        y0(str + "/-/x/");
        x0(str + "/-/x/mp-content/");
        E0(str + "/-/x/rca/");
        D0(str + "/-/s/pro");
        p0(str + "/-/x/hbg/");
        I0(str + "/-/x/travelrule/");
    }

    public static void m0(String str) {
        f0(f43789u, DomainModuleKey.DMK_INDEX.key);
        f43789u = str;
        LogAndWoodRecorder.c("DOMAIN_TEST", "dm index domain = " + f43789u);
    }

    public static void n0(String str) {
        f43780l = str;
    }

    public static void o0(String str) {
        f0(F, DomainModuleKey.DMK_GLOBALWEB.key);
        F = str;
    }

    public static void p0(String str) {
        f43785q = str;
    }

    public static void q0(String str) {
        f0(f43786r, DomainModuleKey.DMK_CONTRACT.key);
        f43786r = str;
        LogAndWoodRecorder.c("DOMAIN_TEST", "dm domain = " + str);
    }

    public static String r() {
        return f43776h;
    }

    public static void r0(String str) {
        f0(f43790v, DomainModuleKey.DMK_DMH5.key);
        f43790v = str;
    }

    public static void s0(String str) {
        f43791w = str;
    }

    public static String t() {
        if (TextUtils.isEmpty(f43790v)) {
            return "l10n-dm-mobile.huobi.cn";
        }
        return f43790v;
    }

    public static void t0(String str) {
        f43782n = str;
    }

    public static String u() {
        return f43789u;
    }

    public static void u0(String str) {
        if (SystemUtils.c()) {
            f43788t = str + "/-/x/api/";
            return;
        }
        f43788t = str + "/-/x/inst/";
    }

    public static String v() {
        return f43780l;
    }

    public static void v0(DomainInfo domainInfo) {
        A = domainInfo.b();
        B = domainInfo.c();
        C = domainInfo.d();
        D = domainInfo.e();
    }

    public static String w() {
        return F;
    }

    public static void w0(String str) {
        f0(G, DomainModuleKey.DMK_KYCWEB.key);
        G = str;
    }

    public static String x() {
        return f43786r;
    }

    public static void x0(String str) {
        f43794z = str;
    }

    public static String y() {
        return f43791w;
    }

    public static void y0(String str) {
        f43793y = str;
    }

    public static String z() {
        return f43782n;
    }

    public static void z0(String str) {
        f0(E, DomainModuleKey.DMK_GLOBALMOBILE.key);
        E = str;
    }

    public void F0(SmartDomain smartDomain) {
        int i11;
        this.f43798d = smartDomain;
        if (!(smartDomain == null || (i11 = smartDomain.timer_interval) == 0)) {
            L = ((long) i11) * 1000;
        }
        K0();
    }

    public void K0() {
        if (!M) {
            LogAndWoodRecorder.c("DOMAIN_TEST", "启动域名检测轮询，轮询间隔：" + L);
            M = true;
            Observable.interval(L, TimeUnit.MILLISECONDS).subscribe(new f());
        }
    }

    public String L(String str) {
        Map<String, String> map = J;
        if (map == null) {
            return "";
        }
        return map.get(str);
    }

    public void U0(DomainInfo domainInfo) {
        if (domainInfo != null) {
            u0(domainInfo.f().getInstitutionDefault());
            v0(domainInfo);
        }
    }

    public SmartDomain V() {
        return this.f43798d;
    }

    public void V0() {
        if (this.f43796b == 0 || System.currentTimeMillis() - this.f43796b >= 5000) {
            this.f43796b = System.currentTimeMillis();
            this.f43795a.a().subscribe(new k());
            return;
        }
        LogAndWoodRecorder.a("DOMAIN_TEST", "域名检测内部限频，不进行域名检测");
    }

    public synchronized void p(String str) {
        String host = Uri.parse(str).getHost();
        if (this.f43799e.get(host) == null) {
            this.f43799e.put(host, 1);
        } else {
            SmartDomain smartDomain = this.f43798d;
            if (smartDomain != null) {
                this.f43800f = smartDomain.err_threshold;
            }
            int intValue = this.f43799e.get(host).intValue() + 1;
            if (intValue >= this.f43800f) {
                LogAndWoodRecorder.a("DOMAIN_TEST", "达到失败次数，切换备用域名");
                q(str);
            } else {
                this.f43799e.put(host, Integer.valueOf(intValue));
            }
        }
    }

    public String q(String str) {
        String str2;
        DomainInfo domainInfo = this.f43797c;
        if (domainInfo == null) {
            LogAndWoodRecorder.a("DOMAIN_TEST", "-0无法切换备用域名：" + str);
            return str;
        }
        HashMap<String, List<String>> a11 = domainInfo.a();
        Set<Map.Entry<String, List<String>>> entrySet = a11.entrySet();
        String str3 = null;
        String host = Uri.parse(str).getHost();
        this.f43799e.put(host, 0);
        for (Map.Entry next : entrySet) {
            try {
                for (String equals : (List) next.getValue()) {
                    if (TextUtils.equals(host, equals)) {
                        str3 = (String) next.getKey();
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = L(host);
        }
        if (!TextUtils.isEmpty(str3)) {
            List list = a11.get(str3);
            V0();
            if (list == null || list.size() <= 1) {
                LogAndWoodRecorder.a("DOMAIN_TEST", "无法切换备用域名：" + str);
                return str;
            }
            int indexOf = list.indexOf(host);
            if (indexOf < 0) {
                LogAndWoodRecorder.a("DOMAIN_TEST", "不属于智能范围，不切换备用域名：" + str);
                return str;
            }
            if (indexOf < list.size() - 1) {
                str2 = (String) list.get(indexOf + 1);
            } else {
                str2 = (String) list.get(0);
                LogAndWoodRecorder.a("DOMAIN_TEST", "已经是最后一个备用域名");
            }
            if (!TextUtils.isEmpty(str3)) {
                if (TextUtils.equals(str3, DomainModuleKey.DMK_GLOBALWEB.key)) {
                    o0(str2);
                } else if (TextUtils.equals(str3, DomainModuleKey.DMK_GLOBALMOBILE.key)) {
                    z0(str2);
                } else if (TextUtils.equals(str3, DomainModuleKey.DMK_KYCWEB.key)) {
                    w0(str2);
                } else if (TextUtils.equals(str3, DomainModuleKey.DMK_CONTRACT.key)) {
                    q0(str2);
                    G0(str2);
                } else if (TextUtils.equals(str3, DomainModuleKey.DMK_INDEX.key)) {
                    m0(str2);
                } else if (TextUtils.equals(str3, DomainModuleKey.DMK_SPOT.key)) {
                    l0(str2);
                } else if (TextUtils.equals(str3, DomainModuleKey.DMK_DMH5.key)) {
                    r0(str2);
                }
            }
            LogAndWoodRecorder.a("DOMAIN_TEST", "切换备用域名完成：" + host + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            String replace = str.replace(host, str2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("切换备用域名完成：");
            sb2.append(replace);
            LogAndWoodRecorder.a("DOMAIN_TEST", sb2.toString());
            return replace;
        }
        LogAndWoodRecorder.a("DOMAIN_TEST", "无法切换备用域名：" + str);
        return str;
    }

    public String s(String str) {
        if (TextUtils.isEmpty(str)) {
            LogAndWoodRecorder.a("DOMAIN_TEST", "-0无法切换better域名：" + str);
            return str;
        }
        DomainInfo domainInfo = this.f43797c;
        if (domainInfo == null) {
            LogAndWoodRecorder.a("DOMAIN_TEST", "-0无法切换better域名：" + str);
            return str;
        }
        Set<Map.Entry<String, List<String>>> entrySet = domainInfo.a().entrySet();
        String host = Uri.parse(str).getHost();
        String str2 = null;
        String str3 = null;
        for (Map.Entry next : entrySet) {
            try {
                Iterator it2 = ((List) next.getValue()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (TextUtils.equals(host, (String) it2.next())) {
                            str3 = (String) next.getKey();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            if (DomainModuleKey.DMK_CONTRACT.key.equals(str3)) {
                str2 = f43786r;
            } else if (DomainModuleKey.DMK_GLOBALMOBILE.key.equals(str3)) {
                str2 = E;
            } else if (DomainModuleKey.DMK_GLOBALWEB.key.equals(str3)) {
                str2 = F;
            } else if (DomainModuleKey.DMK_INDEX.key.equals(str3)) {
                str2 = f43789u;
            } else if (DomainModuleKey.DMK_KYCWEB.key.equals(str3)) {
                str2 = G;
            } else if (DomainModuleKey.DMK_SPOT.key.equals(str3)) {
                str2 = f43776h;
            } else if (TextUtils.equals(str3, DomainModuleKey.DMK_DMH5.key)) {
                str2 = f43790v;
            }
            if (!TextUtils.isEmpty(str2)) {
                LogAndWoodRecorder.a("DOMAIN_TEST", "切换最快域名完成：" + host + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
                String replace = str.replace(host, str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("切换最快域名完成：");
                sb2.append(replace);
                LogAndWoodRecorder.a("DOMAIN_TEST", sb2.toString());
                return replace;
            }
            LogAndWoodRecorder.a("DOMAIN_TEST", "未找到better域名：" + host);
            return str;
        }
        LogAndWoodRecorder.a("DOMAIN_TEST", "无法切换better域名：" + str);
        return str;
    }
}
