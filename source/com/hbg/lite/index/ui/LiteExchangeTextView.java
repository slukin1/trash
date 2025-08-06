package com.hbg.lite.index.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lite.R$color;
import com.hbg.lite.R$dimen;

public class LiteExchangeTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f77112b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f77113c;

    /* renamed from: d  reason: collision with root package name */
    public int f77114d;

    /* renamed from: e  reason: collision with root package name */
    public int f77115e;

    public LiteExchangeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine((float) getWidth(), (float) (getHeight() - this.f77115e), (float) (getHeight() / 2), (float) (getHeight() - this.f77115e), this.f77112b);
        RectF rectF = this.f77113c;
        int i11 = this.f77115e;
        rectF.set((float) i11, (float) i11, (float) getHeight(), (float) (getHeight() - this.f77115e));
        canvas.drawArc(this.f77113c, 90.0f, 180.0f, false, this.f77112b);
        canvas.drawLine((float) (getHeight() / 2), (float) this.f77115e, (float) getWidth(), (float) this.f77115e, this.f77112b);
    }

    public LiteExchangeTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f77112b = paint;
        this.f77113c = new RectF();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R$color.baseColorPrimarySeparator));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.dimen_1);
        this.f77114d = dimensionPixelOffset;
        this.f77115e = dimensionPixelOffset;
        paint.setStrokeWidth((float) dimensionPixelOffset);
        paint.setStyle(Paint.Style.STROKE);
    }
}
