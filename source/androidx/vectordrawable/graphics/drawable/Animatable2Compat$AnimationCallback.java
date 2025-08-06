package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public abstract class Animatable2Compat$AnimationCallback {
    public Animatable2.AnimationCallback mPlatformCallback;

    public class a extends Animatable2.AnimationCallback {
        public a() {
        }

        public void onAnimationEnd(Drawable drawable) {
            Animatable2Compat$AnimationCallback.this.onAnimationEnd(drawable);
        }

        public void onAnimationStart(Drawable drawable) {
            Animatable2Compat$AnimationCallback.this.onAnimationStart(drawable);
        }
    }

    public Animatable2.AnimationCallback getPlatformCallback() {
        if (this.mPlatformCallback == null) {
            this.mPlatformCallback = new a();
        }
        return this.mPlatformCallback;
    }

    public void onAnimationEnd(Drawable drawable) {
    }

    public void onAnimationStart(Drawable drawable) {
    }
}
