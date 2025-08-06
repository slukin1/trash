package tg;

import ad.o;
import android.text.TextUtils;
import android.util.Log;
import bh.j;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.future.controller.FutureClearDialogConfigController;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.hbg.core.bean.AccountNftInfoBean;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.hbg.record.BizRecordProvider;
import com.hbg.lib.network.otc.core.bean.OtcTokenUpdate;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.bean.AccountLoadSuccessEvent;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.account.event.LogOutEvent;
import com.huobi.app.GrayConfigHelper;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.finance.controller.VirtualAddressProvider;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.usercenter.data.source.bean.AccountUserInfo;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.utils.FingerprintHelper;
import com.huobi.main.helper.NewAccountTabRedDotHelper;
import com.huobi.main.helper.m;
import com.huobi.otc.helper.OtcLoginHelper;
import com.huobi.otc.helper.OtcNewOrderTipHelper;
import com.huobi.otcoption.util.OtcOptionsEntryHelper;
import com.huobi.utils.GestureUtil;
import com.huobi.utils.UserInfoUtil;
import dt.h2;
import gj.d;
import i6.k;
import java.util.List;
import jp.l;
import m9.z;
import org.greenrobot.eventbus.EventBus;
import os.c;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.subjects.ReplaySubject;
import sb.f;
import sn.t;
import tq.p;
import u6.g;
import yl.n;
import yo.s0;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public String f47870a;

    /* renamed from: b  reason: collision with root package name */
    public UserInfoData f47871b;

    /* renamed from: c  reason: collision with root package name */
    public volatile String f47872c;

    /* renamed from: d  reason: collision with root package name */
    public volatile String f47873d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f47874e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f47875f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f47876g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f47877h;

    /* renamed from: i  reason: collision with root package name */
    public volatile String f47878i;

    /* renamed from: j  reason: collision with root package name */
    public volatile String f47879j;

    /* renamed from: k  reason: collision with root package name */
    public volatile String f47880k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f47881l;

    /* renamed from: m  reason: collision with root package name */
    public Boolean f47882m;

    /* renamed from: n  reason: collision with root package name */
    public Boolean f47883n;

    /* renamed from: o  reason: collision with root package name */
    public int f47884o;

    /* renamed from: p  reason: collision with root package name */
    public int f47885p;

    /* renamed from: q  reason: collision with root package name */
    public String f47886q;

    /* renamed from: r  reason: collision with root package name */
    public UserOtherInfoData f47887r;

    /* renamed from: s  reason: collision with root package name */
    public AccountNftInfoBean f47888s;

    /* renamed from: t  reason: collision with root package name */
    public String f47889t;

    /* renamed from: u  reason: collision with root package name */
    public String f47890u;

    /* renamed from: v  reason: collision with root package name */
    public String f47891v;

    /* renamed from: w  reason: collision with root package name */
    public String f47892w;

    /* renamed from: x  reason: collision with root package name */
    public String f47893x;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static r f47894a = new r();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean Y(Boolean bool) {
        this.f47883n = bool;
        return bool;
    }

    public static /* synthetic */ void Z(Subscriber subscriber) {
        subscriber.onStart();
        subscriber.onError(new APIStatusErrorException("token_failure", j.c().getString(R.string.login_timeout_login_again)));
        subscriber.onCompleted();
    }

    public static /* synthetic */ void b0(String str, Subscriber subscriber) {
        subscriber.onStart();
        subscriber.onError(new APIStatusErrorException("token_failure", str));
        subscriber.onCompleted();
    }

    public static /* synthetic */ Boolean d0(Boolean bool, Boolean bool2) {
        return Boolean.valueOf(bool.booleanValue() || bool2.booleanValue());
    }

    public static r x() {
        return b.f47894a;
    }

    public String A() {
        return this.f47892w;
    }

    public void A0(int i11, int i12, String str) {
        this.f47884o = i11;
        this.f47885p = i12;
        this.f47886q = str;
    }

    public String B() {
        return this.f47877h;
    }

    public void B0(boolean z11, g gVar) {
        x().S(z11).compose(RxJavaHelper.t(gVar)).subscribe(new BaseSubscriber());
    }

    public String C() {
        return this.f47878i;
    }

    public final void C0() {
        String e11 = ConfigPreferences.e("user_config", this.f47870a + "_" + "config_access_uc_token", "");
        if (!TextUtils.isEmpty(e11)) {
            ConfigPreferences.m("user_config", this.f47870a + "_" + "config_tua", com.hbg.lib.core.util.a.c(e11));
            SP.o("user_config", this.f47870a + "_" + "config_access_uc_token");
        }
    }

    public AccountNftInfoBean D() {
        return this.f47888s;
    }

    public void D0(AccountUserInfo accountUserInfo) {
        UserInfoData e11 = accountUserInfo.e();
        UserOtherInfoData d11 = accountUserInfo.d();
        if (e11 != null && d11 != null) {
            this.f47871b = e11;
            h0(accountUserInfo);
            if (!this.f47893x.equals(J())) {
                GrayConfigHelper.f();
                this.f47893x = J();
            }
            EventBus.d().k(new AccountLoadSuccessEvent());
        }
    }

    public String E() {
        return this.f47875f;
    }

    /* renamed from: E0 */
    public void c0(UserInfoData userInfoData) {
        if (userInfoData != null) {
            this.f47871b = userInfoData;
            i0(userInfoData);
            if (!this.f47893x.equals(J())) {
                GrayConfigHelper.f();
                this.f47893x = J();
            }
        }
    }

    public String F() {
        UserInfoData userInfoData = this.f47871b;
        return userInfoData != null ? userInfoData.h() : "";
    }

    public boolean F0() {
        return !TextUtils.isEmpty(this.f47874e);
    }

    public String G() {
        return this.f47873d;
    }

    public String H() {
        return this.f47872c;
    }

    public String I() {
        return this.f47874e;
    }

    public String J() {
        UserInfoData userInfoData = this.f47871b;
        return userInfoData != null ? userInfoData.i() : "";
    }

    public String K() {
        return this.f47886q;
    }

    public UserOtherInfoData L() {
        return this.f47887r;
    }

    public synchronized UserInfoData M() {
        return this.f47871b;
    }

    public String N() {
        return this.f47889t;
    }

    public Observable<UserInfoData> O(boolean z11) {
        if (!F0()) {
            return Observable.create(m.f29325b);
        }
        ReplaySubject create = ReplaySubject.create();
        create.subscribe(EasySubscriber.create(new o(this)));
        f0(z11).compose(RxJavaHelper.s()).subscribe(create);
        return create;
    }

    public Observable<UserInfoData> P(boolean z11, String str) {
        if (!F0()) {
            return Observable.create(new l(str));
        }
        ReplaySubject create = ReplaySubject.create();
        create.subscribe(EasySubscriber.create(new n(this)));
        f0(z11).compose(RxJavaHelper.s()).subscribe(create);
        return create;
    }

    public String Q() {
        UserInfoData userInfoData = this.f47871b;
        return userInfoData != null ? userInfoData.k() : "";
    }

    public boolean R() {
        List<Integer> d11;
        UserInfoData userInfoData = this.f47871b;
        if (userInfoData == null || (d11 = userInfoData.d()) == null || d11.size() <= 0 || d11.get(0) == null || 183 != d11.get(0).intValue()) {
            return false;
        }
        return true;
    }

    public Observable<Boolean> S(boolean z11) {
        if (!AppLanguageHelper.getInstance().isChineseLanguage()) {
            return Observable.just(Boolean.TRUE);
        }
        if (F0()) {
            return Observable.zip(g(z11), Observable.just(Boolean.valueOf(d.n().p())), q.f29329b);
        }
        return Observable.just(Boolean.valueOf(d.n().p()));
    }

    public boolean T() {
        if (!AppLanguageHelper.getInstance().isChineseLanguage()) {
            return true;
        }
        if (!F0()) {
            return d.n().p();
        }
        Boolean bool = this.f47883n;
        if (bool == null) {
            return d.n().p();
        }
        if (bool.booleanValue() || d.n().p()) {
            return true;
        }
        return false;
    }

    public boolean U() {
        UserInfoData userInfoData = this.f47871b;
        boolean z11 = false;
        if (userInfoData == null) {
            return false;
        }
        List<Integer> d11 = userInfoData.d();
        if (d11 == null || d11.size() <= 0 || d11.get(0) == null) {
            return true;
        }
        if (37 == d11.get(0).intValue()) {
            z11 = true;
        }
        return z11;
    }

    public boolean V() {
        List<Integer> d11;
        UserInfoData userInfoData = this.f47871b;
        if (userInfoData == null || (d11 = userInfoData.d()) == null || d11.size() <= 0 || d11.get(0) == null || 83 != d11.get(0).intValue()) {
            return false;
        }
        return true;
    }

    public Boolean W() {
        if (this.f47882m == null) {
            return null;
        }
        return Boolean.valueOf(F0() && this.f47882m.booleanValue());
    }

    public boolean X() {
        return F0() && this.f47881l;
    }

    public synchronized void e0() {
        if (!TextUtils.isEmpty(this.f47870a)) {
            this.f47881l = ConfigPreferences.c("user_config", this.f47870a + "_" + "ACCOUNT_TYPE", false);
            String e11 = ConfigPreferences.e("user_config", this.f47870a + "_" + "config_gesture", "");
            boolean d11 = new FingerprintHelper().d();
            if (!TextUtils.isEmpty(e11) || d11 || !TextUtils.isEmpty(this.f47874e)) {
                C0();
                this.f47874e = com.hbg.lib.core.util.a.a(ConfigPreferences.e("user_config", this.f47870a + "_" + "config_tua", ""));
                if (!TextUtils.isEmpty(this.f47874e)) {
                    if (this.f47871b == null) {
                        this.f47871b = new UserInfoData();
                    }
                    this.f47871b.l(this.f47870a);
                }
            }
        }
    }

    public Observable<UserInfoData> f0(boolean z11) {
        UserInfoData userInfoData;
        if (!z11 || (userInfoData = this.f47871b) == null) {
            return UserCenterRemoteDataSource.A().R().compose(p.c0());
        }
        return Observable.just(userInfoData);
    }

    public Observable<Boolean> g(boolean z11) {
        Boolean bool;
        if (!z11 || (bool = this.f47883n) == null) {
            return v7.b.a().checkWhiteList().b().map(new p(this));
        }
        return Observable.just(Boolean.valueOf(bool.booleanValue() && F0()));
    }

    public void g0() {
        this.f47872c = "";
        this.f47873d = "";
        this.f47877h = "1";
        this.f47878i = "1";
        this.f47879j = "1";
        this.f47876g = "";
        this.f47880k = "";
        t0("");
        h();
    }

    public void h() {
        this.f47882m = null;
        this.f47883n = null;
        f.h().f();
        h2.t1().W0();
        UserCenterRemoteDataSource.A().p();
        KycProxy.l().h();
        s0.d0().S();
        VirtualAddressProvider.f().c();
        l.h();
        bj.d.a();
        ContractUserInfoProvider.i().g();
        z.f().e();
        AssetDataCacheManager.k0().O();
        c.g();
        n.a();
        tu.c.d();
        o.b();
        com.huobi.c2c.util.n.b();
        BizRecordProvider.b();
        ClearDialogConfigController.b();
        FutureClearDialogConfigController.b();
        OtcLoginHelper.e();
        OtcOptionsEntryHelper.g().f();
        m.b().a();
        ui.d.l(false);
        jo.a.e().c();
    }

    public void h0(AccountUserInfo accountUserInfo) {
        UserInfoData e11 = accountUserInfo.e();
        UserOtherInfoData d11 = accountUserInfo.d();
        if (e11 != null) {
            this.f47871b = e11;
            this.f47870a = e11.i();
            this.f47881l = e11.j() == 2;
            ConfigPreferences.n("user_config", this.f47870a + "_" + "ACCOUNT_TYPE", this.f47881l);
            ConfigPreferences.m("user_config", "config_current_uid", this.f47870a);
            if (!TextUtils.isEmpty(e11.e())) {
                ConfigPreferences.m("user_config", e11.e(), this.f47870a);
            }
            if (!TextUtils.isEmpty(e11.h())) {
                ConfigPreferences.m("user_config", e11.h(), this.f47870a);
            }
            boolean d12 = new FingerprintHelper().d();
            if (GestureUtil.c() || d12) {
                e11.m();
            }
            List<MultipleAccountData> a11 = g.a();
            MultipleAccountData multipleAccountData = null;
            boolean z11 = false;
            for (MultipleAccountData next : a11) {
                if (next.getUid().equals(e11.i())) {
                    next.setCurrentAccount(true);
                    next.setAccount(UserInfoUtil.j(accountUserInfo.f(), accountUserInfo.e(), d11));
                    next.setFrameUrl(d11.getFrame_url());
                    next.setHeadImage(d11.getHead_image());
                    next.setHeadImageType(d11.getHead_image_type());
                    next.setNickName(d11.getNick_name());
                    next.setShowExtBusinessTag(d11.getShow_ext_business_tag());
                    z11 = true;
                    multipleAccountData = next;
                } else {
                    next.setCurrentAccount(false);
                }
            }
            if (!z11) {
                MultipleAccountData multipleAccountData2 = new MultipleAccountData();
                multipleAccountData2.setAccount(UserInfoUtil.j(accountUserInfo.f(), accountUserInfo.e(), d11));
                multipleAccountData2.setCurrentAccount(true);
                multipleAccountData2.setSubAccount(this.f47881l);
                multipleAccountData2.setUid(e11.i());
                multipleAccountData2.setFrameUrl(d11.getFrame_url());
                multipleAccountData2.setHeadImage(d11.getHead_image());
                multipleAccountData2.setHeadImageType(d11.getHead_image_type());
                multipleAccountData2.setNickName(d11.getNick_name());
                multipleAccountData2.setShowExtBusinessTag(d11.getShow_ext_business_tag());
                a11.add(0, multipleAccountData2);
            } else {
                a11.remove(multipleAccountData);
                a11.add(0, multipleAccountData);
            }
            g.c(a11);
        }
    }

    public void i() {
        i6.d.l(6);
        if (x().F0()) {
            t.m();
        }
        this.f47871b = null;
        this.f47872c = "";
        this.f47873d = "";
        this.f47877h = "1";
        this.f47878i = "1";
        this.f47879j = "1";
        this.f47874e = "";
        this.f47876g = "";
        this.f47880k = "";
        this.f47881l = false;
        this.f47884o = 0;
        this.f47885p = 0;
        t0("");
        EventBus.d().k(new ProTokenUpdate(""));
        EventBus.d().k(new LogOutEvent(true));
        h();
    }

    public void i0(UserInfoData userInfoData) {
        if (userInfoData != null) {
            this.f47871b = userInfoData;
            this.f47870a = userInfoData.i();
            this.f47881l = userInfoData.j() == 2;
            ConfigPreferences.n("user_config", this.f47870a + "_" + "ACCOUNT_TYPE", this.f47881l);
            ConfigPreferences.m("user_config", "config_current_uid", this.f47870a);
            if (!TextUtils.isEmpty(userInfoData.e())) {
                ConfigPreferences.m("user_config", userInfoData.e(), this.f47870a);
            }
            if (!TextUtils.isEmpty(userInfoData.h())) {
                ConfigPreferences.m("user_config", userInfoData.h(), this.f47870a);
            }
            ConfigPreferences.m("user_config", this.f47870a + "_" + "config_tua", com.hbg.lib.core.util.a.c(this.f47874e));
            boolean d11 = new FingerprintHelper().d();
            if (GestureUtil.c() || d11) {
                userInfoData.m();
            }
            List<MultipleAccountData> a11 = g.a();
            MultipleAccountData multipleAccountData = null;
            boolean z11 = false;
            for (MultipleAccountData next : a11) {
                if (next.getUid().equals(userInfoData.i())) {
                    next.setCurrentAccount(true);
                    next.setAccount(o(userInfoData));
                    z11 = true;
                    multipleAccountData = next;
                } else {
                    next.setCurrentAccount(false);
                }
            }
            if (!z11) {
                MultipleAccountData multipleAccountData2 = new MultipleAccountData();
                multipleAccountData2.setAccount(o(userInfoData));
                multipleAccountData2.setCurrentAccount(true);
                multipleAccountData2.setSubAccount(this.f47881l);
                multipleAccountData2.setUid(userInfoData.i());
                a11.add(0, multipleAccountData2);
            } else {
                a11.remove(multipleAccountData);
                a11.add(0, multipleAccountData);
            }
            g.c(a11);
        }
    }

    public void j() {
        for (MultipleAccountData next : g.a()) {
            if (SP.b("user_config", next.getUid() + "_" + "config_tua")) {
                SP.o("user_config", next.getUid() + "_" + "config_tua");
            }
        }
    }

    public void j0(String str) {
        this.f47891v = str;
    }

    public void k() {
        this.f47872c = "";
        this.f47873d = "";
        this.f47877h = "1";
        this.f47878i = "1";
        this.f47879j = "1";
        this.f47874e = "";
        this.f47876g = "";
        this.f47880k = "";
        this.f47881l = false;
        this.f47882m = null;
        this.f47884o = 0;
        this.f47885p = 0;
        this.f47887r = null;
        this.f47888s = null;
        this.f47889t = "";
        this.f47890u = "";
        this.f47891v = "";
        this.f47892w = "";
        Log.d("clearToken", "clearToken");
        tu.c.d();
        t0("");
        EventBus.d().k(new ProTokenUpdate(""));
        OtcLoginHelper.e();
        OtcOptionsEntryHelper.g().f();
    }

    public void k0(String str) {
        this.f47880k = str;
    }

    public void l() {
        if (!TextUtils.isEmpty(this.f47870a)) {
            if (SP.b("user_config", this.f47870a + "_" + "config_access_uc_token")) {
                SP.o("user_config", this.f47870a + "_" + "config_access_uc_token");
            }
            if (SP.b("user_config", this.f47870a + "_" + "config_tua")) {
                SP.o("user_config", this.f47870a + "_" + "config_tua");
            }
            UserInfoData.a(this.f47870a);
        }
    }

    public void l0(String str) {
        this.f47870a = str;
    }

    public void m(String str, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            k.f("LOGIN", str);
        }
        String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
        if (TextUtils.isEmpty(e11) || TextUtils.isEmpty(this.f47870a) || e11.equals(this.f47870a)) {
            if (z11) {
                j();
            }
            l();
            this.f47870a = "";
            ConfigPreferences.m("user_config", "config_current_uid", "");
            i();
            PhoneUtils.c(j.c());
            i6.d.c("DataDiffTools", "LOGOUT");
            d7.m.c();
            HbgDialogManager.A().Q();
            NewAccountTabRedDotHelper.f().j();
            GrayConfigHelper.f();
        }
    }

    public void m0(String str) {
        this.f47890u = str;
    }

    public String n() {
        return o(this.f47871b);
    }

    public void n0(String str) {
        this.f47876g = str;
    }

    public String o(UserInfoData userInfoData) {
        if (userInfoData == null) {
            return "";
        }
        if (this.f47881l) {
            return userInfoData.b();
        }
        if (!TextUtils.isEmpty(userInfoData.h())) {
            return userInfoData.h();
        }
        return userInfoData.e();
    }

    public void o0(String str) {
        this.f47879j = str;
    }

    public String p() {
        return this.f47891v;
    }

    public void p0(String str) {
        this.f47892w = str;
    }

    public String q() {
        return this.f47880k;
    }

    public void q0(String str) {
        this.f47877h = str;
    }

    public List<Integer> r() {
        UserInfoData userInfoData = this.f47871b;
        if (userInfoData == null) {
            return null;
        }
        return userInfoData.d();
    }

    public void r0(String str) {
        Log.d("setNewKycToken", Log.getStackTraceString(new Throwable()));
        this.f47878i = str;
    }

    public String s() {
        return this.f47870a;
    }

    public void s0(AccountNftInfoBean accountNftInfoBean) {
        this.f47888s = accountNftInfoBean;
    }

    public String t() {
        return this.f47890u;
    }

    public void t0(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, this.f47875f)) {
            this.f47875f = str;
            EventBus.d().k(new OtcTokenUpdate(str));
            OtcLoginHelper.l(str);
            if (!TextUtils.isEmpty(this.f47875f)) {
                OtcNewOrderTipHelper.o();
            } else {
                OtcNewOrderTipHelper.q();
            }
        }
    }

    public String u() {
        UserInfoData userInfoData = this.f47871b;
        return userInfoData != null ? userInfoData.e() : "";
    }

    public void u0(String str) {
        this.f47873d = str;
    }

    public String v() {
        return this.f47876g;
    }

    public void v0(String str) {
        this.f47872c = str;
        tu.c.d();
        EventBus.d().k(new ProTokenUpdate(str));
    }

    public String w() {
        return this.f47879j;
    }

    public void w0(Boolean bool) {
        this.f47882m = bool;
    }

    public void x0(String str) {
        this.f47874e = str;
    }

    public String y() {
        String a11 = sn.a.c().a();
        return TextUtils.isEmpty(a11) ? "" : a11;
    }

    public void y0(UserOtherInfoData userOtherInfoData) {
        this.f47887r = userOtherInfoData;
    }

    public int z() {
        return this.f47884o;
    }

    public void z0(String str) {
        this.f47889t = str;
    }

    public r() {
        this.f47877h = "1";
        this.f47878i = "1";
        this.f47889t = "";
        this.f47890u = "";
        this.f47891v = "";
        this.f47892w = "";
        this.f47893x = "";
        this.f47870a = ConfigPreferences.e("user_config", "config_current_uid", "");
    }
}
