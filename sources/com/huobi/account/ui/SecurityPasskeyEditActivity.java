package com.huobi.account.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.login.usercenter.data.source.bean.PasskeyVerifyData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;
import u6.g;

public class SecurityPasskeyEditActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public EditText f41319b;

    /* renamed from: c  reason: collision with root package name */
    public Security2FADialogHelper f41320c;

    public class a extends EasySubscriber<Object> {
        public a() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            SecurityPasskeyEditActivity securityPasskeyEditActivity = SecurityPasskeyEditActivity.this;
            Toast.makeText(securityPasskeyEditActivity, securityPasskeyEditActivity.getString(R.string.n_security_success), 0).show();
            SecurityPasskeyEditActivity.this.finish();
        }
    }

    public class b extends EasySubscriber<PasskeyVerifyData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41322b;

        public b(String str) {
            this.f41322b = str;
        }

        /* renamed from: a */
        public void onNext(PasskeyVerifyData passkeyVerifyData) {
            if (passkeyVerifyData.isVerify2fa()) {
                SecurityPasskeyEditActivity.this.th(this.f41322b);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("pass_key_id", this.f41322b);
            SecurityPasskeyEditActivity.this.Qg(hashMap);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public class c extends Security2FADialogHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41324a;

        public c(String str) {
            this.f41324a = str;
        }

        public void onFailed(String str) {
        }

        public void onSuccess(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("pass_key_id", this.f41324a);
            hashMap.put("auth_token", str);
            SecurityPasskeyEditActivity.this.Qg(hashMap);
        }
    }

    public class d extends EasySubscriber<Object> {
        public d() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            SecurityPasskeyEditActivity securityPasskeyEditActivity = SecurityPasskeyEditActivity.this;
            Toast.makeText(securityPasskeyEditActivity, securityPasskeyEditActivity.getString(R.string.n_security_passkeys_delete), 0).show();
            SecurityPasskeyEditActivity.this.finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        sh(str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void qh(String str, View view) {
        String obj = this.f41319b.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            uh(obj, str);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rh(String str, String str2, View view) {
        Pg(str, str2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Pg(String str, String str2) {
        new DialogUtils.b.d(this).c1(getString(R.string.n_option_delivery_tip)).C0(getString(R.string.n_security_passkeys_delete_tips, new Object[]{str2})).P0(getString(R.string.n_confirm)).s0(getString(R.string.n_cancel)).Q0(new n1(this, str)).N0(o1.f41777a).k0().show(getSupportFragmentManager(), "");
    }

    public final void Qg(Map<String, Object> map) {
        o9.a.a().e(map).b().compose(RxJavaHelper.t((g) null)).subscribe(new d());
    }

    public int getContentView() {
        return R.layout.activity_security_passkey_edit;
    }

    public void initView() {
        super.initView();
        this.f41320c = new Security2FADialogHelper(this, this, "PASS_KEY_DELETE");
        String stringExtra = getIntent().getStringExtra("id");
        String stringExtra2 = getIntent().getStringExtra("remark");
        EditText editText = (EditText) findViewById(R.id.et_passkey_edit);
        this.f41319b = editText;
        editText.setText(stringExtra2);
        findViewById(R.id.btn_passkey_edit_save).setOnClickListener(new l1(this, stringExtra));
        findViewById(R.id.btn_passkey_edit_delete).setOnClickListener(new m1(this, stringExtra, stringExtra2));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void sh(String str) {
        showProgressDialog();
        o9.a.a().passkeyVerify().b().compose(RxJavaHelper.t((g) null)).subscribe(new b(str));
    }

    public final void th(String str) {
        this.f41320c.R(new c(str));
    }

    public final void uh(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("pass_key_id", str2);
        hashMap.put("remark", str);
        o9.a.a().f(hashMap).b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }
}
