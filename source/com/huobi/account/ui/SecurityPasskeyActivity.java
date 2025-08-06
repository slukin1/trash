package com.huobi.account.ui;

import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.h;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.login.usercenter.data.source.bean.ChallengeTypeData;
import com.huobi.login.usercenter.data.source.bean.PasskeyVerifyData;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.k;
import java.util.HashMap;
import java.util.concurrent.Executors;
import pro.huobi.R;
import tg.r;

public class SecurityPasskeyActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public androidx.credentials.g f41305b;

    /* renamed from: c  reason: collision with root package name */
    public Security2FADialogHelper f41306c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41307d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41308e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            gs.g.i("guidePasskey_click", (HashMap) null);
            SecurityPasskeyActivity.this.ph();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SecurityPasskeyActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SecurityPasskeyActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements h<androidx.credentials.b, CreateCredentialException> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41312a;

        public d(String str) {
            this.f41312a = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            SecurityPasskeyActivity securityPasskeyActivity = SecurityPasskeyActivity.this;
            Toast.makeText(securityPasskeyActivity, securityPasskeyActivity.getString(R.string.n_quick_addition_add_failure), 0).show();
        }

        /* renamed from: d */
        public void a(CreateCredentialException createCredentialException) {
            SecurityPasskeyActivity.this.dismissProgressDialog();
            k.g("HBPasskey", "Create passkey error!", createCredentialException);
            i.b().d(new j1(this));
        }

        /* renamed from: e */
        public void onResult(androidx.credentials.b bVar) {
            k.d("HBPasskey", "Create passkey success!");
            tg.h.c().g(r.x().s(), true);
            SecurityPasskeyActivity.this.Og(bVar, this.f41312a);
        }
    }

    public class e extends EasySubscriber<PasskeyVerifyData> {

        public class a extends Security2FADialogHelper.Callback {
            public a() {
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void b(String str) {
                Toast.makeText(SecurityPasskeyActivity.this, str, 0).show();
            }

            public void onFailed(String str) {
                SecurityPasskeyActivity.this.dismissProgressDialog();
                i.b().f(new k1(this, str));
                k.f("HBPasskey", str);
            }

            public void onSuccess(String str) {
                k.d("HBPasskey", "Create passkey 2fa success!");
                SecurityPasskeyActivity.this.Pg(str);
            }
        }

        public e() {
        }

        /* renamed from: a */
        public void onNext(PasskeyVerifyData passkeyVerifyData) {
            if (passkeyVerifyData.isVerify2fa()) {
                SecurityPasskeyActivity.this.f41306c.R(new a());
                return;
            }
            k.d("HBPasskey", "Create passkey no need 2fa!");
            SecurityPasskeyActivity.this.Pg((String) null);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SecurityPasskeyActivity.this.dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SecurityPasskeyActivity.this.dismissProgressDialog();
        }
    }

    public class f extends EasySubscriber<ChallengeTypeData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41316b;

        public f(String str) {
            this.f41316b = str;
        }

        /* renamed from: a */
        public void onNext(ChallengeTypeData challengeTypeData) {
            try {
                k.d("HBPasskey", "Create passkey getChallenge success!");
                SecurityPasskeyActivity.this.gg(challengeTypeData, this.f41316b);
            } catch (JSONException e11) {
                k.g("HBPasskey", "Create passkey exception!", e11);
                e11.printStackTrace();
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SecurityPasskeyActivity.this.dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.g("HBPasskey", "Create passkey getChallenge failed!", aPIStatusErrorException);
            SecurityPasskeyActivity.this.dismissProgressDialog();
        }
    }

    public class g extends EasySubscriber<Object> {
        public g() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.g("HBPasskey", "Create passkey web error!", th2);
            SecurityPasskeyActivity.this.dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.g("HBPasskey", "Create passkey web failed!", aPIStatusErrorException);
            SecurityPasskeyActivity.this.dismissProgressDialog();
        }

        public void onNext(Object obj) {
            k.d("HBPasskey", "Create passkey web success!");
            gs.g.i("setPasskey_result", (HashMap) null);
            SecurityPasskeyActivity.this.finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh() {
        Toast.makeText(this, getString(R.string.n_quick_addition_add_failure), 0).show();
    }

    public final void Og(androidx.credentials.b bVar, String str) {
        if (!(bVar instanceof androidx.credentials.e)) {
            k.f("HBPasskey", "Create passkey response error!");
            dismissProgressDialog();
            return;
        }
        JSONObject parseObject = JSON.parseObject(((androidx.credentials.e) bVar).a());
        JSONObject jSONObject = parseObject.getJSONObject("response");
        HashMap hashMap = new HashMap();
        hashMap.put("attestation_object", jSONObject.get("attestationObject"));
        hashMap.put("client_data", jSONObject.get("clientDataJSON"));
        hashMap.put("credential_id", parseObject.get("id"));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("auth_token", str);
        }
        hashMap.put("device_name", Build.BRAND);
        o9.a.a().createPasskey(hashMap).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new g());
    }

    public final void Pg(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", 1);
        o9.a.a().getChallenge(hashMap).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new f(str));
    }

    public final String Qg(ChallengeTypeData challengeTypeData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClientData.KEY_CHALLENGE, (Object) challengeTypeData.getChallenge());
        jSONObject.put(OptionsBridge.TIMEOUT_KEY, (Object) 300000);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", (Object) "www.htx.com");
        jSONObject2.put("name", (Object) "HTX");
        jSONObject.put("rp", (Object) jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("id", (Object) challengeTypeData.getUuid());
        if (TextUtils.isEmpty(challengeTypeData.getLoginName())) {
            return null;
        }
        jSONObject3.put("name", (Object) challengeTypeData.getLoginName());
        jSONObject3.put("displayName", (Object) Build.BRAND);
        jSONObject.put("user", (Object) jSONObject3);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("type", (Object) "public-key");
        jSONObject4.put("alg", (Object) -7);
        jSONArray.add(jSONObject4);
        jSONObject.put("pubKeyCredParams", (Object) jSONArray);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("authenticatorAttachment", (Object) "platform");
        jSONObject5.put("residentKey", (Object) "required");
        jSONObject5.put("requireResidentKey", (Object) Boolean.TRUE);
        jSONObject5.put("userVerification", (Object) "preferred");
        jSONObject.put("authenticatorSelection", (Object) jSONObject5);
        return jSONObject.toString();
    }

    public void finish() {
        super.finish();
        if (this.f41308e) {
            UserLoginHelper.e().o(this, this.f41307d);
        }
    }

    public int getContentView() {
        return R.layout.activity_security_passkey;
    }

    public void gg(ChallengeTypeData challengeTypeData, String str) {
        String Qg = Qg(challengeTypeData);
        if (TextUtils.isEmpty(Qg)) {
            k.f("HBPasskey", "Create passkey requestJson null!");
            i.b().d(new i1(this));
            return;
        }
        this.f41305b.b(new androidx.credentials.d(Qg, (String) null), this, (CancellationSignal) null, Executors.newSingleThreadExecutor(), new d(str));
    }

    public void initExtra() {
        super.initExtra();
        this.f41305b = androidx.credentials.g.a(this);
        this.f41307d = getIntent().getBooleanExtra("checkGuide", false);
        this.f41308e = getIntent().getBooleanExtra("showJump", false);
        this.f41306c = new Security2FADialogHelper(this, this, "PASS_KEY_DELETE");
        HashMap hashMap = new HashMap();
        hashMap.put("pageSource", this.f41308e ? "登录引导" : "用户主动点击");
        gs.g.i("guidePasskey_view", hashMap);
    }

    public void initView() {
        super.initView();
        findViewById(R.id.btn_create_passkey_enable).setOnClickListener(new a());
        findViewById(R.id.btn_create_passkey_close).setOnClickListener(new b());
        if (this.f41308e) {
            findViewById(R.id.btn_create_passkey_jump).setVisibility(0);
            findViewById(R.id.btn_create_passkey_jump).setOnClickListener(new c());
        }
    }

    public final void ph() {
        showProgressDialog(true);
        o9.a.a().passkeyVerify().b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new e());
    }
}
