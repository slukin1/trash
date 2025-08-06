package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.view.e0;
import androidx.core.widget.o;

public class AppCompatToggleButton extends ToggleButton implements e0, o {

    /* renamed from: b  reason: collision with root package name */
    public final c f4388b;

    /* renamed from: c  reason: collision with root package name */
    public final n f4389c;

    /* renamed from: d  reason: collision with root package name */
    public g f4390d;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    private g getEmojiTextViewHelper() {
        if (this.f4390d == null) {
            this.f4390d = new g(this);
        }
        return this.f4390d;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.f4388b;
        if (cVar != null) {
            cVar.b();
        }
        n nVar = this.f4389c;
        if (nVar != null) {
            nVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        c cVar = this.f4388b;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c cVar = this.f4388b;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f4389c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f4389c.k();
    }

    public void setAllCaps(boolean z11) {
        super.setAllCaps(z11);
        getEmojiTextViewHelper().d(z11);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c cVar = this.f4388b;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        c cVar = this.f4388b;
        if (cVar != null) {
            cVar.g(i11);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f4389c;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f4389c;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z11) {
        getEmojiTextViewHelper().e(z11);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        c cVar = this.f4388b;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        c cVar = this.f4388b;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f4389c.w(colorStateList);
        this.f4389c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f4389c.x(mode);
        this.f4389c.b();
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        z.a(this, getContext());
        c cVar = new c(this);
        this.f4388b = cVar;
        cVar.e(attributeSet, i11);
        n nVar = new n(this);
        this.f4389c = nVar;
        nVar.m(attributeSet, i11);
        getEmojiTextViewHelper().c(attributeSet, i11);
    }
}
