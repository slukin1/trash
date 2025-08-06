package com.huobi.account.presenter;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.network.uc.retrofit.bean.UcAuthorizationBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.usercenter.data.source.api.UserCenterService;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import i6.d;
import i6.i;
import java.util.Map;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import tq.p;
import u6.g;
import ug.a2;
import ug.b2;
import ug.c2;
import ug.d2;
import ug.e2;
import ug.f2;
import ug.z1;

public class UpdateOtcTradePwdPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41102a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41103b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41104c;

    /* renamed from: d  reason: collision with root package name */
    public String f41105d;

    /* renamed from: e  reason: collision with root package name */
    public String f41106e;

    public interface a extends g {
        void P0();

        void P1();

        void m3();

        String s5();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(SecurityStrategySet securityStrategySet) {
        this.f41104c = securityStrategySet.getSetting().isVerify_phone();
        this.f41103b = securityStrategySet.getSetting().isVerify_email();
        this.f41102a = securityStrategySet.getSetting().isVerify_ga();
        ((a) getUI()).P0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(UserSecurityInfoData userSecurityInfoData) {
        this.f41106e = userSecurityInfoData.getEmail();
        this.f41105d = userSecurityInfoData.getPhone();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable j0(Map map, UcAuthorizationBean ucAuthorizationBean) {
        if (ucAuthorizationBean != null) {
            map.put("authToken", ucAuthorizationBean.getAuthToken());
            map.put("ucPass", MD5Utils.c(((a) getUI()).s5()));
        }
        return l.K(map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0() {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(Boolean bool) {
        HuobiToastUtil.s(R.string.update_new_otc_trade_pwd_success);
        ((a) getUI()).P1();
        i.b().g(new z1(this), 10);
        d.j("StrategyDisable", "success");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).m3();
        d.j("StrategyDisable", aPIStatusErrorException.getErrMsg());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(Throwable th2) {
        ((a) getUI()).m3();
        th2.printStackTrace();
    }

    public String X() {
        return this.f41106e;
    }

    public String Y() {
        return this.f41105d;
    }

    public Map<String, Object> Z() {
        return MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_POLICY").b();
    }

    public void a0() {
        UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new b2(this)));
    }

    public Map<String, Object> b0() {
        return MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_POLICY").a("voice", Boolean.FALSE).b();
    }

    public final void c0() {
        UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new c2(this)));
    }

    public boolean d0() {
        return this.f41103b;
    }

    public boolean f0() {
        return this.f41102a;
    }

    public boolean g0() {
        return this.f41104c;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    /* renamed from: p0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        c0();
        EventBus.d().p(this);
    }

    public void q0(String str, String str2, String str3) {
        Map<String, Object> b11 = MapParamsBuilder.c().a("tradePass", MD5Utils.d(((a) getUI()).s5())).b();
        if (!TextUtils.isEmpty(str)) {
            b11.put("emailCode", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            b11.put("smsCode", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            b11.put("gaCode", str3);
        }
        ((UserCenterService) p.b0(UserCenterService.class)).getAuthorization("ASSET_PASSWORD_CHECK").compose(p.c0()).flatMap(new f2(this, b11)).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new d2(this), new a2(this), new e2(this)));
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        c.i().f(getActivity());
        getActivity().finish();
    }
}
