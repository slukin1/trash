package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class LeftCornerView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71481b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f71482c;

    public LeftCornerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        this.f71482c.reset();
        this.f71482c.moveTo(0.0f, 0.0f);
        this.f71482c.quadTo(0.0f, (float) getHeight(), (float) getHeight(), (float) getHeight());
        this.f71482c.lineTo((float) getWidth(), (float) getHeight());
        this.f71482c.lineTo((float) getWidth(), 0.0f);
        this.f71482c.close();
        canvas.drawPath(this.f71482c, this.f71481b);
        super.onDraw(canvas);
    }

    public LeftCornerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f71481b = paint;
        this.f71482c = new Path();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R$color.color_0F0066ED));
    }
}
