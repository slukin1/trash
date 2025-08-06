package com.huobi.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.presenter.SecurityLinkStep2Presenter;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.view.PasswordView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;
import tg.r;

public class SecurityLinkStep2Activity extends BaseActivity<SecurityLinkStep2Presenter, SecurityLinkStep2Presenter.e> implements SecurityLinkStep2Presenter.e {

    /* renamed from: b  reason: collision with root package name */
    public Security2FADialogHelper f41290b;

    /* renamed from: c  reason: collision with root package name */
    public SecurityLinkStep2Presenter f41291c;

    /* renamed from: d  reason: collision with root package name */
    public int f41292d;

    /* renamed from: e  reason: collision with root package name */
    public String f41293e;

    /* renamed from: f  reason: collision with root package name */
    public String f41294f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41295g;

    /* renamed from: h  reason: collision with root package name */
    public PasswordView f41296h;

    /* renamed from: i  reason: collision with root package name */
    public String f41297i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41298j;

    /* renamed from: k  reason: collision with root package name */
    public String f41299k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f41300l;

    public class a implements PasswordView.PasswordListener {
        public a() {
        }

        public void keyEnterPress(String str, boolean z11) {
        }

        public void passwordChange(String str) {
        }

        public void passwordComplete(String str) {
            SecurityLinkStep2Activity.this.f41291c.s0(str);
        }
    }

    public class b implements PasswordView.PasswordListener {
        public b() {
        }

        public void keyEnterPress(String str, boolean z11) {
        }

        public void passwordChange(String str) {
        }

        public void passwordComplete(String str) {
            SecurityLinkStep2Activity.this.f41291c.q0(str);
        }
    }

    public class c implements PasswordView.PasswordListener {
        public c() {
        }

        public void keyEnterPress(String str, boolean z11) {
        }

        public void passwordChange(String str) {
        }

        public void passwordComplete(String str) {
            if (SecurityLinkStep2Activity.this.f41292d == 4) {
                SecurityLinkStep2Activity.this.f41291c.p0(str);
            } else {
                SecurityLinkStep2Activity.this.f41291c.r0(str);
            }
        }
    }

    public class d extends Security2FADialogHelper.Callback {
        public d() {
        }

        public void onFailed(String str) {
            SecurityLinkStep2Activity.this.f41290b.v();
            SecurityLinkStep2Activity securityLinkStep2Activity = SecurityLinkStep2Activity.this;
            securityLinkStep2Activity.Qd(securityLinkStep2Activity.f41292d);
        }

        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
            super.onSuccess(authResult);
            SecurityLinkStep2Activity.this.f41290b.v();
            if (SecurityLinkStep2Activity.this.f41292d == 2) {
                SecurityLinkStep2Activity.this.f41291c.t0(authResult.getSmsCode(), authResult.getGaCode(), authResult.passkey);
            } else if (SecurityLinkStep2Activity.this.f41292d == 3) {
                SecurityLinkStep2Activity.this.f41291c.u0(authResult.getEmailCode(), authResult.getSmsCode(), authResult.passkey);
            } else if (SecurityLinkStep2Activity.this.f41292d == 1) {
                SecurityLinkStep2Activity.this.f41291c.v0(authResult.getEmailCode(), authResult.getGaCode(), authResult.passkey);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        this.f41291c.T0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th() {
        PasswordView passwordView = this.f41296h;
        if (passwordView != null && passwordView.getContext() != null) {
            ((InputMethodManager) this.f41296h.getContext().getSystemService("input_method")).showSoftInput(this.f41296h, 0);
        }
    }

    public void Ba() {
        this.f41296h.clearPassword();
    }

    public void H(boolean z11, String str) {
        int i11;
        this.f41295g.setEnabled(z11);
        TextView textView = this.f41295g;
        if (z11) {
            i11 = getResources().getColor(R.color.security_copy_link);
        } else {
            i11 = getResources().getColor(R.color.baseColorSecondaryText);
        }
        textView.setTextColor(i11);
        if (!TextUtils.isEmpty(str)) {
            this.f41295g.setText(str);
        }
    }

    /* renamed from: Og */
    public SecurityLinkStep2Presenter createPresenter() {
        SecurityLinkStep2Presenter securityLinkStep2Presenter = new SecurityLinkStep2Presenter();
        this.f41291c = securityLinkStep2Presenter;
        securityLinkStep2Presenter.Z0(this.f41292d);
        this.f41291c.Y0(this.f41293e, this.f41294f);
        Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(this, this, Qg());
        this.f41290b = security2FADialogHelper;
        security2FADialogHelper.N(false);
        this.f41290b.M(true);
        return this.f41291c;
    }

    public void P0() {
        this.f41290b.R(new d());
    }

    /* renamed from: Pg */
    public SecurityLinkStep2Presenter.e getUI() {
        return this;
    }

    public void Qd(int i11) {
    }

    public final String Qg() {
        int i11 = this.f41292d;
        if (i11 == 2) {
            return "VERIFY_SETTING_POLICY_BIND_EMAIL";
        }
        return (i11 != 3 && i11 == 1) ? "VERIFY_SETTING_POLICY_BIND_PHONE" : "VERIFY_SETTING_POLICY_BIND_GA";
    }

    public void addEvent() {
        this.f41295g.setOnClickListener(new g1(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public void doFinish() {
        super.doFinish();
        if (this.f41292d == 3) {
            g.i("app_get_GA_code_back_click", (HashMap) null);
        }
    }

    public int getContentView() {
        return R.layout.activity_securyity_link_step2;
    }

    public void initView() {
        this.f41292d = getIntent().getIntExtra("LINK_TYPE_KEY", -1);
        this.f41293e = getIntent().getStringExtra("BIND_PHONE_KEY");
        this.f41294f = getIntent().getStringExtra("BIND_EMAIL_KEY");
        this.f41299k = getIntent().getStringExtra("otc_bind_phone_action");
        this.f41300l = getIntent().getBooleanExtra("from_otc_trade_set", false);
        this.f41295g = (TextView) this.viewFinder.b(R.id.tv_send);
        this.f41296h = (PasswordView) this.viewFinder.b(R.id.verify_code_edit);
        this.f41298j = (TextView) this.viewFinder.b(R.id.tv_email_tips);
        int i11 = this.f41292d;
        if (i11 == 2) {
            this.f41297i = getString(R.string.title_code, new Object[]{getString(R.string.security_email_title)});
            this.f41298j.setVisibility(0);
            oh();
        } else if (i11 == 3 || i11 == 4) {
            this.f41297i = getString(R.string.title_ga_auth);
            ph();
        } else if (i11 == 1) {
            this.f41297i = getString(R.string.security_sms_verification);
            qh();
        }
        rh();
        this.f41296h.postDelayed(new h1(this), 50);
    }

    public final void oh() {
        this.f41296h.setPasswordListener(new b());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        if (this.f41296h != null) {
            this.f41296h = null;
        }
        super.onDestroy();
    }

    public final void ph() {
        this.f41295g.setVisibility(8);
        g.i("app_get_GA_code_view", (HashMap) null);
        this.f41296h.setPasswordListener(new c());
    }

    public final void qh() {
        this.f41296h.setPasswordListener(new a());
    }

    public final void rh() {
        setToolBar((Toolbar) this.viewFinder.b(R.id.toolbar), this.f41297i, true);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void y9(int i11) {
        SoftInputUtils.f(this);
        if (!TextUtils.isEmpty(this.f41299k) || this.f41300l) {
            HuobiToastUtil.v(getString(R.string.bind_phone_success));
            if (TextUtils.equals(this.f41299k, "lite_order_otc_bind_phone") || this.f41300l) {
                Activity f11 = oa.a.g().f(SecurityLinkActivity.class);
                if (f11 != null) {
                    f11.finish();
                }
                finish();
            }
        } else {
            startActivity(new Intent(this, SecuritySetActivity.class));
        }
        r.x().O(false);
    }
}
