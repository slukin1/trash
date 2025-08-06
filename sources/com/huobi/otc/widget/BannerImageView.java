package com.huobi.otc.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.otc.R$color;

@SuppressLint({"AppCompatCustomView"})
public class BannerImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public float f79663b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f79664c;

    /* renamed from: d  reason: collision with root package name */
    public float f79665d;

    /* renamed from: e  reason: collision with root package name */
    public float f79666e;

    public BannerImageView(Context context, int i11) {
        super(context);
        b(context, i11);
    }

    public final void a(Context context) {
        Paint paint = new Paint();
        this.f79664c = paint;
        paint.setAntiAlias(true);
        this.f79664c.setColor(context.getResources().getColor(R$color.balance_exchange));
        this.f79663b = (float) PixelUtils.a(0.0f);
    }

    public final void b(Context context, int i11) {
        Paint paint = new Paint();
        this.f79664c = paint;
        paint.setAntiAlias(true);
        this.f79664c.setColor(i11);
        this.f79663b = (float) PixelUtils.a(0.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() != null) {
            RectF rectF = new RectF(0.0f, 0.0f, this.f79665d, this.f79666e);
            Path path = new Path();
            Path path2 = new Path();
            path2.addRect(rectF, Path.Direction.CCW);
            float f11 = this.f79663b;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CCW);
            if (Build.VERSION.SDK_INT >= 19) {
                path.op(path2, path, Path.Op.DIFFERENCE);
            }
            canvas.drawPath(path, this.f79664c);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f79665d = (float) getMeasuredWidth();
        this.f79666e = (float) getMeasuredHeight();
    }

    public BannerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BannerImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
