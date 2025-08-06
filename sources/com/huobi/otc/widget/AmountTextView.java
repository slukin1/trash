package com.huobi.otc.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.module.otc.R$dimen;

public class AmountTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public int f79636b;

    /* renamed from: c  reason: collision with root package name */
    public int f79637c;

    /* renamed from: d  reason: collision with root package name */
    public float f79638d;

    /* renamed from: e  reason: collision with root package name */
    public float f79639e;

    /* renamed from: f  reason: collision with root package name */
    public float f79640f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f79641g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    public final Paint f79642h = new Paint(1);

    /* renamed from: i  reason: collision with root package name */
    public String f79643i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f79644j = "";

    public AmountTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public final void d() {
        float textSize = this.f79642h.getTextSize();
        if (this.f79641g.getTextSize() > textSize) {
            this.f79641g.setTextSize(textSize);
        }
        this.f79638d = this.f79641g.measureText(this.f79643i);
        float measureText = this.f79642h.measureText(this.f79644j);
        this.f79639e = measureText;
        if (this.f79638d + measureText > ((float) this.f79636b)) {
            this.f79642h.setTextSize(textSize - 1.0f);
            d();
            return;
        }
        Paint.FontMetrics fontMetrics = this.f79642h.getFontMetrics();
        float f11 = fontMetrics.descent;
        this.f79640f = ((f11 - fontMetrics.ascent) / 2.0f) - f11;
        setTextSize(0, textSize);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) (fontMetrics.descent - fontMetrics.ascent);
            setLayoutParams(layoutParams);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        d();
        float f11 = ((((float) this.f79636b) - this.f79638d) - this.f79639e) / 2.0f;
        float f12 = (((float) (this.f79637c >> 1)) + this.f79640f) - 1.0f;
        canvas.drawText(this.f79643i, f11, f12, this.f79641g);
        canvas.drawText(this.f79644j, f11 + this.f79638d, f12, this.f79642h);
    }

    public final void e(Context context) {
        setTextSize(1, 18.0f);
        float textSize = getPaint().getTextSize();
        this.f79642h.setTextSize(2.0f * textSize);
        this.f79641g.setTextSize(textSize);
        this.f79642h.setColor(-1);
        this.f79641g.setColor(-1);
        this.f79642h.setTypeface(Typeface.DEFAULT_BOLD);
        this.f79641g.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.f79643i = "";
        } else {
            this.f79643i = str;
        }
        if (TextUtils.isEmpty(str2)) {
            this.f79644j = "";
        } else {
            this.f79644j = str2;
        }
        setTextSize(0, getResources().getDimension(R$dimen.dimen_18));
        float textSize = getPaint().getTextSize();
        this.f79642h.setTextSize(2.0f * textSize);
        this.f79641g.setTextSize(textSize);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f79636b = i11;
        this.f79637c = i12;
    }

    public AmountTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        e(context);
    }
}
