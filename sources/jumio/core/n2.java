package jumio.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

public final class n2 extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f56283a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f56284b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Paint f56285c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f56286d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f56287e;

    /* renamed from: f  reason: collision with root package name */
    public float f56288f;

    public n2(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f56285c = paint;
        paint.setAntiAlias(true);
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f56286d);
        RectF rectF = this.f56287e;
        float f11 = this.f56288f;
        canvas.drawRoundRect(rectF, f11, f11, this.f56285c);
        canvas.restore();
    }

    public final void onMeasure(int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        boolean z11 = false;
        boolean z12 = mode == Integer.MIN_VALUE || mode == 0;
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            z11 = true;
        }
        int i14 = this.f56283a;
        if (!(i14 == 0 || (i13 = this.f56284b) == 0)) {
            float f11 = ((float) i14) / ((float) i13);
            if (size != 0 && z11 && f11 != 1.0f) {
                size2 = (int) (((float) size) / f11);
            } else if (!(!z12 || size2 == 0 || f11 == 1.0f)) {
                size = (int) (((float) size2) * f11);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public final void onSizeChanged(int i11, int i12, int i13, int i14) {
        this.f56286d = new Matrix();
        this.f56287e = new RectF(0.0f, 0.0f, (float) this.f56283a, (float) this.f56284b);
        this.f56286d.setRectToRect(this.f56287e, new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), Matrix.ScaleToFit.CENTER);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f56283a = bitmap.getWidth();
        this.f56284b = bitmap.getHeight();
        this.f56288f = 0.0f;
        this.f56286d = new Matrix();
        this.f56287e = new RectF(0.0f, 0.0f, (float) this.f56283a, (float) this.f56284b);
        this.f56286d.setRectToRect(this.f56287e, new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), Matrix.ScaleToFit.CENTER);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f56285c.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        requestLayout();
        invalidate();
    }
}
