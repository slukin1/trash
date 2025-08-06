package com.huobi.login.v2.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyController;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.holder.EmailAssociationAdapter;
import com.huobi.login.presenter.ForgetPasswordPresenter;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.view.CommonCaptchaDialog;
import com.huobi.view.button.StatusButton;
import com.huobi.view.radiogroup.RadioGroupContainer;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;
import sn.w;
import tn.j;
import tn.k;
import tn.l;
import tn.n;
import tn.o;
import tn.p;
import tn.q;

@Route(path = "/login/forgetPassword")
public class ForgetPasswordActivityV2 extends BaseActivity<ForgetPasswordPresenter, ForgetPasswordPresenter.b> implements ForgetPasswordPresenter.b {
    public static final String A = "ForgetPasswordActivityV2";

    /* renamed from: b  reason: collision with root package name */
    public StatusButton f75784b;

    /* renamed from: c  reason: collision with root package name */
    public View f75785c;

    /* renamed from: d  reason: collision with root package name */
    public final SecurityStrategyBottomMenuFragment f75786d = new SecurityStrategyBottomMenuFragment();

    /* renamed from: e  reason: collision with root package name */
    public CommonCaptchaDialog f75787e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Object> f75788f;

    /* renamed from: g  reason: collision with root package name */
    public String f75789g;

    /* renamed from: h  reason: collision with root package name */
    public VerifyHelper f75790h;

    /* renamed from: i  reason: collision with root package name */
    public View f75791i;

    /* renamed from: j  reason: collision with root package name */
    public int f75792j;

    /* renamed from: k  reason: collision with root package name */
    public ViewGroup f75793k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f75794l;

    /* renamed from: m  reason: collision with root package name */
    public View f75795m;

    /* renamed from: n  reason: collision with root package name */
    public ClearEditText f75796n;

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f75797o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f75798p;

    /* renamed from: q  reason: collision with root package name */
    public String f75799q;

    /* renamed from: r  reason: collision with root package name */
    public String f75800r;

    /* renamed from: s  reason: collision with root package name */
    public RadioGroupContainer f75801s;

    /* renamed from: t  reason: collision with root package name */
    public CheckBox f75802t;

    /* renamed from: u  reason: collision with root package name */
    public CheckBox f75803u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f75804v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f75805w;

    /* renamed from: x  reason: collision with root package name */
    public PopupWindow f75806x;

    /* renamed from: y  reason: collision with root package name */
    public RecyclerView f75807y;

    /* renamed from: z  reason: collision with root package name */
    public EmailAssociationAdapter f75808z;

    public class a extends SecurityStrategyController {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AccountVerifyBean f75809g;

        public a(AccountVerifyBean accountVerifyBean) {
            this.f75809g = accountVerifyBean;
        }

        public boolean C() {
            return this.f75809g.isVerify_phone();
        }

        public void Q() {
            super.Q();
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap = new HashMap();
            hashMap.put("account_name", ForgetPasswordActivityV2.this.f75796n.getText().toString());
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            hashMap.put("version", 2);
            hashMap.put("token", this.f75809g.getToken());
            ((ForgetPasswordPresenter) ForgetPasswordActivityV2.this.getPresenter()).u0(hashMap, ForgetPasswordActivityV2.this.f75796n.getText().toString());
        }

        public String n() {
            return this.f75809g.getEmail();
        }

        public String o() {
            return this.f75809g.getPhone();
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("account_name", ForgetPasswordActivityV2.this.f75796n.getText().toString());
            hashMap.put("use_type", "RESET_PASSWORD_V2_2FA");
            hashMap.put("token", this.f75809g.getToken());
            return hashMap;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put("account_name", ForgetPasswordActivityV2.this.f75796n.getText().toString());
            hashMap.put("use_type", "RESET_PASSWORD_V2_2FA");
            hashMap.put("token", this.f75809g.getToken());
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean x() {
            return this.f75809g.isVerify_email();
        }

        public boolean y() {
            return this.f75809g.isVerify_ga();
        }

        public boolean z() {
            return false;
        }
    }

    public class b implements VerifyHelper.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f75811a;

        public b(String str) {
            this.f75811a = str;
        }

        public void a(int i11, int i12, Intent intent) {
            ForgetPasswordActivityV2.this.onActivityResult(i11, i12, intent);
        }

        public void b(int i11, HashMap<String, Object> hashMap) {
            if (i11 != 0) {
                String unused = ForgetPasswordActivityV2.this.f75789g = this.f75811a;
                HashMap unused2 = ForgetPasswordActivityV2.this.f75788f = hashMap;
                String obj = ForgetPasswordActivityV2.this.f75796n.getText().toString();
                if (ForgetPasswordActivityV2.this.f75792j == 0) {
                    ((ForgetPasswordPresenter) ForgetPasswordActivityV2.this.getPresenter()).p0(obj, hashMap, (String) null);
                } else {
                    ((ForgetPasswordPresenter) ForgetPasswordActivityV2.this.getPresenter()).q0(ForgetPasswordActivityV2.this.f75799q, obj, hashMap, (String) null, false);
                }
            } else {
                ForgetPasswordActivityV2.this.f75784b.dismissAnim();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((ForgetPasswordPresenter) ForgetPasswordActivityV2.this.getPresenter()).n0();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements CommonCaptchaDialog.CommonDialogClickListener {
        public d() {
        }

        public void onCommonDialogClick(Dialog dialog, int i11) {
            ForgetPasswordActivityV2.this.f75787e.dismiss();
            ForgetPasswordActivityV2.this.f75784b.dismissAnim();
        }
    }

    public class e implements CommonCaptchaDialog.CommonDialogClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f75815a;

        public e(String str) {
            this.f75815a = str;
        }

        public void onCommonDialogClick(Dialog dialog, int i11) {
            String obj = ForgetPasswordActivityV2.this.f75787e.getCaptchaEdit().getText().toString();
            if (!TextUtils.isEmpty(obj) && obj.length() >= 5) {
                ForgetPasswordActivityV2.this.showProgressDialog();
                if (ForgetPasswordActivityV2.this.f75792j == 0) {
                    ((ForgetPasswordPresenter) ForgetPasswordActivityV2.this.getPresenter()).p0(this.f75815a, (HashMap<String, Object>) null, obj);
                } else {
                    ((ForgetPasswordPresenter) ForgetPasswordActivityV2.this.getPresenter()).q0(ForgetPasswordActivityV2.this.f75799q, this.f75815a, (HashMap<String, Object>) null, obj, false);
                }
            }
        }
    }

    public class f implements TextWatcher {
        public f() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() < 5) {
                ForgetPasswordActivityV2.this.f75787e.getRightBtn().setEnabled(false);
            } else {
                ForgetPasswordActivityV2.this.f75787e.getRightBtn().setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Eh(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        this.f75792j = i12;
        Oh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fh(String str) {
        this.f75796n.setText(str);
        this.f75796n.setSelection(str.length());
        this.f75806x.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gh(CharSequence charSequence, int i11, int i12, int i13) {
        if (this.f75792j == 1) {
            this.f75798p = charSequence;
            PopupWindow popupWindow = this.f75806x;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.f75806x.dismiss();
            }
        } else {
            this.f75797o = charSequence;
            if (hasWindowFocus()) {
                if (this.f75806x == null) {
                    View inflate = LayoutInflater.from(this).inflate(R.layout.register_email_association, (ViewGroup) null);
                    PopupWindow popupWindow2 = new PopupWindow(inflate);
                    this.f75806x = popupWindow2;
                    popupWindow2.setWidth(-1);
                    this.f75806x.setHeight(getResources().getDimensionPixelSize(R.dimen.dimen_160));
                    this.f75807y = (RecyclerView) inflate.findViewById(R.id.recyclerView);
                    EmailAssociationAdapter emailAssociationAdapter = new EmailAssociationAdapter();
                    this.f75808z = emailAssociationAdapter;
                    emailAssociationAdapter.h(new o(this));
                    this.f75807y.setLayoutManager(new LinearLayoutManager(this));
                    this.f75807y.setAdapter(this.f75808z);
                }
                this.f75808z.g(charSequence.toString());
                if (charSequence.length() <= 0 || this.f75808z.getItemCount() <= 0) {
                    this.f75806x.dismiss();
                } else {
                    if (!this.f75806x.isShowing()) {
                        int[] iArr = new int[2];
                        this.f75796n.getLocationInWindow(iArr);
                        PopupWindow popupWindow3 = this.f75806x;
                        ClearEditText clearEditText = this.f75796n;
                        popupWindow3.showAtLocation(clearEditText, 48, 0, iArr[1] + clearEditText.getHeight() + getResources().getDimensionPixelSize(R.dimen.dimen_8));
                    }
                    this.f75806x.update(-1, getResources().getDimensionPixelSize(R.dimen.dimen_40) * Math.min(this.f75808z.getItemCount(), 3));
                    this.f75808z.notifyDataSetChanged();
                }
            }
        }
        TextPaint paint = this.f75796n.getPaint();
        if (charSequence.length() > 0) {
            paint.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
        } else {
            paint.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
        }
        this.f75805w.setVisibility(8);
        this.f75791i.setBackgroundResource(R.drawable.login_input_bg);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(View view, boolean z11) {
        PopupWindow popupWindow;
        this.f75796n.onFocusChange(view, z11);
        this.f75791i.setSelected(z11);
        if (!z11 && (popupWindow = this.f75806x) != null && popupWindow.isShowing()) {
            this.f75806x.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ih(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        Intent intent = new Intent(this, CountryAreaSelectActivityV2.class);
        intent.putExtra("choose_type", "choose_type_code");
        intent.putExtra("SHOW_COUNTRY_ICON", true);
        intent.putExtra("SHOW_ALL_COUNTRY", true);
        startActivityForResult(intent, 1001);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kh(CountryListData countryListData) {
        String a11 = countryListData.a();
        this.f75799q = a11;
        this.f75794l.setText(a11.replace("00", "+"));
        ConfigPreferences.m("user_config", "config_area_code", this.f75799q);
        if (getPresenter() != null) {
            Mh(this.f75792j, this.f75799q, this.f75800r);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (!Dh()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        SoftInputUtils.f(this);
        ((ForgetPasswordPresenter) getPresenter()).r0(this.f75796n.getText().toString());
        this.f75784b.showAnim();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Bh */
    public ForgetPasswordPresenter createPresenter() {
        ForgetPasswordPresenter forgetPasswordPresenter = new ForgetPasswordPresenter();
        forgetPasswordPresenter.s0(this.f75792j, this.f75799q, this.f75800r);
        return forgetPasswordPresenter;
    }

    /* renamed from: Ch */
    public ForgetPasswordPresenter.b getUI() {
        return this;
    }

    public boolean Dh() {
        String str;
        String str2;
        int i11 = this.f75792j;
        boolean z11 = true;
        if (i11 == 1) {
            if (!TextUtils.isEmpty(this.f75798p)) {
                if (StringUtils.o(this.f75798p.toString()) || (m.Y(this.f75798p.toString()) && this.f75798p.toString().length() >= 5)) {
                    return true;
                }
                z11 = false;
            }
            this.f75791i.setBackgroundResource(R.drawable.login_input_error_bg);
            TextView textView = this.f75805w;
            if (z11) {
                str2 = getString(R.string.n_login_phone_input_placeholder);
            } else {
                str2 = getString(R.string.n_login_phone_error_hint);
            }
            textView.setText(str2);
            this.f75805w.setVisibility(0);
            return false;
        }
        if (i11 == 0) {
            if (!TextUtils.isEmpty(this.f75797o)) {
                if (!StringUtils.o(this.f75797o.toString()) && (!m.Y(this.f75797o.toString()) || this.f75797o.toString().length() < 5)) {
                    z11 = false;
                }
            }
            this.f75791i.setBackgroundResource(R.drawable.login_input_error_bg);
            TextView textView2 = this.f75805w;
            if (z11) {
                str = getString(R.string.n_login_email_input_placeholder);
            } else {
                str = getString(R.string.n_zdcchat_right_email);
            }
            textView2.setText(str);
            this.f75805w.setVisibility(0);
            return false;
        }
        return true;
    }

    public void G0() {
        this.f75784b.dismissAnim();
    }

    public void K0() {
        CommonCaptchaDialog commonCaptchaDialog = this.f75787e;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.dismiss();
        }
    }

    public void Lg(String str, String str2) {
        CommonCaptchaDialog commonCaptchaDialog = new CommonCaptchaDialog(this);
        this.f75787e = commonCaptchaDialog;
        commonCaptchaDialog.setTitle(getResources().getString(R.string.login_dialog_captcha_title));
        this.f75787e.setCancelText(getResources().getString(R.string.login_dialog_cancel));
        this.f75787e.setConfirmText(getResources().getString(R.string.login_dialog_confirm));
        this.f75787e.setCaptchaImage(str);
        this.f75787e.show();
        this.f75787e.getImageView().setOnClickListener(new c());
        this.f75787e.setCancelListener(new d());
        this.f75787e.setConfirmListner(new e(str2));
        this.f75787e.getCaptchaEdit().addTextChangedListener(new f());
    }

    public final void Lh(String str) {
        String str2 = A;
        Log.e(str2, "setPhoneCountryIcon: countryId = " + str);
        f6.c.a().l(this, w.e(str), this.f75804v, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
    }

    public final void Mh(int i11, String str, String str2) {
        ((ForgetPasswordPresenter) getPresenter()).s0(i11, str, str2);
    }

    public void Nh(AccountVerifyBean accountVerifyBean) {
        this.f75786d.Ci(new a(accountVerifyBean));
        FragmentTransaction q11 = getSupportFragmentManager().q();
        q11.e(this.f75786d, "BottomMenuFragment");
        q11.k();
    }

    public final void Oh() {
        int checkedPosition = this.f75801s.getCheckedPosition();
        int i11 = this.f75792j;
        if (checkedPosition != i11) {
            this.f75801s.setCheckedPosition(i11);
        }
        if (this.f75792j == 1) {
            this.f75802t.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f75803u.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
            this.f75793k.setVisibility(0);
            this.f75795m.setVisibility(0);
            this.f75796n.setText(this.f75798p);
            this.f75796n.setHint(getResources().getString(R.string.n_login_phone_input_placeholder));
            this.f75796n.setInputType(3);
            String str = this.f75799q;
            if (str != null) {
                this.f75794l.setText(str.replace("00", "+"));
                return;
            }
            String e11 = ConfigPreferences.e("user_config", "config_area_code", "");
            this.f75799q = e11;
            if (!TextUtils.isEmpty(e11)) {
                this.f75794l.setText(this.f75799q.replace("00", "+"));
                if (getPresenter() != null) {
                    Mh(this.f75792j, this.f75799q, this.f75800r);
                    return;
                }
                return;
            }
            w.j().i(this).subscribe(q6.d.c(this, new q(this)));
            return;
        }
        this.f75802t.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
        this.f75803u.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
        this.f75793k.setVisibility(8);
        this.f75795m.setVisibility(8);
        this.f75796n.setText(this.f75797o);
        this.f75796n.setHint(getResources().getString(R.string.n_login_email_input_placeholder));
        this.f75796n.setInputType(33);
        if (getPresenter() != null) {
            Mh(this.f75792j, this.f75799q, this.f75800r);
        }
    }

    public void Q0(Bitmap bitmap) {
        CommonCaptchaDialog commonCaptchaDialog = this.f75787e;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.getImageView().setImageBitmap(bitmap);
            this.f75787e.getCaptchaEdit().setText("");
        }
    }

    public void S5(String str) {
        if (this.f75792j == 0) {
            ((ForgetPasswordPresenter) getPresenter()).p0(str, (HashMap<String, Object>) null, (String) null);
        } else {
            ((ForgetPasswordPresenter) getPresenter()).q0(this.f75799q, str, (HashMap<String, Object>) null, (String) null, false);
        }
    }

    public void Sg(String str, RiskControl riskControl) {
        this.f75790h.m(this, str, "resetPwd", riskControl, new b(str));
    }

    public void addEvent() {
        this.f75801s.setOnSelelctChangeListner(new p(this));
        this.f75784b.setOnClickListener(new j(this));
        this.f75796n.setOnTextChangedListener(new n(this));
        this.f75796n.setOnFocusChangeListener(new tn.m(this));
        this.f75785c.setOnClickListener(new k(this));
        this.f75793k.setOnClickListener(new l(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public int getContentView() {
        return R.layout.forget_password_activity_v2;
    }

    public void h4() {
        this.f75786d.dismiss();
    }

    public void initExtra() {
        super.initExtra();
        Intent intent = getIntent();
        if (intent != null) {
            this.f75800r = intent.getStringExtra("country_id");
            this.f75792j = intent.getIntExtra("login_type", 0);
            this.f75797o = intent.getCharSequenceExtra("email");
            this.f75798p = intent.getCharSequenceExtra(PlaceFields.PHONE);
            this.f75799q = intent.getStringExtra("country_code");
        }
    }

    public void initView() {
        this.f75785c = this.viewFinder.b(R.id.login_close_btn);
        this.f75791i = this.viewFinder.b(R.id.accountLayout);
        this.f75784b = (StatusButton) this.viewFinder.b(R.id.forget_psw_next_btn);
        this.f75801s = (RadioGroupContainer) this.viewFinder.b(R.id.type_tab);
        this.f75802t = (CheckBox) this.viewFinder.b(R.id.type_email_txt);
        this.f75803u = (CheckBox) this.viewFinder.b(R.id.type_phone_txt);
        this.f75804v = (ImageView) this.viewFinder.b(R.id.iv_login_country_flag);
        this.f75805w = (TextView) this.viewFinder.b(R.id.tv_account_error_tip);
        this.f75790h = new VerifyHelper();
        this.f75793k = (ViewGroup) this.viewFinder.b(R.id.llyt_select_country_code);
        this.f75794l = (TextView) this.viewFinder.b(R.id.tv_login_country_code);
        this.f75795m = this.viewFinder.b(R.id.space_divider);
        this.f75796n = (ClearEditText) this.viewFinder.b(R.id.forget_psw_account_edit);
        this.f75784b.setButtonText(getString(R.string.n_login_retrieve_code));
        this.f75784b.setBackgroundResource(R.drawable.login_v2_btn_bg);
        Oh();
        Lh(this.f75800r);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (!this.f75790h.y(i11, i12, intent)) {
            G0();
        }
        if (i12 == -1) {
            if (i11 == 1001) {
                if (intent != null) {
                    this.f75799q = intent.getStringExtra("phone_area_code");
                    this.f75800r = intent.getStringExtra("country_area_code");
                    String str = this.f75799q;
                    if (str != null) {
                        this.f75794l.setText(str.replace("00", "+"));
                    }
                    Lh(this.f75800r);
                    ConfigPreferences.m("user_config", "config_area_code", this.f75799q);
                    if (getPresenter() != null) {
                        Mh(this.f75792j, this.f75799q, this.f75800r);
                    }
                }
            } else if (i11 == 1002) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("phone_area_code");
                    this.f75799q = stringExtra;
                    if (stringExtra != null) {
                        this.f75794l.setText(stringExtra.replace("00", "+"));
                    }
                    ConfigPreferences.m("user_config", "config_area_code", this.f75799q);
                    if (getPresenter() != null) {
                        Mh(this.f75792j, this.f75799q, this.f75800r);
                    }
                }
            } else if (i11 == 124) {
                AccountVerifyBean accountVerifyBean = (AccountVerifyBean) intent.getSerializableExtra("AccountVerifyBean");
                if (accountVerifyBean.isVerify_email() || accountVerifyBean.isVerify_phone() || accountVerifyBean.isVerify_ga()) {
                    Nh(accountVerifyBean);
                } else {
                    ((ForgetPasswordPresenter) getPresenter()).t0(accountVerifyBean.getToken(), this.f75796n.getText().toString());
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
    }

    public void q1(String str) {
        HuobiToastUtil.m(str);
    }

    public void r2() {
        String obj = this.f75796n.getText().toString();
        if (this.f75792j == 0) {
            CaptchaCodeActivityV2.Th(this, "register_email", obj, this.f75799q, this.f75800r, (String) null, "invalid", (String) null, true, "RESET_PASSWORD_V2");
            return;
        }
        CaptchaCodeActivityV2.Th(this, "register_mobile", obj, this.f75799q.replace("+", "00"), this.f75800r, (String) null, "invalid", (String) null, true, "RESET_PASSWORD_V2");
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
