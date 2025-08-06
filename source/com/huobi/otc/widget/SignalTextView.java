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

public class SignalTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public int f80154b;

    /* renamed from: c  reason: collision with root package name */
    public int f80155c;

    /* renamed from: d  reason: collision with root package name */
    public float f80156d;

    /* renamed from: e  reason: collision with root package name */
    public float f80157e;

    /* renamed from: f  reason: collision with root package name */
    public float f80158f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f80159g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    public final Paint f80160h = new Paint(1);

    /* renamed from: i  reason: collision with root package name */
    public String f80161i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f80162j = "";

    public SignalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public final void d() {
        float textSize = this.f80159g.getTextSize();
        if (this.f80160h.getTextSize() > textSize) {
            this.f80160h.setTextSize(textSize);
        }
        this.f80156d = this.f80159g.measureText(this.f80161i);
        float measureText = this.f80160h.measureText(this.f80162j);
        this.f80157e = measureText;
        if (measureText + this.f80156d > ((float) this.f80154b)) {
            this.f80159g.setTextSize(textSize - 1.0f);
            d();
            return;
        }
        Paint.FontMetrics fontMetrics = this.f80159g.getFontMetrics();
        float f11 = fontMetrics.descent;
        this.f80158f = ((f11 - fontMetrics.ascent) / 2.0f) - f11;
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
        float f11 = ((((float) this.f80154b) - this.f80157e) - this.f80156d) / 2.0f;
        float f12 = (((float) (this.f80155c >> 1)) + this.f80158f) - 1.0f;
        canvas.drawText(this.f80161i, f11, f12, this.f80159g);
        canvas.drawText(this.f80162j, f11 + this.f80156d, f12, this.f80160h);
    }

    public final void e(Context context) {
        setTextSize(1, 18.0f);
        float textSize = getPaint().getTextSize();
        this.f80159g.setTextSize(2.0f * textSize);
        this.f80160h.setTextSize(textSize);
        this.f80159g.setColor(-1);
        this.f80160h.setColor(-1);
        this.f80159g.setTypeface(Typeface.DEFAULT_BOLD);
        this.f80160h.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.f80161i = "";
        } else {
            this.f80161i = str;
        }
        if (TextUtils.isEmpty(str2)) {
            this.f80162j = "";
        } else {
            this.f80162j = str2;
        }
        setTextSize(0, getResources().getDimension(R$dimen.dimen_18));
        float textSize = getPaint().getTextSize();
        this.f80159g.setTextSize(2.0f * textSize);
        this.f80160h.setTextSize(textSize);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f80154b = i11;
        this.f80155c = i12;
    }

    public SignalTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        e(context);
    }
}
