package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import androidx.core.view.e0;
import androidx.core.widget.o;
import c.a;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements e0, o {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f4355e = {16843126};

    /* renamed from: b  reason: collision with root package name */
    public final c f4356b;

    /* renamed from: c  reason: collision with root package name */
    public final n f4357c;

    /* renamed from: d  reason: collision with root package name */
    public final f f4358d;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public void a(f fVar) {
        KeyListener keyListener = getKeyListener();
        if (fVar.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a11 = fVar.a(keyListener);
            if (a11 != keyListener) {
                super.setKeyListener(a11);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.f4356b;
        if (cVar != null) {
            cVar.b();
        }
        n nVar = this.f4357c;
        if (nVar != null) {
            nVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        c cVar = this.f4356b;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c cVar = this.f4356b;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f4357c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f4357c.k();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f4358d.e(h.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c cVar = this.f4356b;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        c cVar = this.f4356b;
        if (cVar != null) {
            cVar.g(i11);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f4357c;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f4357c;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setDropDownBackgroundResource(int i11) {
        setDropDownBackgroundDrawable(a.b(getContext(), i11));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        this.f4358d.f(z11);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f4358d.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        c cVar = this.f4356b;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        c cVar = this.f4356b;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f4357c.w(colorStateList);
        this.f4357c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f4357c.x(mode);
        this.f4357c.b();
    }

    public void setTextAppearance(Context context, int i11) {
        super.setTextAppearance(context, i11);
        n nVar = this.f4357c;
        if (nVar != null) {
            nVar.q(context, i11);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i11) {
        super(b0.b(context), attributeSet, i11);
        z.a(this, getContext());
        d0 v11 = d0.v(getContext(), attributeSet, f4355e, i11, 0);
        if (v11.s(0)) {
            setDropDownBackgroundDrawable(v11.g(0));
        }
        v11.w();
        c cVar = new c(this);
        this.f4356b = cVar;
        cVar.e(attributeSet, i11);
        n nVar = new n(this);
        this.f4357c = nVar;
        nVar.m(attributeSet, i11);
        nVar.b();
        f fVar = new f(this);
        this.f4358d = fVar;
        fVar.d(attributeSet, i11);
        a(fVar);
    }
}
