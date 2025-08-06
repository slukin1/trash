package com.huobi.login.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.CheckInviteCodeResult;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.core.utils.LicenseType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.facebook.FaceBookUtil;
import com.huobi.index.api.IndexService;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.bean.RegisterPreliminaryCheckData;
import com.huobi.login.usercenter.data.source.bean.RegisterResult;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.utils.HistoryAccountDataManager;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.k0;
import com.huobi.utils.x;
import com.tencent.android.tpush.common.Constants;
import i6.k;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nn.a2;
import nn.a3;
import nn.b2;
import nn.b3;
import nn.c2;
import nn.d2;
import nn.e2;
import nn.f2;
import nn.g2;
import nn.h2;
import nn.i2;
import nn.j2;
import nn.k2;
import nn.l2;
import nn.m2;
import nn.n2;
import nn.o2;
import nn.q2;
import nn.t2;
import nn.u2;
import nn.v2;
import nn.w1;
import nn.w2;
import nn.x1;
import nn.x2;
import nn.y1;
import nn.y2;
import nn.z1;
import nn.z2;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import sn.l;
import sn.w;
import tg.r;
import tq.p;
import wn.c0;

public class UserRegisterV2Presenter extends ActivityPresenter<j> {

    /* renamed from: a  reason: collision with root package name */
    public final CompositeSubscription f75517a = new CompositeSubscription();

    /* renamed from: b  reason: collision with root package name */
    public Intent f75518b;

    /* renamed from: c  reason: collision with root package name */
    public String f75519c;

    /* renamed from: d  reason: collision with root package name */
    public String f75520d;

    /* renamed from: e  reason: collision with root package name */
    public String f75521e;

    /* renamed from: f  reason: collision with root package name */
    public String f75522f;

    /* renamed from: g  reason: collision with root package name */
    public String f75523g;

    /* renamed from: h  reason: collision with root package name */
    public String f75524h;

    /* renamed from: i  reason: collision with root package name */
    public String f75525i;

    /* renamed from: j  reason: collision with root package name */
    public String f75526j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f75527k = new ArrayList();

    public class a extends EasySubscriber<CheckInviteCodeResult> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(CheckInviteCodeResult checkInviteCodeResult) {
            super.onNext(checkInviteCodeResult);
            if (checkInviteCodeResult == null || !checkInviteCodeResult.isValid()) {
                ((j) UserRegisterV2Presenter.this.getUI()).q1(UserRegisterV2Presenter.this.getResources().getString(R.string.n_invite_code_error));
                ((j) UserRegisterV2Presenter.this.getUI()).B9();
                return;
            }
            ((j) UserRegisterV2Presenter.this.getUI()).lg();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((j) UserRegisterV2Presenter.this.getUI()).B9();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((j) UserRegisterV2Presenter.this.getUI()).B9();
        }
    }

    public class b extends EasySubscriber<Object> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
            ((j) UserRegisterV2Presenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((j) UserRegisterV2Presenter.this.getUI()).G0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            int i11;
            ((j) UserRegisterV2Presenter.this.getUI()).G0();
            try {
                i11 = m.k0(aPIStatusErrorException.getErrCode());
            } catch (Exception e11) {
                e11.printStackTrace();
                i11 = 0;
            }
            if (i11 == 10039) {
                UserRegisterV2Presenter.this.w1();
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            } else if (i11 == 10051 || i11 == 10061) {
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                ((j) UserRegisterV2Presenter.this.getUI()).g6();
            } else {
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            ((j) UserRegisterV2Presenter.this.getUI()).Vc();
            ((j) UserRegisterV2Presenter.this.getUI()).G0();
            ((j) UserRegisterV2Presenter.this.getUI()).K0();
        }

        public void onStart() {
            super.onStart();
        }
    }

    public class c extends q6.d<VerifyAuthCodeData> {
        public c(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(VerifyAuthCodeData verifyAuthCodeData) {
            super.onNext(verifyAuthCodeData);
            String flowType = verifyAuthCodeData.getFlowType();
            if (VerifyAuthCodeData.FLOW_TYPE_LOGIN.equals(flowType)) {
                ((j) UserRegisterV2Presenter.this.getUI()).Me(verifyAuthCodeData);
            } else if (VerifyAuthCodeData.FLOW_TYPE_LOGIN_2FA.equals(flowType)) {
                ((j) UserRegisterV2Presenter.this.getUI()).Me(verifyAuthCodeData);
            } else if (VerifyAuthCodeData.FLOW_TYPE_REGISTER.equals(flowType)) {
                ((j) UserRegisterV2Presenter.this.getUI()).V8(verifyAuthCodeData.getAuthToken());
            }
        }

        public void onError2(Throwable th2) {
            ((j) UserRegisterV2Presenter.this.getUI()).se(th2.getMessage());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((j) UserRegisterV2Presenter.this.getUI()).se(aPIStatusErrorException.getErrMsg());
        }
    }

    public class d extends EasySubscriber<AccountVerifyBean> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(AccountVerifyBean accountVerifyBean) {
            super.onNext(accountVerifyBean);
            if (accountVerifyBean == null) {
                Log.e("CaptchaCodeActivityV2", "onNext: data == null");
            } else if (accountVerifyBean.isRegistered()) {
                ((j) UserRegisterV2Presenter.this.getUI()).J8(accountVerifyBean);
            } else {
                ((j) UserRegisterV2Presenter.this.getUI()).V8(accountVerifyBean.getToken());
            }
        }

        public void onAfter() {
            super.onAfter();
            ((j) UserRegisterV2Presenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((j) UserRegisterV2Presenter.this.getUI()).se(th2.getMessage());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((j) UserRegisterV2Presenter.this.getUI()).se(aPIStatusErrorException.getErrMsg());
        }
    }

    public class e implements Action1<APIStatusErrorException> {
        public e() {
        }

        /* renamed from: a */
        public void call(APIStatusErrorException aPIStatusErrorException) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_success", Boolean.FALSE);
            hashMap.put("fail_reason", aPIStatusErrorException.getErrMsg());
            gs.g.i("sub_register_result", hashMap);
            aPIStatusErrorException.printStackTrace();
            if ("11653".equals(aPIStatusErrorException.getErrCode())) {
                HuobiToastUtil.j(R.string.third_login_bind_error_rebind);
            }
            ((j) UserRegisterV2Presenter.this.getUI()).G0();
            k.g("UserRegister", "registerUser has error 1", aPIStatusErrorException);
            ((j) UserRegisterV2Presenter.this.getUI()).B4();
        }
    }

    public class f implements Action1<Throwable> {
        public f() {
        }

        /* renamed from: a */
        public void call(Throwable th2) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_success", Boolean.FALSE);
            hashMap.put("fail_reason", th2.getMessage());
            gs.g.i("sub_register_result", hashMap);
            th2.printStackTrace();
            ((j) UserRegisterV2Presenter.this.getUI()).G0();
            k.g("UserRegister", "registerUser has error 2", th2);
            ((j) UserRegisterV2Presenter.this.getUI()).B4();
        }
    }

    public class g extends BaseSubscriber<RegisterPreliminaryCheckData> {
        public g() {
        }

        /* renamed from: a */
        public void onNext(RegisterPreliminaryCheckData registerPreliminaryCheckData) {
            super.onNext(registerPreliminaryCheckData);
            if (registerPreliminaryCheckData == null) {
                ((j) UserRegisterV2Presenter.this.getUI()).q1(UserRegisterV2Presenter.this.getResources().getString(R.string.n_service_error));
            } else if (!registerPreliminaryCheckData.getIpValidSuccess()) {
                ((j) UserRegisterV2Presenter.this.getUI()).q1(UserRegisterV2Presenter.this.getResources().getString(R.string.n_regist_coutry_ban));
            } else if (!registerPreliminaryCheckData.getEmailValidSuccess()) {
                ((j) UserRegisterV2Presenter.this.getUI()).q1(UserRegisterV2Presenter.this.getResources().getString(R.string.n_register_email_not_available));
            } else {
                ((j) UserRegisterV2Presenter.this.getUI()).lg();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((j) UserRegisterV2Presenter.this.getUI()).q1(UserRegisterV2Presenter.this.getResources().getString(R.string.n_service_error));
        }
    }

    public class h extends BaseSubscriber<HomeActivityEntityResponse> {
        public h() {
        }

        /* renamed from: a */
        public void onNext(HomeActivityEntityResponse homeActivityEntityResponse) {
            super.onNext(homeActivityEntityResponse);
            ((j) UserRegisterV2Presenter.this.getUI()).U8(homeActivityEntityResponse);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class i extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f75536b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HashMap f75537c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f75538d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f75539e;

        public i(String str, HashMap hashMap, String str2, String str3) {
            this.f75536b = str;
            this.f75537c = hashMap;
            this.f75538d = str2;
            this.f75539e = str3;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
        }

        public void onAfter() {
            super.onAfter();
            ((j) UserRegisterV2Presenter.this.getUI()).ob(this.f75536b, this.f75537c, this.f75538d, this.f75539e);
        }
    }

    public interface j extends u6.g {
        void B4();

        void B9();

        void G0();

        void J8(AccountVerifyBean accountVerifyBean);

        void K0();

        void Me(VerifyAuthCodeData verifyAuthCodeData);

        void Q0(Bitmap bitmap);

        void U8(HomeActivityEntityResponse homeActivityEntityResponse);

        void V8(String str);

        void Vc();

        void c5(String str, String str2, String str3, String str4, boolean z11);

        void e7(String str);

        void g6();

        void lg();

        void ob(String str, HashMap<String, Object> hashMap, String str2, String str3);

        void q1(String str);

        void q4(String str, String str2, String str3, boolean z11, RiskControl riskControl);

        void se(String str);
    }

    public static /* synthetic */ void L0(UcIntCodeResponse ucIntCodeResponse, Subscriber subscriber) {
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

    public static /* synthetic */ UserToken O0(RegisterResult registerResult) {
        UserToken userToken = new UserToken();
        userToken.h(registerResult.a());
        userToken.i(registerResult.b());
        userToken.j(registerResult.c());
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Q0(UserToken userToken) {
        return u1(userToken.c()).map(new o2(userToken));
    }

    public static /* synthetic */ UserToken R0(UserToken userToken, Object obj) {
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable S0(UserToken userToken) {
        if (F0() == null || E0() == null) {
            return Observable.just(userToken);
        }
        return y0().map(new q2(userToken));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V0() {
        getActivity().finish();
        if (F0() != null && E0() != null) {
            Intent intent = new Intent();
            intent.putExtra("PARAM_BIND_RESULT", true);
            getActivity().setResult(-1, intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W0(Object obj) {
        Intent intent;
        if (LiteReHelper.a().b()) {
            intent = new Intent(getActivity(), LiteReMainActivity.class);
        } else {
            intent = k0.h(getActivity());
        }
        UserLoginHelper.e().j(getActivity(), new JumpTarget(intent, intent));
        i6.i.b().g(new h2(this), 50);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X0(LoginSuccBean loginSuccBean, UserToken userToken) {
        w.j().m((CountryListData) null);
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.TRUE;
        hashMap.put("is_success", bool);
        hashMap.put("fail_reason", "");
        gs.g.i("sub_register_result", hashMap);
        G1(userToken);
        H1();
        I1();
        gs.b.e(getActivity(), r.x().Q());
        HistoryAccountDataManager.a().j(this.f75526j);
        HuobiToastUtil.t(bh.j.c(), R.string.register_success);
        if (loginSuccBean != null) {
            c0.i(this.f75526j, bool, F0(), loginSuccBean);
        }
        l.q(userToken, this.f75526j, getActivity(), true, new w1(this));
        ConfigPreferences.n("user_config", "lite_chosen", false);
        if (K0()) {
            UserCenterRemoteDataSource.A().s0(LicenseType.TR_KYC).d((RequestCallback1) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y0(List list) {
        if (list == null || list.isEmpty()) {
            this.f75527k.clear();
            return;
        }
        this.f75527k.clear();
        this.f75527k.addAll(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(Throwable th2) {
        this.f75527k.clear();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(ImgCaptchaData imgCaptchaData) {
        this.f75520d = imgCaptchaData.getKey();
        ((j) getUI()).Q0(ImageUtils.i(imgCaptchaData.getImage()));
    }

    public static /* synthetic */ void c1() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1(String str, boolean z11, ImgCaptchaData imgCaptchaData) {
        this.f75520d = imgCaptchaData.getKey();
        ((j) getUI()).c5(imgCaptchaData.getImage(), str, (String) null, (String) null, z11);
    }

    public static /* synthetic */ void e1(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void f1(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1() {
        ((j) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1(String str, boolean z11, RiskControl riskControl) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_risk", String.valueOf(riskControl.getRisk()));
        hashMap.put("captcha_type", String.valueOf(riskControl.getCaptcha_type()));
        gs.g.i("app_safety_verification_view", hashMap);
        if (riskControl.getRisk() <= 0) {
            ((j) getUI()).Vc();
        } else if (riskControl.getRisk() == 1) {
            ((j) getUI()).q1(getResources().getString(R.string.n_user_center_risk_tips));
            ((j) getUI()).G0();
        } else if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
            ((j) getUI()).q4(str, (String) null, (String) null, z11, riskControl);
        } else {
            UserCenterRemoteDataSource.A().z().compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(z2.f58691b, new e2(this, str, z11), i2.f58610b, j2.f58616b, new x2(this)));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(String str, String str2, boolean z11, ImgCaptchaData imgCaptchaData) {
        this.f75520d = imgCaptchaData.getKey();
        ((j) getUI()).c5(imgCaptchaData.getImage(), (String) null, str, str2, z11);
    }

    public static /* synthetic */ void j1(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void k1(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1() {
        ((j) getUI()).G0();
        ((j) getUI()).dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m1(String str, String str2, boolean z11, RiskControl riskControl) {
        if (riskControl.getRisk() <= 0) {
            ((j) getUI()).Vc();
        } else if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
            ((j) getUI()).q4((String) null, str, str2, z11, riskControl);
        } else {
            UserCenterRemoteDataSource.A().z().compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(y2.f58685b, new c2(this, str, str2, z11), g2.f58601b, k2.f58620b, new w2(this)));
        }
    }

    public static /* synthetic */ void n1() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(Object obj, Object obj2, Object obj3) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", Boolean.TRUE);
        hashMap.put("fail_reason", "");
        hashMap.put("register_type", obj);
        hashMap.put("regain_code", obj2);
        gs.g.i("app_fill_in_code_sub", hashMap);
        ((j) getUI()).V8((String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p1(Object obj, Object obj2, APIStatusErrorException aPIStatusErrorException) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", Boolean.FALSE);
        hashMap.put("fail_reason", aPIStatusErrorException.getErrMsg());
        hashMap.put("register_type", obj);
        hashMap.put("regain_code", obj2);
        gs.g.i("app_fill_in_code_sub", hashMap);
        ((j) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q1(Object obj, Object obj2, Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", Boolean.FALSE);
        hashMap.put("fail_reason", th2.getMessage());
        hashMap.put("register_type", obj);
        hashMap.put("regain_code", obj2);
        gs.g.i("app_fill_in_code_sub", hashMap);
        ((j) getUI()).G0();
    }

    public final EasySubscriber<Object> A0() {
        return new b();
    }

    public void A1(String str, HashMap<String, Object> hashMap, String str2, String str3, String str4) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.k(getActivity(), R.string.string_network_disconnect);
            return;
        }
        this.f75517a.add(UserCenterRemoteDataSource.A().x(str, str4, hashMap, str2, str3).compose(RxJavaHelper.t((u6.g) getUI())).compose(p.c0()).subscribe(A0()));
    }

    public final Observable<HomeActivityEntityResponse> B0() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", 109);
        hashMap.put("userAgent", "M:huobiapp:phone:android");
        hashMap.put("channel_name", "huobi");
        hashMap.put("version", 105400);
        hashMap.put(Constants.FLAG_DEVICE_ID, PhoneUtils.e());
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        if (!TextUtils.isEmpty(r.x().J())) {
            hashMap.put("uId", r.x().J());
        }
        int g11 = yl.g.h().g();
        if (g11 == -1) {
            try {
                String a11 = sn.a.c().a();
                if (!com.hbg.module.libkt.base.ext.b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        String b11 = x.b();
        if (TextUtils.isEmpty(b11)) {
            b11 = "1";
        }
        HashMap hashMap2 = new HashMap();
        if (g11 > 0) {
            hashMap2.put("clientCountryId", Integer.valueOf(g11));
        }
        hashMap2.put("countryType", b11);
        return ((IndexService) p.C(IndexService.class)).requestAdvertisements(hashMap, hashMap2).compose(p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public void B1(String str, HashMap<String, Object> hashMap, String str2, String str3, String str4, int i11) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.k(getActivity(), R.string.string_network_disconnect);
            return;
        }
        this.f75517a.add(UserCenterRemoteDataSource.A().y(str, str4, hashMap, str2, str3, i11).compose(RxJavaHelper.t((u6.g) getUI())).compose(p.c0()).subscribe(A0()));
    }

    public String C0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindEmail")) {
            return null;
        }
        return intent.getExtras().getString("bindEmail");
    }

    public void C1(String str, boolean z11, int i11) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.k(getActivity(), R.string.string_network_disconnect);
            return;
        }
        this.f75517a.add(UserCenterRemoteDataSource.A().u0(str, i11).compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new f2(this, str, z11))));
    }

    public String D0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindPhone")) {
            return null;
        }
        return intent.getExtras().getString("bindPhone");
    }

    public void D1(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4, boolean z11, String str5) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.k(getActivity(), R.string.string_network_disconnect);
            return;
        }
        this.f75517a.add(UserCenterRemoteDataSource.A().J(str, str2, str5, hashMap, str3, str4, z11).compose(RxJavaHelper.t((u6.g) getUI())).compose(p.c0()).subscribe(A0()));
    }

    public String E0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("third_token")) {
            return null;
        }
        return intent.getExtras().getString("third_token");
    }

    public void E1(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4, boolean z11, String str5, int i11) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.k(getActivity(), R.string.string_network_disconnect);
            return;
        }
        this.f75517a.add(UserCenterRemoteDataSource.A().K(str, str2, str5, hashMap, str3, str4, z11, i11).compose(RxJavaHelper.t((u6.g) getUI())).compose(p.c0()).subscribe(A0()));
    }

    public String F0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null) {
            return null;
        }
        return intent.getExtras().getString("bindType");
    }

    public void F1(String str, String str2, boolean z11, int i11) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.k(getActivity(), R.string.string_network_disconnect);
            return;
        }
        this.f75517a.add(UserCenterRemoteDataSource.A().t0(str2, i11, str).compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new d2(this, str, str2, z11))));
    }

    public String G0() {
        return this.f75520d;
    }

    public final void G1(UserToken userToken) {
        if (this.f75519c.equals("register_email")) {
            gs.c.a(userToken.f());
        } else {
            gs.c.b(userToken.f());
        }
        gs.c.c();
        FaceBookUtil.a(getActivity());
    }

    public void H0(String str, HashMap<String, Object> hashMap, String str2, String str3) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("use_type", "REGISTER");
        hashMap2.put("email", str);
        UserCenterRemoteDataSource.A().getEmailSendResult(hashMap2).compose(RxJavaHelper.t((u6.g) getUI())).compose(p.c0()).subscribe(new i(str, hashMap, str2, str3));
    }

    public final void H1() {
        String str = this.f75519c.equals("register_email") ? "邮箱注册" : "手机注册";
        GrowingIOStatics.h("注册设置密码页", str);
        HashMap hashMap = new HashMap(2);
        hashMap.put("PM_APP_REGISTER_TYPE", str);
        gs.e.b().a("PM_REG_SUCCESS", true, hashMap);
    }

    public List<String> I0() {
        return this.f75527k;
    }

    public final void I1() {
        int i11 = 2;
        HashMap hashMap = new HashMap(2);
        hashMap.put("clientType", 1);
        if (this.f75519c.equals("register_email")) {
            i11 = 1;
        }
        hashMap.put("registerType", Integer.valueOf(i11));
        is.a.p(hashMap);
        is.a.t();
    }

    public boolean J0() {
        return E0() != null;
    }

    public void J1(String str) {
        this.f75519c = str;
    }

    public final boolean K0() {
        return String.valueOf(177).equals(this.f75522f);
    }

    public void K1(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("account_name", str);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("verify_code", str3);
        }
        if ("register_mobile".equals(this.f75519c) && !TextUtils.isEmpty(str2)) {
            hashMap.put("country_code", str2);
        }
        UserCenterRemoteDataSource.A().accountVerify(hashMap).compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public void L1(Map<String, Object> map) {
        Object obj = map.get("register_type");
        Object obj2 = map.get("regain_code");
        map.remove("register_type");
        map.remove("regain_code");
        this.f75517a.add(UserCenterRemoteDataSource.A().registerCodeVerify(map).compose(RxJavaHelper.t((u6.g) getUI())).compose(p.c0()).subscribe(q6.d.d((u6.g) getUI(), new b2(this, obj, obj2), new z1(this, obj, obj2), new a2(this, obj, obj2))));
    }

    public void M1(Map<String, Object> map) {
        this.f75517a.add(o9.a.a().verifyAuthCode(map).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new c((u6.g) getUI())));
    }

    public final void r1(Observable<RegisterResult> observable, LoginSuccBean loginSuccBean) {
        observable.map(t2.f58662b).flatMap(new n2(this)).flatMap(new m2(this)).flatMap(u2.f58667b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new y1(this, loginSuccBean), new e(), new f()));
    }

    /* renamed from: s1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, j jVar) {
        super.onUIReady(baseCoreActivity, jVar);
        this.f75518b = getActivity().getIntent();
        if (TextUtils.isEmpty(this.f75519c)) {
            this.f75519c = this.f75518b.getStringExtra("register_type");
        }
        if (TextUtils.isEmpty(this.f75519c)) {
            this.f75519c = "register_email";
        }
        ((j) getUI()).e7(this.f75519c);
        UserCenterRemoteDataSource.A().getRegisterShieldWords().compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new x1(this), (Action1<Throwable>) new b3(this));
    }

    public void t1(Map<String, Object> map) {
        o9.a.a().registerPreliminaryCheck(map).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    public final Observable<ProUserToken> u1(String str) {
        return UserCenterRemoteDataSource.A().m0(str).doOnError(l2.f58624b).compose(p.a0()).subscribeOn(Schedulers.io());
    }

    public void v1(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f75522f = str;
        this.f75523g = str2;
        this.f75521e = str4;
        if ("register_email".equals(this.f75519c)) {
            this.f75524h = str3;
            this.f75526j = str3;
        } else {
            this.f75525i = str3;
            this.f75526j = str3;
        }
        x1(str5, str6);
    }

    public void w1() {
        this.f75517a.add(UserCenterRemoteDataSource.A().z().compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new a3(this))));
    }

    public void x1(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("register_way", this.f75519c.equals("register_email") ? "EmailRegistration" : "MobileRegistration");
        hashMap.put("invite_code", TextUtils.isEmpty(str2) ? "" : str2);
        gs.g.i("sub_register", hashMap);
        r1(UserCenterRemoteDataSource.A().n0(str, this.f75525i, this.f75524h, this.f75523g, this.f75521e, this.f75522f, str2, "2", E0()).compose(p.c0()), (LoginSuccBean) null);
    }

    public Observable<Object> y0() {
        return UserCenterRemoteDataSource.A().n(E0(), new HashMap()).compose(v2.f58671b);
    }

    public void y1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        String str10 = str;
        this.f75523g = str3;
        this.f75521e = str4;
        this.f75522f = str5;
        this.f75526j = str10;
        if ("register_email".equals(this.f75519c)) {
            this.f75524h = str10;
        } else {
            this.f75525i = str10;
        }
        LoginSuccBean loginSuccBean = new LoginSuccBean();
        loginSuccBean.f(!"register_email".equals(this.f75519c));
        loginSuccBean.d(this.f75521e);
        loginSuccBean.e(this.f75522f);
        r1(UserCenterRemoteDataSource.A().p0(this.f75525i, this.f75524h, str2, str3, str4, str6, str7, str8, str9).compose(p.c0()), loginSuccBean);
    }

    public void z0(String str) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.j(R.string.n_no_network);
        } else {
            v7.b.a().checkInvitedCode(str).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a());
        }
    }

    public void z1() {
        B0().subscribe(new h());
    }
}
