package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;
import u0.a;

public class l extends j {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f4604d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f4605e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f4606f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f4607g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4608h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4609i = false;

    public l(SeekBar seekBar) {
        super(seekBar);
        this.f4604d = seekBar;
    }

    public void c(AttributeSet attributeSet, int i11) {
        super.c(attributeSet, i11);
        Context context = this.f4604d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        d0 v11 = d0.v(context, attributeSet, iArr, i11, 0);
        SeekBar seekBar = this.f4604d;
        h0.v0(seekBar, seekBar.getContext(), iArr, attributeSet, v11.r(), i11, 0);
        Drawable h11 = v11.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h11 != null) {
            this.f4604d.setThumb(h11);
        }
        j(v11.g(R$styleable.AppCompatSeekBar_tickMark));
        int i12 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (v11.s(i12)) {
            this.f4607g = r.e(v11.k(i12, -1), this.f4607g);
            this.f4609i = true;
        }
        int i13 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (v11.s(i13)) {
            this.f4606f = v11.c(i13);
            this.f4608h = true;
        }
        v11.w();
        f();
    }

    public final void f() {
        Drawable drawable = this.f4605e;
        if (drawable == null) {
            return;
        }
        if (this.f4608h || this.f4609i) {
            Drawable r11 = a.r(drawable.mutate());
            this.f4605e = r11;
            if (this.f4608h) {
                a.o(r11, this.f4606f);
            }
            if (this.f4609i) {
                a.p(this.f4605e, this.f4607g);
            }
            if (this.f4605e.isStateful()) {
                this.f4605e.setState(this.f4604d.getDrawableState());
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f4605e != null) {
            int max = this.f4604d.getMax();
            int i11 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f4605e.getIntrinsicWidth();
                int intrinsicHeight = this.f4605e.getIntrinsicHeight();
                int i12 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i11 = intrinsicHeight / 2;
                }
                this.f4605e.setBounds(-i12, -i11, i12, i11);
                float width = ((float) ((this.f4604d.getWidth() - this.f4604d.getPaddingLeft()) - this.f4604d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f4604d.getPaddingLeft(), (float) (this.f4604d.getHeight() / 2));
                for (int i13 = 0; i13 <= max; i13++) {
                    this.f4605e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f4605e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f4604d.getDrawableState())) {
            this.f4604d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f4605e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f4605e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f4605e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f4604d);
            a.m(drawable, h0.F(this.f4604d));
            if (drawable.isStateful()) {
                drawable.setState(this.f4604d.getDrawableState());
            }
            f();
        }
        this.f4604d.invalidate();
    }
}
