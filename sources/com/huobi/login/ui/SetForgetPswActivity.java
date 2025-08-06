package com.huobi.login.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.ProgressButton;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.login.presenter.SetForgetPswPresenter;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pn.k;
import pn.l;
import pn.m;
import pn.n;
import pn.o;
import pro.huobi.R;

public class SetForgetPswActivity extends BaseActivity<SetForgetPswPresenter, SetForgetPswPresenter.b> implements SetForgetPswPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public ClearEditText f75587b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f75588c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressButton f75589d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f75590e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f75591f;

    /* renamed from: g  reason: collision with root package name */
    public String f75592g;

    /* renamed from: h  reason: collision with root package name */
    public String f75593h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f75594i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f75595j;

    /* renamed from: k  reason: collision with root package name */
    public Toolbar f75596k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f75597l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f75598m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f75599n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f75600o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f75601p;

    /* renamed from: q  reason: collision with root package name */
    public View f75602q;

    /* renamed from: r  reason: collision with root package name */
    public View f75603r;

    /* renamed from: s  reason: collision with root package name */
    public String f75604s;

    /* renamed from: t  reason: collision with root package name */
    public String f75605t;

    /* renamed from: u  reason: collision with root package name */
    public int f75606u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f75607v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f75608w = false;

    /* renamed from: x  reason: collision with root package name */
    public RelativeLayout f75609x;

    /* renamed from: y  reason: collision with root package name */
    public RelativeLayout f75610y;

    /* access modifiers changed from: private */
    public /* synthetic */ void Qg(CharSequence charSequence, int i11, int i12, int i13) {
        qh(charSequence.toString(), i12);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (this.f75594i) {
            this.f75590e.setImageResource(R.drawable.icon_eye_close);
            this.f75594i = false;
            this.f75587b.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            this.f75590e.setImageResource(R.drawable.icon_eye_open);
            this.f75594i = true;
            this.f75587b.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        ClearEditText clearEditText = this.f75587b;
        clearEditText.setSelection(clearEditText.getText().toString().length());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (this.f75595j) {
            this.f75591f.setImageResource(R.drawable.icon_eye_close);
            this.f75595j = false;
            this.f75588c.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            this.f75591f.setImageResource(R.drawable.icon_eye_open);
            this.f75595j = true;
            this.f75588c.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        ClearEditText clearEditText = this.f75588c;
        clearEditText.setSelection(clearEditText.getText().toString().length());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (TextUtils.isEmpty(this.f75592g)) {
            this.f75598m.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75599n.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75600o.setImageResource(R.drawable.password_check_failed);
            this.f75601p.setImageResource(R.drawable.password_check_failed);
            this.f75609x.setBackgroundResource(R.drawable.login_input_error_bg);
            this.f75607v = false;
        }
        if (!TextUtils.equals(this.f75592g, this.f75593h)) {
            this.f75597l.setVisibility(0);
            this.f75610y.setBackgroundResource(R.drawable.login_input_error_bg);
            this.f75608w = false;
        }
        if (!this.f75607v || !this.f75608w) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f75589d.c();
        ((SetForgetPswPresenter) getPresenter()).n0(this.f75588c.getText().toString());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh(CharSequence charSequence, int i11, int i12, int i13) {
        ph(charSequence.toString());
    }

    public void G0() {
        this.f75589d.a();
    }

    public LoginSuccBean J9() {
        LoginSuccBean loginSuccBean = new LoginSuccBean();
        boolean z11 = true;
        if (this.f75606u != 1) {
            z11 = false;
        }
        loginSuccBean.f(z11);
        loginSuccBean.d(this.f75605t);
        loginSuccBean.e(this.f75604s);
        return loginSuccBean;
    }

    /* renamed from: Og */
    public SetForgetPswPresenter createPresenter() {
        return new SetForgetPswPresenter();
    }

    /* renamed from: Pg */
    public SetForgetPswPresenter.b getUI() {
        return this;
    }

    public void addEvent() {
        this.f75587b.setOnTextChangedListener(new n(this));
        this.f75588c.setOnTextChangedListener(new o(this));
        this.f75590e.setOnClickListener(new l(this));
        this.f75591f.setOnClickListener(new m(this));
        this.f75589d.setOnClickListener(new k(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public int getContentView() {
        return R.layout.set_forget_psw_activity;
    }

    public void initExtra() {
        super.initExtra();
        Intent intent = getIntent();
        if (intent != null) {
            this.f75604s = intent.getStringExtra("country_id");
            this.f75605t = intent.getStringExtra("country_code");
            this.f75606u = intent.getIntExtra("login_type", 0);
        }
    }

    public void initView() {
        this.f75596k = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f75588c = (ClearEditText) this.viewFinder.b(R.id.set_psw_edit_again);
        this.f75587b = (ClearEditText) this.viewFinder.b(R.id.set_psw_edit);
        this.f75589d = (ProgressButton) this.viewFinder.b(R.id.set_psw_btn);
        this.f75590e = (ImageView) this.viewFinder.b(R.id.set_psw_img);
        this.f75591f = (ImageView) this.viewFinder.b(R.id.set_psw_img_again);
        this.f75597l = (TextView) this.viewFinder.b(R.id.set_psw_tips_bottom);
        this.f75598m = (TextView) this.viewFinder.b(R.id.set_psw_top_tips1);
        this.f75599n = (TextView) this.viewFinder.b(R.id.set_psw_top_tips2);
        this.f75600o = (ImageView) this.viewFinder.b(R.id.tips1Icon);
        this.f75601p = (ImageView) this.viewFinder.b(R.id.tips2Icon);
        this.f75602q = this.viewFinder.b(R.id.divider);
        this.f75603r = this.viewFinder.b(R.id.divider_again);
        this.f75609x = (RelativeLayout) this.viewFinder.b(R.id.pswLayout);
        this.f75610y = (RelativeLayout) this.viewFinder.b(R.id.pswAgainLayout);
        setToolBar(this.f75596k, "", true);
        ViewUtil.d(this.f75587b);
        ViewUtil.d(this.f75588c);
    }

    public final void ph(String str) {
        this.f75593h = str;
        if (TextUtils.isEmpty(str)) {
            this.f75597l.setVisibility(8);
            this.f75610y.setBackgroundResource(R.drawable.login_input_bg);
            this.f75608w = false;
        } else if (TextUtils.isEmpty(this.f75592g)) {
            this.f75608w = false;
        } else if (StringUtils.a(this.f75592g, this.f75593h) == 0) {
            this.f75597l.setVisibility(8);
            this.f75610y.setBackgroundResource(R.drawable.login_input_bg);
            this.f75608w = true;
        } else {
            this.f75597l.setVisibility(0);
            this.f75610y.setBackgroundResource(R.drawable.login_input_error_bg);
            this.f75608w = false;
        }
        if (str.length() > 0) {
            this.f75603r.setVisibility(0);
        } else {
            this.f75603r.setVisibility(4);
        }
    }

    public final void qh(String str, int i11) {
        this.f75592g = str;
        if (!TextUtils.isEmpty(this.f75593h)) {
            if (StringUtils.a(str, this.f75593h) == 0) {
                this.f75597l.setVisibility(8);
                this.f75610y.setBackgroundResource(R.drawable.login_input_bg);
                this.f75608w = true;
            } else {
                this.f75597l.setVisibility(0);
                this.f75610y.setBackgroundResource(R.drawable.login_input_error_bg);
                this.f75608w = false;
            }
        }
        int k11 = StringUtils.k(str);
        if (TextUtils.isEmpty(str) && i11 == 0) {
            this.f75607v = false;
            this.f75598m.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75599n.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75600o.setImageResource(R.drawable.password_check_failed);
            this.f75601p.setImageResource(R.drawable.password_check_failed);
            this.f75609x.setBackgroundResource(R.drawable.login_input_error_bg);
        } else if (TextUtils.isEmpty(str)) {
            this.f75607v = false;
            this.f75598m.setTextColor(getResources().getColor(R.color.baseColorThreeLevelText));
            this.f75599n.setTextColor(getResources().getColor(R.color.baseColorThreeLevelText));
            this.f75600o.setImageResource(R.drawable.password_check_normal);
            this.f75601p.setImageResource(R.drawable.password_check_normal);
            this.f75609x.setBackgroundResource(R.drawable.login_input_bg);
        } else if (k11 == 0) {
            this.f75607v = false;
            this.f75598m.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75599n.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75600o.setImageResource(R.drawable.password_check_failed);
            this.f75601p.setImageResource(R.drawable.password_check_failed);
            this.f75609x.setBackgroundResource(R.drawable.login_input_error_bg);
        } else if (k11 == 1) {
            this.f75607v = false;
            this.f75598m.setTextColor(getResources().getColor(R.color.base_up_color));
            this.f75599n.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75600o.setImageResource(R.drawable.password_check_pass);
            this.f75601p.setImageResource(R.drawable.password_check_failed);
            this.f75609x.setBackgroundResource(R.drawable.login_input_error_bg);
        } else {
            this.f75607v = true;
            this.f75598m.setTextColor(getResources().getColor(R.color.base_up_color));
            this.f75599n.setTextColor(getResources().getColor(R.color.base_up_color));
            this.f75600o.setImageResource(R.drawable.password_check_pass);
            this.f75601p.setImageResource(R.drawable.password_check_pass);
            this.f75609x.setBackgroundResource(R.drawable.login_input_bg);
        }
        if (str.length() > 0) {
            this.f75602q.setVisibility(0);
        } else {
            this.f75602q.setVisibility(4);
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
