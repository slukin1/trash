package com.huochat.community.widget.expandable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.huobi.utils.ImageUtils;
import com.huochat.community.util.DisplayTool;
import i6.d;
import java.lang.ref.SoftReference;

class ExpandableLabelSpan extends ReplacementSpan {
    private int mBgColor;
    public SoftReference<Context> mContextSoftReference;
    private int mDrawPadding = DisplayTool.dp2px(5.0f);
    private int mIconHeight;
    private int mIconResId;
    private int mIconWidth;
    private int mPaddingHorizontal = DisplayTool.dp2px(8.0f);
    private int mPaddingVertical = DisplayTool.dp2px(4.0f);
    private int mRadius;
    private int mSpanWidth;
    private int mTextColor;

    public ExpandableLabelSpan(Context context, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.mContextSoftReference = new SoftReference<>(context);
        this.mIconResId = i11;
        this.mIconWidth = i12;
        this.mIconHeight = i13;
        this.mTextColor = i14;
        this.mBgColor = i15;
        this.mRadius = i16;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        Canvas canvas2 = canvas;
        float f12 = f11;
        Paint paint2 = paint;
        float f13 = (float) i14;
        float descent = (float) (((double) (((paint.descent() - paint.ascent()) + f13) - paint.descent())) * 0.5d);
        d.b("#@### ExpandableSpan asccent: " + paint.ascent() + ", descent: " + paint.descent());
        int i16 = this.mBgColor;
        if (i16 != 0) {
            paint2.setColor(i16);
            paint2.setAntiAlias(true);
            RectF rectF = new RectF(f12, 1.0f, ((float) this.mSpanWidth) + f12, f13 + paint.descent());
            int i17 = this.mRadius;
            canvas.drawRoundRect(rectF, (float) i17, (float) i17, paint2);
        }
        Context context = this.mContextSoftReference.get();
        if (context != null) {
            Bitmap l11 = ImageUtils.l(BitmapFactory.decodeResource(context.getResources(), this.mIconResId), this.mIconWidth, this.mIconHeight);
            canvas.drawBitmap(l11, ((float) this.mPaddingHorizontal) + f12, (float) (this.mPaddingVertical + 1), (Paint) null);
            if (!l11.isRecycled()) {
                l11.recycle();
            }
        }
        paint2.setColor(this.mTextColor);
        canvas.drawText(charSequence, i11, i12, f12 + ((float) this.mPaddingHorizontal) + ((float) this.mDrawPadding) + ((float) this.mIconWidth), descent, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) (paint.measureText(charSequence, i11, i12) + ((float) (this.mPaddingHorizontal * 2)) + ((float) this.mDrawPadding) + ((float) this.mIconWidth));
        this.mSpanWidth = measureText;
        return measureText;
    }
}
