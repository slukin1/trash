package com.huobi.login.v3.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.FollowTypeData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import com.huobi.login.v2.ui.CaptchaCodeActivityV2;
import com.huobi.login.v3.bean.LoginSuccBean;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import com.huobi.utils.SpannableUtils;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import gs.g;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import vn.a0;
import vn.w;
import vn.x;
import vn.y;
import vn.z;
import wn.b0;
import wn.c0;
import wn.f;
import wn.k0;
import wn.u0;

@Route(path = "/login/register_v2")
public class UserRegisterActivityV3 extends BaseActivity<UserLoginPresenter, UserLoginPresenter.f> implements UserLoginPresenter.f, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public StatusButton f76123b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f76124c;

    /* renamed from: d  reason: collision with root package name */
    public int f76125d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f76126e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f76127f = new b0(new a());

    /* renamed from: g  reason: collision with root package name */
    public final u0 f76128g = new u0(new b());

    /* renamed from: h  reason: collision with root package name */
    public final f f76129h = new f(new c());

    /* renamed from: i  reason: collision with root package name */
    public final k0 f76130i = new k0(new d(), "验证码登录");

    public class a implements b0.a {
        public a() {
        }

        public boolean I0() {
            return UserRegisterActivityV3.this.I0();
        }

        public boolean a() {
            return UserRegisterActivityV3.this.Gh();
        }

        public boolean b() {
            return UserRegisterActivityV3.this.Hh();
        }

        public void c(String str) {
            UserRegisterActivityV3.this.Jh(str);
        }

        public BaseActivity getActivity() {
            return UserRegisterActivityV3.this;
        }
    }

    public class b implements u0.d {
        public b() {
        }

        public void a(String str, String str2, int i11, HashMap<String, Object> hashMap) {
            UserRegisterActivityV3.this.showProgressDialog();
            if (UserRegisterActivityV3.this.Gh()) {
                ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).X1(str, hashMap, (String) null, (String) null, 1);
            } else {
                ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).a2(UserRegisterActivityV3.this.Ch(), str, hashMap, (String) null, (String) null, false, 1);
            }
        }

        public void b(int i11, int i12, Intent intent) {
            UserRegisterActivityV3.this.onActivityResult(i11, i12, intent);
        }

        public void c() {
            if (UserRegisterActivityV3.this.f76123b != null) {
                UserRegisterActivityV3.this.f76123b.dismissAnim();
            }
        }

        public BaseActivity getActivity() {
            return UserRegisterActivityV3.this;
        }
    }

    public class c implements f.i {
        public c() {
        }

        public boolean I0() {
            return UserRegisterActivityV3.this.I0();
        }

        public void a() {
            ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).K1(UserRegisterActivityV3.this.getAccount(), (String) null, UserRegisterActivityV3.this.Hh(), UserRegisterActivityV3.this.Ch());
            UserRegisterActivityV3.this.f76123b.showAnim();
        }

        public void b(HashMap<String, Object> hashMap, String str) {
            ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).J1(UserRegisterActivityV3.this.getAccount(), hashMap, str);
        }

        public void c() {
            ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).K1(UserRegisterActivityV3.this.getAccount(), (String) null, UserRegisterActivityV3.this.Hh(), UserRegisterActivityV3.this.Ch());
            UserRegisterActivityV3.this.f76123b.showAnim();
        }

        public void d(String str, HashMap<String, Object> hashMap, String str2) {
            ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).J1(UserRegisterActivityV3.this.getAccount(), hashMap, str2);
        }

        public String e() {
            return ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).P0();
        }

        public BaseActivity getActivity() {
            return UserRegisterActivityV3.this;
        }

        public String i() {
            return TextUtils.isEmpty(UserRegisterActivityV3.this.getAccount()) ? "" : UserRegisterActivityV3.this.getAccount();
        }

        public void onDialogFragmentPause() {
            UserRegisterActivityV3.this.G0();
        }
    }

    public class d implements k0.b {
        public d() {
        }

        public void a(String str, String str2) {
            ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).Q1(str, str2);
        }

        public JumpTarget b() {
            return ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).R0();
        }

        public BaseActivity getActivity() {
            return UserRegisterActivityV3.this;
        }
    }

    public class e implements u0.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f76135a;

        public e(String str) {
            this.f76135a = str;
        }

        public void a() {
            UserRegisterActivityV3.this.G0();
        }

        public void b(String str, String str2) {
            if (!TextUtils.isEmpty(str) && str.length() >= 5) {
                UserRegisterActivityV3.this.showProgressDialog();
                String account = UserRegisterActivityV3.this.getAccount();
                if (UserRegisterActivityV3.this.Gh()) {
                    ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).X1(account, (HashMap<String, Object>) null, str2, str, 1);
                } else {
                    ((UserLoginPresenter) UserRegisterActivityV3.this.getPresenter()).a2(this.f76135a, account, (HashMap<String, Object>) null, str2, str, false, 1);
                }
            }
        }

        public void onCancel() {
            UserRegisterActivityV3.this.f76123b.dismissAnim();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        sn.f.g0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        sn.f.b0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void Mh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        HashMap hashMap = new HashMap(2);
        hashMap.put("pageSource", "SignUp");
        hashMap.put("button_name", "Cancel");
        g.i("popUpClick_login", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((UserLoginPresenter) getPresenter()).d2();
        HashMap hashMap = new HashMap(2);
        hashMap.put("pageSource", "SignUp");
        hashMap.put("button_name", "Login");
        g.i("popUpClick_login", hashMap);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f76127f.K()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        SoftInputUtils.f(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Bh */
    public UserLoginPresenter createPresenter() {
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter();
        userLoginPresenter.T0(getIntent());
        return userLoginPresenter;
    }

    public void C9(String str, String str2, int i11, RiskControl riskControl) {
        this.f76128g.C(str, (String) null, MiPushClient.COMMAND_REGISTER, riskControl);
    }

    public final String Ch() {
        return this.f76127f.m();
    }

    public final String Dh() {
        return this.f76127f.n();
    }

    /* renamed from: Eh */
    public UserLoginPresenter.f getUI() {
        return this;
    }

    public final void Fh() {
        String string = getString(R.string.n_login_simple_register_agree_new);
        String string2 = getString(R.string.privacy_agreement_url2);
        String string3 = getString(R.string.n_me_about_user_privacy_policy);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(Locale.US, string, new Object[]{string2, string3}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.baseColorThreeLevelText)), 0, spannableStringBuilder.length(), 17);
        SpannableUtils.d(this, spannableStringBuilder, string2, new w(this));
        SpannableUtils.d(this, spannableStringBuilder, string3, new y(this));
        this.f76124c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f76124c.setText(spannableStringBuilder);
    }

    public void G0() {
        this.f76123b.dismissAnim();
        this.f76129h.v();
    }

    public final boolean Gh() {
        return this.f76125d == 0;
    }

    public void Hg(FollowTypeData followTypeData, HashMap<String, Object> hashMap) {
    }

    public final boolean Hh() {
        return this.f76125d == 1;
    }

    public boolean I0() {
        return false;
    }

    public final void Ih(String str) {
        int p11 = this.f76127f.p(str);
        if (this.f76125d != p11) {
            this.f76125d = p11;
            this.f76127f.x(str);
        }
    }

    public final void Jh(String str) {
        int p11 = this.f76127f.p(str);
        if (this.f76125d != p11) {
            this.f76125d = p11;
            this.f76127f.O(str, Boolean.FALSE);
        }
    }

    public void K0() {
        this.f76128g.m();
    }

    public void Ma() {
        String m11 = this.f76127f.m();
        this.f76128g.D(getAccount(), 1, this.f76125d, m11, new e(m11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Oh() {
        /*
            r8 = this;
            wn.b0 r0 = r8.f76127f
            boolean r0 = r0.v()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "way"
            java.lang.String r2 = "WEB"
            r0.put(r1, r2)
            boolean r1 = r8.Gh()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0082
            java.lang.String r1 = r8.getAccount()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x002b
            java.lang.String r1 = r1.toLowerCase()
        L_0x002b:
            java.lang.String r4 = "email"
            r0.put(r4, r1)
            com.hbg.lib.common.mvp.ActivityPresenter r4 = r8.getPresenter()
            if (r4 == 0) goto L_0x0082
            com.hbg.lib.common.mvp.ActivityPresenter r4 = r8.getPresenter()
            com.huobi.login.v3.presenter.UserLoginPresenter r4 = (com.huobi.login.v3.presenter.UserLoginPresenter) r4
            java.util.List r4 = r4.U0()
            r5 = 0
            if (r4 == 0) goto L_0x0068
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L_0x0068
            java.util.Iterator r4 = r4.iterator()
        L_0x004d:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0068
            java.lang.Object r6 = r4.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = android.text.TextUtils.isEmpty(r1)
            if (r7 != 0) goto L_0x004d
            boolean r7 = r1.contains(r6)
            if (r7 == 0) goto L_0x004d
            r1 = r3
            r5 = r6
            goto L_0x0069
        L_0x0068:
            r1 = r2
        L_0x0069:
            if (r1 == 0) goto L_0x0082
            android.content.res.Resources r1 = r8.getResources()
            r4 = 2132022985(0x7f1416c9, float:1.9684405E38)
            java.lang.String r1 = r1.getString(r4)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r2] = r5
            java.lang.String r1 = java.lang.String.format(r1, r4)
            com.hbg.lib.widgets.utils.HuobiToastUtil.m(r1)
            goto L_0x0083
        L_0x0082:
            r2 = r3
        L_0x0083:
            java.util.HashMap r1 = new java.util.HashMap
            r4 = 4
            r1.<init>(r4)
            boolean r4 = r8.Gh()
            if (r4 == 0) goto L_0x0092
            java.lang.String r4 = "mail"
            goto L_0x0094
        L_0x0092:
            java.lang.String r4 = "tel"
        L_0x0094:
            java.lang.String r5 = "sign_type"
            r1.put(r5, r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            java.lang.String r5 = "is_success"
            r1.put(r5, r4)
            java.lang.String r4 = "button_name"
            java.lang.String r5 = "获取验证码"
            r1.put(r4, r5)
            java.lang.String r5 = "app_login_button_click"
            gs.g.i(r5, r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>(r3)
            java.lang.String r3 = "NEXT"
            r1.put(r4, r3)
            java.lang.String r3 = "appClick_Signup"
            gs.g.i(r3, r1)
            if (r2 == 0) goto L_0x00da
            com.hbg.lib.common.mvp.ActivityPresenter r1 = r8.getPresenter()
            if (r1 == 0) goto L_0x00da
            com.hbg.lib.common.mvp.ActivityPresenter r1 = r8.getPresenter()
            com.huobi.login.v3.presenter.UserLoginPresenter r1 = (com.huobi.login.v3.presenter.UserLoginPresenter) r1
            java.lang.String r2 = r8.getAccount()
            boolean r3 = r8.Hh()
            java.lang.String r4 = r8.Ch()
            r1.U1(r0, r2, r3, r4)
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.login.v3.ui.UserRegisterActivityV3.Oh():void");
    }

    public LoginSuccBean Pf() {
        LoginSuccBean loginSuccBean = new LoginSuccBean();
        loginSuccBean.f(Hh());
        loginSuccBean.d(Ch());
        loginSuccBean.e(Dh());
        return loginSuccBean;
    }

    public final void Ph(int i11, int i12, Intent intent) {
        if (i11 == 124 && i12 == -1) {
            VerifyAuthCodeData verifyAuthCodeData = (VerifyAuthCodeData) intent.getSerializableExtra("VerifyAuthCodeData");
            String flowType = verifyAuthCodeData.getFlowType();
            if (VerifyAuthCodeData.FLOW_TYPE_LOGIN.equals(flowType)) {
                ((UserLoginPresenter) getPresenter()).R1(getAccount(), verifyAuthCodeData.getUcToken(), verifyAuthCodeData.getTicket());
            } else if (!VerifyAuthCodeData.FLOW_TYPE_LOGIN_2FA.equals(flowType)) {
                VerifyAuthCodeData.FLOW_TYPE_REGISTER.equals(flowType);
            } else if (verifyAuthCodeData.getRequireTypes() != null && verifyAuthCodeData.getRequireTypes().size() > 0) {
                getUI().showProgressDialog();
                List<LoginInfoData.Login2FAOption> requireTypes = verifyAuthCodeData.getRequireTypes();
                String str = "";
                String str2 = str;
                boolean z11 = false;
                boolean z12 = false;
                for (int i13 = 0; i13 < requireTypes.size(); i13++) {
                    LoginInfoData.Login2FAOption login2FAOption = requireTypes.get(i13);
                    int type = login2FAOption.getType();
                    if (type == 1) {
                        z11 = true;
                    } else if (type == 2) {
                        str = login2FAOption.getTag();
                    } else if (type == 3) {
                        str2 = login2FAOption.getTag();
                    } else if (type == 4) {
                        z12 = true;
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("isKnowDevice", Boolean.valueOf(verifyAuthCodeData.isKnowDevice()));
                ge(z11, str, str2, z12, verifyAuthCodeData.getToken(), hashMap);
                getUI().dismissProgressDialog();
            }
        }
    }

    public void Qh(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("pageSource", "SignUp");
        g.i("popUp_login", hashMap);
        DialogUtils.b0(this, "", str, "", getString(R.string.cancel), getString(R.string.n_register_go_login), a0.f61093a, new z(this));
    }

    public void Rh() {
        String stringExtra = getIntent().getStringExtra("login_name");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = c0.b();
        }
        this.f76127f.O(stringExtra, Boolean.TRUE);
    }

    public void addEvent() {
        this.viewFinder.b(R.id.login_close_btn).setOnClickListener(this);
        this.f76123b.setOnClickListener(this);
        this.viewFinder.b(R.id.btn_pwd_login).setOnClickListener(this);
        this.viewFinder.b(R.id.scrollContent).setOnClickListener(new x(this));
    }

    public void b2() {
        if (((UserLoginPresenter) getPresenter()).P0() != null) {
            this.viewFinder.b(R.id.btn_pwd_login).setVisibility(8);
            this.viewFinder.b(R.id.bottom_third_layout).setVisibility(8);
            ((TextView) this.viewFinder.b(R.id.login_register_title)).setText(R.string.n_login_login_sub_account_input_hint);
            ((ImageView) this.viewFinder.b(R.id.login_close_btn)).setImageResource(R.drawable.edge_engine_top_bar_back_normal);
            HashMap hashMap = new HashMap(2);
            hashMap.put("Page_name", "绑定账号输入账号页");
            hashMap.put("sign_type", ((UserLoginPresenter) getPresenter()).P0());
            g.i("App_login_pageview", hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("Page_name", "验证码登录");
        g.i("App_login_pageview", hashMap2);
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
        hashMap.put(InnerShareParams.SCENCE, "验证码登录");
        hashMap.put("verification_type", str2);
        g.i("twoFA_show", hashMap);
        this.f76129h.A(list, str, map);
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
        hashMap.put(InnerShareParams.SCENCE, "验证码登录");
        hashMap.put("verification_type", str4);
        g.i("twoFA_show", hashMap);
        this.f76129h.z(z11, str, str2, z12, str3, map);
    }

    public String getAccount() {
        return this.f76127f.l();
    }

    public int getContentView() {
        return R.layout.activity_register_v3;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public void h5() {
        this.f76129h.u();
    }

    public void initView() {
        String stringExtra = getIntent().getStringExtra("login_name");
        this.f76126e = getIntent().getBooleanExtra("login_multiple_account", false);
        if (TextUtils.isEmpty(stringExtra) && !this.f76126e) {
            stringExtra = c0.b();
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            Ih(stringExtra);
        }
        this.f76123b = (StatusButton) this.viewFinder.b(R.id.register_btn_next);
        this.f76124c = (TextView) this.viewFinder.b(R.id.agreementText);
        this.f76130i.k(this.viewFinder);
        this.f76127f.s(this, this.viewFinder);
        Rh();
        Fh();
    }

    public void m7() {
    }

    public void n3() {
        this.f76123b.showAnim();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (!this.f76128g.w(i11, i12, intent)) {
            G0();
        }
        this.f76130i.v(i11, i12, intent);
        this.f76127f.J(i11, i12, intent);
        Ph(i11, i12, intent);
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
        if (id2 == R.id.btn_pwd_login) {
            ((UserLoginPresenter) getPresenter()).d2();
            HashMap hashMap = new HashMap(1);
            hashMap.put("button_name", "Login");
            g.i("appClick_Signup", hashMap);
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("button_name", "切换密码登录");
            g.i("app_login_button_click", hashMap2);
        } else if (id2 == R.id.login_close_btn) {
            onBackPressed();
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("button_name", "关闭验证码");
            g.i("app_login_button_click", hashMap3);
        } else if (id2 == R.id.register_btn_next) {
            Oh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("login_name");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = c0.b();
        }
        g.i("appView_Signup", (HashMap) null);
        if (((UserLoginPresenter) getPresenter()).P0() == null) {
            this.f76130i.w(stringExtra);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f76128g.x();
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
        hashMap.put(InnerShareParams.SCENCE, "验证码登录");
        hashMap.put("verification_type", str4);
        g.i("twoFA_show", hashMap);
        this.f76129h.x(i11, str, str2, str3, map);
    }

    public void q1(String str) {
        HuobiToastUtil.m(str);
    }

    public void r2() {
        String account = getAccount();
        String Ch = Ch();
        String Dh = Dh();
        if (Gh()) {
            CaptchaCodeActivityV2.Uh(this, "register_email", account, Ch, Dh, (String) null, (String) null, ((UserLoginPresenter) getPresenter()).O0(), true, "AUTH_CODE_LOGIN_REGISTER", 1);
            return;
        }
        CaptchaCodeActivityV2.Uh(this, "register_mobile", account, Ch.replace("+", "00"), Dh, (String) null, (String) null, ((UserLoginPresenter) getPresenter()).O0(), true, "AUTH_CODE_LOGIN_REGISTER", 1);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void yg() {
    }
}
