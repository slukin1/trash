package jc;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class a implements TypeEvaluator<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f19137a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f19138b;

    public a(PointF pointF, PointF pointF2) {
        this.f19137a = pointF;
        this.f19138b = pointF2;
    }

    /* renamed from: a */
    public PointF evaluate(float f11, PointF pointF, PointF pointF2) {
        float f12 = f11;
        PointF pointF3 = pointF;
        PointF pointF4 = pointF2;
        PointF pointF5 = new PointF();
        float f13 = 1.0f - f12;
        double d11 = (double) f13;
        float f14 = f13 * 3.0f;
        double d12 = (double) f12;
        pointF5.x = (((float) Math.pow(d11, 3.0d)) * pointF3.x) + (((float) Math.pow(d11, 2.0d)) * 3.0f * f12 * this.f19137a.x) + (((float) Math.pow(d12, 2.0d)) * f14 * this.f19138b.x) + (((float) Math.pow(d12, 3.0d)) * pointF4.x);
        pointF5.y = (((float) Math.pow(d11, 3.0d)) * pointF3.y) + (((float) Math.pow(d11, 2.0d)) * 3.0f * f12 * this.f19137a.y) + (f14 * f12 * f12 * this.f19138b.y) + (((float) Math.pow(d12, 3.0d)) * pointF4.y);
        return pointF5;
    }
}
