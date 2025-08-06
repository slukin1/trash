package com.huobi.edgeengine.template.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class EngineImageView extends AppCompatImageView {

    /* renamed from: b  reason: collision with root package name */
    public final Path f44351b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f44352c;

    /* renamed from: d  reason: collision with root package name */
    public float[] f44353d;

    public EngineImageView(Context context) {
        super(context);
        this.f44351b = new Path();
        this.f44352c = new RectF();
    }

    public void onDraw(Canvas canvas) {
        if (this.f44353d != null) {
            this.f44352c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f44351b.addRoundRect(this.f44352c, this.f44353d, Path.Direction.CCW);
            try {
                canvas.clipPath(this.f44351b);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float[] fArr) {
        this.f44353d = fArr;
    }

    public EngineImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EngineImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44351b = new Path();
        this.f44352c = new RectF();
    }
}
