package sn;

import android.app.Activity;
import android.text.TextUtils;
import bh.u;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.bugsdk.FirebaseHelper;
import com.huobi.c2c.util.n;
import com.huobi.entity.UserTransInfo;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.main.helper.AssetProfitRateHelper;
import com.huobi.main.helper.f;
import com.huobi.otc.helper.OtcNewOrderTipHelper;
import com.huobi.otcoption.util.OtcOptionsEntryHelper;
import com.huobi.statistics.AppVersionUidHelper;
import com.huobi.supermargin.helper.MarginRiskRateUtil;
import com.huobi.utils.LanguageHelper;
import com.huobi.utils.UserInfoUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.tencent.android.tpush.common.Constants;
import dn.d;
import i6.k;
import java.util.List;
import qh.p0;
import rx.Observable;
import rx.schedulers.Schedulers;
import tg.g;
import tg.r;
import tq.p;
import yl.x;

public final class l {

    public class a extends EasySubscriber<UserKycInfoNew> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f76550b;

        public a(Activity activity) {
            this.f76550b = activity;
        }

        /* renamed from: a */
        public void onNext(UserKycInfoNew userKycInfoNew) {
            super.onNext(userKycInfoNew);
            AppVersionUidHelper.a(this.f76550b);
        }
    }

    public class b extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f76551b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f76552c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c6.b f76553d;

        public b(Activity activity, boolean z11, c6.b bVar) {
            this.f76551b = activity;
            this.f76552c = z11;
            this.f76553d = bVar;
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
            l.g(this.f76551b, this.f76552c, this.f76553d);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            l.g(this.f76551b, this.f76552c, this.f76553d);
        }
    }

    public class c extends EasySubscriber<List<Integer>> {
        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(List<Integer> list) {
            super.onNext(list);
            LanguageHelper.f83697a = list;
        }
    }

    public static void g(Activity activity, boolean z11, c6.b bVar) {
        k.o("global_login", "登录成功 token:" + r.x().I());
        g.d(false);
        x.n().k();
        if (z11) {
            os.c.j();
        } else {
            os.c.i();
        }
        UserLoginHelper.e().d(activity);
        UserLoginHelper.e().f().compose(RxJavaHelper.t((u6.g) null)).subscribe(new BaseSubscriber());
        n.b();
        n.c().d((RequestCallback1) null);
        r.x().B0(false, (u6.g) null);
        yl.g.h().o();
        UserInfoUtil.g(activity, (c6.c<UserTransInfo, UnifyKycInfo>) null);
        u.d();
        OtcOptionsEntryHelper.g().l();
        p0.n().i();
        try {
            SensorsDataAPI.sharedInstance().login(r.x().Q());
        } catch (Exception e11) {
            k.j("SENSORS", e11);
        }
        gs.b.f(activity, r.x().Q());
        com.huobi.lifecycle.a.j().s();
        we.b.l("home_feed_refresh", Integer.class).g(0);
        r();
        FirebaseHelper.h(r.x().Q());
        FirebaseHelper.g(Constants.FLAG_DEVICE_ID, m0.a());
        if (bVar != null) {
            bVar.onCallback(null);
        }
    }

    public static void h(Activity activity, boolean z11, c6.b bVar) {
        AppVersionUidHelper.a(activity);
        n(activity, z11, bVar);
    }

    public static /* synthetic */ String j(Throwable th2) {
        return null;
    }

    public static /* synthetic */ ProUserToken l(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Object m(String str, ProUserToken proUserToken) {
        if (!TextUtils.isEmpty(str)) {
            r.x().r0(str);
        }
        if (proUserToken == null) {
            return null;
        }
        r.x().v0(proUserToken.getToken());
        return null;
    }

    public static void n(Activity activity, boolean z11, c6.b bVar) {
        Observable.zip(UserCenterRemoteDataSource.A().Q("LoginCompleteHelper").compose(p.c0()).flatMap(g.f70163b).subscribeOn(Schedulers.io()).onErrorReturn(i.f70165b), UserCenterRemoteDataSource.A().Q("LoginCompleteHelper").compose(p.c0()).flatMap(h.f70164b).subscribeOn(Schedulers.io()).onErrorReturn(j.f70166b), k.f70167b).compose(RxJavaHelper.t((u6.g) null)).subscribe(new b(activity, z11, bVar));
        MarginRiskRateUtil.b();
    }

    public static void o(Activity activity) {
        k.o("global_login_auto", "自动登录失败");
    }

    public static void p(Activity activity) {
        k.o("global_login_auto", "自动登录成功 token:" + r.x().I());
        f.c().l();
        AssetProfitRateHelper.a().b();
        r();
        u.d();
        d.f().o(true);
        MarginRiskRateUtil.b();
        OtcNewOrderTipHelper.o();
    }

    public static void q(UserToken userToken, String str, Activity activity, boolean z11, c6.b bVar) {
        r.x().g0();
        ConfigPreferences.k("user_config", "ALREADY_LOGGED_IN", 1);
        ConfigPreferences.m("user_config", "config_email", str);
        String s11 = r.x().s();
        if (!TextUtils.isEmpty(s11)) {
            ConfigPreferences.m("user_config", s11 + "config_new_email", str);
        }
        SoftInputUtils.f(activity);
        if (!ConfigPreferences.b("user_config", "is_first_use")) {
            ConfigPreferences.n("user_config", "is_first_use", true);
        }
        rn.c.i().y(userToken);
        r.x().v0(userToken.b());
        r.x().u0(userToken.a());
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        UserLoginHelper.e().g().compose(RxJavaHelper.s()).subscribe(new a(activity));
        n(activity, z11, bVar);
    }

    public static void r() {
        v7.b.a().kolLanguage(BaseModuleConfig.a().f()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new c());
    }
}
