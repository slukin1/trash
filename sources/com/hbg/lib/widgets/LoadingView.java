package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import i6.d;
import java.io.InputStream;

public class LoadingView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f71510b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71511c;

    /* renamed from: d  reason: collision with root package name */
    public int f71512d;

    public LoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(Context context) {
        this.f71510b = new SafeLottieView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f71510b.setLayoutParams(layoutParams);
        addView(this.f71510b);
        setLottieAnimationRes(this.f71512d);
        setLoop(this.f71511c);
    }

    public boolean b() {
        LottieAnimationView lottieAnimationView = this.f71510b;
        if (lottieAnimationView != null) {
            return lottieAnimationView.isAnimating();
        }
        return false;
    }

    public void c() {
        d.b("LoadingView-->start-->");
        LottieAnimationView lottieAnimationView = this.f71510b;
        if (lottieAnimationView != null) {
            lottieAnimationView.playAnimation();
        }
    }

    public void d() {
        d.b("LoadingView-->stop-->");
        LottieAnimationView lottieAnimationView = this.f71510b;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.f71510b.clearAnimation();
        }
    }

    public void setLoop(boolean z11) {
        setRepeatCount(z11 ? -1 : 0);
    }

    public void setLottieAnimationName(String str) {
        LottieAnimationView lottieAnimationView = this.f71510b;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(str);
        }
    }

    public void setLottieAnimationRes(int i11) {
        if (this.f71510b != null && i11 != 0) {
            Resources resources = getResources();
            InputStream openRawResource = resources.openRawResource(i11);
            this.f71510b.setAnimation(openRawResource, "rawRes_" + (resources.getConfiguration().uiMode & 32) + "_" + i11);
        }
    }

    public void setProgress(float f11) {
        LottieAnimationView lottieAnimationView = this.f71510b;
        if (lottieAnimationView != null) {
            lottieAnimationView.setProgress(f11);
        }
    }

    public void setRepeatCount(int i11) {
        LottieAnimationView lottieAnimationView = this.f71510b;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(i11);
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LoadingView, i11, 0);
        this.f71512d = obtainStyledAttributes.getResourceId(R$styleable.LoadingView_loading_view_lottie_rawRes, R$raw.d_middle);
        this.f71511c = obtainStyledAttributes.getBoolean(R$styleable.LoadingView_loading_view_lottie_loop, true);
        obtainStyledAttributes.recycle();
        a(context);
    }
}
