package com.huobi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import pro.huobi.R;

public class CirclePoint extends View {
    private static final int HALF_INT = 2;
    private int color;
    private Paint paint;
    private float radius;

    public CirclePoint(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.radius = getResources().getDimension(R.dimen.dimen_1_5);
        this.color = ContextCompat.getColor(getContext(), R.color.global_divider_color);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(this.color);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.radius, this.paint);
    }

    public CirclePoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CirclePoint(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
