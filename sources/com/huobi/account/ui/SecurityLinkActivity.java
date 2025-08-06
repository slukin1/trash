package com.huobi.account.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.presenter.SecurityLinkPresenter;
import com.huobi.activity.CountryAreaSelectActivity;
import com.huobi.kyc.ui.VerificationTipsDialog;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.utils.a0;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.d;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;

public class SecurityLinkActivity extends BaseActivity<SecurityLinkPresenter, SecurityLinkPresenter.d> implements SecurityLinkPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public String f41246b;

    /* renamed from: c  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f41247c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f41248d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41249e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41250f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41251g;

    /* renamed from: h  reason: collision with root package name */
    public SecurityLinkPresenter f41252h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f41253i;

    /* renamed from: j  reason: collision with root package name */
    public int f41254j;

    /* renamed from: k  reason: collision with root package name */
    public int f41255k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f41256l;

    /* renamed from: m  reason: collision with root package name */
    public int f41257m;

    /* renamed from: n  reason: collision with root package name */
    public String f41258n;

    /* renamed from: o  reason: collision with root package name */
    public String f41259o;

    /* renamed from: p  reason: collision with root package name */
    public ClearEditText f41260p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f41261q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f41262r;

    /* renamed from: s  reason: collision with root package name */
    public String f41263s;

    /* renamed from: t  reason: collision with root package name */
    public String f41264t = "00852";

    /* renamed from: u  reason: collision with root package name */
    public String f41265u = "71";

    /* renamed from: v  reason: collision with root package name */
    public TextView f41266v;

    /* renamed from: w  reason: collision with root package name */
    public String f41267w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f41268x;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityLinkActivity.this.f41255k = editable.length();
            SecurityLinkActivity.this.zh();
            if (SecurityLinkActivity.this.f41255k > 0 && !SecurityLinkActivity.this.f41260p.getTypeface().isBold()) {
                SecurityLinkActivity.this.f41260p.setTypeface(ResourcesCompat.h(SecurityLinkActivity.this.f41260p.getContext(), R.font.roboto_medium));
            } else if (SecurityLinkActivity.this.f41255k == 0) {
                SecurityLinkActivity.this.f41260p.setTypeface(ResourcesCompat.h(SecurityLinkActivity.this.f41260p.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityLinkActivity.this.f41254j = editable.length();
            SecurityLinkActivity.this.yh();
            if (SecurityLinkActivity.this.f41254j > 0 && !SecurityLinkActivity.this.f41253i.getTypeface().isBold()) {
                SecurityLinkActivity.this.f41253i.setTypeface(ResourcesCompat.h(SecurityLinkActivity.this.f41253i.getContext(), R.font.roboto_medium));
            } else if (SecurityLinkActivity.this.f41254j == 0) {
                SecurityLinkActivity.this.f41253i.setTypeface(ResourcesCompat.h(SecurityLinkActivity.this.f41253i.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hh(View view) {
        String trim = this.f41253i.getText().toString().trim();
        if (!StringUtils.o(trim)) {
            HuobiToastUtil.j(R.string.setting_email_address_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f41252h.W(trim);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ih(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(this.f41249e.getText(), this.f41249e.getText()));
            HuobiToastUtil.s(R.string.security_ga_key_already_copy);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        Intent intent = new Intent(this, SecurityLinkStep2Activity.class);
        intent.putExtra("LINK_TYPE_KEY", this.f41257m);
        intent.putExtra("BIND_PHONE_KEY", this.f41258n);
        intent.putExtra("BIND_EMAIL_KEY", this.f41259o);
        intent.putExtra("from_otc_trade_set", getIntent().getBooleanExtra("from_otc_trade_set", false));
        startActivity(intent);
        g.i("app_GA_binding_next_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        if ("--".equals(this.f41264t)) {
            HuobiToastUtil.j(R.string.register_country_code_empty_tips);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String trim = this.f41260p.getText().toString().trim();
        if (trim.length() < 5) {
            HuobiToastUtil.j(R.string.setting_phone_number_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f41252h.X(this.f41264t, trim);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        Intent intent = new Intent(this, CountryAreaSelectActivity.class);
        intent.putExtra("choose_type", "choose_type_code");
        startActivityForResult(intent, 1001);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        doFinish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(VerificationTipsDialog verificationTipsDialog, View view) {
        HBBaseWebActivity.showWebView(this, a0.v(), (String) null, (String) null, false);
        verificationTipsDialog.doDismiss();
        is.a.j("5986", (Map<String, Object>) null, (String) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(VerificationTipsDialog verificationTipsDialog, View view) {
        String str;
        if (KycProxy.l().p() != 2) {
            str = a0.d();
        } else {
            str = a0.c();
        }
        HBBaseWebActivity.showWebView(this, str, (String) null, (String) null, false);
        verificationTipsDialog.doDismiss();
        is.a.j("5987", (Map<String, Object>) null, (String) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ph(VerificationTipsDialog verificationTipsDialog, View view) {
        HBBaseWebActivity.showWebView(this, a0.w(), (String) null, (String) null, false);
        verificationTipsDialog.doDismiss();
        is.a.j("5964", (Map<String, Object>) null, (String) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qh(VerificationTipsDialog verificationTipsDialog, View view) {
        String str;
        if (KycProxy.l().p() != 2) {
            str = a0.d();
        } else {
            str = a0.c();
        }
        HBBaseWebActivity.showWebView(this, str, (String) null, (String) null, false);
        verificationTipsDialog.doDismiss();
        is.a.j("5965", (Map<String, Object>) null, (String) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ah */
    public SecurityLinkPresenter createPresenter() {
        SecurityLinkPresenter securityLinkPresenter = new SecurityLinkPresenter();
        this.f41252h = securityLinkPresenter;
        securityLinkPresenter.Z(this.f41257m);
        this.f41252h.Y(this.f41258n, this.f41259o);
        this.f41247c = new SecurityStrategyBottomMenuFragment();
        return this.f41252h;
    }

    /* renamed from: Bh */
    public SecurityLinkPresenter.d getUI() {
        return this;
    }

    public final void Ch() {
        this.f41263s = getString(R.string.register_default_country_name);
        this.f41264t = getString(R.string.register_default_country_code);
        this.f41265u = getString(R.string.register_default_country_id);
        this.f41266v.setText(String.valueOf(this.f41264t.replace("00", "+")));
    }

    public final void Dh() {
        this.viewFinder.b(R.id.rl_email_area).setVisibility(0);
        EditText editText = (EditText) this.viewFinder.b(R.id.et_email_input);
        this.f41253i = editText;
        this.f41256l = this.f41268x;
        editText.addTextChangedListener(new b());
        this.f41256l.setOnClickListener(new v0(this));
    }

    public final void Eh() {
        this.viewFinder.b(R.id.rl_ga_area).setVisibility(0);
        this.viewFinder.b(R.id.tv_ga_msg);
        this.f41248d = (ImageView) this.viewFinder.b(R.id.iv_security_ga);
        this.f41249e = (TextView) this.viewFinder.b(R.id.tv_ga_key);
        this.f41250f = (TextView) this.viewFinder.b(R.id.tv_save_ga_key);
        TextView textView = this.f41268x;
        this.f41251g = textView;
        textView.setText(getResources().getString(R.string.n_go_verify));
        this.f41251g.setEnabled(true);
        this.f41250f.setOnClickListener(new r0(this));
        this.f41251g.setOnClickListener(new s0(this));
    }

    public void F5() {
        VerificationTipsDialog verificationTipsDialog = new VerificationTipsDialog();
        verificationTipsDialog.setContent(getString(R.string.n_verification_phone_error_tips_email_bound));
        verificationTipsDialog.vh(new VerificationTipsDialog.a[]{new VerificationTipsDialog.a(R.drawable.ic_verification_email_icon, getString(R.string.n_verification_phone_error_tips_unbind_email), getString(R.string.n_verification_submit_apply), new x0(this, verificationTipsDialog)), new VerificationTipsDialog.a(R.drawable.ic_verification_account_icon, getString(R.string.n_verification_phone_error_tips_destroy_account), getString(R.string.n_verification_submit_apply), new w0(this, verificationTipsDialog))});
        verificationTipsDialog.show(getSupportFragmentManager(), "UnBindEmailTipsDialogTag");
        is.a.s("5988", (String) null, false, (String) null, (Map<String, Object>) null);
    }

    public final void Fh() {
        this.viewFinder.b(R.id.rl_phone_area).setVisibility(0);
        this.f41260p = (ClearEditText) this.viewFinder.b(R.id.ct_phone_edit);
        this.f41262r = (TextView) this.viewFinder.b(R.id.tv_country_code);
        this.f41266v = (TextView) this.viewFinder.b(R.id.tv_country_code);
        this.f41261q = this.f41268x;
        this.f41260p.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        this.f41260p.addTextChangedListener(new a());
        this.f41261q.setOnClickListener(new t0(this));
        this.f41262r.setOnClickListener(new u0(this));
        Ch();
    }

    public final void Gh() {
        HbTitleBar hbTitleBar = (HbTitleBar) this.viewFinder.b(R.id.hb_title_bar_securyti_link);
        hbTitleBar.setTitle(this.f41267w);
        hbTitleBar.setOnClickBackListener(new q0(this));
    }

    public void Kg(String str, String str2) {
        Intent intent = new Intent(this, SecurityLinkStep2Activity.class);
        intent.putExtra("LINK_TYPE_KEY", this.f41257m);
        intent.putExtra("LINK_PHONE_KEY", this.f41260p.getText().toString().trim());
        intent.putExtra("COUNTRY_CODE", str);
        intent.putExtra("BIND_PHONE_KEY", this.f41258n);
        intent.putExtra("BIND_EMAIL_KEY", this.f41259o);
        intent.putExtra("otc_bind_phone_action", this.f41246b);
        intent.putExtra("from_otc_trade_set", getIntent().getBooleanExtra("from_otc_trade_set", false));
        startActivity(intent);
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
                d.g(e11);
            }
        }
        return null;
    }

    public void addEvent() {
    }

    public boolean canFullScreen() {
        return true;
    }

    public void doFinish() {
        super.doFinish();
        g.i("app_GA_binding_back_click", (HashMap) null);
    }

    public int getContentView() {
        return R.layout.activity_securyity_link;
    }

    public void initView() {
        this.f41257m = getIntent().getIntExtra("LINK_TYPE_KEY", -1);
        this.f41258n = getIntent().getStringExtra("BIND_PHONE_KEY");
        this.f41259o = getIntent().getStringExtra("BIND_EMAIL_KEY");
        this.f41246b = getIntent().getStringExtra("otc_bind_phone_action");
        this.f41268x = (TextView) this.viewFinder.b(R.id.btn_action);
        int i11 = this.f41257m;
        if (i11 == 2) {
            this.f41267w = getString(R.string.title_link, new Object[]{getString(R.string.security_email_title)});
            Dh();
        } else if (i11 == 3) {
            this.f41267w = getString(R.string.title_link, new Object[]{getString(R.string.title_ga)});
            Eh();
        } else if (i11 == 1) {
            this.f41267w = getString(R.string.title_link, new Object[]{getString(R.string.security_phone_title)});
            Fh();
        }
        Gh();
        g.i("app_GA_binding_view", (HashMap) null);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1001 && intent != null) {
            this.f41263s = intent.getStringExtra("country_name");
            this.f41264t = intent.getStringExtra("phone_area_code");
            this.f41265u = intent.getStringExtra("country_area_code");
            this.f41266v.setText(String.valueOf(this.f41264t).replace("00", "+"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void r8() {
        VerificationTipsDialog verificationTipsDialog = new VerificationTipsDialog();
        verificationTipsDialog.setContent(getString(R.string.n_verification_phone_error_tips_phone_bound));
        verificationTipsDialog.vh(new VerificationTipsDialog.a[]{new VerificationTipsDialog.a(R.drawable.ic_verification_phone_icon, getString(R.string.n_verification_phone_error_tips_unbind_phone), getString(R.string.n_verification_submit_apply), new z0(this, verificationTipsDialog)), new VerificationTipsDialog.a(R.drawable.ic_verification_account_icon, getString(R.string.n_verification_phone_error_tips_destroy_account), getString(R.string.n_verification_submit_apply), new y0(this, verificationTipsDialog))});
        verificationTipsDialog.show(getSupportFragmentManager(), "UnBindPhoneTipsDialogTag");
        is.a.s("5956", (String) null, false, (String) null, (Map<String, Object>) null);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void w(GaGenerateData gaGenerateData) {
        String gaKey = gaGenerateData.getGaKey();
        String loginName = gaGenerateData.getLoginName();
        this.f41249e.setText(gaKey);
        this.f41248d.setImageBitmap(S6(getString(R.string.ga_key_format, new Object[]{loginName, gaKey}), PixelUtils.a(175.0f), PixelUtils.a(175.0f)));
        this.f41250f.setVisibility(0);
    }

    public void w7(String str) {
        Intent intent = new Intent(this, SecurityLinkStep2Activity.class);
        intent.putExtra("LINK_TYPE_KEY", this.f41257m);
        intent.putExtra("LINK_EMAIL_ADDRESSS_KEY", str);
        intent.putExtra("BIND_PHONE_KEY", this.f41258n);
        intent.putExtra("BIND_EMAIL_KEY", this.f41259o);
        intent.putExtra("from_otc_trade_set", getIntent().getBooleanExtra("from_otc_trade_set", false));
        startActivity(intent);
    }

    public final void yh() {
        this.f41256l.setEnabled(this.f41254j > 0);
    }

    public final void zh() {
        this.f41261q.setEnabled(this.f41255k > 0);
    }
}
