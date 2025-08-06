package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import c.a;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.b;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "setFillColor", "", "color", "setStroke", "width", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SNSFrameView extends FrameLayout {
    public SNSFrameView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public final void setFillColor(int i11) {
        Drawable foreground = getForeground();
        SNSFrameDrawable sNSFrameDrawable = foreground instanceof SNSFrameDrawable ? (SNSFrameDrawable) foreground : null;
        if (sNSFrameDrawable != null) {
            sNSFrameDrawable.setFillColor(i11);
        }
    }

    public final void setStroke(int i11, int i12) {
        Drawable foreground = getForeground();
        SNSFrameDrawable sNSFrameDrawable = foreground instanceof SNSFrameDrawable ? (SNSFrameDrawable) foreground : null;
        if (sNSFrameDrawable != null) {
            sNSFrameDrawable.setStroke(i11, i12);
        }
    }

    public SNSFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSFrameView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSFrameView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_FrameViewStyle : i11, (i13 & 8) != 0 ? R.style.SNSFrameViewStyle : i12);
    }

    public SNSFrameView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSFrameView, i11, i12);
        setForeground(new SNSFrameDrawable(a.b(context, obtainStyledAttributes.getResourceId(R.styleable.SNSFrameView_sns_FrameDrawable, -1)), b.a(obtainStyledAttributes, R.styleable.SNSFrameView_sns_FrameFillColor, (int) RoundedDrawable.DEFAULT_BORDER_COLOR), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_sns_FramePaddingLeft, 0.0f), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_sns_FramePaddingTop, 0.0f), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_sns_FramePaddingRight, 0.0f), obtainStyledAttributes.getDimension(R.styleable.SNSFrameView_sns_FramePaddingBottom, 0.0f)));
        obtainStyledAttributes.recycle();
    }
}
