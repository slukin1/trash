package com.huobi.finance.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.CommonAllEditText;
import com.hbg.lib.widgets.ProgressConfirmButton;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.currencyconfig.bean.StableCoinCreate;
import com.huobi.currencyconfig.bean.StableCoinHints;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import com.huobi.currencyconfig.util.StableCurrencyRateConfigUtil;
import com.huobi.finance.bean.StableCurrencyBeanInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dt.h2;
import i6.i;
import i6.m;
import i6.n;
import i6.r;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import u6.g;

public class UnifyStableCurrencyExchangeDialog extends BaseDialogFragment {
    public float A = 0.0f;
    public float B;
    public int C;
    public int D;
    public int E;
    public Subscription F;
    public Subscription G;
    public Subscription H;
    public g I;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f46868b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f46869c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46870d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46871e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f46872f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46873g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46874h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46875i;

    /* renamed from: j  reason: collision with root package name */
    public CommonAllEditText f46876j;

    /* renamed from: k  reason: collision with root package name */
    public EditText f46877k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46878l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f46879m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f46880n;

    /* renamed from: o  reason: collision with root package name */
    public ProgressConfirmButton f46881o;

    /* renamed from: p  reason: collision with root package name */
    public ConstraintLayout f46882p;

    /* renamed from: q  reason: collision with root package name */
    public RelativeLayout f46883q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f46884r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f46885s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f46886t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f46887u;

    /* renamed from: v  reason: collision with root package name */
    public ProgressConfirmButton f46888v;

    /* renamed from: w  reason: collision with root package name */
    public StableCurrencyBeanInfo f46889w;

    /* renamed from: x  reason: collision with root package name */
    public StableCurrencyRateBean.StableCurrencyBean f46890x;

    /* renamed from: y  reason: collision with root package name */
    public StableCoinCreate f46891y;

    /* renamed from: z  reason: collision with root package name */
    public int f46892z = 270;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            String b11 = m.b(editable, 30, PrecisionUtil.o());
            if (b11 != null) {
                UnifyStableCurrencyExchangeDialog.this.f46877k.setText(b11);
                UnifyStableCurrencyExchangeDialog.this.f46877k.setSelection(UnifyStableCurrencyExchangeDialog.this.f46877k.getText().length());
                return;
            }
            String trim = editable.toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.endsWith(InstructionFileId.DOT)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            if (BigDecimal.ZERO.compareTo(m.a(trim)) >= 0 || TextUtils.isEmpty(trim)) {
                UnifyStableCurrencyExchangeDialog.this.f46881o.setEnabled(false);
            } else {
                UnifyStableCurrencyExchangeDialog.this.f46881o.setEnabled(true);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b extends EasySubscriber<StableCoinCreate> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(StableCoinCreate stableCoinCreate) {
            super.onNext(stableCoinCreate);
            StableCoinCreate unused = UnifyStableCurrencyExchangeDialog.this.f46891y = stableCoinCreate;
            UnifyStableCurrencyExchangeDialog.this.Qh(stableCoinCreate);
        }

        public void onAfter() {
            super.onAfter();
            UnifyStableCurrencyExchangeDialog.this.f46881o.c();
        }

        public void onStart() {
            super.onStart();
            UnifyStableCurrencyExchangeDialog.this.f46881o.b();
        }
    }

    public class c extends EasySubscriber<String> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            UnifyStableCurrencyExchangeDialog.this.si();
            UnifyStableCurrencyExchangeDialog.this.dismiss();
            HuobiToastUtil.s(R.string.currency_stable_convert_success);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            UnifyStableCurrencyExchangeDialog.this.si();
            UnifyStableCurrencyExchangeDialog.this.ni();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            UnifyStableCurrencyExchangeDialog.this.si();
            UnifyStableCurrencyExchangeDialog.this.ni();
        }

        public void onStart() {
            super.onStart();
            UnifyStableCurrencyExchangeDialog.this.ri();
        }
    }

    public class d extends BaseSubscriber<StableCurrencyRateBean.StableCurrencyBean> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean) {
            super.onNext(stableCurrencyBean);
            UnifyStableCurrencyExchangeDialog.this.qi(stableCurrencyBean);
            UnifyStableCurrencyExchangeDialog.this.Rh();
        }
    }

    public class e extends BaseSubscriber<Long> {
        public e() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() == 0) {
                UnifyStableCurrencyExchangeDialog.this.dismiss();
            }
            UnifyStableCurrencyExchangeDialog.this.f46887u.setText(UnifyStableCurrencyExchangeDialog.this.getContext().getString(R.string.otc_place_order_time_text_format, new Object[]{String.valueOf(l11)}));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(View view, boolean z11) {
        if (z11) {
            this.f46876j.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
        } else {
            this.f46876j.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh(FrameLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f46868b.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zh(FrameLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f46868b.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai(StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean) {
        this.f46890x = stableCurrencyBean;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean ci(StableCoinHints stableCoinHints) {
        return Boolean.valueOf(stableCoinHints.getCurrency().equalsIgnoreCase(this.f46889w.getStableCurrencyBean().getCurrency()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ StableCurrencyBeanInfo di(StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean, BalanceQueryData balanceQueryData, StableCoinHints stableCoinHints) {
        this.f46889w.setStableCurrencyBean(stableCurrencyBean);
        this.f46889w.setStableCoinHints(stableCoinHints);
        StableCurrencyBeanInfo stableCurrencyBeanInfo = this.f46889w;
        stableCurrencyBeanInfo.setAvailable(balanceQueryData.getAvailableBalance(stableCurrencyBeanInfo.getCurrency()));
        this.f46889w.setStableAvailable(balanceQueryData.getAvailableBalance(stableCurrencyBean.getCurrency()));
        return this.f46889w;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei(StableCurrencyBeanInfo stableCurrencyBeanInfo) {
        l3();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean gi(StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean) {
        return Boolean.valueOf(stableCurrencyBean.getCurrency().equalsIgnoreCase(this.f46889w.getStableCurrencyBean().getCurrency()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean ii(StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean) {
        if (this.f46889w.isExchangeIn()) {
            return Boolean.valueOf(stableCurrencyBean.getCurrency().equalsIgnoreCase(this.f46889w.getFromCurrency()));
        }
        return Boolean.valueOf(stableCurrencyBean.getCurrency().equalsIgnoreCase(this.f46889w.getToCurrency()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ji() {
        this.D = this.f46868b.getHeight();
        this.E = this.f46883q.getHeight() + this.f46869c.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f46868b.getLayoutParams();
        int height = this.f46868b.getHeight();
        int i11 = this.C;
        if (height > i11) {
            layoutParams.height = i11;
            this.D = i11;
        }
        this.f46868b.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Uh(this.f46877k.getText().toString());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        Rh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        Subscription subscription = this.F;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        pi(this.f46891y);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Qh(StableCoinCreate stableCoinCreate) {
        String str;
        this.f46872f.setVisibility(0);
        this.f46870d.setVisibility(8);
        this.f46873g.setVisibility(0);
        this.f46883q.setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f46872f, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration((long) this.f46892z);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f46873g, "alpha", new float[]{0.0f, 1.0f});
        ofFloat2.setDuration((long) this.f46892z);
        ofFloat2.start();
        if (this.A == 0.0f) {
            this.A = (this.B / 2.0f) - ((float) (this.f46873g.getWidth() / 2));
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f46873g, "translationX", new float[]{0.0f, -this.A});
        ofFloat3.setDuration((long) this.f46892z);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        ofFloat3.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f46882p, "translationX", new float[]{0.0f, -this.B});
        ofFloat4.setDuration((long) this.f46892z);
        ofFloat4.start();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f46883q, "translationX", new float[]{this.B, 0.0f});
        ofFloat5.setDuration((long) this.f46892z);
        ofFloat5.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.D, this.E});
        ofInt.addUpdateListener(new c9(this, (FrameLayout.LayoutParams) this.f46868b.getLayoutParams()));
        ofInt.setDuration((long) this.f46892z);
        ofInt.start();
        if (this.f46889w.isExchangeIn()) {
            str = m.m(stableCoinCreate.getRate(), PrecisionUtil.p());
        } else if (m.a(stableCoinCreate.getRate()).compareTo(BigDecimal.ZERO) == 0) {
            str = this.f46890x.getAskRate().toPlainString();
        } else {
            str = BigDecimal.ONE.divide(this.f46890x.getAskRate(), PrecisionUtil.p(), RoundingMode.DOWN).toPlainString();
        }
        this.f46884r.setText(String.format(getString(R.string.stable_currency_exchange_dialog_rate), new Object[]{StringUtils.i(this.f46889w.getFromCurrency()), StringUtils.i(this.f46889w.getToCurrency()), getString(R.string.stable_currency_base_rate), str}));
        TextView textView = this.f46885s;
        String string = getString(R.string.two_label_with_space);
        String outCurrency = stableCoinCreate.getOutCurrency();
        Locale locale = Locale.US;
        textView.setText(String.format(string, new Object[]{m.m(stableCoinCreate.getOutAmount(), PrecisionUtil.o()), StringUtils.i(outCurrency.toUpperCase(locale))}));
        this.f46886t.setText(String.format(getString(R.string.two_label_with_space), new Object[]{m.m(stableCoinCreate.getInAmount(), PrecisionUtil.o()), StringUtils.i(stableCoinCreate.getInCurrency().toUpperCase(locale))}));
        this.F = Observable.interval(0, 1, TimeUnit.SECONDS).take(16).map(new u8(15)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e());
    }

    public void Rh() {
        String str;
        this.f46870d.setVisibility(0);
        if (this.f46889w.isExchangeIn()) {
            this.f46871e.setText(String.format(getString(R.string.stable_currency_exchange_dialog_rate), new Object[]{StringUtils.i(this.f46889w.getFromCurrency()), StringUtils.i(this.f46889w.getToCurrency()), getString(R.string.stable_currency_base_rate), this.f46890x.getBidRate().toPlainString()}));
        } else {
            if (this.f46890x.getAskRate().compareTo(BigDecimal.ZERO) == 0) {
                str = m.q(this.f46890x.getAskRate(), PrecisionUtil.p());
            } else {
                str = BigDecimal.ONE.divide(this.f46890x.getAskRate(), PrecisionUtil.p(), RoundingMode.DOWN).toPlainString();
            }
            this.f46871e.setText(String.format(getString(R.string.stable_currency_exchange_dialog_rate), new Object[]{StringUtils.i(this.f46889w.getFromCurrency()), StringUtils.i(this.f46889w.getToCurrency()), getString(R.string.stable_currency_base_rate), str}));
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f46872f, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration((long) this.f46892z);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f46873g, "alpha", new float[]{1.0f, 0.0f});
        ofFloat2.setDuration((long) this.f46892z);
        ofFloat2.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f46873g, "translationX", new float[]{-this.A, 0.0f});
        ofFloat3.setDuration((long) this.f46892z);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        ofFloat3.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f46882p, "translationX", new float[]{-this.B, 0.0f});
        ofFloat4.setDuration((long) this.f46892z);
        ofFloat4.start();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f46883q, "translationX", new float[]{0.0f, this.B});
        ofFloat5.setDuration((long) this.f46892z);
        ofFloat5.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.E, this.D});
        ofInt.addUpdateListener(new s8(this, (FrameLayout.LayoutParams) this.f46868b.getLayoutParams()));
        ofInt.setDuration((long) this.f46892z);
        ofInt.start();
        Subscription subscription = this.F;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void Sh() {
        Subscription subscription = this.H;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public boolean Th(String str) {
        BigDecimal bigDecimal;
        BigDecimal a11 = m.a(str);
        if (this.f46889w.isExchangeIn()) {
            bigDecimal = m.a(this.f46889w.getStableAvailable());
        } else {
            bigDecimal = m.a(this.f46889w.getAvailable());
        }
        if (a11 == null || a11.compareTo(bigDecimal) <= 0) {
            return true;
        }
        HuobiToastUtil.m(String.format(getResources().getString(R.string.currency_stable_convert_over_limit_total), new Object[]{bigDecimal.toPlainString(), this.f46889w.getFromCurrency().toUpperCase(Locale.US)}));
        return false;
    }

    public void Uh(String str) {
        if (Th(str)) {
            SoftInputUtils.g(getActivity(), this.f46877k);
            StableCurrencyRateConfigUtil.a(MapParamsBuilder.c().a("out-currency", this.f46889w.getFromCurrency()).a("in-currency", this.f46889w.getToCurrency()).a("out-amount", str).b()).compose(RxJavaHelper.t((g) null)).subscribe(new b());
        }
    }

    public g Vh() {
        return this.I;
    }

    public void addEvent(r rVar) {
        this.f46877k.setOnFocusChangeListener(new i9(this));
        this.f46880n.setOnClickListener(new g9(this));
        this.f46877k.addTextChangedListener(new a());
        this.f46881o.setOnClickListener(new e9(this));
        this.f46872f.setOnClickListener(new f9(this));
        this.f46888v.setOnClickListener(new h9(this));
        this.f46887u.setOnClickListener(new d9(this));
    }

    public void afterInit() {
        l3();
        ki();
    }

    public int getContentViewResId() {
        return R.layout.dialog_stable_currency_exchange;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.B = (float) n.g(getActivity());
        this.C = n.f(getActivity()) / 2;
        this.f46868b = (RelativeLayout) rVar.b(R.id.exchange_root_rl);
        this.f46869c = (RelativeLayout) rVar.b(R.id.dialog_top_cl);
        this.f46870d = (TextView) rVar.b(R.id.dialog_title_tv);
        this.f46871e = (TextView) rVar.b(R.id.exchange_rate_tv);
        this.f46874h = (TextView) rVar.b(R.id.platform_total_exchange_title_tv);
        this.f46875i = (TextView) rVar.b(R.id.platform_total_exchange_tv);
        this.f46876j = (CommonAllEditText) rVar.b(R.id.stable_currency_exchange_et);
        this.f46878l = (TextView) rVar.b(R.id.exchange_available_tv);
        this.f46877k = this.f46876j.getEditText();
        this.f46879m = (TextView) rVar.b(R.id.exchange_hint_tv);
        this.f46880n = (TextView) rVar.b(R.id.dialog_close_tv);
        this.f46881o = (ProgressConfirmButton) rVar.b(R.id.exchange_confirm_tv);
        this.f46872f = (ImageView) rVar.b(R.id.dialog_back_iv);
        this.f46873g = (TextView) rVar.b(R.id.dialog_center_title_tv);
        this.f46882p = (ConstraintLayout) rVar.b(R.id.input_exchange_amount_cl);
        this.f46883q = (RelativeLayout) rVar.b(R.id.exchange_confirm_rl);
        this.f46884r = (TextView) rVar.b(R.id.confirm_rate_tv);
        this.f46885s = (TextView) rVar.b(R.id.confirm_exchange_out_tv);
        this.f46886t = (TextView) rVar.b(R.id.confirm_exchange_in_tv);
        this.f46887u = (TextView) rVar.b(R.id.exchange_cancel_tv);
        this.f46888v = (ProgressConfirmButton) rVar.b(R.id.exchange_second_confirm_tv);
        this.f46883q.setVisibility(0);
        this.f46883q.setTranslationX(this.B);
        setCanceledOnTouchOutside(false);
    }

    public boolean isTransparent() {
        return true;
    }

    public final void ki() {
        this.H = Observable.zip(mi().flatMap(z8.f47433b).filter(new w8(this)).doOnNext(new k9(this)), li(), oi().flatMap(a9.f47045b).filter(new v8(this)), new b9(this)).compose(RxJavaHelper.t(Vh())).subscribe(q6.d.c(Vh(), new t8(this)));
    }

    public final void l3() {
        String str;
        if (this.f46889w != null) {
            this.f46870d.setText(String.format(getString(R.string.currency_stable_exchange_dialog_title), new Object[]{StringUtils.i(this.f46889w.getFromCurrency()), StringUtils.i(this.f46889w.getToCurrency())}));
            if (this.f46889w.isExchangeIn()) {
                this.f46871e.setText(String.format(getString(R.string.stable_currency_exchange_dialog_rate), new Object[]{StringUtils.i(this.f46889w.getFromCurrency()), StringUtils.i(this.f46889w.getToCurrency()), getString(R.string.stable_currency_base_rate), this.f46890x.getBidRate().toPlainString()}));
                this.f46874h.setText(String.format(getString(R.string.currency_stable_exchange_total_exchange_in), new Object[]{StringUtils.i(this.f46889w.getFromCurrency())}));
                this.f46875i.setText(m.m(this.f46890x.getInMaxAmount(), PrecisionUtil.o()));
                this.f46878l.setText(String.format(getString(R.string.etf_redemption_available), new Object[]{m.m(this.f46889w.getStableAvailable(), PrecisionUtil.o()), StringUtils.i(this.f46890x.getCurrency())}));
                this.f46876j.setAllText(m.m(this.f46889w.getStableAvailable(), PrecisionUtil.o()));
            } else {
                if (this.f46890x.getAskRate().compareTo(BigDecimal.ZERO) == 0) {
                    str = m.q(this.f46890x.getAskRate(), PrecisionUtil.p());
                } else {
                    str = BigDecimal.ONE.divide(this.f46890x.getAskRate(), PrecisionUtil.p(), RoundingMode.DOWN).toPlainString();
                }
                this.f46871e.setText(String.format(getString(R.string.stable_currency_exchange_dialog_rate), new Object[]{StringUtils.i(this.f46889w.getFromCurrency()), StringUtils.i(this.f46889w.getToCurrency()), getString(R.string.stable_currency_base_rate), str}));
                this.f46874h.setText(String.format(getString(R.string.currency_stable_exchange_total_exchange_out), new Object[]{StringUtils.i(this.f46889w.getToCurrency())}));
                this.f46875i.setText(m.m(this.f46890x.getOutMaxAmount(), PrecisionUtil.o()));
                this.f46878l.setText(String.format(getString(R.string.etf_redemption_available), new Object[]{m.m(this.f46889w.getAvailable(), PrecisionUtil.o()), StringUtils.i(this.f46889w.getFromCurrency())}));
                this.f46876j.setAllText(m.m(this.f46889w.getAvailable(), PrecisionUtil.o()));
            }
            this.f46876j.setCurrencyUnitText(StringUtils.i(this.f46889w.getFromCurrency()));
            if (this.f46889w.getStableCoinHints() != null) {
                String normalHint = this.f46889w.getStableCoinHints().getNormalHint();
                if (!TextUtils.isEmpty(normalHint)) {
                    String replaceAll = normalHint.replaceAll("!>_<!", "\n·");
                    TextView textView = this.f46879m;
                    textView.setText("·" + replaceAll);
                }
            }
            i.b().f(new j9(this));
        }
    }

    public final Observable<BalanceQueryData> li() {
        return h2.t1().v3(this.f46889w.getTradeType(), false).subscribeOn(Schedulers.io());
    }

    public final Observable<List<StableCurrencyRateBean.StableCurrencyBean>> mi() {
        return StableCurrencyRateConfigUtil.e(false).compose(RxJavaHelper.t(Vh()));
    }

    public void ni() {
        mi().flatMap(y8.f47414b).filter(new x8(this)).subscribe(new d());
    }

    public final Observable<List<StableCoinHints>> oi() {
        return StableCurrencyRateConfigUtil.c(false).compose(RxJavaHelper.t(Vh())).timeout(5000, TimeUnit.MILLISECONDS).onErrorResumeNext(Observable.just(null));
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Subscription subscription = this.F;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.onDismiss(dialogInterface);
    }

    public void onPause() {
        super.onPause();
        EditText editText = this.f46877k;
        if (editText != null) {
            editText.setText("");
        }
        ProgressConfirmButton progressConfirmButton = this.f46881o;
        if (progressConfirmButton != null) {
            progressConfirmButton.c();
        }
        ProgressConfirmButton progressConfirmButton2 = this.f46888v;
        if (progressConfirmButton2 != null) {
            progressConfirmButton2.c();
        }
        Subscription subscription = this.G;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Sh();
    }

    public void pi(StableCoinCreate stableCoinCreate) {
        if (stableCoinCreate != null) {
            this.G = StableCurrencyRateConfigUtil.g(stableCoinCreate.getOrderId()).compose(RxJavaHelper.t((g) null)).subscribe(new c());
        }
    }

    public void qi(StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean) {
        this.f46890x = stableCurrencyBean;
    }

    public void ri() {
        this.f46888v.b();
    }

    public void si() {
        this.f46888v.c();
    }

    public boolean useWindowBg() {
        return false;
    }
}
