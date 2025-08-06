package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.widgets.NumberAnimView;
import i6.m;
import java.math.BigDecimal;

public class NumAnimTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public NumberAnimView.b f71545b;

    /* renamed from: c  reason: collision with root package name */
    public BigDecimal f71546c = BigDecimal.ZERO;

    /* renamed from: d  reason: collision with root package name */
    public BigDecimal f71547d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f71548e;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            NumAnimTextView numAnimTextView = NumAnimTextView.this;
            numAnimTextView.i(numAnimTextView.f71546c);
        }
    }

    public NumAnimTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        i(this.f71547d.multiply(new BigDecimal(((Integer) valueAnimator.getAnimatedValue()).intValue())));
    }

    public void g() {
        ValueAnimator valueAnimator = this.f71548e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f71548e.cancel();
        }
    }

    public final void i(BigDecimal bigDecimal) {
        String str;
        NumberAnimView.b bVar = this.f71545b;
        if (bVar == null) {
            str = bigDecimal.toPlainString();
        } else {
            str = bVar.a(bigDecimal.toPlainString());
        }
        setText(str);
    }

    public void j() {
        this.f71547d = this.f71546c.divide(new BigDecimal(50), 2);
        ValueAnimator valueAnimator = this.f71548e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f71548e.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{1, 50});
        this.f71548e = ofInt;
        ofInt.addListener(new a());
        this.f71548e.addUpdateListener(new h1(this));
        this.f71548e.setDuration(500);
        this.f71548e.start();
    }

    public void setCallback(NumberAnimView.b bVar) {
        this.f71545b = bVar;
    }

    public void setNumber(BigDecimal bigDecimal) {
        this.f71546c = bigDecimal;
        i(bigDecimal);
    }

    public NumAnimTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public void setNumber(String str) {
        BigDecimal a11 = m.a(str);
        this.f71546c = a11;
        i(a11);
    }
}
