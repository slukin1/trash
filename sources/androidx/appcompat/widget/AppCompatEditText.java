package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R$attr;
import androidx.core.view.b;
import androidx.core.view.e0;
import androidx.core.view.h0;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.x;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.l;
import androidx.core.widget.o;

public class AppCompatEditText extends EditText implements e0, x, o {
    private final f mAppCompatEmojiEditTextHelper;
    private final c mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    private a mSuperCaller;
    private final m mTextClassifierHelper;
    private final n mTextHelper;

    public class a {
        public a() {
        }

        public TextClassifier a() {
            return AppCompatEditText.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            AppCompatEditText.super.setTextClassifier(textClassifier);
        }
    }

    public AppCompatEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    private a getSuperCaller() {
        if (this.mSuperCaller == null) {
            this.mSuperCaller = new a();
        }
        return this.mSuperCaller;
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

    public TextClassifier getTextClassifier() {
        m mVar;
        if (Build.VERSION.SDK_INT >= 28 || (mVar = this.mTextClassifierHelper) == null) {
            return getSuperCaller().a();
        }
        return mVar.a();
    }

    public void initEmojiKeyListener(f fVar) {
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

    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.c();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] I;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.r(this, onCreateInputConnection, editorInfo);
        InputConnection a11 = h.a(onCreateInputConnection, editorInfo, this);
        if (!(a11 == null || Build.VERSION.SDK_INT > 30 || (I = h0.I(this)) == null)) {
            EditorInfoCompat.d(editorInfo, I);
            a11 = InputConnectionCompat.c(this, a11, editorInfo);
        }
        return this.mAppCompatEmojiEditTextHelper.e(a11, editorInfo);
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (k.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public b onReceiveContent(b bVar) {
        return this.mDefaultOnReceiveContentListener.a(this, bVar);
    }

    public boolean onTextContextMenuItem(int i11) {
        if (k.b(this, i11)) {
            return true;
        }
        return super.onTextContextMenuItem(i11);
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

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.v(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z11) {
        this.mAppCompatEmojiEditTextHelper.f(z11);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(keyListener));
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

    public void setTextClassifier(TextClassifier textClassifier) {
        m mVar;
        if (Build.VERSION.SDK_INT >= 28 || (mVar = this.mTextClassifierHelper) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            mVar.b(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i11) {
        super(b0.b(context), attributeSet, i11);
        z.a(this, getContext());
        c cVar = new c(this);
        this.mBackgroundTintHelper = cVar;
        cVar.e(attributeSet, i11);
        n nVar = new n(this);
        this.mTextHelper = nVar;
        nVar.m(attributeSet, i11);
        nVar.b();
        this.mTextClassifierHelper = new m(this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        f fVar = new f(this);
        this.mAppCompatEmojiEditTextHelper = fVar;
        fVar.d(attributeSet, i11);
        initEmojiKeyListener(fVar);
    }
}
