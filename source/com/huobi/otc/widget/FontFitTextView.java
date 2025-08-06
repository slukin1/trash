package com.huobi.otc.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.common.utils.PixelUtils;

public class FontFitTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public Paint f79816b;

    /* renamed from: c  reason: collision with root package name */
    public float f79817c = ((float) PixelUtils.a(8.0f));

    /* renamed from: d  reason: collision with root package name */
    public float f79818d = ((float) PixelUtils.a(28.0f));

    public FontFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f79816b = paint;
        paint.set(getPaint());
    }

    public final void d(String str, int i11) {
        if (i11 > 0) {
            int paddingLeft = (i11 - getPaddingLeft()) - getPaddingRight();
            float f11 = this.f79818d;
            float f12 = this.f79817c;
            this.f79816b.set(getPaint());
            this.f79816b.setTextSize(this.f79818d);
            float f13 = (float) paddingLeft;
            if (this.f79816b.measureText(str) <= f13) {
                f12 = this.f79818d;
            } else {
                this.f79816b.setTextSize(this.f79817c);
                if (this.f79816b.measureText(str) < f13) {
                    while (f11 - f12 > 0.5f) {
                        float f14 = (f11 + f12) / 2.0f;
                        this.f79816b.setTextSize(f14);
                        if (this.f79816b.measureText(str) >= f13) {
                            f11 = f14;
                        } else {
                            f12 = f14;
                        }
                    }
                }
            }
            setTextSize(0, f12);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int measuredHeight = getMeasuredHeight();
        d(getText().toString(), size);
        setMeasuredDimension(size, measuredHeight);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        if (i11 != i13) {
            d(getText().toString(), i11);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        d(charSequence.toString(), getWidth());
    }
}
