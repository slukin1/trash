package hy;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

public class a extends Animation {

    /* renamed from: b  reason: collision with root package name */
    public PointF f37197b;

    /* renamed from: c  reason: collision with root package name */
    public float f37198c;

    /* renamed from: d  reason: collision with root package name */
    public int f37199d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f37200e;

    /* renamed from: f  reason: collision with root package name */
    public float f37201f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f37202g = 0.4f;

    /* renamed from: h  reason: collision with root package name */
    public PointF f37203h;

    /* renamed from: i  reason: collision with root package name */
    public PointF f37204i;

    public a(int i11, PointF pointF, PointF pointF2, int i12, int i13) {
        Paint paint = new Paint();
        this.f37200e = paint;
        this.f37199d = i11;
        this.f37197b = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        float f11 = pointF.x;
        PointF pointF3 = this.f37197b;
        this.f37203h = new PointF(f11 - pointF3.x, pointF.y - pointF3.y);
        float f12 = pointF2.x;
        PointF pointF4 = this.f37197b;
        this.f37204i = new PointF(f12 - pointF4.x, pointF2.y - pointF4.y);
        e(i12);
        f(i13);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void applyTransformation(float f11, Transformation transformation) {
        float f12 = this.f37201f;
        d(f12 + ((this.f37202g - f12) * f11));
    }

    public void b(Canvas canvas) {
        PointF pointF = this.f37203h;
        float f11 = pointF.x;
        float f12 = pointF.y;
        PointF pointF2 = this.f37204i;
        canvas.drawLine(f11, f12, pointF2.x, pointF2.y, this.f37200e);
    }

    public void c(int i11) {
        this.f37198c = (float) ((-new Random().nextInt(i11)) + i11);
    }

    public void d(float f11) {
        this.f37200e.setAlpha((int) (f11 * 255.0f));
    }

    public void e(int i11) {
        this.f37200e.setColor(i11);
    }

    public void f(int i11) {
        this.f37200e.setStrokeWidth((float) i11);
    }

    public void g(float f11, float f12) {
        this.f37201f = f11;
        this.f37202g = f12;
        super.start();
    }
}
