package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.coupon.bean.CouponReturn;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;
import vp.l;

public class ExperienceItem extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public e f79770b;

    /* renamed from: c  reason: collision with root package name */
    public CouponReturn f79771c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f79772d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f79773e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f79774f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f79775g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79776h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f79777i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f79778j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f79779k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f79780l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f79781m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f79782n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f79783o;

    public class a implements Action1<Void> {
        public a() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (ExperienceItem.this.f79770b != null) {
                ExperienceItem.this.f79770b.l0(ExperienceItem.this.f79772d, ExperienceItem.this.f79771c);
            }
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            ExperienceItem.this.f79774f.setVisibility(8);
            ExperienceItem.this.f79775g.setVisibility(0);
            if (ExperienceItem.this.f79771c != null) {
                ExperienceItem.this.f79771c.expanded = !ExperienceItem.this.f79771c.expanded;
            }
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            ExperienceItem.this.f79774f.setVisibility(0);
            ExperienceItem.this.f79775g.setVisibility(8);
            if (ExperienceItem.this.f79771c != null) {
                ExperienceItem.this.f79771c.expanded = !ExperienceItem.this.f79771c.expanded;
            }
        }
    }

    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        public void onGlobalLayout() {
            if (ExperienceItem.this.f79778j.getLineCount() > 0) {
                if (ExperienceItem.this.f79778j.getLineCount() > 1) {
                    ExperienceItem.this.f79782n.setVisibility(0);
                } else {
                    ExperienceItem.this.f79782n.setVisibility(8);
                }
                ExperienceItem.this.f79778j.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    public interface e {
        void l0(View view, CouponReturn couponReturn);
    }

    public ExperienceItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: setDataBoxData */
    public void l(String str) {
        try {
            if (this.f79777i.getPaint().measureText(str) >= ((float) this.f79773e.getMeasuredWidth())) {
                int indexOf = str.indexOf(InstructionFileId.DOT) - 4;
                str = str.substring(0, indexOf) + "\n" + str.substring(indexOf);
            }
            this.f79777i.setText(str);
        } catch (Exception unused) {
        }
    }

    private void setTextView(CouponReturn couponReturn) {
        this.f79778j.setText(couponReturn.getRules());
        TextView textView = this.f79779k;
        textView.setText(couponReturn.getRules() + "\n\n" + getResources().getString(R$string.n_channel_with_colon) + couponReturn.getCouponSource());
        this.f79778j.getViewTreeObserver().addOnGlobalLayoutListener(new d());
        if (couponReturn.expanded) {
            this.f79774f.setVisibility(8);
            this.f79775g.setVisibility(0);
            return;
        }
        this.f79774f.setVisibility(0);
        this.f79775g.setVisibility(8);
    }

    public final void i() {
        Observable<Void> a11 = dw.a.a(this.f79781m);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new a());
        dw.a.a(this.f79774f).throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f79775g).throttleFirst(300, timeUnit).subscribe(new c());
    }

    public void j(CouponReturn couponReturn) {
        String str;
        if (couponReturn != null) {
            this.f79771c = couponReturn;
            this.f79772d.setVisibility(0);
            String h11 = DateTimeUtils.h(couponReturn.getValidAt(), "yyyy.MM.dd");
            if (couponReturn.getSavingsEffectDays() != null && couponReturn.getSavingsEffectDays().intValue() > 0) {
                str = String.format(getResources().getString(R$string.n_experience_coupon_convert_expire_desc), new Object[]{h11, couponReturn.getSavingsEffectDays().toString()});
            } else {
                str = String.format(getResources().getString(R$string.n_coupon_time_dealine), new Object[]{h11});
            }
            String baseCurrency = couponReturn.getBaseCurrency();
            String str2 = "";
            if (baseCurrency != null && !str2.equals(baseCurrency)) {
                str2 = baseCurrency.toUpperCase();
            }
            TextView textView = this.f79776h;
            textView.setText(couponReturn.getAmount() + " " + str2 + " " + couponReturn.getTitle());
            this.f79773e.postDelayed(new l(this, str), 100);
            try {
                if (Integer.valueOf(couponReturn.getMeetCondition()).intValue() > 0) {
                    this.f79780l.setVisibility(0);
                    this.f79780l.setText(String.format(getResources().getString(R$string.n_contract_coupon_convert_limit_simply_desc), new Object[]{couponReturn.getMeetCondition()}));
                } else {
                    this.f79780l.setVisibility(8);
                }
            } catch (NumberFormatException unused) {
            }
            m(couponReturn);
            setTextView(couponReturn);
        }
    }

    public final void k(Context context) {
        LayoutInflater.from(context).inflate(R$layout.view_bbin_return_item, this, true);
        this.f79772d = (LinearLayout) findViewById(R$id.ll_bbin);
        this.f79776h = (TextView) findViewById(R$id.tv_title);
        this.f79773e = (LinearLayout) findViewById(R$id.ll_time);
        this.f79774f = (LinearLayout) findViewById(R$id.ll_head_content);
        this.f79775g = (LinearLayout) findViewById(R$id.ll_content);
        this.f79777i = (TextView) findViewById(R$id.tv_array_date);
        this.f79778j = (TextView) findViewById(R$id.tv_head_content);
        this.f79781m = (ImageView) findViewById(R$id.coupon_select_iv);
        this.f79779k = (TextView) findViewById(R$id.tv_content);
        this.f79782n = (ImageView) findViewById(R$id.iv_down);
        this.f79783o = (ImageView) findViewById(R$id.iv_close);
        this.f79780l = (TextView) findViewById(R$id.tv_use_limit);
        i();
    }

    public final void m(CouponReturn couponReturn) {
        int i11;
        if (getContext() != null) {
            ImageView imageView = this.f79781m;
            if (couponReturn.isSelected()) {
                i11 = R$drawable.common_check_selected;
            } else {
                i11 = R$drawable.common_check_unselected;
            }
            imageView.setImageResource(i11);
        }
    }

    public void setExCallback(e eVar) {
        this.f79770b = eVar;
    }

    public ExperienceItem(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k(context);
    }
}
