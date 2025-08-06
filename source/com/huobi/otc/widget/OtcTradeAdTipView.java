package com.huobi.otc.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import java.util.concurrent.TimeUnit;
import jp.b1;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import rx.Observable;
import vp.l0;
import vp.m0;

public class OtcTradeAdTipView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f80061b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80062c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f80063d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f80064e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f80065f;

    /* renamed from: g  reason: collision with root package name */
    public int f80066g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f80067h;

    /* renamed from: i  reason: collision with root package name */
    public e f80068i;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f80069b;

        public a(int i11) {
            this.f80069b = i11;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            OtcTradeAdTipView.this.f80063d.setTranslationY((float) intValue);
            if (OtcTradeAdTipView.this.f80068i != null) {
                OtcTradeAdTipView.this.f80068i.b((-this.f80069b) + intValue);
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            OtcTradeAdTipView.this.k();
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            OtcTradeAdTipView.this.k();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f80072b;

        public c(int i11) {
            this.f80072b = i11;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            OtcTradeAdTipView.this.f80063d.setTranslationY((float) intValue);
            if (OtcTradeAdTipView.this.f80068i != null) {
                OtcTradeAdTipView.this.f80068i.b((-this.f80072b) + intValue);
            }
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            boolean unused = OtcTradeAdTipView.this.f80065f = false;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            boolean unused = OtcTradeAdTipView.this.f80065f = false;
        }
    }

    public interface e {
        void a(int i11);

        void b(int i11);

        void c();
    }

    public OtcTradeAdTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Void voidR) {
        g();
        b1.q(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(Void voidR) {
        View.OnClickListener onClickListener = this.f80067h;
        if (onClickListener != null) {
            onClickListener.onClick(this.f80062c);
        }
    }

    public void g() {
        this.f80064e = false;
        if (getVisibility() == 0) {
            int a11 = UIUtil.a(getContext(), 10.0d);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, (-this.f80066g) + a11});
            ofInt.setDuration(270);
            ofInt.addUpdateListener(new a(a11));
            ofInt.addListener(new b());
            ofInt.start();
        }
    }

    public final void h(Context context) {
        setBackgroundResource(R$drawable.shape_order_ad_tip_btn);
        setGravity(16);
        View.inflate(context, R$layout.otc_trade_ad_tip_layout, this);
        this.f80063d = (LinearLayout) findViewById(R$id.ll_ad_open_tip);
        this.f80061b = (ImageView) findViewById(R$id.iv_close_tip);
        this.f80062c = (TextView) findViewById(R$id.tv_des);
        String string = getResources().getString(R$string.n_otc_advert_opt_button_text_to_advert);
        String str = getResources().getString(R$string.n_otc_advert_opt_ad_maker_state_tip) + string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf = str.indexOf(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R$color.baseColorMajorTheme100)), indexOf, string.length() + indexOf, 34);
        this.f80062c.setText(spannableStringBuilder);
        Observable<Void> a11 = dw.a.a(this.f80061b);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new m0(this));
        dw.a.a(this.f80062c).throttleFirst(1, timeUnit).subscribe(new l0(this));
    }

    public final void k() {
        if (getVisibility() == 0) {
            setVisibility(8);
            e eVar = this.f80068i;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    public final void l() {
        if (!this.f80065f) {
            e eVar = this.f80068i;
            if (eVar != null) {
                eVar.a(this.f80066g);
            }
            this.f80065f = true;
            int a11 = UIUtil.a(getContext(), 10.0d);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{(-this.f80066g) + a11, 0});
            ofInt.setDuration(270);
            ofInt.addUpdateListener(new c(a11));
            ofInt.addListener(new d());
            ofInt.start();
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f80066g = Math.max(this.f80066g, i12);
        if (this.f80064e) {
            this.f80064e = false;
            l();
        }
    }

    public void setMOnGoToAdClick(View.OnClickListener onClickListener) {
        this.f80067h = onClickListener;
    }

    public void setOnTipAnimListener(e eVar) {
        this.f80068i = eVar;
    }
}
