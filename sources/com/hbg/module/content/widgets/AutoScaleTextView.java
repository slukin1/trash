package com.hbg.module.content.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.content.R$styleable;
import kotlin.jvm.internal.r;

public final class AutoScaleTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public int f18953b;

    /* renamed from: c  reason: collision with root package name */
    public int f18954c;

    public AutoScaleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoScaleTextView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final float d(int i11) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) i11);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
    }

    public final float e(int i11, String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) i11);
        return textPaint.measureText(str);
    }

    public final void f(String str, int i11, int i12) {
        if (i11 > 0 && i12 > 0) {
            if (!(str.length() == 0)) {
                int paddingLeft = (i11 - getPaddingLeft()) - getPaddingRight();
                int paddingTop = (i12 - getPaddingTop()) - getPaddingBottom();
                float f11 = (float) paddingLeft;
                if (e(this.f18954c, str) > f11 || d(this.f18954c) > ((float) paddingTop)) {
                    int i13 = this.f18954c;
                    while (i13 - this.f18953b > 1) {
                        i13--;
                        if (e(i13, str) < f11 && d(i13) < ((float) paddingTop)) {
                            break;
                        }
                    }
                    setTextSize(0, (float) i13);
                    return;
                }
                setTextSize(0, (float) this.f18954c);
            }
        }
    }

    public final int getMaxTextSize() {
        return this.f18954c;
    }

    public final int getMinTextSize() {
        return this.f18953b;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        if (i11 != i13) {
            f(getText().toString(), PixelUtils.a((float) i11), PixelUtils.a((float) i12));
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        f(String.valueOf(charSequence), PixelUtils.a((float) getWidth()), PixelUtils.a((float) getHeight()));
    }

    public final void setMaxTextSize(int i11) {
        this.f18954c = i11;
    }

    public final void setMinTextSize(int i11) {
        this.f18953b = i11;
    }

    public AutoScaleTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f18953b = PixelUtils.a(12.0f);
        this.f18954c = PixelUtils.a(16.0f);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoScaleTextView);
            this.f18953b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AutoScaleTextView_autoScaleMinTextSize, this.f18953b);
            obtainStyledAttributes.recycle();
            this.f18954c = (int) getTextSize();
        }
    }
}
