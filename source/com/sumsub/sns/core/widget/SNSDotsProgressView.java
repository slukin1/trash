package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J(\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSDotsProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "completePaint", "Landroid/graphics/Paint;", "dotPaint", "dotRadius", "minGap", "value", "progress", "getProgress", "()I", "setProgress", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSDotsProgressView extends View {
    private final Paint completePaint;
    private final Paint dotPaint;
    private int dotRadius;
    private int minGap;
    private int progress;

    public SNSDotsProgressView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public final int getProgress() {
        return this.progress;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / ((this.dotRadius * 2) + this.minGap);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2);
        int width2 = width > 1 ? (((getWidth() - getPaddingLeft()) - getPaddingRight()) - ((this.dotRadius * width) * 2)) / (width - 1) : 0;
        int paddingLeft = getPaddingLeft() + this.dotRadius;
        for (int i11 = 0; i11 < width; i11++) {
            canvas.drawCircle((float) paddingLeft, (float) paddingTop, (float) this.dotRadius, (i11 * 100) / width >= this.progress ? this.dotPaint : this.completePaint);
            paddingLeft += (this.dotRadius * 2) + width2;
        }
        canvas.restore();
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.dotRadius = RangesKt___RangesKt.d((i12 - getPaddingTop()) - getPaddingBottom(), 0) / 2;
    }

    public final void setProgress(int i11) {
        if (i11 != this.progress) {
            this.progress = i11;
            invalidate();
        }
    }

    public SNSDotsProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSDotsProgressView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSDotsProgressView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_DotsProgressViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSDotsProgressView : i12);
    }

    public SNSDotsProgressView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.completePaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.dotPaint = paint2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSDotsProgressView, i11, i12);
        paint2.setColor(b.a(obtainStyledAttributes, R.styleable.SNSDotsProgressView_sns_dotsProgressDotBackgroundColor, 0));
        paint.setColor(b.a(obtainStyledAttributes, R.styleable.SNSDotsProgressView_sns_dotsProgressDotCompleteColor, 0));
        this.minGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSDotsProgressView_sns_dotsProgressMinGap, 0);
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
    }
}
