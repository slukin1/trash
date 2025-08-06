package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.view.e0;
import androidx.core.widget.l;
import androidx.core.widget.o;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import t0.g;
import z0.c;

public class AppCompatTextView extends TextView implements e0, o, androidx.core.widget.b {
    private final c mBackgroundTintHelper;
    private g mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<z0.c> mPrecomputedTextFuture;
    private a mSuperCaller;
    private final m mTextClassifierHelper;
    private final n mTextHelper;

    public interface a {
        int a();

        TextClassifier b();

        int c();

        void d(int i11);

        int e();

        void f(int[] iArr, int i11);

        void g(int i11);

        int h();

        int[] i();

        void j(TextClassifier textClassifier);

        void setAutoSizeTextTypeUniformWithConfiguration(int i11, int i12, int i13, int i14);

        void setAutoSizeTextTypeWithDefaults(int i11);
    }

    public class b implements a {
        public b() {
        }

        public int a() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        public TextClassifier b() {
            return AppCompatTextView.super.getTextClassifier();
        }

        public int c() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        public void d(int i11) {
        }

        public int e() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        public void f(int[] iArr, int i11) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
        }

        public void g(int i11) {
        }

        public int h() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        public int[] i() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        public void j(TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }

        public void setAutoSizeTextTypeUniformWithConfiguration(int i11, int i12, int i13, int i14) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }

        public void setAutoSizeTextTypeWithDefaults(int i11) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i11);
        }
    }

    public class c extends b {
        public c() {
            super();
        }

        public void d(int i11) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i11);
        }

        public void g(int i11) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i11);
        }
    }

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<z0.c> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                l.r(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    private g getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new g(this);
        }
        return this.mEmojiTextViewHelper;
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
            return getSuperCaller().c();
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            return nVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (o0.f4669b) {
            return getSuperCaller().a();
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            return nVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (o0.f4669b) {
            return getSuperCaller().e();
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            return nVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (o0.f4669b) {
            return getSuperCaller().i();
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
        } else if (getSuperCaller().h() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return l.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return l.c(this);
    }

    public a getSuperCaller() {
        if (this.mSuperCaller == null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                this.mSuperCaller = new c();
            } else if (i11 >= 26) {
                this.mSuperCaller = new b();
            }
        }
        return this.mSuperCaller;
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

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        m mVar;
        if (Build.VERSION.SDK_INT >= 28 || (mVar = this.mTextClassifierHelper) == null) {
            return getSuperCaller().b();
        }
        return mVar.a();
    }

    public c.a getTextMetricsParamsCompat() {
        return l.g(this);
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.r(this, onCreateInputConnection, editorInfo);
        return h.a(onCreateInputConnection, editorInfo, this);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.o(z11, i11, i12, i13, i14);
        }
    }

    public void onMeasure(int i11, int i12) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i11, i12);
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
            getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
            return;
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.t(i11, i12, i13, i14);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i11) throws IllegalArgumentException {
        if (o0.f4669b) {
            getSuperCaller().f(iArr, i11);
            return;
        }
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.u(iArr, i11);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i11) {
        if (o0.f4669b) {
            getSuperCaller().setAutoSizeTextTypeWithDefaults(i11);
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

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        n nVar = this.mTextHelper;
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

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().d(i11);
        } else {
            l.o(this, i11);
        }
    }

    public void setLastBaselineToBottomHeight(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().g(i11);
        } else {
            l.p(this, i11);
        }
    }

    public void setLineHeight(int i11) {
        l.q(this, i11);
    }

    public void setPrecomputedText(z0.c cVar) {
        l.r(this, cVar);
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
            getSuperCaller().j(textClassifier);
        } else {
            mVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<z0.c> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        l.t(this, aVar);
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

    public void setTypeface(Typeface typeface, int i11) {
        if (!this.mIsSetTypefaceProcessing) {
            Typeface typeface2 = null;
            if (typeface != null && i11 > 0) {
                typeface2 = g.a(getContext(), typeface, i11);
            }
            this.mIsSetTypefaceProcessing = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i11);
            } finally {
                this.mIsSetTypefaceProcessing = false;
            }
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i11) {
        super(b0.b(context), attributeSet, i11);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        z.a(this, getContext());
        c cVar = new c(this);
        this.mBackgroundTintHelper = cVar;
        cVar.e(attributeSet, i11);
        n nVar = new n(this);
        this.mTextHelper = nVar;
        nVar.m(attributeSet, i11);
        nVar.b();
        this.mTextClassifierHelper = new m(this);
        getEmojiTextViewHelper().c(attributeSet, i11);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b11 = i11 != 0 ? c.a.b(context, i11) : null;
        Drawable b12 = i12 != 0 ? c.a.b(context, i12) : null;
        Drawable b13 = i13 != 0 ? c.a.b(context, i13) : null;
        if (i14 != 0) {
            drawable = c.a.b(context, i14);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b11, b12, b13, drawable);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b11 = i11 != 0 ? c.a.b(context, i11) : null;
        Drawable b12 = i12 != 0 ? c.a.b(context, i12) : null;
        Drawable b13 = i13 != 0 ? c.a.b(context, i13) : null;
        if (i14 != 0) {
            drawable = c.a.b(context, i14);
        }
        setCompoundDrawablesWithIntrinsicBounds(b11, b12, b13, drawable);
        n nVar = this.mTextHelper;
        if (nVar != null) {
            nVar.p();
        }
    }
}
