package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u001b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSDocBoundsCheckResultView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "Landroid/graphics/Rect;", "docRect", "getDocRect", "()Landroid/graphics/Rect;", "setDocRect", "(Landroid/graphics/Rect;)V", "Landroid/graphics/RectF;", "docRectF", "getDocRectF", "()Landroid/graphics/RectF;", "setDocRectF", "(Landroid/graphics/RectF;)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "Landroid/graphics/Matrix;", "transformMatrix", "getTransformMatrix", "()Landroid/graphics/Matrix;", "setTransformMatrix", "(Landroid/graphics/Matrix;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class SNSDocBoundsCheckResultView extends View {
    private Rect docRect;
    private RectF docRectF;
    private final Paint paint;
    private Matrix transformMatrix;

    public SNSDocBoundsCheckResultView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public final Rect getDocRect() {
        return this.docRect;
    }

    public final RectF getDocRectF() {
        return this.docRectF;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.docRectF;
        if (rectF != null) {
            canvas.drawRect(rectF, this.paint);
        }
    }

    public final void setDocRect(Rect rect) {
        this.docRect = rect;
        setDocRectF(rect != null ? new RectF(rect) : null);
    }

    public final void setDocRectF(RectF rectF) {
        this.docRectF = rectF;
        invalidate();
    }

    public final void setTransformMatrix(Matrix matrix) {
        this.transformMatrix = matrix;
        invalidate();
    }

    public SNSDocBoundsCheckResultView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSDocBoundsCheckResultView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSDocBoundsCheckResultView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public SNSDocBoundsCheckResultView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(-16711936);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.sns_frame_stroke_width));
    }
}
