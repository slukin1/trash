package com.jumio.defaultui.view;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.b;
import pw.v;

public final class ScanFragment$animatedDrawableCallback$1 extends Animatable2Compat$AnimationCallback {
    public final /* synthetic */ ScanFragment this$0;

    public ScanFragment$animatedDrawableCallback$1(ScanFragment scanFragment) {
        this.this$0 = scanFragment;
    }

    /* access modifiers changed from: private */
    public static final void onAnimationEnd$lambda$0(ScanFragment scanFragment) {
        b animatedDrawable = scanFragment.getAnimatedDrawable();
        if (animatedDrawable != null) {
            animatedDrawable.start();
        }
    }

    public void onAnimationEnd(Drawable drawable) {
        ImageView animationIcon = this.this$0.getAnimationIcon();
        if (animationIcon != null) {
            animationIcon.post(new v(this.this$0));
        }
    }
}
