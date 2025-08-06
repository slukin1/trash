package com.huobi.otc.ui;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.lang.BaseLang;
import com.hbg.lib.core.lang.EnLang;
import com.hbg.lib.core.lang.EsEsLang;
import com.hbg.lib.core.lang.EsLaLang;
import com.hbg.lib.core.lang.PtPtLang;
import com.hbg.lib.core.lang.ZhCnLang;
import com.hbg.lib.core.lang.ZhHkLang;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.UserBillingAddressBean;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.persenter.OtcBindBankCardPresenter;
import com.huobi.otc.widget.CustomViewPager;
import com.huobi.otc.widget.StepView;
import com.huobi.view.DatePickerDialog;
import com.huobi.view.FixedSpeedScroller;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.twitter.sdk.android.core.identity.AuthHandler;
import com.youth.banner.config.BannerConfig;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jp.l;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import sp.a0;
import sp.b0;
import sp.c0;
import sp.d0;
import sp.x;
import sp.y;
import sp.z;

public class OtcBindBankCardActivity extends BaseActivity<OtcBindBankCardPresenter, OtcBindBankCardPresenter.d> implements OtcBindBankCardPresenter.d {
    public LinearLayout A;
    public LinearLayout B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public String I;
    public TextView J;
    public TextView K;
    public TextView L;
    public ConstraintLayout M;
    public TextView N;
    public TextView O;
    public ConstraintLayout P;
    public final float Q = 0.3f;
    public int R = 0;
    public int S = 1;
    public LoadingLayout T;
    public OtcBindBankCardPresenter U;
    public boolean V;
    public String W = "1";
    public String X = "2";
    public String Y = "3";
    public String Z = "4";

    /* renamed from: a0  reason: collision with root package name */
    public boolean f79287a0 = false;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f79288b;

    /* renamed from: b0  reason: collision with root package name */
    public int f79289b0;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79290c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79291d;

    /* renamed from: e  reason: collision with root package name */
    public final int f79292e = BannerConfig.SCROLL_TIME;

    /* renamed from: f  reason: collision with root package name */
    public View f79293f;

    /* renamed from: g  reason: collision with root package name */
    public View f79294g;

    /* renamed from: h  reason: collision with root package name */
    public CustomViewPager f79295h;

    /* renamed from: i  reason: collision with root package name */
    public List<View> f79296i;

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f79297j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f79298k;

    /* renamed from: l  reason: collision with root package name */
    public String f79299l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f79300m = "";

    /* renamed from: n  reason: collision with root package name */
    public String f79301n = "";

    /* renamed from: o  reason: collision with root package name */
    public String f79302o = "";

    /* renamed from: p  reason: collision with root package name */
    public String f79303p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f79304q = "";

    /* renamed from: r  reason: collision with root package name */
    public EditText f79305r;

    /* renamed from: s  reason: collision with root package name */
    public EditText f79306s;

    /* renamed from: t  reason: collision with root package name */
    public int f79307t;

    /* renamed from: u  reason: collision with root package name */
    public int f79308u;

    /* renamed from: v  reason: collision with root package name */
    public EditText f79309v;

    /* renamed from: w  reason: collision with root package name */
    public EditText f79310w;

    /* renamed from: x  reason: collision with root package name */
    public EditText f79311x;

    /* renamed from: y  reason: collision with root package name */
    public EditText f79312y;

    /* renamed from: z  reason: collision with root package name */
    public LinearLayout f79313z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) OtcBindBankCardActivity.this.f79298k.getLayoutParams();
            layoutParams.width = OtcBindBankCardActivity.this.f79298k.getWidth() * (OtcBindBankCardActivity.this.S + 1);
            OtcBindBankCardActivity.this.f79298k.setLayoutParams(layoutParams);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(OtcBindBankCardActivity.this, AddNewAddressActivity.class);
            OtcBindBankCardActivity.this.startActivityForResult(intent, 1003);
            HashMap hashMap = new HashMap();
            hashMap.put("otc_step", "click_new_billing_address");
            uf.c.b().h("hbg_fiat_bind_card", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Intent intent = new Intent();
            UserBillingAddressBean userBillingAddressBean = new UserBillingAddressBean();
            userBillingAddressBean.setAddressLine1(OtcBindBankCardActivity.this.C.getText().toString().trim());
            userBillingAddressBean.setAddressLine2(OtcBindBankCardActivity.this.D.getText().toString().trim());
            userBillingAddressBean.setCity(OtcBindBankCardActivity.this.E.getText().toString().trim());
            userBillingAddressBean.setState(OtcBindBankCardActivity.this.F.getText().toString().trim());
            userBillingAddressBean.setZip(OtcBindBankCardActivity.this.G.getText().toString().trim());
            userBillingAddressBean.setCountry(OtcBindBankCardActivity.this.I);
            userBillingAddressBean.setCountryName(OtcBindBankCardActivity.this.H.getText().toString().trim());
            intent.putExtra("userBillingAddressBean", userBillingAddressBean);
            intent.setClass(OtcBindBankCardActivity.this, AddNewAddressActivity.class);
            OtcBindBankCardActivity.this.startActivityForResult(intent, 1003);
            HashMap hashMap = new HashMap();
            hashMap.put("otc_step", "click_edit_billing_address");
            uf.c.b().h("hbg_fiat_bind_card", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            if (i11 == OtcBindBankCardActivity.this.f79298k.getChildCount() - 1) {
                OtcBindBankCardActivity.this.f79297j.setProgress(100);
            } else {
                OtcBindBankCardActivity.this.f79297j.setProgress((int) (((float) ((100 / OtcBindBankCardActivity.this.f79298k.getChildCount()) * (i11 + 1))) + (((float) (100 / OtcBindBankCardActivity.this.f79298k.getChildCount())) * f11)));
            }
        }

        public void onPageSelected(int i11) {
        }
    }

    public class e extends PagerAdapter {
        public e() {
        }

        public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
            viewGroup.removeView((View) OtcBindBankCardActivity.this.f79296i.get(i11));
        }

        public int getCount() {
            return OtcBindBankCardActivity.this.f79296i.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i11) {
            viewGroup.addView((View) OtcBindBankCardActivity.this.f79296i.get(i11));
            return OtcBindBankCardActivity.this.f79296i.get(i11);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public class f implements DatePickerDialog.ResultListener {
        public f() {
        }

        public void onCancel() {
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy", Locale.getDefault());
            Date date = new Date(j11);
            OtcBindBankCardActivity.this.f79306s.setText(simpleDateFormat.format(date));
            int unused = OtcBindBankCardActivity.this.f79307t = date.getYear() + 1900;
            int unused2 = OtcBindBankCardActivity.this.f79308u = date.getMonth() + 1;
            datePickerDialog.dismiss();
        }
    }

    public class g implements TextWatcher {
        public g() {
        }

        public void afterTextChanged(Editable editable) {
            if (OtcBindBankCardActivity.this.Xh()) {
                OtcBindBankCardActivity.this.f79290c.setBackground(OtcBindBankCardActivity.this.getResources().getDrawable(R$drawable.common_blue_5_radius_selector));
                OtcBindBankCardActivity.this.f79290c.setEnabled(true);
                return;
            }
            OtcBindBankCardActivity.this.f79290c.setBackground(OtcBindBankCardActivity.this.getResources().getDrawable(R$drawable.common_gray_5_radius_selector));
            OtcBindBankCardActivity.this.f79290c.setEnabled(false);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(Void voidR) {
        Vh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        Intent intent = new Intent();
        intent.setClass(this, AddNewAddressActivity.class);
        startActivityForResult(intent, 1003);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kh(Void voidR) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh(Void voidR) {
        uf.c.b().p("confirm_creditcard", this.f79289b0 == OtcTradeAreaEnum.FAST_AREA.getCode() ? "otc.fast.layer_bindingcard.confirm_card" : "otc.third.layer_bindingcard.confirm_card", (HashMap) null);
        Dh();
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", "click_confirm");
        uf.c.b().h("hbg_fiat_bind_card", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("otc_step", "click_submit_cardinfo");
        uf.c.b().h("otc_card_info_typein", hashMap2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mh(Void voidR) {
        Intent intent = new Intent();
        intent.setClass(this, AddNewAddressActivity.class);
        startActivityForResult(intent, 1003);
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", "click_go_card_info_next");
        uf.c.b().h("otc_card_info_typein", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put(EnLang.getInstance(), Arrays.asList(new BaseLang[0]));
        hashMap.put(ZhCnLang.getInstance(), Arrays.asList(new BaseLang[]{ZhCnLang.getInstance()}));
        hashMap.put(ZhHkLang.getInstance(), Arrays.asList(new BaseLang[]{ZhHkLang.getInstance()}));
        hashMap.put(PtPtLang.getInstance(), Arrays.asList(new BaseLang[]{PtPtLang.getInstance()}));
        hashMap.put(EsEsLang.getInstance(), Arrays.asList(new BaseLang[]{EsEsLang.getInstance(), EsLaLang.getInstance()}));
        HBBaseWebActivity.showWebView(this, BaseModuleConfig.a().m("54954447731723", hashMap), "", "", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        Ch();
    }

    public static void Qh(Activity activity, int i11) {
        Rh(activity, false, i11);
    }

    public static void Rh(Activity activity, boolean z11, int i11) {
        Intent intent = new Intent(activity, OtcBindBankCardActivity.class);
        intent.putExtra("bind_card_from_tag", z11);
        intent.putExtra("parma_current_area", i11);
        activity.startActivityForResult(intent, 1003);
    }

    public static void Sh(Activity activity) {
        Intent intent = new Intent(activity, OtcBindBankCardActivity.class);
        intent.putExtra("bind_card_from_tag", false);
        intent.putExtra("bind_card_from_settlepay", true);
        activity.startActivityForResult(intent, 1003);
    }

    public final void Ch() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("paymentMethod", this.f79287a0 ? "settlepay" : "CreditcardtoCheckout");
        String str2 = "settlepay210811";
        if (SystemUtils.c()) {
            if (!this.f79287a0) {
                str2 = "2W5omA";
            }
        } else if (!this.f79287a0) {
            str2 = "otc";
        }
        hashMap.put("merchantCode", str2);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, up.g.c("otc_select_trade_currency_quote_asset"));
        hashMap.put("extend", "{\"threeDs\":false,\"threeDsEnable\":false,\"capture\":true}");
        hashMap.put("successUrl", Fh());
        hashMap.put("failedUrl", Fh());
        hashMap.put("domainUrl", SystemUtils.c() ? OtcModuleConfig.a().t() : "http://otc-dev-20.otcdev.top");
        hashMap.put("useDefault", 0);
        i6.d.e("failedUrl--->", Fh());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserDataStore.COUNTRY, this.I);
            jSONObject.put("zip", this.G.getText().toString().trim());
            jSONObject.put("state", this.F.getText().toString().trim());
            jSONObject.put("city", this.E.getText().toString().trim());
            jSONObject.put("addressLine2", this.D.getText().toString().trim());
            jSONObject.put("addressLine1", this.C.getText().toString().trim());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        hashMap.put("billingAddress", jSONObject.toString());
        hashMap.put("firstName", this.f79302o);
        hashMap.put("middleName", this.f79303p);
        hashMap.put("lastName", this.f79304q);
        hashMap.put("cardNumber", this.f79299l.replaceAll(" ", ""));
        int i11 = this.f79308u;
        if (i11 < 10) {
            str = "0" + this.f79308u;
        } else {
            str = String.valueOf(i11);
        }
        hashMap.put("expiryMonth", str);
        hashMap.put("expiryYear", Integer.valueOf(this.f79307t));
        hashMap.put("cvv", this.f79301n);
        hashMap.put(AuthHandler.EXTRA_TOKEN_SECRET, Long.valueOf(System.currentTimeMillis()));
        hashMap.put("isAsynchronous", Boolean.TRUE);
        getPresenter().Z(this, hashMap);
    }

    public final void Dh() {
        DialogUtils.X(this, getString(R$string.n_otc_use_tip), getString(R$string.n_otc_new_card_bind_intercept_prompt), (String) null, getString(R$string.n_known), new y(this));
    }

    /* renamed from: Eh */
    public OtcBindBankCardPresenter createPresenter() {
        OtcBindBankCardPresenter otcBindBankCardPresenter = new OtcBindBankCardPresenter();
        this.U = otcBindBankCardPresenter;
        return otcBindBankCardPresenter;
    }

    public final String Fh() {
        if (SystemUtils.c()) {
            return l.p() + "fiat-crypto/card-result" + "?type=3";
        }
        return "http://otc-dev-20.otcdev.top" + OtcModuleConfig.a().g() + "fiat-crypto/card-result" + "?type=3";
    }

    /* renamed from: Gh */
    public OtcBindBankCardPresenter getPresenter() {
        return this.U;
    }

    /* renamed from: Hh */
    public OtcBindBankCardPresenter.d getUI() {
        return this;
    }

    public final void Ph() {
        if (this.R < this.f79298k.getChildCount() - 1) {
            int i11 = this.R + 1;
            this.R = i11;
            this.f79295h.setCurrentItem(i11, false);
            int i12 = 0;
            while (i12 < this.f79298k.getChildCount()) {
                View childAt = this.f79298k.getChildAt(i12);
                int i13 = this.R;
                Wh(childAt, i13, i12 == i13);
                i12++;
            }
        }
        this.f79299l = this.f79305r.getText().toString();
        this.f79300m = this.f79306s.getText().toString();
        this.f79301n = this.f79309v.getText().toString();
        this.f79302o = this.f79310w.getText().toString();
        this.f79303p = this.f79311x.getText().toString();
        this.f79304q = this.f79312y.getText().toString();
        SoftInputUtils.f(this);
        Uh();
        Th();
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", "click_next");
        uf.c.b().h("hbg_fiat_bind_card", hashMap);
    }

    public final void Th() {
        if (!TextUtils.isEmpty(this.D.getText().toString().trim())) {
            this.f79313z.setVisibility(0);
        } else {
            this.f79313z.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.F.getText().toString().trim())) {
            this.A.setVisibility(0);
        } else {
            this.A.setVisibility(8);
        }
    }

    public final void Uh() {
        if (TextUtils.isEmpty(this.C.getText().toString().trim()) || TextUtils.isEmpty(this.E.getText().toString().trim()) || TextUtils.isEmpty(this.G.getText().toString().trim()) || TextUtils.isEmpty(this.H.getText().toString().trim())) {
            this.f79291d.setEnabled(false);
        } else {
            this.f79291d.setEnabled(true);
        }
    }

    public final void Vh() {
        new DatePickerDialog.Builder().setInitDate(System.currentTimeMillis()).setMinDate(System.currentTimeMillis()).setTitle(R$string.n_otc_card_pay_valid_period).setResultListener(new f()).setHideDate(true).show(this);
    }

    public void W(MktRuleBean mktRuleBean) {
        if (mktRuleBean != null) {
            this.M.setVisibility(0);
            this.J.setText(mktRuleBean.getTitle());
            this.K.setText(mktRuleBean.getContent());
            this.P.setVisibility(0);
            this.N.setText(mktRuleBean.getTitle());
            this.O.setText(mktRuleBean.getContent());
        }
    }

    public void Wh(View view, int i11, boolean z11) {
        ObjectAnimator objectAnimator;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.3f, 1.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationX", new float[]{(float) (0 - (view.getWidth() * (i11 - 1))), (float) ((-view.getWidth()) * i11)});
        if (z11) {
            objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        } else {
            objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat2});
        }
        objectAnimator.setDuration(600);
        objectAnimator.start();
    }

    public boolean Xh() {
        return !TextUtils.isEmpty(this.f79305r.getText().toString().trim()) && !TextUtils.isEmpty(this.f79306s.getText().toString().trim()) && !TextUtils.isEmpty(this.f79310w.getText().toString().trim()) && !TextUtils.isEmpty(this.f79312y.getText().toString().trim());
    }

    public void addEvent() {
        this.f79306s.setFocusable(false);
        dw.a.a(this.f79306s).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new c0(this));
        this.f79294g.findViewById(R$id.difAddress).setOnClickListener(new b());
        this.L.setOnClickListener(new x(this));
        this.f79294g.findViewById(R$id.bill_address_edit_container).setOnClickListener(new c());
        jp.a.a(this.f79305r);
        g gVar = new g();
        this.f79305r.addTextChangedListener(gVar);
        this.f79306s.addTextChangedListener(gVar);
        this.f79309v.addTextChangedListener(gVar);
        this.f79310w.addTextChangedListener(gVar);
        this.f79311x.addTextChangedListener(gVar);
        this.f79312y.addTextChangedListener(gVar);
        this.f79295h.setPagingEnabled(false);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            FixedSpeedScroller fixedSpeedScroller = new FixedSpeedScroller(this.f79295h.getContext(), new AccelerateInterpolator());
            declaredField.set(this.f79295h, fixedSpeedScroller);
            fixedSpeedScroller.setScrollDuration(BannerConfig.SCROLL_TIME);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f79295h.setOnPageChangeListener(new d());
        this.f79295h.setAdapter(new e());
        Observable<Void> a11 = dw.a.a(this.f79288b);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new z(this));
        dw.a.a(this.f79291d).throttleFirst(300, timeUnit).subscribe(new b0(this));
        dw.a.a(this.f79290c).throttleFirst(300, timeUnit).subscribe(new a0(this));
        dw.a.a(this.B).throttleFirst(300, timeUnit).subscribe(new d0(this));
    }

    public int getContentView() {
        return R$layout.activity_otc_bind_bank_card;
    }

    public void initView() {
        this.V = getIntent().getBooleanExtra("bind_card_from_tag", false);
        this.f79289b0 = getIntent().getIntExtra("parma_current_area", OtcTradeAreaEnum.FAST_AREA.getCode());
        this.f79287a0 = getIntent().getBooleanExtra("bind_card_from_settlepay", false);
        this.f79288b = (ImageView) findViewById(R$id.bind_bank_ib_back);
        this.f79298k = (LinearLayout) findViewById(R$id.step_container);
        this.f79295h = (CustomViewPager) findViewById(R$id.viewpager);
        this.f79297j = (ProgressBar) findViewById(R$id.progress_horizontal);
        this.f79298k.post(new a());
        StepView stepView = new StepView(this, getString(R$string.n_otc_card_pay_step_one), getString(R$string.n_otc_card_pay_information));
        StepView stepView2 = new StepView(this, getString(R$string.n_otc_card_pay_step_two), getString(R$string.n_otc_card_account_information), 0.3f);
        this.f79298k.addView(stepView);
        this.f79298k.addView(stepView2);
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f79293f = layoutInflater.inflate(R$layout.layout_otc_bindcard_card_infomation, (ViewGroup) null);
        this.f79294g = layoutInflater.inflate(R$layout.layout_otc_bindcard_billing_address, (ViewGroup) null);
        this.f79290c = (TextView) this.f79293f.findViewById(R$id.card_info_continue);
        this.f79305r = (EditText) this.f79293f.findViewById(R$id.cardNumber);
        this.f79306s = (EditText) this.f79293f.findViewById(R$id.expiresDate);
        this.f79309v = (EditText) this.f79293f.findViewById(R$id.cvv);
        this.f79310w = (EditText) this.f79293f.findViewById(R$id.firstName);
        this.f79311x = (EditText) this.f79293f.findViewById(R$id.middleName);
        this.f79312y = (EditText) this.f79293f.findViewById(R$id.lastName);
        this.B = (LinearLayout) this.f79293f.findViewById(R$id.head_text_container);
        this.f79291d = (TextView) this.f79294g.findViewById(R$id.card_info_confirm);
        this.f79313z = (LinearLayout) this.f79294g.findViewById(R$id.addressLine2Container);
        this.A = (LinearLayout) this.f79294g.findViewById(R$id.id_provincial_city_ll);
        this.C = (TextView) this.f79294g.findViewById(R$id.addressLine1);
        this.D = (TextView) this.f79294g.findViewById(R$id.addressLine2);
        this.E = (TextView) this.f79294g.findViewById(R$id.city);
        this.F = (TextView) this.f79294g.findViewById(R$id.state);
        this.G = (TextView) this.f79294g.findViewById(R$id.zip);
        this.H = (TextView) this.f79294g.findViewById(R$id.country);
        LoadingLayout loadingLayout = (LoadingLayout) this.f79294g.findViewById(R$id.loading_layout);
        this.T = loadingLayout;
        this.L = (TextView) loadingLayout.findViewById(R$id.id_empty_difAddress);
        this.T.p();
        View view = this.f79293f;
        int i11 = R$id.id_pci_title_tv;
        this.J = (TextView) view.findViewById(i11);
        View view2 = this.f79293f;
        int i12 = R$id.id_pci_content_tv;
        this.K = (TextView) view2.findViewById(i12);
        View view3 = this.f79293f;
        int i13 = R$id.id_pci_root;
        this.M = (ConstraintLayout) view3.findViewById(i13);
        this.N = (TextView) this.f79294g.findViewById(i11);
        this.O = (TextView) this.f79294g.findViewById(i12);
        this.P = (ConstraintLayout) this.f79294g.findViewById(i13);
        ArrayList arrayList = new ArrayList();
        this.f79296i = arrayList;
        arrayList.add(this.f79293f);
        this.f79296i.add(this.f79294g);
        if (this.f79287a0) {
            this.f79309v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", "view_form_page");
        uf.c.b().h("hbg_fiat_bind_card", hashMap);
    }

    public boolean j9() {
        return this.V;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("userBillingAddressBean");
            if (serializableExtra instanceof UserBillingAddressBean) {
                UserBillingAddressBean userBillingAddressBean = (UserBillingAddressBean) serializableExtra;
                this.C.setText(userBillingAddressBean.getAddressLine1());
                this.D.setText(userBillingAddressBean.getAddressLine2());
                this.E.setText(userBillingAddressBean.getCity());
                this.F.setText(userBillingAddressBean.getState());
                this.G.setText(userBillingAddressBean.getZip());
                this.I = userBillingAddressBean.getCountry();
                String countryName = userBillingAddressBean.getCountryName();
                try {
                    countryName = qu.d.i().h(Integer.valueOf(this.I).intValue(), countryName);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.H.setText(countryName);
                this.T.g();
                Ph();
            }
        }
    }

    public void qf(String str, String str2, String str3, String str4) {
        if (!str.equals(this.Z) || !str2.equals(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER)) {
            OtcModuleConfig.b().E(this, str, str2, str4, str3);
        } else {
            HuobiToastUtil.m(getString(R$string.n_otc_card_pay_bind_card_success));
        }
        finish();
    }
}
