package com.huobi.finance.utils;

import al.f0;
import al.g0;
import al.h0;
import al.i0;
import al.j0;
import al.k0;
import al.l0;
import al.m0;
import al.n0;
import al.o0;
import al.p0;
import al.q0;
import android.os.CancellationSignal;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException;
import androidx.credentials.l;
import androidx.credentials.n;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.account.ui.SecurityStrategyPasskeyFragment;
import com.huobi.login.usercenter.data.source.bean.ChallengeTypeData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.iproov.sdk.bridge.OptionsBridge;
import com.jumio.core.cdn.CDNDownload;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import i6.k;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import pro.huobi.R;
import rx.Observable;
import tq.p;

public class Security2FADialogHelper {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentActivity f47440a;

    /* renamed from: b  reason: collision with root package name */
    public final SecurityStrategyBottomMenuFragment f47441b;

    /* renamed from: c  reason: collision with root package name */
    public final SecurityStrategyPasskeyFragment f47442c;

    /* renamed from: d  reason: collision with root package name */
    public final u6.g f47443d;

    /* renamed from: e  reason: collision with root package name */
    public Callback f47444e;

    /* renamed from: f  reason: collision with root package name */
    public String f47445f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f47446g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f47447h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47448i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f47449j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f47450k = false;

    /* renamed from: l  reason: collision with root package name */
    public jp.c f47451l;

    public static class AuthResult implements Serializable {
        @SerializedName("email-code")
        public String emailCode;
        @SerializedName("ga-code")
        public String gaCode;
        @SerializedName("login-password")
        public String loginPassword;
        @SerializedName("order-id")
        public String orderId;
        @SerializedName("passkey")
        public PasskeyAuth passkey;
        @SerializedName("sms-code")
        public String smsCode;
        @SerializedName("token")
        public String token;

        public AuthResult(String str, String str2, String str3, String str4, String str5, String str6) {
            this(str, str2, str3, str4, str5, (PasskeyAuth) null, str6);
        }

        public boolean canEqual(Object obj) {
            return obj instanceof AuthResult;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthResult)) {
                return false;
            }
            AuthResult authResult = (AuthResult) obj;
            if (!authResult.canEqual(this)) {
                return false;
            }
            String emailCode2 = getEmailCode();
            String emailCode3 = authResult.getEmailCode();
            if (emailCode2 != null ? !emailCode2.equals(emailCode3) : emailCode3 != null) {
                return false;
            }
            String smsCode2 = getSmsCode();
            String smsCode3 = authResult.getSmsCode();
            if (smsCode2 != null ? !smsCode2.equals(smsCode3) : smsCode3 != null) {
                return false;
            }
            String gaCode2 = getGaCode();
            String gaCode3 = authResult.getGaCode();
            if (gaCode2 != null ? !gaCode2.equals(gaCode3) : gaCode3 != null) {
                return false;
            }
            String token2 = getToken();
            String token3 = authResult.getToken();
            if (token2 != null ? !token2.equals(token3) : token3 != null) {
                return false;
            }
            String orderId2 = getOrderId();
            String orderId3 = authResult.getOrderId();
            if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
                return false;
            }
            String loginPassword2 = getLoginPassword();
            String loginPassword3 = authResult.getLoginPassword();
            if (loginPassword2 != null ? !loginPassword2.equals(loginPassword3) : loginPassword3 != null) {
                return false;
            }
            PasskeyAuth passkey2 = getPasskey();
            PasskeyAuth passkey3 = authResult.getPasskey();
            return passkey2 != null ? passkey2.equals(passkey3) : passkey3 == null;
        }

        public String getEmailCode() {
            return this.emailCode;
        }

        public String getGaCode() {
            return this.gaCode;
        }

        public String getLoginPassword() {
            return this.loginPassword;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public PasskeyAuth getPasskey() {
            return this.passkey;
        }

        public String getSmsCode() {
            return this.smsCode;
        }

        public String getToken() {
            return this.token;
        }

        public int hashCode() {
            String emailCode2 = getEmailCode();
            int i11 = 43;
            int hashCode = emailCode2 == null ? 43 : emailCode2.hashCode();
            String smsCode2 = getSmsCode();
            int hashCode2 = ((hashCode + 59) * 59) + (smsCode2 == null ? 43 : smsCode2.hashCode());
            String gaCode2 = getGaCode();
            int hashCode3 = (hashCode2 * 59) + (gaCode2 == null ? 43 : gaCode2.hashCode());
            String token2 = getToken();
            int hashCode4 = (hashCode3 * 59) + (token2 == null ? 43 : token2.hashCode());
            String orderId2 = getOrderId();
            int hashCode5 = (hashCode4 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
            String loginPassword2 = getLoginPassword();
            int hashCode6 = (hashCode5 * 59) + (loginPassword2 == null ? 43 : loginPassword2.hashCode());
            PasskeyAuth passkey2 = getPasskey();
            int i12 = hashCode6 * 59;
            if (passkey2 != null) {
                i11 = passkey2.hashCode();
            }
            return i12 + i11;
        }

        public void setEmailCode(String str) {
            this.emailCode = str;
        }

        public void setGaCode(String str) {
            this.gaCode = str;
        }

        public void setLoginPassword(String str) {
            this.loginPassword = str;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public void setPasskey(PasskeyAuth passkeyAuth) {
            this.passkey = passkeyAuth;
        }

        public void setSmsCode(String str) {
            this.smsCode = str;
        }

        public void setToken(String str) {
            this.token = str;
        }

        public String toString() {
            return "Security2FADialogHelper.AuthResult(emailCode=" + getEmailCode() + ", smsCode=" + getSmsCode() + ", gaCode=" + getGaCode() + ", token=" + getToken() + ", orderId=" + getOrderId() + ", loginPassword=" + getLoginPassword() + ", passkey=" + getPasskey() + ")";
        }

        public AuthResult(String str, String str2, String str3, String str4, String str5, PasskeyAuth passkeyAuth, String str6) {
            this.emailCode = str;
            this.smsCode = str2;
            this.gaCode = str3;
            this.token = str4;
            this.loginPassword = str5;
            this.passkey = passkeyAuth;
            this.orderId = str6;
        }
    }

    public static abstract class Callback {
        public void onApiError(String str) {
        }

        public abstract void onFailed(String str);

        public void onManualDismiss() {
        }

        public void onSuccess(AuthResult authResult) {
        }

        public void onSuccess(String str) {
        }
    }

    public static class PasskeyAuth implements Serializable {
        @SerializedName("client_data")
        public String clientData;
        @SerializedName("credential_id")
        public String credentialId;
        @SerializedName("raw_authenticator_data")
        public String rawAuthData;
        @SerializedName("signature")
        public String signature;
        @SerializedName("user_handle")
        public String userHandle;

        public PasskeyAuth(String str, String str2, String str3, String str4, String str5) {
            this.rawAuthData = str;
            this.signature = str2;
            this.clientData = str3;
            this.credentialId = str4;
            this.userHandle = str5;
        }
    }

    public class a implements SecurityStrategyPasskeyFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callback f47452a;

        public a(Callback callback) {
            this.f47452a = callback;
        }

        public void a() {
            Security2FADialogHelper.this.f47442c.dismiss();
        }

        public void b() {
            Security2FADialogHelper.this.J();
        }

        public void onCancel() {
            this.f47452a.onManualDismiss();
        }
    }

    public class b implements BaseDialogFragment.c {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Callback f47454b;

        public b(Callback callback) {
            this.f47454b = callback;
        }

        public void onDialogFragmentBackPressed() {
            this.f47454b.onManualDismiss();
        }

        public void onDialogFragmentPause() {
        }

        public void onDialogFragmentResume() {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Security2FADialogHelper.this.f47444e.onManualDismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements BaseDialogFragment.c {
        public d() {
        }

        public void onDialogFragmentBackPressed() {
            Security2FADialogHelper.this.f47444e.onManualDismiss();
        }

        public void onDialogFragmentPause() {
        }

        public void onDialogFragmentResume() {
        }
    }

    public class e implements SecurityStrategyPasskeyFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Pair f47458a;

        public e(Pair pair) {
            this.f47458a = pair;
        }

        public void a() {
            Security2FADialogHelper.this.f47442c.dismiss();
            Security2FADialogHelper.this.Q(this.f47458a, false);
        }

        public void b() {
            Security2FADialogHelper.this.J();
        }

        public void onCancel() {
            Security2FADialogHelper.this.f47444e.onManualDismiss();
        }
    }

    public class f implements BaseDialogFragment.c {
        public f() {
        }

        public void onDialogFragmentBackPressed() {
            Security2FADialogHelper.this.f47444e.onManualDismiss();
        }

        public void onDialogFragmentPause() {
        }

        public void onDialogFragmentResume() {
        }
    }

    public class g extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f47461g = false;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Pair f47462h;

        public g(Pair pair) {
            this.f47462h = pair;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c0(String str, String str2, String str3, String str4, String str5) {
            if (!Security2FADialogHelper.this.f47448i) {
                Security2FADialogHelper.this.v();
            }
            Security2FADialogHelper.this.f47444e.onSuccess(str5);
            Security2FADialogHelper.this.f47444e.onSuccess(new AuthResult(str, str2, str3, str5, str4, Security2FADialogHelper.this.w()));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d0(APIStatusErrorException aPIStatusErrorException) {
            if (!Security2FADialogHelper.this.f47448i) {
                Security2FADialogHelper.this.v();
            }
            Security2FADialogHelper.this.f47444e.onFailed("Security strategy verify failed.");
            Security2FADialogHelper.this.f47444e.onApiError("Security strategy verify failed.");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e0(Throwable th2) {
            if (!Security2FADialogHelper.this.f47448i) {
                Security2FADialogHelper.this.v();
            }
            Security2FADialogHelper.this.f47444e.onFailed("Security strategy verify failed.");
        }

        public boolean C() {
            return ((SecurityStrategySet) this.f47462h.second).getSetting().isVerify_phone();
        }

        public void Q() {
            super.Q();
            if (!this.f47461g) {
                Security2FADialogHelper.this.f47444e.onFailed("Dismiss");
            }
        }

        public void T() {
            Security2FADialogHelper.this.Q(this.f47462h, true);
        }

        public void i(String str, String str2, String str3, String str4) {
            super.i(str, str2, str3, str4);
            this.f47461g = true;
            if (Security2FADialogHelper.this.f47449j) {
                Security2FADialogHelper security2FADialogHelper = Security2FADialogHelper.this;
                UserCenterRemoteDataSource.G(str, str2, str3, str4, security2FADialogHelper.f47446g, security2FADialogHelper.f47445f, q6.d.d(Security2FADialogHelper.this.f47443d, new p0(this, str, str2, str3, str4), new n0(this), new o0(this)), Security2FADialogHelper.this.f47443d);
                return;
            }
            Security2FADialogHelper.this.f47444e.onSuccess("");
            Security2FADialogHelper.this.f47444e.onSuccess(new AuthResult(str, str2, str3, "", str4, Security2FADialogHelper.this.w()));
        }

        public String n() {
            return ((UserSecurityInfoData) this.f47462h.first).getEmail();
        }

        public String o() {
            return ((UserSecurityInfoData) this.f47462h.first).getPhone();
        }

        public Map<String, Object> p() {
            Map<String, Object> b11 = MapParamsBuilder.c().a("use_type", Security2FADialogHelper.this.f47445f).b();
            Map<String, Object> map = Security2FADialogHelper.this.f47446g;
            if (map != null) {
                b11.put("params", map);
            }
            return b11;
        }

        public Map<String, Object> s() {
            Map<String, Object> b11 = MapParamsBuilder.c().a("use_type", Security2FADialogHelper.this.f47445f).a("voice", Boolean.FALSE).b();
            Map<String, Object> map = Security2FADialogHelper.this.f47446g;
            if (map != null) {
                b11.put("params", map);
            }
            return b11;
        }

        public boolean x() {
            return ((SecurityStrategySet) this.f47462h.second).getSetting().isVerify_email();
        }

        public boolean y() {
            return ((SecurityStrategySet) this.f47462h.second).getSetting().isVerify_ga();
        }

        public boolean z() {
            return ((SecurityStrategySet) this.f47462h.second).getSetting().isVerifyPassword();
        }
    }

    public class h extends EasySubscriber<ChallengeTypeData> {
        public h() {
        }

        /* renamed from: a */
        public void onNext(ChallengeTypeData challengeTypeData) {
            if (challengeTypeData == null) {
                try {
                    if (Security2FADialogHelper.this.f47440a instanceof BaseActivity) {
                        ((BaseActivity) Security2FADialogHelper.this.f47440a).dismissProgressDialog();
                    }
                    k.f("HBPasskey", "passkey ChallengeTypeData null !");
                } catch (JSONException e11) {
                    if (Security2FADialogHelper.this.f47440a instanceof BaseActivity) {
                        ((BaseActivity) Security2FADialogHelper.this.f47440a).dismissProgressDialog();
                    }
                    k.g("HBPasskey", "passkey login error !", e11);
                }
            } else {
                Security2FADialogHelper security2FADialogHelper = Security2FADialogHelper.this;
                security2FADialogHelper.I(security2FADialogHelper.x(challengeTypeData));
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (Security2FADialogHelper.this.f47440a instanceof BaseActivity) {
                ((BaseActivity) Security2FADialogHelper.this.f47440a).dismissProgressDialog();
            }
            Security2FADialogHelper.this.f47444e.onFailed("Security strategy get challenge failed.");
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (Security2FADialogHelper.this.f47440a instanceof BaseActivity) {
                ((BaseActivity) Security2FADialogHelper.this.f47440a).dismissProgressDialog();
            }
            Security2FADialogHelper.this.f47444e.onFailed("Security strategy get challenge failed.");
        }
    }

    public class i implements androidx.credentials.h<l, GetCredentialException> {
        public i() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            Toast.makeText(Security2FADialogHelper.this.f47440a, Security2FADialogHelper.this.f47440a.getText(R.string.n_risk_fail_title), 0).show();
        }

        /* renamed from: d */
        public void a(GetCredentialException getCredentialException) {
            if ((getCredentialException instanceof GetCredentialCancellationException) || ((getCredentialException instanceof GetPublicKeyCredentialDomException) && (((GetPublicKeyCredentialDomException) getCredentialException).getDomError() instanceof NotAllowedError))) {
                k.f("HBPasskey", "passkey login cancel !");
                if (Security2FADialogHelper.this.f47440a instanceof BaseActivity) {
                    ((BaseActivity) Security2FADialogHelper.this.f47440a).dismissProgressDialog();
                    return;
                }
                return;
            }
            k.g("HBPasskey", "passkey login error !", getCredentialException);
            tg.h.c().h(true);
            if (Security2FADialogHelper.this.f47440a instanceof BaseActivity) {
                ((BaseActivity) Security2FADialogHelper.this.f47440a).dismissProgressDialog();
            }
            i6.i.b().f(new q0(this));
        }

        /* renamed from: e */
        public void onResult(l lVar) {
            k.d("HBPasskey", "passkey login success !");
            tg.h.c().h(false);
            Security2FADialogHelper.this.K(lVar);
            if (Security2FADialogHelper.this.f47440a instanceof BaseActivity) {
                ((BaseActivity) Security2FADialogHelper.this.f47440a).dismissProgressDialog();
            }
        }
    }

    public Security2FADialogHelper(FragmentActivity fragmentActivity, u6.g gVar, String str) {
        this.f47440a = fragmentActivity;
        this.f47443d = gVar;
        this.f47445f = str;
        this.f47441b = new SecurityStrategyBottomMenuFragment();
        this.f47442c = new SecurityStrategyPasskeyFragment();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(Throwable th2) {
        v();
        this.f47444e.onFailed("Security info load failed.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B() {
        ((BaseActivity) this.f47440a).showProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(PasskeyAuth passkeyAuth, String str) {
        if (!this.f47448i) {
            v();
        }
        FragmentActivity fragmentActivity = this.f47440a;
        if (fragmentActivity instanceof BaseActivity) {
            ((BaseActivity) fragmentActivity).dismissProgressDialog();
        }
        this.f47444e.onSuccess(str);
        this.f47444e.onSuccess(new AuthResult("", "", "", str, "", passkeyAuth, w()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(APIStatusErrorException aPIStatusErrorException) {
        if (!this.f47448i) {
            v();
        }
        FragmentActivity fragmentActivity = this.f47440a;
        if (fragmentActivity instanceof BaseActivity) {
            ((BaseActivity) fragmentActivity).dismissProgressDialog();
        }
        this.f47444e.onFailed("Security strategy verify failed.");
        this.f47444e.onApiError("Security strategy verify failed.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(Throwable th2) {
        if (!this.f47448i) {
            v();
        }
        FragmentActivity fragmentActivity = this.f47440a;
        if (fragmentActivity instanceof BaseActivity) {
            ((BaseActivity) fragmentActivity).dismissProgressDialog();
        }
        this.f47444e.onFailed("Security strategy verify failed.");
    }

    public static String u(int i11) {
        return i11 == 35 ? "VERIFY_SETTING_POLICY_CHANGE_SECURITY_ITEM_CODE" : i11 == 36 ? "CREATED_RED_PACKET" : "";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(Pair pair) {
        Q(pair, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(APIStatusErrorException aPIStatusErrorException) {
        v();
        this.f47444e.onFailed("Security info load failed.");
    }

    public final Observable<UserSecurityInfoData> F() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t(this.f47443d));
    }

    public final void G() {
        Observable.zip(F(), H(), m0.f3581b).subscribe(q6.d.d(this.f47443d, new g0(this), new i0(this), new j0(this)));
    }

    public final Observable<SecurityStrategySet> H() {
        if (this.f47447h != null) {
            return UserCenterRemoteDataSource.A().getSecurityStrategyWithParams(this.f47447h).compose(p.c0()).compose(RxJavaHelper.t(this.f47443d));
        }
        return UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t(this.f47443d));
    }

    public final void I(String str) {
        androidx.credentials.g.a(this.f47440a).c(new GetCredentialRequest.Builder().a(new n(str)).b(), this.f47440a, (CancellationSignal) null, Executors.newSingleThreadExecutor(), new i());
    }

    public final void J() {
        if (this.f47440a instanceof BaseActivity) {
            i6.i.b().d(new f0(this));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", 3);
        hashMap.put("use_type", this.f47445f);
        Map<String, Object> map = this.f47446g;
        if (map != null) {
            hashMap.putAll(map);
        }
        o9.a.a().getChallenge(hashMap).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new h());
    }

    public final void K(l lVar) {
        if (lVar == null || !(lVar.a() instanceof androidx.credentials.p)) {
            k.d("HBPasskey", "passkey login response error !");
            FragmentActivity fragmentActivity = this.f47440a;
            if (fragmentActivity instanceof BaseActivity) {
                ((BaseActivity) fragmentActivity).dismissProgressDialog();
                return;
            }
            return;
        }
        JSONObject parseObject = JSON.parseObject(((androidx.credentials.p) lVar.a()).a());
        JSONObject jSONObject = parseObject.getJSONObject("response");
        PasskeyAuth passkeyAuth = new PasskeyAuth(jSONObject.getString("authenticatorData"), jSONObject.getString(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE), jSONObject.getString("clientDataJSON"), parseObject.getString("id"), jSONObject.getString("userHandle"));
        HashMap hashMap = new HashMap();
        hashMap.put("raw_authenticator_data", passkeyAuth.rawAuthData);
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, passkeyAuth.signature);
        hashMap.put("client_data", passkeyAuth.clientData);
        hashMap.put("credential_id", passkeyAuth.credentialId);
        hashMap.put("user_handle", passkeyAuth.userHandle);
        if (this.f47449j) {
            UserCenterRemoteDataSource.H((String) null, (String) null, (String) null, (String) null, this.f47446g, hashMap, this.f47445f, q6.d.d(this.f47443d, new l0(this, passkeyAuth), new h0(this), new k0(this)), this.f47443d);
            return;
        }
        this.f47444e.onSuccess("");
        this.f47444e.onSuccess(new AuthResult("", "", "", "", "", passkeyAuth, w()));
        FragmentActivity fragmentActivity2 = this.f47440a;
        if (fragmentActivity2 instanceof BaseActivity) {
            ((BaseActivity) fragmentActivity2).dismissProgressDialog();
        }
    }

    public void L(boolean z11) {
        this.f47448i = z11;
    }

    public void M(boolean z11) {
        this.f47450k = z11;
    }

    public void N(boolean z11) {
        this.f47449j = z11;
    }

    public void O(String str) {
        this.f47445f = str;
    }

    public void P(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
        this.f47441b.Ci(new g(pair));
        this.f47441b.show(this.f47440a.getSupportFragmentManager(), "BottomMenuFragment");
    }

    public final void Q(Pair<UserSecurityInfoData, SecurityStrategySet> pair, boolean z11) {
        gs.g.i("security_verification_pop_expose", (HashMap) null);
        boolean z12 = true;
        boolean z13 = ((SecurityStrategySet) pair.second).getSetting().verifyPasskey && tg.h.c().i();
        SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f47441b;
        if (!z13 || !this.f47450k) {
            z12 = false;
        }
        securityStrategyBottomMenuFragment.Fi(z12);
        this.f47441b.zi(new c());
        this.f47441b.setDialogFragmentListener(new d());
        if (!this.f47450k || !z11 || !z13) {
            jp.c cVar = this.f47451l;
            if (cVar != null) {
                cVar.call();
            } else {
                P(pair);
            }
        } else {
            this.f47442c.xh(new e(pair));
            this.f47442c.setDialogFragmentListener(new f());
            this.f47442c.show(this.f47440a.getSupportFragmentManager(), "PasskeyFragment");
        }
    }

    public void R(Callback callback) {
        T((Map<String, Object>) null, callback, (Map<String, Object>) null, (jp.c) null);
    }

    public void S(Callback callback, jp.c cVar) {
        T((Map<String, Object>) null, callback, (Map<String, Object>) null, cVar);
    }

    public void T(Map<String, Object> map, Callback callback, Map<String, Object> map2, jp.c cVar) {
        if (callback != null) {
            this.f47444e = callback;
            this.f47446g = map;
            this.f47447h = map2;
            this.f47451l = cVar;
            G();
            return;
        }
        throw new IllegalArgumentException("Param callback must not be null.");
    }

    public void U(Callback callback, Map<String, Object> map, Map<String, Object> map2) {
        T(map, callback, map2, (jp.c) null);
    }

    public void V(Callback callback) {
        this.f47444e = callback;
        this.f47442c.xh(new a(callback));
        this.f47442c.setDialogFragmentListener(new b(callback));
        this.f47442c.show(this.f47440a.getSupportFragmentManager(), "PasskeyFragment");
    }

    public void v() {
        SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f47441b;
        if (securityStrategyBottomMenuFragment != null) {
            securityStrategyBottomMenuFragment.dismiss();
        }
        SecurityStrategyPasskeyFragment securityStrategyPasskeyFragment = this.f47442c;
        if (securityStrategyPasskeyFragment != null) {
            securityStrategyPasskeyFragment.dismiss();
        }
    }

    public final String w() {
        Map<String, Object> map = this.f47446g;
        if (map != null) {
            return (String) map.get("withdraw_id");
        }
        return null;
    }

    public final String x(ChallengeTypeData challengeTypeData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClientData.KEY_CHALLENGE, (Object) challengeTypeData.getChallenge());
        jSONObject.put(OptionsBridge.TIMEOUT_KEY, (Object) Integer.valueOf(CDNDownload.DEFAULT_TIMEOUT));
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
}
