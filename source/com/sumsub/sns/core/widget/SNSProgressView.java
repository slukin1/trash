package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "value", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "setProgressBackgroundColor", "", "color", "setProgressBarColor", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSProgressView extends ConstraintLayout {
    public SNSProgressView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final ProgressBar getProgressBar() {
        return (ProgressBar) findViewById(R.id.sns_progress_bar);
    }

    public final CharSequence getText() {
        TextView textView = (TextView) findViewById(R.id.sns_progress_text);
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    public final void setProgressBackgroundColor(int i11) {
        View findViewById = findViewById(R.id.sns_progress_bg);
        MaterialShapeDrawable materialShapeDrawable = null;
        Object background = findViewById != null ? findViewById.getBackground() : null;
        if (background instanceof MaterialShapeDrawable) {
            materialShapeDrawable = (MaterialShapeDrawable) background;
        }
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTint(i11);
        }
    }

    public final void setProgressBarColor(int i11) {
        ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(i11));
        }
    }

    public final void setText(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.sns_progress_text);
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public SNSProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSProgressView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSProgressView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_ProgressViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSProgressView : i12);
    }

    public SNSProgressView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        Integer a11;
        Integer a12;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSProgressView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSProgressView_sns_progressViewLayout, 0), this, true);
        int i13 = R.styleable.SNSProgressView_sns_dimColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            setBackgroundColor(i.a(obtainStyledAttributes, context, i13).getDefaultColor());
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, attributeSet, i11, i12);
        int i14 = R.styleable.SNSProgressView_sns_progressBackgroundColor;
        if (obtainStyledAttributes.hasValue(i14)) {
            materialShapeDrawable.setTint(i.a(obtainStyledAttributes, context, i14).getDefaultColor());
        }
        View findViewById = findViewById(R.id.sns_progress_bg);
        if (findViewById != null) {
            findViewById.setBackground(materialShapeDrawable);
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        a aVar = a.f31095a;
        SNSColorElement sNSColorElement = SNSColorElement.BACKGROUND_COMMON;
        d a13 = aVar.a();
        if (!(a13 == null || (a12 = aVar.a(a13, sNSColorElement, aVar.a((View) this))) == null)) {
            int intValue = a12.intValue();
            setBackground(new ColorDrawable(intValue));
            setProgressBackgroundColor(intValue);
        }
        SNSColorElement sNSColorElement2 = SNSColorElement.CONTENT_NEUTRAL;
        d a14 = aVar.a();
        if (a14 != null && (a11 = aVar.a(a14, sNSColorElement2, aVar.a((View) this))) != null) {
            setProgressBarColor(a11.intValue());
        }
    }
}
