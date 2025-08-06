package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class IndicatorView extends View {
    private static final int DESIGN_BOTTOM_HEIGHT = 52;
    private static final int DESIGN_INDICATOR_DISTANCE = 14;
    private static final int DESIGN_INDICATOR_RADIUS = 6;
    private int count;
    private int current;

    public IndicatorView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        if (this.count <= 1) {
            setVisibility(8);
            return;
        }
        float height = (float) getHeight();
        float f11 = (6.0f * height) / 52.0f;
        float f12 = (14.0f * height) / 52.0f;
        float f13 = f11 * 2.0f;
        int i11 = this.count;
        float width = (((float) getWidth()) - ((((float) i11) * f13) + (((float) (i11 - 1)) * f12))) / 2.0f;
        float f14 = height / 2.0f;
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (int i12 = 0; i12 < this.count; i12++) {
            if (i12 == this.current) {
                paint.setColor(-10653280);
            } else {
                paint.setColor(-5262921);
            }
            canvas.drawCircle(((f13 + f12) * ((float) i12)) + width, f14, f11, paint);
        }
    }

    public void onScreenChange(int i11, int i12) {
        if (i11 != this.current) {
            this.current = i11;
            postInvalidate();
        }
    }

    public void setScreenCount(int i11) {
        this.count = i11;
    }
}
