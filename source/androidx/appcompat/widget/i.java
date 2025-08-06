package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;
import androidx.core.widget.h;
import c.a;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f4594a;

    /* renamed from: b  reason: collision with root package name */
    public TintInfo f4595b;

    /* renamed from: c  reason: collision with root package name */
    public TintInfo f4596c;

    /* renamed from: d  reason: collision with root package name */
    public TintInfo f4597d;

    /* renamed from: e  reason: collision with root package name */
    public int f4598e = 0;

    public i(ImageView imageView) {
        this.f4594a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f4597d == null) {
            this.f4597d = new TintInfo();
        }
        TintInfo tintInfo = this.f4597d;
        tintInfo.a();
        ColorStateList a11 = h.a(this.f4594a);
        if (a11 != null) {
            tintInfo.f4523d = true;
            tintInfo.f4520a = a11;
        }
        PorterDuff.Mode b11 = h.b(this.f4594a);
        if (b11 != null) {
            tintInfo.f4522c = true;
            tintInfo.f4521b = b11;
        }
        if (!tintInfo.f4523d && !tintInfo.f4522c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f4594a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f4594a.getDrawable() != null) {
            this.f4594a.getDrawable().setLevel(this.f4598e);
        }
    }

    public void c() {
        Drawable drawable = this.f4594a.getDrawable();
        if (drawable != null) {
            r.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!l() || !a(drawable)) {
            TintInfo tintInfo = this.f4596c;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(drawable, tintInfo, this.f4594a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f4595b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(drawable, tintInfo2, this.f4594a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        TintInfo tintInfo = this.f4596c;
        if (tintInfo != null) {
            return tintInfo.f4520a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        TintInfo tintInfo = this.f4596c;
        if (tintInfo != null) {
            return tintInfo.f4521b;
        }
        return null;
    }

    public boolean f() {
        return Build.VERSION.SDK_INT < 21 || !(this.f4594a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i11) {
        int n11;
        Context context = this.f4594a.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        d0 v11 = d0.v(context, attributeSet, iArr, i11, 0);
        ImageView imageView = this.f4594a;
        h0.v0(imageView, imageView.getContext(), iArr, attributeSet, v11.r(), i11, 0);
        try {
            Drawable drawable = this.f4594a.getDrawable();
            if (!(drawable != null || (n11 = v11.n(R$styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f4594a.getContext(), n11)) == null)) {
                this.f4594a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                r.b(drawable);
            }
            int i12 = R$styleable.AppCompatImageView_tint;
            if (v11.s(i12)) {
                h.c(this.f4594a, v11.c(i12));
            }
            int i13 = R$styleable.AppCompatImageView_tintMode;
            if (v11.s(i13)) {
                h.d(this.f4594a, r.e(v11.k(i13, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v11.w();
        }
    }

    public void h(Drawable drawable) {
        this.f4598e = drawable.getLevel();
    }

    public void i(int i11) {
        if (i11 != 0) {
            Drawable b11 = a.b(this.f4594a.getContext(), i11);
            if (b11 != null) {
                r.b(b11);
            }
            this.f4594a.setImageDrawable(b11);
        } else {
            this.f4594a.setImageDrawable((Drawable) null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f4596c == null) {
            this.f4596c = new TintInfo();
        }
        TintInfo tintInfo = this.f4596c;
        tintInfo.f4520a = colorStateList;
        tintInfo.f4523d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f4596c == null) {
            this.f4596c = new TintInfo();
        }
        TintInfo tintInfo = this.f4596c;
        tintInfo.f4521b = mode;
        tintInfo.f4522c = true;
        c();
    }

    public final boolean l() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 21) {
            return i11 == 21;
        }
        if (this.f4595b != null) {
            return true;
        }
        return false;
    }
}
