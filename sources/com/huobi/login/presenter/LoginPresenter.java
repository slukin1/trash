package com.huobi.login.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.thirdlogin.ThirdLoginUtil;
import com.huobi.login.ui.TrustDeviceActivity;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.ThirdAuth;
import com.huobi.login.usercenter.data.source.bean.ThirdAuthUrl;
import com.huobi.login.usercenter.data.source.bean.ThirdData;
import com.huobi.login.usercenter.data.source.bean.ThirdInfo;
import com.huobi.login.usercenter.data.source.bean.ThirdState;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.usercenter.utils.TrustDeviceStatus;
import com.huobi.login.usercenter.utils.UcNeed2FAStatus;
import com.huobi.login.utils.HistoryAccountDataManager;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.q0;
import com.huobi.vulcan.model.VulcanInfo;
import com.tencent.imsdk.BaseConstants;
import i6.i;
import i6.k;
import i6.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nn.a0;
import nn.a1;
import nn.b0;
import nn.b1;
import nn.c0;
import nn.c1;
import nn.d0;
import nn.d1;
import nn.e0;
import nn.f0;
import nn.g0;
import nn.h0;
import nn.i0;
import nn.j0;
import nn.k0;
import nn.l0;
import nn.m0;
import nn.p0;
import nn.r0;
import nn.s0;
import nn.t0;
import nn.u0;
import nn.v0;
import nn.w0;
import nn.x;
import nn.x0;
import nn.y;
import nn.y0;
import nn.z;
import nn.z0;
import on.e;
import on.f;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;
import sn.l;
import tg.r;
import tq.p;
import u6.g;

public class LoginPresenter extends ActivityPresenter<d> implements f {

    /* renamed from: s  reason: collision with root package name */
    public static String f75467s = "LoginPresenter";

    /* renamed from: t  reason: collision with root package name */
    public static String f75468t = "facebook";

    /* renamed from: u  reason: collision with root package name */
    public static String f75469u = "google";

    /* renamed from: v  reason: collision with root package name */
    public static String f75470v = "telegram";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ThirdInfo> f75471b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final CompositeSubscription f75472c = new CompositeSubscription();

    /* renamed from: d  reason: collision with root package name */
    public String f75473d;

    /* renamed from: e  reason: collision with root package name */
    public String f75474e;

    /* renamed from: f  reason: collision with root package name */
    public kn.a f75475f;

    /* renamed from: g  reason: collision with root package name */
    public JumpTarget f75476g;

    /* renamed from: h  reason: collision with root package name */
    public on.d f75477h;

    /* renamed from: i  reason: collision with root package name */
    public on.d f75478i;

    /* renamed from: j  reason: collision with root package name */
    public on.d f75479j;

    /* renamed from: k  reason: collision with root package name */
    public on.d f75480k;

    /* renamed from: l  reason: collision with root package name */
    public int f75481l;

    /* renamed from: m  reason: collision with root package name */
    public String f75482m;

    /* renamed from: n  reason: collision with root package name */
    public int f75483n = 1;

    /* renamed from: o  reason: collision with root package name */
    public String f75484o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f75485p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f75486q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f75487r;

    public class a extends EasySubscriber<UserToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f75488b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f75489c;

        public a(boolean z11, boolean z12) {
            this.f75488b = z11;
            this.f75489c = z12;
        }

        public void onAfter() {
        }

        public void onError2(Throwable th2) {
            String B0 = LoginPresenter.f75467s;
            Log.d(B0, "onError2: " + th2 + ", msg =" + th2.getMessage());
            if (th2 instanceof UcNeed2FAStatus) {
                UcIntCodeResponse<LoginInfoData> ucIntCodeResponse = ((UcNeed2FAStatus) th2).getUcIntCodeResponse();
                LoginPresenter.this.V0(new APIStatusErrorException(String.valueOf(ucIntCodeResponse.getCode()), ucIntCodeResponse.getMessage()), this.f75489c, ucIntCodeResponse.getData());
                ((d) LoginPresenter.this.getUI()).G0();
                ((d) LoginPresenter.this.getUI()).dismissProgressDialog();
            }
            if (th2 instanceof TrustDeviceStatus) {
                UcIntCodeResponse<LoginInfoData> ucIntCodeResponse2 = ((TrustDeviceStatus) th2).getUcIntCodeResponse();
                ((d) LoginPresenter.this.getUI()).G0();
                ((d) LoginPresenter.this.getUI()).dismissProgressDialog();
                if (10077 == ucIntCodeResponse2.getCode()) {
                    TrustDeviceActivity.fg(LoginPresenter.this.getActivity(), false, ucIntCodeResponse2.getData().getTsvToken());
                } else if (10078 == ucIntCodeResponse2.getCode()) {
                    TrustDeviceActivity.fg(LoginPresenter.this.getActivity(), true, ucIntCodeResponse2.getData().getTsvToken());
                }
            } else {
                super.onError2(th2);
                th2.printStackTrace();
                ((d) LoginPresenter.this.getUI()).dismissProgressDialog();
                ((d) LoginPresenter.this.getUI()).G0();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            LoginPresenter.this.V0(aPIStatusErrorException, this.f75489c, (LoginInfoData) null);
        }

        public void onStart() {
            super.onStart();
        }

        public void onNext(UserToken userToken) {
            ((d) LoginPresenter.this.getUI()).n3();
            LoginPresenter.this.W0(userToken, this.f75488b);
            ((d) LoginPresenter.this.getUI()).G0();
        }
    }

    public class b extends EasySubscriber<ImgCaptchaData> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ImgCaptchaData imgCaptchaData) {
            super.onNext(imgCaptchaData);
            String unused = LoginPresenter.this.f75473d = imgCaptchaData.getKey();
            ((d) LoginPresenter.this.getUI()).Q0(ImageUtils.i(imgCaptchaData.getImage()));
        }

        public void onAfter() {
            super.onAfter();
            ((d) LoginPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((d) LoginPresenter.this.getUI()).dismissProgressDialog();
        }
    }

    public class c extends EasySubscriber<List<ThirdInfo>> {
        public c() {
        }

        public void onError2(Throwable th2) {
            String B0 = LoginPresenter.f75467s;
            k.o(B0, "Third login fetchThirdList  error " + th2);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String B0 = LoginPresenter.f75467s;
            k.o(B0, "Third login fetchThirdList net error " + aPIStatusErrorException);
        }

        public void onNext(List<ThirdInfo> list) {
            super.onNext(list);
            for (ThirdInfo next : list) {
                String B0 = LoginPresenter.f75467s;
                k.o(B0, "Third login fetchThirdList success  " + next);
                String lowerCase = next.d().toLowerCase();
                if (lowerCase.contains(LoginPresenter.f75468t.toLowerCase())) {
                    LoginPresenter.f75468t = lowerCase;
                    LoginPresenter.this.f75471b.put(LoginPresenter.f75468t, next);
                } else if (lowerCase.contains(LoginPresenter.f75469u.toLowerCase())) {
                    if (!ThirdLoginUtil.a()) {
                        LoginPresenter.f75469u = lowerCase;
                        LoginPresenter.this.f75471b.put(LoginPresenter.f75469u, next);
                    }
                } else if (lowerCase.contains(LoginPresenter.f75470v.toLowerCase())) {
                    LoginPresenter.f75470v = lowerCase;
                    LoginPresenter.this.f75471b.put(LoginPresenter.f75470v, next);
                }
            }
            ((d) LoginPresenter.this.getUI()).He(LoginPresenter.this.f75471b);
        }
    }

    public interface d extends g {
        void G0();

        void He(HashMap<String, ThirdInfo> hashMap);

        void K0();

        void L5();

        void N(String str);

        void Q0(Bitmap bitmap);

        void Q4(boolean z11, String str, String str2, String str3, Map<String, Object> map);

        void Ve(String str, String str2, RiskControl riskControl);

        void a9(int i11);

        void ac();

        void b2();

        void g2(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map);

        void n3();

        void p2(int i11, String str, String str2, String str3, Map<String, Object> map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A1(Throwable th2) {
        ((d) getUI()).G0();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B1(ThirdData thirdData, ThirdState thirdState) {
        String str = f75467s;
        k.o(str, "Third login getThirdState success  " + thirdState.toString());
        I0(thirdState.a(), thirdData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C1(APIStatusErrorException aPIStatusErrorException) {
        String str = f75467s;
        k.o(str, "Third login getThirdState net error " + aPIStatusErrorException);
        ((d) getUI()).dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D1(Throwable th2) {
        String str = f75467s;
        k.o(str, "Third login getThirdState  error " + th2);
        ((d) getUI()).dismissProgressDialog();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F1(ThirdAuthUrl thirdAuthUrl) {
        String authUrl = thirdAuthUrl.getAuthUrl();
        ((e) this.f75479j).c(authUrl);
        k.o("TelegramLogin", "getThirdAuthUrl " + authUrl);
        this.f75479j.login();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(Object obj) {
        String str = f75467s;
        k.o(str, "Third bind   " + obj);
        K1(O0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a1(APIStatusErrorException aPIStatusErrorException) {
        String str = f75467s;
        k.o(str, "Third bind  net error " + aPIStatusErrorException);
        ((d) getUI()).dismissProgressDialog();
        ((d) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(Throwable th2) {
        String str = f75467s;
        k.o(str, "Third bind   error " + th2);
        th2.printStackTrace();
        ((d) getUI()).dismissProgressDialog();
        ((d) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c1(ThirdAuth thirdAuth) {
        String str = f75467s;
        k.o(str, "Third login getThirdAuth success  " + thirdAuth.toString());
        if (!thirdAuth.b().booleanValue()) {
            String str2 = f75467s;
            k.o(str2, "Third login onSuccess: " + this.f75484o);
            Intent intent = new Intent(getActivity(), UserLoginActivityV2.class);
            intent.putExtra("bindType", this.f75484o);
            intent.putExtra("third_token", thirdAuth.e());
            if (thirdAuth.d() != null) {
                intent.putExtra("login_name", thirdAuth.d());
            }
            JumpTarget jumpTarget = this.f75476g;
            if (jumpTarget != null) {
                intent.putExtra("target", jumpTarget);
            }
            getActivity().startActivityForResult(intent, BaseConstants.ERR_SVR_CONV_ACCOUNT_NOT_FOUND);
        } else {
            K1(thirdAuth.e());
        }
        ((d) getUI()).dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1(APIStatusErrorException aPIStatusErrorException) {
        String str = f75467s;
        k.o(str, "Third login getThirdAuth net error  " + aPIStatusErrorException);
        ((d) getUI()).dismissProgressDialog();
        if ("11653".equals(aPIStatusErrorException.getErrCode())) {
            HuobiToastUtil.j(R.string.third_login_bind_error_rebind);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e1(Throwable th2) {
        String str = f75467s;
        k.o(str, "Third login getThirdAuth error  " + th2);
        ((d) getUI()).dismissProgressDialog();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1() {
        if (P0() != null) {
            Intent intent = new Intent();
            intent.putExtra("PARAM_BIND_RESULT", true);
            getActivity().setResult(0, intent);
        }
        ((d) getUI()).dismissProgressDialog();
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1(boolean z11, Object obj) {
        i.b().g(new i0(this), 50);
        if (!this.f75485p) {
            tg.f.j(4);
        }
        UserLoginHelper.e().j(getActivity(), this.f75475f);
        if (!z11) {
            if (Y0()) {
                HistoryAccountDataManager.a().j(this.f75474e);
            } else {
                HistoryAccountDataManager.a().k(this.f75474e);
            }
        }
        is.a.q("000004", (Map<String, Object>) null);
    }

    public static /* synthetic */ Observable j1(UcIntCodeResponse ucIntCodeResponse) {
        if (10070 == ucIntCodeResponse.getCode()) {
            return Observable.error(new UcNeed2FAStatus(ucIntCodeResponse));
        }
        if (10077 == ucIntCodeResponse.getCode() || 10078 == ucIntCodeResponse.getCode()) {
            return Observable.error(new TrustDeviceStatus(ucIntCodeResponse));
        }
        return Observable.just(ucIntCodeResponse);
    }

    public static /* synthetic */ UserToken k1(LoginInfoData loginInfoData) {
        if (loginInfoData.isForbidCountry()) {
            q0.d().h(loginInfoData.getForbidCountryMessage());
        }
        UserToken userToken = new UserToken();
        userToken.h(loginInfoData.getTicket());
        userToken.i(loginInfoData.getUcToken());
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(LoginInfoData loginInfoData) {
        ((d) getUI()).ac();
    }

    public static /* synthetic */ UserToken m1(LoginInfoData loginInfoData) {
        UserToken userToken = new UserToken();
        userToken.h(loginInfoData.getTicket());
        userToken.i(loginInfoData.getUcToken());
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable p1(UcIntCodeResponse ucIntCodeResponse) {
        String str = f75467s;
        k.o(str, "Third login loginWithThirdAccount  " + ucIntCodeResponse);
        if (10070 == ucIntCodeResponse.getCode()) {
            ((d) getUI()).dismissProgressDialog();
            return Observable.error(new UcNeed2FAStatus(ucIntCodeResponse));
        } else if (10077 == ucIntCodeResponse.getCode() || 10078 == ucIntCodeResponse.getCode()) {
            ((d) getUI()).dismissProgressDialog();
            return Observable.error(new TrustDeviceStatus(ucIntCodeResponse));
        } else {
            if (50001 == ucIntCodeResponse.getCode()) {
                EventBus.d().k(new HKPayOffEvent());
            }
            return Observable.just(ucIntCodeResponse);
        }
    }

    public static /* synthetic */ UserToken q1(LoginInfoData loginInfoData) {
        UserToken userToken = new UserToken();
        userToken.h(loginInfoData.getTicket());
        userToken.i(loginInfoData.getUcToken());
        if (!TextUtils.isEmpty(userToken.e())) {
            r.x().x0(userToken.e());
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ UserToken r1(UserToken userToken, UserInfoData userInfoData) {
        r.x().i0(userInfoData);
        if (!TextUtils.isEmpty(userInfoData.e())) {
            this.f75474e = userInfoData.e();
        } else if (!TextUtils.isEmpty(userInfoData.h())) {
            this.f75474e = userInfoData.h();
        }
        return userToken;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable s1(UserToken userToken) {
        return r.x().f0(false).map(new m0(this, userToken));
    }

    public static /* synthetic */ void t1() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1(ImgCaptchaData imgCaptchaData) {
        this.f75473d = imgCaptchaData.getKey();
        ((d) getUI()).N(imgCaptchaData.getImage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(APIStatusErrorException aPIStatusErrorException) {
        ((d) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(Throwable th2) {
        ((d) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x1() {
        ((d) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y1(String str, String str2, RiskControl riskControl) {
        if (riskControl.getRisk() <= 0) {
            Map<String, Object> R0 = R0(str, str2, (HashMap<String, Object>) null);
            if (P0() == null) {
                H1(R0);
                return;
            }
            if (this.f75481l == 1 && !TextUtils.isEmpty(this.f75482m)) {
                R0.put("country_code", this.f75482m);
            }
            H0(R0);
        } else if (riskControl.getRisk() == 1) {
            HuobiToastUtil.m(getResources().getString(R.string.n_user_center_risk_tips));
            ((d) getUI()).G0();
        } else if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
            ((d) getUI()).Ve(str, str2, riskControl);
        } else {
            UserCenterRemoteDataSource.A().z().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(x0.f58678b, new d1(this), new y0(this), new c0(this), new t0(this)));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z1(APIStatusErrorException aPIStatusErrorException) {
        ((d) getUI()).G0();
    }

    public void G0() {
        rn.c.i().w(this.f75476g, getActivity(), this.f75486q);
    }

    public void G1(String str, String str2, String str3) {
        this.f75474e = str;
        String c11 = MD5Utils.c(str2);
        HashMap hashMap = new HashMap();
        hashMap.put("login_name", str);
        hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, c11);
        hashMap.put("way", "APP_HUOBI_PRO");
        hashMap.put("captcha_key", this.f75473d);
        hashMap.put("captcha_code", str3);
        int i11 = 3;
        hashMap.put("login_version", 3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        if (P0() == null) {
            H1(hashMap);
            return;
        }
        if (!StringUtils.o(str)) {
            i11 = 2;
        }
        ((d) getUI()).p2(i11, StringUtils.o(str) ? null : str, StringUtils.o(str) ? str : null, (String) null, hashMap);
        ((d) getUI()).dismissProgressDialog();
    }

    public void H0(Map<String, Object> map) {
        this.f75472c.add(UserCenterRemoteDataSource.A().o(O0(), map).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new g0(this), new z0(this), new d0(this))));
    }

    public void H1(Map<String, Object> map) {
        this.f75487r = false;
        if (map != null) {
            map.put("login_version", 3);
            map.put(VulcanInfo.VTOKEN, ku.b.e().h(getActivity()));
            if (this.f75481l == 1 && !TextUtils.isEmpty(this.f75482m)) {
                map.put("country_code", this.f75482m);
            }
        }
        this.f75472c.add(UserCenterRemoteDataSource.A().g0(map).flatMap(p0.f58642b).compose(p.c0()).map(nn.q0.f58646b).flatMap(v0.f58669b).compose(RxJavaHelper.t((g) getUI())).subscribe(K0(false, false)));
    }

    public final void I0(String str, ThirdData thirdData) {
        String str2;
        String str3 = f75467s;
        k.o(str3, "Third login fetchThirdInfo  " + str + " data: " + thirdData.toString());
        if (f75470v.equals(this.f75484o)) {
            ThirdInfo thirdInfo = this.f75471b.get(thirdData.f75671a);
            str2 = thirdInfo != null ? thirdInfo.b() : null;
        } else {
            str2 = thirdData.f75673c;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f75472c.add(UserCenterRemoteDataSource.A().L(thirdData, str, str2).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new z(this), new c1(this), new b0(this))));
        }
    }

    public void I1(Map<String, Object> map, String str) {
        ((d) getUI()).showProgressDialog();
        this.f75472c.add(UserCenterRemoteDataSource.A().h0(str, map).compose(p.c0()).doOnNext(new y(this)).map(s0.f58655b).flatMap(w0.f58673b).compose(RxJavaHelper.t((g) getUI())).subscribe(K0(true, this.f75487r)));
    }

    public final void J0() {
        this.f75472c.add(UserCenterRemoteDataSource.A().N().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new c()));
    }

    public void J1(String str, String str2, HashMap<String, Object> hashMap) {
        Map<String, Object> R0 = R0(str, str2, hashMap);
        if (P0() == null) {
            H1(R0);
            return;
        }
        ((d) getUI()).p2(StringUtils.o(str) ? 3 : 2, StringUtils.o(str) ? null : str, StringUtils.o(str) ? str : null, (String) null, R0);
    }

    public final EasySubscriber<UserToken> K0(boolean z11, boolean z12) {
        return new a(z12, z11);
    }

    public final void K1(String str) {
        this.f75487r = true;
        String str2 = f75467s;
        k.o(str2, "Third login loginWithThirdAccount  " + str);
        this.f75472c.add(UserCenterRemoteDataSource.A().j0(str).flatMap(new k0(this)).compose(p.c0()).map(r0.f58650b).flatMap(new l0(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(K0(false, true)));
    }

    public String L0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindEmail")) {
            return null;
        }
        return intent.getExtras().getString("bindEmail");
    }

    public void L1(String str, String str2) {
        this.f75474e = str;
        this.f75472c.add(UserCenterRemoteDataSource.A().t0(str, P0() == null ? 2 : 1, this.f75481l == 1 ? this.f75482m : null).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new j0(this, str, str2), new b1(this), new e0(this))));
    }

    public String M0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("login_name")) {
            return null;
        }
        return intent.getExtras().getString("login_name");
    }

    /* renamed from: M1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        Bundle extras;
        super.onUIReady(baseCoreActivity, dVar);
        Intent intent = getActivity().getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("target")) {
                kn.a aVar = (kn.a) extras.get("target");
                this.f75475f = aVar;
                if (aVar instanceof JumpTarget) {
                    this.f75476g = (JumpTarget) aVar;
                }
            }
            if (extras.containsKey("USER_LOGIN_TYPE")) {
                this.f75483n = extras.getInt("USER_LOGIN_TYPE");
            }
        }
        ((d) getUI()).a9(this.f75483n);
        ((d) getUI()).L5();
        gs.e.b().c("PM_LOGIN_SUCCESS");
        ((d) getUI()).b2();
        if (P0() == null) {
            J0();
        }
        if (tg.g.b()) {
            r.x().j();
        }
    }

    public String N0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindPhone")) {
            return null;
        }
        return intent.getExtras().getString("bindPhone");
    }

    public void N1() {
        this.f75472c.add(UserCenterRemoteDataSource.A().t0(this.f75474e, 2, this.f75481l == 1 ? this.f75482m : null).compose(p.c0()).flatMap(u0.f58665b).compose(RxJavaHelper.t((g) getUI())).subscribe(new b()));
    }

    public String O0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("third_token")) {
            return null;
        }
        return intent.getExtras().getString("third_token");
    }

    public void O1(String str) {
        this.f75482m = str;
    }

    public String P0() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindType")) {
            return null;
        }
        return intent.getExtras().getString("bindType");
    }

    public void P1(int i11) {
        this.f75481l = i11;
    }

    public JumpTarget Q0() {
        return this.f75476g;
    }

    public void Q1(String str) {
        this.f75484o = str;
        if (str.equals(f75468t)) {
            if (this.f75477h == null) {
                this.f75477h = new on.b(getActivity(), this);
            }
            on.d dVar = this.f75477h;
            this.f75480k = dVar;
            dVar.login();
        } else if (str.equals(f75469u)) {
            if (this.f75478i == null) {
                this.f75478i = new on.c(getActivity(), this);
            }
            on.d dVar2 = this.f75478i;
            this.f75480k = dVar2;
            dVar2.login();
        } else if (str.equals(f75470v)) {
            if (this.f75479j == null) {
                this.f75479j = new e(getActivity(), this);
            }
            this.f75480k = this.f75479j;
            HashMap<String, ThirdInfo> hashMap = this.f75471b;
            if (hashMap != null && hashMap.get(str) != null) {
                UserCenterRemoteDataSource.A().M(this.f75471b.get(str)).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new a0(this)));
            }
        }
    }

    public final Map<String, Object> R0(String str, String str2, HashMap<String, Object> hashMap) {
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

    public void S0(Intent intent) {
        this.f75486q = intent.getBooleanExtra("login_multiple_account", false);
    }

    public HashMap<String, ThirdInfo> T0() {
        return this.f75471b;
    }

    public on.d U0(String str) {
        if (str.equals(f75468t)) {
            return this.f75477h;
        }
        if (str.equals(f75469u)) {
            return this.f75478i;
        }
        if (str.equals(f75470v)) {
            return this.f75479j;
        }
        return null;
    }

    public final void V0(APIStatusErrorException aPIStatusErrorException, boolean z11, LoginInfoData loginInfoData) {
        ((d) getUI()).dismissProgressDialog();
        String errCode = aPIStatusErrorException.getErrCode();
        String errMsg = aPIStatusErrorException.getErrMsg();
        Log.e(f75467s, "handleUserLoginError: code:" + errCode + ",msg:" + errMsg);
        if (!TextUtils.isEmpty(errCode)) {
            int l02 = m.l0(errCode, -1);
            if (l02 != 10013) {
                if (l02 != 10015) {
                    if (l02 == 10039) {
                        ((d) getUI()).G0();
                        HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                        return;
                    } else if (l02 == 10070) {
                        ((d) getUI()).K0();
                        if (loginInfoData.getRequireTypes() != null && loginInfoData.getRequireTypes().size() > 0) {
                            List<LoginInfoData.Login2FAOption> requireTypes = loginInfoData.getRequireTypes();
                            String str = "";
                            String str2 = str;
                            boolean z12 = false;
                            for (int i11 = 0; i11 < requireTypes.size(); i11++) {
                                LoginInfoData.Login2FAOption login2FAOption = requireTypes.get(i11);
                                int type = login2FAOption.getType();
                                if (type == 1) {
                                    z12 = true;
                                } else if (type == 2) {
                                    str = login2FAOption.getTag();
                                } else if (type == 3) {
                                    str2 = login2FAOption.getTag();
                                }
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("isKnowDevice", Boolean.valueOf(loginInfoData.isKnowDevice()));
                            ((d) getUI()).Q4(z12, str, str2, loginInfoData.getToken(), hashMap);
                            return;
                        } else if (loginInfoData.getSwitchTypes() != null && loginInfoData.getSwitchTypes().size() > 0) {
                            List<LoginInfoData.Login2FAOption> switchTypes = loginInfoData.getSwitchTypes();
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("isKnowDevice", Boolean.valueOf(loginInfoData.isKnowDevice()));
                            ((d) getUI()).g2(switchTypes, loginInfoData.getToken(), hashMap2);
                            return;
                        } else {
                            return;
                        }
                    } else if (l02 == 10080) {
                        ((d) getUI()).K0();
                        return;
                    } else if (!(l02 == 10082 || l02 == 11005)) {
                        if (l02 != 50000) {
                            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                            ((d) getUI()).G0();
                            return;
                        }
                        ((d) getUI()).G0();
                        HbgDialogManager.A().j0(968, 0, "template/zh-CN/968.html", 0, "", "", "", "", "0");
                        return;
                    }
                }
                if (z11) {
                    ((d) getUI()).ac();
                }
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                ((d) getUI()).G0();
                return;
            }
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            ((d) getUI()).G0();
        }
    }

    public final void W0(UserToken userToken, boolean z11) {
        l.q(userToken, this.f75474e, getActivity(), false, new x(this, z11));
    }

    public boolean X0() {
        return this.f75486q;
    }

    public boolean Y0() {
        return this.f75483n == 1;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        k.o(f75467s, "onActivityResult");
        on.d dVar = this.f75480k;
        if (dVar != null) {
            dVar.onActivityResult(i11, i12, intent);
        }
        super.onActivityResult(i11, i12, intent);
        if (i11 == 50001 && intent != null && intent.getBooleanExtra("PARAM_BIND_RESULT", false)) {
            getActivity().finish();
        }
    }

    public void onError(Exception exc) {
        String str = f75467s;
        k.o(str, "LoginPresenter onError: " + exc.getMessage());
    }

    public void p(String str) {
        k.o(f75467s, "LoginPresenter onCancel");
    }

    public void x(ThirdData thirdData) {
        String str = f75467s;
        k.o(str, "Third login onSuccess: " + this.f75484o + " type: " + thirdData);
        if (thirdData.f75671a.equals(this.f75484o)) {
            ((d) getUI()).showProgressDialog(false);
            this.f75472c.add(UserCenterRemoteDataSource.A().O().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new h0(this, thirdData), new a1(this), new f0(this))));
        }
    }
}
