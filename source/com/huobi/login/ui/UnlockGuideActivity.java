package com.huobi.login.ui;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.biometric.BiometricPrompt;
import androidx.core.os.CancellationSignal;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.GesturePwdLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.presenter.UnlockGuidePresenter;
import com.huobi.login.utils.FingerprintHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.k;
import java.util.HashMap;
import java.util.List;
import pn.p;
import pro.huobi.R;

public class UnlockGuideActivity extends BaseActivity<UnlockGuidePresenter, UnlockGuidePresenter.a> implements UnlockGuidePresenter.a, GesturePwdLayout.a {

    /* renamed from: b  reason: collision with root package name */
    public FingerprintHelper f75618b;

    /* renamed from: c  reason: collision with root package name */
    public int f75619c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f75620d;

    /* renamed from: e  reason: collision with root package name */
    public View f75621e;

    /* renamed from: f  reason: collision with root package name */
    public View f75622f;

    /* renamed from: g  reason: collision with root package name */
    public FingerprintHelper f75623g;

    /* renamed from: h  reason: collision with root package name */
    public long f75624h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f75625i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f75626j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f75627k;

    /* renamed from: l  reason: collision with root package name */
    public View f75628l;

    /* renamed from: m  reason: collision with root package name */
    public View f75629m;

    /* renamed from: n  reason: collision with root package name */
    public GesturePwdLayout f75630n;

    /* renamed from: o  reason: collision with root package name */
    public View f75631o;

    public class a extends BiometricPrompt.AuthenticationCallback {
        public a() {
        }

        public void a(int i11, CharSequence charSequence) {
            k.f("UNLOCK", "onAuthenticationError " + i11);
            if (i11 == 7) {
                HuobiToastUtil.k(UnlockGuideActivity.this, R.string.n_login_unlock_much_times);
                UnlockGuideActivity.this.th();
            } else if (i11 != 5) {
                long unused = UnlockGuideActivity.this.f75624h = System.currentTimeMillis();
                HuobiToastUtil.k(UnlockGuideActivity.this, R.string.n_login_finger_fail);
                UnlockGuideActivity.this.th();
            }
        }

        public void b() {
            k.f("UNLOCK", "onAuthenticationFailed");
            HuobiToastUtil.k(UnlockGuideActivity.this, R.string.n_login_finger_fail);
        }

        public void c(BiometricPrompt.a aVar) {
            k.f("UNLOCK", "onAuthenticationSucceeded");
            UnlockGuideActivity.this.sh();
            if (UnlockGuideActivity.this.f75623g != null) {
                UnlockGuideActivity.this.f75623g.j();
            }
        }
    }

    public class b implements CancellationSignal.b {
        public b() {
        }

        public void onCancel() {
            k.f("UNLOCK", "onCancel");
            UnlockGuideActivity.this.th();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements DialogUtils.b.f {
            public a() {
            }

            public void a(HBDialogFragment hBDialogFragment) {
                hBDialogFragment.dismiss();
                ((UnlockGuidePresenter) UnlockGuideActivity.this.getPresenter()).R();
                UnlockGuideActivity.this.finish();
            }
        }

        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            int i11;
            UnlockGuideActivity unlockGuideActivity;
            String str;
            HashMap hashMap = new HashMap();
            hashMap.put("button_name", "注册页_设置快捷登录_跳过");
            g.i("app_RegisterProcess_button_click", hashMap);
            int g11 = ConfigPreferences.g("user_config", "UNLOCK_GUIDE_TIP_TIMES", 1) + 1;
            Log.e("UNLOCK", "vCloseAction - " + g11);
            ConfigPreferences.k("user_config", "UNLOCK_GUIDE_TIP_TIMES", g11);
            if (UnlockGuideActivity.this.f75620d) {
                unlockGuideActivity = UnlockGuideActivity.this;
                i11 = R.string.security_fingerprint_unlock;
            } else {
                unlockGuideActivity = UnlockGuideActivity.this;
                i11 = R.string.n_gesture_login;
            }
            String string = unlockGuideActivity.getString(i11);
            try {
                str = UnlockGuideActivity.this.getString(R.string.n_fast_login_tip, new Object[]{string});
            } catch (Exception e11) {
                k.j("UNLOCK", e11);
                str = "";
            }
            UnlockGuideActivity unlockGuideActivity2 = UnlockGuideActivity.this;
            DialogUtils.X(unlockGuideActivity2, unlockGuideActivity2.getString(R.string.login_set_gesture_title), str, (String) null, UnlockGuideActivity.this.getString(R.string.n_known), new a());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (UnlockGuideActivity.this.f75620d) {
                HashMap hashMap = new HashMap();
                hashMap.put("button_name", "注册页_设置快捷登录_立即设置");
                g.i("app_RegisterProcess_button_click", hashMap);
                UnlockGuideActivity.this.qh();
                UnlockGuideActivity.this.h6();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh() {
        if (this.f75630n != null && !isFinishing()) {
            this.f75630n.l();
        }
    }

    public void P2() {
        this.f75630n.l();
        this.f75627k.setText(getString(R.string.n_set_gesture_login_draw_again));
    }

    /* renamed from: Qg */
    public UnlockGuidePresenter createPresenter() {
        return new UnlockGuidePresenter();
    }

    public void addEvent() {
        this.f75621e.setOnClickListener(new c());
        this.f75622f.setOnClickListener(new d());
    }

    public void finish() {
        super.finish();
        if (tg.d.g().f47851a) {
            tg.d.g().f47851a = false;
            tg.d.g().f();
        }
    }

    public int getContentView() {
        this.f75618b = new FingerprintHelper();
        return R.layout.activity_unlock_guide;
    }

    public void h6() {
        FingerprintHelper fingerprintHelper = this.f75623g;
        if (fingerprintHelper != null) {
            fingerprintHelper.h(this, new a());
            this.f75623g.g(new b());
        }
    }

    public void initView() {
        int c11 = this.f75618b.c();
        this.f75619c = c11;
        this.f75620d = c11 != 0;
        this.f75621e = findViewById(R.id.btn_guide_close);
        this.f75622f = findViewById(R.id.btn_guide_into);
        this.f75625i = (TextView) findViewById(R.id.tv_title_guide);
        this.f75626j = (TextView) findViewById(R.id.tv_top_tips);
        this.f75628l = findViewById(R.id.btn_guide_image);
        this.f75629m = findViewById(R.id.gesture_panel);
        this.f75627k = (TextView) findViewById(R.id.tv_gesture_tips);
        GesturePwdLayout gesturePwdLayout = (GesturePwdLayout) findViewById(R.id.ninepoint_setview);
        this.f75630n = gesturePwdLayout;
        gesturePwdLayout.setCallback(this);
        this.f75631o = findViewById(R.id.fingerprintLayout);
        if (this.f75620d) {
            this.f75625i.setText(getString(R.string.n_set_finger_login));
            this.f75626j.setText(getString(R.string.n_set_finger_login_tip));
            this.f75631o.setVisibility(0);
            this.f75622f.setVisibility(0);
            this.f75629m.setVisibility(8);
        } else {
            this.f75625i.setText(getString(R.string.n_set_gesture_login));
            this.f75626j.setText(getString(R.string.n_set_gesture_login_tip));
            this.f75631o.setVisibility(8);
            this.f75622f.setVisibility(8);
            this.f75629m.setVisibility(0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", this.f75620d ? "注册页_设置快捷方式_指纹" : "注册页_设置快捷方式_手势");
        g.i("App_PageView", hashMap);
    }

    public final void oh() {
        new Handler().postDelayed(new p(this), 1000);
    }

    public void onBackPressed() {
        ((UnlockGuidePresenter) getPresenter()).R();
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        FingerprintHelper fingerprintHelper = this.f75623g;
        if (fingerprintHelper != null) {
            fingerprintHelper.j();
            this.f75623g = null;
        }
    }

    /* renamed from: ph */
    public UnlockGuidePresenter.a getUI() {
        return this;
    }

    public void qh() {
        FingerprintHelper fingerprintHelper = this.f75623g;
        if (fingerprintHelper != null) {
            fingerprintHelper.j();
            this.f75623g = null;
        }
        this.f75623g = new FingerprintHelper();
    }

    public final void sh() {
        if (this.f75618b.f()) {
            HuobiToastUtil.v(getString(R.string.otc_trade_setting_success));
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 3);
            ((UnlockGuidePresenter) getPresenter()).R();
            finish();
        }
    }

    public final void th() {
        FingerprintHelper fingerprintHelper = this.f75623g;
        if (fingerprintHelper != null) {
            fingerprintHelper.j();
        }
    }

    public void y7(List<Integer> list) {
        if (list.size() < 6) {
            this.f75630n.setError(true);
            oh();
            HuobiToastUtil.m(getString(R.string.draw_gesture_need_six_dot));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Integer intValue : list) {
            sb2.append(String.valueOf(intValue.intValue() + 518));
        }
        ((UnlockGuidePresenter) getPresenter()).V(sb2.toString());
    }

    public void z2() {
        this.f75630n.setError(true);
        oh();
        HuobiToastUtil.m(getString(R.string.draw_gesture_not_same));
    }
}
