package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.view.i;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "Lcom/sumsub/sns/core/widget/SNSTextInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "flagMarginEnd", "flagMarginStart", "flagTouchInterceptor", "Landroid/widget/FrameLayout;", "getFlagTouchInterceptor", "()Landroid/widget/FrameLayout;", "flagView", "Lcom/sumsub/sns/core/widget/SNSFlagView;", "getFlagView", "()Lcom/sumsub/sns/core/widget/SNSFlagView;", "addView", "", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "updateEditTextPadding", "editText", "Landroid/widget/EditText;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSFlaggedInputLayout extends SNSTextInputLayout {
    private final int flagMarginEnd;
    private final int flagMarginStart;
    private final FrameLayout flagTouchInterceptor;
    private final SNSFlagView flagView;

    public SNSFlaggedInputLayout(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: addView$lambda-2$lambda-1  reason: not valid java name */
    public static final void m29addView$lambda2$lambda1(SNSFlaggedInputLayout sNSFlaggedInputLayout, View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        EditText editText = sNSFlaggedInputLayout.getEditText();
        if (editText != null) {
            sNSFlaggedInputLayout.updateEditTextPadding(editText);
        }
    }

    private final void updateEditTextPadding(EditText editText) {
        int i11;
        ViewGroup.LayoutParams layoutParams = this.flagView.getLayoutParams();
        int i12 = 0;
        int b11 = layoutParams instanceof ViewGroup.MarginLayoutParams ? i.b((ViewGroup.MarginLayoutParams) layoutParams) : 0;
        ViewGroup.LayoutParams layoutParams2 = this.flagView.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            i12 = i.a((ViewGroup.MarginLayoutParams) layoutParams2);
        }
        int abs = Math.abs(this.flagView.getRight() - this.flagView.getLeft());
        if (this.flagView.getDrawable() != null) {
            i11 = b11 + this.flagMarginEnd + abs;
        } else {
            i11 = this.flagMarginStart;
        }
        editText.setPaddingRelative(i11, editText.getPaddingTop(), this.flagView.getDrawable() != null ? i12 + this.flagMarginStart + abs : editText.getPaddingEnd(), editText.getPaddingBottom());
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        if (view instanceof EditText) {
            EditText editText = getEditText();
            FrameLayout frameLayout = null;
            ViewParent parent = editText != null ? editText.getParent() : null;
            if (parent instanceof FrameLayout) {
                frameLayout = (FrameLayout) parent;
            }
            if (frameLayout != null) {
                this.flagTouchInterceptor.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
                frameLayout.addView(this.flagTouchInterceptor);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 8388627;
                this.flagTouchInterceptor.addView(this.flagView, layoutParams2);
                SNSFlagView sNSFlagView = this.flagView;
                sNSFlagView.setPadding(this.flagMarginStart, sNSFlagView.getPaddingTop(), sNSFlagView.getPaddingRight(), sNSFlagView.getPaddingBottom());
                this.flagView.addOnLayoutChangeListener(new o(this));
            }
        }
    }

    public final FrameLayout getFlagTouchInterceptor() {
        return this.flagTouchInterceptor;
    }

    public final SNSFlagView getFlagView() {
        return this.flagView;
    }

    public SNSFlaggedInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSFlaggedInputLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSFlaggedInputLayout(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_FlaggedInputLayoutStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSFlaggedInputLayout : i12);
    }

    public SNSFlaggedInputLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.flagTouchInterceptor = new FrameLayout(context);
        this.flagView = new SNSFlagView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSFlaggedInputLayout, i11, i12);
        this.flagMarginStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSFlaggedInputLayout_sns_flagMarginStart, 0);
        this.flagMarginEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSFlaggedInputLayout_sns_flagMarginEnd, 0);
        obtainStyledAttributes.recycle();
    }
}
