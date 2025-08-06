package com.hbg.lib.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import i6.d;

public class TopScrollItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f71629b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f71630c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71631d;

    /* renamed from: e  reason: collision with root package name */
    public TopScrollData f71632e;

    /* renamed from: f  reason: collision with root package name */
    public int f71633f;

    /* renamed from: g  reason: collision with root package name */
    public int f71634g;

    /* renamed from: h  reason: collision with root package name */
    public TextUtils.TruncateAt f71635h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f71636i;

    /* renamed from: j  reason: collision with root package name */
    public final Interpolator f71637j;

    public interface a {
        void a(TopScrollData topScrollData);
    }

    public TopScrollItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(TopScrollData topScrollData) {
        d.b("TopScrollItemView-->startAnim-->" + this.f71633f + "-->" + this.f71632e + "-->滑上来了");
        this.f71634g = 1;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{(float) getHeight(), 0.0f});
        this.f71636i = ofFloat;
        ofFloat.setInterpolator(this.f71637j);
        this.f71636i.setDuration(500);
        this.f71636i.start();
        a aVar = this.f71629b;
        if (aVar != null) {
            aVar.a(topScrollData);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (this.f71634g == 1) {
            d.b("TopScrollItemView-->continueAnim-->" + this.f71633f + "-->" + this.f71632e + "-->滑出去了");
            this.f71634g = 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{0.0f, (float) (-getHeight())});
            this.f71636i = ofFloat;
            ofFloat.setInterpolator(this.f71637j);
            this.f71636i.setDuration(500);
            this.f71636i.start();
            return;
        }
        d.b("TopScrollItemView-->continueAnim-->" + this.f71633f + "-->" + this.f71632e + "-->没动");
    }

    public void c(TopScrollData topScrollData) {
        this.f71632e = topScrollData;
        d.b("TopScrollItemView-->startAnim-->" + this.f71633f + "-->" + this.f71632e);
        if (topScrollData == null) {
            h();
            return;
        }
        this.f71630c.setText(d(topScrollData.e()));
        this.f71631d.setText(d(topScrollData.f()));
        post(new o1(this, topScrollData));
    }

    public final String d(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public final void e(Context context) {
        this.f71630c = (TextView) LayoutInflater.from(context).inflate(R$layout.text_view_dingpro_regular, (ViewGroup) null);
        this.f71630c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f71630c.setSingleLine();
        this.f71630c.setEllipsize(this.f71635h);
        this.f71630c.setTextColor(getResources().getColor(R$color.global_main_text_color));
        this.f71630c.setTextSize(1, 12.0f);
        addView(this.f71630c);
        this.f71631d = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) getResources().getDimension(R$dimen.dimen_5);
        this.f71631d.setLayoutParams(layoutParams);
        this.f71631d.setSingleLine();
        this.f71631d.setEllipsize(this.f71635h);
        this.f71631d.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
        this.f71631d.setTextSize(1, 12.0f);
        addView(this.f71631d);
    }

    public void h() {
        ObjectAnimator objectAnimator = this.f71636i;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f71636i.cancel();
        }
        this.f71630c.setText("");
        this.f71631d.setText("");
        setTranslationY(0.0f);
        this.f71634g = 0;
    }

    public void i() {
        post(new n1(this));
    }

    public void setCallback(a aVar) {
        this.f71629b = aVar;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f71635h = truncateAt;
        TextView textView = this.f71630c;
        if (textView != null) {
            textView.setEllipsize(truncateAt);
        }
        TextView textView2 = this.f71631d;
        if (textView2 != null) {
            textView2.setEllipsize(truncateAt);
        }
    }

    public void setFirstTextColor(int i11) {
        this.f71630c.setTextColor(i11);
    }

    public void setIndex(int i11) {
        this.f71633f = i11;
    }

    public void setText(TopScrollData topScrollData) {
        String str = "";
        this.f71630c.setText(d(topScrollData == null ? str : topScrollData.e()));
        TextView textView = this.f71631d;
        if (topScrollData != null) {
            str = topScrollData.f();
        }
        textView.setText(d(str));
    }

    public void setTextBold(boolean z11) {
        Typeface h11 = ResourcesCompat.h(getContext(), R$font.roboto_regular);
        this.f71630c.getPaint().setTypeface(h11);
        this.f71631d.getPaint().setTypeface(h11);
    }

    public void setTextSize(int i11) {
        TextView textView = this.f71630c;
        if (textView != null) {
            textView.setTextSize(1, (float) i11);
        }
        TextView textView2 = this.f71631d;
        if (textView2 != null) {
            textView2.setTextSize(1, (float) i11);
        }
    }

    public TopScrollItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71634g = 0;
        this.f71635h = null;
        this.f71637j = new DecelerateInterpolator();
        setOrientation(0);
        setGravity(16);
        e(context);
        if (isInEditMode()) {
            this.f71630c.setText("title");
            this.f71631d.setText("desc");
        }
    }
}
