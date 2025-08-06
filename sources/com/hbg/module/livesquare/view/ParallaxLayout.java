package com.hbg.module.livesquare.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.h0;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.a0;
import androidx.lifecycle.u;
import com.bumptech.glide.d;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$styleable;
import com.huobi.view.roundimg.RoundedImageView;
import df.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class ParallaxLayout extends LinearLayout implements Handler.Callback, c {

    /* renamed from: b  reason: collision with root package name */
    public int f26665b;

    /* renamed from: c  reason: collision with root package name */
    public int f26666c;

    /* renamed from: d  reason: collision with root package name */
    public int f26667d;

    /* renamed from: e  reason: collision with root package name */
    public float f26668e;

    /* renamed from: f  reason: collision with root package name */
    public float f26669f;

    /* renamed from: g  reason: collision with root package name */
    public int f26670g;

    /* renamed from: h  reason: collision with root package name */
    public float f26671h;

    /* renamed from: i  reason: collision with root package name */
    public List<View> f26672i;

    /* renamed from: j  reason: collision with root package name */
    public AnimatorSet f26673j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f26674k;

    /* renamed from: l  reason: collision with root package name */
    public long f26675l;

    /* renamed from: m  reason: collision with root package name */
    public long f26676m;

    /* renamed from: n  reason: collision with root package name */
    public int f26677n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f26678o;

    /* renamed from: p  reason: collision with root package name */
    public final Handler f26679p;

    public static final class a implements u {

        /* renamed from: b  reason: collision with root package name */
        public final LifecycleOwner f26680b;

        /* renamed from: c  reason: collision with root package name */
        public final c f26681c;

        public a(LifecycleOwner lifecycleOwner, c cVar) {
            this.f26680b = lifecycleOwner;
            this.f26681c = cVar;
        }

        @a0(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            c cVar;
            Log.e("ParallaxLayout", "onDestroy");
            LifecycleOwner lifecycleOwner = this.f26680b;
            if (lifecycleOwner != null && (cVar = this.f26681c) != null) {
                cVar.onDestroy(lifecycleOwner);
            }
        }

        @a0(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            c cVar;
            Log.e("ParallaxLayout", "onPause");
            LifecycleOwner lifecycleOwner = this.f26680b;
            if (lifecycleOwner != null && (cVar = this.f26681c) != null) {
                cVar.onPause(lifecycleOwner);
            }
        }

        @a0(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            c cVar;
            Log.e("ParallaxLayout", "onResume");
            LifecycleOwner lifecycleOwner = this.f26680b;
            if (lifecycleOwner != null && (cVar = this.f26681c) != null) {
                cVar.onResume(lifecycleOwner);
            }
        }

        @a0(Lifecycle.Event.ON_START)
        public final void onStart() {
            c cVar;
            Log.e("ParallaxLayout", "onStart");
            LifecycleOwner lifecycleOwner = this.f26680b;
            if (lifecycleOwner != null && (cVar = this.f26681c) != null) {
                cVar.onStart(lifecycleOwner);
            }
        }

        @a0(Lifecycle.Event.ON_STOP)
        public final void onStop() {
            c cVar;
            Log.e("ParallaxLayout", "onStop");
            LifecycleOwner lifecycleOwner = this.f26680b;
            if (lifecycleOwner != null && (cVar = this.f26681c) != null) {
                cVar.onStop(lifecycleOwner);
            }
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ParallaxLayout f26682b;

        public b(ParallaxLayout parallaxLayout) {
            this.f26682b = parallaxLayout;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f26682b.getCacheItems().size() != 0 && this.f26682b.getChildCount() != 0) {
                this.f26682b.l();
                ParallaxLayout parallaxLayout = this.f26682b;
                parallaxLayout.f26677n = parallaxLayout.f26677n + 1;
                ParallaxLayout parallaxLayout2 = this.f26682b;
                parallaxLayout2.g(parallaxLayout2.f26677n + this.f26682b.getMaxVisibleItems());
                this.f26682b.getCacheItems().get(this.f26682b.getCacheItems().size() - 1).setAlpha(0.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (this.f26682b.getCacheItems().size() != 0) {
                this.f26682b.getCacheItems().get(this.f26682b.getCacheItems().size() - 1).setScaleX(0.0f);
                this.f26682b.getCacheItems().get(this.f26682b.getCacheItems().size() - 1).setScaleY(0.0f);
                this.f26682b.getCacheItems().get(this.f26682b.getCacheItems().size() - 1).setAlpha(1.0f);
            }
        }
    }

    public ParallaxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParallaxLayout(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void o(ParallaxLayout parallaxLayout, ValueAnimator valueAnimator) {
        if (parallaxLayout.f26672i.size() != 0) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int size = parallaxLayout.f26672i.size();
            for (int i11 = 1; i11 < size; i11++) {
                parallaxLayout.f26672i.get(i11).setTranslationX((-floatValue) - (parallaxLayout.f26671h * ((float) i11)));
            }
        }
    }

    public static final void p(ParallaxLayout parallaxLayout, ValueAnimator valueAnimator) {
        if (parallaxLayout.f26672i.size() != 0) {
            parallaxLayout.f26672i.get(0).setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            parallaxLayout.f26672i.get(0).setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            List<View> list = parallaxLayout.f26672i;
            list.get(list.size() - 1).setScaleX(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
            List<View> list2 = parallaxLayout.f26672i;
            list2.get(list2.size() - 1).setScaleY(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public final void g(int i11) {
        RoundedImageView roundedImageView = new RoundedImageView(getContext());
        roundedImageView.setBorderColor(this.f26670g);
        roundedImageView.setBorderWidth(this.f26668e);
        roundedImageView.setCornerRadius(this.f26669f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f26666c, this.f26667d);
        d v11 = com.bumptech.glide.a.v(getContext());
        List<String> list = this.f26674k;
        v11.q(list.get(i11 % list.size())).D0(roundedImageView);
        addView(roundedImageView, layoutParams);
        if (this.f26672i.size() == 0) {
            h0.F0(roundedImageView, 0.0f);
            roundedImageView.setTranslationX(0.0f);
        } else {
            List<View> list2 = this.f26672i;
            h0.F0(roundedImageView, list2.get(list2.size() - 1).getElevation() + ((float) 1));
            List<View> list3 = this.f26672i;
            roundedImageView.setTranslationX((-this.f26671h) + list3.get(list3.size() - 1).getTranslationX());
        }
        this.f26672i.add(roundedImageView);
    }

    public final List<View> getCacheItems() {
        return this.f26672i;
    }

    public final long getDuration() {
        return this.f26676m;
    }

    public final float getImageBorder() {
        return this.f26668e;
    }

    public final int getImageBorderColor() {
        return this.f26670g;
    }

    public final float getImageBorderRadius() {
        return this.f26669f;
    }

    public final int getImageHeight() {
        return this.f26667d;
    }

    public final int getImageWidth() {
        return this.f26666c;
    }

    public final long getIntervals() {
        return this.f26675l;
    }

    public final List<String> getItemsList() {
        return this.f26674k;
    }

    public final int getMaxVisibleItems() {
        return this.f26665b;
    }

    public final float getOffset() {
        return this.f26671h;
    }

    public final void h(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.a(new a(lifecycleOwner, this));
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            i();
            this.f26679p.sendEmptyMessageDelayed(1, this.f26675l);
        }
        return true;
    }

    public final void i() {
        if (this.f26674k.size() > this.f26665b && this.f26672i.size() > this.f26665b) {
            n();
        }
    }

    public final void j() {
        k();
        if (this.f26674k.size() != 0) {
            int i11 = this.f26665b;
            if (this.f26674k.size() <= i11) {
                i11 = this.f26674k.size() - 1;
            }
            int i12 = 0;
            if (i11 >= 0) {
                while (true) {
                    g(i12);
                    if (i12 == i11) {
                        break;
                    }
                    i12++;
                }
            }
            if (this.f26674k.size() > this.f26665b) {
                List<View> list = this.f26672i;
                list.get(list.size() - 1).setAlpha(0.0f);
                this.f26679p.sendEmptyMessageDelayed(1, 4000);
            }
            this.f26678o = true;
        }
    }

    public final void k() {
        m();
        removeAllViews();
        this.f26672i.clear();
    }

    public final void l() {
        if (this.f26672i.size() != 0 && getChildCount() != 0) {
            int i11 = 0;
            this.f26672i.remove(0);
            removeViewAt(0);
            for (T next : this.f26672i) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                View view = (View) next;
                view.setTranslationX(view.getTranslationX() + ((float) this.f26666c));
                h0.F0(view, (float) i11);
                i11 = i12;
            }
        }
    }

    public final void m() {
        this.f26679p.removeCallbacksAndMessages((Object) null);
        AnimatorSet animatorSet = this.f26673j;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f26673j;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
    }

    public final void n() {
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{0.0f, ((float) this.f26666c) - this.f26671h});
        ofFloat.setDuration(this.f26676m);
        ofFloat.setInterpolator(new LinearOutSlowInInterpolator());
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.setDuration(this.f26676m);
        ofFloat2.setInterpolator(new LinearOutSlowInInterpolator());
        ofFloat.addUpdateListener(new df.a(this));
        ofFloat2.addUpdateListener(new df.b(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f26673j = animatorSet;
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        AnimatorSet animatorSet2 = this.f26673j;
        if (animatorSet2 != null) {
            animatorSet2.addListener(new b(this));
        }
        AnimatorSet animatorSet3 = this.f26673j;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f26674k.size() > 0) {
            j();
        }
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        k();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    public void onMeasure(int i11, int i12) {
        int i13 = this.f26665b;
        if (this.f26674k.size() < this.f26665b) {
            i13 = this.f26674k.size();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (((float) (this.f26666c * i13)) - (this.f26671h * ((float) (i13 - 1)))), 1073741824), i12);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        if (this.f26678o) {
            this.f26678o = false;
            m();
        }
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        if (!this.f26678o) {
            this.f26678o = true;
            this.f26679p.removeCallbacksAndMessages((Object) null);
            this.f26679p.sendEmptyMessageDelayed(1, this.f26675l);
        }
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        j();
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        k();
    }

    public final void setCacheItems(List<View> list) {
        this.f26672i = list;
    }

    public final void setDuration(long j11) {
        this.f26676m = j11;
    }

    public final void setImageBorder(float f11) {
        this.f26668e = f11;
    }

    public final void setImageBorderColor(int i11) {
        this.f26670g = i11;
    }

    public final void setImageBorderRadius(float f11) {
        this.f26669f = f11;
    }

    public final void setImageHeight(int i11) {
        this.f26667d = i11;
    }

    public final void setImageWidth(int i11) {
        this.f26666c = i11;
    }

    public final void setIntervals(long j11) {
        this.f26675l = j11;
    }

    public final void setItemsList(List<String> list) {
        this.f26674k.clear();
        k();
        this.f26674k.addAll(list);
        requestLayout();
        j();
    }

    public final void setMaxVisibleItems(int i11) {
        this.f26665b = i11;
    }

    public final void setOffset(float f11) {
        this.f26671h = f11;
    }

    public ParallaxLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f26665b = 3;
        this.f26666c = PixelUtils.a(16.0f);
        this.f26667d = PixelUtils.a(16.0f);
        this.f26668e = PixelUtils.b(0.5f);
        this.f26669f = PixelUtils.b(8.0f);
        this.f26670g = context.getResources().getColor(R$color.image_heard_border);
        this.f26671h = PixelUtils.b(3.0f);
        this.f26672i = new ArrayList();
        this.f26674k = new ArrayList();
        this.f26675l = 2000;
        this.f26676m = 400;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ParallaxLayout);
            this.f26665b = obtainStyledAttributes.getInteger(R$styleable.ParallaxLayout_maxVisibleItems, this.f26665b);
            this.f26666c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ParallaxLayout_imageWidth, this.f26666c);
            this.f26667d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ParallaxLayout_imageHeight, this.f26667d);
            this.f26668e = obtainStyledAttributes.getDimension(R$styleable.ParallaxLayout_imageBorderWidth, this.f26668e);
            this.f26669f = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.ParallaxLayout_imageRadius, (int) this.f26669f);
            this.f26671h = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.ParallaxLayout_offset, (int) this.f26671h);
            this.f26675l = (long) obtainStyledAttributes.getInteger(R$styleable.ParallaxLayout_intervals, (int) this.f26675l);
            this.f26676m = (long) obtainStyledAttributes.getInteger(R$styleable.ParallaxLayout_animateDuration, (int) this.f26676m);
            this.f26670g = obtainStyledAttributes.getColor(R$styleable.ParallaxLayout_imageBorderColor, this.f26670g);
            obtainStyledAttributes.recycle();
        }
        this.f26679p = new Handler(Looper.getMainLooper(), this);
    }
}
