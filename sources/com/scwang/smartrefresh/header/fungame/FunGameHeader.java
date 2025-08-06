package com.scwang.smartrefresh.header.fungame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huobi.view.roundimg.RoundedDrawable;
import com.scwang.smartrefresh.header.R$styleable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.i;
import ky.j;

public class FunGameHeader extends FunGameBase {

    /* renamed from: m  reason: collision with root package name */
    public float f29664m = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f29665n;

    /* renamed from: o  reason: collision with root package name */
    public RelativeLayout f29666o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f29667p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f29668q;

    /* renamed from: r  reason: collision with root package name */
    public int f29669r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f29670s = false;

    /* renamed from: t  reason: collision with root package name */
    public String f29671t = "下拉即将展开";

    /* renamed from: u  reason: collision with root package name */
    public String f29672u = "拖动控制游戏";

    /* renamed from: v  reason: collision with root package name */
    public int f29673v;

    /* renamed from: w  reason: collision with root package name */
    public int f29674w;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            FunGameHeader.this.f29667p.setVisibility(8);
            FunGameHeader.this.f29668q.setVisibility(8);
            FunGameHeader.this.f29666o.setVisibility(8);
            FunGameHeader.this.l();
        }
    }

    public FunGameHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context, attributeSet);
    }

    public final void h() {
        if (getChildCount() < 2 && !isInEditMode()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f29654c);
            addView(this.f29666o, layoutParams);
            addView(this.f29665n, layoutParams);
            this.f29669r = (int) (((float) this.f29654c) * 0.5f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f29669r);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f29669r);
            layoutParams3.topMargin = this.f29654c - this.f29669r;
            this.f29665n.addView(this.f29667p, layoutParams2);
            this.f29665n.addView(this.f29668q, layoutParams3);
        }
    }

    public final TextView i(Context context, String str, int i11, int i12) {
        TextView textView = new TextView(context);
        textView.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        textView.setBackgroundColor(-1);
        textView.setGravity(i12 | 1);
        textView.setTextSize(0, (float) i11);
        textView.setText(str);
        return textView;
    }

    public final void j(long j11) {
        TextView textView = this.f29667p;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", new float[]{textView.getTranslationY(), (float) (-this.f29669r)});
        TextView textView2 = this.f29668q;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView2, "translationY", new float[]{textView2.getTranslationY(), (float) this.f29669r});
        RelativeLayout relativeLayout = this.f29666o;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(relativeLayout, "alpha", new float[]{relativeLayout.getAlpha(), 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(800);
        animatorSet.setStartDelay(j11);
        animatorSet.start();
        animatorSet.addListener(new a());
    }

    public final void k(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FunGameHeader);
        int i11 = R$styleable.FunGameHeader_fgvMaskTopText;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f29671t = obtainStyledAttributes.getString(i11);
        }
        int i12 = R$styleable.FunGameHeader_fgvMaskBottomText;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.f29672u = obtainStyledAttributes.getString(i12);
        }
        this.f29673v = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        this.f29674w = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int i13 = R$styleable.FunGameHeader_fgvBottomTextSize;
        this.f29673v = obtainStyledAttributes.getDimensionPixelSize(i13, this.f29673v);
        this.f29674w = obtainStyledAttributes.getDimensionPixelSize(i13, this.f29674w);
        obtainStyledAttributes.recycle();
        this.f29665n = new RelativeLayout(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f29666o = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#3A3A3A"));
        this.f29667p = i(context, this.f29671t, this.f29673v, 80);
        this.f29668q = i(context, this.f29672u, this.f29674w, 48);
        this.f29664m = (float) Math.max(1, DensityUtil.b(0.5f));
    }

    public void l() {
    }

    public void m() {
        this.f29670s = false;
        TextView textView = this.f29667p;
        textView.setTranslationY(textView.getTranslationY() + ((float) this.f29669r));
        TextView textView2 = this.f29668q;
        textView2.setTranslationY(textView2.getTranslationY() - ((float) this.f29669r));
        this.f29666o.setAlpha(1.0f);
        this.f29667p.setVisibility(0);
        this.f29668q.setVisibility(0);
        this.f29666o.setVisibility(0);
    }

    public void n() {
        if (!this.f29670s) {
            j(200);
            this.f29670s = true;
        }
    }

    public int onFinish(j jVar, boolean z11) {
        if (!this.f29659h) {
            m();
        }
        return super.onFinish(jVar, z11);
    }

    public void onInitialized(i iVar, int i11, int i12) {
        super.onInitialized(iVar, i11, i12);
        h();
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        super.onStartAnimator(jVar, i11, i12);
        n();
    }

    public void setBottomMaskViewText(String str) {
        this.f29672u = str;
        this.f29668q.setText(str);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.f29667p.setTextColor(iArr[0]);
            this.f29668q.setTextColor(iArr[0]);
            if (iArr.length > 1) {
                this.f29666o.setBackgroundColor(iy.a.d(iArr[1], 200));
                this.f29667p.setBackgroundColor(iy.a.d(iArr[1], 200));
                this.f29668q.setBackgroundColor(iy.a.d(iArr[1], 200));
            }
        }
    }

    public void setTopMaskViewText(String str) {
        this.f29671t = str;
        this.f29667p.setText(str);
    }

    public FunGameHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k(context, attributeSet);
    }
}
