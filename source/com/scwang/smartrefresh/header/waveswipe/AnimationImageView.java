package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.view.animation.Animation;
import android.widget.ImageView;

public class AnimationImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public Animation.AnimationListener f29697b;

    public AnimationImageView(Context context) {
        super(context);
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f29697b;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f29697b;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f29697b = animationListener;
    }
}
