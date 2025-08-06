package com.huobi.login.v2.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.hbg.lib.common.utils.CommonTextWatcher;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.MenuListenEditText;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.login.v3.ui.VerModeDialog;
import com.huobi.view.CommonCaptchaDialog;
import com.huobi.vulcan.model.VulcanInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import i6.m;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

@Route(path = "/login/codeInput")
public class CaptchaCodeActivityV2 extends BaseActivity<UserRegisterV2Presenter, UserRegisterV2Presenter.j> implements UserRegisterV2Presenter.j {
    public String A;
    public String B;
    public boolean C;
    public boolean D;
    public View E;
    public int F = 1;
    public String G;
    public int H;
    public int I;
    public View.OnKeyListener J = new d();
    public View.OnFocusChangeListener K = new e();

    /* renamed from: b  reason: collision with root package name */
    public View f75730b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75731c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75732d;

    /* renamed from: e  reason: collision with root package name */
    public MenuListenEditText f75733e;

    /* renamed from: f  reason: collision with root package name */
    public MenuListenEditText f75734f;

    /* renamed from: g  reason: collision with root package name */
    public MenuListenEditText f75735g;

    /* renamed from: h  reason: collision with root package name */
    public MenuListenEditText f75736h;

    /* renamed from: i  reason: collision with root package name */
    public MenuListenEditText f75737i;

    /* renamed from: j  reason: collision with root package name */
    public MenuListenEditText f75738j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f75739k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f75740l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f75741m;

    /* renamed from: n  reason: collision with root package name */
    public String f75742n;

    /* renamed from: o  reason: collision with root package name */
    public String f75743o;

    /* renamed from: p  reason: collision with root package name */
    public String f75744p;

    /* renamed from: q  reason: collision with root package name */
    public final CompositeSubscription f75745q = new CompositeSubscription();

    /* renamed from: r  reason: collision with root package name */
    public VerifyHelper f75746r;

    /* renamed from: s  reason: collision with root package name */
    public CommonCaptchaDialog f75747s;

    /* renamed from: t  reason: collision with root package name */
    public String f75748t;

    /* renamed from: u  reason: collision with root package name */
    public String f75749u;

    /* renamed from: v  reason: collision with root package name */
    public String f75750v;

    /* renamed from: w  reason: collision with root package name */
    public String f75751w;

    /* renamed from: x  reason: collision with root package name */
    public LinearLayout f75752x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f75753y;

    /* renamed from: z  reason: collision with root package name */
    public EditText f75754z;

    public class a extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f75755b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75756c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f75757d;

        public a(TextView textView, String str, String str2) {
            this.f75755b = textView;
            this.f75756c = str;
            this.f75757d = str2;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                CaptchaCodeActivityV2.this.bi(this.f75755b, true, this.f75756c);
                if (!isUnsubscribed()) {
                    unsubscribe();
                }
                CaptchaCodeActivityV2.this.Qh();
                return;
            }
            int k02 = m.k0(l11 + "");
            CaptchaCodeActivityV2.this.bi(this.f75755b, false, String.format(this.f75757d, new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class b extends CommonTextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f75759b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ EditText f75760c;

        public b(EditText editText, EditText editText2) {
            this.f75759b = editText;
            this.f75760c = editText2;
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            super.onTextChanged(charSequence, i11, i12, i13);
            CaptchaCodeActivityV2.this.f75739k.setText("");
            CaptchaCodeActivityV2.this.f75733e.setBackgroundResource(R.drawable.login_input_bg);
            CaptchaCodeActivityV2.this.f75734f.setBackgroundResource(R.drawable.login_input_bg);
            CaptchaCodeActivityV2.this.f75735g.setBackgroundResource(R.drawable.login_input_bg);
            CaptchaCodeActivityV2.this.f75736h.setBackgroundResource(R.drawable.login_input_bg);
            CaptchaCodeActivityV2.this.f75737i.setBackgroundResource(R.drawable.login_input_bg);
            CaptchaCodeActivityV2.this.f75738j.setBackgroundResource(R.drawable.login_input_bg);
            if (TextUtils.isEmpty(charSequence)) {
                EditText editText = this.f75759b;
                if (editText != null) {
                    editText.requestFocus();
                }
            } else if (charSequence.length() != 6 || !m.Z(charSequence.toString())) {
                EditText editText2 = this.f75760c;
                if (editText2 != null) {
                    editText2.requestFocus();
                }
                CaptchaCodeActivityV2.this.ai();
            } else {
                CaptchaCodeActivityV2.this.Vh(charSequence);
            }
        }
    }

    public class c implements VerModeDialog.a {
        public c() {
        }

        public void a() {
        }

        public boolean b() {
            return true;
        }

        public void c() {
            Intent intent = new Intent();
            intent.putExtra("switch_type", "passkey");
            CaptchaCodeActivityV2.this.setResult(-1, intent);
            CaptchaCodeActivityV2.this.finish();
        }

        public boolean d() {
            return true;
        }

        public boolean e() {
            return CaptchaCodeActivityV2.this.I == 2;
        }

        public void f() {
            Intent intent = new Intent();
            intent.putExtra("switch_type", "pwd");
            CaptchaCodeActivityV2.this.setResult(-1, intent);
            CaptchaCodeActivityV2.this.finish();
        }
    }

    public class d implements View.OnKeyListener {
        public d() {
        }

        public boolean onKey(View view, int i11, KeyEvent keyEvent) {
            return i11 == 67;
        }
    }

    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11 && view != CaptchaCodeActivityV2.this.f75754z) {
                CaptchaCodeActivityV2.this.Kh();
            }
            boolean z12 = true;
            CaptchaCodeActivityV2.this.f75733e.setSelected(CaptchaCodeActivityV2.this.f75733e == CaptchaCodeActivityV2.this.f75754z);
            CaptchaCodeActivityV2.this.f75734f.setSelected(CaptchaCodeActivityV2.this.f75734f == CaptchaCodeActivityV2.this.f75754z);
            CaptchaCodeActivityV2.this.f75735g.setSelected(CaptchaCodeActivityV2.this.f75735g == CaptchaCodeActivityV2.this.f75754z);
            CaptchaCodeActivityV2.this.f75736h.setSelected(CaptchaCodeActivityV2.this.f75736h == CaptchaCodeActivityV2.this.f75754z);
            CaptchaCodeActivityV2.this.f75737i.setSelected(CaptchaCodeActivityV2.this.f75737i == CaptchaCodeActivityV2.this.f75754z);
            MenuListenEditText Dh = CaptchaCodeActivityV2.this.f75738j;
            if (CaptchaCodeActivityV2.this.f75738j != CaptchaCodeActivityV2.this.f75754z) {
                z12 = false;
            }
            Dh.setSelected(z12);
        }
    }

    public class f implements VerifyHelper.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f75765a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f75766b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75767c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f75768d;

        public f(String str, String str2, String str3, boolean z11) {
            this.f75765a = str;
            this.f75766b = str2;
            this.f75767c = str3;
            this.f75768d = z11;
        }

        public void a(int i11, int i12, Intent intent) {
            CaptchaCodeActivityV2.this.onActivityResult(i11, i12, intent);
        }

        public void b(int i11, HashMap<String, Object> hashMap) {
            if (i11 != 0) {
                CaptchaCodeActivityV2.this.Wh(hashMap, this.f75765a, this.f75766b, this.f75767c, (String) null, (String) null, this.f75768d);
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((UserRegisterV2Presenter) CaptchaCodeActivityV2.this.getPresenter()).w1();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class h implements CommonCaptchaDialog.CommonDialogClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f75771a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f75772b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75773c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f75774d;

        public h(String str, String str2, String str3, boolean z11) {
            this.f75771a = str;
            this.f75772b = str2;
            this.f75773c = str3;
            this.f75774d = z11;
        }

        public void onCommonDialogClick(Dialog dialog, int i11) {
            String obj = CaptchaCodeActivityV2.this.f75747s.getCaptchaEdit().getText().toString();
            if (!TextUtils.isEmpty(obj) && obj.length() >= 5) {
                CaptchaCodeActivityV2.this.showProgressDialog();
                CaptchaCodeActivityV2 captchaCodeActivityV2 = CaptchaCodeActivityV2.this;
                captchaCodeActivityV2.Wh((HashMap<String, Object>) null, this.f75771a, this.f75772b, this.f75773c, ((UserRegisterV2Presenter) captchaCodeActivityV2.getPresenter()).G0(), obj, this.f75774d);
            }
        }
    }

    public class i implements TextWatcher {
        public i() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() < 5) {
                CaptchaCodeActivityV2.this.f75747s.getRightBtn().setEnabled(false);
            } else {
                CaptchaCodeActivityV2.this.f75747s.getRightBtn().setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Mh(int i11) {
        ClipData primaryClip;
        ClipData.Item itemAt;
        if (i11 == 16908322) {
            try {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                if (!(clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null)) {
                    Vh(Pattern.compile("[^0-9]").matcher(itemAt.getText()).replaceAll("").trim());
                }
            } catch (Exception e11) {
                e11.toString();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oh(Dialog dialog, int i11) {
        this.f75747s.dismiss();
    }

    public static void Rh(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11, int i11, String str8) {
        Sh(activity, str, str2, str3, str4, str5, str6, str7, z11, i11, str8, 0);
    }

    public static void Sh(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11, int i11, String str8, int i12) {
        Intent intent = new Intent(activity, CaptchaCodeActivityV2.class);
        intent.putExtra("type", str);
        intent.putExtra(Constants.FLAG_ACCOUNT, str2);
        intent.putExtra("country_code", str3);
        intent.putExtra("country_id", str4);
        intent.putExtra("pw", str5);
        intent.putExtra("invite_code", str6);
        intent.putExtra("third_token", str7);
        intent.putExtra("key_version", z11);
        intent.putExtra("use_type", str8);
        intent.putExtra(InnerShareParams.SCENCE, i12);
        intent.putExtra("captcha_switch", i11);
        if (z11 || i11 != 0) {
            activity.startActivityForResult(intent, 124);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void Th(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11, String str8) {
        Sh(activity, str, str2, str3, str4, str5, str6, str7, z11, 0, str8, 0);
    }

    public static void Uh(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11, String str8, int i11) {
        Sh(activity, str, str2, str3, str4, str5, str6, str7, z11, 0, str8, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ((UserRegisterV2Presenter) getPresenter()).F1(this.f75749u, this.f75748t, true, Ih());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        new VerModeDialog(new c()).show(getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "注册页_重新获取验证码");
        gs.g.i("app_RegisterProcess_button_click", hashMap);
        gs.g.i("app_fill_in_code_regain_click", (HashMap) null);
        this.D = true;
        if (!Lh()) {
            ((UserRegisterV2Presenter) getPresenter()).F1(this.f75749u, this.f75748t, false, Ih());
        } else {
            ((UserRegisterV2Presenter) getPresenter()).C1(this.f75748t, false, Ih());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void B4() {
        finish();
    }

    public void B9() {
    }

    public final void Fh(MenuListenEditText menuListenEditText, EditText editText, EditText editText2) {
        menuListenEditText.addTextChangedListener(new b(editText, editText2));
        menuListenEditText.setCallback(new tn.e(this));
    }

    public void G0() {
    }

    public final void Gh() {
        this.f75733e.setText("");
        this.f75734f.setText("");
        this.f75735g.setText("");
        this.f75736h.setText("");
        this.f75737i.setText("");
        this.f75738j.setText("");
    }

    /* renamed from: Hh */
    public UserRegisterV2Presenter createPresenter() {
        String str;
        UserRegisterV2Presenter userRegisterV2Presenter = new UserRegisterV2Presenter();
        userRegisterV2Presenter.J1(this.f75742n);
        HashMap hashMap = new HashMap(4);
        hashMap.put("Page_name", "验证码验证页");
        hashMap.put("sign_type", Lh() ? "mail" : "tel");
        if (getIntent().getExtras().getString("third_token") != null) {
            str = "绑定账号";
        } else {
            str = this.C ? "验证码登录" : "忘记密码";
        }
        hashMap.put(InnerShareParams.SCENCE, str);
        gs.g.i("App_login_pageview", hashMap);
        return userRegisterV2Presenter;
    }

    public final int Ih() {
        return "RESET_PASSWORD_V2".equals(this.G) ? 3 : 1;
    }

    public void J8(AccountVerifyBean accountVerifyBean) {
        Intent intent = new Intent();
        intent.putExtra("AccountVerifyBean", accountVerifyBean);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: Jh */
    public UserRegisterV2Presenter.j getUI() {
        return this;
    }

    public void K0() {
        CommonCaptchaDialog commonCaptchaDialog = this.f75747s;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.dismiss();
        }
    }

    public final void Kh() {
        int childCount = this.f75752x.getChildCount();
        this.f75754z = null;
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            EditText editText = (EditText) this.f75752x.getChildAt(i11);
            if (TextUtils.isEmpty(editText.getText())) {
                editText.requestFocus();
                this.f75754z = editText;
                break;
            }
            i11++;
        }
        if (this.f75754z == null) {
            EditText editText2 = (EditText) this.f75752x.getChildAt(childCount - 1);
            this.f75754z = editText2;
            editText2.requestFocus();
            this.f75754z.setSelection(1);
        }
    }

    public final boolean Lh() {
        return "register_email".equals(this.f75742n);
    }

    public void Me(VerifyAuthCodeData verifyAuthCodeData) {
        Intent intent = new Intent();
        intent.putExtra("VerifyAuthCodeData", verifyAuthCodeData);
        setResult(-1, intent);
        finish();
    }

    public void Q0(Bitmap bitmap) {
        CommonCaptchaDialog commonCaptchaDialog = this.f75747s;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.getImageView().setImageBitmap(bitmap);
            this.f75747s.getCaptchaEdit().setText("");
        }
    }

    public final void Qh() {
        if (!Lh()) {
            this.f75741m.setVisibility(0);
            this.f75741m.setEnabled(true);
        }
        this.f75740l.setEnabled(true);
    }

    public void U8(HomeActivityEntityResponse homeActivityEntityResponse) {
    }

    public void V8(String str) {
        b2.a.d().a("/login/password_set_v2").withString("register_type", this.f75742n).withString("country_id", this.f75750v).withString("pw", this.f75751w).withString(Constants.FLAG_ACCOUNT, this.f75748t).withString("country_code", this.f75749u).withString("country_id", this.f75750v).withString("invite_code", this.B).withString("auth_token", str).withString(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, this.f75751w).withString("third_token", ((UserRegisterV2Presenter) getPresenter()).E0()).navigation();
        B4();
    }

    public void Vc() {
    }

    public final void Vh(CharSequence charSequence) {
        if (charSequence.length() > 0) {
            this.f75733e.setText(String.valueOf(charSequence.charAt(0)));
        }
        if (charSequence.length() > 1) {
            this.f75734f.setText(String.valueOf(charSequence.charAt(1)));
        }
        if (charSequence.length() > 2) {
            this.f75735g.setText(String.valueOf(charSequence.charAt(2)));
        }
        if (charSequence.length() > 3) {
            this.f75736h.setText(String.valueOf(charSequence.charAt(3)));
        }
        if (charSequence.length() > 4) {
            this.f75737i.setText(String.valueOf(charSequence.charAt(4)));
        }
        if (charSequence.length() > 5) {
            this.f75738j.setText(String.valueOf(charSequence.charAt(5)));
        }
        ai();
    }

    public final void Wh(HashMap<String, Object> hashMap, String str, String str2, String str3, String str4, String str5, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            int i11 = this.F + 1;
            this.F = i11;
            if (i11 == 2) {
                HashMap<String, Object> hashMap2 = hashMap;
                String str6 = str;
                ((UserRegisterV2Presenter) getPresenter()).H0(str, hashMap, str4, str5);
            } else {
                HashMap<String, Object> hashMap3 = hashMap;
                String str7 = str4;
                String str8 = str5;
                ((UserRegisterV2Presenter) getPresenter()).B1(str, hashMap, str4, str5, this.G, this.H);
            }
            Xh();
            return;
        }
        ((UserRegisterV2Presenter) getPresenter()).E1(str2, str3, hashMap, str4, str5, z11, this.G, this.H);
        if (z11) {
            Zh();
        } else {
            Xh();
        }
    }

    public final void Xh() {
        Gh();
        this.f75740l.setEnabled(false);
        this.f75741m.setEnabled(false);
        Yh(this.f75740l, this.f75743o, this.f75744p);
    }

    public final void Yh(TextView textView, String str, String str2) {
        this.f75745q.clear();
        a aVar = new a(textView, str2, str);
        bi(textView, false, "");
        this.f75745q.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(tn.g.f37267b).compose(RxJavaHelper.u(this, Schedulers.computation())).subscribe(aVar));
    }

    public final void Zh() {
        Gh();
        this.f75741m.setEnabled(false);
        this.f75740l.setEnabled(false);
        Yh(this.f75741m, getString(R.string.n_login_voice_verify_countdown), getString(R.string.n_login_not_received_sms_verify_new));
    }

    public void addEvent() {
        if (!Lh()) {
            this.f75741m.setOnClickListener(new tn.d(this));
        }
        this.f75753y.setOnClickListener(new tn.c(this));
        this.f75740l.setOnClickListener(new tn.b(this));
        this.f75730b.setOnClickListener(new tn.a(this));
        this.f75733e.setOnFocusChangeListener(this.K);
        this.f75734f.setOnFocusChangeListener(this.K);
        this.f75735g.setOnFocusChangeListener(this.K);
        this.f75736h.setOnFocusChangeListener(this.K);
        this.f75737i.setOnFocusChangeListener(this.K);
        this.f75738j.setOnFocusChangeListener(this.K);
        this.f75733e.setOnKeyListener(this.J);
        this.f75734f.setOnKeyListener(this.J);
        this.f75735g.setOnKeyListener(this.J);
        this.f75736h.setOnKeyListener(this.J);
        this.f75737i.setOnKeyListener(this.J);
        this.f75738j.setOnKeyListener(this.J);
    }

    public final void ai() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f75733e.getText().toString());
        sb2.append(this.f75734f.getText().toString());
        sb2.append(this.f75735g.getText().toString());
        sb2.append(this.f75736h.getText().toString());
        sb2.append(this.f75737i.getText().toString());
        sb2.append(this.f75738j.getText().toString());
        if (sb2.length() >= 6) {
            this.f75751w = sb2.toString();
            if ("RESET_PASSWORD_V2".equals(this.G)) {
                ((UserRegisterV2Presenter) getPresenter()).K1(this.f75748t, this.f75749u, this.f75751w);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.C) {
                if (Lh()) {
                    hashMap.put("email", this.f75748t);
                } else {
                    hashMap.put("country_code", this.f75749u);
                    hashMap.put(PlaceFields.PHONE, this.f75748t);
                }
                hashMap.put(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, this.f75751w);
                hashMap.put(VulcanInfo.VTOKEN, ku.b.e().h(this));
                ((UserRegisterV2Presenter) getPresenter()).M1(hashMap);
                return;
            }
            if (Lh()) {
                hashMap.put("email", this.f75748t);
            } else {
                hashMap.put("country_code", this.f75749u);
                hashMap.put(PlaceFields.PHONE, this.f75748t);
            }
            hashMap.put(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, this.f75751w);
            hashMap.put("register_type", Lh() ? "邮箱注册" : "手机注册");
            hashMap.put("regain_code", Boolean.valueOf(this.D));
            ((UserRegisterV2Presenter) getPresenter()).L1(hashMap);
        }
    }

    public final void bi(TextView textView, boolean z11, String str) {
        textView.setText(str);
        textView.setEnabled(z11);
    }

    public void c5(String str, String str2, String str3, String str4, boolean z11) {
        CommonCaptchaDialog commonCaptchaDialog = new CommonCaptchaDialog(this);
        this.f75747s = commonCaptchaDialog;
        commonCaptchaDialog.setTitle(getResources().getString(R.string.login_dialog_captcha_title));
        this.f75747s.setCancelText(getResources().getString(R.string.login_dialog_cancel));
        this.f75747s.setConfirmText(getResources().getString(R.string.login_dialog_confirm));
        this.f75747s.setCaptchaImage(str);
        this.f75747s.show();
        this.f75747s.getImageView().setOnClickListener(new g());
        this.f75747s.setCancelListener(new tn.f(this));
        this.f75747s.setConfirmListner(new h(str2, str3, str4, z11));
        this.f75747s.getCaptchaEdit().addTextChangedListener(new i());
    }

    public boolean canFullScreen() {
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 1) {
            if (keyCode == 66 || keyCode == 160) {
                ai();
            } else if (keyCode == 67) {
                View findFocus = this.f75752x.findFocus();
                int childCount = this.f75752x.getChildCount();
                if (findFocus != null) {
                    EditText editText = (EditText) findFocus;
                    int indexOfChild = this.f75752x.indexOfChild(editText);
                    if (indexOfChild == childCount - 1 && !TextUtils.isEmpty(editText.getText())) {
                        editText.setText("");
                        return true;
                    } else if (indexOfChild > 0 && TextUtils.isEmpty(editText.getText())) {
                        EditText editText2 = (EditText) this.f75752x.getChildAt(indexOfChild - 1);
                        editText2.setText("");
                        editText2.requestFocus();
                        return true;
                    }
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void e7(String str) {
    }

    public void g6() {
    }

    public int getContentView() {
        return R.layout.activity_register_captcha_v2;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public void initView() {
        this.f75742n = getIntent().getStringExtra("type");
        this.f75748t = getIntent().getStringExtra(Constants.FLAG_ACCOUNT);
        this.f75749u = getIntent().getStringExtra("country_code");
        this.f75750v = getIntent().getStringExtra("country_id");
        this.A = getIntent().getStringExtra("pw");
        this.B = getIntent().getStringExtra("invite_code");
        this.C = getIntent().getBooleanExtra("key_version", false);
        this.G = getIntent().getStringExtra("use_type");
        this.H = getIntent().getIntExtra(InnerShareParams.SCENCE, 0);
        this.I = getIntent().getIntExtra("captcha_switch", 0);
        this.f75730b = findViewById(R.id.closeBtn);
        this.f75731c = (TextView) findViewById(R.id.captchaTitle);
        this.f75732d = (TextView) findViewById(R.id.captchaTips);
        MenuListenEditText menuListenEditText = (MenuListenEditText) findViewById(R.id.captchaText1);
        this.f75733e = menuListenEditText;
        menuListenEditText.setSelected(true);
        this.f75734f = (MenuListenEditText) findViewById(R.id.captchaText2);
        this.f75735g = (MenuListenEditText) findViewById(R.id.captchaText3);
        this.f75736h = (MenuListenEditText) findViewById(R.id.captchaText4);
        this.f75737i = (MenuListenEditText) findViewById(R.id.captchaText5);
        this.f75738j = (MenuListenEditText) findViewById(R.id.captchaText6);
        this.f75739k = (TextView) findViewById(R.id.captcha_error);
        this.f75740l = (TextView) findViewById(R.id.countDownText);
        this.f75741m = (TextView) findViewById(R.id.voiceCaptchaText);
        this.f75752x = (LinearLayout) findViewById(R.id.captchaTextGroup);
        TextView textView = (TextView) findViewById(R.id.tv_captcha_switch_auth);
        this.f75753y = textView;
        textView.setVisibility(this.I != 0 ? 0 : 8);
        this.E = findViewById(R.id.viewContent);
        Fh(this.f75733e, (EditText) null, this.f75734f);
        Fh(this.f75734f, this.f75733e, this.f75735g);
        Fh(this.f75735g, this.f75734f, this.f75736h);
        Fh(this.f75736h, this.f75735g, this.f75737i);
        Fh(this.f75737i, this.f75736h, this.f75738j);
        Fh(this.f75738j, this.f75737i, (EditText) null);
        String string = getResources().getString(R.string.n_register_send_code);
        if (Lh()) {
            this.f75731c.setText(getString(R.string.n_login_code_email));
            SpannableString spannableString = new SpannableString(string + " " + this.f75748t);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.baseColorSecondaryText)), 0, string.length(), 33);
            this.f75732d.setText(spannableString);
            this.f75743o = getString(R.string.n_register_resend_code) + "(%dS)";
            this.f75744p = getString(R.string.n_register_resend_code);
            this.f75741m.setVisibility(8);
        } else {
            this.f75731c.setText(getString(R.string.n_login_code_sms));
            SpannableString spannableString2 = new SpannableString(string + " " + String.format("%s %s", new Object[]{this.f75749u.replace("00", "+"), this.f75748t}));
            spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.baseColorSecondaryText)), 0, string.length(), 33);
            this.f75732d.setText(spannableString2);
            this.f75743o = getString(R.string.n_register_resend_code) + "(%dS)";
            this.f75744p = getString(R.string.n_register_resend_code);
            this.f75741m.setVisibility(8);
        }
        Xh();
        this.f75746r = new VerifyHelper();
        Kh();
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", "注册页_输入验证码页");
        gs.g.i("App_PageView", hashMap);
    }

    public void lg() {
    }

    public void ob(String str, HashMap<String, Object> hashMap, String str2, String str3) {
        ((UserRegisterV2Presenter) getPresenter()).B1(str, hashMap, str2, str3, this.G, this.H);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        this.f75746r.y(i11, i12, intent);
    }

    public void onDestroy() {
        this.f75745q.clear();
        super.onDestroy();
    }

    public void q1(String str) {
    }

    public void q4(String str, String str2, String str3, boolean z11, RiskControl riskControl) {
        this.f75746r.m(this, !TextUtils.isEmpty(str) ? str : str3, MiPushClient.COMMAND_REGISTER, riskControl, new f(str, str2, str3, z11));
    }

    public void se(String str) {
        this.f75739k.setText(str);
        this.f75733e.setBackgroundResource(R.drawable.login_input_error_bg);
        this.f75734f.setBackgroundResource(R.drawable.login_input_error_bg);
        this.f75735g.setBackgroundResource(R.drawable.login_input_error_bg);
        this.f75736h.setBackgroundResource(R.drawable.login_input_error_bg);
        this.f75737i.setBackgroundResource(R.drawable.login_input_error_bg);
        this.f75738j.setBackgroundResource(R.drawable.login_input_error_bg);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
