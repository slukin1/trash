package com.huobi.login.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.biometric.BiometricPrompt;
import androidx.core.os.CancellationSignal;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.presenter.FingerprintPresenter;
import com.huobi.login.utils.FingerprintHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.i;
import i6.k;
import java.util.HashMap;
import pn.d;
import pn.e;
import pro.huobi.R;

public class FingerprintLoginActivity extends BaseActivity<FingerprintPresenter, FingerprintPresenter.b> implements FingerprintPresenter.b, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f75560b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75561c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75562d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f75563e = false;

    /* renamed from: f  reason: collision with root package name */
    public FingerprintHelper f75564f;

    /* renamed from: g  reason: collision with root package name */
    public long f75565g;

    /* renamed from: h  reason: collision with root package name */
    public String f75566h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f75567i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f75568j;

    public class a extends BiometricPrompt.AuthenticationCallback {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e() {
            FingerprintLoginActivity.this.finish();
        }

        public void a(int i11, CharSequence charSequence) {
            k.f("UNLOCK", "onAuthenticationError " + i11);
            if (i11 == 7) {
                HuobiToastUtil.k(FingerprintLoginActivity.this, R.string.n_login_unlock_much_times);
                FingerprintLoginActivity.this.qh();
            } else if (i11 != 5) {
                long unused = FingerprintLoginActivity.this.f75565g = System.currentTimeMillis();
                HuobiToastUtil.k(FingerprintLoginActivity.this, R.string.n_login_finger_fail);
                FingerprintLoginActivity.this.qh();
            }
        }

        public void b() {
            k.f("UNLOCK", "onAuthenticationFailed");
            HashMap hashMap = new HashMap();
            hashMap.put("unlock_type", "Finger");
            hashMap.put("is_success", Boolean.FALSE);
            g.i("unlock_result", hashMap);
            HuobiToastUtil.k(FingerprintLoginActivity.this, R.string.n_login_finger_fail);
        }

        public void c(BiometricPrompt.a aVar) {
            k.f("UNLOCK", "onAuthenticationSucceeded");
            HashMap hashMap = new HashMap();
            hashMap.put("unlock_type", "Finger");
            hashMap.put("is_success", Boolean.TRUE);
            g.i("unlock_result", hashMap);
            if (FingerprintLoginActivity.this.f75568j) {
                FingerprintLoginActivity.this.setResult(-1);
                i.b().g(new e(this), 200);
            } else {
                ((FingerprintPresenter) FingerprintLoginActivity.this.getPresenter()).b0();
            }
            if (FingerprintLoginActivity.this.f75564f != null) {
                FingerprintLoginActivity.this.f75564f.j();
            }
        }
    }

    public class b implements CancellationSignal.b {
        public b() {
        }

        public void onCancel() {
            k.f("UNLOCK", "onCancel");
            FingerprintLoginActivity.this.qh();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f75568j) {
            finish();
        } else {
            onBackPressed();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Pg */
    public FingerprintPresenter createPresenter() {
        return new FingerprintPresenter();
    }

    /* renamed from: Qg */
    public FingerprintPresenter.b getUI() {
        return this;
    }

    public void addEvent() {
        this.f75560b.setOnClickListener(this);
        this.f75561c.setOnClickListener(this);
        String e11 = ConfigPreferences.e("user_config", "config_email", "");
        this.f75566h = e11;
        if (!TextUtils.isEmpty(e11)) {
            TextView textView = this.f75562d;
            textView.setText(getResources().getString(R.string.login_finger_hello) + StringUtils.u(this.f75566h));
        }
        h6();
        this.f75567i.setOnClickListener(new d(this));
    }

    public void ga() {
        FingerprintHelper fingerprintHelper = this.f75564f;
        if (fingerprintHelper != null) {
            fingerprintHelper.j();
            this.f75564f = null;
        }
    }

    public int getContentView() {
        return R.layout.activity_user_login_fingerprint;
    }

    public void h6() {
        FingerprintHelper fingerprintHelper = this.f75564f;
        if (fingerprintHelper != null) {
            fingerprintHelper.h(this, new a());
            this.f75564f.g(new b());
        }
    }

    public void initExtra() {
        this.f75568j = getIntent().getBooleanExtra("verifyOnly", false);
    }

    public void initView() {
        this.f75560b = (LinearLayout) this.viewFinder.b(R.id.fingerprint_area);
        this.f75561c = (TextView) this.viewFinder.b(R.id.fingerprint_change);
        this.f75562d = (TextView) this.viewFinder.b(R.id.fingerprint_top_name);
        this.f75567i = (TextView) this.viewFinder.b(R.id.login_cancel_text);
        oh();
        ph();
        g.i("unlock_finger", (HashMap) null);
        this.f75561c.setVisibility(this.f75568j ? 8 : 0);
    }

    public void oh() {
        FingerprintHelper fingerprintHelper = this.f75564f;
        if (fingerprintHelper != null) {
            fingerprintHelper.j();
            this.f75564f = null;
        }
        this.f75564f = new FingerprintHelper();
    }

    public void onBackPressed() {
        super.onBackPressed();
        FingerprintHelper fingerprintHelper = this.f75564f;
        if (fingerprintHelper != null) {
            fingerprintHelper.j();
            this.f75564f = null;
        }
        if (!this.f75568j) {
            ((FingerprintPresenter) getPresenter()).a0();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fingerprint_area:
                oh();
                ph();
                h6();
                break;
            case R.id.fingerprint_change:
                FingerprintHelper fingerprintHelper = this.f75564f;
                if (fingerprintHelper != null) {
                    fingerprintHelper.j();
                }
                ((FingerprintPresenter) getPresenter()).d0(this.f75566h);
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroy() {
        super.onDestroy();
        ga();
    }

    public void ph() {
    }

    public final void qh() {
        FingerprintHelper fingerprintHelper = this.f75564f;
        if (fingerprintHelper != null) {
            fingerprintHelper.j();
        }
    }
}
