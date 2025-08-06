package com.huobi.login.v3.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException;
import androidx.credentials.l;
import androidx.credentials.n;
import androidx.credentials.p;
import bj.o0;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.ChallengeTypeData;
import com.huobi.login.usercenter.data.source.bean.CountryInfo;
import com.huobi.login.usercenter.data.source.bean.FollowTypeData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.PasskeyLoginData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import com.huobi.login.v2.ui.CaptchaCodeActivityV2;
import com.huobi.login.v2.ui.ForgetPasswordActivityV2;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import com.huobi.login.v3.ui.LoginPwdFragment;
import com.huobi.login.v3.ui.PasskeyFragment;
import com.huobi.login.v3.ui.VerModeDialog;
import com.huobi.utils.SpannableUtils;
import com.huobi.view.button.StatusButton;
import com.huobi.view.radiogroup.RadioGroupContainer;
import com.huochat.community.util.DisplayTool;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.Constants;
import i6.k;
import i6.r;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import pro.huobi.R;
import sn.w;
import vn.o;
import vn.q;
import vn.s;
import vn.t;
import vn.u;
import vn.v;
import wn.b0;
import wn.c0;
import wn.f;
import wn.k0;
import wn.u0;

public class UserLoginActivityV4 extends BaseActivity<UserLoginPresenter, UserLoginPresenter.f> implements UserLoginPresenter.f, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RadioGroupContainer f76089b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f76090c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f76091d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f76092e;

    /* renamed from: f  reason: collision with root package name */
    public StatusButton f76093f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f76094g;

    /* renamed from: h  reason: collision with root package name */
    public int f76095h = -1;

    /* renamed from: i  reason: collision with root package name */
    public String f76096i = "";

    /* renamed from: j  reason: collision with root package name */
    public boolean f76097j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f76098k = false;

    /* renamed from: l  reason: collision with root package name */
    public PasskeyFragment f76099l;

    /* renamed from: m  reason: collision with root package name */
    public LoginPwdFragment f76100m;

    /* renamed from: n  reason: collision with root package name */
    public HashMap<String, Object> f76101n;

    /* renamed from: o  reason: collision with root package name */
    public final b0 f76102o = new b0(new b());

    /* renamed from: p  reason: collision with root package name */
    public final u0 f76103p = new u0(new c());

    /* renamed from: q  reason: collision with root package name */
    public final wn.f f76104q = new wn.f(new d());

    /* renamed from: r  reason: collision with root package name */
    public final k0 f76105r = new k0(new e(), "密码登录");

    public class a extends EasySubscriber<PasskeyLoginData> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(PasskeyLoginData passkeyLoginData) {
            String account = UserLoginActivityV4.this.getAccount();
            k.d("HBPasskey", "passkey login web success !");
            HashMap hashMap = new HashMap(1);
            hashMap.put("pagetype", "1Step");
            gs.g.i("appPass_passkey", hashMap);
            ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).S1(account, passkeyLoginData.getUcToken(), passkeyLoginData.getTicket(), true);
            UserLoginActivityV4.this.dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            UserLoginActivityV4.this.dismissProgressDialog();
            k.g("HBPasskey", "passkey login error !", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            UserLoginActivityV4.this.dismissProgressDialog();
            k.g("HBPasskey", "passkey login failed !", aPIStatusErrorException);
        }
    }

    public class b implements b0.a {
        public b() {
        }

        public boolean I0() {
            return UserLoginActivityV4.this.I0();
        }

        public boolean a() {
            return UserLoginActivityV4.this.pi();
        }

        public boolean b() {
            return UserLoginActivityV4.this.qi();
        }

        public void c(String str) {
            UserLoginActivityV4.this.si(str);
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV4.this;
        }
    }

    public class c implements u0.d {
        public c() {
        }

        public void a(String str, String str2, int i11, HashMap<String, Object> hashMap) {
            HashMap unused = UserLoginActivityV4.this.f76101n = hashMap;
            if (i11 == 1) {
                ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).M1(str, UserLoginActivityV4.this.qi(), UserLoginActivityV4.this.hi(), hashMap);
            } else if (i11 == 2) {
                if (UserLoginActivityV4.this.pi()) {
                    ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).W1(str, hashMap, (String) null, (String) null);
                } else {
                    ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).Z1(UserLoginActivityV4.this.hi(), str, hashMap, (String) null, (String) null, false);
                }
            } else if (i11 == 3) {
                ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).N1(str, str2, hashMap, UserLoginActivityV4.this.qi(), UserLoginActivityV4.this.hi());
            }
        }

        public void b(int i11, int i12, Intent intent) {
            UserLoginActivityV4.this.onActivityResult(i11, i12, intent);
        }

        public void c() {
            if (UserLoginActivityV4.this.f76093f != null) {
                UserLoginActivityV4.this.f76093f.dismissAnim();
            }
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV4.this;
        }
    }

    public class d implements f.i {
        public d() {
        }

        public boolean I0() {
            return UserLoginActivityV4.this.I0();
        }

        public void a() {
            ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).K1(UserLoginActivityV4.this.getAccount(), UserLoginActivityV4.this.ki(), UserLoginActivityV4.this.qi(), UserLoginActivityV4.this.hi());
            UserLoginActivityV4.this.f76093f.showAnim();
        }

        public void b(HashMap<String, Object> hashMap, String str) {
            ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).J1(UserLoginActivityV4.this.getAccount(), hashMap, str);
        }

        public void c() {
            ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).K1(UserLoginActivityV4.this.getAccount(), UserLoginActivityV4.this.ki(), UserLoginActivityV4.this.qi(), UserLoginActivityV4.this.hi());
            UserLoginActivityV4.this.f76093f.showAnim();
        }

        public void d(String str, HashMap<String, Object> hashMap, String str2) {
            ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).J1(UserLoginActivityV4.this.getAccount(), hashMap, str2);
        }

        public String e() {
            return ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).P0();
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV4.this;
        }

        public String i() {
            return TextUtils.isEmpty(UserLoginActivityV4.this.getAccount()) ? "" : UserLoginActivityV4.this.getAccount();
        }

        public void onDialogFragmentPause() {
            UserLoginActivityV4.this.G0();
        }
    }

    public class e implements k0.b {
        public e() {
        }

        public void a(String str, String str2) {
            ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).Q1(str, str2);
        }

        public JumpTarget b() {
            return ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).R0();
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV4.this;
        }
    }

    public class f implements u0.e {
        public f() {
        }

        public void a() {
            UserLoginActivityV4.this.G0();
        }

        public void b(String str, String str2) {
            String account = UserLoginActivityV4.this.getAccount();
            String qh2 = UserLoginActivityV4.this.ki();
            if (!TextUtils.isEmpty(str) && str.length() >= 5) {
                UserLoginActivityV4.this.showProgressDialog();
                ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).P1(account, qh2, str, str2, UserLoginActivityV4.this.qi(), UserLoginActivityV4.this.hi());
            }
        }

        public void onCancel() {
            UserLoginActivityV4.this.f76093f.dismissAnim();
        }
    }

    public class g implements PasskeyFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HashMap f76112a;

        public class a implements VerModeDialog.a {
            public a() {
            }

            public void a() {
                UserLoginActivityV4.this.ei();
            }

            public boolean b() {
                return UserLoginActivityV4.this.f76095h == 2;
            }

            public void c() {
            }

            public boolean d() {
                return true;
            }

            public boolean e() {
                return false;
            }

            public void f() {
                g gVar = g.this;
                UserLoginActivityV4.this.Di(gVar.f76112a);
            }
        }

        public g(HashMap hashMap) {
            this.f76112a = hashMap;
        }

        public void a() {
            new VerModeDialog(new a()).show(UserLoginActivityV4.this.f76099l.getChildFragmentManager(), "");
        }

        public void login() {
            UserLoginActivityV4.this.gi(this.f76112a);
        }
    }

    public class h implements LoginPwdFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HashMap f76115a;

        public class a implements VerModeDialog.a {
            public a() {
            }

            public void a() {
                UserLoginActivityV4.this.ei();
            }

            public boolean b() {
                return UserLoginActivityV4.this.f76095h == 2;
            }

            public void c() {
                h hVar = h.this;
                UserLoginActivityV4.this.Ei(hVar.f76115a);
            }

            public boolean d() {
                return false;
            }

            public boolean e() {
                return UserLoginActivityV4.this.f76097j && !UserLoginActivityV4.this.f76098k;
            }

            public void f() {
            }
        }

        public h(HashMap hashMap) {
            this.f76115a = hashMap;
        }

        public void a() {
            new VerModeDialog(new a()).show(UserLoginActivityV4.this.f76100m.getChildFragmentManager(), "");
        }

        public boolean b() {
            return UserLoginActivityV4.this.f76095h == 2;
        }

        public boolean c() {
            return UserLoginActivityV4.this.f76097j && !UserLoginActivityV4.this.f76098k;
        }

        public void d(r rVar) {
            UserLoginActivityV4.this.f76102o.u(rVar);
        }

        public void e() {
            UserLoginActivityV4.this.Ii("1Step", "Password", "ForgetPassword");
            if (!UserLoginActivityV4.this.I0()) {
                Intent intent = new Intent(UserLoginActivityV4.this, ForgetPasswordActivityV2.class);
                if (((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).R0() != null) {
                    intent.putExtra("target", ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).R0());
                }
                intent.putExtra("country_id", UserLoginActivityV4.this.ii());
                intent.putExtra("login_type", UserLoginActivityV4.this.f76095h);
                intent.putExtra("email", UserLoginActivityV4.this.ji());
                intent.putExtra(PlaceFields.PHONE, UserLoginActivityV4.this.li());
                intent.putExtra("country_code", UserLoginActivityV4.this.hi());
                UserLoginActivityV4.this.startActivity(intent);
                return;
            }
            UserLoginActivityV4 userLoginActivityV4 = UserLoginActivityV4.this;
            DialogUtils.X(userLoginActivityV4, userLoginActivityV4.getString(R.string.dialog_minamount_hint_title), UserLoginActivityV4.this.getString(R.string.sub_account_forget_pw), (String) null, UserLoginActivityV4.this.getString(R.string.dialog_minamount_hint_confrm_btn), o0.f12469a);
        }

        public void login(String str) {
            if (!UserLoginActivityV4.this.f76102o.w()) {
                UserLoginActivityV4.this.Ii("1Step", "Password", "Next");
                if (TextUtils.isEmpty(UserLoginActivityV4.this.f76096i)) {
                    ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).L1(UserLoginActivityV4.this.getAccount(), str, 3, UserLoginActivityV4.this.qi(), UserLoginActivityV4.this.hi());
                    return;
                }
                ((UserLoginPresenter) UserLoginActivityV4.this.getPresenter()).O1(UserLoginActivityV4.this.getAccount(), str, this.f76115a, UserLoginActivityV4.this.qi(), UserLoginActivityV4.this.hi(), UserLoginActivityV4.this.f76096i);
                UserLoginActivityV4.this.m7();
            }
        }
    }

    public class i extends EasySubscriber<ChallengeTypeData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f76118b;

        public i(HashMap hashMap) {
            this.f76118b = hashMap;
        }

        /* renamed from: a */
        public void onNext(ChallengeTypeData challengeTypeData) {
            if (challengeTypeData == null) {
                try {
                    k.f("HBPasskey", "passkey ChallengeTypeData null !");
                    UserLoginActivityV4.this.dismissProgressDialog();
                } catch (JSONException e11) {
                    k.g("HBPasskey", "passkey login error !", e11);
                }
            } else {
                UserLoginActivityV4 userLoginActivityV4 = UserLoginActivityV4.this;
                userLoginActivityV4.Ai(userLoginActivityV4.mi(challengeTypeData), challengeTypeData.getUuid(), this.f76118b);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public class j implements androidx.credentials.h<l, GetCredentialException> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f76120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f76121b;

        public j(String str, HashMap hashMap) {
            this.f76120a = str;
            this.f76121b = hashMap;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(HashMap hashMap) {
            UserLoginActivityV4.this.Di(hashMap);
        }

        /* renamed from: d */
        public void a(GetCredentialException getCredentialException) {
            UserLoginActivityV4.this.dismissProgressDialog();
            if ((getCredentialException instanceof GetCredentialCancellationException) || ((getCredentialException instanceof GetPublicKeyCredentialDomException) && (((GetPublicKeyCredentialDomException) getCredentialException).getDomError() instanceof NotAllowedError))) {
                k.f("HBPasskey", "passkey login cancel !");
                return;
            }
            k.g("HBPasskey", "passkey login error !", getCredentialException);
            boolean unused = UserLoginActivityV4.this.f76098k = true;
            tg.h.c().h(true);
            i6.i.b().f(new v(this, this.f76121b));
        }

        /* renamed from: e */
        public void onResult(l lVar) {
            k.d("HBPasskey", "passkey login success !");
            HashMap hashMap = new HashMap(1);
            hashMap.put("pagetype", "1Step");
            gs.g.i("appExpose_passkey", hashMap);
            tg.h.c().h(false);
            UserLoginActivityV4.this.Bi(lVar, this.f76120a);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Intent intent = new Intent(this, UserRegisterActivityV3.class);
        intent.putExtra("login_multiple_account", ((UserLoginPresenter) getPresenter()).Y0());
        if (((UserLoginPresenter) getPresenter()).R0() != null) {
            intent.putExtra("target", ((UserLoginPresenter) getPresenter()).R0());
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("button_name", "SignUp");
        gs.g.i("appClick_login", hashMap);
        startActivity(intent);
        if (((UserLoginPresenter) getPresenter()).P0() == null) {
            overridePendingTransition(0, 0);
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (this.f76102o.K()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        SoftInputUtils.f(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ti(View view) {
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ui(View view) {
        sn.f.g0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void wi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        HashMap hashMap = new HashMap(2);
        hashMap.put("pageSource", "Login");
        hashMap.put("button_name", "Cancel");
        gs.g.i("popUpClick_login", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xi(HBDialogFragment hBDialogFragment) {
        Intent intent = new Intent(this, UserRegisterActivityV3.class);
        intent.putExtra("login_name", getAccount());
        if (qi()) {
            intent.putExtra("phone_area_code", hi());
            intent.putExtra("country_area_code", ii());
        }
        startActivity(intent);
        HashMap hashMap = new HashMap(2);
        hashMap.put("pageSource", "Login");
        hashMap.put("button_name", "SignUp");
        gs.g.i("popUpClick_login", hashMap);
    }

    public final void Ai(String str, String str2, HashMap<String, Object> hashMap) {
        androidx.credentials.g.a(this).c(new GetCredentialRequest.Builder().a(new n(str)).b(), this, (CancellationSignal) null, Executors.newSingleThreadExecutor(), new j(str2, hashMap));
    }

    public final void Bi(l lVar, String str) {
        if (lVar == null || !(lVar.a() instanceof p)) {
            k.d("HBPasskey", "passkey login response error !");
            dismissProgressDialog();
            return;
        }
        JSONObject parseObject = JSON.parseObject(((p) lVar.a()).a());
        JSONObject jSONObject = parseObject.getJSONObject("response");
        HashMap hashMap = new HashMap();
        hashMap.put("token", this.f76096i);
        hashMap.put("user_uuid", str);
        hashMap.put("way", "APP_HUOBI_PRO");
        hashMap.put("raw_authenticator_data", jSONObject.get("authenticatorData"));
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, jSONObject.get(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE));
        hashMap.put("client_data", jSONObject.get("clientDataJSON"));
        hashMap.put("credential_id", parseObject.get("id"));
        hashMap.put("user_handle", jSONObject.get("userHandle"));
        o9.a.a().passkeyLogin(hashMap).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a());
    }

    public void C9(String str, String str2, int i11, RiskControl riskControl) {
        if (!isCanBeSeen()) {
            G0();
        } else {
            this.f76103p.B(str, str2, i11, FirebaseAnalytics.Event.LOGIN, riskControl);
        }
    }

    public final void Ci() {
        CountryInfo g11 = w.j().g();
        if (g11 != null && g11.isShowMsg() && !c0.f76688a) {
            new DialogUtils.b.d(this).i1(0).g1(17).e1(Integer.valueOf(getColor(R.color.color_E94359))).h1(Float.valueOf((float) DisplayTool.dp2px(18.0f))).c1(getString(R.string.n_hk_toast_title)).H0(Float.valueOf((float) DisplayTool.dp2px(16.0f))).G0(Integer.valueOf(DisplayTool.dp2px(10.0f))).X0(true).C0(getString(R.string.n_hk_toast_content)).W0(Float.valueOf((float) DisplayTool.dp2px(14.0f))).R0(getString(R.string.n_hk_toast_desc)).T0(true).V0(Integer.valueOf(DisplayTool.dp2px(15.0f))).b1(Integer.valueOf(DisplayTool.dp2px(15.0f))).Y0(" ").Z0(true).q0(false).P0(getString(R.string.n_copy_trading_me_know)).Q0(t.f61116a).l0().show(getSupportFragmentManager(), "");
            c0.f76688a = true;
        }
    }

    public final void Di(HashMap<String, Object> hashMap) {
        PasskeyFragment passkeyFragment = this.f76099l;
        if (passkeyFragment != null) {
            passkeyFragment.dismiss();
        }
        if (this.f76100m == null) {
            this.f76100m = new LoginPwdFragment(new h(hashMap));
        }
        this.f76100m.show(getSupportFragmentManager(), "");
        Ji("1Step", "Password");
    }

    public final void Ei(HashMap<String, Object> hashMap) {
        LoginPwdFragment loginPwdFragment = this.f76100m;
        if (loginPwdFragment != null) {
            loginPwdFragment.dismiss();
        }
        if (this.f76099l == null) {
            k.d("HBPasskey", "passkey login show !");
            this.f76099l = new PasskeyFragment(new g(hashMap));
        }
        this.f76099l.show(getSupportFragmentManager(), "");
        Ji("1Step", "PassKey");
    }

    public void Fi() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("pageSource", "Login");
        gs.g.i("popUp_login", hashMap);
        DialogUtils.c0(this, getString(R.string.n_login_input_not_reg), "", getString(R.string.n_login_switch_account), getString(R.string.n_home_register), u.f61117a, new s(this)).show(getSupportFragmentManager(), "");
    }

    public void G0() {
        this.f76093f.dismissAnim();
        this.f76104q.v();
    }

    public final void Gi() {
        this.f76089b.setCheckedPosition(this.f76095h);
        if (pi()) {
            this.f76090c.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
            this.f76091d.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76092e.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
        } else if (qi()) {
            this.f76090c.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76091d.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
            this.f76092e.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
        } else if (I0()) {
            this.f76090c.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76091d.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76092e.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
        }
    }

    public void Hg(FollowTypeData followTypeData, HashMap<String, Object> hashMap) {
        this.f76096i = followTypeData.getAuthCodeLoginToken();
        this.f76097j = false;
        if (FollowTypeData.FLOW_TYPE_LOGIN_PASS_KEY.equals(followTypeData.getFlowType())) {
            if (tg.h.c().i()) {
                this.f76097j = true;
                Ei(hashMap);
                return;
            }
            Di(hashMap);
        } else if (followTypeData.getFlowType().equals(VerifyAuthCodeData.FLOW_TYPE_LOGIN_2FA)) {
            Di(hashMap);
        } else if (I0()) {
            this.f76102o.M(Boolean.TRUE);
        } else {
            Fi();
        }
    }

    public final void Hi() {
        Gi();
        String stringExtra = getIntent().getStringExtra("login_name");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = c0.b();
        }
        this.f76102o.O(stringExtra, Boolean.TRUE);
    }

    public boolean I0() {
        return this.f76095h == 2;
    }

    public final void Ii(String str, String str2, String str3) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("verification_way", str2);
        hashMap.put("pagetype", str);
        hashMap.put("button_name", str3);
        gs.g.i("appClick_verification", hashMap);
    }

    public final void Ji(String str, String str2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("verification_way", str2);
        hashMap.put("pagetype", str);
        gs.g.i("appView_verification", hashMap);
    }

    public void K0() {
        this.f76103p.m();
    }

    public void Ma() {
        this.f76103p.D(getAccount(), 2, this.f76095h, this.f76102o.m(), new f());
    }

    public LoginSuccBean Pf() {
        LoginSuccBean loginSuccBean = new LoginSuccBean();
        loginSuccBean.f(qi());
        loginSuccBean.d(hi());
        loginSuccBean.e(ii());
        return loginSuccBean;
    }

    public void addEvent() {
        this.viewFinder.b(R.id.login_close_btn).setOnClickListener(new o(this));
        this.f76093f.setOnClickListener(this);
        this.viewFinder.b(R.id.login_sign_up).setOnClickListener(new vn.p(this));
        this.viewFinder.b(R.id.scrollContent).setOnClickListener(new q(this));
    }

    public void b2() {
    }

    public boolean canFullScreen() {
        return true;
    }

    public void dh() {
        this.f76102o.M(Boolean.TRUE);
    }

    public final void ei() {
        HashMap hashMap = new HashMap();
        hashMap.put("way", "WEB");
        if (pi()) {
            hashMap.put("email", getAccount());
            Ji("1Step", "MailCode");
        } else {
            Ji("1Step", "SMSCode");
        }
        HashMap hashMap2 = new HashMap(4);
        hashMap2.put("sign_type", pi() ? "mail" : "tel");
        hashMap2.put("is_success", Boolean.TRUE);
        hashMap2.put("button_name", "获取验证码");
        gs.g.i("app_login_button_click", hashMap2);
        if (getPresenter() != null) {
            showProgressDialog();
            ((UserLoginPresenter) getPresenter()).V1(hashMap, getAccount(), qi(), hi(), this.f76096i);
            m7();
        }
    }

    /* renamed from: fi */
    public UserLoginPresenter createPresenter() {
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter();
        userLoginPresenter.T0(getIntent());
        return userLoginPresenter;
    }

    public void g2(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map) {
        int type = list.get(0).getType();
        String str2 = type == 1 ? "ga" : type == 2 ? "tel" : "mail";
        HashMap hashMap = new HashMap(2);
        hashMap.put(InnerShareParams.SCENCE, "密码登录");
        hashMap.put("verification_type", str2);
        gs.g.i("twoFA_show", hashMap);
        this.f76104q.A(list, str, map);
    }

    public void ge(boolean z11, String str, String str2, boolean z12, String str3, Map<String, Object> map) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = null;
        if (!TextUtils.isEmpty(str)) {
            str8 = "tel,";
            str5 = "SMSCode,";
        } else {
            str5 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (str4 == null) {
                str4 = "mail,";
            } else {
                str4 = str4 + "mail,";
            }
            if (str5 == null) {
                str5 = "MailCode,";
            } else {
                str5 = str5 + "MailCode,";
            }
        }
        if (z11) {
            if (str4 == null) {
                str7 = "ga,";
            } else {
                str7 = str4 + "ga,";
            }
            if (str5 == null) {
                str5 = "GA,";
            } else {
                str5 = str5 + "GA,";
            }
        }
        if (z12) {
            if (str4 == null) {
                str6 = "password,";
            } else {
                str6 = str4 + "password,";
            }
            if (str5 == null) {
                str5 = "Password,";
            } else {
                str5 = str5 + "Password,";
            }
        }
        if (str4.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            str4 = str4.substring(0, str4.length() - 1);
        }
        if (str5.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            str5 = str5.substring(0, str5.length() - 1);
        }
        String str9 = str5;
        HashMap hashMap = new HashMap(2);
        hashMap.put(InnerShareParams.SCENCE, "密码登录");
        hashMap.put("verification_type", str4);
        gs.g.i("twoFA_show", hashMap);
        Ji("2FA", str9);
        this.f76104q.C(z11, str, str2, z12, str3, map, str9);
    }

    public String getAccount() {
        return this.f76102o.l();
    }

    public int getContentView() {
        getWindow().setFlags(8192, 8192);
        return R.layout.activity_login_v4;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public final void gi(HashMap<String, Object> hashMap) {
        showProgressDialog(true);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", 2);
        hashMap2.put("token", this.f76096i);
        o9.a.a().getChallenge(hashMap2).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new i(hashMap));
    }

    public void h5() {
        this.f76104q.u();
    }

    public final String hi() {
        return this.f76102o.m();
    }

    public final String ii() {
        return this.f76102o.n();
    }

    public void initView() {
        String stringExtra = getIntent().getStringExtra("login_name");
        if (TextUtils.isEmpty(stringExtra) && !getIntent().getBooleanExtra("login_multiple_account", false)) {
            stringExtra = c0.b();
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            ri(stringExtra);
        }
        this.f76089b = (RadioGroupContainer) this.viewFinder.b(R.id.type_tab);
        this.f76090c = (CheckBox) this.viewFinder.b(R.id.type_email_txt);
        this.f76091d = (CheckBox) this.viewFinder.b(R.id.type_phone_txt);
        this.f76092e = (CheckBox) this.viewFinder.b(R.id.type_sub_account_txt);
        StatusButton statusButton = (StatusButton) this.viewFinder.b(R.id.login_btn);
        this.f76093f = statusButton;
        statusButton.setButtonText(getString(R.string.n_grid_user_guide_next));
        this.f76093f.setBackgroundResource(R.drawable.register_v2_btn_bg);
        this.f76094g = (TextView) this.viewFinder.b(R.id.agreementText);
        this.f76105r.k(this.viewFinder);
        this.f76102o.s(this, this.viewFinder);
        Hi();
        oi();
        Ci();
    }

    public final CharSequence ji() {
        return this.f76102o.o();
    }

    public final String ki() {
        return this.f76102o.q();
    }

    public final CharSequence li() {
        return this.f76102o.r();
    }

    public void m7() {
        this.f76096i = "";
    }

    public final String mi(ChallengeTypeData challengeTypeData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClientData.KEY_CHALLENGE, (Object) challengeTypeData.getChallenge());
        jSONObject.put(OptionsBridge.TIMEOUT_KEY, (Object) 300000);
        jSONObject.put("rpId", (Object) "www.htx.com");
        jSONObject.put("userVerification", (Object) "preferred");
        JSONArray jSONArray = new JSONArray();
        for (String put : challengeTypeData.getCredentialIds()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", (Object) put);
            jSONObject2.put("type", (Object) "public-key");
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.add("internal");
            jSONArray2.add("hybrid");
            jSONObject2.put("transports", (Object) jSONArray2);
            jSONArray.add(jSONObject2);
        }
        jSONObject.put("allowCredentials", (Object) jSONArray);
        return jSONObject.toString();
    }

    public void n3() {
        this.f76093f.showAnim();
    }

    /* renamed from: ni */
    public UserLoginPresenter.f getUI() {
        return this;
    }

    public final void oi() {
        String string = getString(R.string.n_login_login_agree);
        String string2 = getString(R.string.privacy_agreement_url2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, new Object[]{string2}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.baseColorThreeLevelText)), 0, spannableStringBuilder.length(), 17);
        SpannableUtils.d(this, spannableStringBuilder, string2, new vn.r(this));
        this.f76094g.setMovementMethod(LinkMovementMethod.getInstance());
        this.f76094g.setText(spannableStringBuilder);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (!this.f76103p.w(i11, i12, intent)) {
            G0();
        }
        this.f76105r.v(i11, i12, intent);
        this.f76102o.J(i11, i12, intent);
        zi(i11, i12, intent);
    }

    public void onBackPressed() {
        SoftInputUtils.f(this);
        if (getPresenter() != null) {
            ((UserLoginPresenter) getPresenter()).H0();
        } else {
            finish();
        }
    }

    @SuppressLint({"NonConstantResourceId"})
    @SensorsDataInstrumented
    public void onClick(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (view.getId() == R.id.login_btn) {
            boolean v11 = this.f76102o.v();
            HashMap hashMap = new HashMap(4);
            hashMap.put("sign_type", pi() ? "mail" : I0() ? "sub" : "tel");
            hashMap.put("is_success", Boolean.valueOf(v11));
            hashMap.put("button_name", "密码登录");
            gs.g.i("app_login_button_click", hashMap);
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("button_name", "Next");
            gs.g.i("appClick_login", hashMap2);
            if (v11) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            } else {
                ((UserLoginPresenter) getPresenter()).L1(getAccount(), "", 1, qi(), hi());
                this.f76093f.showAnim();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable) null);
        }
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("login_name");
        String b11 = c0.b();
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = b11;
        }
        this.f76105r.w(stringExtra);
        HashMap hashMap = new HashMap(2);
        hashMap.put("Page_name", "密码登录");
        gs.g.i("App_login_pageview", hashMap);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("is_login_history", Boolean.valueOf(!TextUtils.isEmpty(b11)));
        gs.g.i("appView_login", hashMap2);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f76103p.x();
    }

    public void p2(int i11, String str, String str2, String str3, Map<String, Object> map) {
        String str4 = !TextUtils.isEmpty(str) ? "tel," : null;
        if (!TextUtils.isEmpty(str2)) {
            if (str4 == null) {
                str4 = "mail,";
            } else {
                str4 = str4 + "mail,";
            }
        }
        if (str4.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            str4 = str4.substring(0, str4.length() - 1);
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(InnerShareParams.SCENCE, "密码登录");
        hashMap.put("verification_type", str4);
        gs.g.i("twoFA_show", hashMap);
        this.f76104q.y(i11, str, str2, str3, map);
    }

    public final boolean pi() {
        return this.f76095h == 0;
    }

    public void q1(String str) {
        HuobiToastUtil.m(str);
    }

    public final boolean qi() {
        return this.f76095h == 1;
    }

    public void r2() {
        String account = getAccount();
        String hi2 = hi();
        String ii2 = ii();
        if (pi()) {
            CaptchaCodeActivityV2.Rh(this, "register_email", account, hi2, ii2, (String) null, (String) null, ((UserLoginPresenter) getPresenter()).O0(), true, (!this.f76097j || this.f76098k) ? 1 : 2, "AUTH_CODE_LOGIN_REGISTER");
        } else {
            CaptchaCodeActivityV2.Rh(this, "register_mobile", account, hi2.replace("+", "00"), ii2, (String) null, (String) null, ((UserLoginPresenter) getPresenter()).O0(), true, (!this.f76097j || this.f76098k) ? 1 : 2, "AUTH_CODE_LOGIN_REGISTER");
        }
    }

    public final void ri(String str) {
        this.f76095h = this.f76102o.p(str);
        this.f76102o.x(str);
    }

    public final void si(String str) {
        int p11 = this.f76102o.p(str);
        if (this.f76095h != p11) {
            this.f76095h = p11;
            Gi();
            this.f76102o.O(str, Boolean.FALSE);
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void yg() {
        this.f76102o.N(true);
    }

    public void yi() {
        ((UserLoginPresenter) getPresenter()).L1(getAccount(), "", 1, qi(), hi());
        this.f76093f.showAnim();
    }

    public final void zi(int i11, int i12, Intent intent) {
        if (i11 == 124 && i12 == -1) {
            VerifyAuthCodeData verifyAuthCodeData = (VerifyAuthCodeData) intent.getSerializableExtra("VerifyAuthCodeData");
            if (verifyAuthCodeData == null) {
                String stringExtra = intent.getStringExtra("switch_type");
                stringExtra.hashCode();
                if (stringExtra.equals("passkey")) {
                    Ei(this.f76101n);
                } else if (stringExtra.equals("pwd")) {
                    Di(this.f76101n);
                }
            } else {
                String flowType = verifyAuthCodeData.getFlowType();
                if (VerifyAuthCodeData.FLOW_TYPE_LOGIN.equals(flowType)) {
                    ((UserLoginPresenter) getPresenter()).R1(getAccount(), verifyAuthCodeData.getUcToken(), verifyAuthCodeData.getTicket());
                } else if (!VerifyAuthCodeData.FLOW_TYPE_LOGIN_2FA.equals(flowType)) {
                    VerifyAuthCodeData.FLOW_TYPE_REGISTER.equals(flowType);
                } else if (verifyAuthCodeData.getRequireTypes() != null && verifyAuthCodeData.getRequireTypes().size() > 0) {
                    getUI().showProgressDialog();
                    List<LoginInfoData.Login2FAOption> requireTypes = verifyAuthCodeData.getRequireTypes();
                    String str = "";
                    String str2 = str;
                    boolean z11 = false;
                    boolean z12 = false;
                    for (int i13 = 0; i13 < requireTypes.size(); i13++) {
                        LoginInfoData.Login2FAOption login2FAOption = requireTypes.get(i13);
                        int type = login2FAOption.getType();
                        if (type == 1) {
                            z11 = true;
                        } else if (type == 2) {
                            str = login2FAOption.getTag();
                        } else if (type == 3) {
                            str2 = login2FAOption.getTag();
                        } else if (type == 4) {
                            z12 = true;
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("isKnowDevice", Boolean.valueOf(verifyAuthCodeData.isKnowDevice()));
                    ge(z11, str, str2, z12, verifyAuthCodeData.getToken(), hashMap);
                    getUI().dismissProgressDialog();
                }
            }
        }
    }
}
