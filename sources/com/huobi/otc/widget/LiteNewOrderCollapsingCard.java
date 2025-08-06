package com.huobi.otc.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$font;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import vp.o;
import vp.p;

public class LiteNewOrderCollapsingCard extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f79827b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f79828c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79829d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79830e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79831f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f79832g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f79833h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f79834i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f79835j = true;

    /* renamed from: k  reason: collision with root package name */
    public int f79836k = getResources().getDimensionPixelSize(R$dimen.dimen_35);

    /* renamed from: l  reason: collision with root package name */
    public RotateAnimation f79837l;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            LiteNewOrderCollapsingCard.this.f79833h.setVisibility(8);
        }
    }

    public LiteNewOrderCollapsingCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public static /* synthetic */ void f(View view, int i11, int i12, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i11 <= i12 || intValue < i11) {
            layoutParams.height = intValue;
        } else {
            layoutParams.height = -2;
        }
        view.setLayoutParams(layoutParams);
        view.setAlpha(((float) intValue) / ((float) Math.max(i12, i11)));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        ValueAnimator valueAnimator;
        if (this.f79834i) {
            boolean z11 = !(this.f79833h.getVisibility() == 0);
            h();
            int i11 = this.f79836k;
            if (z11) {
                this.f79835j = false;
                this.f79833h.setVisibility(0);
                valueAnimator = d(this.f79833h, 0, i11);
            } else {
                this.f79835j = true;
                valueAnimator = d(this.f79833h, i11, 0);
                valueAnimator.addListener(new a());
            }
            valueAnimator.start();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final ValueAnimator d(View view, int i11, int i12) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.setDuration(270);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new o(view, i12, i11));
        return ofInt;
    }

    public final void e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f79827b = linearLayout;
        LinearLayout linearLayout2 = linearLayout;
        linearLayout.setGravity(17);
        ((LinearLayout) this.f79827b).setOrientation(1);
        addView(this.f79827b);
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        this.f79828c = linearLayout3;
        LinearLayout linearLayout4 = linearLayout3;
        linearLayout3.setOrientation(0);
        ((LinearLayout) this.f79828c).setGravity(16);
        this.f79829d = new ImageView(getContext());
        Resources resources = getResources();
        int i11 = R$dimen.dimen_20;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(i11), getResources().getDimensionPixelSize(i11));
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R$dimen.dimen_4);
        this.f79828c.addView(this.f79829d, layoutParams);
        TextView textView = new TextView(getContext());
        this.f79830e = textView;
        textView.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
        this.f79830e.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f79830e.setTextSize(0, (float) getResources().getDimensionPixelSize(R$dimen.global_text_size_16));
        this.f79828c.addView(this.f79830e);
        this.f79828c.addView(new Space(getContext()), new LinearLayout.LayoutParams(-1, -2, 1.0f));
        TextView textView2 = new TextView(getContext());
        this.f79831f = textView2;
        textView2.setTextSize(0, (float) getResources().getDimensionPixelSize(R$dimen.dimen_12));
        this.f79831f.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorSecondaryText));
        this.f79828c.addView(this.f79831f);
        ImageView imageView = new ImageView(getContext());
        this.f79832g = imageView;
        imageView.setImageResource(R$drawable.lite_order_arrow);
        this.f79832g.setVisibility(this.f79834i ? 0 : 8);
        this.f79828c.addView(this.f79832g);
        LinearLayout linearLayout5 = new LinearLayout(getContext());
        this.f79833h = linearLayout5;
        LinearLayout linearLayout6 = linearLayout5;
        linearLayout5.setGravity(17);
        ((LinearLayout) this.f79833h).setOrientation(1);
        this.f79828c.setOnClickListener(new p(this));
        this.f79827b.addView(this.f79828c);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        this.f79833h.setPadding(0, getResources().getDimensionPixelSize(R$dimen.dimen_15), 0, 0);
        this.f79827b.addView(this.f79833h, layoutParams2);
    }

    public final void h() {
        if (this.f79833h.getVisibility() == 0) {
            this.f79837l = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        } else {
            this.f79837l = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        }
        this.f79837l.setDuration(270);
        this.f79837l.setInterpolator(new LinearInterpolator());
        this.f79837l.setRepeatMode(2);
        this.f79837l.setFillAfter(true);
        this.f79832g.startAnimation(this.f79837l);
    }

    public void setHeaderViewVisible(boolean z11) {
        ViewUtil.m(this.f79828c, z11);
    }

    public ViewGroup getRootView() {
        return this.f79827b;
    }
}
