package c4;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.a;

public abstract class d<Z> extends h<ImageView, Z> implements a.C0707a {

    /* renamed from: i  reason: collision with root package name */
    public Animatable f63154i;

    public d(ImageView imageView) {
        super(imageView);
    }

    public final void f(Z z11) {
        if (z11 instanceof Animatable) {
            Animatable animatable = (Animatable) z11;
            this.f63154i = animatable;
            animatable.start();
            return;
        }
        this.f63154i = null;
    }

    public void g(Drawable drawable) {
        ((ImageView) this.f63159b).setImageDrawable(drawable);
    }

    public abstract void h(Z z11);

    public final void i(Z z11) {
        h(z11);
        f(z11);
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f63154i;
        if (animatable != null) {
            animatable.stop();
        }
        i((Object) null);
        g(drawable);
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        i((Object) null);
        g(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        i((Object) null);
        g(drawable);
    }

    public void onResourceReady(Z z11, a<? super Z> aVar) {
        if (aVar == null || !aVar.a(z11, this)) {
            i(z11);
        } else {
            f(z11);
        }
    }

    public void onStart() {
        Animatable animatable = this.f63154i;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f63154i;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
