package com.huobi.login.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.bean.RegisterResult;
import com.huobi.login.usercenter.data.source.bean.TsvTokenWrapper;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.utils.HistoryAccountDataManager;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.riskcontrol.bean.SecurityVerifyParam;
import com.huobi.utils.StringUtilsTodo;
import com.huobi.utils.k0;
import com.huobi.vulcan.model.VulcanInfo;
import java.util.HashMap;
import nn.m1;
import nn.n1;
import nn.o1;
import nn.p1;
import nn.q1;
import nn.s1;
import nn.t1;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import sn.l;
import sn.w;
import tg.r;
import tq.p;
import u6.g;
import wn.c0;

public class SetForgetPswPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public JumpTarget f75507a;

    /* renamed from: b  reason: collision with root package name */
    public String f75508b;

    /* renamed from: c  reason: collision with root package name */
    public String f75509c;

    public class a extends EasySubscriber<TsvTokenWrapper> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(TsvTokenWrapper tsvTokenWrapper) {
            Intent h11 = k0.h(SetForgetPswPresenter.this.getActivity());
            h11.putExtra("login_name", SetForgetPswPresenter.this.f75508b);
            if (SetForgetPswPresenter.this.f75507a != null) {
                h11.putExtra("target", SetForgetPswPresenter.this.f75507a);
            }
            HuobiToastUtil.s(R.string.n_find_success);
            RegisterResult registerResult = new RegisterResult();
            registerResult.d(tsvTokenWrapper.getTicket());
            registerResult.f(tsvTokenWrapper.getUcToken());
            registerResult.e(tsvTokenWrapper.getTokenUrl());
            SetForgetPswPresenter.this.k0(Observable.just(registerResult), ((b) SetForgetPswPresenter.this.getUI()).J9(), h11);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((b) SetForgetPswPresenter.this.getUI()).G0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            uq.a.b(SetForgetPswPresenter.this.getActivity(), aPIStatusErrorException, (SecurityVerifyParam.Scene) null, (SecurityVerifyParam.RiskOperate) null, true);
            ((b) SetForgetPswPresenter.this.getUI()).G0();
        }
    }

    public interface b extends g {
        void G0();

        LoginSuccBean J9();
    }

    public static /* synthetic */ UserToken c0(RegisterResult registerResult) {
        UserToken userToken = new UserToken();
        userToken.h(registerResult.a());
        userToken.i(registerResult.b());
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable f0(UserToken userToken) {
        return m0(userToken.c()).map(new q1(userToken));
    }

    public static /* synthetic */ UserToken g0(UserToken userToken, UserInfoData userInfoData) {
        userToken.j(userInfoData.k());
        r.x().i0(userInfoData);
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Intent intent, Object obj) {
        if (LiteReHelper.a().b()) {
            getActivity().startActivity(new Intent(getActivity(), LiteReMainActivity.class));
        } else {
            getActivity().startActivity(intent);
        }
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(LoginSuccBean loginSuccBean, Intent intent, UserToken userToken) {
        w.j().m((CountryListData) null);
        gs.b.e(getActivity(), r.x().Q());
        HistoryAccountDataManager.a().j(this.f75508b);
        if (loginSuccBean != null) {
            c0.i(this.f75508b, Boolean.TRUE, (String) null, loginSuccBean);
        }
        l.q(userToken, this.f75508b, getActivity(), true, new m1(this, intent));
        ConfigPreferences.n("user_config", "lite_chosen", false);
    }

    public final void k0(Observable<RegisterResult> observable, LoginSuccBean loginSuccBean, Intent intent) {
        observable.map(s1.f58656b).flatMap(new p1(this)).flatMap(t1.f58661b).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new n1(this, loginSuccBean, intent)));
    }

    /* renamed from: l0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (intent.getExtras() != null && intent.getExtras().containsKey("target")) {
                kn.a aVar = (kn.a) intent.getExtras().get("target");
                if (aVar instanceof JumpTarget) {
                    this.f75507a = (JumpTarget) aVar;
                }
            }
            this.f75508b = intent.getStringExtra("login_name");
            this.f75509c = intent.getStringExtra("reset_token");
        }
    }

    public final Observable<ProUserToken> m0(String str) {
        return UserCenterRemoteDataSource.A().m0(str).doOnError(o1.f58639b).compose(p.a0()).subscribeOn(Schedulers.io());
    }

    public void n0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reset_token", this.f75509c);
        hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, MD5Utils.c(str));
        hashMap.put("password_level", Integer.valueOf(StringUtilsTodo.a(str)));
        hashMap.put(VulcanInfo.VTOKEN, ku.b.e().h(getActivity()));
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("way", "APP_HUOBI_PRO");
        UserCenterRemoteDataSource.A().resetPassword(hashMap).compose(RxJavaHelper.t((g) getUI())).compose(p.c0()).subscribe(new a());
    }
}
