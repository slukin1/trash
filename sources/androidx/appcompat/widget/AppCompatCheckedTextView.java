package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$attr;
import androidx.core.view.e0;
import androidx.core.widget.l;
import androidx.core.widget.m;
import androidx.core.widget.o;
import c.a;

public class AppCompatCheckedTextView extends CheckedTextView implements m, e0, o {

    /* renamed from: b  reason: collision with root package name */
    public final d f4341b;

    /* renamed from: c  reason: collision with root package name */
    public final c f4342c;

    /* renamed from: d  reason: collision with root package name */
    public final n f4343d;

    /* renamed from: e  reason: collision with root package name */
    public g f4344e;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkedTextViewStyle);
    }

    private g getEmojiTextViewHelper() {
        if (this.f4344e == null) {
            this.f4344e = new g(this);
        }
        return this.f4344e;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        n nVar = this.f4343d;
        if (nVar != null) {
            nVar.b();
        }
        c cVar = this.f4342c;
        if (cVar != null) {
            cVar.b();
        }
        d dVar = this.f4341b;
        if (dVar != null) {
            dVar.a();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        c cVar = this.f4342c;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c cVar = this.f4342c;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        d dVar = this.f4341b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        d dVar = this.f4341b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f4343d.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f4343d.k();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return h.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setAllCaps(boolean z11) {
        super.setAllCaps(z11);
        getEmojiTextViewHelper().d(z11);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c cVar = this.f4342c;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        c cVar = this.f4342c;
        if (cVar != null) {
            cVar.g(i11);
        }
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        d dVar = this.f4341b;
        if (dVar != null) {
            dVar.e();
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f4343d;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f4343d;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.v(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        getEmojiTextViewHelper().e(z11);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        c cVar = this.f4342c;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        c cVar = this.f4342c;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        d dVar = this.f4341b;
        if (dVar != null) {
            dVar.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        d dVar = this.f4341b;
        if (dVar != null) {
            dVar.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f4343d.w(colorStateList);
        this.f4343d.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f4343d.x(mode);
        this.f4343d.b();
    }

    public void setTextAppearance(Context context, int i11) {
        super.setTextAppearance(context, i11);
        n nVar = this.f4343d;
        if (nVar != null) {
            nVar.q(context, i11);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i11) {
        super(b0.b(context), attributeSet, i11);
        z.a(this, getContext());
        n nVar = new n(this);
        this.f4343d = nVar;
        nVar.m(attributeSet, i11);
        nVar.b();
        c cVar = new c(this);
        this.f4342c = cVar;
        cVar.e(attributeSet, i11);
        d dVar = new d(this);
        this.f4341b = dVar;
        dVar.d(attributeSet, i11);
        getEmojiTextViewHelper().c(attributeSet, i11);
    }

    public void setCheckMarkDrawable(int i11) {
        setCheckMarkDrawable(a.b(getContext(), i11));
    }
}
