package com.huobi.login.v2.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.KeyListener;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import com.huobi.utils.SpannableUtils;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import gs.g;
import java.util.HashMap;
import java.util.Locale;
import pro.huobi.R;
import sn.f;
import tn.r;
import tn.s;
import tn.t;
import tn.u;
import tn.v;
import tn.w;
import tn.x;
import tn.y;
import tn.z;

@Route(path = "/login/password_set_v2")
public class PasswordSetActivityV2 extends BaseActivity<UserRegisterV2Presenter, UserRegisterV2Presenter.j> implements UserRegisterV2Presenter.j, View.OnClickListener {

    /* renamed from: s  reason: collision with root package name */
    public static final String f75818s = PasswordSetActivityV2.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public ClearEditText f75819b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f75820c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75821d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75822e;

    /* renamed from: f  reason: collision with root package name */
    public View f75823f;

    /* renamed from: g  reason: collision with root package name */
    public View f75824g;

    /* renamed from: h  reason: collision with root package name */
    public View f75825h;

    /* renamed from: i  reason: collision with root package name */
    public View f75826i;

    /* renamed from: j  reason: collision with root package name */
    public ScrollView f75827j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f75828k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f75829l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f75830m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f75831n;

    /* renamed from: o  reason: collision with root package name */
    public StatusButton f75832o;

    /* renamed from: p  reason: collision with root package name */
    public String f75833p = "";

    /* renamed from: q  reason: collision with root package name */
    public TextView f75834q;

    /* renamed from: r  reason: collision with root package name */
    public View f75835r;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ah(View view) {
        f.b0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(View view, boolean z11) {
        this.f75825h.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uh(CharSequence charSequence, int i11, int i12, int i13) {
        this.f75825h.setBackgroundResource(R.drawable.login_input_bg);
        this.f75826i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(View view, boolean z11) {
        this.f75823f.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(CharSequence charSequence, int i11, int i12, int i13) {
        String charSequence2 = charSequence.toString();
        int k11 = StringUtils.k(charSequence2);
        if (TextUtils.isEmpty(charSequence2) && i12 == 0) {
            this.f75821d.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75822e.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75829l.setImageResource(R.drawable.password_check_failed);
            this.f75830m.setImageResource(R.drawable.password_check_failed);
        } else if (TextUtils.isEmpty(charSequence2)) {
            this.f75821d.setTextColor(getResources().getColor(R.color.baseColorThreeLevelText));
            this.f75822e.setTextColor(getResources().getColor(R.color.baseColorThreeLevelText));
            this.f75829l.setImageResource(R.drawable.password_check_normal);
            this.f75830m.setImageResource(R.drawable.password_check_normal);
        } else if (k11 == 0) {
            this.f75821d.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75822e.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75829l.setImageResource(R.drawable.password_check_failed);
            this.f75830m.setImageResource(R.drawable.password_check_failed);
        } else if (k11 == 1) {
            this.f75821d.setTextColor(getResources().getColor(R.color.base_up_color));
            this.f75822e.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75829l.setImageResource(R.drawable.password_check_pass);
            this.f75830m.setImageResource(R.drawable.password_check_failed);
        } else {
            this.f75821d.setTextColor(getResources().getColor(R.color.base_up_color));
            this.f75822e.setTextColor(getResources().getColor(R.color.base_up_color));
            this.f75829l.setImageResource(R.drawable.password_check_pass);
            this.f75830m.setImageResource(R.drawable.password_check_pass);
        }
        if (charSequence.length() > 0) {
            this.f75824g.setVisibility(0);
        } else {
            this.f75824g.setVisibility(4);
        }
        ph();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        if (this.f75831n) {
            this.f75828k.setImageResource(R.drawable.register_eye_close_icon);
            this.f75831n = false;
            this.f75819b.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ClearEditText clearEditText = this.f75819b;
            clearEditText.setSelection(clearEditText.getText().toString().length());
        } else {
            this.f75828k.setImageResource(R.drawable.register_eye_open_icon);
            this.f75831n = true;
            this.f75819b.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ClearEditText clearEditText2 = this.f75819b;
            clearEditText2.setSelection(clearEditText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(View view) {
        if (TextUtils.isEmpty(this.f75819b.getText().toString())) {
            this.f75821d.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75822e.setTextColor(getResources().getColor(R.color.global_huobi_color));
            this.f75829l.setImageResource(R.drawable.password_check_failed);
            this.f75830m.setImageResource(R.drawable.password_check_failed);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "注册页_设置密码页_完成注册");
        g.i("app_RegisterProcess_button_click", hashMap);
        Editable text = this.f75820c.getText();
        if (text == null || TextUtils.isEmpty(text.toString())) {
            this.f75833p = null;
            lg();
        } else {
            this.f75833p = text.toString();
            ((UserRegisterV2Presenter) getPresenter()).z0(this.f75833p);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zh(View view) {
        f.g0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void B4() {
    }

    public void B9() {
        this.f75825h.setBackgroundResource(R.drawable.login_input_error_bg);
        this.f75826i.setVisibility(0);
    }

    public final void Bh(String str) {
        String str2 = f75818s;
        Log.e(str2, "initView: inviteId = " + str);
        if (TextUtils.isEmpty(str)) {
            str = SP.i("invite_code", (String) null);
        } else {
            SP.s("invite_code", str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f75820c.setText(str);
            this.f75820c.setKeyListener((KeyListener) null);
            this.f75820c.setFocusable(false);
            this.f75820c.setFocusableInTouchMode(false);
            this.f75825h.setBackground(ContextCompat.getDrawable(this, R.drawable.login_no_edit_input_bg));
            this.f75820c.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
        }
    }

    public void G0() {
    }

    public void J8(AccountVerifyBean accountVerifyBean) {
    }

    public void K0() {
    }

    public void Me(VerifyAuthCodeData verifyAuthCodeData) {
    }

    public void Q0(Bitmap bitmap) {
    }

    public void U8(HomeActivityEntityResponse homeActivityEntityResponse) {
    }

    public void V8(String str) {
    }

    public void Vc() {
    }

    public void addEvent() {
        this.f75820c.setClearEditTextOnFocusChangeListener(new w(this));
        this.f75820c.setOnTextChangedListener(new z(this));
        this.f75819b.setClearEditTextOnFocusChangeListener(new x(this));
        this.f75819b.setOnTextChangedListener(new y(this));
        this.f75828k.setOnClickListener(new u(this));
        this.f75832o.setOnClickListener(new r(this));
    }

    public void c5(String str, String str2, String str3, String str4, boolean z11) {
    }

    public boolean canFullScreen() {
        return true;
    }

    public void e7(String str) {
    }

    public void g6() {
    }

    public int getContentView() {
        return R.layout.activity_user_register_password_set_v2;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public void initExtra() {
        String stringExtra;
        super.initExtra();
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("invite_code")) != null) {
            this.f75833p = stringExtra;
        }
    }

    public void initView() {
        this.f75819b = (ClearEditText) this.viewFinder.b(R.id.set_psw_edit);
        this.f75821d = (TextView) this.viewFinder.b(R.id.set_psw_top_tips1);
        this.f75822e = (TextView) this.viewFinder.b(R.id.set_psw_top_tips2);
        this.f75829l = (ImageView) this.viewFinder.b(R.id.tips1Icon);
        this.f75830m = (ImageView) this.viewFinder.b(R.id.tips2Icon);
        this.f75823f = this.viewFinder.b(R.id.pswLayout);
        this.f75824g = this.viewFinder.b(R.id.divider);
        this.f75825h = this.viewFinder.b(R.id.layout_register_invite);
        this.f75826i = this.viewFinder.b(R.id.tv_invite_error);
        this.f75827j = (ScrollView) this.viewFinder.b(R.id.scroll_view);
        this.f75828k = (ImageView) this.viewFinder.b(R.id.set_psw_img);
        this.f75832o = (StatusButton) this.viewFinder.b(R.id.register_btn_next);
        this.f75820c = (ClearEditText) this.viewFinder.b(R.id.cet_invite);
        this.f75834q = (TextView) this.viewFinder.b(R.id.agreementText);
        this.f75835r = this.viewFinder.b(R.id.scrollContent);
        this.viewFinder.b(R.id.close_btn).setOnClickListener(new t(this));
        this.f75832o.setEnabled(true);
        this.f75832o.setButtonText(getString(R.string.n_register_complete));
        this.f75832o.setTextSize(getResources().getDimension(R.dimen.global_text_size_14));
        this.f75832o.setBackgroundResource(R.drawable.register_v2_btn_bg_enable);
        sh();
        SoftInputUtils.e(this, this.f75827j, 125);
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", "注册页_设置密码页");
        g.i("App_PageView", hashMap);
        if ("invalid".equals(this.f75833p)) {
            this.f75833p = "";
            this.f75825h.setVisibility(8);
            return;
        }
        Bh(ChannelUtils.c());
    }

    public void lg() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("auth_token");
            String str = "";
            if (!TextUtils.isEmpty(stringExtra)) {
                String stringExtra2 = getIntent().getStringExtra(Constants.FLAG_ACCOUNT);
                ((UserRegisterV2Presenter) getPresenter()).y1(stringExtra2, this.f75819b.getText() == null ? str : this.f75819b.getText().toString(), getIntent().getStringExtra(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE), getIntent().getStringExtra("country_code"), getIntent().getStringExtra("country_id"), "2", (String) null, this.f75833p, stringExtra);
                return;
            }
            UserRegisterV2Presenter userRegisterV2Presenter = (UserRegisterV2Presenter) getPresenter();
            String stringExtra3 = getIntent().getStringExtra("country_id");
            String stringExtra4 = getIntent().getStringExtra("pw");
            String stringExtra5 = getIntent().getStringExtra(Constants.FLAG_ACCOUNT);
            String stringExtra6 = getIntent().getStringExtra("country_code");
            if (this.f75819b.getText() != null) {
                str = this.f75819b.getText().toString();
            }
            userRegisterV2Presenter.v1(stringExtra3, stringExtra4, stringExtra5, stringExtra6, str, this.f75833p);
        }
    }

    public void ob(String str, HashMap<String, Object> hashMap, String str2, String str3) {
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void ph() {
        String str;
        if (TextUtils.isEmpty(this.f75819b.getText().toString())) {
            this.f75832o.setEnabled(true);
            return;
        }
        if (this.f75819b.getText() == null) {
            str = "";
        } else {
            str = this.f75819b.getText().toString();
        }
        if (StringUtils.k(str) > 1) {
            this.f75832o.setEnabled(true);
        } else {
            this.f75832o.setEnabled(false);
        }
    }

    public void q1(String str) {
        HuobiToastUtil.m(str);
    }

    public void q4(String str, String str2, String str3, boolean z11, RiskControl riskControl) {
    }

    /* renamed from: qh */
    public UserRegisterV2Presenter createPresenter() {
        return new UserRegisterV2Presenter();
    }

    /* renamed from: rh */
    public UserRegisterV2Presenter.j getUI() {
        return this;
    }

    public void se(String str) {
    }

    public final void sh() {
        String string = getString(R.string.n_login_simple_register_agree_new);
        String string2 = getString(R.string.privacy_agreement_url2);
        String string3 = getString(R.string.n_me_about_user_privacy_policy);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(Locale.US, string, new Object[]{string2, string3}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.baseColorThreeLevelText)), 0, spannableStringBuilder.length(), 17);
        SpannableUtils.d(this, spannableStringBuilder, string2, new s(this));
        SpannableUtils.d(this, spannableStringBuilder, string3, new v(this));
        this.f75834q.setMovementMethod(LinkMovementMethod.getInstance());
        this.f75834q.setText(spannableStringBuilder);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
