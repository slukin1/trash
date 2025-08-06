package cz;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.yanzhenjie.loading.Utils;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f52798a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f52799b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public Drawable.Callback f52800c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f52801d;

    /* renamed from: e  reason: collision with root package name */
    public long f52802e;

    /* renamed from: f  reason: collision with root package name */
    public float f52803f;

    /* renamed from: g  reason: collision with root package name */
    public float f52804g;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
            c.this.e();
        }
    }

    public c(Context context) {
        float a11 = Utils.a(context, 56.0f);
        this.f52804g = a11;
        this.f52803f = a11;
        this.f52802e = 1333;
        l();
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f52801d.addListener(animatorListener);
    }

    public abstract void c(float f11);

    public abstract void d(Canvas canvas);

    public final void e() {
        this.f52800c.invalidateDrawable((Drawable) null);
    }

    public boolean f() {
        return this.f52801d.isRunning();
    }

    public abstract void g();

    public abstract void h(int i11);

    public void i(Rect rect) {
        this.f52799b.set(rect);
    }

    public void j(Drawable.Callback callback) {
        this.f52800c = callback;
    }

    public abstract void k(ColorFilter colorFilter);

    public final void l() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f52801d = ofFloat;
        ofFloat.setRepeatCount(-1);
        this.f52801d.setRepeatMode(1);
        this.f52801d.setDuration(this.f52802e);
        this.f52801d.setInterpolator(new LinearInterpolator());
        this.f52801d.addUpdateListener(this.f52798a);
    }

    public void m() {
        g();
        this.f52801d.addUpdateListener(this.f52798a);
        this.f52801d.setRepeatCount(-1);
        this.f52801d.setDuration(this.f52802e);
        this.f52801d.start();
    }

    public void n() {
        this.f52801d.removeUpdateListener(this.f52798a);
        this.f52801d.setRepeatCount(0);
        this.f52801d.setDuration(0);
        this.f52801d.end();
    }
}
