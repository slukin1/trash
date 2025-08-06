package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$raw;
import com.huobi.otc.widget.DragRelativeLayout;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import rx.Observable;
import rx.functions.Action1;

public class OtcFloatView extends RelativeLayout implements DragRelativeLayout.b {

    /* renamed from: b  reason: collision with root package name */
    public SafeLottieView f79966b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f79967c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f79968d = true;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f79969e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f79970f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f79971g;

    /* renamed from: h  reason: collision with root package name */
    public f f79972h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f79973i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f79974j;

    /* renamed from: k  reason: collision with root package name */
    public Runnable f79975k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f79976l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f79977m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f79978n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f79979o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f79980p;

    public class a implements Action1<Void> {
        public a() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (!OtcFloatView.this.f79970f) {
                if (OtcFloatView.this.f79969e.getVisibility() == 0) {
                    OtcFloatView.this.o(true);
                } else if (OtcFloatView.this.f79971g) {
                    OtcFloatView.this.s();
                } else if (OtcFloatView.this.f79972h != null) {
                    OtcFloatView.this.f79972h.onClick(1);
                }
            }
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (OtcFloatView.this.f79972h != null) {
                OtcFloatView.this.f79972h.onClick(2);
            }
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (OtcFloatView.this.f79972h != null) {
                OtcFloatView.this.m();
                OtcFloatView.this.f79972h.onClick(3);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            boolean unused = OtcFloatView.this.f79967c = false;
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            OtcFloatView.this.f79966b.playAnimation();
        }
    }

    public interface f {
        void onClick(int i11);
    }

    public OtcFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }

    public boolean a() {
        return this.f79969e.getVisibility() == 0;
    }

    public void b() {
        m();
        removeCallbacks(this.f79974j);
        this.f79967c = true;
    }

    public void c(boolean z11) {
        this.f79968d = z11;
        r();
        d dVar = new d();
        this.f79974j = dVar;
        postDelayed(dVar, 1000);
    }

    public void d(boolean z11) {
        this.f79968d = z11;
    }

    public float getTvTranslateX() {
        return this.f79969e.getTranslationX();
    }

    public final void m() {
        this.f79969e.setVisibility(8);
        r();
    }

    public final void n(Context context) {
        View.inflate(context, R$layout.otc_float_view, this);
        this.f79977m = (TextView) findViewById(R$id.tv_left_buy_coin);
        this.f79978n = (TextView) findViewById(R$id.tv_left_faq);
        this.f79979o = (ImageView) findViewById(R$id.iv_left);
        this.f79980p = (ImageView) findViewById(R$id.iv_right);
        this.f79966b = (SafeLottieView) findViewById(R$id.slv_float);
        if (NightHelper.e().g()) {
            this.f79966b.setAnimation(R$raw.faq_otc_huobao_night);
        }
        this.f79966b.setRepeatCount(2);
        this.f79969e = (RelativeLayout) findViewById(R$id.fl_tv);
        m();
        Observable<Void> a11 = dw.a.a(this);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new a());
        dw.a.a(this.f79978n).throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f79977m).throttleFirst(300, timeUnit).subscribe(new c());
    }

    public final void o(boolean z11) {
        m();
        if (z11 && !this.f79971g) {
            setVisibility(8);
            f fVar = this.f79972h;
            if (fVar != null) {
                fVar.onClick(1);
            }
        }
    }

    public void p() {
        this.f79966b.pauseAnimation();
        if (this.f79969e.getVisibility() == 0) {
            o(false);
        }
        Runnable runnable = this.f79973i;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f79975k;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
    }

    public void q() {
        boolean b11 = ConfigPreferences.b("otc_config", "otc_faq_float_close");
        this.f79976l = b11;
        if (b11) {
            setVisibility(8);
            return;
        }
        getParent().requestLayout();
        setVisibility(0);
        if (getAlpha() == 0.0f) {
            animate().alpha(1.0f).setDuration(400).setInterpolator(new DecelerateInterpolator()).start();
        }
        if (this.f79975k == null) {
            this.f79975k = new e();
        }
        removeCallbacks(this.f79975k);
        postDelayed(this.f79975k, 500);
    }

    public final void r() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f79969e.getLayoutParams();
        if (this.f79968d) {
            layoutParams.removeRule(9);
            layoutParams.addRule(11);
            layoutParams.leftMargin = UIUtil.a(getContext(), 60.0d);
            layoutParams.rightMargin = 0;
            layoutParams.width = UIUtil.a(getContext(), 236.0d);
            this.f79969e.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f79966b.getLayoutParams();
            layoutParams2.removeRule(11);
            layoutParams.addRule(9);
            if (this.f79969e.getVisibility() == 0) {
                layoutParams2.rightMargin = UIUtil.a(getContext(), 236.0d);
            } else {
                layoutParams2.rightMargin = 0;
            }
            layoutParams2.leftMargin = 0;
            this.f79966b.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.removeRule(11);
                layoutParams3.addRule(9);
                if (this.f79969e.getVisibility() == 0) {
                    layoutParams3.width = UIUtil.a(getContext(), 296.0d);
                } else {
                    layoutParams3.width = UIUtil.a(getContext(), 60.0d);
                }
                setLayoutParams(layoutParams3);
            }
            this.f79980p.setVisibility(8);
            this.f79979o.setVisibility(0);
            return;
        }
        layoutParams.removeRule(11);
        layoutParams.addRule(9);
        layoutParams.rightMargin = UIUtil.a(getContext(), 60.0d);
        layoutParams.leftMargin = 0;
        layoutParams.width = UIUtil.a(getContext(), 236.0d);
        this.f79969e.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f79966b.getLayoutParams();
        layoutParams4.removeRule(9);
        if (this.f79969e.getVisibility() == 0) {
            layoutParams4.leftMargin = UIUtil.a(getContext(), 236.0d);
        } else {
            layoutParams4.leftMargin = 0;
        }
        layoutParams4.rightMargin = 0;
        layoutParams.addRule(11);
        this.f79966b.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.removeRule(9);
            layoutParams5.addRule(11);
            if (this.f79969e.getVisibility() == 0) {
                layoutParams5.width = UIUtil.a(getContext(), 296.0d);
            } else {
                layoutParams5.width = UIUtil.a(getContext(), 60.0d);
            }
            setLayoutParams(layoutParams5);
        }
        this.f79980p.setVisibility(0);
        this.f79979o.setVisibility(8);
    }

    public boolean s() {
        if (this.f79967c) {
            m();
            return false;
        }
        this.f79969e.setVisibility(0);
        r();
        return true;
    }

    public void setIsClickShowTv(boolean z11) {
        this.f79971g = z11;
        if (!z11 && this.f79969e.getVisibility() == 0) {
            o(false);
        }
    }

    public void setOnFloatViewClickListener(f fVar) {
        this.f79972h = fVar;
    }
}
