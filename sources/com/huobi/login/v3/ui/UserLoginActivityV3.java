package com.huobi.login.v3.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import bj.o0;
import cn.sharesdk.framework.InnerShareParams;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.CountryInfo;
import com.huobi.login.usercenter.data.source.bean.FollowTypeData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.v2.ui.ForgetPasswordActivityV2;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import com.huobi.utils.SpannableUtils;
import com.huobi.view.button.StatusButton;
import com.huobi.view.radiogroup.RadioGroupContainer;
import com.huochat.community.util.DisplayTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import gs.g;
import i6.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import sn.w;
import vn.i;
import vn.j;
import vn.k;
import vn.l;
import vn.n;
import wn.c0;
import wn.f;
import wn.k0;
import wn.p;
import wn.u0;

public class UserLoginActivityV3 extends BaseActivity<UserLoginPresenter, UserLoginPresenter.f> implements UserLoginPresenter.f, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RadioGroupContainer f76072b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f76073c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f76074d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f76075e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f76076f;

    /* renamed from: g  reason: collision with root package name */
    public StatusButton f76077g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f76078h;

    /* renamed from: i  reason: collision with root package name */
    public int f76079i;

    /* renamed from: j  reason: collision with root package name */
    public final p f76080j = new p(new a());

    /* renamed from: k  reason: collision with root package name */
    public final u0 f76081k = new u0(new b());

    /* renamed from: l  reason: collision with root package name */
    public final f f76082l = new f(new c());

    /* renamed from: m  reason: collision with root package name */
    public final k0 f76083m = new k0(new d(), "密码登录");

    public class a implements p.a {
        public a() {
        }

        public boolean I0() {
            return UserLoginActivityV3.this.I0();
        }

        public boolean a() {
            return UserLoginActivityV3.this.Ih();
        }

        public boolean b() {
            return UserLoginActivityV3.this.Jh();
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV3.this;
        }
    }

    public class b implements u0.d {
        public b() {
        }

        public void a(String str, String str2, int i11, HashMap<String, Object> hashMap) {
            ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).N1(str, str2, hashMap, UserLoginActivityV3.this.Jh(), UserLoginActivityV3.this.Bh());
        }

        public void b(int i11, int i12, Intent intent) {
            UserLoginActivityV3.this.onActivityResult(i11, i12, intent);
        }

        public void c() {
            if (UserLoginActivityV3.this.f76077g != null) {
                UserLoginActivityV3.this.f76077g.dismissAnim();
            }
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV3.this;
        }
    }

    public class c implements f.i {
        public c() {
        }

        public boolean I0() {
            return UserLoginActivityV3.this.I0();
        }

        public void a() {
            ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).K1(UserLoginActivityV3.this.getAccount(), UserLoginActivityV3.this.Eh(), UserLoginActivityV3.this.Jh(), UserLoginActivityV3.this.Bh());
            UserLoginActivityV3.this.f76077g.showAnim();
        }

        public void b(HashMap<String, Object> hashMap, String str) {
            ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).J1(UserLoginActivityV3.this.getAccount(), hashMap, str);
        }

        public void c() {
            ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).K1(UserLoginActivityV3.this.getAccount(), UserLoginActivityV3.this.Eh(), UserLoginActivityV3.this.Jh(), UserLoginActivityV3.this.Bh());
            UserLoginActivityV3.this.f76077g.showAnim();
        }

        public void d(String str, HashMap<String, Object> hashMap, String str2) {
            ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).J1(UserLoginActivityV3.this.getAccount(), hashMap, str2);
        }

        public String e() {
            return ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).P0();
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV3.this;
        }

        public String i() {
            return TextUtils.isEmpty(UserLoginActivityV3.this.getAccount()) ? "" : UserLoginActivityV3.this.getAccount();
        }

        public void onDialogFragmentPause() {
            UserLoginActivityV3.this.G0();
        }
    }

    public class d implements k0.b {
        public d() {
        }

        public void a(String str, String str2) {
            ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).Q1(str, str2);
        }

        public JumpTarget b() {
            return ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).R0();
        }

        public BaseActivity getActivity() {
            return UserLoginActivityV3.this;
        }
    }

    public class e implements u0.e {
        public e() {
        }

        public void a() {
            UserLoginActivityV3.this.G0();
        }

        public void b(String str, String str2) {
            String account = UserLoginActivityV3.this.getAccount();
            String wh2 = UserLoginActivityV3.this.Eh();
            if (!TextUtils.isEmpty(str) && str.length() >= 5) {
                UserLoginActivityV3.this.showProgressDialog();
                ((UserLoginPresenter) UserLoginActivityV3.this.getPresenter()).P1(account, wh2, str, str2, UserLoginActivityV3.this.Jh(), UserLoginActivityV3.this.Bh());
            }
        }

        public void onCancel() {
            UserLoginActivityV3.this.f76077g.dismissAnim();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mh(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        this.f76079i = i12;
        Qh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        sn.f.g0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Intent intent = new Intent(this, UserRegisterActivityV3.class);
        intent.putExtra("login_multiple_account", ((UserLoginPresenter) getPresenter()).Y0());
        if (((UserLoginPresenter) getPresenter()).R0() != null) {
            intent.putExtra("target", ((UserLoginPresenter) getPresenter()).R0());
        }
        startActivity(intent);
        if (((UserLoginPresenter) getPresenter()).P0() == null) {
            overridePendingTransition(0, 0);
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (this.f76080j.F()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        SoftInputUtils.f(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ah */
    public UserLoginPresenter createPresenter() {
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter();
        userLoginPresenter.T0(getIntent());
        return userLoginPresenter;
    }

    public final String Bh() {
        return this.f76080j.k();
    }

    public void C9(String str, String str2, int i11, RiskControl riskControl) {
        if (!isCanBeSeen()) {
            G0();
        } else {
            this.f76081k.C(str, str2, FirebaseAnalytics.Event.LOGIN, riskControl);
        }
    }

    public final String Ch() {
        return this.f76080j.l();
    }

    public final CharSequence Dh() {
        return this.f76080j.m();
    }

    public final String Eh() {
        return this.f76080j.n();
    }

    public final CharSequence Fh() {
        return this.f76080j.o();
    }

    public void G0() {
        this.f76077g.dismissAnim();
        this.f76082l.v();
    }

    /* renamed from: Gh */
    public UserLoginPresenter.f getUI() {
        return this;
    }

    public void Hg(FollowTypeData followTypeData, HashMap<String, Object> hashMap) {
    }

    public final void Hh() {
        String string = getString(R.string.n_login_login_agree);
        String string2 = getString(R.string.privacy_agreement_url2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, new Object[]{string2}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.baseColorThreeLevelText)), 0, spannableStringBuilder.length(), 17);
        SpannableUtils.d(this, spannableStringBuilder, string2, new l(this));
        this.f76078h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f76078h.setText(spannableStringBuilder);
    }

    public boolean I0() {
        return this.f76079i == 2;
    }

    public final boolean Ih() {
        return this.f76079i == 0;
    }

    public final boolean Jh() {
        return this.f76079i == 1;
    }

    public void K0() {
        this.f76081k.m();
    }

    public final void Kh(String str) {
        if (m.Y(str)) {
            this.f76079i = 1;
        } else if (StringUtils.o(str)) {
            this.f76079i = 0;
        } else {
            this.f76079i = 2;
        }
        this.f76080j.u(str);
    }

    public void Ma() {
        this.f76081k.D(getAccount(), 2, this.f76079i, this.f76080j.k(), new e());
    }

    public LoginSuccBean Pf() {
        LoginSuccBean loginSuccBean = new LoginSuccBean();
        loginSuccBean.f(Jh());
        loginSuccBean.d(Bh());
        loginSuccBean.e(Ch());
        return loginSuccBean;
    }

    public final void Ph() {
        CountryInfo g11 = w.j().g();
        if (g11 != null && g11.isShowMsg() && !c0.f76688a) {
            new DialogUtils.b.d(this).i1(0).g1(17).e1(Integer.valueOf(getColor(R.color.color_E94359))).h1(Float.valueOf((float) DisplayTool.dp2px(18.0f))).c1(getString(R.string.n_hk_toast_title)).H0(Float.valueOf((float) DisplayTool.dp2px(16.0f))).G0(Integer.valueOf(DisplayTool.dp2px(10.0f))).X0(true).C0(getString(R.string.n_hk_toast_content)).W0(Float.valueOf((float) DisplayTool.dp2px(14.0f))).R0(getString(R.string.n_hk_toast_desc)).T0(true).V0(Integer.valueOf(DisplayTool.dp2px(15.0f))).b1(Integer.valueOf(DisplayTool.dp2px(15.0f))).Y0(" ").Z0(true).q0(false).P0(getString(R.string.n_copy_trading_me_know)).Q0(vn.m.f61109a).l0().show(getSupportFragmentManager(), "");
            c0.f76688a = true;
        }
    }

    public final void Qh() {
        int checkedPosition = this.f76072b.getCheckedPosition();
        int i11 = this.f76079i;
        if (checkedPosition != i11) {
            this.f76072b.setCheckedPosition(i11);
        }
        if (Ih()) {
            this.f76073c.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
            this.f76074d.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76075e.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
        } else if (Jh()) {
            this.f76073c.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76074d.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
            this.f76075e.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
        } else if (I0()) {
            this.f76073c.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76074d.setTypeface(ResourcesCompat.h(this, R.font.roboto_regular));
            this.f76075e.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
        }
        String stringExtra = getIntent().getStringExtra("login_name");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = c0.b();
        }
        this.f76080j.H(stringExtra);
        this.f76080j.I();
    }

    public void addEvent() {
        this.viewFinder.b(R.id.login_close_btn).setOnClickListener(new i(this));
        this.f76076f.setOnClickListener(this);
        this.f76077g.setOnClickListener(this);
        j jVar = new j(this);
        this.viewFinder.b(R.id.login_sign_up).setOnClickListener(jVar);
        this.viewFinder.b(R.id.btn_login_by_verfication).setOnClickListener(jVar);
        this.f76072b.setOnSelelctChangeListner(new n(this));
        this.viewFinder.b(R.id.scrollContent).setOnClickListener(new k(this));
    }

    public void b2() {
    }

    public boolean canFullScreen() {
        return true;
    }

    public void dh() {
    }

    public void g2(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map) {
        int type = list.get(0).getType();
        String str2 = type == 1 ? "ga" : type == 2 ? "tel" : "mail";
        HashMap hashMap = new HashMap(2);
        hashMap.put(InnerShareParams.SCENCE, "密码登录");
        hashMap.put("verification_type", str2);
        g.i("twoFA_show", hashMap);
        this.f76082l.A(list, str, map);
    }

    public void ge(boolean z11, String str, String str2, boolean z12, String str3, Map<String, Object> map) {
        String str4 = !TextUtils.isEmpty(str) ? "tel," : null;
        if (!TextUtils.isEmpty(str2)) {
            if (str4 == null) {
                str4 = "mail,";
            } else {
                str4 = str4 + "mail,";
            }
        }
        if (z11) {
            if (str4 == null) {
                str4 = "ga,";
            } else {
                str4 = str4 + "ga,";
            }
        }
        if (z12) {
            if (str4 == null) {
                str4 = "password,";
            } else {
                str4 = str4 + "password,";
            }
        }
        if (str4.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            str4 = str4.substring(0, str4.length() - 1);
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(InnerShareParams.SCENCE, "密码登录");
        hashMap.put("verification_type", str4);
        g.i("twoFA_show", hashMap);
        this.f76082l.z(z11, str, str2, z12, str3, map);
    }

    public String getAccount() {
        return this.f76080j.j();
    }

    public int getContentView() {
        getWindow().setFlags(8192, 8192);
        return R.layout.activity_login_v3;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public void h5() {
        this.f76082l.u();
    }

    public void initView() {
        String stringExtra = getIntent().getStringExtra("login_name");
        if (TextUtils.isEmpty(stringExtra) && !getIntent().getBooleanExtra("login_multiple_account", false)) {
            stringExtra = c0.b();
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            Kh(stringExtra);
        }
        this.f76072b = (RadioGroupContainer) this.viewFinder.b(R.id.type_tab);
        this.f76073c = (CheckBox) this.viewFinder.b(R.id.type_email_txt);
        this.f76074d = (CheckBox) this.viewFinder.b(R.id.type_phone_txt);
        this.f76075e = (CheckBox) this.viewFinder.b(R.id.type_sub_account_txt);
        this.f76076f = (TextView) this.viewFinder.b(R.id.login_forgot_psw);
        StatusButton statusButton = (StatusButton) this.viewFinder.b(R.id.login_btn);
        this.f76077g = statusButton;
        statusButton.setButtonText(getString(R.string.n_login_login));
        this.f76077g.setBackgroundResource(R.drawable.register_v2_btn_bg);
        this.f76078h = (TextView) this.viewFinder.b(R.id.agreementText);
        this.f76083m.k(this.viewFinder);
        this.f76080j.q(this, this.viewFinder);
        this.f76080j.r(this.viewFinder);
        Qh();
        Hh();
        Ph();
    }

    public void m7() {
    }

    public void n3() {
        this.f76077g.showAnim();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (!this.f76081k.w(i11, i12, intent)) {
            G0();
        }
        this.f76083m.v(i11, i12, intent);
        this.f76080j.E(i11, i12, intent);
    }

    public void onBackPressed() {
        SoftInputUtils.f(this);
        if (getPresenter() != null) {
            ((UserLoginPresenter) getPresenter()).H0();
        } else {
            finish();
        }
    }

    @SuppressLint({"NonConstantResourceId"})
    @SensorsDataInstrumented
    public void onClick(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int id2 = view.getId();
        if (id2 == R.id.login_btn) {
            boolean s11 = this.f76080j.s();
            if (!this.f76080j.t()) {
                s11 = false;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("sign_type", Ih() ? "mail" : I0() ? "sub" : "tel");
            hashMap.put("is_success", Boolean.valueOf(s11));
            hashMap.put("button_name", "密码登录");
            g.i("app_login_button_click", hashMap);
            if (!s11) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            } else {
                ((UserLoginPresenter) getPresenter()).K1(getAccount(), Eh(), Jh(), Bh());
                this.f76077g.showAnim();
            }
        } else if (id2 == R.id.login_forgot_psw) {
            if (!I0()) {
                Intent intent = new Intent(this, ForgetPasswordActivityV2.class);
                if (((UserLoginPresenter) getPresenter()).R0() != null) {
                    intent.putExtra("target", ((UserLoginPresenter) getPresenter()).R0());
                }
                intent.putExtra("country_id", Ch());
                intent.putExtra("login_type", this.f76079i);
                intent.putExtra("email", Dh());
                intent.putExtra(PlaceFields.PHONE, Fh());
                intent.putExtra("country_code", Bh());
                startActivity(intent);
            } else {
                DialogUtils.X(this, getString(R.string.dialog_minamount_hint_title), getString(R.string.sub_account_forget_pw), (String) null, getString(R.string.dialog_minamount_hint_confrm_btn), o0.f12469a);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("login_name");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = c0.b();
        }
        this.f76083m.w(stringExtra);
        HashMap hashMap = new HashMap(2);
        hashMap.put("Page_name", "密码登录");
        g.i("App_login_pageview", hashMap);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f76081k.x();
    }

    public void p2(int i11, String str, String str2, String str3, Map<String, Object> map) {
        String str4 = !TextUtils.isEmpty(str) ? "tel," : null;
        if (!TextUtils.isEmpty(str2)) {
            if (str4 == null) {
                str4 = "mail,";
            } else {
                str4 = str4 + "mail,";
            }
        }
        if (str4.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            str4 = str4.substring(0, str4.length() - 1);
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(InnerShareParams.SCENCE, "密码登录");
        hashMap.put("verification_type", str4);
        g.i("twoFA_show", hashMap);
        this.f76082l.x(i11, str, str2, str3, map);
    }

    public void q1(String str) {
        HuobiToastUtil.m(str);
    }

    public void r2() {
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void yg() {
    }
}
