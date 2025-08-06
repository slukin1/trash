package com.huobi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.hbg.lib.common.utils.PixelUtils;
import pro.huobi.R;

public class BannerImageView extends ImageView {
    private float height;
    private Paint paint;
    private float radius;
    private float width;

    public BannerImageView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setColor(context.getResources().getColor(R.color.baseColorDeepestBackground));
        this.radius = (float) PixelUtils.a(0.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() != null) {
            RectF rectF = new RectF(0.0f, 0.0f, this.width, this.height);
            Path path = new Path();
            Path path2 = new Path();
            path2.addRect(rectF, Path.Direction.CCW);
            float f11 = this.radius;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CCW);
            if (Build.VERSION.SDK_INT >= 19) {
                path.op(path2, path, Path.Op.DIFFERENCE);
            }
            canvas.drawPath(path, this.paint);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.width = (float) getMeasuredWidth();
        this.height = (float) getMeasuredHeight();
    }

    public void setRadius(float f11) {
        this.radius = (float) PixelUtils.a(f11);
    }

    public BannerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public BannerImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }

    public BannerImageView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(context);
    }
}
