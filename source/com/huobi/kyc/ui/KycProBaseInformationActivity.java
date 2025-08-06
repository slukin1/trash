package com.huobi.kyc.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.kyc.bean.CountryKyc;
import com.huobi.kyc.presenter.KycProBaseInformationPresenter;
import com.huobi.kyc.ui.VerificationTipsDialog;
import com.huobi.kyc.util.KycProxy;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import pro.huobi.R;
import um.d;
import um.e;
import um.f;
import um.g;
import um.h;
import um.i;
import um.j;
import um.k;
import um.l;
import um.m;

public class KycProBaseInformationActivity extends BaseActivity<KycProBaseInformationPresenter, KycProBaseInformationPresenter.c> implements KycProBaseInformationPresenter.c {
    public boolean A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public CoordinatorLayout F;
    public View G;
    public boolean H;
    public boolean I;
    public String J;
    public String K;
    public String L;

    /* renamed from: b  reason: collision with root package name */
    public TextView f74863b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f74864c;

    /* renamed from: d  reason: collision with root package name */
    public ClearEditText f74865d;

    /* renamed from: e  reason: collision with root package name */
    public ClearEditText f74866e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74867f;

    /* renamed from: g  reason: collision with root package name */
    public String f74868g;

    /* renamed from: h  reason: collision with root package name */
    public View f74869h;

    /* renamed from: i  reason: collision with root package name */
    public View f74870i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f74871j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f74872k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f74873l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f74874m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f74875n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f74876o;

    /* renamed from: p  reason: collision with root package name */
    public Uri f74877p;

    /* renamed from: q  reason: collision with root package name */
    public int f74878q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f74879r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f74880s = 0;

    /* renamed from: t  reason: collision with root package name */
    public Toolbar f74881t;

    /* renamed from: u  reason: collision with root package name */
    public CollapsingToolbarLayout f74882u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f74883v;

    /* renamed from: w  reason: collision with root package name */
    public View.OnClickListener f74884w;

    /* renamed from: x  reason: collision with root package name */
    public View.OnClickListener f74885x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f74886y;

    /* renamed from: z  reason: collision with root package name */
    public LoadingLayout f74887z;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = KycProBaseInformationActivity.this.f74878q = editable.length();
            KycProBaseInformationActivity.this.Ah();
            if (KycProBaseInformationActivity.this.f74878q > 0 && !KycProBaseInformationActivity.this.f74864c.getTypeface().isBold()) {
                KycProBaseInformationActivity.this.f74864c.setTypeface(ResourcesCompat.h(KycProBaseInformationActivity.this.f74864c.getContext(), R.font.roboto_medium));
            } else if (KycProBaseInformationActivity.this.f74878q == 0) {
                KycProBaseInformationActivity.this.f74864c.setTypeface(ResourcesCompat.h(KycProBaseInformationActivity.this.f74864c.getContext(), R.font.roboto_regular));
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
            int unused = KycProBaseInformationActivity.this.f74879r = editable.length();
            KycProBaseInformationActivity.this.Ah();
            if (KycProBaseInformationActivity.this.f74879r > 0 && !KycProBaseInformationActivity.this.f74865d.getTypeface().isBold()) {
                KycProBaseInformationActivity.this.f74865d.setTypeface(ResourcesCompat.h(KycProBaseInformationActivity.this.f74865d.getContext(), R.font.roboto_medium));
            } else if (KycProBaseInformationActivity.this.f74879r == 0) {
                KycProBaseInformationActivity.this.f74865d.setTypeface(ResourcesCompat.h(KycProBaseInformationActivity.this.f74865d.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = KycProBaseInformationActivity.this.f74880s = editable.length();
            KycProBaseInformationActivity.this.Ah();
            if (KycProBaseInformationActivity.this.f74880s > 0 && !KycProBaseInformationActivity.this.f74866e.getTypeface().isBold()) {
                KycProBaseInformationActivity.this.f74866e.setTypeface(ResourcesCompat.h(KycProBaseInformationActivity.this.f74866e.getContext(), R.font.roboto_medium));
            } else if (KycProBaseInformationActivity.this.f74880s == 0) {
                KycProBaseInformationActivity.this.f74866e.setTypeface(ResourcesCompat.h(KycProBaseInformationActivity.this.f74866e.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        if (this.A) {
            Bh();
        } else {
            Th();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh(View view, boolean z11) {
        this.f74864c.onFocusChange(view, z11);
        this.f74864c.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mh(View view, boolean z11) {
        this.f74865d.onFocusChange(view, z11);
        this.f74865d.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(View view, boolean z11) {
        this.f74866e.onFocusChange(view, z11);
        this.f74866e.setSelected(z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        ((KycProBaseInformationPresenter) getPresenter()).c0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ph(VerificationTipsDialog verificationTipsDialog, View view) {
        HBBaseWebActivity.showWebView(this, a0.n(), (String) null, (String) null, false);
        verificationTipsDialog.doDismiss();
        is.a.j("5969", (Map<String, Object>) null, (String) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qh(VerificationTipsDialog verificationTipsDialog, View view) {
        HBBaseWebActivity.showWebView(this, a0.o(), (String) null, (String) null, false);
        verificationTipsDialog.doDismiss();
        is.a.j("5993", (Map<String, Object>) null, (String) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Rh(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        is.a.j("5992", (Map<String, Object>) null, (String) null);
        VerificationTipsDialog verificationTipsDialog = new VerificationTipsDialog();
        verificationTipsDialog.setContent(getString(R.string.n_verification_area_error_tips_detail));
        verificationTipsDialog.vh(new VerificationTipsDialog.a[]{new VerificationTipsDialog.a(R.drawable.ic_verification_country_icon, getString(R.string.n_verification_area_error_not_match), getString(R.string.n_verification_submit_apply), new i(this, verificationTipsDialog)), new VerificationTipsDialog.a(R.drawable.ic_verification_account_icon, getString(R.string.n_verification_area_error_already_used), getString(R.string.n_verification_submit_to_remove_realname), new j(this, verificationTipsDialog))});
        verificationTipsDialog.show(getSupportFragmentManager(), "AreaErrorTipsDialogTag");
        is.a.s("5955", (String) null, false, (String) null, (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Sh(View view) {
        SoftInputUtils.f(this);
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void Vh(Context context, String str) {
        Wh(context, str, "");
    }

    public static void Wh(Context context, String str, String str2) {
        Intent intent = new Intent(context, KycProBaseInformationActivity.class);
        intent.putExtra("EXTRA_FROM", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("EXTRA_URL", str2);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        int p11 = KycProxy.l().p();
        if (p11 == 3) {
            Intent intent = new Intent(this, KycProBaseInformationActivity.class);
            intent.putExtra("TRY_AGAIN_KEY", true);
            startActivity(intent);
        } else if (p11 == 1 || p11 == 2 || p11 == 4) {
            if (this.H && !this.I) {
                finish();
            } else if (!"FROM_CONTRACT".equals(this.J)) {
                k0.O(this, "", true);
                finish();
            } else if (this.A) {
                ContractWebActivity.Mh(this, this.K, new Bundle());
                finish();
            } else {
                finish();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void A(boolean z11) {
        if (z11) {
            this.f74887z.setVisibility(0);
            this.f74883v.setVisibility(8);
            this.G.setVisibility(8);
            this.f74887z.p();
            return;
        }
        this.f74887z.setVisibility(8);
        this.f74883v.setVisibility(0);
        this.G.setVisibility(0);
    }

    public final void Ah() {
        TextView textView = this.f74867f;
        if (textView != null) {
            boolean z11 = true;
            if (this.A) {
                if (this.f74879r <= 0 || this.f74880s <= 0) {
                    z11 = false;
                }
                textView.setEnabled(z11);
                return;
            }
            if (this.f74878q <= 0 || this.f74879r <= 0 || this.f74880s <= 0) {
                z11 = false;
            }
            textView.setEnabled(z11);
        }
    }

    public final void Bh() {
        String trim = this.f74865d.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            HuobiToastUtil.j(R.string.verification_last_name_short);
        } else if (trim.length() > 50) {
            HuobiToastUtil.j(R.string.verification_last_name_long);
        } else {
            String trim2 = this.f74866e.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                HuobiToastUtil.j(R.string.verification_passport_short);
            } else if (trim2.length() > 20) {
                HuobiToastUtil.j(R.string.verification_passport_long);
            } else if (trim2.contains(" ")) {
                HuobiToastUtil.j(R.string.verification_passport_format_error);
            } else {
                ((KycProBaseInformationPresenter) getPresenter()).U(trim, trim2);
            }
        }
    }

    /* renamed from: Ch */
    public KycProBaseInformationPresenter createPresenter() {
        return new KycProBaseInformationPresenter();
    }

    public final void Dh(Intent intent) {
        if (intent != null) {
            this.f74876o = intent.getBooleanExtra("TRY_AGAIN_KEY", false);
            this.f74886y = intent.getBooleanExtra("FROM_STEP2_KEY", false);
            this.H = intent.getBooleanExtra("OTC_KYC_PRO", false);
            this.I = intent.getBooleanExtra("verify_by_paymethod", false);
            this.J = intent.getStringExtra("EXTRA_FROM");
            this.K = intent.getStringExtra("EXTRA_URL");
            this.L = intent.getStringExtra("EXTRA_DM_SOURCE_FROM");
        }
    }

    public final String Eh(String[] strArr) {
        StringBuilder sb2 = new StringBuilder();
        if (strArr != null) {
            for (int i11 = 0; i11 < strArr.length; i11++) {
                sb2.append(strArr[i11]);
                if (i11 != strArr.length - 1) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return sb2.toString();
    }

    /* renamed from: Fh */
    public KycProBaseInformationPresenter.c getUI() {
        return this;
    }

    public final void Gh() {
        startActivity(k0.h(this));
        finish();
    }

    public void Hf() {
        A(true);
    }

    public final void Hh() {
        jp.k0.k(this);
        finish();
    }

    public final void Ih() {
        this.G.setVisibility(8);
        this.f74869h.setVisibility(8);
        this.f74870i.setVisibility(0);
        TextView textView = this.f74883v;
        this.f74875n = textView;
        textView.setOnClickListener(this.f74885x);
        this.f74875n.setEnabled(true);
        this.f74882u.setTitle("");
        this.f74881t.setTitle((CharSequence) "");
    }

    public final void Jh() {
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f74881t = toolbar;
        setToolBar(toolbar, "", true);
        this.f74881t.setNavigationOnClickListener(new d(this));
    }

    public final void Th() {
        String trim = this.f74864c.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            HuobiToastUtil.k(this, R.string.verification_fist_name_short);
        } else if (trim.length() > 50) {
            HuobiToastUtil.j(R.string.verification_fist_name_long);
        } else {
            String trim2 = this.f74865d.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                HuobiToastUtil.j(R.string.verification_last_name_short);
            } else if (trim2.length() > 50) {
                HuobiToastUtil.j(R.string.verification_last_name_long);
            } else {
                String trim3 = this.f74866e.getText().toString().trim();
                if (TextUtils.isEmpty(trim3)) {
                    HuobiToastUtil.j(R.string.verification_passport_short);
                } else if (trim3.length() > 20) {
                    HuobiToastUtil.j(R.string.verification_passport_long);
                } else {
                    Intent intent = getIntent();
                    intent.setClass(this, KycProBaseInformationUploadPhotoActivity.class);
                    intent.putExtra("FIRST_NAME_KEY", trim);
                    intent.putExtra("LAST_NAME_KEY", trim2);
                    intent.putExtra("CARD_NUMBER_KEY", trim3);
                    intent.putExtra("COUNTRY_ID_KEY", this.f74868g);
                    intent.putExtra("DM_SOURCE_KEY", this.L);
                    Uri uri = this.f74877p;
                    if (uri != null) {
                        intent.putExtra("THUMBNAIL_URI_KEY", uri);
                    }
                    startActivityForResult(intent, 1000);
                }
            }
        }
    }

    public final void Uh(UserKycInfoNew userKycInfoNew, Map<String, CountryKyc> map) {
        String str;
        String str2;
        this.f74870i.setVisibility(8);
        this.f74869h.setVisibility(0);
        this.f74882u.setTitle(getString(R.string.verification_enter_action));
        TextView textView = this.f74883v;
        this.f74867f = textView;
        textView.setOnClickListener(this.f74884w);
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        if (userKycInfoNew.getUser_info().getAuth_country() != null) {
            Map<Object, String> auth_country = userKycInfoNew.getUser_info().getAuth_country();
            if (auth_country.containsKey("2")) {
                String str3 = auth_country.get("2");
                if (str3 != null) {
                    TextView textView2 = this.f74863b;
                    if (isChineseLanguage) {
                        str2 = map.get(str3).getCountries_z();
                    } else {
                        str2 = map.get(str3).getCountries_e();
                    }
                    textView2.setText(str2);
                    this.f74868g = str3;
                } else {
                    this.f74863b.setText(R.string.kyc_pro_default_country);
                    this.f74868g = "37";
                }
            } else if (auth_country.containsKey("1")) {
                String str4 = auth_country.get("1");
                if (str4 != null) {
                    TextView textView3 = this.f74863b;
                    if (isChineseLanguage) {
                        str = map.get(str4).getCountries_z();
                    } else {
                        str = map.get(str4).getCountries_e();
                    }
                    textView3.setText(str);
                    this.f74868g = str4;
                } else {
                    this.f74863b.setText(R.string.kyc_pro_default_country);
                    this.f74868g = "37";
                }
            } else {
                this.f74863b.setText(R.string.kyc_pro_default_country);
                this.f74868g = "37";
            }
        } else {
            this.f74863b.setText(R.string.kyc_pro_default_country);
            this.f74868g = "37";
        }
        if ("37".equals(this.f74868g)) {
            this.A = true;
            this.B.setVisibility(8);
            this.f74864c.setVisibility(8);
            this.E.setVisibility(8);
            this.C.setText(R.string.verification_cn_name);
            this.f74865d.setHint(R.string.verification_cn_name_hint);
            this.D.setText(R.string.verification_cn_card);
            this.f74866e.setHint(R.string.verification_cn_card_hint);
        }
    }

    public void W0() {
        this.f74887z.k();
    }

    public void addEvent() {
        this.f74884w = new h(this);
        this.f74885x = new e(this);
        this.f74864c.addTextChangedListener(new a());
        this.f74864c.setOnFocusChangeListener(new m(this));
        this.f74865d.addTextChangedListener(new b());
        this.f74865d.setOnFocusChangeListener(new k(this));
        this.f74866e.addTextChangedListener(new c());
        this.f74866e.setOnFocusChangeListener(new l(this));
        this.f74887z.setOnRetryClickListener(new g(this));
        this.G.setOnClickListener(new f(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.activity_verification_step_1;
    }

    public void initView() {
        removeWinBg();
        this.f74869h = this.viewFinder.b(R.id.rl_verification_step1);
        this.f74863b = (TextView) this.viewFinder.b(R.id.tv_value_nationality);
        this.B = (TextView) this.viewFinder.b(R.id.tv_title_first_name);
        this.C = (TextView) this.viewFinder.b(R.id.tv_title_last_name);
        this.D = (TextView) this.viewFinder.b(R.id.tv_title_passport_no);
        this.f74864c = (ClearEditText) this.viewFinder.b(R.id.et_first_name);
        this.f74865d = (ClearEditText) this.viewFinder.b(R.id.et_last_name);
        this.f74866e = (ClearEditText) this.viewFinder.b(R.id.et_passport);
        this.f74870i = this.viewFinder.b(R.id.rl_verification_msg);
        this.f74871j = (ImageView) this.viewFinder.b(R.id.iv_verification);
        this.f74872k = (TextView) this.viewFinder.b(R.id.tv_verification_reason_title);
        this.f74873l = (TextView) this.viewFinder.b(R.id.tv_verification_reason_subtitle);
        this.f74874m = (TextView) this.viewFinder.b(R.id.tv_verification_reason);
        this.E = (TextView) this.viewFinder.b(R.id.verification_last_passport_hint_tv);
        this.f74882u = (CollapsingToolbarLayout) this.viewFinder.b(R.id.collapsing_toolbar);
        this.f74883v = (TextView) this.viewFinder.b(R.id.btn_action);
        this.f74887z = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.F = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
        this.G = this.viewFinder.b(R.id.btn_area_error_tips);
        Jh();
    }

    public void m6(Pair<UserKycInfoNew, Map<String, CountryKyc>> pair) {
        A(false);
        UserKycInfoNew userKycInfoNew = (UserKycInfoNew) pair.first;
        Map map = (Map) pair.second;
        if (this.f74876o) {
            Uh(userKycInfoNew, map);
            return;
        }
        int p11 = KycProxy.l().p();
        if (p11 == 3) {
            Ih();
            this.f74871j.setImageResource(R.drawable.verification_info_failed);
            this.f74872k.setText(R.string.verification_failed);
            this.f74872k.setTextColor(getResources().getColor(R.color.verification_status_failed));
            this.f74873l.setVisibility(0);
            this.f74873l.setText(R.string.verification_failed_subtitle);
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                this.f74874m.setText(String.format(getString(R.string.verification_failed_reason), new Object[]{Eh(userKycInfoNew.getAuth_info().getPro_reason_zh())}));
            } else {
                this.f74874m.setText(String.format(getString(R.string.verification_failed_reason), new Object[]{Eh(userKycInfoNew.getAuth_info().getPro_reason_en())}));
            }
            this.f74875n.setText(R.string.verification_failed_action);
        } else if (p11 == 1 || p11 == 4) {
            Ih();
            this.f74871j.setImageResource(R.drawable.verification_info_waiting);
            this.f74872k.setText(R.string.verification_wait);
            this.f74872k.setTextColor(getResources().getColor(R.color.verification_title));
            this.f74873l.setVisibility(8);
            this.f74874m.setText(R.string.verification_wait_reason);
            this.f74875n.setText(R.string.verification_wait_action);
            if (this.H) {
                if (this.I) {
                    this.f74875n.setVisibility(8);
                    return;
                }
                this.f74875n.setVisibility(0);
                this.f74875n.setText(R.string.otc_verification_continue_trade);
            } else if ("FROM_CONTRACT".equals(this.J)) {
                this.f74874m.setText(R.string.n_contract_verify_identify_text);
                this.f74875n.setText(R.string.n_known);
            } else if ("FROM_SAVINGS".equals(this.J)) {
                this.f74875n.setVisibility(8);
            }
        } else if (p11 == 2) {
            Ih();
            this.f74871j.setImageResource(R.drawable.verification_info_success);
            this.f74872k.setText(R.string.verification_complete);
            this.f74872k.setTextColor(getResources().getColor(R.color.verification_status_pass));
            this.f74873l.setVisibility(8);
            this.f74874m.setText(R.string.verification_pass_reason);
            this.f74875n.setText(R.string.verification_wait_action);
            if (this.H) {
                if (this.I) {
                    this.f74875n.setVisibility(8);
                    return;
                }
                this.f74875n.setVisibility(0);
                this.f74875n.setText(R.string.otc_verification_continue_trade);
            } else if ("FROM_CONTRACT".equals(this.J)) {
                this.f74875n.setText(R.string.sign_up_next);
            } else if ("FROM_SAVINGS".equals(this.J)) {
                this.f74875n.setVisibility(8);
            }
        } else {
            Uh(userKycInfoNew, map);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (intent != null && -1 == i12 && i11 == 1000) {
            this.f74877p = (Uri) intent.getParcelableExtra("THUMBNAIL_URI_KEY");
        }
    }

    public void onBackPressed() {
        if (this.f74886y) {
            int p11 = KycProxy.l().p();
            if (p11 == 1 || p11 == 2 || p11 == 4) {
                Gh();
            } else {
                super.onBackPressed();
            }
        } else if (!this.H || !this.I) {
            super.onBackPressed();
        } else if (KycProxy.l().p() == 2) {
            Hh();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        Dh(getIntent());
        super.onCreate(bundle);
        gs.e.b().c("PM_AUTH");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Dh(intent);
        ((KycProBaseInformationPresenter) getPresenter()).c0();
    }
}
