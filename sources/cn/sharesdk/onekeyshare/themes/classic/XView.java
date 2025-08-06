package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class XView extends View {
    private float ratio;

    public XView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-6250336);
        float width = (float) (getWidth() / 2);
        canvas.drawRect(width, 0.0f, (float) getWidth(), (float) (getHeight() / 2), paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(this.ratio * 3.0f);
        paint2.setColor(-1);
        float f11 = this.ratio * 8.0f;
        float f12 = width + f11;
        float f13 = width - f11;
        Canvas canvas2 = canvas;
        float f14 = f12;
        Paint paint3 = paint2;
        canvas2.drawLine(f14, f11, ((float) getWidth()) - f11, f13, paint3);
        canvas2.drawLine(f14, f13, ((float) getWidth()) - f11, f11, paint3);
    }

    public void setRatio(float f11) {
        this.ratio = f11;
    }
}
