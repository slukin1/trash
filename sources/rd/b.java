package rd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class b extends ImageSpan {

    /* renamed from: b  reason: collision with root package name */
    public o f23345b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f23346c;

    /* renamed from: d  reason: collision with root package name */
    public int f23347d = PixelUtils.a(8.0f);

    public b(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    @SensorsDataInstrumented
    public void a(View view) {
        o oVar = this.f23345b;
        if (oVar != null) {
            oVar.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(o oVar) {
        this.f23345b = oVar;
    }

    public void c(Drawable drawable) {
        this.f23346c = drawable;
        if (drawable != null) {
            int i11 = this.f23347d;
            drawable.setBounds(0, 0, i11, i11);
        }
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.save();
        canvas.translate(f11, (float) (((((fontMetricsInt.descent + i14) + i14) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2)));
        drawable.draw(canvas);
        canvas.restore();
        if (this.f23346c != null) {
            canvas.save();
            canvas.translate((float) (drawable.getIntrinsicWidth() - this.f23347d), (float) (drawable.getBounds().bottom - (this.f23347d / 2)));
            this.f23346c.draw(canvas);
            canvas.restore();
        }
    }
}
