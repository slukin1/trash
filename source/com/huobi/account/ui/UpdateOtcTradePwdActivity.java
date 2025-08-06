package com.huobi.account.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.account.presenter.UpdateOtcTradePwdPresenter;
import com.huobi.otc.ui.BaseDragActivity;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Map;
import pro.huobi.R;

@Route(path = "/securityCenter/setFundPassword")
public class UpdateOtcTradePwdActivity extends BaseDragActivity<UpdateOtcTradePwdPresenter, UpdateOtcTradePwdPresenter.a> implements UpdateOtcTradePwdPresenter.a {

    /* renamed from: d  reason: collision with root package name */
    public HbTitleBar f41601d;

    /* renamed from: e  reason: collision with root package name */
    public ClearEditText f41602e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f41603f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41604g;

    /* renamed from: h  reason: collision with root package name */
    public ClearEditText f41605h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f41606i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41607j;

    /* renamed from: k  reason: collision with root package name */
    public Button f41608k;

    /* renamed from: l  reason: collision with root package name */
    public View f41609l;

    /* renamed from: m  reason: collision with root package name */
    public View f41610m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f41611n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f41612o;

    /* renamed from: p  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f41613p;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            UpdateOtcTradePwdActivity.this.Hh();
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
            UpdateOtcTradePwdActivity.this.f41602e.onFocusChange(view, z11);
            if (z11) {
                UpdateOtcTradePwdActivity.this.f41609l.setBackgroundColor(UpdateOtcTradePwdActivity.this.getResources().getColor(R.color.global_jump_btn_color));
                return;
            }
            UpdateOtcTradePwdActivity.this.f41609l.setBackgroundColor(UpdateOtcTradePwdActivity.this.getResources().getColor(R.color.global_divider_color));
            boolean unused = UpdateOtcTradePwdActivity.this.Jh();
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            UpdateOtcTradePwdActivity.this.Hh();
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
            UpdateOtcTradePwdActivity.this.f41605h.onFocusChange(view, z11);
            if (z11) {
                UpdateOtcTradePwdActivity.this.f41610m.setBackgroundColor(UpdateOtcTradePwdActivity.this.getResources().getColor(R.color.global_jump_btn_color));
                return;
            }
            UpdateOtcTradePwdActivity.this.f41610m.setBackgroundColor(UpdateOtcTradePwdActivity.this.getResources().getColor(R.color.global_divider_color));
            boolean unused = UpdateOtcTradePwdActivity.this.Ih();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (UpdateOtcTradePwdActivity.this.f41612o) {
                UpdateOtcTradePwdActivity.this.f41606i.setImageResource(R.drawable.icon_eye_close);
                boolean unused = UpdateOtcTradePwdActivity.this.f41612o = false;
                UpdateOtcTradePwdActivity.this.f41605h.setTransformationMethod(PasswordTransformationMethod.getInstance());
                UpdateOtcTradePwdActivity.this.f41605h.setSelection(UpdateOtcTradePwdActivity.this.f41605h.getText().toString().length());
            } else {
                UpdateOtcTradePwdActivity.this.f41606i.setImageResource(R.drawable.icon_eye_open);
                boolean unused2 = UpdateOtcTradePwdActivity.this.f41612o = true;
                UpdateOtcTradePwdActivity.this.f41605h.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                UpdateOtcTradePwdActivity.this.f41605h.setSelection(UpdateOtcTradePwdActivity.this.f41605h.getText().toString().length());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class f extends SecurityStrategyController {
        public f() {
        }

        public boolean C() {
            return ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).g0();
        }

        public void i(String str, String str2, String str3, String str4) {
            ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).q0(str, str2, str3);
        }

        public String n() {
            return ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).X();
        }

        public String o() {
            return ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).Y();
        }

        public Map<String, Object> p() {
            return ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).Z();
        }

        public Map<String, Object> s() {
            return ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).b0();
        }

        public boolean x() {
            return ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).d0();
        }

        public boolean y() {
            return ((UpdateOtcTradePwdPresenter) UpdateOtcTradePwdActivity.this.getPresenter()).f0();
        }

        public boolean z() {
            return false;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        if (this.f41611n) {
            this.f41603f.setImageResource(R.drawable.icon_eye_close);
            this.f41611n = false;
            this.f41602e.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ClearEditText clearEditText = this.f41602e;
            clearEditText.setSelection(clearEditText.getText().toString().length());
        } else {
            this.f41603f.setImageResource(R.drawable.icon_eye_open);
            this.f41611n = true;
            this.f41602e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ClearEditText clearEditText2 = this.f41602e;
            clearEditText2.setSelection(clearEditText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (Jh() && Ih()) {
            ((UpdateOtcTradePwdPresenter) getPresenter()).a0();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        doFinish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Hh() {
        if (TextUtils.isEmpty(this.f41602e.getText().toString()) || TextUtils.isEmpty(this.f41605h.getText().toString()) || !StringUtils.s(this.f41602e.getText().toString())) {
            this.f41608k.setEnabled(false);
        } else {
            this.f41608k.setEnabled(true);
        }
    }

    public final boolean Ih() {
        String obj = this.f41605h.getText().toString();
        if (TextUtils.isEmpty(obj.toString())) {
            this.f41607j.setVisibility(0);
            return false;
        } else if (this.f41602e.getText().toString().equals(obj)) {
            this.f41607j.setVisibility(8);
            return true;
        } else {
            this.f41607j.setVisibility(0);
            return false;
        }
    }

    public final boolean Jh() {
        String obj = this.f41602e.getText().toString();
        if (obj.length() < 8 || obj.length() > 32 || !StringUtils.s(obj)) {
            this.f41604g.setVisibility(0);
            return false;
        }
        this.f41604g.setVisibility(8);
        return true;
    }

    /* renamed from: Kh */
    public UpdateOtcTradePwdPresenter createPresenter() {
        return new UpdateOtcTradePwdPresenter();
    }

    /* renamed from: Lh */
    public UpdateOtcTradePwdPresenter.a getUI() {
        return this;
    }

    public void P0() {
        this.f41613p.Ci(new f());
        this.f41613p.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public void P1() {
        if (this.f41613p.isVisible()) {
            this.f41613p.dismiss();
        }
    }

    public String R0() {
        return null;
    }

    public String Xf() {
        return "passHome";
    }

    public void addEvent() {
        this.f41602e.addTextChangedListener(new a());
        this.f41602e.setOnFocusChangeListener(new b());
        this.f41605h.addTextChangedListener(new c());
        this.f41605h.setOnFocusChangeListener(new d());
        this.f41603f.setOnClickListener(new c6(this));
        this.f41606i.setOnClickListener(new e());
        this.f41608k.setOnClickListener(new b6(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.activity_update_otc_trade_pwd;
    }

    public void initView() {
        super.initView();
        this.f41601d = (HbTitleBar) this.viewFinder.b(R.id.hb_title_bar_otc_trade_pwd);
        this.f41602e = (ClearEditText) this.viewFinder.b(R.id.otc_new_trade_password_et);
        this.f41603f = (ImageView) this.viewFinder.b(R.id.otc_trade_password_show_iv);
        this.f41604g = (TextView) this.viewFinder.b(R.id.password_error_tv);
        this.f41605h = (ClearEditText) this.viewFinder.b(R.id.otc_new_trade_password_confirm_et);
        this.f41606i = (ImageView) this.viewFinder.b(R.id.otc_trade_password_confirm_show_iv);
        this.f41607j = (TextView) this.viewFinder.b(R.id.confirm_password_error_tv);
        this.f41608k = (Button) this.viewFinder.b(R.id.otc_new_trade_pwd_btn);
        this.f41609l = this.viewFinder.b(R.id.otc_password_divider_line);
        this.f41610m = this.viewFinder.b(R.id.otc_password_confirm_divider_line);
        this.f41613p = new SecurityStrategyBottomMenuFragment();
        ViewUtil.d(this.f41602e);
        this.f41601d.setTitle(getString(R.string.n_otc_new_security_center_modification_pass));
        this.f41601d.setOnClickBackListener(new d6(this));
    }

    public void m3() {
    }

    public String s5() {
        return this.f41602e.getText().toString();
    }
}
