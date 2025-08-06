package com.hbg.lite.trade.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.ProgressButton;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lite.R$color;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.trade.presenter.LiteOtcTradeSettingPwsdPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class LiteOtcTradeSettingActivity extends BaseActivity<LiteOtcTradeSettingPwsdPresenter, LiteOtcTradeSettingPwsdPresenter.a> implements LiteOtcTradeSettingPwsdPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public ClearEditText f77507b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f77508c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77509d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77510e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f77511f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f77512g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressButton f77513h;

    /* renamed from: i  reason: collision with root package name */
    public View f77514i;

    /* renamed from: j  reason: collision with root package name */
    public View f77515j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f77516k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f77517l;

    /* renamed from: m  reason: collision with root package name */
    public Toolbar f77518m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f77519n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f77520o = true;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            LiteOtcTradeSettingActivity.this.sh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z11) {
            LiteOtcTradeSettingActivity.this.f77507b.onFocusChange(view, z11);
            if (z11) {
                LiteOtcTradeSettingActivity.this.f77514i.setBackgroundColor(LiteOtcTradeSettingActivity.this.getResources().getColor(R$color.global_jump_btn_color));
                return;
            }
            LiteOtcTradeSettingActivity.this.f77514i.setBackgroundColor(LiteOtcTradeSettingActivity.this.getResources().getColor(R$color.global_divider_color));
            boolean unused = LiteOtcTradeSettingActivity.this.uh();
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            LiteOtcTradeSettingActivity.this.sh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z11) {
            LiteOtcTradeSettingActivity.this.f77508c.onFocusChange(view, z11);
            if (z11) {
                LiteOtcTradeSettingActivity.this.f77515j.setBackgroundColor(LiteOtcTradeSettingActivity.this.getResources().getColor(R$color.global_jump_btn_color));
                return;
            }
            LiteOtcTradeSettingActivity.this.f77515j.setBackgroundColor(LiteOtcTradeSettingActivity.this.getResources().getColor(R$color.global_divider_color));
            boolean unused = LiteOtcTradeSettingActivity.this.th();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (LiteOtcTradeSettingActivity.this.f77517l) {
                LiteOtcTradeSettingActivity.this.f77512g.setImageResource(R$drawable.icon_eye_close);
                boolean unused = LiteOtcTradeSettingActivity.this.f77517l = false;
                LiteOtcTradeSettingActivity.this.f77508c.setTransformationMethod(PasswordTransformationMethod.getInstance());
                LiteOtcTradeSettingActivity.this.f77508c.setSelection(LiteOtcTradeSettingActivity.this.f77508c.getText().toString().length());
            } else {
                LiteOtcTradeSettingActivity.this.f77512g.setImageResource(R$drawable.icon_eye_open);
                boolean unused2 = LiteOtcTradeSettingActivity.this.f77517l = true;
                LiteOtcTradeSettingActivity.this.f77508c.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                LiteOtcTradeSettingActivity.this.f77508c.setSelection(LiteOtcTradeSettingActivity.this.f77508c.getText().toString().length());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if ((uh() && th()) && this.f77520o) {
            ((LiteOtcTradeSettingPwsdPresenter) getPresenter()).c0(MD5Utils.d(this.f77507b.getText().toString()).toLowerCase(), MD5Utils.c(this.f77507b.getText().toString()).toLowerCase());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        if (this.f77516k) {
            this.f77511f.setImageResource(R$drawable.icon_eye_close);
            this.f77516k = false;
            this.f77507b.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ClearEditText clearEditText = this.f77507b;
            clearEditText.setSelection(clearEditText.getText().toString().length());
        } else {
            this.f77511f.setImageResource(R$drawable.icon_eye_open);
            this.f77516k = true;
            this.f77507b.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ClearEditText clearEditText2 = this.f77507b;
            clearEditText2.setSelection(clearEditText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.f77507b.addTextChangedListener(new a());
        this.f77507b.setOnFocusChangeListener(new b());
        this.f77508c.addTextChangedListener(new c());
        this.f77508c.setOnFocusChangeListener(new d());
        this.f77511f.setOnClickListener(new qb.b(this));
        this.f77512g.setOnClickListener(new e());
        this.f77513h.setOnClickListener(new qb.a(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R$layout.activity_lite_otc_trade_setting;
    }

    public void initView() {
        this.f77518m = (Toolbar) this.viewFinder.b(R$id.toolbar);
        this.f77507b = (ClearEditText) this.viewFinder.b(R$id.otc_trade_password_et);
        this.f77508c = (ClearEditText) this.viewFinder.b(R$id.otc_trade_password_confirm_et);
        this.f77509d = (TextView) this.viewFinder.b(R$id.password_error_tv);
        this.f77510e = (TextView) this.viewFinder.b(R$id.confirm_password_error_tv);
        this.f77511f = (ImageView) this.viewFinder.b(R$id.otc_trade_password_show_iv);
        this.f77512g = (ImageView) this.viewFinder.b(R$id.otc_trade_password_confirm_show_iv);
        this.f77513h = (ProgressButton) this.viewFinder.b(R$id.otc_trade_setting_btn);
        this.f77514i = this.viewFinder.b(R$id.otc_password_divider_line);
        this.f77515j = this.viewFinder.b(R$id.otc_password_confirm_divider_line);
        setToolBar(this.f77518m, "", true);
        this.f77513h.setText(getString(R$string.otc_trade_setting_btn_text));
        ViewUtil.d(this.f77507b);
    }

    public final void sh() {
        if (TextUtils.isEmpty(this.f77507b.getText().toString()) || TextUtils.isEmpty(this.f77508c.getText().toString()) || !StringUtils.s(this.f77507b.getText().toString())) {
            this.f77513h.setEnabled(false);
        } else {
            this.f77513h.setEnabled(true);
        }
    }

    public final boolean th() {
        String obj = this.f77508c.getText().toString();
        if (TextUtils.isEmpty(this.f77507b.getText().toString())) {
            return false;
        }
        if (this.f77507b.getText().toString().equals(obj)) {
            this.f77510e.setVisibility(8);
            return true;
        }
        this.f77510e.setVisibility(0);
        return false;
    }

    public final boolean uh() {
        String obj = this.f77507b.getText().toString();
        if (obj.length() < 8 || obj.length() > 32 || !StringUtils.s(obj)) {
            this.f77509d.setVisibility(0);
            return false;
        }
        this.f77509d.setVisibility(8);
        return true;
    }

    /* renamed from: vh */
    public LiteOtcTradeSettingPwsdPresenter createPresenter() {
        return new LiteOtcTradeSettingPwsdPresenter();
    }

    /* renamed from: wh */
    public LiteOtcTradeSettingPwsdPresenter.a getUI() {
        return this;
    }
}
