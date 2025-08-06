package com.huobi.otc.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.core.util.TransferAccountType;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.coupon.bean.Coupon;
import com.huobi.otc.widget.CouponCountDown;
import com.huobi.view.CouponCardView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;
import vp.d;
import vp.e;
import vp.f;
import vp.g;
import vp.h;

public class CouponItem extends RelativeLayout implements CouponCountDown.b {

    /* renamed from: b  reason: collision with root package name */
    public CouponCardView f79699b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79700c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79701d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79702e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79703f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79704g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79705h;

    /* renamed from: i  reason: collision with root package name */
    public CouponCountDown f79706i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f79707j;

    /* renamed from: k  reason: collision with root package name */
    public ProgressBar f79708k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f79709l;

    /* renamed from: m  reason: collision with root package name */
    public c f79710m;

    /* renamed from: n  reason: collision with root package name */
    public Coupon f79711n;

    /* renamed from: o  reason: collision with root package name */
    public HBDialogFragment f79712o;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f79713p;

    /* renamed from: q  reason: collision with root package name */
    public LinearLayout f79714q;

    /* renamed from: r  reason: collision with root package name */
    public AmountTextView f79715r;

    /* renamed from: s  reason: collision with root package name */
    public SignalTextView f79716s;

    /* renamed from: t  reason: collision with root package name */
    public View f79717t;

    /* renamed from: u  reason: collision with root package name */
    public View f79718u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f79719v;

    /* renamed from: w  reason: collision with root package name */
    public View f79720w;

    public class a implements Action1<Void> {
        public a() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (CouponItem.this.f79710m != null) {
                CouponItem.this.f79710m.e(CouponItem.this.f79699b, CouponItem.this.f79711n);
            }
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (CouponItem.this.f79710m != null) {
                CouponItem.this.f79710m.b(CouponItem.this.f79707j, CouponItem.this.f79711n);
            }
        }
    }

    public interface c {
        void b(View view, Coupon coupon);

        void c(HBDialogFragment hBDialogFragment, Coupon coupon);

        void d(Coupon coupon);

        void e(View view, Coupon coupon);

        Activity getRootActivity();
    }

    public CouponItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.f79706i.measure(0, 0);
        if (this.f79706i.getMeasuredWidth() + this.f79705h.getMeasuredWidth() > this.f79714q.getMeasuredWidth()) {
            this.f79714q.setOrientation(1);
            TextView textView = this.f79705h;
            textView.setPadding(textView.getPaddingLeft(), this.f79705h.getPaddingTop(), this.f79705h.getPaddingRight(), (int) (((float) this.f79705h.getPaddingBottom()) + getContext().getResources().getDimension(R$dimen.dimen_2)));
            return;
        }
        this.f79714q.setOrientation(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(HBDialogFragment hBDialogFragment) {
        c cVar = this.f79710m;
        if (cVar != null) {
            cVar.c((HBDialogFragment) null, (Coupon) null);
        }
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: setDataBoxData */
    public void q(String str) {
        try {
            if (this.f79704g.getPaint().measureText(str) >= ((float) this.f79714q.getMeasuredWidth())) {
                int indexOf = str.indexOf(InstructionFileId.DOT) - 4;
                str = str.substring(0, indexOf) + "\n" + str.substring(indexOf);
            }
            this.f79704g.setText(str);
        } catch (Exception unused) {
        }
    }

    private void setLeftVisible(int i11) {
        this.f79715r.setVisibility(i11);
        this.f79716s.setVisibility(i11);
        this.f79700c.setVisibility(i11);
        this.f79708k.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(Coupon coupon, View view) {
        c cVar = this.f79710m;
        Activity activity = cVar != null ? (FragmentActivity) cVar.getRootActivity() : null;
        if (activity == null) {
            activity = oa.a.g().b();
        }
        HBDialogFragment j02 = new DialogUtils.b.d((FragmentActivity) activity).c1(getResources().getString(R$string.n_coupon_used_rules)).C0(coupon.getRules()).R0("").T0(true).q0(false).P0(getResources().getString(R$string.n_known)).Q0(new e(this)).j0();
        this.f79712o = j02;
        j02.show(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), "");
        c cVar2 = this.f79710m;
        if (cVar2 != null) {
            cVar2.c(this.f79712o, this.f79711n);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void a() {
        HBDialogFragment hBDialogFragment = this.f79712o;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            this.f79712o.dismiss();
        }
        c cVar = this.f79710m;
        if (cVar != null) {
            cVar.d(this.f79711n);
        }
    }

    public CouponCardView getCouponCardView() {
        return this.f79699b;
    }

    public TextView getTextViewCouponItemDesc() {
        return this.f79702e;
    }

    public TextView getTextViewCouponItemRule() {
        return this.f79703f;
    }

    public TextView getTextViewCouponItemUse() {
        return this.f79707j;
    }

    public final void k() {
        Observable<Void> a11 = dw.a.a(this.f79699b);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new a());
        dw.a.a(this.f79707j).throttleFirst(300, timeUnit).subscribe(new b());
    }

    public void l(Coupon coupon) {
        if (coupon != null) {
            this.f79711n = coupon;
            this.f79717t.setVisibility(8);
            setLeftVisible(0);
            TransferAccountType transferAccountType = TransferAccountType.SPOT;
            if (transferAccountType.type.equalsIgnoreCase(coupon.getBusinessType())) {
                this.f79715r.setVisibility(0);
                this.f79716s.setVisibility(8);
                this.f79715r.f(coupon.getQuoteSign(), o(coupon.getAmount()));
                this.f79700c.setText(getResources().getString(R$string.n_coupon_type_discount));
                this.f79701d.setText(getResources().getString(R$string.n_coupon_exchange_title));
                this.f79702e.setText(getResources().getString(R$string.n_coupon_exchange_rule_content));
                this.f79699b.setLeftColor(getResources().getColor(R$color.baseColorShadeFunctionButtonStart));
                this.f79707j.setBackgroundResource(R$drawable.shape_2c72f5_border);
                this.f79707j.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
            } else if (Coupon.SAVINGS.equals(coupon.getBusinessType())) {
                this.f79715r.setVisibility(8);
                this.f79716s.setVisibility(0);
                if (m.a0(coupon.getAmount())) {
                    this.f79716s.f(new BigDecimal(coupon.getAmount()).multiply(BigDecimal.valueOf(100)).stripTrailingZeros().toPlainString(), "%");
                } else {
                    this.f79716s.f("0", "%");
                }
                this.f79700c.setText(getResources().getString(R$string.n_coupon_type_saving));
                this.f79701d.setText(String.format(getResources().getString(R$string.n_coupon_saving_title), new Object[]{coupon.getBaseCurrency()}));
                this.f79702e.setText(String.format(getResources().getString(R$string.n_coupon_saving_desc), new Object[]{coupon.getMeetCondition(), Integer.valueOf(coupon.getSavingsEffectDays())}));
                this.f79699b.setLeftColor(getResources().getColor(R$color.baseColorShadeFunctionButtonStart));
                this.f79707j.setBackgroundResource(R$drawable.shape_2c72f5_border);
                this.f79707j.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
            } else if (Coupon.PRIME_LIST.equals(coupon.getBusinessType())) {
                n(coupon, coupon.getType() == 8);
            } else if (Coupon.CANDY_DROP.equals(coupon.getBusinessType())) {
                m(coupon, coupon.getType() == 8);
            } else {
                this.f79715r.setVisibility(0);
                this.f79716s.setVisibility(8);
                this.f79715r.f(coupon.getQuoteSign(), o(coupon.getAmount()));
                this.f79700c.setText(getResources().getString(R$string.n_coupon_type_full_reduction));
                this.f79701d.setText(String.format(getResources().getString(R$string.n_coupon_otc_title), new Object[]{coupon.getQuoteSign(), o(coupon.getMeetCondition())}));
                this.f79702e.setText(String.format(getResources().getString(R$string.n_coupon_otc_rule_content), new Object[]{coupon.getBaseCurrency().replace("/", Constants.ACCEPT_TIME_SEPARATOR_SP)}));
                this.f79699b.setLeftColor(getResources().getColor(R$color.coupon_dialog_card_bg_color));
                this.f79707j.setBackgroundResource(R$drawable.shape_03ad8f_border);
                this.f79707j.setTextColor(getResources().getColor(R$color.otc_face_result_success));
            }
            int state = coupon.getState();
            if (state == -1) {
                this.f79707j.setText(getResources().getString(R$string.n_coupon_state_pending_button));
                this.f79708k.setVisibility(8);
            } else if (state == 1) {
                this.f79707j.setText(getResources().getString(R$string.n_coupon_state_using));
                if (transferAccountType.type.equalsIgnoreCase(coupon.getBusinessType())) {
                    this.f79708k.setVisibility(0);
                    try {
                        this.f79708k.setMax(100);
                        this.f79708k.setProgress((int) ((coupon.getUsedHP() / Double.parseDouble(coupon.getAmount())) * 100.0d));
                    } catch (NumberFormatException unused) {
                    }
                } else {
                    this.f79708k.setVisibility(8);
                }
            } else if (state == 2) {
                this.f79707j.setText(getResources().getString(R$string.n_coupon_state_used));
                this.f79708k.setVisibility(8);
                this.f79699b.setLeftColor(getResources().getColor(R$color.baseColorDisableButton));
                this.f79707j.setBackgroundResource(R$drawable.shape_dark_border);
                this.f79707j.setTextColor(getResources().getColor(R$color.coupon_unenable_button));
            } else if (state != 3) {
                this.f79707j.setText(getResources().getString(R$string.n_coupon_state_wait_use_button));
                this.f79708k.setVisibility(8);
            } else {
                this.f79707j.setText(getResources().getString(R$string.n_coupon_state_expired));
                this.f79708k.setVisibility(8);
                this.f79699b.setLeftColor(getResources().getColor(R$color.baseColorDisableButton));
                this.f79707j.setBackgroundResource(R$drawable.shape_dark_border);
                this.f79707j.setTextColor(getResources().getColor(R$color.coupon_unenable_button));
            }
            if (coupon.getEndTime() == 0) {
                this.f79706i.setVisibility(8);
                this.f79705h.setVisibility(8);
                this.f79704g.setVisibility(8);
            } else {
                long sysTime = coupon.getSysTime();
                if (coupon.getEndTime() < sysTime || coupon.getEndTime() - sysTime > Period.MIN60_MILLS || coupon.getState() == 3 || coupon.getState() == 2) {
                    this.f79706i.setVisibility(8);
                    this.f79705h.setVisibility(8);
                    this.f79704g.setVisibility(0);
                    this.f79714q.postDelayed(new h(this, String.format(getResources().getString(R$string.n_coupon_time_dealine), new Object[]{DateTimeUtils.h(coupon.getEndTime(), "yyyy.MM.dd")})), 100);
                } else {
                    this.f79706i.setVisibility(0);
                    this.f79705h.setVisibility(0);
                    this.f79704g.setVisibility(8);
                    this.f79706i.setOnCouponCountDownDone(this);
                    this.f79706i.setCountDownTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
                    this.f79706i.e(coupon.getEndTime() - sysTime);
                    this.f79714q.postDelayed(new g(this), 200);
                }
            }
            v(coupon);
            d dVar = new d(this, coupon);
            this.f79703f.setOnClickListener(dVar);
            this.f79702e.setOnClickListener(dVar);
            this.f79713p.post(new f(this));
        }
    }

    public final void m(Coupon coupon, boolean z11) {
        int i11;
        int i12;
        Resources resources = getResources();
        if (z11) {
            i11 = R$string.n_coupon_title_CandydropDouble;
        } else {
            i11 = R$string.n_coupon_title_CandydropSureWin;
        }
        String string = resources.getString(i11);
        Resources resources2 = getResources();
        if (z11) {
            i12 = R$string.n_coupon_desc_CandydropDouble;
        } else {
            i12 = R$string.n_coupon_desc_CandydropSureWin;
        }
        String string2 = resources2.getString(i12);
        if (!z11) {
            string2 = String.format(string2, new Object[]{coupon.getAmount() + "%"});
        }
        setLeftVisible(8);
        this.f79717t.setVisibility(0);
        if (z11) {
            this.f79718u.setVisibility(0);
            this.f79720w.setVisibility(8);
        } else {
            this.f79718u.setVisibility(8);
            this.f79720w.setVisibility(0);
        }
        this.f79719v.setText(coupon.getAmount());
        this.f79701d.setText(string);
        this.f79702e.setText(string2);
        this.f79699b.setLeftColor(getResources().getColor(R$color.baseColorShadeFunctionButtonStart));
        this.f79707j.setBackgroundResource(R$drawable.shape_2c72f5_border);
        this.f79707j.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
    }

    public final void n(Coupon coupon, boolean z11) {
        int i11;
        int i12;
        Resources resources = getResources();
        if (z11) {
            i11 = R$string.n_coupon_title_PrimelistDouble;
        } else {
            i11 = R$string.n_coupon_title_PrimelistSureWin;
        }
        String string = resources.getString(i11);
        Resources resources2 = getResources();
        if (z11) {
            i12 = R$string.n_coupon_desc_PrimelistDouble;
        } else {
            i12 = R$string.n_coupon_desc_PrimelistSureWin;
        }
        String string2 = resources2.getString(i12);
        if (!z11) {
            string2 = String.format(string2, new Object[]{coupon.getAmount() + "%"});
        }
        setLeftVisible(8);
        this.f79717t.setVisibility(0);
        if (z11) {
            this.f79718u.setVisibility(0);
            this.f79720w.setVisibility(8);
        } else {
            this.f79718u.setVisibility(8);
            this.f79720w.setVisibility(0);
        }
        this.f79719v.setText(coupon.getAmount());
        this.f79701d.setText(string);
        this.f79702e.setText(string2);
        this.f79699b.setLeftColor(getResources().getColor(R$color.baseColorShadeFunctionButtonStart));
        this.f79707j.setBackgroundResource(R$drawable.shape_2c72f5_border);
        this.f79707j.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
    }

    @SuppressLint({"DefaultLocale"})
    public String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "--";
        }
        try {
            double parseDouble = (double) ((int) Double.parseDouble(str));
            if (parseDouble < 10000.0d) {
                return str;
            }
            if (parseDouble < 1000000.0d) {
                NumberFormat numberInstance = NumberFormat.getNumberInstance();
                numberInstance.setMaximumFractionDigits(2);
                return numberInstance.format(parseDouble / 1000.0d) + "K";
            } else if (parseDouble < 1.0E9d) {
                NumberFormat numberInstance2 = NumberFormat.getNumberInstance();
                numberInstance2.setMaximumFractionDigits(2);
                return numberInstance2.format(parseDouble / 1000000.0d) + "M";
            } else {
                NumberFormat numberInstance3 = NumberFormat.getNumberInstance();
                numberInstance3.setMaximumFractionDigits(2);
                return numberInstance3.format(parseDouble / 1.0E9d) + "B";
            }
        } catch (Exception unused) {
            return "--";
        }
    }

    public final void p(Context context) {
        LayoutInflater.from(context).inflate(R$layout.view_coupon_item, this, true);
        this.f79699b = (CouponCardView) findViewById(R$id.coupon_cart_view_coupon_item);
        this.f79715r = (AmountTextView) findViewById(R$id.amount_text_view_coupon_item);
        this.f79713p = (LinearLayout) findViewById(R$id.linear_layout_coupon_item_rule_box);
        this.f79714q = (LinearLayout) findViewById(R$id.linear_layout_coupon_item_date_box);
        this.f79700c = (TextView) findViewById(R$id.text_view_coupon_item_type);
        this.f79701d = (TextView) findViewById(R$id.auto_size_text_view_coupon_item_title);
        this.f79702e = (TextView) findViewById(R$id.text_view_coupon_item_desc);
        this.f79703f = (TextView) findViewById(R$id.text_view_coupon_item_rule);
        this.f79704g = (TextView) findViewById(R$id.text_view_coupon_item_time);
        this.f79705h = (TextView) findViewById(R$id.text_view_coupon_item_count_down_label);
        this.f79708k = (ProgressBar) findViewById(R$id.progress_bar_coupon_item);
        this.f79706i = (CouponCountDown) findViewById(R$id.prime_count_down_layout_coupon_item);
        this.f79707j = (TextView) findViewById(R$id.text_view_coupon_item_use);
        this.f79709l = (ImageView) findViewById(R$id.coupon_select_iv);
        this.f79716s = (SignalTextView) findViewById(R$id.amount_text_view_coupon_item_percent);
        this.f79717t = findViewById(R$id.ll_left_prime_list);
        this.f79718u = findViewById(R$id.tv_left_prime_list_double_cpo);
        this.f79719v = (TextView) findViewById(R$id.tv_left_prime_list_amount);
        this.f79720w = findViewById(R$id.tv_left_prime_list_100);
        k();
    }

    public void setMCallback(c cVar) {
        this.f79710m = cVar;
    }

    public final void u() {
        if (this.f79703f.getMeasuredWidth() + this.f79702e.getMeasuredWidth() >= this.f79713p.getWidth()) {
            this.f79713p.setOrientation(1);
        } else {
            this.f79713p.setOrientation(0);
        }
    }

    public final void v(Coupon coupon) {
        int i11;
        Context context = getContext();
        if (context != null) {
            if (!coupon.isShowSelected()) {
                this.f79709l.setVisibility(8);
                return;
            }
            this.f79709l.setVisibility(0);
            this.f79707j.setVisibility(8);
            this.f79699b.setEnabled(coupon.isEnable());
            if (!coupon.isEnable() && !coupon.isSelected()) {
                this.f79709l.setImageResource(R$drawable.marquee_banselected);
                this.f79699b.setLeftColor(ContextCompat.getColor(context, R$color.baseColorDisableButton));
                this.f79699b.setStrokeColor(ContextCompat.getColor(context, R$color.baseColorPrimarySeparator));
            } else if (coupon.isEnable() || !coupon.isSelected()) {
                ImageView imageView = this.f79709l;
                if (coupon.isSelected()) {
                    i11 = R$drawable.marquee_selected;
                } else {
                    i11 = R$drawable.marquee_unselected;
                }
                imageView.setImageResource(i11);
                if (coupon.isSelected()) {
                    this.f79699b.setStrokeColor(ContextCompat.getColor(context, R$color.coupon_dialog_card_bg_color));
                } else {
                    this.f79699b.setStrokeColor(ContextCompat.getColor(context, R$color.baseColorPrimarySeparator));
                }
            } else {
                this.f79709l.setImageResource(R$drawable.marquee_selected);
                this.f79699b.setLeftColor(ContextCompat.getColor(context, R$color.baseColorDisableButton));
                this.f79699b.setStrokeColor(ContextCompat.getColor(context, R$color.baseColorPrimarySeparator));
            }
        }
    }

    public CouponItem(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        p(context);
    }
}
