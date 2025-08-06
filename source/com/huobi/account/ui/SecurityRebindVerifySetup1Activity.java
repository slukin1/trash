package com.huobi.account.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.places.model.PlaceFields;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.presenter.SecurityRebindVerifySetup1Presenter;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import f6.c;
import gs.g;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;
import q6.d;
import sn.w;
import tq.p;

public class SecurityRebindVerifySetup1Activity extends BaseActivity<SecurityRebindVerifySetup1Presenter, SecurityRebindVerifySetup1Presenter.f> implements SecurityRebindVerifySetup1Presenter.f {
    public View A;
    public View B;
    public View C;
    public View D;
    public View E;
    public View F;
    public View G;
    public View H;
    public ImageView I;
    public ImageView J;
    public boolean K;
    public Security2FADialogHelper L;
    public TextWatcher M = new a();

    /* renamed from: b  reason: collision with root package name */
    public int f41332b;

    /* renamed from: c  reason: collision with root package name */
    public String f41333c;

    /* renamed from: d  reason: collision with root package name */
    public String f41334d;

    /* renamed from: e  reason: collision with root package name */
    public String f41335e;

    /* renamed from: f  reason: collision with root package name */
    public String f41336f;

    /* renamed from: g  reason: collision with root package name */
    public String f41337g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f41338h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f41339i;

    /* renamed from: j  reason: collision with root package name */
    public EditText f41340j;

    /* renamed from: k  reason: collision with root package name */
    public EditText f41341k;

    /* renamed from: l  reason: collision with root package name */
    public EditText f41342l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f41343m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f41344n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f41345o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f41346p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f41347q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f41348r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f41349s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f41350t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f41351u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f41352v;

    /* renamed from: w  reason: collision with root package name */
    public View f41353w;

    /* renamed from: x  reason: collision with root package name */
    public View f41354x;

    /* renamed from: y  reason: collision with root package name */
    public View f41355y;

    /* renamed from: z  reason: collision with root package name */
    public View f41356z;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            SecurityRebindVerifySetup1Activity.this.Gh();
        }
    }

    public class b extends Security2FADialogHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41358a;

        public b(String str) {
            this.f41358a = str;
        }

        public void onFailed(String str) {
        }

        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
            super.onSuccess(authResult);
            SecurityRebindVerifySetup1Activity.this.ii(this.f41358a, authResult.getEmailCode(), authResult.getSmsCode(), authResult.getGaCode(), authResult.passkey);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh(View view, boolean z11) {
        this.A.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mh(View view, boolean z11) {
        this.B.setSelected(z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        Intent intent = new Intent(this, CountryAreaSelectActivityV2.class);
        intent.putExtra("choose_type", "choose_type_code");
        intent.putExtra("SHOW_COUNTRY_ICON", true);
        intent.putExtra("SHOW_ALL_COUNTRY", true);
        startActivityForResult(intent, 1001);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        this.G.setVisibility(8);
        this.f41350t.setText(R.string.n_security_bar);
        g.i("APP_set_security_button_click", new HashMap<String, Object>() {
            {
                put("button_name", "20");
            }
        });
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ph(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(this.f41352v.getText(), this.f41352v.getText()));
            HuobiToastUtil.s(R.string.security_ga_key_already_copy);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qh(View view, boolean z11) {
        this.C.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Rh(View view, boolean z11) {
        this.D.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sh(View view, boolean z11) {
        this.E.setSelected(z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Th(View view) {
        ClipData primaryClip = ((ClipboardManager) this.f41343m.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null || itemAt.getText() == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String charSequence = itemAt.getText().toString();
        if (charSequence != null && TextUtils.isDigitsOnly(charSequence)) {
            this.f41340j.setText(charSequence);
            EditText editText = this.f41340j;
            editText.setSelection(editText.getText().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Uh(View view) {
        if (this.f41338h.getText() == null || this.f41338h.getText().length() == 0) {
            HuobiToastUtil.j(R.string.n_login_phone_input_placeholder);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.K = true;
        this.f41334d = this.f41338h.getText().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "REBIND_PHONE");
        hashMap.put("country_code", this.f41333c);
        hashMap.put(PlaceFields.PHONE, this.f41334d);
        hashMap.put("voice", Boolean.FALSE);
        ((SecurityRebindVerifySetup1Presenter) getPresenter()).w0(hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Vh(View view) {
        if (this.f41341k.getText() == null || this.f41341k.getText().length() == 0) {
            HuobiToastUtil.j(R.string.n_login_email_input_placeholder);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (StringUtils.o(this.f41341k.getText().toString())) {
            this.K = true;
            this.f41335e = this.f41341k.getText().toString();
            HashMap hashMap = new HashMap();
            hashMap.put("use_type", "REBIND_EMAIL");
            hashMap.put("email", this.f41335e);
            ((SecurityRebindVerifySetup1Presenter) getPresenter()).v0(hashMap);
            Gh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wh(View view) {
        doFinish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xh(View view) {
        int i11 = this.f41332b;
        if (i11 == 1) {
            ((SecurityRebindVerifySetup1Presenter) getPresenter()).u0(this.f41334d, this.f41339i.getText().toString(), this.f41333c);
        } else if (i11 == 2) {
            ((SecurityRebindVerifySetup1Presenter) getPresenter()).s0(this.f41335e, this.f41342l.getText().toString());
        } else if (i11 == 3) {
            this.f41336f = this.f41340j.getText().toString();
            ((SecurityRebindVerifySetup1Presenter) getPresenter()).t0(this.f41336f);
        }
        g.i("APP_set_security_button_click", new HashMap<String, Object>() {
            {
                if (SecurityRebindVerifySetup1Activity.this.f41332b == 1) {
                    put("button_name", "14");
                } else if (SecurityRebindVerifySetup1Activity.this.f41332b == 2) {
                    put("button_name", "17");
                } else {
                    put("button_name", "21");
                }
            }
        });
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yh(CountryListData countryListData) {
        this.f41333c = countryListData.a();
        this.f41337g = String.valueOf(countryListData.c());
        this.f41348r.setText(String.valueOf(this.f41333c.replace("00", "+")));
        ji(this.f41337g);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zh(Object obj) {
        getUI().V1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bi(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(Object obj) {
        getUI().V1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(Object obj) {
        getUI().V1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hi(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    public final void Fh(Security2FADialogHelper.PasskeyAuth passkeyAuth, Map<String, Object> map) {
        if (map != null && passkeyAuth != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("raw_authenticator_data", passkeyAuth.rawAuthData);
            hashMap.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, passkeyAuth.signature);
            hashMap.put("client_data", passkeyAuth.clientData);
            hashMap.put("credential_id", passkeyAuth.credentialId);
            hashMap.put("user_handle", passkeyAuth.userHandle);
            map.put("passkey", hashMap);
        }
    }

    public void G5(String str) {
        this.L.N(false);
        this.L.R(new b(str));
    }

    public final void Gh() {
        int i11 = this.f41332b;
        boolean z11 = true;
        if (i11 != 1 ? i11 != 2 ? this.f41340j.getText() == null || this.f41340j.getText().length() != 6 : this.f41341k.getText() == null || !StringUtils.o(this.f41341k.getText().toString()) || this.f41342l.getText() == null || this.f41342l.getText().length() != 6 || !this.K : TextUtils.isEmpty(this.f41333c) || this.f41338h.getText() == null || this.f41338h.getText().length() < 5 || this.f41339i.getText() == null || this.f41339i.getText().length() != 6 || !this.K) {
            z11 = false;
        }
        this.f41349s.setEnabled(z11);
    }

    /* renamed from: Hh */
    public SecurityRebindVerifySetup1Presenter createPresenter() {
        return new SecurityRebindVerifySetup1Presenter();
    }

    /* renamed from: Ih */
    public SecurityRebindVerifySetup1Presenter.f getUI() {
        return this;
    }

    public final String Jh() {
        int i11 = this.f41332b;
        if (i11 == 1) {
            return "VERIFY_SETTING_POLICY_REBIND_PHONE";
        }
        return i11 == 2 ? "VERIFY_SETTING_POLICY_REBIND_EMAIL" : "VERIFY_SETTING_POLICY_REBIND_GA";
    }

    public final void Kh() {
        if (getIntent() != null) {
            this.f41332b = getIntent().getIntExtra("LINK_TYPE_KEY", 0);
        }
        int i11 = this.f41332b;
        if (i11 == 1) {
            this.f41353w.setVisibility(0);
        } else if (i11 == 2) {
            this.f41354x.setVisibility(0);
        } else if (i11 == 3) {
            this.f41355y.setVisibility(0);
            this.G.setVisibility(0);
            this.f41350t.setText(R.string.n_security_bar_ga);
            ((SecurityRebindVerifySetup1Presenter) getPresenter()).d0();
        }
        w.j().h(this).subscribe(d.c(this, new v1(this)));
        Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(this, this, Jh());
        this.L = security2FADialogHelper;
        security2FADialogHelper.M(true);
    }

    public final Bitmap S6(String str, int i11, int i12) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
                    hashMap.put(EncodeHintType.MARGIN, 0);
                    BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i11, i12, hashMap);
                    int[] iArr = new int[(i11 * i12)];
                    for (int i13 = 0; i13 < i12; i13++) {
                        for (int i14 = 0; i14 < i11; i14++) {
                            if (encode.get(i14, i13)) {
                                iArr[(i13 * i11) + i14] = -16777216;
                            } else {
                                iArr[(i13 * i11) + i14] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.RGB_565);
                    createBitmap.setPixels(iArr, 0, i11, 0, 0, i11, i12);
                    return createBitmap;
                }
            } catch (WriterException e11) {
                i6.d.g(e11);
            }
        }
        return null;
    }

    public void V1() {
        String str;
        int i11 = this.f41332b;
        if (i11 == 1) {
            str = getString(R.string.n_security_success_phone);
        } else if (i11 == 2) {
            str = getString(R.string.n_security_success_mail);
        } else {
            str = getString(R.string.n_security_success_ga);
        }
        Toast.makeText(this, str, 0).show();
        startActivity(k0.h(this));
        g.i("APP_set_security_button_click", new HashMap<String, Object>() {
            {
                if (SecurityRebindVerifySetup1Activity.this.f41332b == 1) {
                    put("button_name", "15");
                } else if (SecurityRebindVerifySetup1Activity.this.f41332b == 2) {
                    put("button_name", "18");
                } else {
                    put("button_name", "22");
                }
            }
        });
    }

    public void addEvent() {
        this.f41338h.setOnFocusChangeListener(new u1(this));
        this.f41339i.setOnFocusChangeListener(new t1(this));
        this.f41340j.setOnFocusChangeListener(new s1(this));
        this.f41341k.setOnFocusChangeListener(new n2(this));
        this.f41342l.setOnFocusChangeListener(new m2(this));
        this.f41338h.addTextChangedListener(this.M);
        this.f41339i.addTextChangedListener(this.M);
        this.f41341k.addTextChangedListener(this.M);
        this.f41342l.addTextChangedListener(this.M);
        this.f41340j.addTextChangedListener(this.M);
        this.f41343m.setOnClickListener(new g2(this));
        this.f41344n.setOnClickListener(new k2(this));
        this.f41346p.setOnClickListener(new h2(this));
        this.F.setOnClickListener(new l2(this));
        this.f41349s.setOnClickListener(new c2(this));
        this.f41356z.setOnClickListener(new j2(this));
        this.f41351u.setOnClickListener(new i2(this));
        this.H.setOnClickListener(new r1(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public void e2(boolean z11, String str) {
        if (z11) {
            this.f41346p.setVisibility(0);
            this.f41347q.setVisibility(8);
            return;
        }
        this.f41346p.setVisibility(8);
        this.f41347q.setVisibility(0);
        this.f41347q.setText(str);
    }

    public int getContentView() {
        return R.layout.activity_security_rebind_verify_setup1;
    }

    public void h3(boolean z11, String str) {
        if (z11) {
            this.f41344n.setVisibility(0);
            this.f41345o.setVisibility(8);
            return;
        }
        this.f41344n.setVisibility(8);
        this.f41345o.setVisibility(0);
        this.f41345o.setText(str);
    }

    public void ii(String str, String str2, String str3, String str4, Security2FADialogHelper.PasskeyAuth passkeyAuth) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        int i11 = this.f41332b;
        if (i11 == 1) {
            hashMap.put("new_country_code", this.f41333c);
            hashMap.put("new_phone", this.f41334d);
            hashMap.put("new_phone_token", str);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("old_sms_code", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("ga_code", str4);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("email_code", str2);
            }
            Fh(passkeyAuth, hashMap);
            UserCenterRemoteDataSource.A().rebindPhone(hashMap).compose(p.c0()).compose(RxJavaHelper.t(getUI())).subscribe(d.d(getUI(), new a2(this), d2.f41664b, new y1(this)));
        } else if (i11 == 2) {
            hashMap.put("new_email", this.f41335e);
            hashMap.put("new_email_token", str);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("sms_code", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("ga_code", str4);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("email_code", str2);
            }
            Fh(passkeyAuth, hashMap);
            UserCenterRemoteDataSource.A().rebindEmail(hashMap).compose(p.c0()).compose(RxJavaHelper.t(getUI())).subscribe(d.d(getUI(), new b2(this), f2.f41680b, new x1(this)));
        } else {
            hashMap.put("new_ga_code", this.f41336f);
            hashMap.put("ga_token", str);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("sms_code", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("old_ga_code", str4);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("email_code", str2);
            }
            Fh(passkeyAuth, hashMap);
            UserCenterRemoteDataSource.A().rebindGa(hashMap).compose(p.c0()).compose(RxJavaHelper.t(getUI())).subscribe(d.d(getUI(), new z1(this), e2.f41672b, new w1(this)));
        }
    }

    public void initView() {
        this.f41353w = this.viewFinder.b(R.id.phoneContent);
        this.f41354x = this.viewFinder.b(R.id.emailContent);
        this.f41355y = this.viewFinder.b(R.id.gaContent);
        this.f41338h = (EditText) this.viewFinder.b(R.id.phoneEdit);
        this.A = this.viewFinder.b(R.id.phoneEditFrame);
        this.f41339i = (EditText) this.viewFinder.b(R.id.phoneCodeEdit);
        this.B = this.viewFinder.b(R.id.phoneCodeEditFrame);
        this.f41340j = (EditText) this.viewFinder.b(R.id.gaEdit);
        this.C = this.viewFinder.b(R.id.gaEditFrame);
        this.f41341k = (EditText) this.viewFinder.b(R.id.emailEdit);
        this.D = this.viewFinder.b(R.id.emailEditFrame);
        this.f41342l = (EditText) this.viewFinder.b(R.id.emailCodeEdit);
        this.E = this.viewFinder.b(R.id.emailCodeEditFrame);
        this.f41343m = (TextView) this.viewFinder.b(R.id.gaPaste);
        this.f41344n = (TextView) this.viewFinder.b(R.id.phoneSend);
        this.f41345o = (TextView) this.viewFinder.b(R.id.phoneCountDown);
        this.f41346p = (TextView) this.viewFinder.b(R.id.emailSend);
        this.f41347q = (TextView) this.viewFinder.b(R.id.emailCountDown);
        this.f41356z = this.viewFinder.b(R.id.selectCountryCode);
        this.f41348r = (TextView) this.viewFinder.b(R.id.countryCode);
        this.I = (ImageView) this.viewFinder.b(R.id.ivCountryIcon);
        this.F = this.viewFinder.b(R.id.closeBtn);
        this.f41349s = (TextView) this.viewFinder.b(R.id.submit);
        this.G = this.viewFinder.b(R.id.gaArea);
        this.f41350t = (TextView) this.viewFinder.b(R.id.title);
        this.f41351u = (TextView) this.viewFinder.b(R.id.gaNext);
        this.J = (ImageView) this.viewFinder.b(R.id.securityGa);
        this.f41352v = (TextView) this.viewFinder.b(R.id.gaKey);
        this.H = this.viewFinder.b(R.id.saveGaKey);
    }

    public final void ji(String str) {
        c.a().l(this, w.e(str), this.I, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1001 && intent != null) {
            this.f41333c = intent.getStringExtra("phone_area_code");
            String stringExtra = intent.getStringExtra("country_area_code");
            this.f41337g = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                ji(this.f41337g);
            }
            String str = this.f41333c;
            if (str != null) {
                this.f41348r.setText(String.valueOf(str.replace("00", "+")));
            }
            Gh();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Kh();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void w(GaGenerateData gaGenerateData) {
        if (gaGenerateData != null) {
            String gaKey = gaGenerateData.getGaKey();
            String loginName = gaGenerateData.getLoginName();
            this.f41352v.setText(gaKey);
            this.J.setImageBitmap(S6(getString(R.string.ga_key_format, new Object[]{loginName, gaKey}), PixelUtils.a(175.0f), PixelUtils.a(175.0f)));
            this.f41351u.setEnabled(true);
        }
    }
}
