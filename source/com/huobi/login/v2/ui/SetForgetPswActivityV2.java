package com.huobi.login.v2.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.login.presenter.SetForgetPswPresenter;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.utils.StatusBarUtils;
import com.huobi.utils.StringUtilsTodo;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class SetForgetPswActivityV2 extends BaseActivity<SetForgetPswPresenter, SetForgetPswPresenter.b> implements SetForgetPswPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public ClearEditText f75836b;

    /* renamed from: c  reason: collision with root package name */
    public StatusButton f75837c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f75838d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f75839e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f75840f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f75841g;

    /* renamed from: h  reason: collision with root package name */
    public Toolbar f75842h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f75843i;

    /* renamed from: j  reason: collision with root package name */
    public View f75844j;

    /* renamed from: k  reason: collision with root package name */
    public View f75845k;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            SetForgetPswActivityV2.this.f75836b.onFocusChange(view, z11);
            SetForgetPswActivityV2.this.f75844j.setSelected(z11);
        }
    }

    public class b implements ClearEditText.b {
        public b() {
        }

        public void a(CharSequence charSequence, int i11, int i12, int i13) {
            Drawable drawable;
            CharSequence unused = SetForgetPswActivityV2.this.f75839e = charSequence;
            if (TextUtils.isEmpty(charSequence.toString()) || StringUtilsTodo.a(charSequence.toString()) <= 0) {
                SetForgetPswActivityV2.this.f75843i.setTextColor(SetForgetPswActivityV2.this.getResources().getColor(R.color.global_huobi_color));
                SetForgetPswActivityV2.this.f75843i.setText(SetForgetPswActivityV2.this.getResources().getString(R.string.n_login_register_check_failed));
                drawable = SetForgetPswActivityV2.this.getDrawable(R.drawable.password_check_failed);
            } else {
                SetForgetPswActivityV2.this.f75843i.setTextColor(SetForgetPswActivityV2.this.getResources().getColor(R.color.base_up_color));
                SetForgetPswActivityV2.this.f75843i.setText(SetForgetPswActivityV2.this.getResources().getString(R.string.n_login_register_check_pass));
                drawable = SetForgetPswActivityV2.this.getDrawable(R.drawable.password_check_pass);
            }
            drawable.setBounds(0, 0, PixelUtils.a(11.0f), PixelUtils.a(11.0f));
            SetForgetPswActivityV2.this.f75843i.setCompoundDrawablesRelative(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            if (charSequence.length() > 0) {
                SetForgetPswActivityV2.this.f75845k.setVisibility(0);
            } else {
                SetForgetPswActivityV2.this.f75845k.setVisibility(4);
            }
            SetForgetPswActivityV2.this.f75843i.setVisibility(0);
            SetForgetPswActivityV2.this.qh();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (SetForgetPswActivityV2.this.f75840f) {
                SetForgetPswActivityV2.this.f75838d.setImageResource(R.drawable.icon_eye_close);
                boolean unused = SetForgetPswActivityV2.this.f75840f = false;
                SetForgetPswActivityV2.this.f75836b.setTransformationMethod(PasswordTransformationMethod.getInstance());
                SetForgetPswActivityV2.this.f75836b.setSelection(SetForgetPswActivityV2.this.f75836b.getText().toString().length());
            } else {
                SetForgetPswActivityV2.this.f75838d.setImageResource(R.drawable.icon_eye_open);
                boolean unused2 = SetForgetPswActivityV2.this.f75840f = true;
                SetForgetPswActivityV2.this.f75836b.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                SetForgetPswActivityV2.this.f75836b.setSelection(SetForgetPswActivityV2.this.f75836b.getText().toString().length());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SetForgetPswActivityV2.this.f75837c.showAnim();
            ((SetForgetPswPresenter) SetForgetPswActivityV2.this.getPresenter()).n0(SetForgetPswActivityV2.this.f75836b.getText().toString());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public void G0() {
        this.f75837c.dismissAnim();
    }

    public LoginSuccBean J9() {
        return null;
    }

    public void addEvent() {
        this.f75836b.setOnFocusChangeListener(new a());
        this.f75836b.setOnTextChangedListener(new b());
        this.f75838d.setOnClickListener(new c());
        this.f75837c.setOnClickListener(new d());
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.set_forget_psw_activity_v2;
    }

    public void initView() {
        this.f75842h = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f75836b = (ClearEditText) this.viewFinder.b(R.id.set_psw_edit);
        this.f75837c = (StatusButton) this.viewFinder.b(R.id.set_psw_btn);
        this.f75838d = (ImageView) this.viewFinder.b(R.id.set_psw_img);
        this.f75841g = (TextView) this.viewFinder.b(R.id.set_psw_top_tips);
        this.f75843i = (TextView) this.viewFinder.b(R.id.set_psw_tips_top);
        this.f75844j = this.viewFinder.b(R.id.pswLayout);
        this.f75845k = this.viewFinder.b(R.id.divider);
        setToolBar(this.f75842h, "", true);
        ViewUtil.d(this.f75836b);
        SoftInputUtils.d(this, (ScrollView) this.viewFinder.b(R.id.scrollContent));
        this.f75837c.setEnabled(false);
        this.f75837c.setButtonText(getString(R.string.n_login_register_finish));
        this.f75837c.setBackgroundResource(R.drawable.login_v2_btn_bg);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtils.e(this, 0);
        changeStatusBarTextColor(!isLightStatusBar());
    }

    public void qh() {
        if (TextUtils.isEmpty(this.f75839e)) {
            this.f75837c.setEnabled(false);
        } else if (StringUtilsTodo.a(this.f75839e.toString()) > 0) {
            this.f75837c.setEnabled(true);
        } else {
            this.f75837c.setEnabled(false);
        }
    }

    /* renamed from: rh */
    public SetForgetPswPresenter createPresenter() {
        return new SetForgetPswPresenter();
    }

    /* renamed from: sh */
    public SetForgetPswPresenter.b getUI() {
        return this;
    }
}
