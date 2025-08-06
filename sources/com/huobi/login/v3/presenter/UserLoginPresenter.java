package com.huobi.login.v3.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.m;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.retrofit.eventbus.HKPayOffEvent;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.account.ui.BrushSecurityVerifyActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.ui.TrustDeviceActivity;
import com.huobi.login.usercenter.data.source.bean.FollowTypeData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.RegisterPreliminaryCheckData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.usercenter.utils.TrustDeviceStatus;
import com.huobi.login.usercenter.utils.UcNeed2FAStatus;
import com.huobi.login.utils.HistoryAccountDataManager;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.login.v3.ui.UserLoginActivityV4;
import com.huobi.login.v3.ui.UserRegisterActivityV3;
import com.huobi.utils.k0;
import com.huobi.utils.q0;
import com.huobi.vulcan.model.VulcanInfo;
import com.tencent.imsdk.BaseConstants;
import i6.i;
import i6.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import tg.r;
import tq.p;
import u6.g;
import un.a0;
import un.b0;
import un.c0;
import un.d0;
import un.e0;
import un.f0;
import un.g0;
import un.h;
import un.h0;
import un.i0;
import un.j;
import un.l;
import un.n;
import un.o;
import un.q;
import un.s;
import un.t;
import un.u;
import un.v;
import un.y;

public class UserLoginPresenter extends ActivityPresenter<f> {

    /* renamed from: i  reason: collision with root package name */
    public static String f76039i = "UserLoginPresenter";

    /* renamed from: a  reason: collision with root package name */
    public String f76040a;

    /* renamed from: b  reason: collision with root package name */
    public kn.a f76041b;

    /* renamed from: c  reason: collision with root package name */
    public JumpTarget f76042c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76043d;

    /* renamed from: e  reason: collision with root package name */
    public String f76044e;

    /* renamed from: f  reason: collision with root package name */
    public LoginInfoData f76045f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f76046g = true;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f76047h = new ArrayList();

    public class a extends EasySubscriber<FollowTypeData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f76048b;

        public a(HashMap hashMap) {
            this.f76048b = hashMap;
        }

        /* renamed from: a */
        public void onNext(FollowTypeData followTypeData) {
            ((f) UserLoginPresenter.this.getUI()).G0();
            ((f) UserLoginPresenter.this.getUI()).Hg(followTypeData, this.f76048b);
            Log.d("loginNameIsInvalid", m.g(followTypeData));
        }

        public void onError2(Throwable th2) {
            ((f) UserLoginPresenter.this.getUI()).G0();
            Log.d("loginNameIsInvalid", th2.getMessage());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((f) UserLoginPresenter.this.getUI()).G0();
            ((f) UserLoginPresenter.this.getUI()).q1(aPIStatusErrorException.getErrMsg());
            ((f) UserLoginPresenter.this.getUI()).dh();
            Log.d("loginNameIsInvalid", aPIStatusErrorException.getErrMsg());
        }
    }

    public class b extends EasySubscriber<UserToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f76050b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76051c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f76052d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f76053e;

        public b(boolean z11, String str, boolean z12, boolean z13) {
            this.f76050b = z11;
            this.f76051c = str;
            this.f76052d = z12;
            this.f76053e = z13;
        }

        public void onAfter() {
        }

        public void onError2(Throwable th2) {
            String D0 = UserLoginPresenter.f76039i;
            Log.d(D0, "onError2: " + th2 + ", msg =" + th2.getMessage());
            ((f) UserLoginPresenter.this.getUI()).m7();
            if (th2 instanceof UcNeed2FAStatus) {
                UcIntCodeResponse<LoginInfoData> ucIntCodeResponse = ((UcNeed2FAStatus) th2).getUcIntCodeResponse();
                UserLoginPresenter.this.W0(new APIStatusErrorException(String.valueOf(ucIntCodeResponse.getCode()), ucIntCodeResponse.getMessage()), this.f76053e, ucIntCodeResponse.getData());
                ((f) UserLoginPresenter.this.getUI()).G0();
                ((f) UserLoginPresenter.this.getUI()).dismissProgressDialog();
            }
            if (th2 instanceof TrustDeviceStatus) {
                UcIntCodeResponse<LoginInfoData> ucIntCodeResponse2 = ((TrustDeviceStatus) th2).getUcIntCodeResponse();
                ((f) UserLoginPresenter.this.getUI()).G0();
                ((f) UserLoginPresenter.this.getUI()).dismissProgressDialog();
                if (10077 == ucIntCodeResponse2.getCode()) {
                    TrustDeviceActivity.fg(UserLoginPresenter.this.getActivity(), false, ucIntCodeResponse2.getData().getTsvToken());
                } else if (10078 == ucIntCodeResponse2.getCode()) {
                    TrustDeviceActivity.fg(UserLoginPresenter.this.getActivity(), true, ucIntCodeResponse2.getData().getTsvToken());
                }
            } else {
                super.onError2(th2);
                th2.printStackTrace();
                ((f) UserLoginPresenter.this.getUI()).dismissProgressDialog();
                ((f) UserLoginPresenter.this.getUI()).G0();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            UserLoginPresenter.this.W0(aPIStatusErrorException, this.f76053e, (LoginInfoData) null);
            ((f) UserLoginPresenter.this.getUI()).m7();
        }

        public void onStart() {
            super.onStart();
        }

        public void onNext(UserToken userToken) {
            ((f) UserLoginPresenter.this.getUI()).n3();
            UserLoginPresenter.this.X0(userToken, this.f76050b, this.f76051c, this.f76052d);
            ((f) UserLoginPresenter.this.getUI()).G0();
        }
    }

    public class c extends BaseSubscriber<RegisterPreliminaryCheckData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f76055b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f76056c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76057d;

        public c(String str, boolean z11, String str2) {
            this.f76055b = str;
            this.f76056c = z11;
            this.f76057d = str2;
        }

        /* renamed from: a */
        public void onNext(RegisterPreliminaryCheckData registerPreliminaryCheckData) {
            super.onNext(registerPreliminaryCheckData);
            if (registerPreliminaryCheckData == null) {
                ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_service_error));
            } else if (!registerPreliminaryCheckData.getIpValidSuccess()) {
                ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_regist_coutry_ban));
            } else if (!registerPreliminaryCheckData.getEmailValidSuccess()) {
                ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_register_email_not_available));
            } else {
                UserLoginPresenter.this.b2(this.f76055b, this.f76056c, this.f76057d);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_service_error));
        }
    }

    public class d extends BaseSubscriber<RegisterPreliminaryCheckData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f76059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f76060c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76061d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f76062e;

        public d(String str, boolean z11, String str2, String str3) {
            this.f76059b = str;
            this.f76060c = z11;
            this.f76061d = str2;
            this.f76062e = str3;
        }

        /* renamed from: a */
        public void onNext(RegisterPreliminaryCheckData registerPreliminaryCheckData) {
            super.onNext(registerPreliminaryCheckData);
            if (registerPreliminaryCheckData == null) {
                ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_service_error));
            } else if (!registerPreliminaryCheckData.getIpValidSuccess()) {
                ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_regist_coutry_ban));
            } else if (!registerPreliminaryCheckData.getEmailValidSuccess()) {
                ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_register_email_not_available));
            } else if (TextUtils.isEmpty(this.f76059b)) {
                UserLoginPresenter.this.c2(this.f76062e, this.f76060c, 2, this.f76061d);
            } else if (this.f76060c) {
                UserLoginPresenter userLoginPresenter = UserLoginPresenter.this;
                userLoginPresenter.Z1(this.f76061d, this.f76062e, userLoginPresenter.Q0(this.f76059b), (String) null, (String) null, false);
            } else {
                UserLoginPresenter userLoginPresenter2 = UserLoginPresenter.this;
                userLoginPresenter2.W1(this.f76062e, userLoginPresenter2.Q0(this.f76059b), (String) null, (String) null);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((f) UserLoginPresenter.this.getUI()).q1(UserLoginPresenter.this.getResources().getString(R.string.n_service_error));
        }
    }

    public class e extends EasySubscriber<Object> {
        public e() {
        }

        public void onAfter() {
            super.onAfter();
            ((f) UserLoginPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((f) UserLoginPresenter.this.getUI()).G0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            int i11;
            ((f) UserLoginPresenter.this.getUI()).G0();
            try {
                i11 = i6.m.k0(aPIStatusErrorException.getErrCode());
            } catch (Exception e11) {
                e11.printStackTrace();
                i11 = 0;
            }
            if (i11 == 10051 || i11 == 10061) {
                f fVar = (f) UserLoginPresenter.this.getUI();
                if (fVar instanceof UserRegisterActivityV3) {
                    ((UserRegisterActivityV3) fVar).Qh(aPIStatusErrorException.getErrMsg());
                }
            } else if (i11 == 10210) {
                ((f) UserLoginPresenter.this.getUI()).m7();
            } else if (i11 != 14300) {
                ((f) UserLoginPresenter.this.getUI()).q1(aPIStatusErrorException.getErrMsg());
            } else {
                UserLoginPresenter.this.d2();
                ((f) UserLoginPresenter.this.getUI()).q1(aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            ((f) UserLoginPresenter.this.getUI()).r2();
            ((f) UserLoginPresenter.this.getUI()).G0();
            ((f) UserLoginPresenter.this.getUI()).K0();
        }

        public void onStart() {
            super.onStart();
        }
    }

    public interface f extends g {
        void C9(String str, String str2, int i11, RiskControl riskControl);

        void G0();

        void Hg(FollowTypeData followTypeData, HashMap<String, Object> hashMap);

        boolean I0();

        void K0();

        void Ma();

        LoginSuccBean Pf();

        void b2();

        void dh();

        void g2(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map);

        void ge(boolean z11, String str, String str2, boolean z12, String str3, Map<String, Object> map);

        String getAccount();

        void h5();

        void m7();

        void n3();

        void p2(int i11, String str, String str2, String str3, Map<String, Object> map);

        void q1(String str);

        void r2();

        void yg();
    }

    public static /* synthetic */ UserToken A1(UserToken userToken, Object obj) {
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable B1(UserToken userToken) {
        if (P0() != null) {
            return I0().map(new h(userToken));
        }
        return Observable.just(userToken);
    }

    public static /* synthetic */ UserToken C1(boolean z11, UserToken userToken, UserInfoData userInfoData) {
        if (z11 && userInfoData != null) {
            tg.h.c().g(userInfoData.i(), true);
        }
        r.x().i0(userInfoData);
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E1(List list) {
        if (list == null || list.isEmpty()) {
            this.f76047h.clear();
            return;
        }
        this.f76047h.clear();
        this.f76047h.addAll(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F1(Throwable th2) {
        this.f76047h.clear();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G1(String str, RiskControl riskControl) {
        if (riskControl.getRisk() <= 0) {
            ((f) getUI()).r2();
        } else if (riskControl.getRisk() == 1) {
            HuobiToastUtil.m(getResources().getString(R.string.n_user_center_risk_tips));
            ((f) getUI()).G0();
        } else if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
            ((f) getUI()).C9(str, (String) null, -1, riskControl);
        } else {
            ((f) getUI()).Ma();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H1(String str, int i11, RiskControl riskControl) {
        if (riskControl.getRisk() <= 0) {
            ((f) getUI()).r2();
        } else if (riskControl.getRisk() == 1) {
            HuobiToastUtil.m(getResources().getString(R.string.n_user_center_risk_tips));
            ((f) getUI()).G0();
        } else if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
            ((f) getUI()).C9(str, "", i11, riskControl);
        } else {
            ((f) getUI()).Ma();
        }
    }

    public static /* synthetic */ void Z0(UcIntCodeResponse ucIntCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (ucIntCodeResponse == null) {
            subscriber.onError(new APIStatusErrorException("", ""));
        } else if (ucIntCodeResponse.isSuccess()) {
            subscriber.onNext(ucIntCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(ucIntCodeResponse.getCode()), ucIntCodeResponse.getMessage(), ucIntCodeResponse.getData()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c1() {
        if (P0() != null) {
            Intent intent = new Intent();
            intent.putExtra("PARAM_BIND_RESULT", true);
            getActivity().setResult(0, intent);
        }
        ((f) getUI()).dismissProgressDialog();
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1(boolean z11, Object obj) {
        i.b().g(new l(this), 50);
        tg.f.j(4);
        if (this.f76043d) {
            Intent a11 = k0.a(getActivity());
            UserLoginHelper.e().j(getActivity(), new JumpTarget(a11, a11));
        } else {
            UserLoginHelper.e().j(getActivity(), this.f76041b);
        }
        if (!z11) {
            if (((f) getUI()).I0()) {
                HistoryAccountDataManager.a().k(this.f76040a);
            } else {
                HistoryAccountDataManager.a().j(this.f76040a);
            }
        }
        is.a.q("000004", (Map<String, Object>) null);
    }

    public static /* synthetic */ Observable g1(UcIntCodeResponse ucIntCodeResponse) {
        if (10070 == ucIntCodeResponse.getCode()) {
            return Observable.error(new UcNeed2FAStatus(ucIntCodeResponse));
        }
        if (10077 == ucIntCodeResponse.getCode() || 10078 == ucIntCodeResponse.getCode()) {
            return Observable.error(new TrustDeviceStatus(ucIntCodeResponse));
        }
        return Observable.just(ucIntCodeResponse);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ UserToken h1(LoginInfoData loginInfoData) {
        if (loginInfoData.isForbidCountry()) {
            q0.d().h(loginInfoData.getForbidCountryMessage());
        }
        UserToken userToken = new UserToken();
        userToken.h(loginInfoData.getTicket());
        userToken.i(loginInfoData.getUcToken());
        this.f76046g = loginInfoData.isBindPassKey();
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    public static /* synthetic */ UserToken i1(UserToken userToken, Object obj) {
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable j1(UserToken userToken) {
        if (P0() != null) {
            return I0().map(new j(userToken));
        }
        return Observable.just(userToken);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k1(LoginInfoData loginInfoData) {
        ((f) getUI()).h5();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ UserToken l1(LoginInfoData loginInfoData) {
        UserToken userToken = new UserToken();
        userToken.h(loginInfoData.getTicket());
        userToken.i(loginInfoData.getUcToken());
        this.f76046g = loginInfoData.isBindPassKey();
        k.d("HBPasskey", "2fa login success showPasskey!" + this.f76046g);
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    public static /* synthetic */ UserToken m1(UserToken userToken, Object obj) {
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable n1(UserToken userToken) {
        if (P0() != null) {
            return I0().map(new un.i(userToken));
        }
        return Observable.just(userToken);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ UserToken o1(UserToken userToken, UserInfoData userInfoData) {
        r.x().i0(userInfoData);
        tg.h.c().g(userInfoData.i(), this.f76046g && !tg.h.c().d());
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable p1(UserToken userToken) {
        return r.x().f0(false).map(new t(this, userToken));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q1(String str, String str2, boolean z11, String str3, RiskControl riskControl) {
        if (riskControl.getRisk() <= 0) {
            I1(S0(str, str2, (HashMap<String, Object>) null), z11, str3);
        } else if (riskControl.getRisk() == 1) {
            HuobiToastUtil.m(getResources().getString(R.string.n_user_center_risk_tips));
            ((f) getUI()).G0();
        } else if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
            ((f) getUI()).C9(str, str2, -1, riskControl);
        } else {
            ((f) getUI()).Ma();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r1(APIStatusErrorException aPIStatusErrorException) {
        ((f) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s1(Throwable th2) {
        ((f) getUI()).G0();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t1(String str, String str2, int i11, RiskControl riskControl) {
        if (riskControl.getRisk() <= 0) {
            return;
        }
        if (riskControl.getRisk() == 1) {
            HuobiToastUtil.m(getResources().getString(R.string.n_user_center_risk_tips));
            ((f) getUI()).G0();
        } else if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
            ((f) getUI()).C9(str, str2, i11, riskControl);
        } else {
            ((f) getUI()).Ma();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1(APIStatusErrorException aPIStatusErrorException) {
        ((f) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(Throwable th2) {
        ((f) getUI()).G0();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable w1(UcIntCodeResponse ucIntCodeResponse) {
        String str = f76039i;
        k.o(str, "Third login loginWithThirdAccount  " + ucIntCodeResponse);
        if (10070 == ucIntCodeResponse.getCode()) {
            ((f) getUI()).dismissProgressDialog();
            return Observable.error(new UcNeed2FAStatus(ucIntCodeResponse));
        } else if (10077 == ucIntCodeResponse.getCode() || 10078 == ucIntCodeResponse.getCode()) {
            ((f) getUI()).dismissProgressDialog();
            return Observable.error(new TrustDeviceStatus(ucIntCodeResponse));
        } else {
            if (50001 == ucIntCodeResponse.getCode()) {
                EventBus.d().k(new HKPayOffEvent());
            }
            return Observable.just(ucIntCodeResponse);
        }
    }

    public static /* synthetic */ UserToken x1(LoginInfoData loginInfoData) {
        UserToken userToken = new UserToken();
        userToken.h(loginInfoData.getTicket());
        userToken.i(loginInfoData.getUcToken());
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ UserToken y1(UserToken userToken, UserInfoData userInfoData) {
        r.x().i0(userInfoData);
        if (!TextUtils.isEmpty(userInfoData.e())) {
            this.f76040a = userInfoData.e();
        } else if (!TextUtils.isEmpty(userInfoData.h())) {
            this.f76040a = userInfoData.h();
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable z1(UserToken userToken) {
        return r.x().f0(false).map(new u(this, userToken));
    }

    public void H0() {
        rn.c.i().w(this.f76042c, getActivity(), this.f76043d);
    }

    public Observable<Object> I0() {
        return UserCenterRemoteDataSource.A().n(O0(), new HashMap()).compose(c0.f60863b);
    }

    public void I1(Map<String, Object> map, boolean z11, String str) {
        if (map != null) {
            map.put("login_version", 3);
            map.put(VulcanInfo.VTOKEN, ku.b.e().h(getActivity()));
            if (z11 && !TextUtils.isEmpty(str)) {
                map.put("country_code", str);
            }
        }
        UserCenterRemoteDataSource.A().g0(map).flatMap(y.f60903b).compose(p.c0()).map(new un.m(this)).flatMap(new o(this)).flatMap(b0.f60860b).compose(RxJavaHelper.t((g) getUI())).subscribe(K0(false));
    }

    public final void J0(LoginInfoData loginInfoData, Map<String, Object> map) {
        if (loginInfoData.getRequireTypes() != null && loginInfoData.getRequireTypes().size() > 0) {
            List<LoginInfoData.Login2FAOption> requireTypes = loginInfoData.getRequireTypes();
            String str = "";
            String str2 = str;
            boolean z11 = false;
            for (int i11 = 0; i11 < requireTypes.size(); i11++) {
                LoginInfoData.Login2FAOption login2FAOption = requireTypes.get(i11);
                int type = login2FAOption.getType();
                if (type == 1) {
                    z11 = true;
                } else if (type == 2) {
                    str = login2FAOption.getTag();
                } else if (type == 3) {
                    str2 = login2FAOption.getTag();
                }
            }
            ((f) getUI()).ge(z11, str, str2, false, loginInfoData.getToken(), map);
        } else if (loginInfoData.getSwitchTypes() != null && loginInfoData.getSwitchTypes().size() > 0) {
            ((f) getUI()).g2(loginInfoData.getSwitchTypes(), loginInfoData.getToken(), map);
        }
    }

    public void J1(String str, Map<String, Object> map, String str2) {
        ((f) getUI()).showProgressDialog();
        this.f76040a = str;
        UserCenterRemoteDataSource.A().h0(str2, map).compose(p.c0()).doOnNext(new f0(this)).map(new n(this)).flatMap(new q(this)).flatMap(new s(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(K0(true));
    }

    public final EasySubscriber<UserToken> K0(boolean z11) {
        return L0(z11, false);
    }

    public void K1(String str, String str2, boolean z11, String str3) {
        this.f76040a = str;
        this.f76044e = "";
        UserCenterRemoteDataSource.A().t0(str, P0() == null ? 2 : 1, z11 ? str3 : null).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new un.f(this, str, str2, z11, str3), new e0(this), new i0(this)));
    }

    public final EasySubscriber<UserToken> L0(boolean z11, boolean z12) {
        return N0(z11, !TextUtils.isEmpty(this.f76044e), !TextUtils.isEmpty(this.f76044e) ? this.f76044e : P0(), z12);
    }

    public void L1(String str, String str2, int i11, boolean z11, String str3) {
        this.f76040a = str;
        this.f76044e = "";
        UserCenterRemoteDataSource A = UserCenterRemoteDataSource.A();
        int i12 = P0() == null ? 2 : 1;
        if (!z11) {
            str3 = null;
        }
        A.t0(str, i12, str3).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new un.e(this, str, str2, i11), new d0(this), new h0(this)));
    }

    public final EasySubscriber<UserToken> M0(boolean z11, boolean z12, String str) {
        return N0(z11, z11, str, false);
    }

    public void M1(String str, boolean z11, String str2, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("login_name", str);
        if (z11 && !TextUtils.isEmpty(str2)) {
            hashMap2.put("country_code", str2);
        }
        VerifyHelper.k(hashMap2, hashMap);
        o9.a.a().loginNameIsInvalid(hashMap2).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(hashMap));
    }

    public final EasySubscriber<UserToken> N0(boolean z11, boolean z12, String str, boolean z13) {
        return new b(z12, str, z13, z11);
    }

    public void N1(String str, String str2, HashMap<String, Object> hashMap, boolean z11, String str3) {
        Map<String, Object> S0 = S0(str, str2, hashMap);
        if (P0() == null) {
            I1(S0, z11, str3);
            return;
        }
        ((f) getUI()).p2(StringUtils.o(str) ? 3 : 2, StringUtils.o(str) ? null : str, StringUtils.o(str) ? str : null, (String) null, S0);
    }

    public String O0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("third_token")) {
            return null;
        }
        return intent.getExtras().getString("third_token");
    }

    public void O1(String str, String str2, HashMap<String, Object> hashMap, boolean z11, String str3, String str4) {
        Map<String, Object> S0 = S0(str, str2, hashMap);
        S0.put("token", str4);
        if (P0() == null) {
            I1(S0, z11, str3);
            return;
        }
        int i11 = StringUtils.o(str) ? 3 : 2;
        f fVar = (f) getUI();
        String str5 = null;
        String str6 = StringUtils.o(str) ? null : str;
        if (StringUtils.o(str)) {
            str5 = str;
        }
        fVar.p2(i11, str6, str5, (String) null, S0);
    }

    public String P0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindType")) {
            return null;
        }
        return intent.getExtras().getString("bindType");
    }

    public void P1(String str, String str2, String str3, String str4, boolean z11, String str5) {
        this.f76040a = str;
        String c11 = MD5Utils.c(str2);
        HashMap hashMap = new HashMap();
        hashMap.put("login_name", str);
        hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, c11);
        hashMap.put("way", "APP_HUOBI_PRO");
        hashMap.put("captcha_key", str4);
        hashMap.put("captcha_code", str3);
        int i11 = 3;
        hashMap.put("login_version", 3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        if (P0() == null) {
            I1(hashMap, z11, str5);
            return;
        }
        if (!StringUtils.o(str)) {
            i11 = 2;
        }
        ((f) getUI()).p2(i11, StringUtils.o(str) ? null : str, StringUtils.o(str) ? str : null, (String) null, hashMap);
        ((f) getUI()).dismissProgressDialog();
    }

    public final HashMap<String, Object> Q0(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("token", str);
        return hashMap;
    }

    public void Q1(String str, String str2) {
        this.f76044e = str2;
        String str3 = f76039i;
        k.o(str3, "Third login loginWithThirdAccount  " + str + " thirdType:" + str2);
        UserCenterRemoteDataSource.A().j0(str).flatMap(new un.k(this)).compose(p.c0()).map(a0.f60858b).flatMap(new un.r(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(M0(false, true, str2));
    }

    public JumpTarget R0() {
        return this.f76042c;
    }

    public void R1(String str, String str2, String str3) {
        S1(str, str2, str3, false);
    }

    public final Map<String, Object> S0(String str, String str2, HashMap<String, Object> hashMap) {
        String c11 = MD5Utils.c(str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("login_name", str);
        hashMap2.put(MTCoreConstants.Register.KEY_PASSWORD, c11);
        hashMap2.put("way", "APP_HUOBI_PRO");
        hashMap2.put("ga_switch", Boolean.TRUE);
        hashMap2.put("login_version", 3);
        VerifyHelper.k(hashMap2, hashMap);
        hashMap2.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        return hashMap2;
    }

    public void S1(String str, String str2, String str3, boolean z11) {
        this.f76040a = str;
        ((f) getUI()).showProgressDialog();
        UserToken userToken = new UserToken();
        userToken.h(str3);
        userToken.i(str2);
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        Observable.just(userToken).flatMap(new un.p(this)).flatMap(new v(z11)).compose(RxJavaHelper.t((g) getUI())).subscribe(L0(false, z11));
    }

    public void T0(Intent intent) {
        this.f76043d = intent.getBooleanExtra("login_multiple_account", false);
    }

    /* renamed from: T1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        Bundle extras;
        super.onUIReady(baseCoreActivity, fVar);
        Intent intent = getActivity().getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("target"))) {
            kn.a aVar = (kn.a) extras.get("target");
            this.f76041b = aVar;
            if (aVar instanceof JumpTarget) {
                this.f76042c = (JumpTarget) aVar;
            }
        }
        if (tg.g.b()) {
            r.x().j();
        }
        ((f) getUI()).b2();
        Y1();
    }

    public List<String> U0() {
        return this.f76047h;
    }

    public void U1(Map<String, Object> map, String str, boolean z11, String str2) {
        this.f76044e = "";
        o9.a.a().registerPreliminaryCheck(map).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new c(str, z11, str2));
    }

    public final EasySubscriber<Object> V0() {
        return new e();
    }

    public void V1(Map<String, Object> map, String str, boolean z11, String str2, String str3) {
        this.f76044e = "";
        o9.a.a().registerPreliminaryCheck(map).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new d(str3, z11, str2, str));
    }

    public final void W0(APIStatusErrorException aPIStatusErrorException, boolean z11, LoginInfoData loginInfoData) {
        ((f) getUI()).dismissProgressDialog();
        String errCode = aPIStatusErrorException.getErrCode();
        String errMsg = aPIStatusErrorException.getErrMsg();
        String str = f76039i;
        Log.e(str, "handleUserLoginError: code:" + errCode + ",msg:" + errMsg);
        if (!TextUtils.isEmpty(errCode)) {
            int l02 = i6.m.l0(errCode, -1);
            if (l02 != 10013) {
                if (l02 != 10015) {
                    if (l02 == 10039) {
                        ((f) getUI()).G0();
                        HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                        return;
                    } else if (l02 == 10070) {
                        ((f) getUI()).K0();
                        HashMap hashMap = new HashMap();
                        hashMap.put("isKnowDevice", Boolean.valueOf(loginInfoData.isKnowDevice()));
                        J0(loginInfoData, hashMap);
                        return;
                    } else if (l02 == 10080) {
                        ((f) getUI()).K0();
                        return;
                    } else if (!(l02 == 10082 || l02 == 11005)) {
                        if (l02 == 14100) {
                            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                            ((f) getUI()).G0();
                            if (aPIStatusErrorException.getData() instanceof LoginInfoData) {
                                this.f76045f = (LoginInfoData) aPIStatusErrorException.getData();
                                Intent intent = new Intent(getActivity(), BrushSecurityVerifyActivity.class);
                                intent.putExtra("AUTH_TOKEN", this.f76045f.getAuthToken());
                                getActivity().startActivityForResult(intent, BaseConstants.ERR_SVR_CONV_INVALID_PARAMETERS);
                                return;
                            }
                            this.f76045f = null;
                            return;
                        } else if (l02 != 14300) {
                            switch (l02) {
                                case 50000:
                                    ((f) getUI()).q1(errMsg);
                                    ((f) getUI()).G0();
                                    HbgDialogManager.A().j0(968, 0, "template/zh-CN/968.html", 0, "", "", "", "", "0");
                                    return;
                                case BaseConstants.ERR_SVR_CONV_ACCOUNT_NOT_FOUND:
                                    EventBus.d().k(new HKPayOffEvent());
                                    ((f) getUI()).G0();
                                    return;
                                default:
                                    HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                                    ((f) getUI()).G0();
                                    return;
                            }
                        } else {
                            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                            ((f) getUI()).G0();
                            d2();
                            return;
                        }
                    }
                }
                if (z11) {
                    ((f) getUI()).h5();
                }
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                ((f) getUI()).G0();
                return;
            }
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            ((f) getUI()).yg();
            ((f) getUI()).G0();
        }
    }

    public void W1(String str, HashMap<String, Object> hashMap, String str2, String str3) {
        UserCenterRemoteDataSource.A().x(str, "AUTH_CODE_LOGIN_REGISTER", hashMap, str2, str3).compose(RxJavaHelper.t((g) getUI())).compose(p.c0()).subscribe(V0());
    }

    public final void X0(UserToken userToken, boolean z11, String str, boolean z12) {
        Boolean bool;
        String str2 = f76039i;
        k.o(str2, "handleUserLoginSuccess thirdType:" + str + " mLoginName:" + this.f76040a);
        f fVar = (f) getUI();
        if (fVar instanceof UserLoginActivityV4) {
            bool = Boolean.FALSE;
        } else {
            bool = fVar instanceof UserRegisterActivityV3 ? Boolean.TRUE : null;
        }
        wn.c0.j(this.f76040a, bool, str, fVar.Pf(), z12);
        sn.l.q(userToken, this.f76040a, getActivity(), false, new un.a(this, z11));
    }

    public void X1(String str, HashMap<String, Object> hashMap, String str2, String str3, int i11) {
        UserCenterRemoteDataSource.A().y(str, "AUTH_CODE_LOGIN_REGISTER", hashMap, str2, str3, i11).compose(RxJavaHelper.t((g) getUI())).compose(p.c0()).subscribe(V0());
    }

    public boolean Y0() {
        return this.f76043d;
    }

    public void Y1() {
        UserCenterRemoteDataSource.A().getRegisterShieldWords().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new un.b(this), (Action1<Throwable>) new g0(this));
    }

    public void Z1(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4, boolean z11) {
        UserCenterRemoteDataSource.A().J(str, str2, "AUTH_CODE_LOGIN_REGISTER", hashMap, str3, str4, z11).compose(RxJavaHelper.t((g) getUI())).compose(p.c0()).subscribe(V0());
    }

    public void a2(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4, boolean z11, int i11) {
        UserCenterRemoteDataSource.A().K(str, str2, "AUTH_CODE_LOGIN_REGISTER", hashMap, str3, str4, z11, i11).compose(RxJavaHelper.t((g) getUI())).compose(p.c0()).subscribe(V0());
    }

    public void b2(String str, boolean z11, String str2) {
        UserCenterRemoteDataSource A = UserCenterRemoteDataSource.A();
        if (!z11) {
            str2 = null;
        }
        A.t0(str, 1, str2).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new un.c(this, str)));
    }

    public void c2(String str, boolean z11, int i11, String str2) {
        UserCenterRemoteDataSource A = UserCenterRemoteDataSource.A();
        if (!z11) {
            str2 = null;
        }
        A.t0(str, 1, str2).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new un.d(this, str, i11)));
    }

    public void d2() {
        String account = ((f) getUI()).getAccount();
        wn.c0.i(account, Boolean.FALSE, !TextUtils.isEmpty(this.f76044e) ? this.f76044e : P0(), ((f) getUI()).Pf());
        Intent intent = new Intent(getActivity(), wn.c0.h() ? UserLoginActivityV4.class : UserLoginActivityV2.class);
        intent.putExtra("login_multiple_account", Y0());
        if (R0() != null) {
            intent.putExtra("target", R0());
        }
        intent.putExtra("login_name", account);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
        getActivity().finish();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        k.o(f76039i, "onActivityResult");
        super.onActivityResult(i11, i12, intent);
        if (i11 != 50001 || intent == null) {
            if (i11 == 50002 && i12 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("TEMP_GA_VERIFY_PASS_TOKEN");
                String str = f76039i;
                i6.d.e(str, "tempGaVerifyPassToken:" + stringExtra);
                if (this.f76045f != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("isKnowDevice", Boolean.valueOf(this.f76045f.isKnowDevice()));
                    hashMap.put("temp_ga_verify_pass_token", stringExtra);
                    J0(this.f76045f, hashMap);
                }
                this.f76045f = null;
            }
        } else if (intent.getBooleanExtra("PARAM_BIND_RESULT", false)) {
            getActivity().finish();
        }
    }
}
