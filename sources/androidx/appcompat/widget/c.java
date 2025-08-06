package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final View f4542a;

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatDrawableManager f4543b;

    /* renamed from: c  reason: collision with root package name */
    public int f4544c = -1;

    /* renamed from: d  reason: collision with root package name */
    public TintInfo f4545d;

    /* renamed from: e  reason: collision with root package name */
    public TintInfo f4546e;

    /* renamed from: f  reason: collision with root package name */
    public TintInfo f4547f;

    public c(View view) {
        this.f4542a = view;
        this.f4543b = AppCompatDrawableManager.b();
    }

    public final boolean a(Drawable drawable) {
        if (this.f4547f == null) {
            this.f4547f = new TintInfo();
        }
        TintInfo tintInfo = this.f4547f;
        tintInfo.a();
        ColorStateList v11 = h0.v(this.f4542a);
        if (v11 != null) {
            tintInfo.f4523d = true;
            tintInfo.f4520a = v11;
        }
        PorterDuff.Mode w11 = h0.w(this.f4542a);
        if (w11 != null) {
            tintInfo.f4522c = true;
            tintInfo.f4521b = w11;
        }
        if (!tintInfo.f4523d && !tintInfo.f4522c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f4542a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f4542a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            TintInfo tintInfo = this.f4546e;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(background, tintInfo, this.f4542a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f4545d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(background, tintInfo2, this.f4542a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        TintInfo tintInfo = this.f4546e;
        if (tintInfo != null) {
            return tintInfo.f4520a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        TintInfo tintInfo = this.f4546e;
        if (tintInfo != null) {
            return tintInfo.f4521b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i11) {
        Context context = this.f4542a.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        d0 v11 = d0.v(context, attributeSet, iArr, i11, 0);
        View view = this.f4542a;
        h0.v0(view, view.getContext(), iArr, attributeSet, v11.r(), i11, 0);
        try {
            int i12 = R$styleable.ViewBackgroundHelper_android_background;
            if (v11.s(i12)) {
                this.f4544c = v11.n(i12, -1);
                ColorStateList f11 = this.f4543b.f(this.f4542a.getContext(), this.f4544c);
                if (f11 != null) {
                    h(f11);
                }
            }
            int i13 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (v11.s(i13)) {
                h0.C0(this.f4542a, v11.c(i13));
            }
            int i14 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (v11.s(i14)) {
                h0.D0(this.f4542a, r.e(v11.k(i14, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v11.w();
        }
    }

    public void f(Drawable drawable) {
        this.f4544c = -1;
        h((ColorStateList) null);
        b();
    }

    public void g(int i11) {
        this.f4544c = i11;
        AppCompatDrawableManager appCompatDrawableManager = this.f4543b;
        h(appCompatDrawableManager != null ? appCompatDrawableManager.f(this.f4542a.getContext(), i11) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f4545d == null) {
                this.f4545d = new TintInfo();
            }
            TintInfo tintInfo = this.f4545d;
            tintInfo.f4520a = colorStateList;
            tintInfo.f4523d = true;
        } else {
            this.f4545d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f4546e == null) {
            this.f4546e = new TintInfo();
        }
        TintInfo tintInfo = this.f4546e;
        tintInfo.f4520a = colorStateList;
        tintInfo.f4523d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f4546e == null) {
            this.f4546e = new TintInfo();
        }
        TintInfo tintInfo = this.f4546e;
        tintInfo.f4521b = mode;
        tintInfo.f4522c = true;
        b();
    }

    public final boolean k() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 21) {
            return i11 == 21;
        }
        if (this.f4545d != null) {
            return true;
        }
        return false;
    }
}
