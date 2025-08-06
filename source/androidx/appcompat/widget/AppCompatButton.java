package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;
import androidx.core.view.e0;
import androidx.core.widget.b;
import androidx.core.widget.l;
import androidx.core.widget.o;

public class AppCompatButton extends Button implements e0, b, o {
    private g mAppCompatEmojiTextHelper;
    private final c mBackgroundTintHelper;
    private final n mTextHelper;

    public AppCompatButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private g getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.b();
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (o0.f4669b) {
            return super.getAutoSizeMaxTextSize();
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            return nVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (o0.f4669b) {
            return super.getAutoSizeMinTextSize();
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            return nVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (o0.f4669b) {
            return super.getAutoSizeStepGranularity();
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            return nVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (o0.f4669b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        n nVar = this.mTextHelper;
        return nVar != null ? nVar.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!o0.f4669b) {
            n nVar = this.mTextHelper;
            if (nVar != null) {
                return nVar.i();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.o(z11, i11, i12, i13, i14);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        super.onTextChanged(charSequence, i11, i12, i13);
        n nVar = this.mTextHelper;
        if (nVar != null && !o0.f4669b && nVar.l()) {
            this.mTextHelper.c();
        }
    }

    public void setAllCaps(boolean z11) {
        super.setAllCaps(z11);
        getEmojiTextViewHelper().d(z11);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        if (o0.f4669b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
            return;
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.t(i11, i12, i13, i14);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i11) throws IllegalArgumentException {
        if (o0.f4669b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
            return;
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.u(iArr, i11);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i11) {
        if (o0.f4669b) {
            super.setAutoSizeTextTypeWithDefaults(i11);
            return;
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.v(i11);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.g(i11);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.v(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        getEmojiTextViewHelper().e(z11);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z11) {
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.s(z11);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        c cVar = this.mBackgroundTintHelper;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.w(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.x(mode);
        this.mTextHelper.b();
    }

    public void setTextAppearance(Context context, int i11) {
        super.setTextAppearance(context, i11);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.q(context, i11);
        }
    }

    public void setTextSize(int i11, float f11) {
        if (o0.f4669b) {
            super.setTextSize(i11, f11);
            return;
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.A(i11, f11);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i11) {
        super(b0.b(context), attributeSet, i11);
        z.a(this, getContext());
        c cVar = new c(this);
        this.mBackgroundTintHelper = cVar;
        cVar.e(attributeSet, i11);
        n nVar = new n(this);
        this.mTextHelper = nVar;
        nVar.m(attributeSet, i11);
        nVar.b();
        getEmojiTextViewHelper().c(attributeSet, i11);
    }
}
